package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class j0 extends t {
    @Override // com.google.zxing.client.result.t
    /* renamed from: q */
    public i0 k(com.google.zxing.k kVar) {
        String g2;
        String c2 = t.c(kVar);
        if (!c2.startsWith("WIFI:") || (g2 = t.g("S:", c2, ';', false)) == null || g2.isEmpty()) {
            return null;
        }
        String g3 = t.g("P:", c2, ';', false);
        String g4 = t.g("T:", c2, ';', false);
        if (g4 == null) {
            g4 = "nopass";
        }
        return new i0(g4, g2, g3, Boolean.parseBoolean(t.g("H:", c2, ';', false)));
    }
}
