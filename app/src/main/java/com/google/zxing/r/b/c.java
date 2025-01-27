package com.google.zxing.r.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.d;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final int f8811a = 0;

    /* renamed from: b */
    private static final int f8812b = 1;

    /* renamed from: c */
    private static final int f8813c = 2;

    /* renamed from: d */
    private final com.google.zxing.common.reedsolomon.c f8814d = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f8351h);

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) throws ChecksumException {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & 255;
            }
        }
        try {
            this.f8814d.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public d b(com.google.zxing.common.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public d c(com.google.zxing.common.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] a2 = new a(bVar).a();
        a(a2, 0, 10, 10, 0);
        int i2 = a2[0] & 15;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(a2, 20, 84, 40, 1);
            a(a2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i2 != 5) {
                throw FormatException.getFormatInstance();
            }
            a(a2, 20, 68, 56, 1);
            a(a2, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(a2, 0, bArr, 0, 10);
        System.arraycopy(a2, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }
}
