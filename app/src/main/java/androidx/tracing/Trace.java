package androidx.tracing;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    @SuppressLint({"NewApi"})
    public static void beginAsyncSection(@NonNull String str, int i10) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                TraceApi29Impl.beginAsyncSection(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        beginAsyncSectionFallback(str, i10);
    }

    private static void beginAsyncSectionFallback(@NonNull String str, int i10) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            handleException("asyncTraceBegin", e10);
        }
    }

    public static void beginSection(@NonNull String str) {
        TraceApi18Impl.beginSection(str);
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String str, int i10) {
        try {
            if (sAsyncTraceEndMethod == null) {
                TraceApi29Impl.endAsyncSection(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        endAsyncSectionFallback(str, i10);
    }

    private static void endAsyncSectionFallback(@NonNull String str, int i10) {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            handleException("asyncTraceEnd", e10);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    private static void handleException(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v(TAG, "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        boolean isEnabled;
        try {
            if (sIsTagEnabledMethod == null) {
                isEnabled = android.os.Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e10) {
            handleException("isTagEnabled", e10);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String str, int i10) {
        try {
            if (sTraceCounterMethod == null) {
                TraceApi29Impl.setCounter(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        setCounterFallback(str, i10);
    }

    private static void setCounterFallback(@NonNull String str, int i10) {
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            handleException("traceCounter", e10);
        }
    }
}
