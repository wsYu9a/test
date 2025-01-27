package y5;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes2.dex */
public final class s extends t {
    @Override // y5.t
    /* renamed from: q */
    public r k(t5.k kVar) {
        BarcodeFormat b10 = kVar.b();
        if (b10 != BarcodeFormat.UPC_A && b10 != BarcodeFormat.UPC_E && b10 != BarcodeFormat.EAN_8 && b10 != BarcodeFormat.EAN_13) {
            return null;
        }
        String c10 = t.c(kVar);
        if (t.d(c10, c10.length())) {
            return new r(c10, (b10 == BarcodeFormat.UPC_E && c10.length() == 8) ? j6.z.r(c10) : c10);
        }
        return null;
    }
}
