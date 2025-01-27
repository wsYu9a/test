package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import t6.d;
import t6.f;
import z5.b;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public final b f10613a;

    /* renamed from: b */
    public f f10614b;

    /* renamed from: c */
    public d f10615c;

    /* renamed from: d */
    public boolean f10616d;

    public a(b bVar) throws FormatException {
        int h10 = bVar.h();
        if (h10 < 21 || (h10 & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f10613a = bVar;
    }

    public final int a(int i10, int i11, int i12) {
        return this.f10616d ? this.f10613a.e(i11, i10) : this.f10613a.e(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public void b() {
        int i10 = 0;
        while (i10 < this.f10613a.l()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f10613a.h(); i12++) {
                if (this.f10613a.e(i10, i12) != this.f10613a.e(i12, i10)) {
                    this.f10613a.d(i12, i10);
                    this.f10613a.d(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] c() throws FormatException {
        d d10 = d();
        f e10 = e();
        DataMask dataMask = DataMask.values()[d10.c()];
        int h10 = this.f10613a.h();
        dataMask.unmaskBitMatrix(this.f10613a, h10);
        b a10 = e10.a();
        byte[] bArr = new byte[e10.h()];
        int i10 = h10 - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < h10; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!a10.e(i18, i16)) {
                        i13++;
                        i14 <<= 1;
                        if (this.f10613a.e(i18, i16)) {
                            i14 |= 1;
                        }
                        if (i13 == 8) {
                            bArr[i12] = (byte) i14;
                            i12++;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == e10.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public d d() throws FormatException {
        d dVar = this.f10615c;
        if (dVar != null) {
            return dVar;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 = a(i12, 8, i11);
        }
        int a10 = a(8, 7, a(8, 8, a(7, 8, i11)));
        for (int i13 = 5; i13 >= 0; i13--) {
            a10 = a(8, i13, a10);
        }
        int h10 = this.f10613a.h();
        int i14 = h10 - 7;
        for (int i15 = h10 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = h10 - 8; i16 < h10; i16++) {
            i10 = a(i16, 8, i10);
        }
        d a11 = d.a(a10, i10);
        this.f10615c = a11;
        if (a11 != null) {
            return a11;
        }
        throw FormatException.getFormatInstance();
    }

    public f e() throws FormatException {
        f fVar = this.f10614b;
        if (fVar != null) {
            return fVar;
        }
        int h10 = this.f10613a.h();
        int i10 = (h10 - 17) / 4;
        if (i10 <= 6) {
            return f.i(i10);
        }
        int i11 = h10 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = h10 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        f c10 = f.c(i13);
        if (c10 != null && c10.e() == h10) {
            this.f10614b = c10;
            return c10;
        }
        for (int i16 = 5; i16 >= 0; i16--) {
            for (int i17 = h10 - 9; i17 >= i11; i17--) {
                i12 = a(i16, i17, i12);
            }
        }
        f c11 = f.c(i12);
        if (c11 == null || c11.e() != h10) {
            throw FormatException.getFormatInstance();
        }
        this.f10614b = c11;
        return c11;
    }

    public void f() {
        if (this.f10615c == null) {
            return;
        }
        DataMask.values()[this.f10615c.c()].unmaskBitMatrix(this.f10613a, this.f10613a.h());
    }

    public void g(boolean z10) {
        this.f10614b = null;
        this.f10615c = null;
        this.f10616d = z10;
    }
}
