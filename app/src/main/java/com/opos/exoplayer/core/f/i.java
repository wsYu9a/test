package com.opos.exoplayer.core.f;

import java.util.List;

/* loaded from: classes4.dex */
public abstract class i extends com.opos.exoplayer.core.b.f implements d {

    /* renamed from: c */
    private d f18811c;

    /* renamed from: d */
    private long f18812d;

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j2) {
        return this.f18811c.a(j2 - this.f18812d);
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i2) {
        return this.f18811c.a(i2) + this.f18812d;
    }

    @Override // com.opos.exoplayer.core.b.a
    public void a() {
        super.a();
        this.f18811c = null;
    }

    public void a(long j2, d dVar, long j3) {
        ((com.opos.exoplayer.core.b.f) this).f17742a = j2;
        this.f18811c = dVar;
        if (j3 != Long.MAX_VALUE) {
            j2 = j3;
        }
        this.f18812d = j2;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.f18811c.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<b> b(long j2) {
        return this.f18811c.b(j2 - this.f18812d);
    }

    public abstract void e();
}
