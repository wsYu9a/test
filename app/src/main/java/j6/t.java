package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class t implements t5.n {

    /* renamed from: a */
    public final i f27229a = new i();

    public static String c(String str) {
        int length = str.length();
        if (length == 11) {
            int i10 = 0;
            for (int i11 = 0; i11 < 11; i11++) {
                i10 += (str.charAt(i11) - '0') * (i11 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - i10) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return "0" + str;
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.f27229a.a(c(str), BarcodeFormat.EAN_13, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
