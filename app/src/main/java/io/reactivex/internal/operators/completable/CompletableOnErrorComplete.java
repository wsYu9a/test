package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: classes4.dex */
public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        public OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th2) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th2)) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.source = completableSource;
        this.predicate = predicate;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }
}
