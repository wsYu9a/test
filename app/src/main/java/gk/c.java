package gk;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: b */
    public static final String f26328b = "RxScheduledExecutorPool-";

    /* renamed from: c */
    public static final ak.f f26329c = new ak.f(f26328b);

    /* renamed from: d */
    public static final c f26330d = new c();

    /* renamed from: a */
    public final ScheduledExecutorService f26331a;

    public c() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        availableProcessors = availableProcessors > 4 ? availableProcessors / 2 : availableProcessors;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(availableProcessors > 8 ? 8 : availableProcessors, f26329c);
        if (!zj.b.k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            zj.b.g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f26331a = newScheduledThreadPool;
    }

    public static ScheduledExecutorService a() {
        return f26330d.f26331a;
    }
}
