package com.shu.priory.d;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f16891a = new byte[256];

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f16892b = new int[256];

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f16893c = new int[256];

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f16894d = new int[256];

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f16895e = new int[256];

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f16896f = new byte[256];

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f16897g = new int[256];

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f16898h = new int[256];

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f16899i = new int[256];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f16900j = new int[256];

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f16901k = new int[10];

    /* renamed from: l, reason: collision with root package name */
    private int f16902l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f16903m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f16904n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int[] f16905o = null;

    /* renamed from: p, reason: collision with root package name */
    private int[] f16906p = null;

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            int charAt = "捼睻\uf26b濅、末ﻗꭶ쪂쥽繁䟰귔ꊯ鲤狀럽錦㘿\uf7cc㒥\ue5f1燘ㄕӇ⏃ᢖ֚ܒ胢\ueb27뉵ঃⰚ᭮媠刻횳⧣⾄发í\u20fc녛櫋븹䩌壏탯\uaafb䍍㎅䗹ɿ值龨冣䂏銝㣵벶\uda21ჿ\uf3d2촌Ꮼ得䐗쒧總摝ᥳ悁俜∪邈䛮렔\ude5e\u0bdb\ue032㨊䤆\u245c싓걢醕\ue479\ue7c8㝭跕亩汖\uf4ea敺금멸┮Ღ듆\ue8dd琟䮽變瀾땦䠃\uf60e愵垹蛁ᶞ\ue1f8頑槙躔鬞蟩칕⣟財褍뿦䉨䆙ⴏ끔묖".charAt(i10 >>> 1);
            if ((i10 & 1) == 0) {
                charAt >>>= 8;
            }
            int i11 = ((byte) charAt) & 255;
            int i12 = i11 << 1;
            if (i12 >= 256) {
                i12 ^= 283;
            }
            int i13 = i12 ^ i11;
            int i14 = i10 << 1;
            if (i14 >= 256) {
                i14 ^= 283;
            }
            int i15 = i14 << 1;
            if (i15 >= 256) {
                i15 ^= 283;
            }
            int i16 = i15 << 1;
            if (i16 >= 256) {
                i16 ^= 283;
            }
            int i17 = i16 ^ i10;
            int i18 = i14 ^ (i15 ^ i16);
            f16891a[i10] = (byte) i11;
            int i19 = (i12 << 24) | (i11 << 16) | (i11 << 8) | i13;
            f16892b[i10] = i19;
            f16893c[i10] = (i19 >>> 8) | (i19 << 24);
            f16894d[i10] = (i19 >>> 16) | (i19 << 16);
            f16895e[i10] = (i19 << 8) | (i19 >>> 24);
            f16896f[i11] = (byte) i10;
            int i20 = (i18 << 24) | (i17 << 16) | ((i17 ^ i15) << 8) | (i17 ^ i14);
            f16897g[i11] = i20;
            f16898h[i11] = (i20 >>> 8) | (i20 << 24);
            f16899i[i11] = (i20 >>> 16) | (i20 << 16);
            f16900j[i11] = (i20 << 8) | (i20 >>> 24);
        }
        f16901k[0] = 16777216;
        int i21 = 1;
        for (int i22 = 1; i22 < 10; i22++) {
            i21 <<= 1;
            if (i21 >= 256) {
                i21 ^= 283;
            }
            f16901k[i22] = i21 << 24;
        }
    }

    public final void a(byte[] bArr) {
        int i10;
        this.f16903m = 8;
        int i11 = 8 + 6;
        this.f16902l = i11;
        int i12 = 4;
        int i13 = (i11 + 1) * 4;
        this.f16904n = i13;
        this.f16905o = new int[i13];
        this.f16906p = new int[i13];
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i10 = this.f16903m;
            if (i14 >= i10) {
                break;
            }
            this.f16905o[i14] = (bArr[i15] << b5.a.B) | ((bArr[i15 + 1] & 255) << 16) | ((bArr[i15 + 2] & 255) << 8) | (bArr[i15 + 3] & 255);
            i14++;
            i15 += 4;
        }
        int i16 = 0;
        int i17 = 0;
        while (i10 < this.f16904n) {
            int[] iArr = this.f16905o;
            int i18 = iArr[i10 - 1];
            if (i16 == 0) {
                i16 = this.f16903m;
                byte[] bArr2 = f16891a;
                i18 = ((bArr2[i18 >>> 24] & 255) | (((bArr2[(i18 >>> 16) & 255] << b5.a.B) | ((bArr2[(i18 >>> 8) & 255] & 255) << 16)) | ((bArr2[i18 & 255] & 255) << 8))) ^ f16901k[i17];
                i17++;
            } else if (this.f16903m == 8 && i16 == 4) {
                byte[] bArr3 = f16891a;
                i18 = (bArr3[i18 & 255] & 255) | (bArr3[i18 >>> 24] << b5.a.B) | ((bArr3[(i18 >>> 16) & 255] & 255) << 16) | ((bArr3[(i18 >>> 8) & 255] & 255) << 8);
            }
            iArr[i10] = i18 ^ iArr[i10 - this.f16903m];
            i10++;
            i16--;
        }
        int i19 = this.f16902l * 4;
        int[] iArr2 = this.f16906p;
        int[] iArr3 = this.f16905o;
        iArr2[0] = iArr3[i19];
        iArr2[1] = iArr3[i19 + 1];
        iArr2[2] = iArr3[i19 + 2];
        iArr2[3] = iArr3[i19 + 3];
        int i20 = i19 - 4;
        for (int i21 = 1; i21 < this.f16902l; i21++) {
            int[] iArr4 = this.f16905o;
            int i22 = iArr4[i20];
            int[] iArr5 = this.f16906p;
            int[] iArr6 = f16897g;
            byte[] bArr4 = f16891a;
            int i23 = iArr6[bArr4[i22 >>> 24] & 255];
            int[] iArr7 = f16898h;
            int i24 = i23 ^ iArr7[bArr4[(i22 >>> 16) & 255] & 255];
            int[] iArr8 = f16899i;
            int i25 = i24 ^ iArr8[bArr4[(i22 >>> 8) & 255] & 255];
            int[] iArr9 = f16900j;
            iArr5[i12] = iArr9[bArr4[i22 & 255] & 255] ^ i25;
            int i26 = iArr4[i20 + 1];
            iArr5[i12 + 1] = iArr9[bArr4[i26 & 255] & 255] ^ ((iArr6[bArr4[i26 >>> 24] & 255] ^ iArr7[bArr4[(i26 >>> 16) & 255] & 255]) ^ iArr8[bArr4[(i26 >>> 8) & 255] & 255]);
            int i27 = iArr4[i20 + 2];
            iArr5[i12 + 2] = iArr9[bArr4[i27 & 255] & 255] ^ ((iArr6[bArr4[i27 >>> 24] & 255] ^ iArr7[bArr4[(i27 >>> 16) & 255] & 255]) ^ iArr8[bArr4[(i27 >>> 8) & 255] & 255]);
            int i28 = iArr4[i20 + 3];
            iArr5[i12 + 3] = iArr9[bArr4[i28 & 255] & 255] ^ ((iArr6[bArr4[i28 >>> 24] & 255] ^ iArr7[bArr4[(i28 >>> 16) & 255] & 255]) ^ iArr8[bArr4[(i28 >>> 8) & 255] & 255]);
            i12 += 4;
            i20 -= 4;
        }
        int[] iArr10 = this.f16906p;
        int[] iArr11 = this.f16905o;
        iArr10[i12] = iArr11[i20];
        iArr10[i12 + 1] = iArr11[i20 + 1];
        iArr10[i12 + 2] = iArr11[i20 + 2];
        iArr10[i12 + 3] = iArr11[i20 + 3];
    }

    public final void finalize() {
        if (this.f16905o != null) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f16905o;
                if (i10 >= iArr.length) {
                    break;
                }
                iArr[i10] = 0;
                i10++;
            }
            this.f16905o = null;
        }
        if (this.f16906p == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            int[] iArr2 = this.f16906p;
            if (i11 >= iArr2.length) {
                this.f16906p = null;
                return;
            } else {
                iArr2[i11] = 0;
                i11++;
            }
        }
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        int i10 = (bArr[0] << b5.a.B) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr = this.f16906p;
        int i11 = i10 ^ iArr[0];
        int i12 = ((((bArr[4] << b5.a.B) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr[1];
        int i13 = ((((bArr[8] << b5.a.B) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr[2];
        int i14 = ((bArr[15] & 255) | (((bArr[14] & 255) << 8) | ((bArr[12] << b5.a.B) | ((bArr[13] & 255) << 16)))) ^ iArr[3];
        int i15 = 1;
        int i16 = 0;
        while (i15 < this.f16902l) {
            int i17 = i16 + 4;
            int[] iArr2 = f16897g;
            int i18 = iArr2[i11 >>> 24];
            int[] iArr3 = f16898h;
            int i19 = i18 ^ iArr3[(i14 >>> 16) & 255];
            int[] iArr4 = f16899i;
            int i20 = iArr4[(i13 >>> 8) & 255] ^ i19;
            int[] iArr5 = f16900j;
            int i21 = iArr5[i12 & 255] ^ i20;
            int[] iArr6 = this.f16906p;
            int i22 = i21 ^ iArr6[i17];
            int i23 = ((iArr4[(i14 >>> 8) & 255] ^ (iArr2[i12 >>> 24] ^ iArr3[(i11 >>> 16) & 255])) ^ iArr5[i13 & 255]) ^ iArr6[i16 + 5];
            int i24 = (((iArr3[(i12 >>> 16) & 255] ^ iArr2[i13 >>> 24]) ^ iArr4[(i11 >>> 8) & 255]) ^ iArr5[i14 & 255]) ^ iArr6[i16 + 6];
            i14 = iArr6[i16 + 7] ^ (iArr5[i11 & 255] ^ ((iArr2[i14 >>> 24] ^ iArr3[(i13 >>> 16) & 255]) ^ iArr4[(i12 >>> 8) & 255]));
            i15++;
            i13 = i24;
            i12 = i23;
            i11 = i22;
            i16 = i17;
        }
        int[] iArr7 = this.f16906p;
        int i25 = iArr7[i16 + 4];
        byte[] bArr3 = f16896f;
        bArr2[0] = (byte) (bArr3[i11 >>> 24] ^ (i25 >>> 24));
        bArr2[1] = (byte) (bArr3[(i14 >>> 16) & 255] ^ (i25 >>> 16));
        bArr2[2] = (byte) (bArr3[(i13 >>> 8) & 255] ^ (i25 >>> 8));
        bArr2[3] = (byte) (bArr3[i12 & 255] ^ i25);
        int i26 = iArr7[i16 + 5];
        bArr2[4] = (byte) (bArr3[i12 >>> 24] ^ (i26 >>> 24));
        bArr2[5] = (byte) (bArr3[(i11 >>> 16) & 255] ^ (i26 >>> 16));
        bArr2[6] = (byte) (bArr3[(i14 >>> 8) & 255] ^ (i26 >>> 8));
        bArr2[7] = (byte) (i26 ^ bArr3[i13 & 255]);
        int i27 = iArr7[i16 + 6];
        bArr2[8] = (byte) (bArr3[i13 >>> 24] ^ (i27 >>> 24));
        bArr2[9] = (byte) (bArr3[(i12 >>> 16) & 255] ^ (i27 >>> 16));
        bArr2[10] = (byte) (bArr3[(i11 >>> 8) & 255] ^ (i27 >>> 8));
        bArr2[11] = (byte) (i27 ^ bArr3[i14 & 255]);
        int i28 = iArr7[i16 + 7];
        bArr2[12] = (byte) (bArr3[i14 >>> 24] ^ (i28 >>> 24));
        bArr2[13] = (byte) (bArr3[(i13 >>> 16) & 255] ^ (i28 >>> 16));
        bArr2[14] = (byte) (bArr3[(i12 >>> 8) & 255] ^ (i28 >>> 8));
        bArr2[15] = (byte) (i28 ^ bArr3[i11 & 255]);
    }
}
