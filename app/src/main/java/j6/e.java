package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e extends r {
    public static void g(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        int i10 = length + 25;
        for (int i11 = 0; i11 < length; i11++) {
            int indexOf = d.f27194e.indexOf(str.charAt(i11));
            if (indexOf < 0) {
                throw new IllegalArgumentException("Bad contents: " + str);
            }
            g(d.f27196g[indexOf], iArr);
            for (int i12 = 0; i12 < 9; i12++) {
                i10 += iArr[i12];
            }
        }
        boolean[] zArr = new boolean[i10];
        g(d.f27197h, iArr);
        int c10 = r.c(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int c11 = c10 + r.c(zArr, c10, iArr2, false);
        for (int i13 = 0; i13 < length; i13++) {
            g(d.f27196g[d.f27194e.indexOf(str.charAt(i13))], iArr);
            int c12 = c11 + r.c(zArr, c11, iArr, true);
            c11 = c12 + r.c(zArr, c12, iArr2, false);
        }
        g(d.f27197h, iArr);
        r.c(zArr, c11, iArr, true);
        return zArr;
    }
}
