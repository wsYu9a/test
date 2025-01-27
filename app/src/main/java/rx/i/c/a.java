package rx.i.c;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    private static final a f35774a = new a();

    /* renamed from: b */
    private final AtomicReference<b> f35775b = new AtomicReference<>();

    a() {
    }

    public static a a() {
        return f35774a;
    }

    public b b() {
        if (this.f35775b.get() == null) {
            this.f35775b.compareAndSet(null, b.a());
        }
        return this.f35775b.get();
    }

    public void c(b bVar) {
        if (this.f35775b.compareAndSet(null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f35775b.get());
    }

    @rx.j.a
    public void d() {
        this.f35775b.set(null);
    }
}
