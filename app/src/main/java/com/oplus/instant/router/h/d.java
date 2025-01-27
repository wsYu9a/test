package com.oplus.instant.router.h;

import android.util.Log;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static boolean f16084a;

    public static void a() {
        f16084a = true;
    }

    public static void b(String str, String str2) {
        if (f16084a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String str3;
        StringBuilder sb;
        String message;
        if (th != null) {
            if (f16084a) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("##Throwable##");
                message = Log.getStackTraceString(th);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                message = th.getMessage();
            }
            sb.append(message);
            Log.d(str, sb.toString());
            str3 = null;
        } else {
            str3 = "throwable is null";
        }
        f(str, str2 + str3);
    }

    public static void d(String str, Throwable th) {
        c(str, "", th);
    }

    public static void e(String str, String str2) {
        if (f16084a) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2) {
        Log.e(str, str2);
    }
}
