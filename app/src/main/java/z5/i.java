package z5;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class i extends g {

    /* renamed from: i */
    public static final int f33675i = 3;

    /* renamed from: j */
    public static final int f33676j = 8;

    /* renamed from: k */
    public static final int f33677k = 7;

    /* renamed from: l */
    public static final int f33678l = 40;

    /* renamed from: m */
    public static final int f33679m = 24;

    /* renamed from: h */
    public b f33680h;

    public i(t5.e eVar) {
        super(eVar);
    }

    public static int[][] i(byte[] bArr, int i10, int i11, int i12, int i13) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, i10);
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 << 3;
            int i16 = i13 - 8;
            if (i15 > i16) {
                i15 = i16;
            }
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = i17 << 3;
                int i19 = i12 - 8;
                if (i18 > i19) {
                    i18 = i19;
                }
                int i20 = (i15 * i12) + i18;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 255;
                while (i21 < 8) {
                    for (int i25 = 0; i25 < 8; i25++) {
                        int i26 = bArr[i20 + i25] & 255;
                        i22 += i26;
                        if (i26 < i24) {
                            i24 = i26;
                        }
                        if (i26 > i23) {
                            i23 = i26;
                        }
                    }
                    if (i23 - i24 > 24) {
                        while (true) {
                            i21++;
                            i20 += i12;
                            if (i21 < 8) {
                                for (int i27 = 0; i27 < 8; i27++) {
                                    i22 += bArr[i20 + i27] & 255;
                                }
                            }
                        }
                    }
                    i21++;
                    i20 += i12;
                }
                int i28 = i22 >> 6;
                if (i23 - i24 <= 24) {
                    i28 = i24 / 2;
                    if (i14 > 0 && i17 > 0) {
                        int[] iArr2 = iArr[i14 - 1];
                        int i29 = i17 - 1;
                        int i30 = ((iArr2[i17] + (iArr[i14][i29] * 2)) + iArr2[i29]) / 4;
                        if (i24 < i30) {
                            i28 = i30;
                        }
                        iArr[i14][i17] = i28;
                    }
                }
                iArr[i14][i17] = i28;
            }
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, b bVar) {
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 << 3;
            int i16 = i13 - 8;
            if (i15 > i16) {
                i15 = i16;
            }
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = i17 << 3;
                int i19 = i12 - 8;
                if (i18 <= i19) {
                    i19 = i18;
                }
                int k10 = k(i17, 2, i10 - 3);
                int k11 = k(i14, 2, i11 - 3);
                int i20 = 0;
                for (int i21 = -2; i21 <= 2; i21++) {
                    int[] iArr2 = iArr[k11 + i21];
                    i20 += iArr2[k10 - 2] + iArr2[k10 - 1] + iArr2[k10] + iArr2[k10 + 1] + iArr2[k10 + 2];
                }
                l(bArr, i19, i15, i20 / 25, i12, bVar);
            }
        }
    }

    public static int k(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public static void l(byte[] bArr, int i10, int i11, int i12, int i13, b bVar) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bVar.o(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // z5.g, t5.a
    public t5.a a(t5.e eVar) {
        return new i(eVar);
    }

    @Override // z5.g, t5.a
    public b b() throws NotFoundException {
        b bVar = this.f33680h;
        if (bVar != null) {
            return bVar;
        }
        t5.e e10 = e();
        int e11 = e10.e();
        int b10 = e10.b();
        if (e11 < 40 || b10 < 40) {
            this.f33680h = super.b();
        } else {
            byte[] c10 = e10.c();
            int i10 = e11 >> 3;
            if ((e11 & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = b10 >> 3;
            if ((b10 & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] i14 = i(c10, i11, i13, e11, b10);
            b bVar2 = new b(e11, b10);
            j(c10, i11, i13, e11, b10, i14, bVar2);
            this.f33680h = bVar2;
        }
        return this.f33680h;
    }
}
