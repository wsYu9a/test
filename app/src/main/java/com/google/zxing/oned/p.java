package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: a */
    private final x[] f8591a;

    public p(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f8591a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    @Override // com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] p = x.p(aVar);
        for (x xVar : this.f8591a) {
            try {
                com.google.zxing.k m = xVar.m(i2, aVar, p, map);
                boolean z = m.b() == BarcodeFormat.EAN_13 && m.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return m;
                }
                com.google.zxing.k kVar = new com.google.zxing.k(m.g().substring(1), m.d(), m.f(), BarcodeFormat.UPC_A);
                kVar.i(m.e());
                return kVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.q, com.google.zxing.j
    public void reset() {
        for (x xVar : this.f8591a) {
            xVar.reset();
        }
    }
}
