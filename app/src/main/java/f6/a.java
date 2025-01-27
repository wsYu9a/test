package f6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import g6.c;
import java.util.Map;
import t5.j;
import t5.k;
import t5.l;
import z5.b;
import z5.d;

/* loaded from: classes2.dex */
public final class a implements j {

    /* renamed from: b */
    public static final l[] f25999b = new l[0];

    /* renamed from: c */
    public static final int f26000c = 30;

    /* renamed from: d */
    public static final int f26001d = 33;

    /* renamed from: a */
    public final c f26002a = new c();

    private static b c(b bVar) throws NotFoundException {
        int[] g10 = bVar.g();
        if (g10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = g10[0];
        int i11 = g10[1];
        int i12 = g10[2];
        int i13 = g10[3];
        b bVar2 = new b(30, 33);
        for (int i14 = 0; i14 < 33; i14++) {
            int i15 = (((i14 * i13) + (i13 / 2)) / 33) + i11;
            for (int i16 = 0; i16 < 30; i16++) {
                if (bVar.e(((((i16 * i12) + (i12 / 2)) + (((i14 & 1) * i12) / 2)) / 30) + i10, i15)) {
                    bVar2.o(i16, i14);
                }
            }
        }
        return bVar2;
    }

    @Override // t5.j
    public k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        d c10 = this.f26002a.c(c(bVar.b()), map);
        k kVar = new k(c10.j(), c10.g(), f25999b, BarcodeFormat.MAXICODE);
        String b10 = c10.b();
        if (b10 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b10);
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
