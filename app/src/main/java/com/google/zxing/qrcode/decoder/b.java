package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.g;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private final int f8750a;

    /* renamed from: b */
    private final byte[] f8751b;

    private b(int i2, byte[] bArr) {
        this.f8750a = i2;
        this.f8751b = bArr;
    }

    static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != gVar.h()) {
            throw new IllegalArgumentException();
        }
        g.b f2 = gVar.f(errorCorrectionLevel);
        g.a[] a2 = f2.a();
        int i2 = 0;
        for (g.a aVar : a2) {
            i2 += aVar.a();
        }
        b[] bVarArr = new b[i2];
        int i3 = 0;
        for (g.a aVar2 : a2) {
            int i4 = 0;
            while (i4 < aVar2.a()) {
                int b2 = aVar2.b();
                bVarArr[i3] = new b(b2, new byte[f2.b() + b2]);
                i4++;
                i3++;
            }
        }
        int length = bVarArr[0].f8751b.length;
        int i5 = i2 - 1;
        while (i5 >= 0 && bVarArr[i5].f8751b.length != length) {
            i5--;
        }
        int i6 = i5 + 1;
        int b3 = length - f2.b();
        int i7 = 0;
        for (int i8 = 0; i8 < b3; i8++) {
            int i9 = 0;
            while (i9 < i3) {
                bVarArr[i9].f8751b[i8] = bArr[i7];
                i9++;
                i7++;
            }
        }
        int i10 = i6;
        while (i10 < i3) {
            bVarArr[i10].f8751b[b3] = bArr[i7];
            i10++;
            i7++;
        }
        int length2 = bVarArr[0].f8751b.length;
        while (b3 < length2) {
            int i11 = 0;
            while (i11 < i3) {
                bVarArr[i11].f8751b[i11 < i6 ? b3 : b3 + 1] = bArr[i7];
                i11++;
                i7++;
            }
            b3++;
        }
        return bVarArr;
    }

    byte[] a() {
        return this.f8751b;
    }

    int c() {
        return this.f8750a;
    }
}
