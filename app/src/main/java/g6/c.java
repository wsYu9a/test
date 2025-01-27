package g6;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;
import z5.d;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b */
    public static final int f26174b = 0;

    /* renamed from: c */
    public static final int f26175c = 1;

    /* renamed from: d */
    public static final int f26176d = 2;

    /* renamed from: a */
    public final b6.c f26177a = new b6.c(b6.a.f1291o);

    public final void a(byte[] bArr, int i10, int i11, int i12, int i13) throws ChecksumException {
        int i14 = i11 + i12;
        int i15 = i13 == 0 ? 1 : 2;
        int[] iArr = new int[i14 / i15];
        for (int i16 = 0; i16 < i14; i16++) {
            if (i13 == 0 || i16 % 2 == i13 - 1) {
                iArr[i16 / i15] = bArr[i16 + i10] & 255;
            }
        }
        try {
            this.f26177a.a(iArr, i12 / i15);
            for (int i17 = 0; i17 < i11; i17++) {
                if (i13 == 0 || i17 % 2 == i13 - 1) {
                    bArr[i17 + i10] = (byte) iArr[i17 / i15];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public d b(z5.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public d c(z5.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] a10 = new a(bVar).a();
        a(a10, 0, 10, 10, 0);
        int i10 = a10[0] & 15;
        if (i10 == 2 || i10 == 3 || i10 == 4) {
            a(a10, 20, 84, 40, 1);
            a(a10, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i10 != 5) {
                throw FormatException.getFormatInstance();
            }
            a(a10, 20, 68, 56, 1);
            a(a10, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(a10, 0, bArr, 0, 10);
        System.arraycopy(a10, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i10);
    }
}
