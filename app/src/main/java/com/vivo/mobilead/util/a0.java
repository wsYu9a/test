package com.vivo.mobilead.util;

/* loaded from: classes4.dex */
public final class a0 {
    public static boolean a(float f2, float f3) {
        return a(f2, f3, 1.0E-6d);
    }

    public static boolean a(float f2, float f3, double d2) {
        return ((double) Math.abs(f2 - f3)) <= d2;
    }

    public static boolean a(double d2, double d3) {
        return a(d2, d3, 1.0E-6d);
    }

    public static boolean a(double d2, double d3, double d4) {
        return Math.abs(d2 - d3) <= d4;
    }
}
