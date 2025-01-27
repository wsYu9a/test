package com.google.zxing.t.e;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c */
    private static final float f8837c = 0.42f;

    /* renamed from: d */
    private static final float f8838d = 0.8f;

    /* renamed from: g */
    private static final int f8841g = 3;

    /* renamed from: h */
    private static final int f8842h = 5;

    /* renamed from: i */
    private static final int f8843i = 25;

    /* renamed from: j */
    private static final int f8844j = 5;
    private static final int k = 10;

    /* renamed from: a */
    private static final int[] f8835a = {0, 4, 1, 5};

    /* renamed from: b */
    private static final int[] f8836b = {6, 2, 7, 3};

    /* renamed from: e */
    private static final int[] f8839e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f */
    private static final int[] f8840f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private a() {
    }

    private static void a(l[] lVarArr, l[] lVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            lVarArr[iArr[i2]] = lVarArr2[i2];
        }
    }

    public static b b(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        com.google.zxing.common.b b2 = bVar.b();
        List<l[]> c2 = c(z, b2);
        if (c2.isEmpty()) {
            b2 = b2.clone();
            b2.n();
            c2 = c(z, b2);
        }
        return new b(b2, c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4.hasNext() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r5 = (com.google.zxing.l[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r5[1] == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r5[3] == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.zxing.l[]> c(boolean r8, com.google.zxing.common.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.h()
            if (r3 >= r6) goto L7c
            com.google.zxing.l[] r4 = f(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L52
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L52
            if (r5 == 0) goto L7c
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            com.google.zxing.l[] r5 = (com.google.zxing.l[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.d()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.d()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            goto L8
        L52:
            r0.add(r4)
            if (r8 == 0) goto L7c
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6a
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
            goto L78
        L6a:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
        L78:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.e.a.c(boolean, com.google.zxing.common.b):java.util.List");
    }

    private static int[] d(com.google.zxing.common.b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.e(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i7 = 0;
        int i8 = i2;
        while (i2 < i4) {
            if (bVar.e(i2, i3) ^ z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                int i9 = length - 1;
                if (i7 != i9) {
                    i7++;
                } else {
                    if (g(iArr2, iArr, f8838d) < f8837c) {
                        return new int[]{i8, i2};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i10 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i9] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i7 != length - 1 || g(iArr2, iArr, f8838d) >= f8837c) {
            return null;
        }
        return new int[]{i8, i2 - 1};
    }

    private static l[] e(com.google.zxing.common.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        l[] lVarArr = new l[4];
        int[] iArr2 = new int[iArr.length];
        int i10 = i4;
        while (true) {
            if (i10 >= i2) {
                z = false;
                break;
            }
            int[] d2 = d(bVar, i5, i10, i3, false, iArr, iArr2);
            if (d2 != null) {
                int i11 = i10;
                int[] iArr3 = d2;
                int i12 = i11;
                while (true) {
                    if (i12 <= 0) {
                        i9 = i12;
                        break;
                    }
                    int i13 = i12 - 1;
                    int[] d3 = d(bVar, i5, i13, i3, false, iArr, iArr2);
                    if (d3 == null) {
                        i9 = i13 + 1;
                        break;
                    }
                    iArr3 = d3;
                    i12 = i13;
                }
                float f2 = i9;
                lVarArr[0] = new l(iArr3[0], f2);
                lVarArr[1] = new l(iArr3[1], f2);
                i10 = i9;
                z = true;
            } else {
                i10 += 5;
            }
        }
        int i14 = i10 + 1;
        if (z) {
            int[] iArr4 = {(int) lVarArr[0].c(), (int) lVarArr[1].c()};
            int i15 = i14;
            int i16 = 0;
            while (true) {
                if (i15 >= i2) {
                    i7 = i16;
                    i8 = i15;
                    break;
                }
                i7 = i16;
                i8 = i15;
                int[] d4 = d(bVar, iArr4[0], i15, i3, false, iArr, iArr2);
                if (d4 != null && Math.abs(iArr4[0] - d4[0]) < 5 && Math.abs(iArr4[1] - d4[1]) < 5) {
                    iArr4 = d4;
                    i16 = 0;
                } else {
                    if (i7 > 25) {
                        break;
                    }
                    i16 = i7 + 1;
                }
                i15 = i8 + 1;
            }
            i14 = i8 - (i7 + 1);
            float f3 = i14;
            lVarArr[2] = new l(iArr4[0], f3);
            lVarArr[3] = new l(iArr4[1], f3);
        }
        if (i14 - i10 < 10) {
            for (i6 = 0; i6 < 4; i6++) {
                lVarArr[i6] = null;
            }
        }
        return lVarArr;
    }

    private static l[] f(com.google.zxing.common.b bVar, int i2, int i3) {
        int h2 = bVar.h();
        int l = bVar.l();
        l[] lVarArr = new l[8];
        a(lVarArr, e(bVar, h2, l, i2, i3, f8839e), f8835a);
        if (lVarArr[4] != null) {
            i3 = (int) lVarArr[4].c();
            i2 = (int) lVarArr[4].d();
        }
        a(lVarArr, e(bVar, h2, l, i2, i3, f8840f), f8836b);
        return lVarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
