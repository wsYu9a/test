package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k extends y {

    /* renamed from: a */
    public static final int f27212a = 67;

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        boolean[] zArr = new boolean[67];
        int c10 = r.c(zArr, 0, x.f27240f, true);
        int i10 = 0;
        while (i10 <= 3) {
            int i11 = i10 + 1;
            c10 += r.c(zArr, c10, x.f27243i[Integer.parseInt(str.substring(i10, i11))], false);
            i10 = i11;
        }
        int c11 = c10 + r.c(zArr, c10, x.f27241g, false);
        int i12 = 4;
        while (i12 <= 7) {
            int i13 = i12 + 1;
            c11 += r.c(zArr, c11, x.f27243i[Integer.parseInt(str.substring(i12, i13))], true);
            i12 = i13;
        }
        r.c(zArr, c11, x.f27240f, true);
        return zArr;
    }
}
