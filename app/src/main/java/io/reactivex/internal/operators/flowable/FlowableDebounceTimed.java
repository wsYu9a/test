package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedSubscriber<T> parent;
        final T value;

        public DebounceEmitter(T t10, long j10, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t10;
            this.idx = j10;
            this.parent = debounceTimedSubscriber;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void emit() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        final long timeout;
        Disposable timer;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker worker;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j10, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.downstream = subscriber;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        public void emit(long j10, T t10, DebounceEmitter<T> debounceEmitter) {
            if (j10 == this.index) {
                if (get() == 0) {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                } else {
                    this.downstream.onNext(t10);
                    BackpressureHelper.produced(this, 1L);
                    debounceEmitter.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.emit();
            }
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.done = true;
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.index + 1;
            this.index = j10;
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t10, j10, this);
            this.timer = debounceEmitter;
            debounceEmitter.setResource(this.worker.schedule(debounceEmitter, this.timeout, this.unit));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this, j10);
            }
        }
    }

    public FlowableDebounceTimed(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.timeout = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
