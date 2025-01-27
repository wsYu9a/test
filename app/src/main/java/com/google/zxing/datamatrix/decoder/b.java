package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.d;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private final int f8369a;

    /* renamed from: b */
    private final byte[] f8370b;

    private b(int i2, byte[] bArr) {
        this.f8369a = i2;
        this.f8370b = bArr;
    }

    static b[] b(byte[] bArr, d dVar) {
        d.c d2 = dVar.d();
        d.b[] a2 = d2.a();
        int i2 = 0;
        for (d.b bVar : a2) {
            i2 += bVar.a();
        }
        b[] bVarArr = new b[i2];
        int i3 = 0;
        for (d.b bVar2 : a2) {
            int i4 = 0;
            while (i4 < bVar2.a()) {
                int b2 = bVar2.b();
                bVarArr[i3] = new b(b2, new byte[d2.b() + b2]);
                i4++;
                i3++;
            }
        }
        int length = bVarArr[0].f8370b.length - d2.b();
        int i5 = length - 1;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = 0;
            while (i8 < i3) {
                bVarArr[i8].f8370b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        boolean z = dVar.i() == 24;
        int i9 = z ? 8 : i3;
        int i10 = 0;
        while (i10 < i9) {
            bVarArr[i10].f8370b[i5] = bArr[i6];
            i10++;
            i6++;
        }
        int length2 = bVarArr[0].f8370b.length;
        while (length < length2) {
            int i11 = 0;
            while (i11 < i3) {
                int i12 = z ? (i11 + 8) % i3 : i11;
                bVarArr[i12].f8370b[(!z || i12 <= 7) ? length : length - 1] = bArr[i6];
                i11++;
                i6++;
            }
            length++;
        }
        if (i6 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    byte[] a() {
        return this.f8370b;
    }

    int c() {
        return this.f8369a;
    }
}
