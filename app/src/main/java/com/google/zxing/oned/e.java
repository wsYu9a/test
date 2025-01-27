package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends r {
    private static void g(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) != 0) {
                i4 = 2;
            }
            iArr[i3] = i4;
        }
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        int i2 = length + 25;
        for (int i3 = 0; i3 < length; i3++) {
            int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3));
            if (indexOf < 0) {
                throw new IllegalArgumentException("Bad contents: " + str);
            }
            g(d.f8563c[indexOf], iArr);
            for (int i4 = 0; i4 < 9; i4++) {
                i2 += iArr[i4];
            }
        }
        boolean[] zArr = new boolean[i2];
        g(d.f8564d, iArr);
        int c2 = r.c(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int c3 = c2 + r.c(zArr, c2, iArr2, false);
        for (int i5 = 0; i5 < length; i5++) {
            g(d.f8563c["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i5))], iArr);
            int c4 = c3 + r.c(zArr, c3, iArr, true);
            c3 = c4 + r.c(zArr, c4, iArr2, false);
        }
        g(d.f8564d, iArr);
        r.c(zArr, c3, iArr, true);
        return zArr;
    }
}
