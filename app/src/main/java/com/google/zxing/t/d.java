package com.google.zxing.t;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.n;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements n {

    /* renamed from: a */
    static final int f8833a = 30;

    /* renamed from: b */
    static final int f8834b = 2;

    private static com.google.zxing.common.b c(com.google.zxing.pdf417.encoder.d dVar, String str, int i2, int i3, int i4, int i5) throws WriterException {
        boolean z;
        dVar.e(str, i2);
        byte[][] c2 = dVar.f().c(1, 4);
        if ((i4 > i3) ^ (c2[0].length < c2.length)) {
            c2 = e(c2);
            z = true;
        } else {
            z = false;
        }
        int length = i3 / c2[0].length;
        int length2 = i4 / c2.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return d(c2, i5);
        }
        byte[][] c3 = dVar.f().c(length, length << 2);
        if (z) {
            c3 = e(c3);
        }
        return d(c3, i5);
    }

    private static com.google.zxing.common.b d(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(bArr[0].length + i3, bArr.length + i3);
        bVar.b();
        int h2 = (bVar.h() - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr[i4][i5] == 1) {
                    bVar.o(i5 + i2, h2);
                }
            }
            i4++;
            h2--;
        }
        return bVar;
    }

    private static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        int i4;
        int i5;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        com.google.zxing.pdf417.encoder.d dVar = new com.google.zxing.pdf417.encoder.d();
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                dVar.h(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                dVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                com.google.zxing.pdf417.encoder.c cVar = (com.google.zxing.pdf417.encoder.c) map.get(encodeHintType3);
                dVar.j(cVar.a(), cVar.c(), cVar.b(), cVar.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            int parseInt = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            int parseInt2 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                dVar.k(Charset.forName(map.get(encodeHintType6).toString()));
            }
            i5 = parseInt;
            i4 = parseInt2;
        } else {
            i4 = 2;
            i5 = 30;
        }
        return c(dVar, str, i4, i2, i3, i5);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
