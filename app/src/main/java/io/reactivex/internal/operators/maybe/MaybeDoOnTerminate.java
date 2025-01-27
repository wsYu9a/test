package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* loaded from: classes4.dex */
public final class MaybeDoOnTerminate<T> extends Maybe<T> {
    final Action onTerminate;
    final MaybeSource<T> source;

    public final class DoOnTerminate implements MaybeObserver<T> {
        final MaybeObserver<? super T> downstream;

        public DoOnTerminate(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                MaybeDoOnTerminate.this.onTerminate.run();
                this.downstream.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th2) {
            try {
                MaybeDoOnTerminate.this.onTerminate.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t10) {
            try {
                MaybeDoOnTerminate.this.onTerminate.run();
                this.downstream.onSuccess(t10);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.source = maybeSource;
        this.onTerminate = action;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new DoOnTerminate(maybeObserver));
    }
}
