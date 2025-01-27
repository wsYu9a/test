package d6;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.datamatrix.decoder.DecodedBitStreamParser;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final b6.c f25266a = new b6.c(b6.a.f1289m);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f25266a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public z5.d b(z5.b bVar) throws FormatException, ChecksumException {
        a aVar = new a(bVar);
        b[] b10 = b.b(aVar.c(), aVar.b());
        int i10 = 0;
        for (b bVar2 : b10) {
            i10 += bVar2.c();
        }
        byte[] bArr = new byte[i10];
        int length = b10.length;
        for (int i11 = 0; i11 < length; i11++) {
            b bVar3 = b10[i11];
            byte[] a10 = bVar3.a();
            int c10 = bVar3.c();
            a(a10, c10);
            for (int i12 = 0; i12 < c10; i12++) {
                bArr[(i12 * length) + i11] = a10[i12];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    public z5.d c(boolean[][] zArr) throws FormatException, ChecksumException {
        int length = zArr.length;
        z5.b bVar = new z5.b(length);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                if (zArr[i10][i11]) {
                    bVar.o(i11, i10);
                }
            }
        }
        return b(bVar);
    }
}
