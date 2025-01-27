package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: classes4.dex */
public class e {
    public static String a(Context context) {
        String str = "";
        try {
            str = b.c.b.a.a.a(String.valueOf(com.opos.cmn.an.h.d.a.b(context, context.getPackageName())), d.a(context), b(context), "");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e2);
        }
        com.opos.cmn.an.f.a.b("RouteDataTool", "getRouteDataValue=" + str);
        return str;
    }

    private static String b(Context context) {
        String str = "";
        try {
            String b2 = com.opos.cmn.g.a.b.b(context);
            if (com.opos.cmn.an.c.a.a(b2)) {
                b2 = com.opos.cmn.g.a.c.a(context);
            }
            str = (Math.abs(b2.hashCode()) % 100000) + "";
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e2);
        }
        com.opos.cmn.an.f.a.b("RouteDataTool", "getAdgValue=" + str);
        return str;
    }
}
