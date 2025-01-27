package com.vivo.google.android.exoplayer3;

import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a */
    public static final int[] f27486a = {1, 2, 3, 6};

    /* renamed from: b */
    public static final int[] f27487b = {48000, 44100, 32000};

    /* renamed from: c */
    public static final int[] f27488c = {24000, 22050, 16000};

    /* renamed from: d */
    public static final int[] f27489d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e */
    public static final int[] f27490e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f */
    public static final int[] f27491f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f27487b;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f27491f;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f27490e[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }
}
