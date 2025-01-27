package com.alimm.tanx.core.web.cache;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WebCacheThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "WebCacheThreadPool";
    private static final ThreadPoolExecutor sExecutor;
    private static Handler sHandler;
    private static long sIndex;

    /* renamed from: com.alimm.tanx.core.web.cache.WebCacheThreadPool$1 */
    public static class AnonymousClass1 implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "WebCacheThreadPool-" + WebCacheThreadPool.access$008());
        }
    }

    /* renamed from: com.alimm.tanx.core.web.cache.WebCacheThreadPool$2 */
    public static class AnonymousClass2 implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* renamed from: com.alimm.tanx.core.web.cache.WebCacheThreadPool$3 */
    public static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Runnable val$runnable;

        public AnonymousClass3(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebCacheThreadPool.post(runnable);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.tanx.core.web.cache.WebCacheThreadPool.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "WebCacheThreadPool-" + WebCacheThreadPool.access$008());
            }
        });
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.tanx.core.web.cache.WebCacheThreadPool.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
            }
        });
    }

    public static /* synthetic */ long access$008() {
        long j10 = sIndex;
        sIndex = 1 + j10;
        return j10;
    }

    public static void post(@NonNull Runnable runnable) {
        try {
            sExecutor.execute(runnable);
        } catch (Throwable th2) {
            LogUtils.d(TAG, "UserReport :post exception", th2);
        }
    }

    public static void postDelayed(@NonNull Runnable runnable, int i10) {
        if (i10 == 0) {
            post(runnable);
        } else if (i10 > 0) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            sHandler.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.web.cache.WebCacheThreadPool.3
                final /* synthetic */ Runnable val$runnable;

                public AnonymousClass3(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    WebCacheThreadPool.post(runnable);
                }
            }, i10);
        }
    }

    public static void removeTask(@NonNull Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
