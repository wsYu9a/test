package com.opos.cmn.b.a;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public final class a {
    public static String a(Date date) {
        if (date != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DateTool", "getTimeToMil", e2);
            }
        }
        return "";
    }

    public static Date a() {
        return new Date();
    }

    public static String b() {
        try {
            return a(a());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("DateTool", "getNowTimeToMil", e2);
            return "";
        }
    }

    public static long c() {
        return System.currentTimeMillis();
    }
}
