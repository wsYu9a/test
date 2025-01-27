package com.alipay.apmobilesecuritysdk.e;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    public static String f6454a = "";

    /* renamed from: b */
    public static String f6455b = "";

    /* renamed from: c */
    public static String f6456c = "";

    /* renamed from: d */
    public static String f6457d = "";

    /* renamed from: e */
    public static String f6458e = "";

    /* renamed from: f */
    public static Map<String, String> f6459f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f6459f.containsKey(str2)) {
                String str3 = f6459f.get(str2);
                if (t3.a.f(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (i.class) {
            str = f6454a;
        }
        return str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f6455b;
        }
        return str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f6457d;
        }
        return str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f6458e;
        }
        return str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f6456c;
        }
        return str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f6454a, f6455b, f6456c, f6457d, f6458e);
        }
        return cVar;
    }

    public static void h() {
        f6459f.clear();
        f6454a = "";
        f6455b = "";
        f6457d = "";
        f6458e = "";
        f6456c = "";
    }

    public static synchronized void a() {
        synchronized (i.class) {
        }
    }

    public static void b(String str) {
        f6454a = str;
    }

    public static void c(String str) {
        f6455b = str;
    }

    public static void d(String str) {
        f6456c = str;
    }

    public static void e(String str) {
        f6457d = str;
    }

    public static void f(String str) {
        f6458e = str;
    }

    public static synchronized void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                f6454a = bVar.f6440a;
                f6455b = bVar.f6441b;
                f6456c = bVar.f6442c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f6454a = cVar.f6443a;
                f6455b = cVar.f6444b;
                f6457d = cVar.f6446d;
                f6458e = cVar.f6447e;
                f6456c = cVar.f6445c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            try {
                String str3 = "apdidTokenCache" + str;
                if (f6459f.containsKey(str3)) {
                    f6459f.remove(str3);
                }
                f6459f.put(str3, str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r1 < 0) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alipay.apmobilesecuritysdk.e.i> r0 = com.alipay.apmobilesecuritysdk.e.i.class
            monitor-enter(r0)
            long r1 = com.alipay.apmobilesecuritysdk.e.h.a(r6)     // Catch: java.lang.Throwable -> Ld
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L10
        Ld:
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
        L10:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L24
            long r6 = com.alipay.apmobilesecuritysdk.e.h.h(r6, r7)     // Catch: java.lang.Throwable -> L24
            long r3 = r3 - r6
            long r6 = java.lang.Math.abs(r3)     // Catch: java.lang.Throwable -> L24
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L28
            monitor-exit(r0)
            r6 = 1
            return r6
        L24:
            r6 = move-exception
            com.alipay.apmobilesecuritysdk.c.a.a(r6)     // Catch: java.lang.Throwable -> L2b
        L28:
            monitor-exit(r0)
            r6 = 0
            return r6
        L2b:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.e.i.a(android.content.Context, java.lang.String):boolean");
    }
}
