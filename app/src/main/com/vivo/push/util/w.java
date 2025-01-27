package com.vivo.push.util;

import android.content.Context;

/* loaded from: classes4.dex */
public final class w extends b {

    /* renamed from: b */
    private static w f25149b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            try {
                if (f25149b == null) {
                    f25149b = new w();
                }
                wVar = f25149b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return wVar;
    }

    public final synchronized void a(Context context) {
        if (this.f25111a == null) {
            this.f25111a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c10 = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c10 == null || c10.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : c10;
    }

    public final byte[] d() {
        byte[] c10 = c(b("com.vivo.push.secure_cache_key", ""));
        return (c10 == null || c10.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, nf.c.f28885q, 41, 32, 38, 37, 36, 35, 34, 33} : c10;
    }

    private static byte[] c(String str) {
        int i10;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i10 = split.length;
            } else {
                i10 = 0;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = Byte.parseByte(split[i11].trim());
            }
        } catch (Exception e10) {
            p.a("SharePreferenceManager", "getCodeBytes error:" + e10.getMessage());
        }
        return bArr;
    }
}
