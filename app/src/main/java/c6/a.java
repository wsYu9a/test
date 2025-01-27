package c6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.datamatrix.detector.Detector;
import d6.c;
import java.util.List;
import java.util.Map;
import t5.j;
import t5.k;
import t5.l;
import z5.d;
import z5.f;

/* loaded from: classes2.dex */
public final class a implements j {

    /* renamed from: b */
    public static final l[] f1704b = new l[0];

    /* renamed from: a */
    public final c f1705a = new c();

    public static z5.b c(z5.b bVar) throws NotFoundException {
        int[] k10 = bVar.k();
        int[] f10 = bVar.f();
        if (k10 == null || f10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int d10 = d(k10, bVar);
        int i10 = k10[1];
        int i11 = f10[1];
        int i12 = k10[0];
        int i13 = ((f10[0] - i12) + 1) / d10;
        int i14 = ((i11 - i10) + 1) / d10;
        if (i13 <= 0 || i14 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = d10 / 2;
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        z5.b bVar2 = new z5.b(i13, i14);
        for (int i18 = 0; i18 < i14; i18++) {
            int i19 = (i18 * d10) + i16;
            for (int i20 = 0; i20 < i13; i20++) {
                if (bVar.e((i20 * d10) + i17, i19)) {
                    bVar2.o(i20, i18);
                }
            }
        }
        return bVar2;
    }

    public static int d(int[] iArr, z5.b bVar) throws NotFoundException {
        int l10 = bVar.l();
        int i10 = iArr[0];
        int i11 = iArr[1];
        while (i10 < l10 && bVar.e(i10, i11)) {
            i10++;
        }
        if (i10 == l10) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i10 - iArr[0];
        if (i12 != 0) {
            return i12;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // t5.j
    public k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b10;
        d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f c10 = new Detector(bVar.b()).c();
            d b11 = this.f1705a.b(c10.a());
            b10 = c10.b();
            dVar = b11;
        } else {
            dVar = this.f1705a.b(c(bVar.b()));
            b10 = f1704b;
        }
        k kVar = new k(dVar.j(), dVar.g(), b10, BarcodeFormat.DATA_MATRIX);
        List<byte[]> a10 = dVar.a();
        if (a10 != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b12 = dVar.b();
        if (b12 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b12);
        }
        return kVar;
    }

    @Override // t5.j
    public k b(t5.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // t5.j
    public void reset() {
    }
}
