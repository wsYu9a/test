package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class a implements l {

    /* renamed from: a */
    public final int f17755a;

    /* renamed from: b */
    public final int[] f17756b;

    /* renamed from: c */
    public final long[] f17757c;

    /* renamed from: d */
    public final long[] f17758d;

    /* renamed from: e */
    public final long[] f17759e;

    /* renamed from: f */
    private final long f17760f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f17756b = iArr;
        this.f17757c = jArr;
        this.f17758d = jArr2;
        this.f17759e = jArr3;
        int length = iArr.length;
        this.f17755a = length;
        if (length > 0) {
            this.f17760f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f17760f = 0L;
        }
    }

    public int a(long j2) {
        return u.a(this.f17759e, j2, true, true);
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f17760f;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        int a2 = a(j2);
        m mVar = new m(this.f17759e[a2], this.f17757c[a2]);
        if (mVar.f18329b >= j2 || a2 == this.f17755a - 1) {
            return new l.a(mVar);
        }
        int i2 = a2 + 1;
        return new l.a(mVar, new m(this.f17759e[i2], this.f17757c[i2]));
    }
}
