package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class b implements l {

    /* renamed from: a */
    private final int f18299a;

    /* renamed from: b */
    private final int f18300b;

    /* renamed from: c */
    private final int f18301c;

    /* renamed from: d */
    private final int f18302d;

    /* renamed from: e */
    private final int f18303e;

    /* renamed from: f */
    private final int f18304f;

    /* renamed from: g */
    private long f18305g;

    /* renamed from: h */
    private long f18306h;

    public b(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f18299a = i2;
        this.f18300b = i3;
        this.f18301c = i4;
        this.f18302d = i5;
        this.f18303e = i6;
        this.f18304f = i7;
    }

    public long a(long j2) {
        return (Math.max(0L, j2 - this.f18305g) * C.MICROS_PER_SECOND) / this.f18301c;
    }

    public void a(long j2, long j3) {
        this.f18305g = j2;
        this.f18306h = j3;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return ((this.f18306h / this.f18302d) * C.MICROS_PER_SECOND) / this.f18300b;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        long j3 = (this.f18301c * j2) / C.MICROS_PER_SECOND;
        int i2 = this.f18302d;
        long a2 = u.a((j3 / i2) * i2, 0L, this.f18306h - i2);
        long j4 = this.f18305g + a2;
        long a3 = a(j4);
        m mVar = new m(a3, j4);
        if (a3 < j2) {
            long j5 = this.f18306h;
            int i3 = this.f18302d;
            if (a2 != j5 - i3) {
                long j6 = i3 + j4;
                return new l.a(mVar, new m(a(j6), j6));
            }
        }
        return new l.a(mVar);
    }

    public boolean c() {
        return (this.f18305g == 0 || this.f18306h == 0) ? false : true;
    }

    public int d() {
        return this.f18302d;
    }

    public int e() {
        return this.f18300b * this.f18303e * this.f18299a;
    }

    public int f() {
        return this.f18300b;
    }

    public int g() {
        return this.f18299a;
    }

    public int h() {
        return this.f18304f;
    }
}
