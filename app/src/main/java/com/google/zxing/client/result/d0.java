package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class d0 extends t {
    @Override // com.google.zxing.client.result.t
    /* renamed from: q */
    public b0 k(com.google.zxing.k kVar) {
        int indexOf;
        String c2 = t.c(kVar);
        if ((c2.startsWith("urlto:") || c2.startsWith("URLTO:")) && (indexOf = c2.indexOf(58, 6)) >= 0) {
            return new b0(c2.substring(indexOf + 1), indexOf > 6 ? c2.substring(6, indexOf) : null);
        }
        return null;
    }
}
