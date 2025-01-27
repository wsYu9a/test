package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {
    public static c a(String str) {
        try {
            if (!t3.a.c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString(o3.a.f29032k), jSONObject.optString("tid"), jSONObject.optString(z2.b.f33622g));
            }
        } catch (Exception e10) {
            com.alipay.apmobilesecuritysdk.c.a.a(e10);
        }
        return null;
    }

    public static synchronized c b() {
        synchronized (d.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (t3.a.c(a10)) {
                return null;
            }
            return a(a10);
        }
    }

    public static synchronized c c(Context context) {
        synchronized (d.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (t3.a.c(a10)) {
                return null;
            }
            return a(a10);
        }
    }

    public static synchronized void a() {
        synchronized (d.class) {
        }
    }

    public static synchronized c b(Context context) {
        c a10;
        synchronized (d.class) {
            try {
                String a11 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
                if (t3.a.c(a11)) {
                    a11 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
                }
                a10 = a(a11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a10;
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.f6443a);
                jSONObject.put("deviceInfoHash", cVar.f6444b);
                jSONObject.put(o3.a.f29032k, cVar.f6445c);
                jSONObject.put("tid", cVar.f6446d);
                jSONObject.put(z2.b.f33622g, cVar.f6447e);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e10) {
                com.alipay.apmobilesecuritysdk.c.a.a(e10);
            }
        }
    }
}
