package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class h extends x {
    static final int[] k = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] l = new int[4];

    private static void r(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == k[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.x
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.l;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l = aVar.l();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < l; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f8645g);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        r(sb, i3);
        int i6 = x.n(aVar, i2, true, x.f8642d)[1];
        for (int i7 = 0; i7 < 6 && i6 < l; i7++) {
            sb.append((char) (x.j(aVar, iArr2, i6, x.f8644f) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // com.google.zxing.oned.x
    BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
