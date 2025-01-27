package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private final com.google.zxing.common.reedsolomon.c f8371a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f8349f);

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f8371a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public com.google.zxing.common.d b(com.google.zxing.common.b bVar) throws FormatException, ChecksumException {
        a aVar = new a(bVar);
        b[] b2 = b.b(aVar.c(), aVar.b());
        int i2 = 0;
        for (b bVar2 : b2) {
            i2 += bVar2.c();
        }
        byte[] bArr = new byte[i2];
        int length = b2.length;
        for (int i3 = 0; i3 < length; i3++) {
            b bVar3 = b2[i3];
            byte[] a2 = bVar3.a();
            int c2 = bVar3.c();
            a(a2, c2);
            for (int i4 = 0; i4 < c2; i4++) {
                bArr[(i4 * length) + i3] = a2[i4];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    public com.google.zxing.common.d c(boolean[][] zArr) throws FormatException, ChecksumException {
        int length = zArr.length;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.o(i3, i2);
                }
            }
        }
        return b(bVar);
    }
}
