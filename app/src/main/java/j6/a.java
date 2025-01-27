package j6;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class a extends q {

    /* renamed from: d */
    public static final float f27163d = 2.0f;

    /* renamed from: e */
    public static final float f27164e = 1.5f;

    /* renamed from: i */
    public static final int f27168i = 3;

    /* renamed from: a */
    public final StringBuilder f27170a = new StringBuilder(20);

    /* renamed from: b */
    public int[] f27171b = new int[80];

    /* renamed from: c */
    public int f27172c = 0;

    /* renamed from: f */
    public static final String f27165f = "0123456789-$:/.+ABCD";

    /* renamed from: g */
    public static final char[] f27166g = f27165f.toCharArray();

    /* renamed from: h */
    public static final int[] f27167h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: j */
    public static final char[] f27169j = {'A', 'B', 'C', 'D'};

    public static boolean h(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        if (r7 >= (-1)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        r8 = r8 + r11.f27171b[r6 + r7];
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        if (r6 >= r11.f27172c) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        if (r4 < (r8 / 2)) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        m(r13);
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r4 >= r11.f27170a.length()) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        r5 = r11.f27170a;
        r5.setCharAt(r4, j6.a.f27166g[r5.charAt(r4)]);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        r4 = r11.f27170a.charAt(0);
        r5 = j6.a.f27169j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        if (h(r5, r4) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        r4 = r11.f27170a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        if (h(r5, r4.charAt(r4.length() - 1)) == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        if (r11.f27170a.length() <= 3) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (r14 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
    
        if (r14.containsKey(com.google.zxing.DecodeHintType.RETURN_CODABAR_START_END) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b8, code lost:
    
        r14 = 0;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (r14 >= r13) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        r4 = r4 + r11.f27171b[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c3, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c4, code lost:
    
        if (r13 >= r2) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
    
        r4 = r4 + r11.f27171b[r13];
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
    
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        return new t5.k(r11.f27170a.toString(), null, new t5.l[]{new t5.l(r14, r12), new t5.l(r4, r12)}, com.google.zxing.BarcodeFormat.CODABAR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
    
        r14 = r11.f27170a;
        r14.deleteCharAt(r14.length() - 1);
        r11.f27170a.deleteCharAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f2, code lost:
    
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f7, code lost:
    
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fc, code lost:
    
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        r2 = r2 + 7;
        r4 = r11.f27171b[r2];
        r7 = -8;
        r8 = 0;
     */
    @Override // j6.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t5.k c(int r12, z5.a r13, java.util.Map<com.google.zxing.DecodeHintType, ?> r14) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.a.c(int, z5.a, java.util.Map):t5.k");
    }

    public final void i(int i10) {
        int[] iArr = this.f27171b;
        int i11 = this.f27172c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f27172c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f27171b = iArr2;
        }
    }

    public final int j() throws NotFoundException {
        for (int i10 = 1; i10 < this.f27172c; i10 += 2) {
            int l10 = l(i10);
            if (l10 != -1 && h(f27169j, f27166g[l10])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f27171b[i12];
                }
                if (i10 == 1 || this.f27171b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void k(z5.a aVar) throws NotFoundException {
        int i10 = 0;
        this.f27172c = 0;
        int k10 = aVar.k(0);
        int l10 = aVar.l();
        if (k10 >= l10) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = true;
        while (k10 < l10) {
            if (aVar.h(k10) ^ z10) {
                i10++;
            } else {
                i(i10);
                z10 = !z10;
                i10 = 1;
            }
            k10++;
        }
        i(i10);
    }

    public final int l(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f27172c) {
            return -1;
        }
        int[] iArr = this.f27171b;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = f27167h;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    public final void m(int i10) throws NotFoundException {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f27170a.length() - 1;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            int i13 = f27167h[this.f27170a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) << 1);
                iArr[i15] = iArr[i15] + this.f27171b[i11 + i14];
                iArr2[i15] = iArr2[i15] + 1;
                i13 >>= 1;
            }
            if (i12 >= length) {
                break;
            }
            i11 += 8;
            i12++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i16 = 0; i16 < 2; i16++) {
            fArr2[i16] = 0.0f;
            int i17 = i16 + 2;
            int i18 = iArr[i17];
            int i19 = iArr2[i17];
            float f10 = ((iArr[i16] / iArr2[i16]) + (i18 / i19)) / 2.0f;
            fArr2[i17] = f10;
            fArr[i16] = f10;
            fArr[i17] = ((i18 * 2.0f) + 1.5f) / i19;
        }
        int i20 = i10;
        int i21 = 0;
        loop3: while (true) {
            int i22 = f27167h[this.f27170a.charAt(i21)];
            for (int i23 = 6; i23 >= 0; i23--) {
                int i24 = (i23 & 1) + ((i22 & 1) << 1);
                float f11 = this.f27171b[i20 + i23];
                if (f11 < fArr2[i24] || f11 > fArr[i24]) {
                    break loop3;
                }
                i22 >>= 1;
            }
            if (i21 >= length) {
                return;
            }
            i20 += 8;
            i21++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
