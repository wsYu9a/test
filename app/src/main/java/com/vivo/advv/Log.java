package com.vivo.advv;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes4.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int LOG_ID_CRASH = 4;
    public static final int LOG_ID_EVENTS = 2;
    public static final int LOG_ID_MAIN = 0;
    public static final int LOG_ID_RADIO = 1;
    public static final int LOG_ID_SYSTEM = 3;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static boolean sEnableLog = false;

    private Log() {
    }

    public static int d(String str, String str2) {
        return println(0, 3, str, str2);
    }

    public static int e(String str, String str2) {
        return println(0, 6, str, str2);
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static int i(String str, String str2) {
        return println(0, 4, str, str2);
    }

    public static int println(int i2, String str, String str2) {
        return println(0, i2, str, str2);
    }

    public static void setEnableLog(boolean z) {
        sEnableLog = z;
    }

    public static int v(String str, String str2) {
        return println(0, 2, str, str2);
    }

    public static int w(String str, String str2) {
        return println(0, 5, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return println(0, 3, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int e(String str, String str2, Throwable th) {
        return println(0, 6, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int i(String str, String str2, Throwable th) {
        return println(0, 4, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int println(int i2, int i3, String str, String str2) {
        if (!sEnableLog) {
            return -1;
        }
        System.out.println(str2);
        return 0;
    }

    public static int v(String str, String str2, Throwable th) {
        return println(0, 2, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, String str2, Throwable th) {
        return println(0, 5, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return println(0, 5, str, getStackTraceString(th));
    }
}
