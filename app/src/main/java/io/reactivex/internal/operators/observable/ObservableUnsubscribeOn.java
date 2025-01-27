package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;
        final Observer<? super T> downstream;
        final Scheduler scheduler;
        Disposable upstream;

        public final class DisposeTask implements Runnable {
            public DisposeTask() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.upstream.dispose();
            }
        }

        public UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.downstream = observer;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.scheduleDirect(new DisposeTask());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t10) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new UnsubscribeObserver(observer, this.scheduler));
    }
}
