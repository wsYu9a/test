package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public class g extends com.google.zxing.a {

    /* renamed from: b */
    private static final int f8307b = 5;

    /* renamed from: c */
    private static final int f8308c = 3;

    /* renamed from: d */
    private static final int f8309d = 32;

    /* renamed from: e */
    private static final byte[] f8310e = new byte[0];

    /* renamed from: f */
    private byte[] f8311f;

    /* renamed from: g */
    private final int[] f8312g;

    public g(com.google.zxing.e eVar) {
        super(eVar);
        this.f8311f = f8310e;
        this.f8312g = new int[32];
    }

    private static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i4 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }

    private void h(int i2) {
        if (this.f8311f.length < i2) {
            this.f8311f = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f8312g[i3] = 0;
        }
    }

    @Override // com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.e eVar) {
        return new g(eVar);
    }

    @Override // com.google.zxing.a
    public b b() throws NotFoundException {
        com.google.zxing.e e2 = e();
        int e3 = e2.e();
        int b2 = e2.b();
        b bVar = new b(e3, b2);
        h(e3);
        int[] iArr = this.f8312g;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] d2 = e2.d((b2 * i2) / 5, this.f8311f);
            int i3 = (e3 << 2) / 5;
            for (int i4 = e3 / 5; i4 < i3; i4++) {
                int i5 = (d2[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int g2 = g(iArr);
        byte[] c2 = e2.c();
        for (int i6 = 0; i6 < b2; i6++) {
            int i7 = i6 * e3;
            for (int i8 = 0; i8 < e3; i8++) {
                if ((c2[i7 + i8] & 255) < g2) {
                    bVar.o(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public a c(int i2, a aVar) throws NotFoundException {
        com.google.zxing.e e2 = e();
        int e3 = e2.e();
        if (aVar == null || aVar.l() < e3) {
            aVar = new a(e3);
        } else {
            aVar.d();
        }
        h(e3);
        byte[] d2 = e2.d(i2, this.f8311f);
        int[] iArr = this.f8312g;
        for (int i3 = 0; i3 < e3; i3++) {
            int i4 = (d2[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int g2 = g(iArr);
        if (e3 < 3) {
            for (int i5 = 0; i5 < e3; i5++) {
                if ((d2[i5] & 255) < g2) {
                    aVar.q(i5);
                }
            }
        } else {
            int i6 = 1;
            int i7 = d2[0] & 255;
            int i8 = d2[1] & 255;
            while (i6 < e3 - 1) {
                int i9 = i6 + 1;
                int i10 = d2[i9] & 255;
                if ((((i8 << 2) - i7) - i10) / 2 < g2) {
                    aVar.q(i6);
                }
                i7 = i8;
                i6 = i9;
                i8 = i10;
            }
        }
        return aVar;
    }
}
