package s6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import java.util.Map;
import t5.j;
import t5.k;
import t5.l;
import t6.c;
import t6.e;
import z5.d;
import z5.f;

/* loaded from: classes2.dex */
public class a implements j {

    /* renamed from: b */
    public static final l[] f30602b = new l[0];

    /* renamed from: a */
    public final c f30603a = new c();

    private static z5.b e(z5.b bVar) throws NotFoundException {
        int[] k10 = bVar.k();
        int[] f10 = bVar.f();
        if (k10 == null || f10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float g10 = g(k10, bVar);
        int i10 = k10[1];
        int i11 = f10[1];
        int i12 = k10[0];
        int i13 = f10[0];
        if (i12 >= i13 || i10 >= i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i11 - i10;
        if (i14 != i13 - i12 && (i13 = i12 + i14) >= bVar.l()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int round = Math.round(((i13 - i12) + 1) / g10);
        int round2 = Math.round((i14 + 1) / g10);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = (int) (g10 / 2.0f);
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        int i18 = (((int) ((round - 1) * g10)) + i17) - i13;
        if (i18 > 0) {
            if (i18 > i15) {
                throw NotFoundException.getNotFoundInstance();
            }
            i17 -= i18;
        }
        int i19 = (((int) ((round2 - 1) * g10)) + i16) - i11;
        if (i19 > 0) {
            if (i19 > i15) {
                throw NotFoundException.getNotFoundInstance();
            }
            i16 -= i19;
        }
        z5.b bVar2 = new z5.b(round, round2);
        for (int i20 = 0; i20 < round2; i20++) {
            int i21 = ((int) (i20 * g10)) + i16;
            for (int i22 = 0; i22 < round; i22++) {
                if (bVar.e(((int) (i22 * g10)) + i17, i21)) {
                    bVar2.o(i22, i20);
                }
            }
        }
        return bVar2;
    }

    public static float g(int[] iArr, z5.b bVar) throws NotFoundException {
        int h10 = bVar.h();
        int l10 = bVar.l();
        int i10 = iArr[0];
        boolean z10 = true;
        int i11 = iArr[1];
        int i12 = 0;
        while (i10 < l10 && i11 < h10) {
            if (z10 != bVar.e(i10, i11)) {
                i12++;
                if (i12 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i10++;
            i11++;
        }
        if (i10 == l10 || i11 == h10) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i10 - iArr[0]) / 7.0f;
    }

    @Override // t5.j
    public final k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b10;
        d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f f10 = new u6.c(bVar.b()).f(map);
            d d10 = this.f30603a.d(f10.a(), map);
            b10 = f10.b();
            dVar = d10;
        } else {
            dVar = this.f30603a.d(e(bVar.b()), map);
            b10 = f30602b;
        }
        if (dVar.f() instanceof e) {
            ((e) dVar.f()).a(b10);
        }
        k kVar = new k(dVar.j(), dVar.g(), b10, BarcodeFormat.QR_CODE);
        List<byte[]> a10 = dVar.a();
        if (a10 != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b11 = dVar.b();
        if (b11 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b11);
        }
        if (dVar.k()) {
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVar.i()));
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVar.h()));
        }
        return kVar;
    }

    @Override // t5.j
    public k b(t5.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    public final c f() {
        return this.f30603a;
    }

    @Override // t5.j
    public void reset() {
    }
}
