package com.google.zxing.t;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.pdf417.decoder.i;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements j, com.google.zxing.s.c {
    private static k[] e(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        com.google.zxing.t.e.b b2 = com.google.zxing.t.e.a.b(bVar, map, z);
        for (l[] lVarArr : b2.b()) {
            com.google.zxing.common.d i2 = i.i(b2.a(), lVarArr[4], lVarArr[5], lVarArr[6], lVarArr[7], h(lVarArr), f(lVarArr));
            k kVar = new k(i2.j(), i2.g(), lVarArr, BarcodeFormat.PDF_417);
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, i2.b());
            c cVar = (c) i2.f();
            if (cVar != null) {
                kVar.j(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    private static int f(l[] lVarArr) {
        return Math.max(Math.max(g(lVarArr[0], lVarArr[4]), (g(lVarArr[6], lVarArr[2]) * 17) / 18), Math.max(g(lVarArr[1], lVarArr[5]), (g(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    private static int g(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return 0;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    private static int h(l[] lVarArr) {
        return Math.min(Math.min(i(lVarArr[0], lVarArr[4]), (i(lVarArr[6], lVarArr[2]) * 17) / 18), Math.min(i(lVarArr[1], lVarArr[5]), (i(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    private static int i(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        k[] e2 = e(bVar, map, false);
        if (e2 == null || e2.length == 0 || e2[0] == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return e2[0];
    }

    @Override // com.google.zxing.s.c
    public k[] b(com.google.zxing.b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // com.google.zxing.j
    public k c(com.google.zxing.b bVar) throws NotFoundException, FormatException, ChecksumException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.s.c
    public k[] d(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return e(bVar, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
