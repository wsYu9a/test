package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes4.dex */
public final class CompletableDoOnEvent extends Completable {
    final Consumer<? super Throwable> onEvent;
    final CompletableSource source;

    public final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        public DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                CompletableDoOnEvent.this.onEvent.accept(null);
                this.observer.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.observer.onError(th2);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th2) {
            try {
                CompletableDoOnEvent.this.onEvent.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.observer.onError(th2);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.source = completableSource;
        this.onEvent = consumer;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DoOnEvent(completableObserver));
    }
}
