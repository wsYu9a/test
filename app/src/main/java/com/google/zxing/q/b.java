package com.google.zxing.q;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.j;
import com.google.zxing.datamatrix.encoder.k;
import com.google.zxing.n;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements n {
    private static com.google.zxing.common.b c(com.google.zxing.u.c.b bVar) {
        int e2 = bVar.e();
        int d2 = bVar.d();
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(e2, d2);
        bVar2.b();
        for (int i2 = 0; i2 < e2; i2++) {
            for (int i3 = 0; i3 < d2; i3++) {
                if (bVar.b(i2, i3) == 1) {
                    bVar2.o(i2, i3);
                }
            }
        }
        return bVar2;
    }

    private static com.google.zxing.common.b d(e eVar, k kVar) {
        int i2 = kVar.i();
        int h2 = kVar.h();
        com.google.zxing.u.c.b bVar = new com.google.zxing.u.c.b(kVar.k(), kVar.j());
        int i3 = 0;
        for (int i4 = 0; i4 < h2; i4++) {
            if (i4 % kVar.f8423g == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < kVar.k(); i6++) {
                    bVar.h(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                if (i8 % kVar.f8422f == 0) {
                    bVar.h(i7, i3, true);
                    i7++;
                }
                bVar.h(i7, i3, eVar.e(i8, i4));
                i7++;
                int i9 = kVar.f8422f;
                if (i8 % i9 == i9 - 1) {
                    bVar.h(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            int i10 = kVar.f8423g;
            if (i4 % i10 == i10 - 1) {
                int i11 = 0;
                for (int i12 = 0; i12 < kVar.k(); i12++) {
                    bVar.h(i11, i3, true);
                    i11++;
                }
                i3++;
            }
        }
        return c(bVar);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        c cVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
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
        String c2 = j.c(str, symbolShapeHint, cVar2, cVar);
        k o = k.o(c2.length(), symbolShapeHint, cVar2, cVar, true);
        e eVar = new e(i.c(c2, o), o.i(), o.h());
        eVar.k();
        return d(eVar, o);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
