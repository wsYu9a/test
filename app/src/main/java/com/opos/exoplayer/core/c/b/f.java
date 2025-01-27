package com.opos.exoplayer.core.c.b;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a */
    private static final long[] f17828a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f17829b = new byte[8];

    /* renamed from: c */
    private int f17830c;

    /* renamed from: d */
    private int f17831d;

    public static int a(int i2) {
        long j2;
        int i3 = 0;
        do {
            long[] jArr = f17828a;
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
            j2 &= f17828a[i2 - 1] ^ (-1);
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (bArr[i3] & 255);
        }
        return j2;
    }

    public long a(com.opos.exoplayer.core.c.f fVar, boolean z, boolean z2, int i2) {
        if (this.f17830c == 0) {
            if (!fVar.a(this.f17829b, 0, 1, z)) {
                return -1L;
            }
            int a2 = a(this.f17829b[0] & 255);
            this.f17831d = a2;
            if (a2 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f17830c = 1;
        }
        int i3 = this.f17831d;
        if (i3 > i2) {
            this.f17830c = 0;
            return -2L;
        }
        if (i3 != 1) {
            fVar.b(this.f17829b, 1, i3 - 1);
        }
        this.f17830c = 0;
        return a(this.f17829b, this.f17831d, z2);
    }

    public void a() {
        this.f17830c = 0;
        this.f17831d = 0;
    }

    public int b() {
        return this.f17831d;
    }
}
