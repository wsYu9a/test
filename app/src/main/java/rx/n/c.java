package rx.n;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes5.dex */
final class c {

    /* renamed from: a */
    private static final String f36945a = "RxScheduledExecutorPool-";

    /* renamed from: b */
    private static final rx.internal.util.f f36946b = new rx.internal.util.f(f36945a);

    /* renamed from: c */
    private static final c f36947c = new c();

    /* renamed from: d */
    private final ScheduledExecutorService f36948d;

    private c() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        availableProcessors = availableProcessors > 4 ? availableProcessors / 2 : availableProcessors;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(availableProcessors > 8 ? 8 : availableProcessors, f36946b);
        if (!rx.internal.schedulers.b.m(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            rx.internal.schedulers.b.i((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f36948d = newScheduledThreadPool;
    }

    public static ScheduledExecutorService a() {
        return f36947c.f36948d;
    }
}
