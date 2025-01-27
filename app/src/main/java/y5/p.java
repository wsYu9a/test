package y5;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes2.dex */
public final class p extends t {
    @Override // y5.t
    /* renamed from: q */
    public o k(t5.k kVar) {
        if (kVar.b() != BarcodeFormat.EAN_13) {
            return null;
        }
        String c10 = t.c(kVar);
        if (c10.length() != 13) {
            return null;
        }
        if (c10.startsWith("978") || c10.startsWith("979")) {
            return new o(c10);
        }
        return null;
    }
}
