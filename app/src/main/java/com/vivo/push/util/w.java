package com.vivo.push.util;

import android.content.Context;

/* loaded from: classes4.dex */
public final class w extends b {

    /* renamed from: b */
    private static w f31113b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f31113b == null) {
                f31113b = new w();
            }
            wVar = f31113b;
        }
        return wVar;
    }

    public final synchronized void a(Context context) {
        if (this.f31075a == null) {
            this.f31075a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{34, org.mozilla.universalchardet.prober.g.s, 33, 37, 33, 34, org.mozilla.universalchardet.prober.g.s, 33, 33, 33, 34, 41, 35, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s} : c2;
    }

    public final byte[] d() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_key", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, org.mozilla.universalchardet.prober.g.s, 38, 37, 36, 35, 34, 33} : c2;
    }

    private static byte[] c(String str) {
        int i2;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i2 = split.length;
            } else {
                i2 = 0;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
        } catch (Exception e2) {
            p.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
