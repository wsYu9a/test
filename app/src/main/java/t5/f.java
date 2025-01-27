package t5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import j6.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f implements j {

    /* renamed from: a */
    public Map<DecodeHintType, ?> f30706a;

    /* renamed from: b */
    public j[] f30707b;

    @Override // t5.j
    public k a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return c(bVar);
    }

    @Override // t5.j
    public k b(b bVar) throws NotFoundException {
        e(null);
        return c(bVar);
    }

    public final k c(b bVar) throws NotFoundException {
        j[] jVarArr = this.f30707b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                try {
                    return jVar.a(bVar, this.f30706a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public k d(b bVar) throws NotFoundException {
        if (this.f30707b == null) {
            e(null);
        }
        return c(bVar);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.f30706a = map;
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z11 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z11 && !z10) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new s6.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new c6.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new u5.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new n6.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new f6.a());
            }
            if (z11 && z10) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z10) {
                arrayList.add(new o(map));
            }
            arrayList.add(new s6.a());
            arrayList.add(new c6.a());
            arrayList.add(new u5.b());
            arrayList.add(new n6.b());
            arrayList.add(new f6.a());
            if (z10) {
                arrayList.add(new o(map));
            }
        }
        this.f30707b = (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // t5.j
    public void reset() {
        j[] jVarArr = this.f30707b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.reset();
            }
        }
    }
}
