package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a5.a
@DoNotMock("Use FakeTimeLimiter")
@a5.c
@m
/* loaded from: classes2.dex */
public interface z0 {
    void a(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException;

    <T> T b(T t10, Class<T> cls, long j10, TimeUnit timeUnit);

    void c(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException;

    @CanIgnoreReturnValue
    <T> T d(Callable<T> callable, long j10, TimeUnit timeUnit) throws TimeoutException, ExecutionException;

    @CanIgnoreReturnValue
    <T> T e(Callable<T> callable, long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException;
}
