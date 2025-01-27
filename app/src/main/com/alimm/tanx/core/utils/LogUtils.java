package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.log.tanxc_int;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.sdk.m.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class LogUtils implements NotConfused {
    private static final String LOG_TAG = "TanxAdSdk";
    private static List<String> tagCloseSwitchList;
    private static final String[] tagCloseSwitch = {"UtRequest", "TanxAdMonitor", "TanxAdMonitor-Cover"};
    private static volatile LogStatus logStatus = LogStatus.LOG_DEFAULT;

    /* renamed from: com.alimm.tanx.core.utils.LogUtils$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[LogStatus.values().length];
            tanxc_do = iArr;
            try {
                iArr[LogStatus.LOG_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tanxc_do[LogStatus.LOG_DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[LogStatus.LOG_ALL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void d(String str, String str2) {
        tanxc_int.tanxc_do().write("d", str, str2);
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
        }
    }

    public static void d2print(String str, String str2) {
        startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
    }

    public static void e(String str, String str2) {
        e(str, str2, "");
    }

    private static String getLogString(String str, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    public static String getStackTraceMessage(Throwable th2) {
        if (th2 == null) {
            return "本次throwable为null";
        }
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static void i(String str, String str2) {
        tanxc_int.tanxc_do().write("i", str, str2);
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "i");
        }
    }

    public static boolean isDebug(String str) {
        try {
            str.hashCode();
            if (!TanxCoreSdk.getConfig().isDebugMode()) {
                if (!Log.isLoggable(LOG_TAG, 2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            Log.e("isDebug", getStackTraceMessage(e10));
            return false;
        }
    }

    public static boolean isLogSwitch(String str, String str2) {
        try {
            int i10 = AnonymousClass1.tanxc_do[logStatus.ordinal()];
            if (i10 == 1) {
                return str2.equals(e.TAG);
            }
            if (i10 != 2) {
                return i10 != 3;
            }
            if (tagCloseSwitchList == null) {
                tagCloseSwitchList = Arrays.asList(tagCloseSwitch);
            }
            return isDebug(str2) && (tagCloseSwitchList.contains(str) ^ true);
        } catch (Exception e10) {
            Log.e("isLogSwitch", getStackTraceMessage(e10));
            return true;
        }
    }

    public static void setLogStatus(LogStatus logStatus2) {
        logStatus = logStatus2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void startPrint(String str, String str2, String str3) {
        String str4;
        int length;
        str4 = str2 + " [SDK Version:" + SdkConstant.getSdkVersion() + "]";
        length = 2001 - str.length();
        str3.hashCode();
        switch (str3) {
            case "d":
                while (str4.length() > length) {
                    Log.d(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.d(str, str4);
                break;
            case "e":
                while (str4.length() > length) {
                    Log.e(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.e(str, str4);
                break;
            case "i":
                while (str4.length() > length) {
                    Log.i(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.i(str, str4);
                break;
            case "v":
                while (str4.length() > length) {
                    Log.v(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.v(str, str4);
                break;
            case "w":
                while (str4.length() > length) {
                    Log.w(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.w(str, str4);
                break;
        }
    }

    public static void v(String str, String str2) {
        tanxc_int.tanxc_do().write("v", str, str2);
        if (isLogSwitch(str, "v")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "v");
        }
    }

    public static void w(String str, String... strArr) {
        tanxc_int.tanxc_do().write(IAdInterListener.AdReqParam.WIDTH, str, getLogString(str, strArr));
        if (isLogSwitch(str, IAdInterListener.AdReqParam.WIDTH)) {
            startPrint(LOG_TAG, getLogString(str, strArr), IAdInterListener.AdReqParam.WIDTH);
        }
    }

    public static void e(String str, String str2, String str3) {
        tanxc_int.tanxc_do().write(e.TAG, str, str2);
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, e.TAG);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        tanxc_int.tanxc_do().write("d", str, str2 + getStackTraceMessage(th2));
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2 + getStackTraceMessage(th2), "d");
        }
    }

    public static void i(String str, String... strArr) {
        tanxc_int.tanxc_do().write("i", str, getLogString(str, strArr));
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "i");
        }
    }

    public static void e(Exception exc) {
        e("", exc);
    }

    public static void e(String str, Exception exc) {
        e(str, exc, "");
    }

    public static void d(String str, String... strArr) {
        tanxc_int.tanxc_do().write("d", str, getLogString(str, strArr));
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "d");
        }
    }

    public static void e(String str, Exception exc, String str2) {
        tanxc_int.tanxc_do().write(e.TAG, str, getStackTraceMessage(exc));
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + getStackTraceMessage(exc), e.TAG);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        String str3 = str2 + getStackTraceMessage(th2);
        tanxc_int.tanxc_do().write(e.TAG, str, str3);
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + str3, e.TAG);
        }
    }
}
