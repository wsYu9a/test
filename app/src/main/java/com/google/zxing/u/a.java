package com.google.zxing.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.f;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.detector.c;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements j {

    /* renamed from: a */
    private static final l[] f8847a = new l[0];

    /* renamed from: b */
    private final d f8848b = new d();

    private static com.google.zxing.common.b e(com.google.zxing.common.b bVar) throws NotFoundException {
        int[] k = bVar.k();
        int[] f2 = bVar.f();
        if (k == null || f2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float g2 = g(k, bVar);
        int i2 = k[1];
        int i3 = f2[1];
        int i4 = k[0];
        int i5 = f2[0];
        if (i4 >= i5 || i2 >= i3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.l()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int round = Math.round(((i5 - i4) + 1) / g2);
        int round2 = Math.round((i6 + 1) / g2);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = (int) (g2 / 2.0f);
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        int i10 = (((int) ((round - 1) * g2)) + i9) - i5;
        if (i10 > 0) {
            if (i10 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i9 -= i10;
        }
        int i11 = (((int) ((round2 - 1) * g2)) + i8) - i3;
        if (i11 > 0) {
            if (i11 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i11;
        }
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(round, round2);
        for (int i12 = 0; i12 < round2; i12++) {
            int i13 = ((int) (i12 * g2)) + i8;
            for (int i14 = 0; i14 < round; i14++) {
                if (bVar.e(((int) (i14 * g2)) + i9, i13)) {
                    bVar2.o(i14, i12);
                }
            }
        }
        return bVar2;
    }

    private static float g(int[] iArr, com.google.zxing.common.b bVar) throws NotFoundException {
        int h2 = bVar.h();
        int l = bVar.l();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < l && i3 < h2) {
            if (z != bVar.e(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 == l || i3 == h2) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i2 - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.j
    public final k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b2;
        com.google.zxing.common.d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f f2 = new c(bVar.b()).f(map);
            com.google.zxing.common.d c2 = this.f8848b.c(f2.a(), map);
            b2 = f2.b();
            dVar = c2;
        } else {
            dVar = this.f8848b.c(e(bVar.b()), map);
            b2 = f8847a;
        }
        if (dVar.f() instanceof com.google.zxing.qrcode.decoder.f) {
            ((com.google.zxing.qrcode.decoder.f) dVar.f()).a(b2);
        }
        k kVar = new k(dVar.j(), dVar.g(), b2, BarcodeFormat.QR_CODE);
        List<byte[]> a2 = dVar.a();
        if (a2 != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a2);
        }
        String b3 = dVar.b();
        if (b3 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b3);
        }
        if (dVar.k()) {
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVar.i()));
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVar.h()));
        }
        return kVar;
    }

    @Override // com.google.zxing.j
    public k c(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    protected final d f() {
        return this.f8848b;
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
