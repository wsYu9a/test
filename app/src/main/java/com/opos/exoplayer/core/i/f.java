package com.opos.exoplayer.core.i;

import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    public final int f19017a;

    /* renamed from: b */
    public final int f19018b;

    /* renamed from: c */
    public final int f19019c;

    /* renamed from: d */
    public final int f19020d;

    /* renamed from: e */
    public final int f19021e;

    /* renamed from: f */
    public final int f19022f;

    /* renamed from: g */
    public final int f19023g;

    /* renamed from: h */
    public final long f19024h;

    public f(byte[] bArr, int i2) {
        l lVar = new l(bArr);
        lVar.a(i2 * 8);
        this.f19017a = lVar.c(16);
        this.f19018b = lVar.c(16);
        this.f19019c = lVar.c(24);
        this.f19020d = lVar.c(24);
        this.f19021e = lVar.c(20);
        this.f19022f = lVar.c(3) + 1;
        this.f19023g = lVar.c(5) + 1;
        this.f19024h = ((lVar.c(4) & 15) << 32) | (lVar.c(32) & 4294967295L);
    }

    public int a() {
        return this.f19023g * this.f19021e;
    }

    public long b() {
        return (this.f19024h * C.MICROS_PER_SECOND) / this.f19021e;
    }
}
