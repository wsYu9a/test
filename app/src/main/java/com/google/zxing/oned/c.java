package com.google.zxing.oned;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class c extends q {

    /* renamed from: a */
    static final int[][] f8551a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b */
    private static final float f8552b = 0.25f;

    /* renamed from: c */
    private static final float f8553c = 0.7f;

    /* renamed from: d */
    private static final int f8554d = 98;

    /* renamed from: e */
    private static final int f8555e = 99;

    /* renamed from: f */
    private static final int f8556f = 100;

    /* renamed from: g */
    private static final int f8557g = 101;

    /* renamed from: h */
    private static final int f8558h = 102;

    /* renamed from: i */
    private static final int f8559i = 97;

    /* renamed from: j */
    private static final int f8560j = 96;
    private static final int k = 101;
    private static final int l = 100;
    private static final int m = 103;
    private static final int n = 104;
    private static final int o = 105;
    private static final int p = 106;

    private static int h(com.google.zxing.common.a aVar, int[] iArr, int i2) throws NotFoundException {
        q.f(aVar, i2, iArr);
        float f2 = f8552b;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f8551a;
            if (i4 >= iArr2.length) {
                break;
            }
            float e2 = q.e(iArr, iArr2[i4], f8553c);
            if (e2 < f2) {
                i3 = i4;
                f2 = e2;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] i(com.google.zxing.common.a aVar) throws NotFoundException {
        int l2 = aVar.l();
        int j2 = aVar.j(0);
        int[] iArr = new int[6];
        int i2 = j2;
        boolean z = false;
        int i3 = 0;
        while (j2 < l2) {
            if (aVar.h(j2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    float f2 = f8552b;
                    int i4 = -1;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float e2 = q.e(iArr, f8551a[i5], f8553c);
                        if (e2 < f2) {
                            i4 = i5;
                            f2 = e2;
                        }
                    }
                    if (i4 >= 0 && aVar.n(Math.max(0, i2 - ((j2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, j2, i4};
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            j2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
    
        if (r9 != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0127, code lost:
    
        if (r9 != false) goto L227;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e A[PHI: r17
  0x012e: PHI (r17v10 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:78:0x0107, B:51:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013a A[PHI: r16 r17
  0x013a: PHI (r16v4 boolean) = 
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v3 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
 binds: [B:78:0x0107, B:79:0x010b, B:83:0x0117, B:82:0x0113, B:70:0x0138, B:51:0x00c1, B:52:0x00c6, B:56:0x00d3, B:55:0x00ce] A[DONT_GENERATE, DONT_INLINE]
  0x013a: PHI (r17v9 boolean) = 
  (r17v6 boolean)
  (r17v6 boolean)
  (r17v6 boolean)
  (r17v6 boolean)
  (r17v8 boolean)
  (r17v17 boolean)
  (r17v17 boolean)
  (r17v17 boolean)
  (r17v17 boolean)
 binds: [B:78:0x0107, B:79:0x010b, B:83:0x0117, B:82:0x0113, B:70:0x0138, B:51:0x00c1, B:52:0x00c6, B:56:0x00d3, B:55:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.k b(int r25, com.google.zxing.common.a r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.c.b(int, com.google.zxing.common.a, java.util.Map):com.google.zxing.k");
    }
}
