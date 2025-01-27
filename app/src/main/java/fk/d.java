package fk;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: d */
    public static final d f26057d = new d();

    /* renamed from: e */
    public static final fk.a f26058e = new a();

    /* renamed from: a */
    public final AtomicReference<fk.a> f26059a = new AtomicReference<>();

    /* renamed from: b */
    public final AtomicReference<b> f26060b = new AtomicReference<>();

    /* renamed from: c */
    public final AtomicReference<e> f26061c = new AtomicReference<>();

    public static class a extends fk.a {
    }

    public static d b() {
        return f26057d;
    }

    public static Object d(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException unused) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(simpleName + " implementation class not found: " + property, e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e12);
        }
    }

    public fk.a a() {
        if (this.f26059a.get() == null) {
            Object d10 = d(fk.a.class);
            if (d10 == null) {
                k0.e.a(this.f26059a, null, f26058e);
            } else {
                k0.e.a(this.f26059a, null, (fk.a) d10);
            }
        }
        return this.f26059a.get();
    }

    public b c() {
        if (this.f26060b.get() == null) {
            Object d10 = d(b.class);
            if (d10 == null) {
                k0.e.a(this.f26060b, null, c.f());
            } else {
                k0.e.a(this.f26060b, null, (b) d10);
            }
        }
        return this.f26060b.get();
    }

    public e e() {
        if (this.f26061c.get() == null) {
            Object d10 = d(e.class);
            if (d10 == null) {
                k0.e.a(this.f26061c, null, e.b());
            } else {
                k0.e.a(this.f26061c, null, (e) d10);
            }
        }
        return this.f26061c.get();
    }

    public void f(fk.a aVar) {
        if (k0.e.a(this.f26059a, null, aVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f26059a.get());
    }

    public void g(b bVar) {
        if (k0.e.a(this.f26060b, null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f26060b.get());
    }

    public void h(e eVar) {
        if (k0.e.a(this.f26061c, null, eVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f26061c.get());
    }

    public void i() {
        d dVar = f26057d;
        dVar.f26059a.set(null);
        dVar.f26060b.set(null);
        dVar.f26061c.set(null);
    }
}
