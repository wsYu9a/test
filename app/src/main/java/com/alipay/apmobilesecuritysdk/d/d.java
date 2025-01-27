package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap();
            try {
                new com.alipay.apmobilesecuritysdk.c.b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            try {
                e2.e.a();
                e2.b.a(APSecuritySdk.getInstance(context));
                hashMap = new HashMap();
                hashMap.put("AE1", e2.e.c());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e2.e.d() ? "1" : "0");
                hashMap.put("AE2", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e2.e.e() ? "1" : "0");
                hashMap.put("AE3", sb3.toString());
                hashMap.put("AE4", e2.e.f());
                hashMap.put("AE5", e2.e.g());
                hashMap.put("AE6", e2.e.h());
                hashMap.put("AE7", e2.e.i());
                hashMap.put("AE8", e2.e.j());
                hashMap.put("AE9", e2.e.k());
                hashMap.put("AE10", e2.e.l());
                hashMap.put("AE11", e2.e.m());
                hashMap.put("AE12", e2.e.n());
                hashMap.put("AE13", e2.e.o());
                hashMap.put("AE14", e2.e.p());
                hashMap.put("AE15", e2.e.q());
                hashMap.put("AE21", e2.b.m());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hashMap;
    }
}
