package com.vivo.mobilead.lottie;

import android.os.Build;
import android.os.Trace;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static boolean f29112a = false;

    /* renamed from: b */
    private static boolean f29113b = false;

    /* renamed from: c */
    private static String[] f29114c;

    /* renamed from: d */
    private static long[] f29115d;

    /* renamed from: e */
    private static int f29116e;

    /* renamed from: f */
    private static int f29117f;

    public static void a(String str) {
        if (f29113b) {
            int i2 = f29116e;
            if (i2 == 20) {
                f29117f++;
                return;
            }
            f29114c[i2] = str;
            f29115d[i2] = System.nanoTime();
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection(str);
            }
            f29116e++;
        }
    }

    public static float b(String str) {
        int i2 = f29117f;
        if (i2 > 0) {
            f29117f = i2 - 1;
            return 0.0f;
        }
        if (!f29113b) {
            return 0.0f;
        }
        int i3 = f29116e - 1;
        f29116e = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f29114c[i3])) {
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
            return (System.nanoTime() - f29115d[f29116e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f29114c[f29116e] + ".");
    }
}
