package d6;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public final z5.b f25261a;

    /* renamed from: b */
    public final z5.b f25262b;

    /* renamed from: c */
    public final d f25263c;

    public a(z5.b bVar) throws FormatException {
        int h10 = bVar.h();
        if (h10 < 8 || h10 > 144 || (h10 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.f25263c = j(bVar);
        z5.b a10 = a(bVar);
        this.f25261a = a10;
        this.f25262b = new z5.b(a10.l(), a10.h());
    }

    public static d j(z5.b bVar) throws FormatException {
        return d.h(bVar.h(), bVar.l());
    }

    public final z5.b a(z5.b bVar) {
        int f10 = this.f25263c.f();
        int e10 = this.f25263c.e();
        if (bVar.h() != f10) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int c10 = this.f25263c.c();
        int b10 = this.f25263c.b();
        int i10 = f10 / c10;
        int i11 = e10 / b10;
        z5.b bVar2 = new z5.b(i11 * b10, i10 * c10);
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 * c10;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = i14 * b10;
                for (int i16 = 0; i16 < c10; i16++) {
                    int i17 = ((c10 + 2) * i12) + 1 + i16;
                    int i18 = i13 + i16;
                    for (int i19 = 0; i19 < b10; i19++) {
                        if (bVar.e(((b10 + 2) * i14) + 1 + i19, i17)) {
                            bVar2.o(i15 + i19, i18);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    public d b() {
        return this.f25263c;
    }

    public byte[] c() throws FormatException {
        byte[] bArr = new byte[this.f25263c.g()];
        int h10 = this.f25261a.h();
        int l10 = this.f25261a.l();
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i12 = 4;
        while (true) {
            if (i12 == h10 && i10 == 0 && !z10) {
                bArr[i11] = (byte) d(h10, l10);
                i12 -= 2;
                i10 += 2;
                i11++;
                z10 = true;
            } else {
                int i13 = h10 - 2;
                if (i12 == i13 && i10 == 0 && (l10 & 3) != 0 && !z11) {
                    bArr[i11] = (byte) e(h10, l10);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z11 = true;
                } else if (i12 == h10 + 4 && i10 == 2 && (l10 & 7) == 0 && !z12) {
                    bArr[i11] = (byte) f(h10, l10);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z12 = true;
                } else if (i12 == i13 && i10 == 0 && (l10 & 7) == 4 && !z13) {
                    bArr[i11] = (byte) g(h10, l10);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z13 = true;
                } else {
                    while (true) {
                        if (i12 < h10 && i10 >= 0 && !this.f25262b.e(i10, i12)) {
                            bArr[i11] = (byte) i(i12, i10, h10, l10);
                            i11++;
                        }
                        int i14 = i12 - 2;
                        int i15 = i10 + 2;
                        if (i14 < 0 || i15 >= l10) {
                            break;
                        }
                        i12 = i14;
                        i10 = i15;
                    }
                    int i16 = i12 - 1;
                    int i17 = i10 + 5;
                    while (true) {
                        if (i16 >= 0 && i17 < l10 && !this.f25262b.e(i17, i16)) {
                            bArr[i11] = (byte) i(i16, i17, h10, l10);
                            i11++;
                        }
                        int i18 = i16 + 2;
                        int i19 = i17 - 2;
                        if (i18 >= h10 || i19 < 0) {
                            break;
                        }
                        i16 = i18;
                        i17 = i19;
                    }
                    i12 = i16 + 5;
                    i10 = i17 - 1;
                }
            }
            if (i12 >= h10 && i10 >= l10) {
                break;
            }
        }
        if (i11 == this.f25263c.g()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public final int d(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (h(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (h(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (h(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (h(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return h(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    public final int e(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return h(1, i18, i10, i11) ? i19 | 1 : i19;
    }

    public final int f(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (h(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (h(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (h(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return h(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    public final int g(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (h(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return h(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    public final boolean h(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        this.f25262b.o(i11, i10);
        return this.f25261a.e(i11, i10);
    }

    public final int i(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (h(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (h(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (h(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (h(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (h(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (h(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return h(i10, i11, i12, i13) ? i24 | 1 : i24;
    }
}
