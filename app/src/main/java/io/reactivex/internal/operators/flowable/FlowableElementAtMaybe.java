package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long index;
    final Flowable<T> source;

    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        long count;
        boolean done;
        final MaybeObserver<? super T> downstream;
        final long index;
        Subscription upstream;

        public ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j10) {
            this.downstream = maybeObserver;
            this.index = j10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.count;
            if (j10 != this.index) {
                this.count = j10 + 1;
                return;
            }
            this.done = true;
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onSuccess(t10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtMaybe(Flowable<T> flowable, long j10) {
        this.source = flowable;
        this.index = j10;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.source, this.index, null, false));
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((FlowableSubscriber) new ElementAtSubscriber(maybeObserver, this.index));
    }
}
