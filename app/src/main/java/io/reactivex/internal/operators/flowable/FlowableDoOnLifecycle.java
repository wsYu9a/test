package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action onCancel;
    private final LongConsumer onRequest;
    private final Consumer<? super Subscription> onSubscribe;

    public static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        final Action onCancel;
        final LongConsumer onRequest;
        final Consumer<? super Subscription> onSubscribe;
        Subscription upstream;

        public SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.downstream = subscriber;
            this.onSubscribe = consumer;
            this.onCancel = action;
            this.onRequest = longConsumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.upstream;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.upstream = subscriptionHelper;
                try {
                    this.onCancel.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
                subscription.cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.upstream != SubscriptionHelper.CANCELLED) {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            if (this.upstream != SubscriptionHelper.CANCELLED) {
                this.downstream.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            try {
                this.onSubscribe.accept(subscription);
                if (SubscriptionHelper.validate(this.upstream, subscription)) {
                    this.upstream = subscription;
                    this.downstream.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscription.cancel();
                this.upstream = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th2, this.downstream);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            try {
                this.onRequest.accept(j10);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.upstream.request(j10);
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.onSubscribe = consumer;
        this.onRequest = longConsumer;
        this.onCancel = action;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new SubscriptionLambdaSubscriber(subscriber, this.onSubscribe, this.onRequest, this.onCancel));
    }
}
