package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final ObservableSource<?> other;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        public SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z10 = this.done;
                    emit();
                    if (z10) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            emit();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        final ObservableSource<?> sampler;
        Disposable upstream;

        public SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.downstream = observer;
            this.sampler = observableSource;
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        public abstract void completion();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        public void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public void error(Throwable th2) {
            this.upstream.dispose();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completion();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new SamplerObserver(this));
                }
            }
        }

        public abstract void run();

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> parent;

        public SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.parent = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            this.parent.error(th2);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.parent.run();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.parent.setOther(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z10) {
        super(observableSource);
        this.other = observableSource2;
        this.emitLast = z10;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.emitLast) {
            this.source.subscribe(new SampleMainEmitLast(serializedObserver, this.other));
        } else {
            this.source.subscribe(new SampleMainNoLast(serializedObserver, this.other));
        }
    }
}
