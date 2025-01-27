package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: h */
    private static final int f8314h = 3;

    /* renamed from: i */
    private static final int f8315i = 8;

    /* renamed from: j */
    private static final int f8316j = 7;
    private static final int k = 40;
    private static final int l = 24;
    private b m;

    public i(com.google.zxing.e eVar) {
        super(eVar);
    }

    private static int[][] i(byte[] bArr, int i2, int i3, int i4, int i5) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = (i7 * i4) + i10;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 255;
                while (i13 < 8) {
                    for (int i17 = 0; i17 < 8; i17++) {
                        int i18 = bArr[i12 + i17] & 255;
                        i14 += i18;
                        if (i18 < i16) {
                            i16 = i18;
                        }
                        if (i18 > i15) {
                            i15 = i18;
                        }
                    }
                    if (i15 - i16 > 24) {
                        while (true) {
                            i13++;
                            i12 += i4;
                            if (i13 < 8) {
                                for (int i19 = 0; i19 < 8; i19++) {
                                    i14 += bArr[i12 + i19] & 255;
                                }
                            }
                        }
                    }
                    i13++;
                    i12 += i4;
                }
                int i20 = i14 >> 6;
                if (i15 - i16 <= 24) {
                    i20 = i16 / 2;
                    if (i6 > 0 && i9 > 0) {
                        int i21 = i6 - 1;
                        int i22 = i9 - 1;
                        int i23 = ((iArr[i21][i9] + (iArr[i6][i22] * 2)) + iArr[i21][i22]) / 4;
                        if (i16 < i23) {
                            i20 = i23;
                        }
                        iArr[i6][i9] = i20;
                    }
                }
                iArr[i6][i9] = i20;
            }
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 <= i11) {
                    i11 = i10;
                }
                int k2 = k(i9, 2, i2 - 3);
                int k3 = k(i6, 2, i3 - 3);
                int i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++) {
                    int[] iArr2 = iArr[k3 + i13];
                    i12 += iArr2[k2 - 2] + iArr2[k2 - 1] + iArr2[k2] + iArr2[k2 + 1] + iArr2[k2 + 2];
                }
                l(bArr, i11, i7, i12 / 25, i4, bVar);
            }
        }
    }

    private static int k(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void l(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.o(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // com.google.zxing.common.g, com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.e eVar) {
        return new i(eVar);
    }

    @Override // com.google.zxing.common.g, com.google.zxing.a
    public b b() throws NotFoundException {
        b bVar = this.m;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.e e2 = e();
        int e3 = e2.e();
        int b2 = e2.b();
        if (e3 < 40 || b2 < 40) {
            this.m = super.b();
        } else {
            byte[] c2 = e2.c();
            int i2 = e3 >> 3;
            if ((e3 & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = b2 >> 3;
            if ((b2 & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] i6 = i(c2, i3, i5, e3, b2);
            b bVar2 = new b(e3, b2);
            j(c2, i3, i5, e3, b2, i6, bVar2);
            this.m = bVar2;
        }
        return this.m;
    }
}
