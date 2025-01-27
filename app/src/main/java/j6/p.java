package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p extends q {

    /* renamed from: a */
    public final x[] f27227a;

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
        this.f27227a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    @Override // j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] p10 = x.p(aVar);
        for (x xVar : this.f27227a) {
            try {
                t5.k m10 = xVar.m(i10, aVar, p10, map);
                boolean z10 = m10.b() == BarcodeFormat.EAN_13 && m10.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z11 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z10 || !z11) {
                    return m10;
                }
                t5.k kVar = new t5.k(m10.g().substring(1), m10.d(), m10.f(), BarcodeFormat.UPC_A);
                kVar.i(m10.e());
                return kVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // j6.q, t5.j
    public void reset() {
        for (x xVar : this.f27227a) {
            xVar.reset();
        }
    }
}
