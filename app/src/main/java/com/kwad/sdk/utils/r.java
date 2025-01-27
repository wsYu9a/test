package com.kwad.sdk.utils;

/* loaded from: classes3.dex */
public final class r {
    public static int a(long j10, long j11, boolean z10, int i10) {
        com.kwad.sdk.core.d.c.d("DownloadProgressTransformUtil", "soFarBytes:" + j10 + " totalBytes:" + j11 + " isShowOptimizedProgress: " + z10 + " optimizeMethod: " + i10);
        double d10 = j11 > 0 ? (j10 * 100.0d) / j11 : l5.c.f27899e;
        if (!z10) {
            return (int) d10;
        }
        if (i10 == 1) {
            d10 = p(d10);
        } else if (i10 == 2) {
            d10 = q(d10);
        }
        return (int) d10;
    }

    private static double p(double d10) {
        if (d10 <= 6.0d) {
            return d10 * 5.0d;
        }
        if (d10 <= 15.0d) {
            return ((d10 - 6.0d) * 2.0d) + 30.0d;
        }
        if (d10 <= 30.0d) {
            return d10 + 33.0d;
        }
        if (d10 < 100.0d) {
            return Math.min((((d10 - 30.0d) * 0.37d) / 0.7d) + 63.0d, 99.0d);
        }
        return 100.0d;
    }

    private static double q(double d10) {
        return Math.sqrt(d10) * 10.0d;
    }
}
