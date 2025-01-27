package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private final com.google.zxing.common.reedsolomon.c f8754a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f8348e);

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f8754a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private com.google.zxing.common.d d(a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        g e2 = aVar.e();
        ErrorCorrectionLevel d2 = aVar.d().d();
        b[] b2 = b.b(aVar.c(), e2, d2);
        int i2 = 0;
        for (b bVar : b2) {
            i2 += bVar.c();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (b bVar2 : b2) {
            byte[] a2 = bVar2.a();
            int c2 = bVar2.c();
            a(a2, c2);
            int i4 = 0;
            while (i4 < c2) {
                bArr[i3] = a2[i4];
                i4++;
                i3++;
            }
        }
        return c.a(bArr, e2, d2, map);
    }

    public com.google.zxing.common.d b(com.google.zxing.common.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public com.google.zxing.common.d c(com.google.zxing.common.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e2;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return d(aVar, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                com.google.zxing.common.d d2 = d(aVar, map);
                d2.o(new f(true));
                return d2;
            } catch (ChecksumException | FormatException e4) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (FormatException e5) {
            e2 = null;
            formatException = e5;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            com.google.zxing.common.d d22 = d(aVar, map);
            d22.o(new f(true));
            return d22;
        }
    }

    public com.google.zxing.common.d e(boolean[][] zArr) throws ChecksumException, FormatException {
        return f(zArr, null);
    }

    public com.google.zxing.common.d f(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        int length = zArr.length;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.o(i3, i2);
                }
            }
        }
        return c(bVar, map);
    }
}
