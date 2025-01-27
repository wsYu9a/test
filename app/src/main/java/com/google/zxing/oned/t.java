package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class t implements com.google.zxing.n {

    /* renamed from: a */
    private final i f8630a = new i();

    private static String c(String str) {
        int length = str.length();
        if (length == 11) {
            int i2 = 0;
            for (int i3 = 0; i3 < 11; i3++) {
                i2 += (str.charAt(i3) - '0') * (i3 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - i2) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return "0" + str;
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.f8630a.a(c(str), BarcodeFormat.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
