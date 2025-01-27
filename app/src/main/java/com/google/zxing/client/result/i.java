package com.google.zxing.client.result;

import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class i extends t {

    /* renamed from: f */
    private static final Pattern f8250f = Pattern.compile(",");

    @Override // com.google.zxing.client.result.t
    /* renamed from: q */
    public h k(com.google.zxing.k kVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String c2 = t.c(kVar);
        if (!c2.startsWith("mailto:") && !c2.startsWith("MAILTO:")) {
            if (j.s(c2)) {
                return new h(c2);
            }
            return null;
        }
        String substring = c2.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        try {
            String p = t.p(substring);
            String[] split = !p.isEmpty() ? f8250f.split(p) : null;
            Map<String, String> m = t.m(c2);
            if (m != null) {
                if (split == null && (str3 = m.get("to")) != null) {
                    split = f8250f.split(str3);
                }
                String str4 = m.get("cc");
                String[] split2 = str4 != null ? f8250f.split(str4) : null;
                String str5 = m.get("bcc");
                String[] split3 = str5 != null ? f8250f.split(str5) : null;
                String str6 = m.get("subject");
                str2 = m.get("body");
                strArr = split;
                strArr3 = split3;
                strArr2 = split2;
                str = str6;
            } else {
                strArr = split;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new h(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
