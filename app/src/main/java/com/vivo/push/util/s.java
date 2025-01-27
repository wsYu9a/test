package com.vivo.push.util;

/* loaded from: classes4.dex */
public final class s {
    public static int a(com.vivo.push.b.c cVar) {
        w b2 = w.b();
        int b3 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int a2 = b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT");
        long b4 = currentTimeMillis - b2.b("com.vivo.push_preferences.operate." + b3 + "START_TIME", 0L);
        if (b4 <= 86400000 && b4 >= 0) {
            if (a2 >= cVar.f()) {
                return 1001;
            }
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", a2 + 1);
            return 0;
        }
        b2.a("com.vivo.push_preferences.operate." + b3 + "START_TIME", System.currentTimeMillis());
        b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", 1);
        return 0;
    }
}
