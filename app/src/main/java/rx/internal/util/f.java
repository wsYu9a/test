package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
public final class f implements ThreadFactory {

    /* renamed from: a */
    static final AtomicLongFieldUpdater<f> f36791a = AtomicLongFieldUpdater.newUpdater(f.class, "c");

    /* renamed from: b */
    final String f36792b;

    /* renamed from: c */
    volatile long f36793c;

    public f(String str) {
        this.f36792b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f36792b + f36791a.incrementAndGet(this));
        thread.setDaemon(true);
        return thread;
    }
}
