package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.envdev.api.EnvDevConfig;

/* loaded from: classes4.dex */
public final class b {
    public static String a(Context context) {
        String str = "";
        if (context != null) {
            try {
                str = EnvDevConfig.getReportErrorUrl(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                str = com.opos.cmn.biz.c.b.a.a(context);
            } else {
                com.opos.cmn.an.f.a.b("Utils", "getReportUrl pub=".concat(String.valueOf(com.opos.cmn.biz.c.b.a.a(context))));
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getReportUrl=".concat(String.valueOf(str)));
        return str;
    }
}
