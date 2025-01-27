package com.google.zxing.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.b;
import com.google.zxing.common.d;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.r.b.c;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a */
    private static final l[] f8795a = new l[0];

    /* renamed from: b */
    private static final int f8796b = 30;

    /* renamed from: c */
    private static final int f8797c = 33;

    /* renamed from: d */
    private final c f8798d = new c();

    private static b b(b bVar) throws NotFoundException {
        int[] g2 = bVar.g();
        if (g2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2 = g2[0];
        int i3 = g2[1];
        int i4 = g2[2];
        int i5 = g2[3];
        b bVar2 = new b(30, 33);
        for (int i6 = 0; i6 < 33; i6++) {
            int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
            for (int i8 = 0; i8 < 30; i8++) {
                if (bVar.e(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                    bVar2.o(i8, i6);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        d c2 = this.f8798d.c(b(bVar.b()), map);
        k kVar = new k(c2.j(), c2.g(), f8795a, BarcodeFormat.MAXICODE);
        String b2 = c2.b();
        if (b2 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b2);
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
