package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class e {
    public static boolean a(Context context, long j2, long j3) {
        p.d("ClientReportUtil", "report message: " + j2 + ", reportType: " + j3);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j3);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.heytap.mcssdk.n.d.n, String.valueOf(j2));
        String b2 = z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("remoteAppId", b2);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        return true;
    }

    public static boolean a(long j2, HashMap<String, String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.e.a().a(xVar);
        return true;
    }
}
