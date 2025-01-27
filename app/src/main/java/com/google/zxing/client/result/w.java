package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class w extends t {
    @Override // com.google.zxing.client.result.t
    /* renamed from: q */
    public v k(com.google.zxing.k kVar) {
        String str;
        String c2 = t.c(kVar);
        if (!c2.startsWith("smsto:") && !c2.startsWith("SMSTO:") && !c2.startsWith("mmsto:") && !c2.startsWith("MMSTO:")) {
            return null;
        }
        String substring = c2.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str = null;
        }
        return new v(substring, (String) null, (String) null, str);
    }
}
