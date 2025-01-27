package com.google.zxing.o.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public static final int f8477a = 33;

    /* renamed from: b */
    public static final int f8478b = 0;

    /* renamed from: c */
    private static final int f8479c = 32;

    /* renamed from: d */
    private static final int f8480d = 4;

    /* renamed from: e */
    private static final int[] f8481e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int[] a(com.google.zxing.common.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int l = aVar.l() / i2;
        for (int i4 = 0; i4 < l; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= aVar.h((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static void b(com.google.zxing.common.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.o(i6, i5);
                    bVar.o(i6, i7);
                    bVar.o(i5, i6);
                    bVar.o(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.o(i8, i8);
        int i9 = i8 + 1;
        bVar.o(i9, i8);
        bVar.o(i8, i9);
        int i10 = i2 + i3;
        bVar.o(i10, i8);
        bVar.o(i10, i9);
        bVar.o(i10, i10 - 1);
    }

    private static void c(com.google.zxing.common.b bVar, boolean z, int i2, com.google.zxing.common.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.h(i4)) {
                    bVar.o(i5, i3 - 5);
                }
                if (aVar.h(i4 + 7)) {
                    bVar.o(i3 + 5, i5);
                }
                if (aVar.h(20 - i4)) {
                    bVar.o(i5, i3 + 5);
                }
                if (aVar.h(27 - i4)) {
                    bVar.o(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.h(i4)) {
                bVar.o(i6, i3 - 7);
            }
            if (aVar.h(i4 + 10)) {
                bVar.o(i3 + 7, i6);
            }
            if (aVar.h(29 - i4)) {
                bVar.o(i6, i3 + 7);
            }
            if (aVar.h(39 - i4)) {
                bVar.o(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static a d(byte[] bArr) {
        return e(bArr, 33, 0);
    }

    public static a e(byte[] bArr, int i2, int i3) {
        com.google.zxing.common.a aVar;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        com.google.zxing.common.a a2 = new d(bArr).a();
        int l = ((a2.l() * i2) / 100) + 11;
        int l2 = a2.l() + l;
        int i8 = 0;
        int i9 = 1;
        if (i3 == 0) {
            com.google.zxing.common.a aVar2 = null;
            int i10 = 0;
            int i11 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i12 = z2 ? i10 + 1 : i10;
                int j2 = j(i12, z2);
                if (l2 <= j2) {
                    int[] iArr = f8481e;
                    if (i11 != iArr[i12]) {
                        int i13 = iArr[i12];
                        i11 = i13;
                        aVar2 = i(a2, i13);
                    }
                    int i14 = j2 - (j2 % i11);
                    if ((!z2 || aVar2.l() <= (i11 << 6)) && aVar2.l() + l <= i14) {
                        aVar = aVar2;
                        i4 = i11;
                        z = z2;
                        i5 = i12;
                        i6 = j2;
                    }
                }
                i10++;
                i8 = 0;
                i9 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i3 < 0;
        i5 = Math.abs(i3);
        if (i5 > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        i6 = j(i5, z);
        i4 = f8481e[i5];
        int i15 = i6 - (i6 % i4);
        aVar = i(a2, i4);
        if (aVar.l() + l > i15) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && aVar.l() > (i4 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        com.google.zxing.common.a f2 = f(aVar, i6, i4);
        int l3 = aVar.l() / i4;
        com.google.zxing.common.a g2 = g(z, i5, l3);
        int i16 = (z ? 11 : 14) + (i5 << 2);
        int[] iArr2 = new int[i16];
        int i17 = 2;
        if (z) {
            for (int i18 = 0; i18 < i16; i18++) {
                iArr2[i18] = i18;
            }
            i7 = i16;
        } else {
            int i19 = i16 / 2;
            i7 = i16 + 1 + (((i19 - 1) / 15) * 2);
            int i20 = i7 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                iArr2[(i19 - i21) - i9] = (i20 - r14) - 1;
                iArr2[i19 + i21] = (i21 / 15) + i21 + i20 + i9;
            }
        }
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(i7);
        int i22 = 0;
        int i23 = 0;
        while (i22 < i5) {
            int i24 = ((i5 - i22) << i17) + (z ? 9 : 12);
            int i25 = 0;
            while (i25 < i24) {
                int i26 = i25 << 1;
                while (i8 < i17) {
                    if (f2.h(i23 + i26 + i8)) {
                        int i27 = i22 << 1;
                        bVar.o(iArr2[i27 + i8], iArr2[i27 + i25]);
                    }
                    if (f2.h((i24 << 1) + i23 + i26 + i8)) {
                        int i28 = i22 << 1;
                        bVar.o(iArr2[i28 + i25], iArr2[((i16 - 1) - i28) - i8]);
                    }
                    if (f2.h((i24 << 2) + i23 + i26 + i8)) {
                        int i29 = (i16 - 1) - (i22 << 1);
                        bVar.o(iArr2[i29 - i8], iArr2[i29 - i25]);
                    }
                    if (f2.h((i24 * 6) + i23 + i26 + i8)) {
                        int i30 = i22 << 1;
                        bVar.o(iArr2[((i16 - 1) - i30) - i25], iArr2[i30 + i8]);
                    }
                    i8++;
                    i17 = 2;
                }
                i25++;
                i8 = 0;
                i17 = 2;
            }
            i23 += i24 << 3;
            i22++;
            i8 = 0;
            i17 = 2;
        }
        c(bVar, z, i7, g2);
        if (z) {
            b(bVar, i7 / 2, 5);
        } else {
            int i31 = i7 / 2;
            b(bVar, i31, 7);
            int i32 = 0;
            int i33 = 0;
            while (i33 < (i16 / 2) - 1) {
                for (int i34 = i31 & 1; i34 < i7; i34 += 2) {
                    int i35 = i31 - i32;
                    bVar.o(i35, i34);
                    int i36 = i31 + i32;
                    bVar.o(i36, i34);
                    bVar.o(i34, i35);
                    bVar.o(i34, i36);
                }
                i33 += 15;
                i32 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.g(z);
        aVar3.j(i7);
        aVar3.h(i5);
        aVar3.f(l3);
        aVar3.i(bVar);
        return aVar3;
    }

    private static com.google.zxing.common.a f(com.google.zxing.common.a aVar, int i2, int i3) {
        int l = aVar.l() / i3;
        com.google.zxing.common.reedsolomon.d dVar = new com.google.zxing.common.reedsolomon.d(h(i3));
        int i4 = i2 / i3;
        int[] a2 = a(aVar, i3, i4);
        dVar.b(a2, i4 - l);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.c(0, i2 % i3);
        for (int i5 : a2) {
            aVar2.c(i5, i3);
        }
        return aVar2;
    }

    static com.google.zxing.common.a g(boolean z, int i2, int i3) {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (z) {
            aVar.c(i2 - 1, 2);
            aVar.c(i3 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i2 - 1, 5);
        aVar.c(i3 - 1, 11);
        return f(aVar, 40, 4);
    }

    private static com.google.zxing.common.reedsolomon.a h(int i2) {
        if (i2 == 4) {
            return com.google.zxing.common.reedsolomon.a.f8347d;
        }
        if (i2 == 6) {
            return com.google.zxing.common.reedsolomon.a.f8346c;
        }
        if (i2 == 8) {
            return com.google.zxing.common.reedsolomon.a.f8350g;
        }
        if (i2 == 10) {
            return com.google.zxing.common.reedsolomon.a.f8345b;
        }
        if (i2 == 12) {
            return com.google.zxing.common.reedsolomon.a.f8344a;
        }
        throw new IllegalArgumentException("Unsupported word size " + i2);
    }

    static com.google.zxing.common.a i(com.google.zxing.common.a aVar, int i2) {
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        int l = aVar.l();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < l) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= l || aVar.h(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                aVar2.c(i8, i2);
            } else if (i8 == 0) {
                aVar2.c(i5 | 1, i2);
            } else {
                aVar2.c(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return aVar2;
    }

    private static int j(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }
}
