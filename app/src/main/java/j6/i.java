package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class i extends y {

    /* renamed from: a */
    public static final int f27210a = 95;

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (!x.i(str)) {
                throw new IllegalArgumentException("Contents do not pass checksum");
            }
            int i10 = h.f27208l[Integer.parseInt(str.substring(0, 1))];
            boolean[] zArr = new boolean[95];
            int c10 = r.c(zArr, 0, x.f27240f, true);
            int i11 = 1;
            while (i11 <= 6) {
                int i12 = i11 + 1;
                int parseInt = Integer.parseInt(str.substring(i11, i12));
                if (((i10 >> (6 - i11)) & 1) == 1) {
                    parseInt += 10;
                }
                c10 += r.c(zArr, c10, x.f27244j[parseInt], false);
                i11 = i12;
            }
            int c11 = c10 + r.c(zArr, c10, x.f27241g, false);
            int i13 = 7;
            while (i13 <= 12) {
                int i14 = i13 + 1;
                c11 += r.c(zArr, c11, x.f27243i[Integer.parseInt(str.substring(i13, i14))], true);
                i13 = i14;
            }
            r.c(zArr, c11, x.f27240f, true);
            return zArr;
        } catch (FormatException unused) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
