package n6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import t5.n;

/* loaded from: classes2.dex */
public final class d implements n {

    /* renamed from: a */
    public static final int f28796a = 30;

    /* renamed from: b */
    public static final int f28797b = 2;

    public static z5.b c(r6.d dVar, String str, int i10, int i11, int i12, int i13) throws WriterException {
        boolean z10;
        dVar.e(str, i10);
        byte[][] c10 = dVar.f().c(1, 4);
        if ((i12 > i11) ^ (c10[0].length < c10.length)) {
            c10 = e(c10);
            z10 = true;
        } else {
            z10 = false;
        }
        int length = i11 / c10[0].length;
        int length2 = i12 / c10.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return d(c10, i13);
        }
        byte[][] c11 = dVar.f().c(length, length << 2);
        if (z10) {
            c11 = e(c11);
        }
        return d(c11, i13);
    }

    public static z5.b d(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        z5.b bVar = new z5.b(bArr[0].length + i11, bArr.length + i11);
        bVar.b();
        int h10 = (bVar.h() - i10) - 1;
        int i12 = 0;
        while (i12 < bArr.length) {
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                if (bArr[i12][i13] == 1) {
                    bVar.o(i13 + i10, h10);
                }
            }
            i12++;
            h10--;
        }
        return bVar;
    }

    public static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int length = (bArr.length - i10) - 1;
            for (int i11 = 0; i11 < bArr[0].length; i11++) {
                bArr2[i11][length] = bArr[i10][i11];
            }
        }
        return bArr2;
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        int i12;
        int i13;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        r6.d dVar = new r6.d();
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
                r6.c cVar = (r6.c) map.get(encodeHintType3);
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
            i13 = parseInt;
            i12 = parseInt2;
        } else {
            i12 = 2;
            i13 = 30;
        }
        return c(dVar, str, i12, i10, i11, i13);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
