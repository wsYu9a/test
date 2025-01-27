package com.opos.cmn.func.b.a.a;

/* loaded from: classes4.dex */
public class c {
    public static String a() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("Utils", "getUA", e2);
            return "";
        }
    }
}
