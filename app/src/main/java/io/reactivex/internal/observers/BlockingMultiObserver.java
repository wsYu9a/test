package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    public boolean blockingAwait(long j10, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j10, timeUnit)) {
                    dispose();
                    return false;
                }
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.error;
        if (th2 == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.error;
        if (th2 == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                dispose();
                return e10;
            }
        }
        return this.error;
    }

    public void dispose() {
        this.cancelled = true;
        Disposable disposable = this.upstream;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th2) {
        this.error = th2;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t10) {
        this.value = t10;
        countDown();
    }

    public Throwable blockingGetError(long j10, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j10, timeUnit)) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j10, timeUnit)));
                }
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        return this.error;
    }

    public T blockingGet(T t10) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.error;
        if (th2 == null) {
            T t11 = this.value;
            return t11 != null ? t11 : t10;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }
}
