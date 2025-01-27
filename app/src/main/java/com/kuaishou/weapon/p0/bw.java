package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class bw {

    /* renamed from: a */
    private static String f9147a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b */
    private static String f9148b = c.b(f9148b, 2);

    /* renamed from: b */
    private static String f9148b = c.b(f9148b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c2);
        return str2;
    }

    public static void a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext())) {
                Settings.System.putString(context.getContentResolver(), f9147a, str);
            }
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        String c2 = c(context);
        String d2 = d(context);
        if (!TextUtils.isEmpty(c2) && TextUtils.equals(c2, d2)) {
            return c2;
        }
        if (!TextUtils.isEmpty(c2)) {
            b(context, c2);
            return c2;
        }
        if (TextUtils.isEmpty(d2)) {
            return "";
        }
        a(context, d2);
        return d2;
    }

    public static void b(Context context, String str) {
        de.a(context).d(str);
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f9147a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return de.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }
}
