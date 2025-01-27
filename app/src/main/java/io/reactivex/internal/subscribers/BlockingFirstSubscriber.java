package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th2) {
        if (this.value == null) {
            this.error = th2;
        } else {
            RxJavaPlugins.onError(th2);
        }
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            this.upstream.cancel();
            countDown();
        }
    }
}
