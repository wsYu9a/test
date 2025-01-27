package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;

        /* renamed from: w */
        final Scheduler.Worker f27113w;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.f27113w.dispose();
                }
            }
        }

        public final class OnError implements Runnable {
            private final Throwable throwable;

            public OnError(Throwable th2) {
                this.throwable = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.f27113w.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f27114t;

            public OnNext(T t10) {
                this.f27114t = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.downstream.onNext(this.f27114t);
            }
        }

        public DelayObserver(Observer<? super T> observer, long j10, TimeUnit timeUnit, Scheduler.Worker worker, boolean z10) {
            this.downstream = observer;
            this.delay = j10;
            this.unit = timeUnit;
            this.f27113w = worker;
            this.delayError = z10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.f27113w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f27113w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f27113w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            this.f27113w.schedule(new OnError(th2), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t10) {
            this.f27113w.schedule(new OnNext(t10), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j10, TimeUnit timeUnit, Scheduler scheduler, boolean z10) {
        super(observableSource);
        this.delay = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z10;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(this.delayError ? observer : new SerializedObserver(observer), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
