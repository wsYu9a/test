package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class y0 {

    /* renamed from: d */
    public static final long[] f28287d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a */
    public final byte[] f28288a = new byte[8];

    /* renamed from: b */
    public int f28289b;

    /* renamed from: c */
    public int f28290c;

    public static int a(int i2) {
        long j2;
        int i3 = 0;
        do {
            long[] jArr = f28287d;
            if (i3 >= jArr.length) {
                return -1;
            }
            j2 = jArr[i3] & i2;
            i3++;
        } while (j2 == 0);
        return i3;
    }

    public static long a(byte[] bArr, int i2, boolean z) {
        long j2 = bArr[0] & 255;
        if (z) {
            j2 &= f28287d[i2 - 1] ^ (-1);
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (bArr[i3] & 255);
        }
        return j2;
    }

    public long a(h0 h0Var, boolean z, boolean z2, int i2) {
        if (this.f28289b == 0) {
            if (!((d0) h0Var).b(this.f28288a, 0, 1, z)) {
                return -1L;
            }
            int a2 = a(this.f28288a[0] & 255);
            this.f28290c = a2;
            if (a2 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f28289b = 1;
        }
        int i3 = this.f28290c;
        if (i3 > i2) {
            this.f28289b = 0;
            return -2L;
        }
        if (i3 != 1) {
            ((d0) h0Var).b(this.f28288a, 1, i3 - 1, false);
        }
        this.f28289b = 0;
        return a(this.f28288a, this.f28290c, z2);
    }
}
