package k6;

import com.google.zxing.NotFoundException;
import j6.q;

/* loaded from: classes2.dex */
public abstract class a extends q {

    /* renamed from: g */
    public static final float f27700g = 0.2f;

    /* renamed from: h */
    public static final float f27701h = 0.45f;

    /* renamed from: i */
    public static final float f27702i = 0.7916667f;

    /* renamed from: j */
    public static final float f27703j = 0.89285713f;

    /* renamed from: b */
    public final int[] f27705b;

    /* renamed from: e */
    public final int[] f27708e;

    /* renamed from: f */
    public final int[] f27709f;

    /* renamed from: a */
    public final int[] f27704a = new int[4];

    /* renamed from: c */
    public final float[] f27706c = new float[4];

    /* renamed from: d */
    public final float[] f27707d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f27705b = iArr;
        this.f27708e = new int[iArr.length / 2];
        this.f27709f = new int[iArr.length / 2];
    }

    @Deprecated
    public static int h(int[] iArr) {
        return a6.a.d(iArr);
    }

    public static void i(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 < f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] - 1;
    }

    public static void p(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 > f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] + 1;
    }

    public static boolean q(int[] iArr) {
        float f10 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f10 >= 0.7916667f && f10 <= 0.89285713f) {
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
                if (i12 < i10) {
                    i10 = i12;
                }
            }
            if (i11 < i10 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int r(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            if (q.e(iArr, iArr2[i10], 0.45f) < 0.2f) {
                return i10;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] j() {
        return this.f27705b;
    }

    public final int[] k() {
        return this.f27704a;
    }

    public final int[] l() {
        return this.f27709f;
    }

    public final float[] m() {
        return this.f27707d;
    }

    public final int[] n() {
        return this.f27708e;
    }

    public final float[] o() {
        return this.f27706c;
    }
}
