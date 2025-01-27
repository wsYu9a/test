package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final ObservableSource<B> other;

    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        boolean done;
        final WindowBoundaryMainObserver<T, B> parent;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.parent = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaPlugins.onError(th2);
            } else {
                this.done = true;
                this.parent.innerError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b10) {
            if (this.done) {
                return;
            }
            this.parent.innerNext();
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        UnicastSubject<T> window;
        final WindowBoundaryInnerObserver<T, B> boundaryObserver = new WindowBoundaryInnerObserver<>(this);
        final AtomicReference<Disposable> upstream = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i10) {
            this.downstream = observer;
            this.capacityHint = i10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i10 = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z10 = this.done;
                if (z10 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                boolean z11 = poll == null;
                if (z10 && z11) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                }
                if (z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else if (poll != NEXT_WINDOW) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> create = UnicastSubject.create(this.capacityHint, this);
                        this.window = create;
                        this.windows.getAndIncrement();
                        observer.onNext(create);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }

        public void innerError(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            if (!this.errors.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else {
                this.done = true;
                drain();
            }
        }

        public void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th2) {
            this.boundaryObserver.dispose();
            if (!this.errors.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t10) {
            this.queue.offer(t10);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.upstream, disposable)) {
                innerNext();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i10) {
        super(observableSource);
        this.other = observableSource2;
        this.capacityHint = i10;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.capacityHint);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.other.subscribe(windowBoundaryMainObserver.boundaryObserver);
        this.source.subscribe(windowBoundaryMainObserver);
    }
}
