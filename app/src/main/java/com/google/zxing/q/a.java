package com.google.zxing.q;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.d;
import com.google.zxing.common.f;
import com.google.zxing.datamatrix.decoder.c;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a */
    private static final l[] f8744a = new l[0];

    /* renamed from: b */
    private final c f8745b = new c();

    private static com.google.zxing.common.b b(com.google.zxing.common.b bVar) throws NotFoundException {
        int[] k = bVar.k();
        int[] f2 = bVar.f();
        if (k == null || f2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int d2 = d(k, bVar);
        int i2 = k[1];
        int i3 = f2[1];
        int i4 = k[0];
        int i5 = ((f2[0] - i4) + 1) / d2;
        int i6 = ((i3 - i2) + 1) / d2;
        if (i5 <= 0 || i6 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = d2 / 2;
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i5, i6);
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i10 * d2) + i8;
            for (int i12 = 0; i12 < i5; i12++) {
                if (bVar.e((i12 * d2) + i9, i11)) {
                    bVar2.o(i12, i10);
                }
            }
        }
        return bVar2;
    }

    private static int d(int[] iArr, com.google.zxing.common.b bVar) throws NotFoundException {
        int l = bVar.l();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < l && bVar.e(i2, i3)) {
            i2++;
        }
        if (i2 == l) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i4 = i2 - iArr[0];
        if (i4 != 0) {
            return i4;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b2;
        d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f c2 = new Detector(bVar.b()).c();
            d b3 = this.f8745b.b(c2.a());
            b2 = c2.b();
            dVar = b3;
        } else {
            dVar = this.f8745b.b(b(bVar.b()));
            b2 = f8744a;
        }
        k kVar = new k(dVar.j(), dVar.g(), b2, BarcodeFormat.DATA_MATRIX);
        List<byte[]> a2 = dVar.a();
        if (a2 != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a2);
        }
        String b4 = dVar.b();
        if (b4 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b4);
        }
        return kVar;
    }

    @Override // com.google.zxing.j
    public k c(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
