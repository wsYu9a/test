package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.STManager;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public static boolean f16304a = false;

    /* renamed from: b */
    private static String f16305b = null;

    /* renamed from: c */
    private static volatile boolean f16306c = false;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f16305b)) {
            f16305b = com.opos.cmn.biz.a.d.a(context);
        }
        return f16305b;
    }

    public static void a() {
        f16306c = true;
    }

    public static void a(Context context, String str) {
        com.opos.cmn.biz.a.d.a(context, str);
    }

    public static void a(boolean z) {
        f16304a = z;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(null)) {
            return com.opos.cmn.biz.a.b.a(context);
        }
        return null;
    }

    public static void b(Context context, String str) {
        com.opos.cmn.biz.a.b.a(context, str);
    }

    public static boolean b() {
        return f16306c;
    }

    public static void c(Context context) {
        if (context != null) {
            try {
                com.opos.cmn.g.a.b.d(context);
                boolean z = STManager.REGION_OF_CN.equalsIgnoreCase(a(context)) ? false : true;
                d.a("InitUtil", "isOverseas=".concat(String.valueOf(z)));
                if (z) {
                    com.opos.cmn.g.a.b.f(context);
                }
            } catch (Exception e2) {
                d.c("InitUtil", "", e2);
            }
        }
    }
}
