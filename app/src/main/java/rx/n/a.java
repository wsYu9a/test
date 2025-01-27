package rx.n;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.d;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes5.dex */
final class a extends rx.d {

    /* renamed from: a */
    private static final String f36921a = "RxCachedThreadScheduler-";

    /* renamed from: b */
    private static final rx.internal.util.f f36922b = new rx.internal.util.f(f36921a);

    /* renamed from: c */
    private static final String f36923c = "RxCachedWorkerPoolEvictor-";

    /* renamed from: d */
    private static final rx.internal.util.f f36924d = new rx.internal.util.f(f36923c);

    /* renamed from: rx.n.a$a */
    private static final class C0887a {

        /* renamed from: a */
        private static C0887a f36925a = new C0887a(60, TimeUnit.SECONDS);

        /* renamed from: b */
        private final long f36926b;

        /* renamed from: c */
        private final ConcurrentLinkedQueue<c> f36927c;

        /* renamed from: d */
        private final ScheduledExecutorService f36928d;

        /* renamed from: rx.n.a$a$a */
        class RunnableC0888a implements Runnable {
            RunnableC0888a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0887a.this.b();
            }
        }

        C0887a(long j2, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j2);
            this.f36926b = nanos;
            this.f36927c = new ConcurrentLinkedQueue<>();
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, a.f36924d);
            this.f36928d = newScheduledThreadPool;
            newScheduledThreadPool.scheduleWithFixedDelay(new RunnableC0888a(), nanos, nanos, TimeUnit.NANOSECONDS);
        }

        void b() {
            if (this.f36927c.isEmpty()) {
                return;
            }
            long d2 = d();
            Iterator<c> it = this.f36927c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.n() > d2) {
                    return;
                }
                if (this.f36927c.remove(next)) {
                    next.unsubscribe();
                }
            }
        }

        c c() {
            while (!this.f36927c.isEmpty()) {
                c poll = this.f36927c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            return new c(a.f36922b);
        }

        long d() {
            return System.nanoTime();
        }

        void e(c cVar) {
            cVar.o(d() + this.f36926b);
            this.f36927c.offer(cVar);
        }
    }

    private static final class b extends d.a {

        /* renamed from: a */
        static final AtomicIntegerFieldUpdater<b> f36930a = AtomicIntegerFieldUpdater.newUpdater(b.class, "d");

        /* renamed from: b */
        private final rx.p.b f36931b = new rx.p.b();

        /* renamed from: c */
        private final c f36932c;

        /* renamed from: d */
        volatile int f36933d;

        b(c cVar) {
            this.f36932c = cVar;
        }

        @Override // rx.d.a
        public rx.h d(rx.k.a aVar) {
            return e(aVar, 0L, null);
        }

        @Override // rx.d.a
        public rx.h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f36931b.isUnsubscribed()) {
                return rx.p.f.e();
            }
            ScheduledAction j3 = this.f36932c.j(aVar, j2, timeUnit);
            this.f36931b.a(j3);
            j3.addParent(this.f36931b);
            return j3;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36931b.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (f36930a.compareAndSet(this, 0, 1)) {
                C0887a.f36925a.e(this.f36932c);
            }
            this.f36931b.unsubscribe();
        }
    }

    private static final class c extends rx.internal.schedulers.b {
        private long k;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.k = 0L;
        }

        public long n() {
            return this.k;
        }

        public void o(long j2) {
            this.k = j2;
        }
    }

    a() {
    }

    @Override // rx.d
    public d.a a() {
        return new b(C0887a.f36925a.c());
    }
}
