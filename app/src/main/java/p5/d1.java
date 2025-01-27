package p5;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public abstract class d1 implements ExecutorService {

    /* renamed from: b */
    public final ExecutorService f29792b;

    public d1(ExecutorService executorService) {
        this.f29792b = (ExecutorService) b5.u.E(executorService);
    }

    public static /* synthetic */ void b(Callable callable) {
        try {
            callable.call();
        } catch (Exception e10) {
            b5.a0.w(e10);
            throw new RuntimeException(e10);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f29792b.awaitTermination(j10, timeUnit);
    }

    public Runnable c(Runnable runnable) {
        return new Runnable() { // from class: p5.c1

            /* renamed from: b */
            public final /* synthetic */ Callable f29788b;

            public /* synthetic */ c1(Callable callable) {
                d10 = callable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d1.b(d10);
            }
        };
    }

    public abstract <T> Callable<T> d(Callable<T> callable);

    public final <T> ImmutableList<Callable<T>> e(Collection<? extends Callable<T>> collection) {
        ImmutableList.a builder = ImmutableList.builder();
        Iterator<? extends Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            builder.a(d(it.next()));
        }
        return builder.e();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f29792b.execute(c(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f29792b.invokeAll(e(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f29792b.invokeAny(e(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f29792b.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f29792b.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f29792b.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.f29792b.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f29792b.submit(d((Callable) b5.u.E(callable)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f29792b.invokeAll(e(collection), j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f29792b.invokeAny(e(collection), j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.f29792b.submit(c(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, @l0 T t10) {
        return this.f29792b.submit(c(runnable), t10);
    }
}
