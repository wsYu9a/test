package p5;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;
import p5.q0;

@a5.a
@a5.c
@m
/* loaded from: classes2.dex */
public final class q0 implements z0 {

    /* renamed from: a */
    public final ExecutorService f29815a;

    public class a implements InvocationHandler {

        /* renamed from: b */
        public final /* synthetic */ Object f29816b;

        /* renamed from: c */
        public final /* synthetic */ long f29817c;

        /* renamed from: d */
        public final /* synthetic */ TimeUnit f29818d;

        /* renamed from: e */
        public final /* synthetic */ Set f29819e;

        public a(Object obj, long j10, TimeUnit timeUnit, Set set) {
            this.f29816b = obj;
            this.f29817c = j10;
            this.f29818d = timeUnit;
            this.f29819e = set;
        }

        public static /* synthetic */ Object b(Method method, Object obj, Object[] objArr) throws Exception {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e10) {
                throw q0.n(e10, false);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
            return q0.this.h(new Callable() { // from class: p5.p0

                /* renamed from: b */
                public final /* synthetic */ Method f29812b;

                /* renamed from: c */
                public final /* synthetic */ Object f29813c;

                /* renamed from: d */
                public final /* synthetic */ Object[] f29814d;

                public /* synthetic */ p0(Method method2, Object obj2, Object[] objArr2) {
                    method = method2;
                    obj2 = obj2;
                    objArr = objArr2;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object b10;
                    b10 = q0.a.b(method, obj2, objArr);
                    return b10;
                }
            }, this.f29817c, this.f29818d, this.f29819e.contains(method2));
        }
    }

    public q0(ExecutorService executorService) {
        this.f29815a = (ExecutorService) b5.u.E(executorService);
    }

    public static void i(long j10) {
        b5.u.p(j10 > 0, "timeout must be positive: %s", j10);
    }

    public static q0 j(ExecutorService executorService) {
        return new q0(executorService);
    }

    public static boolean k(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    public static Set<Method> l(Class<?> cls) {
        HashSet u10 = Sets.u();
        for (Method method : cls.getMethods()) {
            if (k(method)) {
                u10.add(method);
            }
        }
        return u10;
    }

    public static <T> T m(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static Exception n(Exception exc, boolean z10) throws Exception {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z10) {
            cause.setStackTrace((StackTraceElement[]) e5.b1.f(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }

    @Override // p5.z0
    public void a(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        b5.u.E(runnable);
        b5.u.E(timeUnit);
        i(j10);
        Future<?> submit = this.f29815a.submit(runnable);
        try {
            submit.get(j10, timeUnit);
        } catch (InterruptedException e10) {
            e = e10;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e11) {
            p(e11.getCause());
            throw new AssertionError();
        } catch (TimeoutException e12) {
            e = e12;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // p5.z0
    public <T> T b(T t10, Class<T> cls, long j10, TimeUnit timeUnit) {
        b5.u.E(t10);
        b5.u.E(cls);
        b5.u.E(timeUnit);
        i(j10);
        b5.u.e(cls.isInterface(), "interfaceType must be an interface type");
        return (T) m(cls, new a(t10, j10, timeUnit, l(cls)));
    }

    @Override // p5.z0
    public void c(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException {
        b5.u.E(runnable);
        b5.u.E(timeUnit);
        i(j10);
        Future<?> submit = this.f29815a.submit(runnable);
        try {
            b1.g(submit, j10, timeUnit);
        } catch (ExecutionException e10) {
            p(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        }
    }

    @Override // p5.z0
    @CanIgnoreReturnValue
    public <T> T d(Callable<T> callable, long j10, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        b5.u.E(callable);
        b5.u.E(timeUnit);
        i(j10);
        Future<T> submit = this.f29815a.submit(callable);
        try {
            return (T) b1.g(submit, j10, timeUnit);
        } catch (ExecutionException e10) {
            o(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        }
    }

    @Override // p5.z0
    @CanIgnoreReturnValue
    public <T> T e(Callable<T> callable, long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        b5.u.E(callable);
        b5.u.E(timeUnit);
        i(j10);
        Future<T> submit = this.f29815a.submit(callable);
        try {
            return submit.get(j10, timeUnit);
        } catch (InterruptedException e10) {
            e = e10;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e11) {
            o(e11.getCause());
            throw new AssertionError();
        } catch (TimeoutException e12) {
            e = e12;
            submit.cancel(true);
            throw e;
        }
    }

    public final <T> T h(Callable<T> callable, long j10, TimeUnit timeUnit, boolean z10) throws Exception {
        b5.u.E(callable);
        b5.u.E(timeUnit);
        i(j10);
        Future<T> submit = this.f29815a.submit(callable);
        try {
            if (!z10) {
                return (T) b1.g(submit, j10, timeUnit);
            }
            try {
                return submit.get(j10, timeUnit);
            } catch (InterruptedException e10) {
                submit.cancel(true);
                throw e10;
            }
        } catch (ExecutionException e11) {
            throw n(e11, true);
        } catch (TimeoutException e12) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(e12);
        }
    }

    public final void o(Throwable th2) throws ExecutionException {
        if (th2 instanceof Error) {
            throw new ExecutionError((Error) th2);
        }
        if (!(th2 instanceof RuntimeException)) {
            throw new ExecutionException(th2);
        }
        throw new UncheckedExecutionException(th2);
    }

    public final void p(Throwable th2) {
        if (!(th2 instanceof Error)) {
            throw new UncheckedExecutionException(th2);
        }
        throw new ExecutionError((Error) th2);
    }
}
