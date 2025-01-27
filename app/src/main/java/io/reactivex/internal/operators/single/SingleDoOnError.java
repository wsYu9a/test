package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes4.dex */
public final class SingleDoOnError<T> extends Single<T> {
    final Consumer<? super Throwable> onError;
    final SingleSource<T> source;

    public final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;

        public DoOnError(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th2) {
            try {
                SingleDoOnError.this.onError.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.source = singleSource;
        this.onError = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnError(singleObserver));
    }
}
