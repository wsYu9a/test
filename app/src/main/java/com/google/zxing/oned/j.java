package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class j extends x {
    private final int[] k = new int[4];

    @Override // com.google.zxing.oned.x
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l = aVar.l();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < l; i3++) {
            sb.append((char) (x.j(aVar, iArr2, i2, x.f8644f) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = x.n(aVar, i2, true, x.f8642d)[1];
        for (int i6 = 0; i6 < 4 && i5 < l; i6++) {
            sb.append((char) (x.j(aVar, iArr2, i5, x.f8644f) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // com.google.zxing.oned.x
    BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
