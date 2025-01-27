package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import g2.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || t3.a.c(str) || t3.a.c(str2)) {
            return null;
        }
        try {
            String a10 = e.a(context, str, str2, "");
            if (t3.a.c(a10)) {
                return null;
            }
            return s3.c.e(s3.c.a(), a10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (t3.a.c(str) || t3.a.c(str2)) {
                return null;
            }
            try {
                String a10 = g2.b.a(str);
                if (t3.a.c(a10)) {
                    return null;
                }
                String string = new JSONObject(a10).getString(str2);
                if (t3.a.c(string)) {
                    return null;
                }
                return s3.c.e(s3.c.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (t3.a.c(str) || t3.a.c(str2) || context == null) {
            return;
        }
        try {
            String b10 = s3.c.b(s3.c.a(), str3);
            HashMap hashMap = new HashMap();
            hashMap.put(str2, b10);
            e.b(context, str, hashMap);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            try {
                if (t3.a.c(str) || t3.a.c(str2)) {
                    return;
                }
                try {
                    String a10 = g2.b.a(str);
                    JSONObject jSONObject = new JSONObject();
                    if (t3.a.f(a10)) {
                        try {
                            jSONObject = new JSONObject(a10);
                        } catch (Exception unused) {
                            jSONObject = new JSONObject();
                        }
                    }
                    jSONObject.put(str2, s3.c.b(s3.c.a(), str3));
                    jSONObject.toString();
                    try {
                        System.clearProperty(str);
                    } catch (Throwable unused2) {
                    }
                    if (g2.c.b()) {
                        String str4 = ".SystemConfig" + File.separator + str;
                        if (g2.c.b()) {
                            File file = new File(Environment.getExternalStorageDirectory(), str4);
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
