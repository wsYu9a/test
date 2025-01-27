package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import i2.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            i2.a b10 = b(context, str, str2, str3);
            d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b10.toString());
        }
    }

    public static i2.a b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable unused) {
            str4 = "";
        }
        return new i2.a(Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202311031119", str, str2, str3);
    }

    public static synchronized void a(String str) {
        synchronized (a.class) {
            d.a(str);
        }
    }

    public static synchronized void a(Throwable th2) {
        synchronized (a.class) {
            d.c(th2);
        }
    }
}
