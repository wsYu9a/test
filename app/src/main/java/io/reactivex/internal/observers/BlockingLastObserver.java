package io.reactivex.internal.observers;

/* loaded from: classes4.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th2) {
        this.value = null;
        this.error = th2;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t10) {
        this.value = t10;
    }
}
