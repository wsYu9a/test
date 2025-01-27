package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class i extends y {

    /* renamed from: a */
    private static final int f8575a = 95;

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (!x.i(str)) {
                throw new IllegalArgumentException("Contents do not pass checksum");
            }
            int i2 = h.k[Integer.parseInt(str.substring(0, 1))];
            boolean[] zArr = new boolean[95];
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
            int c3 = c2 + r.c(zArr, c2, x.f8642d, false);
            int i5 = 7;
            while (i5 <= 12) {
                int i6 = i5 + 1;
                c3 += r.c(zArr, c3, x.f8644f[Integer.parseInt(str.substring(i5, i6))], true);
                i5 = i6;
            }
            r.c(zArr, c3, x.f8641c, true);
            return zArr;
        } catch (FormatException unused) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
