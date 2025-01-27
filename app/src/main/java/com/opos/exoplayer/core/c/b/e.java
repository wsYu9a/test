package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.i.m;

/* loaded from: classes4.dex */
final class e {

    /* renamed from: a */
    private final m f17826a = new m(8);

    /* renamed from: b */
    private int f17827b;

    private long b(com.opos.exoplayer.core.c.f fVar) {
        int i2 = 0;
        fVar.c(this.f17826a.f19048a, 0, 1);
        int i3 = this.f17826a.f19048a[0] & 255;
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
        fVar.c(this.f17826a.f19048a, 1, i5);
        while (i2 < i5) {
            i2++;
            i6 = (this.f17826a.f19048a[i2] & 255) + (i6 << 8);
        }
        this.f17827b += i5 + 1;
        return i6;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        long d2 = fVar.d();
        long j2 = 1024;
        if (d2 != -1 && d2 <= 1024) {
            j2 = d2;
        }
        int i2 = (int) j2;
        fVar.c(this.f17826a.f19048a, 0, 4);
        long m = this.f17826a.m();
        this.f17827b = 4;
        while (m != 440786851) {
            int i3 = this.f17827b + 1;
            this.f17827b = i3;
            if (i3 == i2) {
                return false;
            }
            fVar.c(this.f17826a.f19048a, 0, 1);
            m = ((m << 8) & (-256)) | (this.f17826a.f19048a[0] & 255);
        }
        long b2 = b(fVar);
        long j3 = this.f17827b;
        if (b2 == Long.MIN_VALUE) {
            return false;
        }
        if (d2 != -1 && j3 + b2 >= d2) {
            return false;
        }
        while (true) {
            int i4 = this.f17827b;
            long j4 = j3 + b2;
            if (i4 >= j4) {
                return ((long) i4) == j4;
            }
            if (b(fVar) == Long.MIN_VALUE) {
                return false;
            }
            long b3 = b(fVar);
            if (b3 < 0 || b3 > 2147483647L) {
                return false;
            }
            if (b3 != 0) {
                fVar.c((int) b3);
                this.f17827b = (int) (b3 + this.f17827b);
            }
        }
    }
}
