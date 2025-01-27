package rx.m;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a */
    private static final d f36915a = new d();

    /* renamed from: b */
    static final rx.m.a f36916b = new a();

    /* renamed from: c */
    private final AtomicReference<rx.m.a> f36917c = new AtomicReference<>();

    /* renamed from: d */
    private final AtomicReference<b> f36918d = new AtomicReference<>();

    /* renamed from: e */
    private final AtomicReference<e> f36919e = new AtomicReference<>();

    static class a extends rx.m.a {
        a() {
        }
    }

    d() {
    }

    public static d b() {
        return f36915a;
    }

    private static Object d(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException unused) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(simpleName + " implementation class not found: " + property, e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e4);
        }
    }

    public rx.m.a a() {
        if (this.f36917c.get() == null) {
            Object d2 = d(rx.m.a.class);
            if (d2 == null) {
                this.f36917c.compareAndSet(null, f36916b);
            } else {
                this.f36917c.compareAndSet(null, (rx.m.a) d2);
            }
        }
        return this.f36917c.get();
    }

    public b c() {
        if (this.f36918d.get() == null) {
            Object d2 = d(b.class);
            if (d2 == null) {
                this.f36918d.compareAndSet(null, c.f());
            } else {
                this.f36918d.compareAndSet(null, (b) d2);
            }
        }
        return this.f36918d.get();
    }

    public e e() {
        if (this.f36919e.get() == null) {
            Object d2 = d(e.class);
            if (d2 == null) {
                this.f36919e.compareAndSet(null, e.b());
            } else {
                this.f36919e.compareAndSet(null, (e) d2);
            }
        }
        return this.f36919e.get();
    }

    public void f(rx.m.a aVar) {
        if (this.f36917c.compareAndSet(null, aVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f36917c.get());
    }

    public void g(b bVar) {
        if (this.f36918d.compareAndSet(null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f36918d.get());
    }

    public void h(e eVar) {
        if (this.f36919e.compareAndSet(null, eVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f36919e.get());
    }

    void i() {
        d dVar = f36915a;
        dVar.f36917c.set(null);
        dVar.f36918d.set(null);
        dVar.f36919e.set(null);
    }
}
