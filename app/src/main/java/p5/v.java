package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public abstract class v extends s implements g0 {
    @Override // p5.s
    /* renamed from: f */
    public abstract g0 delegate();

    @Override // p5.s, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, @l0 Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // p5.s, java.util.concurrent.ExecutorService
    public <T> c0<T> submit(Callable<T> callable) {
        return delegate().submit((Callable) callable);
    }

    @Override // p5.s, java.util.concurrent.ExecutorService
    public c0<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }

    @Override // p5.s, java.util.concurrent.ExecutorService
    public <T> c0<T> submit(Runnable runnable, @l0 T t10) {
        return delegate().submit(runnable, (Runnable) t10);
    }
}
