package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final SingleSource<T> source;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new SingleFlatMapPublisherObserver(subscriber, this.mapper));
    }

    public static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;
        Disposable disposable;
        final Subscriber<? super T> downstream;
        final Function<? super S, ? extends Publisher<? extends T>> mapper;
        final AtomicReference<Subscription> parent = new AtomicReference<>();

        public SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.downstream = subscriber;
            this.mapper = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.disposable = disposable;
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(S s10) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(s10), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.parent, this, j10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, subscription);
        }
    }
}
