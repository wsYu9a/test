package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a */
    private final com.google.zxing.common.b f8746a;

    /* renamed from: b */
    private g f8747b;

    /* renamed from: c */
    private e f8748c;

    /* renamed from: d */
    private boolean f8749d;

    a(com.google.zxing.common.b bVar) throws FormatException {
        int h2 = bVar.h();
        if (h2 < 21 || (h2 & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f8746a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.f8749d ? this.f8746a.e(i3, i2) : this.f8746a.e(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    void b() {
        int i2 = 0;
        while (i2 < this.f8746a.l()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f8746a.h(); i4++) {
                if (this.f8746a.e(i2, i4) != this.f8746a.e(i4, i2)) {
                    this.f8746a.d(i4, i2);
                    this.f8746a.d(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    byte[] c() throws FormatException {
        e d2 = d();
        g e2 = e();
        DataMask dataMask = DataMask.values()[d2.c()];
        int h2 = this.f8746a.h();
        dataMask.unmaskBitMatrix(this.f8746a, h2);
        com.google.zxing.common.b a2 = e2.a();
        byte[] bArr = new byte[e2.h()];
        int i2 = h2 - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < h2; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!a2.e(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.f8746a.e(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == e2.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    e d() throws FormatException {
        e eVar = this.f8748c;
        if (eVar != null) {
            return eVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a2 = a(8, i5, a2);
        }
        int h2 = this.f8746a.h();
        int i6 = h2 - 7;
        for (int i7 = h2 - 1; i7 >= i6; i7--) {
            i2 = a(8, i7, i2);
        }
        for (int i8 = h2 - 8; i8 < h2; i8++) {
            i2 = a(i8, 8, i2);
        }
        e a3 = e.a(a2, i2);
        this.f8748c = a3;
        if (a3 != null) {
            return a3;
        }
        throw FormatException.getFormatInstance();
    }

    g e() throws FormatException {
        g gVar = this.f8747b;
        if (gVar != null) {
            return gVar;
        }
        int h2 = this.f8746a.h();
        int i2 = (h2 - 17) / 4;
        if (i2 <= 6) {
            return g.i(i2);
        }
        int i3 = h2 - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = h2 - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        g c2 = g.c(i5);
        if (c2 != null && c2.e() == h2) {
            this.f8747b = c2;
            return c2;
        }
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = h2 - 9; i9 >= i3; i9--) {
                i4 = a(i8, i9, i4);
            }
        }
        g c3 = g.c(i4);
        if (c3 == null || c3.e() != h2) {
            throw FormatException.getFormatInstance();
        }
        this.f8747b = c3;
        return c3;
    }

    void f() {
        if (this.f8748c == null) {
            return;
        }
        DataMask.values()[this.f8748c.c()].unmaskBitMatrix(this.f8746a, this.f8746a.h());
    }

    void g(boolean z) {
        this.f8747b = null;
        this.f8748c = null;
        this.f8749d = z;
    }
}
