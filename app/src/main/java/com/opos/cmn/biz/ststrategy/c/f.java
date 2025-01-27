package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.envdev.api.EnvDevConfig;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static final String f16838a = "f";

    public static String a(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            str = EnvDevConfig.getSTConfigUrl(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            return com.opos.cmn.biz.d.b.a.a(context);
        }
        String a2 = com.opos.cmn.biz.d.b.a.a(context);
        com.opos.cmn.an.f.a.b(f16838a, "getSTConfigUrl pub=" + a2);
        return str;
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean b(Context context) {
        boolean a2 = com.opos.cmn.biz.d.b.a.a();
        com.opos.cmn.an.f.a.b(f16838a, "isOverseas=" + a2);
        return a2;
    }

    public static boolean c(Context context) {
        boolean z;
        if (context != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f16838a, "", e2);
            }
            if (com.opos.cmn.biz.a.d.a(context).equalsIgnoreCase(d.b(context))) {
                z = true;
                com.opos.cmn.an.f.a.b(f16838a, "isLastRegion=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f16838a, "isLastRegion=" + z);
        return z;
    }
}
