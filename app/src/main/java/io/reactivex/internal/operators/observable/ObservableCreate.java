package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> source;

    public static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        final Observer<? super T> observer;

        public CreateEmitter(Observer<? super T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th2) {
            if (tryOnError(th2)) {
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t10) {
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t10);
            }
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th2);
                dispose();
                return true;
            } catch (Throwable th3) {
                dispose();
                throw th3;
            }
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final ObservableEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final SpscLinkedArrayQueue<T> queue = new SpscLinkedArrayQueue<>(16);

        public SerializedEmitter(ObservableEmitter<T> observableEmitter) {
            this.emitter = observableEmitter;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            ObservableEmitter<T> observableEmitter = this.emitter;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i10 = 1;
            while (!observableEmitter.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observableEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z10 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z11 = poll == null;
                if (z10 && z11) {
                    observableEmitter.onComplete();
                    return;
                } else if (z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    observableEmitter.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th2) {
            if (tryOnError(th2)) {
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t10) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
                synchronized (spscLinkedArrayQueue) {
                    spscLinkedArrayQueue.offer(t10);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return this;
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable cancellable) {
            this.emitter.setCancellable(cancellable);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
            this.emitter.setDisposable(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable th2) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th2 == null) {
                    th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th2)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.source = observableOnSubscribe;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.source.subscribe(createEmitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            createEmitter.onError(th2);
        }
    }
}
