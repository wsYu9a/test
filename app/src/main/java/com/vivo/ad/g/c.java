package com.vivo.ad.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class c {
    public static synchronized String a(Context context, SharedPreferences sharedPreferences) {
        synchronized (c.class) {
            e a2 = e.a(context, sharedPreferences);
            long currentTimeMillis = System.currentTimeMillis();
            String c2 = a2.c();
            long d2 = a2.d();
            long abs = Math.abs(currentTimeMillis - d2) / 1000;
            if (!TextUtils.isEmpty(c2) && abs <= a2.a()) {
                if (abs <= a2.b()) {
                    if (f.f26726a) {
                        f.a("HideSecureValueManager", "smaller than M, do nothing value=" + c2 + ",lastUseTime=" + d2 + ",M=" + a2.b());
                    }
                    return c2;
                }
                a2.a(currentTimeMillis);
                if (f.f26726a) {
                    f.a("HideSecureValueManager", "large than M, updateLastUseTimestamp value=" + c2 + ",lastLastUseTime=" + d2 + ",M=" + a2.b());
                }
                return c2;
            }
            String a3 = b.a(context, a2, currentTimeMillis);
            if (f.f26726a) {
                f.a("HideSecureValueManager", "large then N, generateAndTransferToAppStore value=" + a3 + ",lastUseTime=" + d2 + ",N=" + a2.a());
            }
            return a3;
        }
    }
}
