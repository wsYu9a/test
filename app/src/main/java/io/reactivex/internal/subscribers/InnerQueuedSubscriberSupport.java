package io.reactivex.internal.subscribers;

/* loaded from: classes4.dex */
public interface InnerQueuedSubscriberSupport<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th2);

    void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t10);
}
