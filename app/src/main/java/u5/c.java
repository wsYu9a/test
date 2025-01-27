package u5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.nio.charset.Charset;
import java.util.Map;
import t5.n;

/* loaded from: classes2.dex */
public final class c implements n {

    /* renamed from: a */
    public static final Charset f30945a = Charset.forName("ISO-8859-1");

    public static z5.b c(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return d(w5.c.e(str.getBytes(charset), i12, i13), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static z5.b d(w5.a aVar, int i10, int i11) {
        z5.b c10 = aVar.c();
        if (c10 == null) {
            throw new IllegalStateException();
        }
        int l10 = c10.l();
        int h10 = c10.h();
        int max = Math.max(i10, l10);
        int max2 = Math.max(i11, h10);
        int min = Math.min(max / l10, max2 / h10);
        int i12 = (max - (l10 * min)) / 2;
        int i13 = (max2 - (h10 * min)) / 2;
        z5.b bVar = new z5.b(max, max2);
        int i14 = 0;
        while (i14 < h10) {
            int i15 = i12;
            int i16 = 0;
            while (i16 < l10) {
                if (c10.e(i16, i14)) {
                    bVar.p(i15, i13, min, min);
                }
                i16++;
                i15 += min;
            }
            i14++;
            i13 += min;
        }
        return bVar;
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i12;
        int i13;
        Charset charset2 = f30945a;
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
                i12 = parseInt;
                i13 = Integer.parseInt(map.get(encodeHintType3).toString());
                return c(str, barcodeFormat, i10, i11, charset, i12, i13);
            }
            charset = charset2;
            i12 = parseInt;
        } else {
            charset = charset2;
            i12 = 33;
        }
        i13 = 0;
        return c(str, barcodeFormat, i10, i11, charset, i12, i13);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
