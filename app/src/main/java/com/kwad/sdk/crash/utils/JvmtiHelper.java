package com.kwad.sdk.crash.utils;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Keep
/* loaded from: classes3.dex */
public class JvmtiHelper {
    private static final String AGENT_LIB = "ti-monitor";
    private static final long DELAY_MS = 200;
    public static final String KEY = "TI_PERF_MONITOR";
    private static final long LOW_MEM_THRESHOLD = 209715200;
    private static final int MB = 1048576;
    private static final int MIN_ALLOC_SIZE = 3145728;
    private static final int MIN_CLASS_LEN = 10485760;
    private static final int MIN_INTERVAL = 10;
    public static final String TAG = "jvmti";
    private static boolean isJdwpEnable = false;
    private static int mAllocRealSetting = 0;
    private static int mLoadSizeRealSetting = 0;
    private static boolean mLoaded = false;
    private static long preAllocEventTime;
    private static String preAllocMsg;
    private static String preClassLoadMsg;

    public static native boolean avoidDeoptForReleaseBuild();

    public static native boolean disableJdwp();

    private static void doAllocAsyncReport(String str, long j10) {
    }

    private static void doClazzLoadAsyncReport(String str) {
        System.currentTimeMillis();
    }

    private static void doGCAsyncReport(String str) {
        System.currentTimeMillis();
    }

    public static native boolean enableJdwp();

    @RequiresApi(api = 26)
    public static boolean ensureAgentLoad() {
        loadLibrary("openjdkjvmti");
        return true;
    }

    @Keep
    public static void fastUnwindStack(String str) {
        try {
            for (StackTraceElement stackTraceElement : frameInfoToTrace(str)) {
                Log.d(TAG, "TODO(deal) " + stackTraceElement.toString());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static native StackTraceElement[] frameInfoToTrace(String str);

    public static int getAllocSizeRealSetting() {
        return mAllocRealSetting;
    }

    public static int getLoadSizeRealSetting() {
        return mLoadSizeRealSetting;
    }

    private static native long getObjectSize(Object obj);

    public static boolean isJDWPEnable() {
        return isJdwpEnable;
    }

    public static boolean isLoaded() {
        return mLoaded;
    }

    public static boolean loadLibrary(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "java.lang.System");
            ((Method) declaredMethod2.invoke(cls, "loadLibrary", new Class[]{String.class})).invoke(cls, str);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        return true;
    }

    private static native boolean loadTiAgent();

    @Keep
    public static void logEvent(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!str.startsWith("alloc_obj")) {
                if (str.startsWith("gc_start")) {
                    doGCAsyncReport(str);
                    return;
                } else {
                    if (!str.startsWith("class_load") || str.equals(preClassLoadMsg)) {
                        return;
                    }
                    preClassLoadMsg = str;
                    doClazzLoadAsyncReport(str);
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - preAllocEventTime >= 10 && !str.equals(preAllocMsg)) {
                preAllocEventTime = currentTimeMillis;
                preAllocMsg = str;
                doAllocAsyncReport(str, currentTimeMillis);
                return;
            }
            preAllocEventTime = currentTimeMillis;
            preAllocMsg = str;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static native void setConfig(int i10, int i11, int i12, int i13, boolean z10, boolean z11, String str, boolean z12);

    private static boolean unlikely(boolean z10) {
        return z10;
    }

    private static native boolean unloadAgent();

    public static void unloadTiAgent() {
        if (mLoaded) {
            unloadAgent();
            mLoaded = false;
        }
    }
}
