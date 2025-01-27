package j6;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class c extends q {

    /* renamed from: a */
    public static final int[][] f27178a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b */
    public static final float f27179b = 0.25f;

    /* renamed from: c */
    public static final float f27180c = 0.7f;

    /* renamed from: d */
    public static final int f27181d = 98;

    /* renamed from: e */
    public static final int f27182e = 99;

    /* renamed from: f */
    public static final int f27183f = 100;

    /* renamed from: g */
    public static final int f27184g = 101;

    /* renamed from: h */
    public static final int f27185h = 102;

    /* renamed from: i */
    public static final int f27186i = 97;

    /* renamed from: j */
    public static final int f27187j = 96;

    /* renamed from: k */
    public static final int f27188k = 101;

    /* renamed from: l */
    public static final int f27189l = 100;

    /* renamed from: m */
    public static final int f27190m = 103;

    /* renamed from: n */
    public static final int f27191n = 104;

    /* renamed from: o */
    public static final int f27192o = 105;

    /* renamed from: p */
    public static final int f27193p = 106;

    public static int h(z5.a aVar, int[] iArr, int i10) throws NotFoundException {
        q.f(aVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f27178a;
            if (i12 >= iArr2.length) {
                break;
            }
            float e10 = q.e(iArr, iArr2[i12], 0.7f);
            if (e10 < f10) {
                i11 = i12;
                f10 = e10;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] i(z5.a aVar) throws NotFoundException {
        int l10 = aVar.l();
        int j10 = aVar.j(0);
        int[] iArr = new int[6];
        int i10 = j10;
        boolean z10 = false;
        int i11 = 0;
        while (j10 < l10) {
            if (aVar.h(j10) ^ z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    int i12 = -1;
                    float f10 = 0.25f;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float e10 = q.e(iArr, f27178a[i13], 0.7f);
                        if (e10 < f10) {
                            i12 = i13;
                            f10 = e10;
                        }
                    }
                    if (i12 >= 0 && aVar.n(Math.max(0, i10 - ((j10 - i10) / 2)), i10, false)) {
                        return new int[]{i10, j10, i12};
                    }
                    i10 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            j10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
    
        if (r3 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e3, code lost:
    
        r2 = false;
        r3 = false;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x013a, code lost:
    
        if (r3 != false) goto L353;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ec A[LOOP:2: B:129:0x01ea->B:130:0x01ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f1 A[PHI: r21
  0x00f1: PHI (r21v10 boolean) = (r21v6 boolean), (r21v16 boolean) binds: [B:79:0x0119, B:51:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa A[PHI: r16 r21
  0x00fa: PHI (r16v4 boolean) = 
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v3 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
 binds: [B:79:0x0119, B:80:0x011d, B:84:0x0129, B:83:0x0125, B:70:0x00fc, B:51:0x00c3, B:52:0x00c7, B:56:0x00d3, B:55:0x00cf] A[DONT_GENERATE, DONT_INLINE]
  0x00fa: PHI (r21v9 boolean) = 
  (r21v6 boolean)
  (r21v6 boolean)
  (r21v6 boolean)
  (r21v6 boolean)
  (r21v8 boolean)
  (r21v16 boolean)
  (r21v16 boolean)
  (r21v16 boolean)
  (r21v16 boolean)
 binds: [B:79:0x0119, B:80:0x011d, B:84:0x0129, B:83:0x0125, B:70:0x00fc, B:51:0x00c3, B:52:0x00c7, B:56:0x00d3, B:55:0x00cf] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // j6.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t5.k c(int r26, z5.a r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.c.c(int, z5.a, java.util.Map):t5.k");
    }
}
