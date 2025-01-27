package w5;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public static final int f31576a = 33;

    /* renamed from: b */
    public static final int f31577b = 0;

    /* renamed from: c */
    public static final int f31578c = 32;

    /* renamed from: d */
    public static final int f31579d = 4;

    /* renamed from: e */
    public static final int[] f31580e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] a(z5.a aVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int l10 = aVar.l() / i10;
        for (int i12 = 0; i12 < l10; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= aVar.h((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    public static void b(z5.b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bVar.o(i14, i13);
                    bVar.o(i14, i15);
                    bVar.o(i13, i14);
                    bVar.o(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bVar.o(i16, i16);
        int i17 = i16 + 1;
        bVar.o(i17, i16);
        bVar.o(i16, i17);
        int i18 = i10 + i11;
        bVar.o(i18, i16);
        bVar.o(i18, i17);
        bVar.o(i18, i18 - 1);
    }

    public static void c(z5.b bVar, boolean z10, int i10, z5.a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.h(i12)) {
                    bVar.o(i13, i11 - 5);
                }
                if (aVar.h(i12 + 7)) {
                    bVar.o(i11 + 5, i13);
                }
                if (aVar.h(20 - i12)) {
                    bVar.o(i13, i11 + 5);
                }
                if (aVar.h(27 - i12)) {
                    bVar.o(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.h(i12)) {
                bVar.o(i14, i11 - 7);
            }
            if (aVar.h(i12 + 10)) {
                bVar.o(i11 + 7, i14);
            }
            if (aVar.h(29 - i12)) {
                bVar.o(i14, i11 + 7);
            }
            if (aVar.h(39 - i12)) {
                bVar.o(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(byte[] bArr) {
        return e(bArr, 33, 0);
    }

    public static a e(byte[] bArr, int i10, int i11) {
        int i12;
        z5.a aVar;
        boolean z10;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = 2;
        z5.a a10 = new d(bArr).a();
        int l10 = ((a10.l() * i10) / 100) + 11;
        int l11 = a10.l() + l10;
        int i20 = 0;
        int i21 = 1;
        if (i11 == 0) {
            z5.a aVar2 = null;
            int i22 = 0;
            int i23 = 0;
            while (i22 <= r6) {
                boolean z11 = i22 <= 3;
                int i24 = z11 ? i22 + 1 : i22;
                int j10 = j(i24, z11);
                if (l11 <= j10) {
                    int i25 = f31580e[i24];
                    if (i23 != i25) {
                        aVar2 = i(a10, i25);
                    } else {
                        i25 = i23;
                    }
                    int i26 = j10 - (j10 % i25);
                    if ((!z11 || aVar2.l() <= (i25 << 6)) && aVar2.l() + l10 <= i26) {
                        aVar = aVar2;
                        z10 = z11;
                        i13 = i24;
                        i14 = j10;
                        i15 = i25;
                    } else {
                        i23 = i25;
                        i12 = 1;
                    }
                } else {
                    i12 = 1;
                }
                i22 += i12;
                i19 = 2;
                r6 = 32;
                i20 = 0;
                i21 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z10 = i11 < 0;
        i13 = Math.abs(i11);
        if (i13 > (z10 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
        }
        i14 = j(i13, z10);
        i15 = f31580e[i13];
        int i27 = i14 - (i14 % i15);
        aVar = i(a10, i15);
        if (aVar.l() + l10 > i27) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z10 && aVar.l() > (i15 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        z5.a f10 = f(aVar, i14, i15);
        int l12 = aVar.l() / i15;
        z5.a g10 = g(z10, i13, l12);
        int i28 = (z10 ? 11 : 14) + (i13 << 2);
        int[] iArr = new int[i28];
        if (z10) {
            for (int i29 = 0; i29 < i28; i29 += i21) {
                iArr[i29] = i29;
            }
            i16 = i28;
        } else {
            int i30 = i28 / 2;
            i16 = i28 + 1 + (((i30 - 1) / 15) * 2);
            int i31 = i16 / 2;
            for (int i32 = 0; i32 < i30; i32 += i21) {
                iArr[(i30 - i32) - 1] = (i31 - r15) - 1;
                iArr[i30 + i32] = (i32 / 15) + i32 + i31 + i21;
            }
        }
        z5.b bVar = new z5.b(i16);
        int i33 = 0;
        int i34 = 0;
        while (i33 < i13) {
            int i35 = ((i13 - i33) << i19) + (z10 ? 9 : 12);
            while (i20 < i35) {
                int i36 = i20 << 1;
                int i37 = 0;
                while (i37 < i19) {
                    if (f10.h(i34 + i36 + i37)) {
                        int i38 = i33 << 1;
                        bVar.o(iArr[i38 + i37], iArr[i38 + i20]);
                    }
                    if (f10.h((i35 << 1) + i34 + i36 + i37)) {
                        int i39 = i33 << 1;
                        i17 = l12;
                        bVar.o(iArr[i39 + i20], iArr[((i28 - 1) - i39) - i37]);
                    } else {
                        i17 = l12;
                    }
                    if (f10.h((i35 << 2) + i34 + i36 + i37)) {
                        int i40 = (i28 - 1) - (i33 << 1);
                        bVar.o(iArr[i40 - i37], iArr[i40 - i20]);
                    }
                    if (f10.h((i35 * 6) + i34 + i36 + i37)) {
                        i18 = 1;
                        int i41 = i33 << 1;
                        bVar.o(iArr[((i28 - 1) - i41) - i20], iArr[i41 + i37]);
                    } else {
                        i18 = 1;
                    }
                    i37 += i18;
                    l12 = i17;
                    i19 = 2;
                }
                i20++;
                i19 = 2;
            }
            i34 += i35 << 3;
            i33++;
            l12 = l12;
            i19 = 2;
            i20 = 0;
        }
        int i42 = l12;
        c(bVar, z10, i16, g10);
        if (z10) {
            b(bVar, i16 / 2, 5);
        } else {
            int i43 = i16 / 2;
            b(bVar, i43, 7);
            int i44 = 0;
            int i45 = 0;
            while (i44 < (i28 / 2) - 1) {
                for (int i46 = i43 & 1; i46 < i16; i46 += 2) {
                    int i47 = i43 - i45;
                    bVar.o(i47, i46);
                    int i48 = i43 + i45;
                    bVar.o(i48, i46);
                    bVar.o(i46, i47);
                    bVar.o(i46, i48);
                }
                i44 += 15;
                i45 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.g(z10);
        aVar3.j(i16);
        aVar3.h(i13);
        aVar3.f(i42);
        aVar3.i(bVar);
        return aVar3;
    }

    public static z5.a f(z5.a aVar, int i10, int i11) {
        int l10 = aVar.l() / i11;
        b6.d dVar = new b6.d(h(i11));
        int i12 = i10 / i11;
        int[] a10 = a(aVar, i11, i12);
        dVar.b(a10, i12 - l10);
        z5.a aVar2 = new z5.a();
        aVar2.c(0, i10 % i11);
        for (int i13 : a10) {
            aVar2.c(i13, i11);
        }
        return aVar2;
    }

    public static z5.a g(boolean z10, int i10, int i11) {
        z5.a aVar = new z5.a();
        if (z10) {
            aVar.c(i10 - 1, 2);
            aVar.c(i11 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i10 - 1, 5);
        aVar.c(i11 - 1, 11);
        return f(aVar, 40, 4);
    }

    public static b6.a h(int i10) {
        if (i10 == 4) {
            return b6.a.f1287k;
        }
        if (i10 == 6) {
            return b6.a.f1286j;
        }
        if (i10 == 8) {
            return b6.a.f1290n;
        }
        if (i10 == 10) {
            return b6.a.f1285i;
        }
        if (i10 == 12) {
            return b6.a.f1284h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    public static z5.a i(z5.a aVar, int i10) {
        z5.a aVar2 = new z5.a();
        int l10 = aVar.l();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < l10) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= l10 || aVar.h(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                aVar2.c(i16, i10);
            } else if (i16 == 0) {
                aVar2.c(i13 | 1, i10);
            } else {
                aVar2.c(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return aVar2;
    }

    public static int j(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 << 4)) * i10;
    }
}
