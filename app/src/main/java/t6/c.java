package t6;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final b6.c f30733a = new b6.c(b6.a.f1288l);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f30733a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public final z5.d b(com.google.zxing.qrcode.decoder.a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        f e10 = aVar.e();
        ErrorCorrectionLevel d10 = aVar.d().d();
        a[] b10 = a.b(aVar.c(), e10, d10);
        int i10 = 0;
        for (a aVar2 : b10) {
            i10 += aVar2.c();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (a aVar3 : b10) {
            byte[] a10 = aVar3.a();
            int c10 = aVar3.c();
            a(a10, c10);
            int i12 = 0;
            while (i12 < c10) {
                bArr[i11] = a10[i12];
                i12++;
                i11++;
            }
        }
        return b.a(bArr, e10, d10, map);
    }

    public z5.d c(z5.b bVar) throws ChecksumException, FormatException {
        return d(bVar, null);
    }

    public z5.d d(z5.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e10;
        com.google.zxing.qrcode.decoder.a aVar = new com.google.zxing.qrcode.decoder.a(bVar);
        FormatException formatException = null;
        try {
            return b(aVar, map);
        } catch (ChecksumException e11) {
            e10 = e11;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                z5.d b10 = b(aVar, map);
                b10.o(new e(true));
                return b10;
            } catch (ChecksumException | FormatException e12) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e10 != null) {
                    throw e10;
                }
                throw e12;
            }
        } catch (FormatException e13) {
            e10 = null;
            formatException = e13;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            z5.d b102 = b(aVar, map);
            b102.o(new e(true));
            return b102;
        }
    }

    public z5.d e(boolean[][] zArr) throws ChecksumException, FormatException {
        return f(zArr, null);
    }

    public z5.d f(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        int length = zArr.length;
        z5.b bVar = new z5.b(length);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                if (zArr[i10][i11]) {
                    bVar.o(i11, i10);
                }
            }
        }
        return d(bVar, map);
    }
}
