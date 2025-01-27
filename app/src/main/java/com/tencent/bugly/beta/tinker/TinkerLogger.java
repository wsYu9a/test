package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog;

/* loaded from: classes4.dex */
public class TinkerLogger implements TinkerLog.TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String TAG = "Tinker.TinkerLogger";
    private static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i2) {
        level = i2;
        Log.w(TAG, "new log level: " + i2);
    }

    public void d(String str, String str2, Object... objArr) {
        if (level <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }
    }

    public void e(String str, String str2, Object... objArr) {
        if (level <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }
    }

    public void i(String str, String str2, Object... objArr) {
        if (level <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2 + "  " + Log.getStackTraceString(th));
    }

    public void v(String str, String str2, Object... objArr) {
        if (level <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }
    }

    public void w(String str, String str2, Object... objArr) {
        if (level <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }
    }
}
