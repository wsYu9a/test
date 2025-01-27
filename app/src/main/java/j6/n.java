package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n extends r {

    /* renamed from: a */
    public static final int[] f27224a = {1, 1, 1, 1};

    /* renamed from: b */
    public static final int[] f27225b = {3, 1, 1};

    @Override // j6.r, t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // j6.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int c10 = r.c(zArr, 0, f27224a, true);
        for (int i10 = 0; i10 < length; i10 += 2) {
            int digit = Character.digit(str.charAt(i10), 10);
            int digit2 = Character.digit(str.charAt(i10 + 1), 10);
            int[] iArr = new int[18];
            for (int i11 = 0; i11 < 5; i11++) {
                int i12 = i11 * 2;
                int[][] iArr2 = m.f27222i;
                iArr[i12] = iArr2[digit][i11];
                iArr[i12 + 1] = iArr2[digit2][i11];
            }
            c10 += r.c(zArr, c10, iArr, true);
        }
        r.c(zArr, c10, f27225b, true);
        return zArr;
    }
}
