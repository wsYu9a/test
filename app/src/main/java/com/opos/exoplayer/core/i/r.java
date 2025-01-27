package com.opos.exoplayer.core.i;

/* loaded from: classes4.dex */
public final class r implements i {

    /* renamed from: a */
    private final b f19070a;

    /* renamed from: b */
    private boolean f19071b;

    /* renamed from: c */
    private long f19072c;

    /* renamed from: d */
    private long f19073d;

    /* renamed from: e */
    private com.opos.exoplayer.core.p f19074e = com.opos.exoplayer.core.p.f19184a;

    public r(b bVar) {
        this.f19070a = bVar;
    }

    @Override // com.opos.exoplayer.core.i.i
    public com.opos.exoplayer.core.p a(com.opos.exoplayer.core.p pVar) {
        if (this.f19071b) {
            a(d());
        }
        this.f19074e = pVar;
        return pVar;
    }

    public void a() {
        if (this.f19071b) {
            return;
        }
        this.f19073d = this.f19070a.a();
        this.f19071b = true;
    }

    public void a(long j2) {
        this.f19072c = j2;
        if (this.f19071b) {
            this.f19073d = this.f19070a.a();
        }
    }

    public void b() {
        if (this.f19071b) {
            a(d());
            this.f19071b = false;
        }
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        long j2 = this.f19072c;
        if (!this.f19071b) {
            return j2;
        }
        long a2 = this.f19070a.a() - this.f19073d;
        com.opos.exoplayer.core.p pVar = this.f19074e;
        return j2 + (pVar.f19185b == 1.0f ? com.opos.exoplayer.core.b.b(a2) : pVar.a(a2));
    }

    @Override // com.opos.exoplayer.core.i.i
    public com.opos.exoplayer.core.p e() {
        return this.f19074e;
    }
}
