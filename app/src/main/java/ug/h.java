package ug;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    public static final String f31081a = "UserReportAddThreadPool";

    /* renamed from: b */
    public static final int f31082b = 2;

    /* renamed from: c */
    public static final int f31083c = 4;

    /* renamed from: d */
    public static final int f31084d = 60;

    /* renamed from: e */
    public static final int f31085e = 100;

    /* renamed from: f */
    public static long f31086f;

    /* renamed from: g */
    public static ThreadPoolExecutor f31087g;

    /* renamed from: h */
    public static Handler f31088h;

    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "UserReportAddThreadPool-" + h.a());
        }
    }

    public static class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Runnable f31089b;

        public c(Runnable runnable) {
            this.f31089b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b(this.f31089b);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new a());
        f31087g = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f31087g.setRejectedExecutionHandler(new b());
    }

    public static /* synthetic */ long a() {
        long j10 = f31086f;
        f31086f = 1 + j10;
        return j10;
    }

    public static void b(Runnable runnable) {
        try {
            f31087g.execute(runnable);
        } catch (Throwable unused) {
            e.c(f31081a, "post error");
        }
    }

    public static void c(Runnable runnable, int i10) {
        if (i10 == 0) {
            b(runnable);
        } else if (i10 > 0) {
            if (f31088h == null) {
                f31088h = new Handler(Looper.getMainLooper());
            }
            f31088h.postDelayed(new c(runnable), i10);
        }
    }

    public static void d(Runnable runnable) {
        Handler handler = f31088h;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }
}
