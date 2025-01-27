package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.a1;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class c1 implements a1.a {

    /* renamed from: a */
    public final long f27236a;

    /* renamed from: b */
    public final long f27237b;

    /* renamed from: c */
    public final long f27238c;

    /* renamed from: d */
    public final long[] f27239d;

    /* renamed from: e */
    public final long f27240e;

    /* renamed from: f */
    public final int f27241f;

    public c1(long j2, long j3, long j4, long[] jArr, long j5, int i2) {
        this.f27236a = j2;
        this.f27237b = j3;
        this.f27238c = j4;
        this.f27239d = jArr;
        this.f27240e = j5;
        this.f27241f = i2;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        if (!a()) {
            return this.f27236a;
        }
        float f2 = (j2 * 100.0f) / this.f27237b;
        if (f2 <= 0.0f) {
            r0 = 0.0f;
        } else if (f2 < 100.0f) {
            int i2 = (int) f2;
            float f3 = i2 != 0 ? this.f27239d[i2 - 1] : 0.0f;
            r0 = (((i2 < 99 ? this.f27239d[i2] : 256.0f) - f3) * (f2 - i2)) + f3;
        }
        double d2 = r0;
        Double.isNaN(d2);
        double d3 = this.f27240e;
        Double.isNaN(d3);
        long round = Math.round(d2 * 0.00390625d * d3);
        long j3 = this.f27236a;
        long j4 = round + j3;
        long j5 = this.f27238c;
        return Math.min(j4, j5 != -1 ? j5 - 1 : ((j3 - this.f27241f) + this.f27240e) - 1);
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return this.f27239d != null;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.f27237b;
    }

    @Override // com.vivo.google.android.exoplayer3.a1.a
    public long c(long j2) {
        long j3 = 0;
        if (a()) {
            long j4 = this.f27236a;
            if (j2 >= j4) {
                double d2 = j2 - j4;
                Double.isNaN(d2);
                double d3 = this.f27240e;
                Double.isNaN(d3);
                double d4 = (d2 * 256.0d) / d3;
                int binarySearchFloor = Util.binarySearchFloor(this.f27239d, (long) d4, true, false) + 1;
                long j5 = this.f27237b;
                long j6 = (binarySearchFloor * j5) / 100;
                long j7 = binarySearchFloor == 0 ? 0L : this.f27239d[binarySearchFloor - 1];
                long j8 = binarySearchFloor == 99 ? 256L : this.f27239d[binarySearchFloor];
                long j9 = (j5 * (binarySearchFloor + 1)) / 100;
                if (j8 != j7) {
                    double d5 = j9 - j6;
                    double d6 = j7;
                    Double.isNaN(d6);
                    Double.isNaN(d5);
                    double d7 = j8 - j7;
                    Double.isNaN(d7);
                    j3 = (long) ((d5 * (d4 - d6)) / d7);
                }
                return j6 + j3;
            }
        }
        return 0L;
    }
}
