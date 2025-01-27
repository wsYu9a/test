package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class f extends a {
    @Override // com.google.zxing.client.result.t
    /* renamed from: s */
    public b0 k(com.google.zxing.k kVar) {
        String g2 = kVar.g();
        if (!g2.startsWith("MEBKM:")) {
            return null;
        }
        String r = a.r("TITLE:", g2, true);
        String[] q = a.q("URL:", g2, true);
        if (q == null) {
            return null;
        }
        String str = q[0];
        if (c0.q(str)) {
            return new b0(str, r);
        }
        return null;
    }
}
