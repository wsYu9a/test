package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a */
    private static boolean f34709a = false;

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    public static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                th3.printStackTrace();
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    public static void a(boolean z) {
        f34709a = z;
    }

    public static boolean a(Context context, String[] strArr) {
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String b(String str) {
        try {
            e a2 = com.yxcorp.kuaishou.addfp.c.a.a.a(str, false);
            return !TextUtils.isEmpty(a2.f34704b) ? a2.f34704b : (TextUtils.isEmpty(a2.f34705c) || !a2.f34705c.contains("denied")) ? TextUtils.isEmpty(a2.f34704b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_PE";
        }
    }
}
