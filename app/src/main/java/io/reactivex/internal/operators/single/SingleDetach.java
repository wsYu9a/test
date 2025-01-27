package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> source;

    public static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> downstream;
        Disposable upstream;

        public DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.downstream = null;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.downstream;
            if (singleObserver != null) {
                this.downstream = null;
                singleObserver.onError(th2);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t10) {
            this.upstream = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.downstream;
            if (singleObserver != null) {
                this.downstream = null;
                singleObserver.onSuccess(t10);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DetachSingleObserver(singleObserver));
    }
}
