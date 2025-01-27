package cn.vlion.ad.inland.base.util.log;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public class LogVlion {
    private static int MIN_STACK_OFFSET = 3;
    private static String TAG = "LogVlion";
    private static boolean isSdkOpenLog = false;
    private static boolean switchFileLineNumber = true;
    private static boolean switchThread = true;

    public static void e(String str) {
        try {
            if (str.startsWith(LogConstant.TAG_DOWN_STRATEGY)) {
                return;
            }
            printLog(6, str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static int getStackOffset(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return 2;
        }
        try {
            for (int i10 = MIN_STACK_OFFSET; i10 < stackTraceElementArr.length; i10++) {
                if (!TextUtils.equals(stackTraceElementArr[i10].getClassName(), LogVlion.class.getName())) {
                    return i10;
                }
            }
            return 2;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 2;
        }
    }

    private static void printLog(int i10, String str) {
        String str2;
        String substring;
        try {
            if (isSdkOpenLog) {
                StringBuilder sb2 = new StringBuilder();
                Thread currentThread = Thread.currentThread();
                if (switchThread) {
                    sb2.append("LogVlion:");
                    sb2.append("<");
                    sb2.append(currentThread.getName());
                    sb2.append("> ");
                }
                if (switchFileLineNumber) {
                    StackTraceElement[] stackTrace = currentThread.getStackTrace();
                    StackTraceElement stackTraceElement = stackTrace[getStackOffset(stackTrace)];
                    sb2.append("[");
                    sb2.append(stackTraceElement.getFileName());
                    sb2.append(":");
                    sb2.append(stackTraceElement.getLineNumber());
                    sb2.append("] ");
                }
                sb2.append(str);
                int length = sb2.length();
                if (length <= 4000) {
                    Log.println(i10, TAG, sb2.toString());
                    return;
                }
                int i11 = 0;
                while (i11 <= length) {
                    int i12 = i11 + 4000;
                    if (i12 < length) {
                        str2 = TAG;
                        substring = sb2.substring(i11, i12);
                    } else {
                        str2 = TAG;
                        substring = sb2.substring(i11, length);
                    }
                    Log.println(i10, str2, substring);
                    i11 = i12;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSdkOpenLog(boolean z10) {
        isSdkOpenLog = z10;
    }
}
