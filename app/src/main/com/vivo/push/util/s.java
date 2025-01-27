package com.vivo.push.util;

/* loaded from: classes4.dex */
public final class s {
    public static int a(com.vivo.push.b.c cVar) {
        w b10 = w.b();
        int b11 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int a10 = b10.a("com.vivo.push_preferences.operate." + b11 + "OPERATE_COUNT");
        long b12 = currentTimeMillis - b10.b("com.vivo.push_preferences.operate." + b11 + "START_TIME", 0L);
        if (b12 <= 86400000 && b12 >= 0) {
            if (a10 >= cVar.f()) {
                return 1001;
            }
            b10.a("com.vivo.push_preferences.operate." + b11 + "OPERATE_COUNT", a10 + 1);
            return 0;
        }
        b10.a("com.vivo.push_preferences.operate." + b11 + "START_TIME", System.currentTimeMillis());
        b10.a("com.vivo.push_preferences.operate." + b11 + "OPERATE_COUNT", 1);
        return 0;
    }
}
