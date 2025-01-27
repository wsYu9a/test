package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class k extends y {

    /* renamed from: a */
    private static final int f8576a = 67;

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        boolean[] zArr = new boolean[67];
        int c2 = r.c(zArr, 0, x.f8641c, true) + 0;
        int i2 = 0;
        while (i2 <= 3) {
            int i3 = i2 + 1;
            c2 += r.c(zArr, c2, x.f8644f[Integer.parseInt(str.substring(i2, i3))], false);
            i2 = i3;
        }
        int c3 = c2 + r.c(zArr, c2, x.f8642d, false);
        int i4 = 4;
        while (i4 <= 7) {
            int i5 = i4 + 1;
            c3 += r.c(zArr, c3, x.f8644f[Integer.parseInt(str.substring(i4, i5))], true);
            i4 = i5;
        }
        r.c(zArr, c3, x.f8641c, true);
        return zArr;
    }
}
