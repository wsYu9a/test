package o1;

import androidx.annotation.NonNull;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: e */
    public static final AtomicInteger f28997e = new AtomicInteger(1);

    /* renamed from: b */
    public final AtomicInteger f28998b = new AtomicInteger(1);

    /* renamed from: c */
    public final ThreadGroup f28999c;

    /* renamed from: d */
    public final String f29000d;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            n1.a.f28723e.info("ARouter::", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th2.getMessage() + "]");
        }
    }

    public c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f28999c = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f29000d = "ARouter task pool No." + f28997e.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.f29000d + this.f28998b.getAndIncrement();
        n1.a.f28723e.info("ARouter::", "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f28999c, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
