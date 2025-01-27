package com.opos.exoplayer.core;

import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
final class f implements com.opos.exoplayer.core.i.i {

    /* renamed from: a */
    private final com.opos.exoplayer.core.i.r f18548a;

    /* renamed from: b */
    private final a f18549b;

    /* renamed from: c */
    @Nullable
    private s f18550c;

    /* renamed from: d */
    @Nullable
    private com.opos.exoplayer.core.i.i f18551d;

    public interface a {
        void a(p pVar);
    }

    public f(a aVar, com.opos.exoplayer.core.i.b bVar) {
        this.f18549b = aVar;
        this.f18548a = new com.opos.exoplayer.core.i.r(bVar);
    }

    private void f() {
        this.f18548a.a(this.f18551d.d());
        p e2 = this.f18551d.e();
        if (e2.equals(this.f18548a.e())) {
            return;
        }
        this.f18548a.a(e2);
        this.f18549b.a(e2);
    }

    private boolean g() {
        s sVar = this.f18550c;
        return (sVar == null || sVar.u() || (!this.f18550c.t() && this.f18550c.g())) ? false : true;
    }

    @Override // com.opos.exoplayer.core.i.i
    public p a(p pVar) {
        com.opos.exoplayer.core.i.i iVar = this.f18551d;
        if (iVar != null) {
            pVar = iVar.a(pVar);
        }
        this.f18548a.a(pVar);
        this.f18549b.a(pVar);
        return pVar;
    }

    public void a() {
        this.f18548a.a();
    }

    public void a(long j2) {
        this.f18548a.a(j2);
    }

    public void a(s sVar) {
        com.opos.exoplayer.core.i.i iVar;
        com.opos.exoplayer.core.i.i c2 = sVar.c();
        if (c2 == null || c2 == (iVar = this.f18551d)) {
            return;
        }
        if (iVar != null) {
            throw h.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f18551d = c2;
        this.f18550c = sVar;
        c2.a(this.f18548a.e());
        f();
    }

    public void b() {
        this.f18548a.b();
    }

    public void b(s sVar) {
        if (sVar == this.f18550c) {
            this.f18551d = null;
            this.f18550c = null;
        }
    }

    public long c() {
        if (!g()) {
            return this.f18548a.d();
        }
        f();
        return this.f18551d.d();
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        return g() ? this.f18551d.d() : this.f18548a.d();
    }

    @Override // com.opos.exoplayer.core.i.i
    public p e() {
        com.opos.exoplayer.core.i.i iVar = this.f18551d;
        return iVar != null ? iVar.e() : this.f18548a.e();
    }
}
