package com.google.common.util.concurrent;

import b5.u;
import b5.z;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public abstract class d implements Service {

    /* renamed from: b */
    public static final Logger f10421b = Logger.getLogger(d.class.getName());

    /* renamed from: a */
    public final com.google.common.util.concurrent.e f10422a = new g(this, null);

    public class a extends Service.a {

        /* renamed from: a */
        public final /* synthetic */ ScheduledExecutorService f10423a;

        public a(d dVar, ScheduledExecutorService scheduledExecutorService) {
            this.f10423a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void a(Service.State state, Throwable th2) {
            this.f10423a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void e(Service.State state) {
            this.f10423a.shutdown();
        }
    }

    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return p.n(d.this.o(), runnable);
        }
    }

    public interface c {
        void cancel(boolean z10);

        boolean isCancelled();
    }

    /* renamed from: com.google.common.util.concurrent.d$d */
    public static abstract class AbstractC0311d extends f {

        /* renamed from: com.google.common.util.concurrent.d$d$a */
        public final class a implements Callable<Void> {

            /* renamed from: b */
            public final Runnable f10425b;

            /* renamed from: c */
            public final ScheduledExecutorService f10426c;

            /* renamed from: d */
            public final com.google.common.util.concurrent.e f10427d;

            /* renamed from: e */
            public final ReentrantLock f10428e = new ReentrantLock();

            /* renamed from: f */
            @CheckForNull
            @GuardedBy("lock")
            public c f10429f;

            public a(com.google.common.util.concurrent.e eVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.f10425b = runnable;
                this.f10426c = scheduledExecutorService;
                this.f10427d = eVar;
            }

            @GuardedBy("lock")
            public final c a(b bVar) {
                c cVar = this.f10429f;
                if (cVar == null) {
                    c cVar2 = new c(this.f10428e, c(bVar));
                    this.f10429f = cVar2;
                    return cVar2;
                }
                if (!cVar.f10434b.isCancelled()) {
                    this.f10429f.f10434b = c(bVar);
                }
                return this.f10429f;
            }

            @CanIgnoreReturnValue
            public c b() {
                c eVar;
                try {
                    b d10 = AbstractC0311d.this.d();
                    this.f10428e.lock();
                    try {
                        eVar = a(d10);
                        this.f10428e.unlock();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            eVar = new e(l.k());
                        } finally {
                            this.f10428e.unlock();
                        }
                    }
                    if (th != null) {
                        this.f10427d.u(th);
                    }
                    return eVar;
                } catch (Throwable th3) {
                    this.f10427d.u(th3);
                    return new e(l.k());
                }
            }

            public final ScheduledFuture<Void> c(b bVar) {
                return this.f10426c.schedule(this, bVar.f10431a, bVar.f10432b);
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.f10425b.run();
                b();
                return null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.d$d$b */
        public static final class b {

            /* renamed from: a */
            public final long f10431a;

            /* renamed from: b */
            public final TimeUnit f10432b;

            public b(long j10, TimeUnit timeUnit) {
                this.f10431a = j10;
                this.f10432b = (TimeUnit) u.E(timeUnit);
            }
        }

        /* renamed from: com.google.common.util.concurrent.d$d$c */
        public static final class c implements c {

            /* renamed from: a */
            public final ReentrantLock f10433a;

            /* renamed from: b */
            @GuardedBy("lock")
            public Future<Void> f10434b;

            public c(ReentrantLock reentrantLock, Future<Void> future) {
                this.f10433a = reentrantLock;
                this.f10434b = future;
            }

            @Override // com.google.common.util.concurrent.d.c
            public void cancel(boolean z10) {
                this.f10433a.lock();
                try {
                    this.f10434b.cancel(z10);
                } finally {
                    this.f10433a.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.d.c
            public boolean isCancelled() {
                this.f10433a.lock();
                try {
                    return this.f10434b.isCancelled();
                } finally {
                    this.f10433a.unlock();
                }
            }
        }

        public AbstractC0311d() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.d.f
        public final c c(com.google.common.util.concurrent.e eVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new a(eVar, scheduledExecutorService, runnable).b();
        }

        public abstract b d() throws Exception;
    }

    public static final class e implements c {

        /* renamed from: a */
        public final Future<?> f10435a;

        public e(Future<?> future) {
            this.f10435a = future;
        }

        @Override // com.google.common.util.concurrent.d.c
        public void cancel(boolean z10) {
            this.f10435a.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.d.c
        public boolean isCancelled() {
            return this.f10435a.isCancelled();
        }
    }

    public static abstract class f {

        public class a extends f {

            /* renamed from: a */
            public final /* synthetic */ long f10436a;

            /* renamed from: b */
            public final /* synthetic */ long f10437b;

            /* renamed from: c */
            public final /* synthetic */ TimeUnit f10438c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j10, long j11, TimeUnit timeUnit) {
                super(null);
                this.f10436a = j10;
                this.f10437b = j11;
                this.f10438c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.d.f
            public c c(com.google.common.util.concurrent.e eVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new e(scheduledExecutorService.scheduleWithFixedDelay(runnable, this.f10436a, this.f10437b, this.f10438c));
            }
        }

        public class b extends f {

            /* renamed from: a */
            public final /* synthetic */ long f10439a;

            /* renamed from: b */
            public final /* synthetic */ long f10440b;

            /* renamed from: c */
            public final /* synthetic */ TimeUnit f10441c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j10, long j11, TimeUnit timeUnit) {
                super(null);
                this.f10439a = j10;
                this.f10440b = j11;
                this.f10441c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.d.f
            public c c(com.google.common.util.concurrent.e eVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new e(scheduledExecutorService.scheduleAtFixedRate(runnable, this.f10439a, this.f10440b, this.f10441c));
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public static f a(long j10, long j11, TimeUnit timeUnit) {
            u.E(timeUnit);
            u.p(j11 > 0, "delay must be > 0, found %s", j11);
            return new a(j10, j11, timeUnit);
        }

        public static f b(long j10, long j11, TimeUnit timeUnit) {
            u.E(timeUnit);
            u.p(j11 > 0, "period must be > 0, found %s", j11);
            return new b(j10, j11, timeUnit);
        }

        public abstract c c(com.google.common.util.concurrent.e eVar, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public f() {
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a(Service.a aVar, Executor executor) {
        this.f10422a.a(aVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10422a.b(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void c(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10422a.c(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void d() {
        this.f10422a.d();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service e() {
        this.f10422a.e();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State f() {
        return this.f10422a.f();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f10422a.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable h() {
        return this.f10422a.h();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service i() {
        this.f10422a.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f10422a.isRunning();
    }

    public ScheduledExecutorService l() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        a(new a(this, newSingleThreadScheduledExecutor), p.c());
        return newSingleThreadScheduledExecutor;
    }

    public abstract void m() throws Exception;

    public abstract f n();

    public String o() {
        return getClass().getSimpleName();
    }

    public void p() throws Exception {
    }

    public void q() throws Exception {
    }

    public String toString() {
        String o10 = o();
        String valueOf = String.valueOf(f());
        StringBuilder sb2 = new StringBuilder(String.valueOf(o10).length() + 3 + valueOf.length());
        sb2.append(o10);
        sb2.append(" [");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    public final class g extends com.google.common.util.concurrent.e {

        /* renamed from: p */
        @CheckForNull
        public volatile c f10442p;

        /* renamed from: q */
        @CheckForNull
        public volatile ScheduledExecutorService f10443q;

        /* renamed from: r */
        public final ReentrantLock f10444r;

        /* renamed from: s */
        public final Runnable f10445s;

        public class a implements z<String> {
            public a() {
            }

            @Override // b5.z
            /* renamed from: a */
            public String get() {
                String o10 = d.this.o();
                String valueOf = String.valueOf(g.this.f());
                StringBuilder sb2 = new StringBuilder(String.valueOf(o10).length() + 1 + valueOf.length());
                sb2.append(o10);
                sb2.append(" ");
                sb2.append(valueOf);
                return sb2.toString();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f10444r.lock();
                try {
                    d.this.q();
                    g gVar = g.this;
                    gVar.f10442p = d.this.n().c(d.this.f10422a, g.this.f10443q, g.this.f10445s);
                    g.this.v();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    g.this.f10444r.lock();
                    try {
                        if (g.this.f() != Service.State.STOPPING) {
                            return;
                        }
                        d.this.p();
                        g.this.f10444r.unlock();
                        g.this.w();
                    } finally {
                        g.this.f10444r.unlock();
                    }
                } catch (Throwable th2) {
                    g.this.u(th2);
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.d$g$d */
        public class RunnableC0312d implements Runnable {
            public RunnableC0312d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                g.this.f10444r.lock();
                try {
                    cVar = g.this.f10442p;
                    Objects.requireNonNull(cVar);
                } finally {
                    try {
                        try {
                        } finally {
                        }
                    } catch (Exception e10) {
                    }
                }
                if (cVar.isCancelled()) {
                    return;
                }
                d.this.m();
            }
        }

        public g() {
            this.f10444r = new ReentrantLock();
            this.f10445s = new RunnableC0312d();
        }

        @Override // com.google.common.util.concurrent.e
        public final void n() {
            this.f10443q = p.s(d.this.l(), new a());
            this.f10443q.execute(new b());
        }

        @Override // com.google.common.util.concurrent.e
        public final void o() {
            Objects.requireNonNull(this.f10442p);
            Objects.requireNonNull(this.f10443q);
            this.f10442p.cancel(false);
            this.f10443q.execute(new c());
        }

        @Override // com.google.common.util.concurrent.e
        public String toString() {
            return d.this.toString();
        }

        public /* synthetic */ g(d dVar, a aVar) {
            this();
        }
    }
}
