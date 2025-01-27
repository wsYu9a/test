package com.google.zxing.o;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.n;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements n {

    /* renamed from: a */
    private static final Charset f8460a = Charset.forName("ISO-8859-1");

    private static com.google.zxing.common.b c(String str, BarcodeFormat barcodeFormat, int i2, int i3, Charset charset, int i4, int i5) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return d(com.google.zxing.o.e.c.e(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static com.google.zxing.common.b d(com.google.zxing.o.e.a aVar, int i2, int i3) {
        com.google.zxing.common.b c2 = aVar.c();
        if (c2 == null) {
            throw new IllegalStateException();
        }
        int l = c2.l();
        int h2 = c2.h();
        int max = Math.max(i2, l);
        int max2 = Math.max(i3, h2);
        int min = Math.min(max / l, max2 / h2);
        int i4 = (max - (l * min)) / 2;
        int i5 = (max2 - (h2 * min)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(max, max2);
        int i6 = 0;
        while (i6 < h2) {
            int i7 = i4;
            int i8 = 0;
            while (i8 < l) {
                if (c2.e(i8, i6)) {
                    bVar.p(i7, i5, min, min);
                }
                i8++;
                i7 += min;
            }
            i6++;
            i5 += min;
        }
        return bVar;
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charset2 = f8460a;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset2 = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int parseInt = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charset2;
                i4 = parseInt;
                i5 = Integer.parseInt(map.get(encodeHintType3).toString());
                return c(str, barcodeFormat, i2, i3, charset, i4, i5);
            }
            charset = charset2;
            i4 = parseInt;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i5 = 0;
        return c(str, barcodeFormat, i2, i3, charset, i4, i5);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
