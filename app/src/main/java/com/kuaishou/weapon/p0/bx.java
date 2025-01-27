package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class bx {

    /* renamed from: a */
    private static String f10861a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b */
    private static String f10862b = c.b(f10862b, 2);

    /* renamed from: b */
    private static String f10862b = c.b(f10862b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c10 = c(context);
        if (TextUtils.isEmpty(c10)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c10);
        return str2;
    }

    public static String b(Context context) {
        String c10 = c(context);
        String d10 = d(context);
        if (!TextUtils.isEmpty(c10) && TextUtils.equals(c10, d10)) {
            return c10;
        }
        if (!TextUtils.isEmpty(c10)) {
            b(context, c10);
            return c10;
        }
        if (TextUtils.isEmpty(d10)) {
            return "";
        }
        a(context, d10);
        return d10;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f10861a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        boolean canWrite;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                canWrite = Settings.System.canWrite(context.getApplicationContext());
                if (!canWrite) {
                    return;
                }
            }
            Settings.System.putString(context.getContentResolver(), f10861a, str);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}
