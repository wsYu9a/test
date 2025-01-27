package com.vivo.google.android.exoplayer3;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public final class k0 {

    /* renamed from: h */
    public static final String[] f27549h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i */
    public static final int[] f27550i = {44100, 48000, 32000};

    /* renamed from: j */
    public static final int[] f27551j = {32, 64, 96, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 288, 320, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 384, 416, 448};
    public static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, Downloads.Impl.STATUS_RUNNING, 224, 256};
    public static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320, 384};
    public static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320};
    public static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a */
    public int f27552a;

    /* renamed from: b */
    public String f27553b;

    /* renamed from: c */
    public int f27554c;

    /* renamed from: d */
    public int f27555d;

    /* renamed from: e */
    public int f27556e;

    /* renamed from: f */
    public int f27557f;

    /* renamed from: g */
    public int f27558g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f27550i[i6];
        if (i3 == 2) {
            i7 /= 2;
        } else if (i3 == 0) {
            i7 /= 4;
        }
        int i8 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f27551j[i5 - 1] : k[i5 - 1]) * 12000) / i7) + i8) * 4;
        }
        int i9 = i3 == 3 ? i4 == 2 ? l[i5 - 1] : m[i5 - 1] : n[i5 - 1];
        if (i3 == 3) {
            return ((i9 * 144000) / i7) + i8;
        }
        return (((i4 == 1 ? 72000 : 144000) * i9) / i7) + i8;
    }

    public static boolean a(int i2, k0 k0Var) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i10 = f27550i[i6];
        if (i3 == 2) {
            i10 /= 2;
        } else if (i3 == 0) {
            i10 /= 4;
        }
        int i11 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f27551j[i5 - 1] : k[i5 - 1];
            i8 = (((i7 * 12000) / i10) + i11) * 4;
            i9 = 384;
        } else {
            if (i3 == 3) {
                i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                i8 = i11 + ((144000 * i7) / i10);
                i9 = 1152;
            } else {
                i7 = n[i5 - 1];
                int i12 = i4 == 1 ? 576 : 1152;
                i8 = i11 + (((i4 == 1 ? 72000 : 144000) * i7) / i10);
                i9 = i12;
            }
        }
        String str = f27549h[3 - i4];
        int i13 = ((i2 >> 6) & 3) == 3 ? 1 : 2;
        k0Var.f27552a = i3;
        k0Var.f27553b = str;
        k0Var.f27554c = i8;
        k0Var.f27555d = i10;
        k0Var.f27556e = i13;
        k0Var.f27557f = i7 * 1000;
        k0Var.f27558g = i9;
        return true;
    }
}
