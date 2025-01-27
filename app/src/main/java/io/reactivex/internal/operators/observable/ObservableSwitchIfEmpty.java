package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes4.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> other;

    public static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final Observer<? super T> downstream;
        final ObservableSource<? extends T> other;
        boolean empty = true;
        final SequentialDisposable arbiter = new SequentialDisposable();

        public SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.other = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.empty) {
                this.downstream.onComplete();
            } else {
                this.empty = false;
                this.other.subscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t10) {
            if (this.empty) {
                this.empty = false;
            }
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.arbiter.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.other);
        observer.onSubscribe(switchIfEmptyObserver.arbiter);
        this.source.subscribe(switchIfEmptyObserver);
    }
}
