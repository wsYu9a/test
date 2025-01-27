package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: f */
    private static final Pattern f8255f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean s(String str) {
        return str != null && f8255f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.google.zxing.client.result.t
    /* renamed from: t */
    public h k(com.google.zxing.k kVar) {
        String[] q;
        String c2 = t.c(kVar);
        if (!c2.startsWith("MATMSG:") || (q = a.q("TO:", c2, true)) == null) {
            return null;
        }
        for (String str : q) {
            if (!s(str)) {
                return null;
            }
        }
        return new h(q, null, null, a.r("SUB:", c2, false), a.r("BODY:", c2, false));
    }
}
