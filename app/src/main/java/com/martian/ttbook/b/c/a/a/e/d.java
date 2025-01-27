package com.martian.ttbook.b.c.a.a.e;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    static final String f15825a = System.getProperty("line.separator");

    public static void a(String str) {
        if (com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue()) {
            b("ADSDK", str);
        }
    }

    static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, String str2, Object... objArr) {
        if (com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue()) {
            if (objArr != null && objArr.length > 0) {
                try {
                    str2 = String.format(str2, objArr);
                } catch (Exception unused) {
                }
            }
            b(str, str2);
        }
    }

    static void d(String str, boolean z) {
        b(str, "+-------------------------------+");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        r2 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(byte[] r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.Boolean r1 = com.martian.ttbook.b.c.a.a.d.b.j.r
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto Lb
            return
        Lb:
            if (r2 == 0) goto L4b
            int r1 = r2.length
            if (r1 <= 0) goto L4b
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L44
            byte[] r1 = com.martian.ttbook.b.c.a.a.b.i(r1)     // Catch: java.lang.Exception -> L44
            if (r1 != 0) goto L1c
            goto L1d
        L1c:
            r2 = r1
        L1d:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L44
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L44
            if (r2 != 0) goto L48
            java.lang.String r2 = "["
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Exception -> L44
            if (r2 == 0) goto L3a
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L44
            r2.<init>(r1)     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L44
            goto L4d
        L3a:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L44
            r2.<init>(r1)     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L44
            goto L4d
        L44:
            r2 = move-exception
            r2.printStackTrace()
        L48:
            java.lang.String r2 = ""
            goto L4d
        L4b:
            java.lang.String r2 = "json:= empty"
        L4d:
            i(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.e.d.e(byte[], java.lang.String):void");
    }

    public static void f(String str) {
        Log.e("mobile_ad", str);
    }

    public static void g(String str, String str2) {
        if (com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue()) {
            b(str, str2);
        }
    }

    public static void h(String str) {
        g("BIDTAG", str);
    }

    public static void i(String str, String str2) {
        if (com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue()) {
            try {
                if (str.startsWith("{")) {
                    str = new JSONObject(str).toString(4);
                } else if (str.startsWith("[")) {
                    str = new JSONArray(str).toString(4);
                }
            } catch (JSONException unused) {
            }
            d("ADSDK", true);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String str3 = f15825a;
            sb.append(str3);
            sb.append(str);
            for (String str4 : sb.toString().split(str3)) {
                b("ADHTTPTAG", "* " + str4);
            }
            d("ADSDK", false);
        }
    }
}
