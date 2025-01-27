package n6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Map;
import o6.i;
import t5.j;
import t5.k;
import t5.l;

/* loaded from: classes2.dex */
public final class b implements j, h6.c {
    public static k[] e(t5.b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        q6.b c10 = q6.a.c(bVar, map, z10);
        for (l[] lVarArr : c10.b()) {
            z5.d i10 = i.i(c10.a(), lVarArr[4], lVarArr[5], lVarArr[6], lVarArr[7], h(lVarArr), f(lVarArr));
            k kVar = new k(i10.j(), i10.g(), lVarArr, BarcodeFormat.PDF_417);
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, i10.b());
            c cVar = (c) i10.f();
            if (cVar != null) {
                kVar.j(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public static int f(l[] lVarArr) {
        return Math.max(Math.max(g(lVarArr[0], lVarArr[4]), (g(lVarArr[6], lVarArr[2]) * 17) / 18), Math.max(g(lVarArr[1], lVarArr[5]), (g(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    public static int g(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return 0;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    public static int h(l[] lVarArr) {
        return Math.min(Math.min(i(lVarArr[0], lVarArr[4]), (i(lVarArr[6], lVarArr[2]) * 17) / 18), Math.min(i(lVarArr[1], lVarArr[5]), (i(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    public static int i(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    @Override // t5.j
    public k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        k kVar;
        k[] e10 = e(bVar, map, false);
        if (e10 == null || e10.length == 0 || (kVar = e10[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return kVar;
    }

    @Override // t5.j
    public k b(t5.b bVar) throws NotFoundException, FormatException, ChecksumException {
        return a(bVar, null);
    }

    @Override // h6.c
    public k[] c(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return e(bVar, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // h6.c
    public k[] d(t5.b bVar) throws NotFoundException {
        return c(bVar, null);
    }

    @Override // t5.j
    public void reset() {
    }
}
