package com.google.zxing.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.n;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.u.c.c;
import com.google.zxing.u.c.f;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements n {

    /* renamed from: a */
    private static final int f8849a = 4;

    private static com.google.zxing.common.b c(f fVar, int i2, int i3, int i4) {
        com.google.zxing.u.c.b c2 = fVar.c();
        if (c2 == null) {
            throw new IllegalStateException();
        }
        int e2 = c2.e();
        int d2 = c2.d();
        int i5 = i4 << 1;
        int i6 = e2 + i5;
        int i7 = i5 + d2;
        int max = Math.max(i2, i6);
        int max2 = Math.max(i3, i7);
        int min = Math.min(max / i6, max2 / i7);
        int i8 = (max - (e2 * min)) / 2;
        int i9 = (max2 - (d2 * min)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(max, max2);
        int i10 = 0;
        while (i10 < d2) {
            int i11 = i8;
            int i12 = 0;
            while (i12 < e2) {
                if (c2.b(i12, i10) == 1) {
                    bVar.p(i11, i9, min, min);
                }
                i12++;
                i11 += min;
            }
            i10++;
            i9 += min;
        }
        return bVar;
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int i4 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i4 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return c(c.p(str, errorCorrectionLevel, map), i2, i3, i4);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
