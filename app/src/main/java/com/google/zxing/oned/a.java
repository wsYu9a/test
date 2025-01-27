package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends q {

    /* renamed from: a */
    private static final float f8512a = 2.0f;

    /* renamed from: b */
    private static final float f8513b = 1.5f;

    /* renamed from: f */
    private static final int f8517f = 3;

    /* renamed from: h */
    private final StringBuilder f8519h = new StringBuilder(20);

    /* renamed from: i */
    private int[] f8520i = new int[80];

    /* renamed from: j */
    private int f8521j = 0;

    /* renamed from: c */
    private static final String f8514c = "0123456789-$:/.+ABCD";

    /* renamed from: d */
    static final char[] f8515d = f8514c.toCharArray();

    /* renamed from: e */
    static final int[] f8516e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: g */
    private static final char[] f8518g = {'A', 'B', 'C', 'D'};

    static boolean h(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i2) {
        int[] iArr = this.f8520i;
        int i3 = this.f8521j;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.f8521j = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f8520i = iArr2;
        }
    }

    private int j() throws NotFoundException {
        for (int i2 = 1; i2 < this.f8521j; i2 += 2) {
            int l = l(i2);
            if (l != -1 && h(f8518g, f8515d[l])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f8520i[i4];
                }
                if (i2 == 1 || this.f8520i[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void k(com.google.zxing.common.a aVar) throws NotFoundException {
        int i2 = 0;
        this.f8521j = 0;
        int k = aVar.k(0);
        int l = aVar.l();
        if (k >= l) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = true;
        while (k < l) {
            if (aVar.h(k) ^ z) {
                i2++;
            } else {
                i(i2);
                z = !z;
                i2 = 1;
            }
            k++;
        }
        i(i2);
    }

    private int l(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f8521j) {
            return -1;
        }
        int[] iArr = this.f8520i;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f8516e;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ae, code lost:
    
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(int r15) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.a.m(int):void");
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.f8520i, 0);
        k(aVar);
        int j2 = j();
        this.f8519h.setLength(0);
        int i3 = j2;
        do {
            int l = l(i3);
            if (l == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.f8519h.append((char) l);
            i3 += 8;
            if (this.f8519h.length() > 1 && h(f8518g, f8515d[l])) {
                break;
            }
        } while (i3 < this.f8521j);
        int i4 = i3 - 1;
        int i5 = this.f8520i[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f8520i[i3 + i7];
        }
        if (i3 < this.f8521j && i5 < i6 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        m(j2);
        for (int i8 = 0; i8 < this.f8519h.length(); i8++) {
            StringBuilder sb = this.f8519h;
            sb.setCharAt(i8, f8515d[sb.charAt(i8)]);
        }
        char charAt = this.f8519h.charAt(0);
        char[] cArr = f8518g;
        if (!h(cArr, charAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f8519h;
        if (!h(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.f8519h.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f8519h;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f8519h.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < j2; i10++) {
            i9 += this.f8520i[i10];
        }
        float f2 = i9;
        while (j2 < i4) {
            i9 += this.f8520i[j2];
            j2++;
        }
        float f3 = i2;
        return new com.google.zxing.k(this.f8519h.toString(), null, new com.google.zxing.l[]{new com.google.zxing.l(f2, f3), new com.google.zxing.l(i9, f3)}, BarcodeFormat.CODABAR);
    }
}
