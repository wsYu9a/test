package com.bytedance.android.openliveplugin.stub.logger;

import android.util.Log;
import p1.b;

/* loaded from: classes2.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    public static void d(String str) {
        if (DEBUG) {
            d(TAG, str);
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void e(String str) {
        if (DEBUG) {
            e(TAG, str);
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = objArr[i10];
            sb2.append(obj != null ? obj.toString() : " null ");
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void i(String str) {
        if (DEBUG) {
            i(TAG, str);
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = TAG;
        }
        Log.i(str, str2);
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i10) {
        sLevel = i10;
    }

    public static void st(String str, int i10) {
        try {
            throw new Exception();
        } catch (Exception e10) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 1; i11 < Math.min(i10, stackTrace.length); i11++) {
                if (i11 > 1) {
                    sb2.append("\n");
                }
                sb2.append(getSimpleClassName(stackTrace[i11].getClassName()));
                sb2.append(b.f29697h);
                sb2.append(stackTrace[i11].getMethodName());
            }
            v(str, sb2.toString());
        }
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void w(String str) {
        if (DEBUG) {
            w(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 3) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 6) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 4) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 2) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 5) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (DEBUG) {
            if (!(str2 == null && th2 == null) && sLevel <= 3) {
                Log.d(str, str2, th2);
            }
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (DEBUG) {
            if (!(str2 == null && th2 == null) && sLevel <= 6) {
                Log.e(str, str2, th2);
            }
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (DEBUG) {
            if (!(str2 == null && th2 == null) && sLevel <= 4) {
                Log.i(str, str2, th2);
            }
        }
    }

    public static void v(String str, String str2, Throwable th2) {
        if (DEBUG) {
            if (!(str2 == null && th2 == null) && sLevel <= 2) {
                Log.v(str, str2, th2);
            }
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (DEBUG) {
            if (!(str2 == null && th2 == null) && sLevel <= 5) {
                Log.w(str, str2, th2);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            Log.d(str, formatMsgs(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    public static void i(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            Log.v(str, formatMsgs(objArr));
        }
    }
}
