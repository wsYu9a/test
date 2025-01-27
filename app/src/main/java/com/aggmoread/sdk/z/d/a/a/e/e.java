package com.aggmoread.sdk.z.d.a.a.e;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    static final String f6091a = System.getProperty("line.separator");

    public static void a(String str) {
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            a("AMSDK", str);
        }
    }

    public static void b(String str) {
        Log.e("mobile_ad", str);
    }

    public static void c(String str) {
        b("BIDTAG", str);
    }

    public static void a(String str, String str2) {
        Log.e(str, str2);
    }

    public static void b(String str, String str2) {
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            try {
                if (str.startsWith("{")) {
                    str = new JSONObject(str).toString(4);
                } else if (str.startsWith("[")) {
                    str = new JSONArray(str).toString(4);
                }
            } catch (JSONException unused) {
            }
            a("AMSDK", true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            String str3 = f6091a;
            sb2.append(str3);
            sb2.append(str);
            for (String str4 : sb2.toString().split(str3)) {
                a("AMHTTAG", "* " + str4);
            }
            a("AMSDK", false);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            if (objArr != null && objArr.length > 0) {
                try {
                    str2 = String.format(str2, objArr);
                } catch (Exception unused) {
                }
            }
            a(str, str2);
        }
    }

    public static void a(String str, boolean z10) {
        a(str, "+-------------------------------+");
    }

    public static void a(byte[] bArr, String str) {
        String str2;
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            boolean contains = str.contains("ads2");
            if (bArr != null && bArr.length > 0) {
                try {
                    String str3 = new String(bArr, "UTF-8");
                    if (contains) {
                        b("AMHTTAG_ADS", "tmp raw data " + str3);
                    }
                    byte[] a10 = com.aggmoread.sdk.z.d.a.a.b.a(str3);
                    if (a10 != null) {
                        bArr = a10;
                    }
                    String str4 = new String(bArr, "UTF-8");
                    if (!TextUtils.isEmpty(str4)) {
                        str2 = str4.startsWith("[") ? new JSONArray(str4).toString() : new JSONObject(str4).toString();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                str2 = "";
            } else {
                if (contains) {
                    b("AMHTTAG_ADS", "json:= empty  " + str);
                    return;
                }
                str2 = "json:= empty";
            }
            c(str2, str);
        }
    }
}
