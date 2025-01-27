package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class e {
    public static boolean a(Context context, long j10, long j11) {
        p.d("ClientReportUtil", "report message: " + j10 + ", reportType: " + j11);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j11);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j10));
        String b10 = z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b10)) {
            hashMap.put("remoteAppId", b10);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        return true;
    }

    public static boolean a(long j10, HashMap<String, String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j10);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.e.a().a(xVar);
        return true;
    }
}
