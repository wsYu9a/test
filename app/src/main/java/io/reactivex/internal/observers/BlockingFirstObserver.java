package io.reactivex.internal.observers;

/* loaded from: classes4.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th2) {
        if (this.value == null) {
            this.error = th2;
        }
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            this.upstream.dispose();
            countDown();
        }
    }
}
