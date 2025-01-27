package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 extends y {

    /* renamed from: a */
    private static final int f8522a = 51;

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        int i2 = z.k[Integer.parseInt(str.substring(7, 8))];
        boolean[] zArr = new boolean[51];
        int c2 = r.c(zArr, 0, x.f8641c, true) + 0;
        int i3 = 1;
        while (i3 <= 6) {
            int i4 = i3 + 1;
            int parseInt = Integer.parseInt(str.substring(i3, i4));
            if (((i2 >> (6 - i3)) & 1) == 1) {
                parseInt += 10;
            }
            c2 += r.c(zArr, c2, x.f8645g[parseInt], false);
            i3 = i4;
        }
        r.c(zArr, c2, x.f8643e, false);
        return zArr;
    }
}
