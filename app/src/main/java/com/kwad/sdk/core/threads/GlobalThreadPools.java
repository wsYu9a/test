package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static final int aEI;
    private static final int aEJ;
    private static final int aEK;
    private static Map<String, WeakReference<ExecutorService>> aEL;
    private static Map<String, Integer> aEM;

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$1 */
    public class AnonymousClass1 implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "ksad-ashelper");
            thread.setPriority(3);
            return thread;
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$2 */
    public class AnonymousClass2 implements a {
        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, 3), GlobalThreadPools.a("async", ParamType.MAX, 3), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$3 */
    public class AnonymousClass3 implements a {
        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4 */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aEN;

        static {
            int[] iArr = new int[ParamType.values().length];
            aEN = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aEN[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aEN[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    public interface a {
        @NonNull
        ExecutorService Hx();
    }

    public static class b implements a {
        private b() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aEJ), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aEK), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public static class c implements a {
        private c() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }

    public static class d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public d(int i10, String str) {
            this.threadPriority = i10;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static class e implements a {
        private e() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "uil-pool-"));
        }

        public /* synthetic */ e(byte b10) {
            this();
        }
    }

    public static class f implements a {
        private f() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }

        public /* synthetic */ f(byte b10) {
            this();
        }
    }

    public static class g implements a {
        private g() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "report-"));
        }

        public /* synthetic */ g(byte b10) {
            this();
        }
    }

    public static class h implements a {
        private h() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "backSingle"));
        }

        public /* synthetic */ h(byte b10) {
            this();
        }
    }

    public static class i implements a {
        private i() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService Hx() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "videoCache"));
        }

        public /* synthetic */ i(byte b10) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aEI = availableProcessors;
        int i10 = availableProcessors > 0 ? availableProcessors + 4 : 9;
        aEJ = i10;
        aEK = i10;
        TAG = "GlobalThreadPools";
        aEL = new ConcurrentHashMap();
        aEM = new ConcurrentHashMap();
    }

    public static void Hh() {
        for (String str : aEL.keySet()) {
            if (aEL.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aEL.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int a10 = a(str, ParamType.CORE, corePoolSize);
                int a11 = a(str, ParamType.MAX, maximumPoolSize);
                try {
                    threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                } catch (IllegalArgumentException e10) {
                    e10.printStackTrace();
                }
                if (corePoolSize != a10 || maximumPoolSize != a11) {
                    if (corePoolSize <= a11) {
                        threadPoolExecutor.setMaximumPoolSize(a11);
                        threadPoolExecutor.setCorePoolSize(a10);
                    } else if (a10 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a10);
                        threadPoolExecutor.setMaximumPoolSize(a11);
                    }
                }
            }
        }
    }

    public static ExecutorService Hi() {
        return a("lruDiskCache", new f((byte) 0));
    }

    public static ExecutorService Hj() {
        return a("backSingle", new h((byte) 0));
    }

    public static synchronized ExecutorService Hk() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTask");
            a10 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a10;
    }

    public static synchronized ExecutorService Hl() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderCachedImages");
            a10 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a10;
    }

    public static ExecutorService Hm() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new c((byte) 0));
    }

    public static synchronized ExecutorService Hn() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forBaseBatchReporter");
            a10 = a("report", new g((byte) 0));
        }
        return a10;
    }

    public static synchronized ExecutorService Ho() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forAdReportManager");
            a10 = a("report", new g((byte) 0));
        }
        return a10;
    }

    public static ExecutorService Hp() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseNetwork");
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService Hq() {
        com.kwad.sdk.core.d.c.d(TAG, "forHttpCacheServer");
        return a("videoCache", new i((byte) 0));
    }

    public static ExecutorService Hr() {
        com.kwad.sdk.core.d.c.d(TAG, "forAppStatusHelper");
        return new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService Hs() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService Hx() {
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, 3), GlobalThreadPools.a("async", ParamType.MAX, 3), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService Ht() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsyncSchedule");
        ExecutorService a10 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService Hx() {
                return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
            }
        });
        return a10 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a10 : new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
    }

    public static Set<String> Hu() {
        return aEL.keySet();
    }

    public static int a(String str, ParamType paramType, int i10) {
        String str2;
        int i11 = AnonymousClass4.aEN[paramType.ordinal()];
        if (i11 == 1) {
            str2 = str + "_core";
        } else if (i11 == 2) {
            str2 = str + "_max";
        } else {
            if (i11 != 3) {
                return i10;
            }
            str2 = str + "_keep_alive";
        }
        return (!aEM.containsKey(str2) || aEM.get(str2) == null) ? i10 : aEM.get(str2).intValue();
    }

    public static ExecutorService eF(String str) {
        if (!aEL.containsKey(str) || aEL.get(str) == null) {
            return null;
        }
        return aEL.get(str).get();
    }

    public static void q(String str, int i10) {
        aEM.put(str, Integer.valueOf(i10));
    }

    @NonNull
    private static ExecutorService a(String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = aEL.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService Hx = aVar.Hx();
        aEL.put(str, new WeakReference<>(Hx));
        return Hx;
    }
}
