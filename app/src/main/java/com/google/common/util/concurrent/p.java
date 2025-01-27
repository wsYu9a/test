package com.google.common.util.concurrent;

import b5.a0;
import b5.u;
import b5.z;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.k;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p5.c0;
import p5.d1;
import p5.e0;
import p5.e1;
import p5.g0;
import p5.i0;
import p5.y0;

@a5.b(emulated = true)
@p5.m
/* loaded from: classes2.dex */
public final class p {

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ BlockingQueue f10530b;

        /* renamed from: c */
        public final /* synthetic */ c0 f10531c;

        public a(BlockingQueue blockingQueue, c0 c0Var) {
            this.f10530b = blockingQueue;
            this.f10531c = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10530b.add(this.f10531c);
        }
    }

    public class b implements Executor {

        /* renamed from: b */
        public final /* synthetic */ Executor f10532b;

        /* renamed from: c */
        public final /* synthetic */ z f10533c;

        public b(Executor executor, z zVar) {
            this.f10532b = executor;
            this.f10533c = zVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f10532b.execute(p5.l.k(runnable, this.f10533c));
        }
    }

    public class c extends d1 {

        /* renamed from: c */
        public final /* synthetic */ z f10534c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExecutorService executorService, z zVar) {
            super(executorService);
            this.f10534c = zVar;
        }

        @Override // p5.d1
        public Runnable c(Runnable runnable) {
            return p5.l.k(runnable, this.f10534c);
        }

        @Override // p5.d1
        public <T> Callable<T> d(Callable<T> callable) {
            return p5.l.l(callable, this.f10534c);
        }
    }

    public class d extends e1 {

        /* renamed from: d */
        public final /* synthetic */ z f10535d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ScheduledExecutorService scheduledExecutorService, z zVar) {
            super(scheduledExecutorService);
            this.f10535d = zVar;
        }

        @Override // p5.d1
        public Runnable c(Runnable runnable) {
            return p5.l.k(runnable, this.f10535d);
        }

        @Override // p5.d1
        public <T> Callable<T> d(Callable<T> callable) {
            return p5.l.l(callable, this.f10535d);
        }
    }

    public class e implements Executor {

        /* renamed from: b */
        public final /* synthetic */ Executor f10536b;

        /* renamed from: c */
        public final /* synthetic */ AbstractFuture f10537c;

        public e(Executor executor, AbstractFuture abstractFuture) {
            this.f10536b = executor;
            this.f10537c = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f10536b.execute(runnable);
            } catch (RejectedExecutionException e10) {
                this.f10537c.setException(e10);
            }
        }
    }

    @a5.d
    @a5.c
    public static class f {

        public class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ ExecutorService f10538b;

            /* renamed from: c */
            public final /* synthetic */ long f10539c;

            /* renamed from: d */
            public final /* synthetic */ TimeUnit f10540d;

            public a(f fVar, ExecutorService executorService, long j10, TimeUnit timeUnit) {
                this.f10538b = executorService;
                this.f10539c = j10;
                this.f10540d = timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f10538b.shutdown();
                    this.f10538b.awaitTermination(this.f10539c, this.f10540d);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final void a(ExecutorService executorService, long j10, TimeUnit timeUnit) {
            u.E(executorService);
            u.E(timeUnit);
            String valueOf = String.valueOf(executorService);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("DelayedShutdownHook-for-");
            sb2.append(valueOf);
            b(p.n(sb2.toString(), new a(this, executorService, j10, timeUnit)));
        }

        @a5.d
        public void b(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        public final ExecutorService c(ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        public final ExecutorService d(ThreadPoolExecutor threadPoolExecutor, long j10, TimeUnit timeUnit) {
            p.v(threadPoolExecutor);
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j10, timeUnit);
            return unconfigurableExecutorService;
        }

        public final ScheduledExecutorService e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j10, TimeUnit timeUnit) {
            p.v(scheduledThreadPoolExecutor);
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j10, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
    }

    @a5.c
    public static class h extends p5.b {

        /* renamed from: b */
        public final ExecutorService f10544b;

        public h(ExecutorService executorService) {
            this.f10544b = (ExecutorService) u.E(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.f10544b.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f10544b.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f10544b.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f10544b.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f10544b.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f10544b.shutdownNow();
        }

        public final String toString() {
            String obj = super.toString();
            String valueOf = String.valueOf(this.f10544b);
            StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2 + valueOf.length());
            sb2.append(obj);
            sb2.append("[");
            sb2.append(valueOf);
            sb2.append("]");
            return sb2.toString();
        }
    }

    @a5.c
    public static final class i extends h implements i0 {

        /* renamed from: c */
        public final ScheduledExecutorService f10545c;

        public static final class a<V> extends k.a<V> implements e0<V> {

            /* renamed from: c */
            public final ScheduledFuture<?> f10546c;

            public a(c0<V> c0Var, ScheduledFuture<?> scheduledFuture) {
                super(c0Var);
                this.f10546c = scheduledFuture;
            }

            @Override // p5.u, java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                boolean cancel = super.cancel(z10);
                if (cancel) {
                    this.f10546c.cancel(z10);
                }
                return cancel;
            }

            @Override // java.lang.Comparable
            /* renamed from: g */
            public int compareTo(Delayed delayed) {
                return this.f10546c.compareTo(delayed);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f10546c.getDelay(timeUnit);
            }
        }

        @a5.c
        public static final class b extends AbstractFuture.i<Void> implements Runnable {

            /* renamed from: b */
            public final Runnable f10547b;

            public b(Runnable runnable) {
                this.f10547b = (Runnable) u.E(runnable);
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            public String pendingToString() {
                String valueOf = String.valueOf(this.f10547b);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
                sb2.append("task=[");
                sb2.append(valueOf);
                sb2.append("]");
                return sb2.toString();
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f10547b.run();
                } catch (Throwable th2) {
                    setException(th2);
                    throw a0.q(th2);
                }
            }
        }

        public i(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f10545c = (ScheduledExecutorService) u.E(scheduledExecutorService);
        }

        @Override // p5.i0, java.util.concurrent.ScheduledExecutorService
        public e0<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f10545c.scheduleAtFixedRate(bVar, j10, j11, timeUnit));
        }

        @Override // p5.i0, java.util.concurrent.ScheduledExecutorService
        public e0<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f10545c.scheduleWithFixedDelay(bVar, j10, j11, timeUnit));
        }

        @Override // p5.i0, java.util.concurrent.ScheduledExecutorService
        public e0<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            TrustedListenableFutureTask v10 = TrustedListenableFutureTask.v(runnable, null);
            return new a(v10, this.f10545c.schedule(v10, j10, timeUnit));
        }

        @Override // p5.i0, java.util.concurrent.ScheduledExecutorService
        public <V> e0<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            TrustedListenableFutureTask w10 = TrustedListenableFutureTask.w(callable);
            return new a(w10, this.f10545c.schedule(w10, j10, timeUnit));
        }
    }

    @a5.a
    @a5.c
    public static void b(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        new f().a(executorService, j10, timeUnit);
    }

    public static Executor c() {
        return DirectExecutor.INSTANCE;
    }

    @a5.a
    @a5.c
    public static ExecutorService d(ThreadPoolExecutor threadPoolExecutor) {
        return new f().c(threadPoolExecutor);
    }

    @a5.a
    @a5.c
    public static ExecutorService e(ThreadPoolExecutor threadPoolExecutor, long j10, TimeUnit timeUnit) {
        return new f().d(threadPoolExecutor, j10, timeUnit);
    }

    @a5.a
    @a5.c
    public static ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new f().e(scheduledThreadPoolExecutor);
    }

    @a5.a
    @a5.c
    public static ScheduledExecutorService g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j10, TimeUnit timeUnit) {
        return new f().f(scheduledThreadPoolExecutor, j10, timeUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8 A[SYNTHETIC] */
    @a5.c
    @p5.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T h(p5.g0 r16, java.util.Collection<? extends java.util.concurrent.Callable<T>> r17, boolean r18, long r19, java.util.concurrent.TimeUnit r21) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r1 = r16
            b5.u.E(r16)
            b5.u.E(r21)
            int r0 = r17.size()
            r2 = 1
            if (r0 <= 0) goto L11
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            b5.u.d(r3)
            java.util.ArrayList r3 = com.google.common.collect.Lists.u(r0)
            java.util.concurrent.LinkedBlockingQueue r4 = e5.f1.k()
            r5 = r19
            r7 = r21
            long r5 = r7.toNanos(r5)
            if (r18 == 0) goto L2f
            long r7 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2c
            goto L31
        L2c:
            r0 = move-exception
            goto Lbc
        L2f:
            r7 = 0
        L31:
            java.util.Iterator r9 = r17.iterator()     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.Callable r10 = (java.util.concurrent.Callable) r10     // Catch: java.lang.Throwable -> L2c
            p5.c0 r10 = u(r1, r10, r4)     // Catch: java.lang.Throwable -> L2c
            r3.add(r10)     // Catch: java.lang.Throwable -> L2c
            int r0 = r0 + (-1)
            r10 = 0
            r12 = r10
            r11 = 1
        L47:
            java.lang.Object r13 = r4.poll()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch: java.lang.Throwable -> L2c
            if (r13 != 0) goto L62
            if (r0 <= 0) goto L66
            int r0 = r0 + (-1)
            java.lang.Object r14 = r9.next()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.Callable r14 = (java.util.concurrent.Callable) r14     // Catch: java.lang.Throwable -> L2c
            p5.c0 r14 = u(r1, r14, r4)     // Catch: java.lang.Throwable -> L2c
            r3.add(r14)     // Catch: java.lang.Throwable -> L2c
            int r11 = r11 + 1
        L62:
            r14 = r7
        L63:
            r6 = r5
            r5 = r0
            goto L91
        L66:
            if (r11 != 0) goto L70
            if (r12 != 0) goto L6f
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L2c
            r12.<init>(r10)     // Catch: java.lang.Throwable -> L2c
        L6f:
            throw r12     // Catch: java.lang.Throwable -> L2c
        L70:
            if (r18 == 0) goto L8a
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r13 = r4.poll(r5, r13)     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch: java.lang.Throwable -> L2c
            if (r13 == 0) goto L84
            long r14 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2c
            long r7 = r14 - r7
            long r5 = r5 - r7
            goto L63
        L84:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L2c
            r0.<init>()     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.lang.Throwable -> L2c
        L8a:
            java.lang.Object r13 = r4.take()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch: java.lang.Throwable -> L2c
            goto L62
        L91:
            if (r13 == 0) goto Lb8
            int r11 = r11 + (-1)
            java.lang.Object r0 = r13.get()     // Catch: java.lang.Throwable -> L2c java.lang.RuntimeException -> Lae java.util.concurrent.ExecutionException -> Lb6
            java.util.Iterator r1 = r3.iterator()
        L9d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lad
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto L9d
        Lad:
            return r0
        Lae:
            r0 = move-exception
            r8 = r0
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L2c
            r12.<init>(r8)     // Catch: java.lang.Throwable -> L2c
            goto Lb8
        Lb6:
            r0 = move-exception
            r12 = r0
        Lb8:
            r0 = r5
            r5 = r6
            r7 = r14
            goto L47
        Lbc:
            java.util.Iterator r1 = r3.iterator()
        Lc0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Ld0
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto Lc0
        Ld0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.p.h(p5.g0, java.util.Collection, boolean, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @a5.c
    public static boolean i() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @a5.c
    public static g0 j(ExecutorService executorService) {
        if (executorService instanceof g0) {
            return (g0) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new i((ScheduledExecutorService) executorService) : new h(executorService);
    }

    @a5.c
    public static i0 k(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof i0 ? (i0) scheduledExecutorService : new i(scheduledExecutorService);
    }

    @a5.c
    public static g0 l() {
        return new g(null);
    }

    @a5.c
    public static Executor m(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @a5.c
    public static Thread n(String str, Runnable runnable) {
        u.E(str);
        u.E(runnable);
        Thread newThread = o().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @a5.a
    @a5.c
    public static ThreadFactory o() {
        if (!i()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e12);
        } catch (InvocationTargetException e13) {
            throw a0.q(e13.getCause());
        }
    }

    public static Executor p(Executor executor, AbstractFuture<?> abstractFuture) {
        u.E(executor);
        u.E(abstractFuture);
        return executor == c() ? executor : new e(executor, abstractFuture);
    }

    @a5.c
    public static Executor q(Executor executor, z<String> zVar) {
        u.E(executor);
        u.E(zVar);
        return new b(executor, zVar);
    }

    @a5.c
    public static ExecutorService r(ExecutorService executorService, z<String> zVar) {
        u.E(executorService);
        u.E(zVar);
        return new c(executorService, zVar);
    }

    @a5.c
    public static ScheduledExecutorService s(ScheduledExecutorService scheduledExecutorService, z<String> zVar) {
        u.E(scheduledExecutorService);
        u.E(zVar);
        return new d(scheduledExecutorService, zVar);
    }

    @CanIgnoreReturnValue
    @a5.a
    @a5.c
    public static boolean t(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @a5.c
    public static <T> c0<T> u(g0 g0Var, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        c0<T> submit = g0Var.submit((Callable) callable);
        submit.addListener(new a(blockingQueue, submit), c());
        return submit;
    }

    @a5.c
    public static void v(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new y0().e(true).h(threadPoolExecutor.getThreadFactory()).b());
    }

    @a5.c
    public static final class g extends p5.b {

        /* renamed from: b */
        public final Object f10541b;

        /* renamed from: c */
        @GuardedBy("lock")
        public int f10542c;

        /* renamed from: d */
        @GuardedBy("lock")
        public boolean f10543d;

        public g() {
            this.f10541b = new Object();
            this.f10542c = 0;
            this.f10543d = false;
        }

        public final void a() {
            synchronized (this.f10541b) {
                try {
                    int i10 = this.f10542c - 1;
                    this.f10542c = i10;
                    if (i10 == 0) {
                        this.f10541b.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j10);
            synchronized (this.f10541b) {
                while (true) {
                    try {
                        if (this.f10543d && this.f10542c == 0) {
                            return true;
                        }
                        if (nanos <= 0) {
                            return false;
                        }
                        long nanoTime = System.nanoTime();
                        TimeUnit.NANOSECONDS.timedWait(this.f10541b, nanos);
                        nanos -= System.nanoTime() - nanoTime;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public final void b() {
            synchronized (this.f10541b) {
                try {
                    if (this.f10543d) {
                        throw new RejectedExecutionException("Executor already shutdown");
                    }
                    this.f10542c++;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z10;
            synchronized (this.f10541b) {
                z10 = this.f10543d;
            }
            return z10;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z10;
            synchronized (this.f10541b) {
                try {
                    z10 = this.f10543d && this.f10542c == 0;
                } finally {
                }
            }
            return z10;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.f10541b) {
                try {
                    this.f10543d = true;
                    if (this.f10542c == 0) {
                        this.f10541b.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }
}
