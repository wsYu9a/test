package p5;

import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@a5.a
@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public final class o implements z0 {
    @Override // p5.z0
    public void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        b5.u.E(runnable);
        b5.u.E(timeUnit);
        try {
            runnable.run();
        } catch (Error e10) {
            throw new ExecutionError(e10);
        } catch (RuntimeException e11) {
            throw new UncheckedExecutionException(e11);
        } catch (Throwable th2) {
            throw new UncheckedExecutionException(th2);
        }
    }

    @Override // p5.z0
    public <T> T b(T t10, Class<T> cls, long j10, TimeUnit timeUnit) {
        b5.u.E(t10);
        b5.u.E(cls);
        b5.u.E(timeUnit);
        return t10;
    }

    @Override // p5.z0
    public void c(Runnable runnable, long j10, TimeUnit timeUnit) {
        a(runnable, j10, timeUnit);
    }

    @Override // p5.z0
    @l0
    public <T> T d(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException {
        return (T) e(callable, j10, timeUnit);
    }

    @Override // p5.z0
    @l0
    public <T> T e(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException {
        b5.u.E(callable);
        b5.u.E(timeUnit);
        try {
            return callable.call();
        } catch (Error e10) {
            throw new ExecutionError(e10);
        } catch (RuntimeException e11) {
            throw new UncheckedExecutionException(e11);
        } catch (Exception e12) {
            throw new ExecutionException(e12);
        } catch (Throwable th2) {
            throw new ExecutionException(th2);
        }
    }
}
