package com.google.zxing.client.result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c0 extends t {

    /* renamed from: f */
    private static final Pattern f8209f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g */
    private static final Pattern f8210g = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean q(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f8209f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f8210g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // com.google.zxing.client.result.t
    /* renamed from: r */
    public b0 k(com.google.zxing.k kVar) {
        String c2 = t.c(kVar);
        if (c2.startsWith("URL:") || c2.startsWith("URI:")) {
            return new b0(c2.substring(4).trim(), null);
        }
        String trim = c2.trim();
        if (q(trim)) {
            return new b0(trim, null);
        }
        return null;
    }
}
