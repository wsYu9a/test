package com.opos.cmn.i;

/* loaded from: classes4.dex */
public class d {
    public static String a() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DeviceUtils", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getUserAgent=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("DeviceUtils", sb.toString());
        return str;
    }
}
