package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class CompletableDisposeOn extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    public static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {
        volatile boolean disposed;
        final CompletableObserver downstream;
        final Scheduler scheduler;
        Disposable upstream;

        public DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.downstream = completableObserver;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.scheduler.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.disposed) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th2) {
            if (this.disposed) {
                RxJavaPlugins.onError(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.source = completableSource;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DisposeOnObserver(completableObserver, this.scheduler));
    }
}
