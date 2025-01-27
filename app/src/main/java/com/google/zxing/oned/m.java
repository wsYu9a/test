package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: a */
    private static final float f8579a = 0.38f;

    /* renamed from: b */
    private static final float f8580b = 0.78f;

    /* renamed from: c */
    private static final int f8581c = 3;

    /* renamed from: d */
    private static final int f8582d = 1;

    /* renamed from: e */
    private static final int[] f8583e = {6, 8, 10, 12, 14};

    /* renamed from: f */
    private static final int[] f8584f = {1, 1, 1, 1};

    /* renamed from: g */
    private static final int[] f8585g = {1, 1, 3};

    /* renamed from: h */
    static final int[][] f8586h = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: i */
    private int f8587i = -1;

    private static int h(int[] iArr) throws NotFoundException {
        int length = f8586h.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float e2 = q.e(iArr, f8586h[i3], f8580b);
            if (e2 < f2) {
                i2 = i3;
                f2 = e2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] i(com.google.zxing.common.a aVar) throws NotFoundException {
        aVar.p();
        try {
            int[] l = l(aVar, m(aVar), f8585g);
            n(aVar, l[0]);
            int i2 = l[0];
            l[0] = aVar.l() - l[1];
            l[1] = aVar.l() - i2;
            return l;
        } finally {
            aVar.p();
        }
    }

    private static void j(com.google.zxing.common.a aVar, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            q.f(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] k(com.google.zxing.common.a aVar) throws NotFoundException {
        int[] l = l(aVar, m(aVar), f8584f);
        this.f8587i = (l[1] - l[0]) / 4;
        n(aVar, l[0]);
        return l;
    }

    private static int[] l(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int l = aVar.l();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < l) {
            if (aVar.h(i2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (q.e(iArr2, iArr, f8580b) < 0.38f) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int m(com.google.zxing.common.a aVar) throws NotFoundException {
        int l = aVar.l();
        int j2 = aVar.j(0);
        if (j2 != l) {
            return j2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n(com.google.zxing.common.a r3, int r4) throws com.google.zxing.NotFoundException {
        /*
            r2 = this;
            int r0 = r2.f8587i
            int r0 = r0 * 10
            if (r0 >= r4) goto L7
            goto L8
        L7:
            r0 = r4
        L8:
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L19
            if (r4 < 0) goto L19
            boolean r1 = r3.h(r4)
            if (r1 != 0) goto L19
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L19:
            if (r0 != 0) goto L1c
            return
        L1c:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.getNotFoundInstance()
            goto L22
        L21:
            throw r3
        L22:
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.m.n(com.google.zxing.common.a, int):void");
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] k = k(aVar);
        int[] i3 = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, k[1], i3[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f8583e;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length2) {
                z = false;
                break;
            }
            int i6 = iArr[i4];
            if (length == i6) {
                z = true;
                break;
            }
            if (i6 > i5) {
                i5 = i6;
            }
            i4++;
        }
        if (!z && length > i5) {
            z = true;
        }
        if (!z) {
            throw FormatException.getFormatInstance();
        }
        float f2 = i2;
        return new com.google.zxing.k(sb2, null, new com.google.zxing.l[]{new com.google.zxing.l(k[1], f2), new com.google.zxing.l(i3[0], f2)}, BarcodeFormat.ITF);
    }
}
