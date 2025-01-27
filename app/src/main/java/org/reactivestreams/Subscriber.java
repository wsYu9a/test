package org.reactivestreams;

/* loaded from: classes4.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t10);

    void onSubscribe(Subscription subscription);
}
