package com.google.zxing.oned.b0;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.q;

/* loaded from: classes.dex */
public abstract class a extends q {

    /* renamed from: a */
    private static final float f8527a = 0.2f;

    /* renamed from: b */
    private static final float f8528b = 0.45f;

    /* renamed from: c */
    private static final float f8529c = 0.7916667f;

    /* renamed from: d */
    private static final float f8530d = 0.89285713f;

    /* renamed from: f */
    private final int[] f8532f;

    /* renamed from: i */
    private final int[] f8535i;

    /* renamed from: j */
    private final int[] f8536j;

    /* renamed from: e */
    private final int[] f8531e = new int[4];

    /* renamed from: g */
    private final float[] f8533g = new float[4];

    /* renamed from: h */
    private final float[] f8534h = new float[4];

    protected a() {
        int[] iArr = new int[8];
        this.f8532f = iArr;
        this.f8535i = new int[iArr.length / 2];
        this.f8536j = new int[iArr.length / 2];
    }

    @Deprecated
    protected static int h(int[] iArr) {
        return com.google.zxing.common.l.a.d(iArr);
    }

    protected static void i(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static void p(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static boolean q(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 >= f8529c && f2 <= f8530d) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int r(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (q.e(iArr, iArr2[i2], f8528b) < 0.2f) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final int[] j() {
        return this.f8532f;
    }

    protected final int[] k() {
        return this.f8531e;
    }

    protected final int[] l() {
        return this.f8536j;
    }

    protected final float[] m() {
        return this.f8534h;
    }

    protected final int[] n() {
        return this.f8535i;
    }

    protected final float[] o() {
        return this.f8533g;
    }
}
