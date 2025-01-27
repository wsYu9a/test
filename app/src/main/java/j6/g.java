package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public class g extends r {
    public static int c(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i10 + 1;
            zArr[i10] = iArr[i11] != 0;
            i11++;
            i10 = i12;
        }
        return 9;
    }

    public static int g(String str, int i10) {
        int i11 = 0;
        int i12 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i11 += f.f27202c.indexOf(str.charAt(length)) * i12;
            i12++;
            if (i12 > i10) {
                i12 = 1;
            }
        }
        return i11 % 47;
    }

    private static void h(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) == 0) {
                i12 = 0;
            }
            iArr[i11] = i12;
        }
    }

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[((str.length() + 4) * 9) + 1];
        h(f.f27204e[47], iArr);
        int c10 = c(zArr, 0, iArr, true);
        for (int i10 = 0; i10 < length; i10++) {
            h(f.f27204e[f.f27202c.indexOf(str.charAt(i10))], iArr);
            c10 += c(zArr, c10, iArr, true);
        }
        int g10 = g(str, 20);
        int[] iArr2 = f.f27204e;
        h(iArr2[g10], iArr);
        int c11 = c10 + c(zArr, c10, iArr, true);
        h(iArr2[g(str + f.f27202c.charAt(g10), 15)], iArr);
        int c12 = c11 + c(zArr, c11, iArr, true);
        h(iArr2[47], iArr);
        zArr[c12 + c(zArr, c12, iArr, true)] = true;
        return zArr;
    }
}
