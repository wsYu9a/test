package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes.dex */
public final class s extends t {
    @Override // com.google.zxing.client.result.t
    /* renamed from: q */
    public r k(com.google.zxing.k kVar) {
        BarcodeFormat b2 = kVar.b();
        if (b2 != BarcodeFormat.UPC_A && b2 != BarcodeFormat.UPC_E && b2 != BarcodeFormat.EAN_8 && b2 != BarcodeFormat.EAN_13) {
            return null;
        }
        String c2 = t.c(kVar);
        if (t.d(c2, c2.length())) {
            return new r(c2, (b2 == BarcodeFormat.UPC_E && c2.length() == 8) ? com.google.zxing.oned.z.r(c2) : c2);
        }
        return null;
    }
}
