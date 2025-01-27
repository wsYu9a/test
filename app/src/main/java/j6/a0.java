package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a0 extends y {

    /* renamed from: a */
    public static final int f27173a = 51;

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        int i10 = z.f27248l[Integer.parseInt(str.substring(7, 8))];
        boolean[] zArr = new boolean[51];
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
        r.c(zArr, c10, x.f27242h, false);
        return zArr;
    }
}
