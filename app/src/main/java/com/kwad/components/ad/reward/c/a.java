package com.kwad.components.ad.reward.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static void P(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String bU = y.bU(context);
        int i2 = 0;
        if (!TextUtils.isEmpty(bU)) {
            try {
                bVar.parseJson(new JSONObject(bU));
                if (b(bVar.gq, currentTimeMillis)) {
                    i2 = bVar.f9538rx;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        bVar.gq = currentTimeMillis;
        bVar.f9538rx = i2 + 1;
        y.T(context, bVar.toJson().toString());
    }

    private static boolean b(long j2, long j3) {
        return j2 > 0 && j3 > 0 && j2 / 2460601000L == j3 / 2460601000L;
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.a.a.az(adInfo) + 1, 1);
        boolean d2 = d(context, max);
        c(context, max);
        return d2 && e(context, com.kwad.sdk.core.response.a.a.aA(adInfo));
    }

    private static void c(@NonNull Context context, int i2) {
        int bT = y.bT(context);
        if (bT % i2 == 0) {
            y.k(context, 1);
        } else {
            y.k(context, bT + 1);
        }
    }

    private static boolean d(@NonNull Context context, int i2) {
        return i2 != 0 && y.bT(context) % i2 == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.c.b r2 = new com.kwad.components.ad.reward.c.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.y.bU(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L2b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.gq     // Catch: java.lang.Exception -> L27
            boolean r7 = b(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L2b
            int r7 = r2.f9538rx     // Catch: java.lang.Exception -> L27
            goto L2c
        L27:
            r7 = move-exception
            com.kwad.sdk.core.d.b.printStackTraceOnly(r7)
        L2b:
            r7 = 0
        L2c:
            if (r7 >= r8) goto L30
            r7 = 1
            return r7
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.c.a.e(android.content.Context, int):boolean");
    }
}
