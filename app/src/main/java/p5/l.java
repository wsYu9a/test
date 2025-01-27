package p5;

import java.util.concurrent.Callable;

@a5.b(emulated = true)
@m
/* loaded from: classes2.dex */
public final class l {
    @a5.a
    @a5.c
    public static <T> e<T> e(Callable<T> callable, g0 g0Var) {
        b5.u.E(callable);
        b5.u.E(g0Var);
        return new e() { // from class: p5.i

            /* renamed from: b */
            public final /* synthetic */ Callable f29797b;

            public /* synthetic */ i(Callable callable2) {
                callable = callable2;
            }

            @Override // p5.e
            public final c0 call() {
                c0 submit;
                submit = g0.this.submit(callable);
                return submit;
            }
        };
    }

    public static /* synthetic */ Object h(b5.z zVar, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean m10 = m((String) zVar.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (m10) {
                m(name, currentThread);
            }
        }
    }

    public static /* synthetic */ void i(b5.z zVar, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean m10 = m((String) zVar.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (m10) {
                m(name, currentThread);
            }
        }
    }

    public static <T> Callable<T> j(@l0 T t10) {
        return new Callable() { // from class: p5.j

            /* renamed from: b */
            public final /* synthetic */ Object f29798b;

            public /* synthetic */ j(Object t102) {
                t10 = t102;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object g10;
                g10 = l.g(t10);
                return g10;
            }
        };
    }

    @a5.c
    public static Runnable k(Runnable runnable, b5.z<String> zVar) {
        b5.u.E(zVar);
        b5.u.E(runnable);
        return new Runnable() { // from class: p5.k

            /* renamed from: c */
            public final /* synthetic */ Runnable f29800c;

            public /* synthetic */ k(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.i(b5.z.this, runnable);
            }
        };
    }

    @a5.c
    public static <T> Callable<T> l(Callable<T> callable, b5.z<String> zVar) {
        b5.u.E(zVar);
        b5.u.E(callable);
        return new Callable() { // from class: p5.h

            /* renamed from: c */
            public final /* synthetic */ Callable f29795c;

            public /* synthetic */ h(Callable callable2) {
                callable = callable2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object h10;
                h10 = l.h(b5.z.this, callable);
                return h10;
            }
        };
    }

    @a5.c
    public static boolean m(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static /* synthetic */ Object g(Object obj) throws Exception {
        return obj;
    }
}
