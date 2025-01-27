package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
final class m {

    /* renamed from: a */
    public final int f17986a;

    /* renamed from: b */
    public final long[] f17987b;

    /* renamed from: c */
    public final int[] f17988c;

    /* renamed from: d */
    public final int f17989d;

    /* renamed from: e */
    public final long[] f17990e;

    /* renamed from: f */
    public final int[] f17991f;

    /* renamed from: g */
    public final long f17992g;

    public m(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        com.opos.exoplayer.core.i.a.a(iArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(jArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(iArr2.length == jArr2.length);
        this.f17987b = jArr;
        this.f17988c = iArr;
        this.f17989d = i2;
        this.f17990e = jArr2;
        this.f17991f = iArr2;
        this.f17992g = j2;
        this.f17986a = jArr.length;
    }

    public int a(long j2) {
        for (int a2 = u.a(this.f17990e, j2, true, false); a2 >= 0; a2--) {
            if ((this.f17991f[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int b2 = u.b(this.f17990e, j2, true, false); b2 < this.f17990e.length; b2++) {
            if ((this.f17991f[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }
}
