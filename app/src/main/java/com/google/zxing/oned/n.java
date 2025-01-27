package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class n extends r {

    /* renamed from: a */
    private static final int[] f8588a = {1, 1, 1, 1};

    /* renamed from: b */
    private static final int[] f8589b = {3, 1, 1};

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int c2 = r.c(zArr, 0, f8588a, true);
        for (int i2 = 0; i2 < length; i2 += 2) {
            int digit = Character.digit(str.charAt(i2), 10);
            int digit2 = Character.digit(str.charAt(i2 + 1), 10);
            int[] iArr = new int[18];
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                int[][] iArr2 = m.f8586h;
                iArr[i4] = iArr2[digit][i3];
                iArr[i4 + 1] = iArr2[digit2][i3];
            }
            c2 += r.c(zArr, c2, iArr, true);
        }
        r.c(zArr, c2, f8589b, true);
        return zArr;
    }
}
