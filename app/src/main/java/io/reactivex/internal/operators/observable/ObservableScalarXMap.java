package io.reactivex.internal.operators.observable;

import defpackage.a;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        public ScalarDisposable(Observer<? super T> observer, T t10) {
            this.observer = observer;
            this.value = t10;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final T value;

        public ScalarXMapObservable(T t10, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.value = t10;
            this.mapper = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null ObservableSource");
                if (!(observableSource instanceof Callable)) {
                    observableSource.subscribe(observer);
                    return;
                }
                try {
                    Object call = ((Callable) observableSource).call();
                    if (call == null) {
                        EmptyDisposable.complete(observer);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                    observer.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptyDisposable.error(th2, observer);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, observer);
            }
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> scalarXMap(T t10, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapObservable(t10, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) observableSource).call();
            if (aVar == null) {
                EmptyDisposable.complete(observer);
                return true;
            }
            try {
                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(function.apply(aVar), "The mapper returned a null ObservableSource");
                if (observableSource2 instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource2).call();
                        if (call == null) {
                            EmptyDisposable.complete(observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(th2, observer);
                        return true;
                    }
                } else {
                    observableSource2.subscribe(observer);
                }
                return true;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptyDisposable.error(th3, observer);
                return true;
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptyDisposable.error(th4, observer);
            return true;
        }
    }
}
