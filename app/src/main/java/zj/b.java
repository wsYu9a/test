package zj;

import ak.f;
import ak.i;
import fk.e;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import qj.h;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes5.dex */
public class b extends d.a implements h {

    /* renamed from: g */
    public static final String f33861g = "RxSchedulerPurge-";

    /* renamed from: b */
    public final ScheduledExecutorService f33866b;

    /* renamed from: c */
    public final e f33867c;

    /* renamed from: d */
    public volatile boolean f33868d;

    /* renamed from: j */
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f33864j = new ConcurrentHashMap<>();

    /* renamed from: k */
    public static final AtomicReference<ScheduledExecutorService> f33865k = new AtomicReference<>();

    /* renamed from: f */
    public static final String f33860f = "rx.scheduler.jdk6.purge-force";

    /* renamed from: h */
    public static final boolean f33862h = Boolean.getBoolean(f33860f);

    /* renamed from: e */
    public static final String f33859e = "rx.scheduler.jdk6.purge-frequency-millis";

    /* renamed from: i */
    public static final int f33863i = Integer.getInteger(f33859e, 1000).intValue();

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.f();
        }
    }

    public b(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f33867c = fk.d.b().e();
        this.f33866b = newScheduledThreadPool;
    }

    public static void e(ScheduledExecutorService scheduledExecutorService) {
        f33864j.remove(scheduledExecutorService);
    }

    public static void f() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f33864j.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th2) {
            vj.a.e(th2);
            fk.d.b().a().a(th2);
        }
    }

    public static void g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f33865k;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new f(f33861g));
            if (k0.e.a(atomicReference, null, newScheduledThreadPool)) {
                a aVar = new a();
                int i10 = f33863i;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i10, i10, TimeUnit.MILLISECONDS);
                break;
            }
        }
        f33864j.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean k(ScheduledExecutorService scheduledExecutorService) {
        if (!f33862h) {
            for (Method method : scheduledExecutorService.getClass().getMethods()) {
                if (method.getName().equals("setRemoveOnCancelPolicy") && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == Boolean.TYPE) {
                    try {
                        method.invoke(scheduledExecutorService, Boolean.TRUE);
                        return true;
                    } catch (Exception e10) {
                        fk.d.b().a().a(e10);
                    }
                }
            }
        }
        return false;
    }

    @Override // qj.d.a
    public h b(wj.a aVar) {
        return c(aVar, 0L, null);
    }

    @Override // qj.d.a
    public h c(wj.a aVar, long j10, TimeUnit timeUnit) {
        return this.f33868d ? ik.f.e() : h(aVar, j10, timeUnit);
    }

    public ScheduledAction h(wj.a aVar, long j10, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f33867c.e(aVar));
        scheduledAction.add(j10 <= 0 ? this.f33866b.submit(scheduledAction) : this.f33866b.schedule(scheduledAction, j10, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction i(wj.a aVar, long j10, TimeUnit timeUnit, i iVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f33867c.e(aVar), iVar);
        iVar.a(scheduledAction);
        scheduledAction.add(j10 <= 0 ? this.f33866b.submit(scheduledAction) : this.f33866b.schedule(scheduledAction, j10, timeUnit));
        return scheduledAction;
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f33868d;
    }

    public ScheduledAction j(wj.a aVar, long j10, TimeUnit timeUnit, ik.b bVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f33867c.e(aVar), bVar);
        bVar.a(scheduledAction);
        scheduledAction.add(j10 <= 0 ? this.f33866b.submit(scheduledAction) : this.f33866b.schedule(scheduledAction, j10, timeUnit));
        return scheduledAction;
    }

    @Override // qj.h
    public void unsubscribe() {
        this.f33868d = true;
        this.f33866b.shutdownNow();
        e(this.f33866b);
    }
}
