package com.czhj.sdk.common.utils;

import android.os.Looper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.IllegalFormatException;

/* loaded from: classes2.dex */
public final class Preconditions {

    /* renamed from: a */
    public static final String f8653a = "";

    public static final class NoThrow {

        /* renamed from: a */
        public static volatile boolean f8654a = true;

        public static boolean checkArgument(boolean z10) {
            return Preconditions.b(z10, f8654a, "Illegal argument", "");
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.b(obj, f8654a, (String) null, "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.b(f8654a, str, "");
        }

        public static String getLineInfo() {
            try {
                StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
                return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getMethodName();
            } catch (Throwable unused) {
                return "";
            }
        }

        public static boolean checkArgument(boolean z10, String str) {
            return Preconditions.b(z10, f8654a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.b(obj, f8654a, str, "");
        }
    }

    public static boolean b(boolean z10, boolean z11, String str, Object... objArr) {
        if (z10) {
            return true;
        }
        String a10 = a(str, objArr);
        if (z11) {
            throw new IllegalArgumentException(a10);
        }
        SigmobLog.e(a10);
        return false;
    }

    public static boolean c(boolean z10, boolean z11, String str, Object... objArr) {
        if (z10) {
            return true;
        }
        String a10 = a(str, objArr);
        if (z11) {
            throw new IllegalStateException(a10);
        }
        SigmobLog.e(a10);
        return false;
    }

    public static void checkNotNull(Object obj) {
        b(obj, true, "Object can not be null.", "");
    }

    public static boolean b(Object obj, boolean z10, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String a10 = a(str, objArr);
        if (z10) {
            throw new NullPointerException(a10);
        }
        SigmobLog.e(a10);
        return false;
    }

    public static boolean b(boolean z10, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String a10 = a(str, objArr);
        if (z10) {
            throw new IllegalStateException(a10);
        }
        SigmobLog.e(a10);
        return false;
    }

    public static String a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e10) {
            SigmobLog.e("Sigmob preconditions had a format exception: " + e10.getMessage());
            return valueOf;
        }
    }
}
