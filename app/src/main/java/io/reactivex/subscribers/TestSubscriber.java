package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k0.e;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;
    private QueueSubscription<T> qs;
    private final AtomicReference<Subscription> upstream;

    public enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public static String fusionModeToString(int i10) {
        if (i10 == 0) {
            return "NONE";
        }
        if (i10 == 1) {
            return "SYNC";
        }
        if (i10 == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i10 + ")";
    }

    public final TestSubscriber<T> assertFuseable() {
        if (this.qs != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    public final TestSubscriber<T> assertFusionMode(int i10) {
        int i11 = this.establishedFusionMode;
        if (i11 == i10) {
            return this;
        }
        if (this.qs == null) {
            throw fail("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + fusionModeToString(i10) + ", actual: " + fusionModeToString(i11));
    }

    public final TestSubscriber<T> assertNotFuseable() {
        if (this.qs == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    public final boolean hasSubscription() {
        return this.upstream.get() != null;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.downstream.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th2) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.errors.add(th2);
            if (th2 == null) {
                this.errors.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.downstream.onError(th2);
            this.done.countDown();
        } catch (Throwable th3) {
            this.done.countDown();
            throw th3;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t10) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode != 2) {
            this.values.add(t10);
            if (t10 == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.downstream.onNext(t10);
            return;
        }
        while (true) {
            try {
                T poll = this.qs.poll();
                if (poll == null) {
                    return;
                } else {
                    this.values.add(poll);
                }
            } catch (Throwable th2) {
                this.errors.add(th2);
                this.qs.cancel();
                return;
            }
        }
    }

    public void onStart() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.lastThread = Thread.currentThread();
        if (subscription == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!e.a(this.upstream, null, subscription)) {
            subscription.cancel();
            if (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                return;
            }
            return;
        }
        int i10 = this.initialFusionMode;
        if (i10 != 0 && (subscription instanceof QueueSubscription)) {
            QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
            this.qs = queueSubscription;
            int requestFusion = queueSubscription.requestFusion(i10);
            this.establishedFusionMode = requestFusion;
            if (requestFusion == 1) {
                this.checkSubscriptionOnce = true;
                this.lastThread = Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.qs.poll();
                        if (poll == null) {
                            this.completions++;
                            return;
                        }
                        this.values.add(poll);
                    } catch (Throwable th2) {
                        this.errors.add(th2);
                        return;
                    }
                }
            }
        }
        this.downstream.onSubscribe(subscription);
        long andSet = this.missedRequested.getAndSet(0L);
        if (andSet != 0) {
            subscription.request(andSet);
        }
        onStart();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, j10);
    }

    public final TestSubscriber<T> requestMore(long j10) {
        request(j10);
        return this;
    }

    public final TestSubscriber<T> setInitialFusionMode(int i10) {
        this.initialFusionMode = i10;
        return this;
    }

    public TestSubscriber(long j10) {
        this(EmptySubscriber.INSTANCE, j10);
    }

    public static <T> TestSubscriber<T> create(long j10) {
        return new TestSubscriber<>(j10);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertNotSubscribed() {
        if (this.upstream.get() != null) {
            throw fail("Subscribed!");
        }
        if (this.errors.isEmpty()) {
            return this;
        }
        throw fail("Not subscribed but errors found");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertSubscribed() {
        if (this.upstream.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    public TestSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j10) {
        if (j10 >= 0) {
            this.downstream = subscriber;
            this.upstream = new AtomicReference<>();
            this.missedRequested = new AtomicLong(j10);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
