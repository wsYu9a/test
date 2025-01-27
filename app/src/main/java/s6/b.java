package s6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;
import t5.n;
import v6.c;
import v6.f;

/* loaded from: classes2.dex */
public final class b implements n {

    /* renamed from: a */
    public static final int f30604a = 4;

    public static z5.b c(f fVar, int i10, int i11, int i12) {
        v6.b c10 = fVar.c();
        if (c10 == null) {
            throw new IllegalStateException();
        }
        int e10 = c10.e();
        int d10 = c10.d();
        int i13 = i12 << 1;
        int i14 = e10 + i13;
        int i15 = i13 + d10;
        int max = Math.max(i10, i14);
        int max2 = Math.max(i11, i15);
        int min = Math.min(max / i14, max2 / i15);
        int i16 = (max - (e10 * min)) / 2;
        int i17 = (max2 - (d10 * min)) / 2;
        z5.b bVar = new z5.b(max, max2);
        int i18 = 0;
        while (i18 < d10) {
            int i19 = i16;
            int i20 = 0;
            while (i20 < e10) {
                if (c10.b(i20, i18) == 1) {
                    bVar.p(i19, i17, min, min);
                }
                i20++;
                i19 += min;
            }
            i18++;
            i17 += min;
        }
        return bVar;
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int i12 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i12 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return c(c.p(str, errorCorrectionLevel, map), i10, i11, i12);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
