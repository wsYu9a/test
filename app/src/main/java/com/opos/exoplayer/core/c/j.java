package com.opos.exoplayer.core.c;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: h */
    private static final String[] f18313h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i */
    private static final int[] f18314i = {44100, 48000, 32000};

    /* renamed from: j */
    private static final int[] f18315j = {32, 64, 96, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 288, 320, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 384, 416, 448};
    private static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, Downloads.Impl.STATUS_RUNNING, 224, 256};
    private static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320, 384};
    private static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320};
    private static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a */
    public int f18316a;

    /* renamed from: b */
    public String f18317b;

    /* renamed from: c */
    public int f18318c;

    /* renamed from: d */
    public int f18319d;

    /* renamed from: e */
    public int f18320e;

    /* renamed from: f */
    public int f18321f;

    /* renamed from: g */
    public int f18322g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f18314i[i6];
        if (i3 == 2) {
            i7 /= 2;
        } else if (i3 == 0) {
            i7 /= 4;
        }
        int i8 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f18315j[i5 - 1] : k[i5 - 1]) * 12000) / i7) + i8) * 4;
        }
        int i9 = i3 == 3 ? i4 == 2 ? l[i5 - 1] : m[i5 - 1] : n[i5 - 1];
        if (i3 == 3) {
            return ((i9 * 144000) / i7) + i8;
        }
        return (((i4 == 1 ? 72000 : 144000) * i9) / i7) + i8;
    }

    private void a(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f18316a = i2;
        this.f18317b = str;
        this.f18318c = i3;
        this.f18319d = i4;
        this.f18320e = i5;
        this.f18321f = i6;
        this.f18322g = i7;
    }

    public static boolean a(int i2, j jVar) {
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
        int i10 = f18314i[i6];
        if (i3 == 2) {
            i10 /= 2;
        } else if (i3 == 0) {
            i10 /= 4;
        }
        int i11 = i10;
        int i12 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f18315j[i5 - 1] : k[i5 - 1];
            i9 = (((i7 * 12000) / i11) + i12) * 4;
            i8 = 384;
        } else {
            if (i3 == 3) {
                i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                i9 = i12 + ((144000 * i7) / i11);
                i8 = 1152;
            } else {
                i7 = n[i5 - 1];
                i8 = i4 == 1 ? 576 : 1152;
                i9 = i12 + (((i4 == 1 ? 72000 : 144000) * i7) / i11);
            }
        }
        jVar.a(i3, f18313h[3 - i4], i9, i11, ((i2 >> 6) & 3) == 3 ? 1 : 2, i7 * 1000, i8);
        return true;
    }
}
