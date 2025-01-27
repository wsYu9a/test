package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter arbiter;
        final Subscriber<? super T> downstream;

        public FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.downstream = subscriber;
            this.arbiter = subscriptionArbiter;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.arbiter.setSubscription(subscription);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final Subscriber<? super T> downstream;
        Publisher<? extends T> fallback;
        final AtomicLong index;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Subscription> upstream;
        final Scheduler.Worker worker;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j10, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            super(true);
            this.downstream = subscriber;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = worker;
            this.fallback = publisher;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = j10 + 1;
                if (this.index.compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.downstream.onNext(t10);
                    startTimeout(j11);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                setSubscription(subscription);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                long j11 = this.consumed;
                if (j11 != 0) {
                    produced(j11);
                }
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                publisher.subscribe(new FallbackSubscriber(this.downstream, this));
                this.worker.dispose();
            }
        }

        public void startTimeout(long j10) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j10, this), this.timeout, this.unit));
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> downstream;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, long j10, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.downstream = subscriber;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t10);
                    startTimeout(j11);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
        }

        public void startTimeout(long j10) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j10, this), this.timeout, this.unit));
        }
    }

    public interface TimeoutSupport {
        void onTimeout(long j10);
    }

    public static final class TimeoutTask implements Runnable {
        final long idx;
        final TimeoutSupport parent;

        public TimeoutTask(long j10, TimeoutSupport timeoutSupport) {
            this.idx = j10;
            this.parent = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.onTimeout(this.idx);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.timeout = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startTimeout(0L);
            this.source.subscribe((FlowableSubscriber) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startTimeout(0L);
        this.source.subscribe((FlowableSubscriber) timeoutFallbackSubscriber);
    }
}
