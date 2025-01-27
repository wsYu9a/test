package com.kwad.sdk.h;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class j {
    private static final AtomicInteger aNS = new AtomicInteger(1);
    private static final ExecutorService aNT = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.h.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aNS.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aMO = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.h.j$1 */
    public class AnonymousClass1 implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aNS.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }

    public static boolean H(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static void Lb() {
    }

    public static void Lc() {
    }

    public static void a(n nVar) {
        aNT.execute(nVar);
    }

    public static void ak(String str, String str2) {
        Log.d(gp(str), dZ(str2));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String dZ(String str) {
        return str + " " + yd();
    }

    private static String gp(String str) {
        return "KSAd_LM_" + str;
    }

    public static double o(double d10) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d10)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    private static String yd() {
        return "";
    }

    public static void a(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }
}
