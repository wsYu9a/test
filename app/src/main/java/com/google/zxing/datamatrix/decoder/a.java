package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a */
    private final com.google.zxing.common.b f8366a;

    /* renamed from: b */
    private final com.google.zxing.common.b f8367b;

    /* renamed from: c */
    private final d f8368c;

    a(com.google.zxing.common.b bVar) throws FormatException {
        int h2 = bVar.h();
        if (h2 < 8 || h2 > 144 || (h2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.f8368c = j(bVar);
        com.google.zxing.common.b a2 = a(bVar);
        this.f8366a = a2;
        this.f8367b = new com.google.zxing.common.b(a2.l(), a2.h());
    }

    private com.google.zxing.common.b a(com.google.zxing.common.b bVar) {
        int f2 = this.f8368c.f();
        int e2 = this.f8368c.e();
        if (bVar.h() != f2) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int c2 = this.f8368c.c();
        int b2 = this.f8368c.b();
        int i2 = f2 / c2;
        int i3 = e2 / b2;
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i3 * b2, i2 * c2);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * c2;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 * b2;
                for (int i8 = 0; i8 < c2; i8++) {
                    int i9 = ((c2 + 2) * i4) + 1 + i8;
                    int i10 = i5 + i8;
                    for (int i11 = 0; i11 < b2; i11++) {
                        if (bVar.e(((b2 + 2) * i6) + 1 + i11, i9)) {
                            bVar2.o(i7 + i11, i10);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (h(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (h(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return h(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    private int e(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return h(1, i10, i2, i3) ? i11 | 1 : i11;
    }

    private int f(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (h(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return h(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int g(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    private boolean h(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f8367b.o(i3, i2);
        return this.f8366a.e(i3, i2);
    }

    private int i(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (h(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (h(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (h(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (h(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private static d j(com.google.zxing.common.b bVar) throws FormatException {
        return d.h(bVar.h(), bVar.l());
    }

    d b() {
        return this.f8368c;
    }

    byte[] c() throws FormatException {
        byte[] bArr = new byte[this.f8368c.g()];
        int h2 = this.f8366a.h();
        int l = this.f8366a.l();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = 4;
        while (true) {
            if (i4 == h2 && i2 == 0 && !z) {
                bArr[i3] = (byte) d(h2, l);
                i4 -= 2;
                i2 += 2;
                i3++;
                z = true;
            } else {
                int i5 = h2 - 2;
                if (i4 == i5 && i2 == 0 && (l & 3) != 0 && !z2) {
                    bArr[i3] = (byte) e(h2, l);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z2 = true;
                } else if (i4 == h2 + 4 && i2 == 2 && (l & 7) == 0 && !z3) {
                    bArr[i3] = (byte) f(h2, l);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i4 == i5 && i2 == 0 && (l & 7) == 4 && !z4) {
                    bArr[i3] = (byte) g(h2, l);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else {
                    do {
                        if (i4 < h2 && i2 >= 0 && !this.f8367b.e(i2, i4)) {
                            bArr[i3] = (byte) i(i4, i2, h2, l);
                            i3++;
                        }
                        i4 -= 2;
                        i2 += 2;
                        if (i4 < 0) {
                            break;
                        }
                    } while (i2 < l);
                    int i6 = i4 + 1;
                    int i7 = i2 + 3;
                    do {
                        if (i6 >= 0 && i7 < l && !this.f8367b.e(i7, i6)) {
                            bArr[i3] = (byte) i(i6, i7, h2, l);
                            i3++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= h2) {
                            break;
                        }
                    } while (i7 >= 0);
                    i4 = i6 + 3;
                    i2 = i7 + 1;
                }
            }
            if (i4 >= h2 && i2 >= l) {
                break;
            }
        }
        if (i3 == this.f8368c.g()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
