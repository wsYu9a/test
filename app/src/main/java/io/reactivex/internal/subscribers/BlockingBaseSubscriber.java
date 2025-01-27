package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    volatile boolean cancelled;
    Throwable error;
    Subscription upstream;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                Subscription subscription = this.upstream;
                this.upstream = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.error;
        if (th2 == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (this.cancelled) {
                return;
            }
            subscription.request(Long.MAX_VALUE);
            if (this.cancelled) {
                this.upstream = SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }
}
