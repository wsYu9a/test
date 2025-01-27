package ak;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
public final class f implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater<f> f253d = AtomicLongFieldUpdater.newUpdater(f.class, "c");

    /* renamed from: b, reason: collision with root package name */
    public final String f254b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f255c;

    public f(String str) {
        this.f254b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f254b + f253d.incrementAndGet(this));
        thread.setDaemon(true);
        return thread;
    }
}
