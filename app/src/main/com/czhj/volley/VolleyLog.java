package com.czhj.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p1.b;

/* loaded from: classes2.dex */
public class VolleyLog {
    public static boolean DEBUG = false;
    public static String TAG = "Sigmob-Volley";

    /* renamed from: a, reason: collision with root package name */
    public static final String f8746a = "com.czhj.volley.VolleyLog";

    public static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* renamed from: c, reason: collision with root package name */
        public static final long f8747c = 0;

        /* renamed from: a, reason: collision with root package name */
        public final List<Marker> f8748a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f8749b = false;

        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j10, long j11) {
                this.name = str;
                this.thread = j10;
                this.time = j11;
            }
        }

        public final long a() {
            if (this.f8748a.size() == 0) {
                return 0L;
            }
            return this.f8748a.get(r2.size() - 1).time - this.f8748a.get(0).time;
        }

        public synchronized void add(String str, long j10) {
            if (this.f8749b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f8748a.add(new Marker(str, j10, SystemClock.elapsedRealtime()));
        }

        public void finalize() {
            if (this.f8749b) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void finish(String str) {
            this.f8749b = true;
            long a10 = a();
            if (a10 <= 0) {
                return;
            }
            long j10 = this.f8748a.get(0).time;
            VolleyLog.d("(%-4d ms) %s", Long.valueOf(a10), str);
            for (Marker marker : this.f8748a) {
                long j11 = marker.time;
                VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j11 - j10), Long.valueOf(marker.thread), marker.name);
                j10 = j11;
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i10 = 2;
        while (true) {
            if (i10 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i10].getClassName().equals(f8746a)) {
                String className = stackTrace[i10].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + b.f29697h + stackTrace[i10].getMethodName();
                break;
            }
            i10++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG) {
            Log.d(TAG, a(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, a(str, objArr));
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, a(str, objArr));
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr));
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        Log.e(TAG, a(str, objArr), th2);
    }

    public static void wtf(Throwable th2, String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr), th2);
    }
}
