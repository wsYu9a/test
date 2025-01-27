package jj;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k0.e;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    public static final a f27581a = new C0720a();

    /* renamed from: b */
    public static final AtomicBoolean f27582b = new AtomicBoolean(false);

    /* renamed from: c */
    public static final AtomicReference<a> f27583c = new AtomicReference<>();

    public static class b extends a {
        @Override // jj.a
        public void b() {
            Iterator it = ServiceLoader.load(jj.b.class, jj.b.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    jj.b.j((jj.b) it.next());
                } catch (ServiceConfigurationError e10) {
                    if (!(e10.getCause() instanceof SecurityException)) {
                        throw e10;
                    }
                }
            }
        }
    }

    public static void a() {
        if (f27582b.getAndSet(true)) {
            throw new IllegalStateException("Already initialized");
        }
        AtomicReference<a> atomicReference = f27583c;
        e.a(atomicReference, null, new b());
        atomicReference.get().b();
    }

    public static void c(a aVar) {
        if (f27582b.get()) {
            throw new IllegalStateException("Already initialized");
        }
        if (!e.a(f27583c, null, aVar)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    public abstract void b();

    /* renamed from: jj.a$a */
    public static class C0720a extends a {
        @Override // jj.a
        public void b() {
        }
    }
}
