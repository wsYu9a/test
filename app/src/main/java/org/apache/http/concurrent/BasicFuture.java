package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.ex == null) {
            return this.result;
        }
        throw new ExecutionException(this.ex);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.completed) {
            return false;
        }
        this.completed = true;
        this.cancelled = true;
        FutureCallback<T> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.cancelled();
        }
        notifyAll();
        return true;
    }

    public synchronized boolean completed(T t) {
        if (this.completed) {
            return false;
        }
        this.completed = true;
        this.result = t;
        FutureCallback<T> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.completed(t);
        }
        notifyAll();
        return true;
    }

    public synchronized boolean failed(Exception exc) {
        if (this.completed) {
            return false;
        }
        this.completed = true;
        this.ex = exc;
        FutureCallback<T> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.failed(exc);
        }
        notifyAll();
        return true;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        long millis = timeUnit.toMillis(j2);
        long currentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        }
        if (millis > 0) {
            long j3 = millis;
            do {
                wait(j3);
                if (this.completed) {
                    return getResult();
                }
                j3 = millis - (System.currentTimeMillis() - currentTimeMillis);
            } while (j3 > 0);
            throw new TimeoutException();
        }
        throw new TimeoutException();
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
