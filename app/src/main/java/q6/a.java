package q6;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import t5.l;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c */
    public static final float f29945c = 0.42f;

    /* renamed from: d */
    public static final float f29946d = 0.8f;

    /* renamed from: g */
    public static final int f29949g = 3;

    /* renamed from: h */
    public static final int f29950h = 5;

    /* renamed from: i */
    public static final int f29951i = 25;

    /* renamed from: j */
    public static final int f29952j = 5;

    /* renamed from: k */
    public static final int f29953k = 10;

    /* renamed from: a */
    public static final int[] f29943a = {0, 4, 1, 5};

    /* renamed from: b */
    public static final int[] f29944b = {6, 2, 7, 3};

    /* renamed from: e */
    public static final int[] f29947e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f */
    public static final int[] f29948f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void a(l[] lVarArr, l[] lVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            lVarArr[iArr[i10]] = lVarArr2[i10];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (t5.l[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<t5.l[]> b(boolean r8, z5.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            r3 = 0
            r4 = 0
        L9:
            int r5 = r9.h()
            if (r2 >= r5) goto L76
            t5.l[] r3 = f(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4e
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4e
            if (r4 == 0) goto L76
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r3.next()
            t5.l[] r4 = (t5.l[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3d
            float r2 = (float) r2
            float r7 = r7.d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3d:
            r4 = r4[r5]
            if (r4 == 0) goto L23
            float r4 = r4.d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L23
        L4b:
            int r2 = r2 + 5
            goto L7
        L4e:
            r0.add(r3)
            if (r8 == 0) goto L76
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L67
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L63:
            int r2 = (int) r2
            r3 = r4
            r4 = 1
            goto L9
        L67:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L63
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.a.b(boolean, z5.b):java.util.List");
    }

    public static b c(t5.b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException {
        z5.b b10 = bVar.b();
        List<l[]> b11 = b(z10, b10);
        if (b11.isEmpty()) {
            b10 = b10.clone();
            b10.n();
            b11 = b(z10, b10);
        }
        return new b(b10, b11);
    }

    public static int[] d(z5.b bVar, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bVar.e(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i15 = 0;
        int i16 = i10;
        while (i10 < i12) {
            if (bVar.e(i10, i11) ^ z11) {
                iArr2[i15] = iArr2[i15] + 1;
            } else {
                int i17 = length - 1;
                if (i15 != i17) {
                    i15++;
                } else {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i16, i10};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i18 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i17] = 0;
                    i15--;
                }
                iArr2[i15] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i15 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i16, i10 - 1};
    }

    public static l[] e(z5.b bVar, int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z10;
        int i15;
        int i16;
        l[] lVarArr = new l[4];
        int[] iArr2 = new int[iArr.length];
        int i17 = i12;
        while (true) {
            if (i17 >= i10) {
                z10 = false;
                break;
            }
            int[] d10 = d(bVar, i13, i17, i11, false, iArr, iArr2);
            if (d10 != null) {
                int i18 = i17;
                int[] iArr3 = d10;
                while (i18 > 0) {
                    int i19 = i18 - 1;
                    int[] d11 = d(bVar, i13, i19, i11, false, iArr, iArr2);
                    if (d11 == null) {
                        break;
                    }
                    iArr3 = d11;
                    i18 = i19;
                }
                float f10 = i18;
                lVarArr[0] = new l(iArr3[0], f10);
                lVarArr[1] = new l(iArr3[1], f10);
                i17 = i18;
                z10 = true;
            } else {
                i17 += 5;
            }
        }
        int i20 = i17 + 1;
        if (z10) {
            int[] iArr4 = {(int) lVarArr[0].c(), (int) lVarArr[1].c()};
            int i21 = i20;
            int i22 = 0;
            while (true) {
                if (i21 >= i10) {
                    i15 = i22;
                    i16 = i21;
                    break;
                }
                i15 = i22;
                i16 = i21;
                int[] d12 = d(bVar, iArr4[0], i21, i11, false, iArr, iArr2);
                if (d12 != null && Math.abs(iArr4[0] - d12[0]) < 5 && Math.abs(iArr4[1] - d12[1]) < 5) {
                    iArr4 = d12;
                    i22 = 0;
                } else {
                    if (i15 > 25) {
                        break;
                    }
                    i22 = i15 + 1;
                }
                i21 = i16 + 1;
            }
            i20 = i16 - (i15 + 1);
            float f11 = i20;
            lVarArr[2] = new l(iArr4[0], f11);
            lVarArr[3] = new l(iArr4[1], f11);
        }
        if (i20 - i17 < 10) {
            for (i14 = 0; i14 < 4; i14++) {
                lVarArr[i14] = null;
            }
        }
        return lVarArr;
    }

    public static l[] f(z5.b bVar, int i10, int i11) {
        int h10 = bVar.h();
        int l10 = bVar.l();
        l[] lVarArr = new l[8];
        a(lVarArr, e(bVar, h10, l10, i10, i11, f29947e), f29943a);
        l lVar = lVarArr[4];
        if (lVar != null) {
            i11 = (int) lVar.c();
            i10 = (int) lVarArr[4].d();
        }
        a(lVarArr, e(bVar, h10, l10, i10, i11, f29948f), f29944b);
        return lVarArr;
    }

    public static float g(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }
}
