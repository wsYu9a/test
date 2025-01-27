package com.google.zxing;

import com.google.zxing.oned.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: a */
    private Map<DecodeHintType, ?> f8429a;

    /* renamed from: b */
    private j[] f8430b;

    private k b(b bVar) throws NotFoundException {
        j[] jVarArr = this.f8430b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                try {
                    return jVar.a(bVar, this.f8429a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.j
    public k a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return b(bVar);
    }

    @Override // com.google.zxing.j
    public k c(b bVar) throws NotFoundException {
        e(null);
        return b(bVar);
    }

    public k d(b bVar) throws NotFoundException {
        if (this.f8430b == null) {
            e(null);
        }
        return b(bVar);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.f8429a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new com.google.zxing.u.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new com.google.zxing.q.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new com.google.zxing.o.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new com.google.zxing.t.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new com.google.zxing.r.a());
            }
            if (z && z2) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new o(map));
            }
            arrayList.add(new com.google.zxing.u.a());
            arrayList.add(new com.google.zxing.q.a());
            arrayList.add(new com.google.zxing.o.b());
            arrayList.add(new com.google.zxing.t.b());
            arrayList.add(new com.google.zxing.r.a());
            if (z2) {
                arrayList.add(new o(map));
            }
        }
        this.f8430b = (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // com.google.zxing.j
    public void reset() {
        j[] jVarArr = this.f8430b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.reset();
            }
        }
    }
}
