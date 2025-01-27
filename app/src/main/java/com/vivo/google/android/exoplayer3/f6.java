package com.vivo.google.android.exoplayer3;

import android.util.Pair;

/* loaded from: classes4.dex */
public final class f6 {

    /* renamed from: a */
    public static final byte[] f27417a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final int[] f27418b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 7350};

    /* renamed from: c */
    public static final int[] f27419c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static int a(m6 m6Var) {
        int a2 = m6Var.a(4);
        if (a2 == 15) {
            return m6Var.a(24);
        }
        g1.a(a2 < 13);
        return f27418b[a2];
    }

    public static Pair<Integer, Integer> a(byte[] bArr) {
        m6 m6Var = new m6(bArr, bArr.length);
        int a2 = m6Var.a(5);
        if (a2 == 31) {
            a2 = m6Var.a(6) + 32;
        }
        int a3 = a(m6Var);
        int a4 = m6Var.a(4);
        if (a2 == 5 || a2 == 29) {
            a3 = a(m6Var);
            int a5 = m6Var.a(5);
            if (a5 == 31) {
                a5 = m6Var.a(6) + 32;
            }
            if (a5 == 22) {
                a4 = m6Var.a(4);
            }
        }
        int i2 = f27419c[a4];
        g1.a(i2 != -1);
        return Pair.create(Integer.valueOf(a3), Integer.valueOf(i2));
    }
}
