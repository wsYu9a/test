package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.generator, this.disposeState, this.stateSupplier.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }

    public static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Observer<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        public GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s10) {
            this.downstream = observer;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = s10;
        }

        private void dispose(S s10) {
            try {
                this.disposeState.accept(s10);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th2) {
            if (this.terminate) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t10) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t10);
            }
        }

        public void run() {
            S s10 = this.state;
            if (this.cancelled) {
                this.state = null;
                dispose(s10);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.generator;
            while (!this.cancelled) {
                this.hasNext = false;
                try {
                    s10 = biFunction.apply(s10, this);
                    if (this.terminate) {
                        this.cancelled = true;
                        this.state = null;
                        dispose(s10);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.state = null;
                    this.cancelled = true;
                    onError(th2);
                    dispose(s10);
                    return;
                }
            }
            this.state = null;
            dispose(s10);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }
    }
}
