package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class x0 {

    /* renamed from: a */
    public final n6 f28256a = new n6(8);

    /* renamed from: b */
    public int f28257b;

    public final long a(h0 h0Var) {
        d0 d0Var = (d0) h0Var;
        int i2 = 0;
        d0Var.a(this.f28256a.f27874a, 0, 1, false);
        int i3 = this.f28256a.f27874a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (i4 ^ (-1));
        d0Var.a(this.f28256a.f27874a, 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (this.f28256a.f27874a[i2] & 255) + (i6 << 8);
        }
        this.f28257b += i5 + 1;
        return i6;
    }
}
