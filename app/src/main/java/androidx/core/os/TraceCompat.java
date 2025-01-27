package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class TraceCompat {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1830a = "TraceCompat";

    /* renamed from: b, reason: collision with root package name */
    private static long f1831b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f1832c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f1833d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f1834e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f1835f;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18 || i2 >= 29) {
            return;
        }
        try {
            f1831b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            f1832c = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            f1833d = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            f1834e = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            f1835f = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e2) {
            Log.i(f1830a, "Unable to initialize via reflection.", e2);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.beginAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                f1833d.invoke(null, Long.valueOf(f1831b), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(f1830a, "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.endAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                f1834e.invoke(null, Long.valueOf(f1831b), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(f1830a, "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return Trace.isEnabled();
        }
        if (i2 >= 18) {
            try {
                return ((Boolean) f1832c.invoke(null, Long.valueOf(f1831b))).booleanValue();
            } catch (Exception unused) {
                Log.v(f1830a, "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.setCounter(str, i2);
        } else if (i3 >= 18) {
            try {
                f1835f.invoke(null, Long.valueOf(f1831b), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(f1830a, "Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}
