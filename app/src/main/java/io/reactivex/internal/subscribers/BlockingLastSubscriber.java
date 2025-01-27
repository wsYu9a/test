package io.reactivex.internal.subscribers;

/* loaded from: classes4.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th2) {
        this.value = null;
        this.error = th2;
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t10) {
        this.value = t10;
    }
}
