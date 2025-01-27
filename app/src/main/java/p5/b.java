package p5;

import com.google.common.util.concurrent.TrustedListenableFutureTask;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

@a5.a
@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public abstract class b extends AbstractExecutorService implements g0 {
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, @l0 T t10) {
        return TrustedListenableFutureTask.v(runnable, t10);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.w(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p5.g0
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, @l0 Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p5.g0
    public c0<?> submit(Runnable runnable) {
        return (c0) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p5.g0
    public <T> c0<T> submit(Runnable runnable, @l0 T t10) {
        return (c0) super.submit(runnable, (Runnable) t10);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p5.g0
    public <T> c0<T> submit(Callable<T> callable) {
        return (c0) super.submit((Callable) callable);
    }
}
