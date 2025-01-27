package sj;

import java.util.concurrent.atomic.AtomicReference;
import k0.e;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: b */
    public static final a f30674b = new a();

    /* renamed from: a */
    public final AtomicReference<b> f30675a = new AtomicReference<>();

    public static a a() {
        return f30674b;
    }

    public b b() {
        if (this.f30675a.get() == null) {
            e.a(this.f30675a, null, b.a());
        }
        return this.f30675a.get();
    }

    public void c(b bVar) {
        if (e.a(this.f30675a, null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f30675a.get());
    }

    @uj.a
    public void d() {
        this.f30675a.set(null);
    }
}
