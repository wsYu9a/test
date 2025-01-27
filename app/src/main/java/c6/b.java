package c6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import e6.e;
import e6.i;
import e6.j;
import e6.k;
import java.util.Map;
import t5.c;
import t5.n;

/* loaded from: classes2.dex */
public final class b implements n {
    public static z5.b c(v6.b bVar) {
        int e10 = bVar.e();
        int d10 = bVar.d();
        z5.b bVar2 = new z5.b(e10, d10);
        bVar2.b();
        for (int i10 = 0; i10 < e10; i10++) {
            for (int i11 = 0; i11 < d10; i11++) {
                if (bVar.b(i10, i11) == 1) {
                    bVar2.o(i10, i11);
                }
            }
        }
        return bVar2;
    }

    public static z5.b d(e eVar, k kVar) {
        int i10 = kVar.i();
        int h10 = kVar.h();
        v6.b bVar = new v6.b(kVar.k(), kVar.j());
        int i11 = 0;
        for (int i12 = 0; i12 < h10; i12++) {
            if (i12 % kVar.f25753e == 0) {
                int i13 = 0;
                for (int i14 = 0; i14 < kVar.k(); i14++) {
                    bVar.h(i13, i11, i14 % 2 == 0);
                    i13++;
                }
                i11++;
            }
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                if (i16 % kVar.f25752d == 0) {
                    bVar.h(i15, i11, true);
                    i15++;
                }
                bVar.h(i15, i11, eVar.e(i16, i12));
                int i17 = i15 + 1;
                int i18 = kVar.f25752d;
                if (i16 % i18 == i18 - 1) {
                    bVar.h(i17, i11, i12 % 2 == 0);
                    i15 += 2;
                } else {
                    i15 = i17;
                }
            }
            int i19 = i11 + 1;
            int i20 = kVar.f25753e;
            if (i12 % i20 == i20 - 1) {
                int i21 = 0;
                for (int i22 = 0; i22 < kVar.k(); i22++) {
                    bVar.h(i21, i19, true);
                    i21++;
                }
                i11 += 2;
            } else {
                i11 = i19;
            }
        }
        return c(bVar);
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        c cVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        c cVar2 = null;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            c cVar3 = (c) map.get(EncodeHintType.MIN_SIZE);
            if (cVar3 == null) {
                cVar3 = null;
            }
            cVar = (c) map.get(EncodeHintType.MAX_SIZE);
            if (cVar == null) {
                cVar = null;
            }
            cVar2 = cVar3;
        } else {
            cVar = null;
        }
        String c10 = j.c(str, symbolShapeHint, cVar2, cVar);
        k o10 = k.o(c10.length(), symbolShapeHint, cVar2, cVar, true);
        e eVar = new e(i.c(c10, o10), o10.i(), o10.h());
        eVar.k();
        return d(eVar, o10);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
