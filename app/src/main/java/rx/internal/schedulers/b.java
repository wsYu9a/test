package rx.internal.schedulers;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.h;
import rx.internal.util.f;
import rx.internal.util.i;
import rx.m.e;

/* loaded from: classes5.dex */
public class b extends d.a implements h {

    /* renamed from: c */
    private static final String f36747c = "RxSchedulerPurge-";

    /* renamed from: h */
    private final ScheduledExecutorService f36752h;

    /* renamed from: i */
    private final e f36753i;

    /* renamed from: j */
    volatile boolean f36754j;

    /* renamed from: f */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f36750f = new ConcurrentHashMap<>();

    /* renamed from: g */
    private static final AtomicReference<ScheduledExecutorService> f36751g = new AtomicReference<>();

    /* renamed from: b */
    private static final String f36746b = "rx.scheduler.jdk6.purge-force";

    /* renamed from: d */
    private static final boolean f36748d = Boolean.getBoolean(f36746b);

    /* renamed from: a */
    private static final String f36745a = "rx.scheduler.jdk6.purge-frequency-millis";

    /* renamed from: e */
    public static final int f36749e = Integer.getInteger(f36745a, 1000).intValue();

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h();
        }
    }

    public b(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            i((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f36753i = rx.m.d.b().e();
        this.f36752h = newScheduledThreadPool;
    }

    public static void g(ScheduledExecutorService scheduledExecutorService) {
        f36750f.remove(scheduledExecutorService);
    }

    static void h() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f36750f.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            rx.m.d.b().a().a(th);
        }
    }

    public static void i(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f36751g;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new f(f36747c));
            if (atomicReference.compareAndSet(null, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f36749e;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.MILLISECONDS);
                break;
            }
        }
        f36750f.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean m(ScheduledExecutorService scheduledExecutorService) {
        if (!f36748d) {
            for (Method method : scheduledExecutorService.getClass().getMethods()) {
                if (method.getName().equals("setRemoveOnCancelPolicy") && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == Boolean.TYPE) {
                    try {
                        method.invoke(scheduledExecutorService, Boolean.TRUE);
                        return true;
                    } catch (Exception e2) {
                        rx.m.d.b().a().a(e2);
                    }
                }
            }
        }
        return false;
    }

    @Override // rx.d.a
    public h d(rx.k.a aVar) {
        return e(aVar, 0L, null);
    }

    @Override // rx.d.a
    public h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
        return this.f36754j ? rx.p.f.e() : j(aVar, j2, timeUnit);
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f36754j;
    }

    public ScheduledAction j(rx.k.a aVar, long j2, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f36753i.e(aVar));
        scheduledAction.add(j2 <= 0 ? this.f36752h.submit(scheduledAction) : this.f36752h.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction k(rx.k.a aVar, long j2, TimeUnit timeUnit, i iVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f36753i.e(aVar), iVar);
        iVar.a(scheduledAction);
        scheduledAction.add(j2 <= 0 ? this.f36752h.submit(scheduledAction) : this.f36752h.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction l(rx.k.a aVar, long j2, TimeUnit timeUnit, rx.p.b bVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f36753i.e(aVar), bVar);
        bVar.a(scheduledAction);
        scheduledAction.add(j2 <= 0 ? this.f36752h.submit(scheduledAction) : this.f36752h.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    @Override // rx.h
    public void unsubscribe() {
        this.f36754j = true;
        this.f36752h.shutdownNow();
        g(this.f36752h);
    }
}
