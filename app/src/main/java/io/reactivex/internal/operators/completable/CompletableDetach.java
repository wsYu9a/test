package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class CompletableDetach extends Completable {
    final CompletableSource source;

    public static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver downstream;
        Disposable upstream;

        public DetachCompletableObserver(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.downstream;
            if (completableObserver != null) {
                this.downstream = null;
                completableObserver.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.downstream;
            if (completableObserver != null) {
                this.downstream = null;
                completableObserver.onError(th2);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
