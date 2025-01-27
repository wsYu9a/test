package gk;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.d;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes5.dex */
public final class a extends qj.d {

    /* renamed from: a */
    public static final String f26303a = "RxCachedThreadScheduler-";

    /* renamed from: b */
    public static final ak.f f26304b = new ak.f(f26303a);

    /* renamed from: c */
    public static final String f26305c = "RxCachedWorkerPoolEvictor-";

    /* renamed from: d */
    public static final ak.f f26306d = new ak.f(f26305c);

    /* renamed from: gk.a$a */
    public static final class C0700a {

        /* renamed from: d */
        public static C0700a f26307d = new C0700a(60, TimeUnit.SECONDS);

        /* renamed from: a */
        public final long f26308a;

        /* renamed from: b */
        public final ConcurrentLinkedQueue<c> f26309b;

        /* renamed from: c */
        public final ScheduledExecutorService f26310c;

        /* renamed from: gk.a$a$a */
        public class RunnableC0701a implements Runnable {
            public RunnableC0701a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0700a.this.b();
            }
        }

        public C0700a(long j10, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j10);
            this.f26308a = nanos;
            this.f26309b = new ConcurrentLinkedQueue<>();
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, a.f26306d);
            this.f26310c = newScheduledThreadPool;
            newScheduledThreadPool.scheduleWithFixedDelay(new RunnableC0701a(), nanos, nanos, TimeUnit.NANOSECONDS);
        }

        public void b() {
            if (this.f26309b.isEmpty()) {
                return;
            }
            long d10 = d();
            Iterator<c> it = this.f26309b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > d10) {
                    return;
                }
                if (this.f26309b.remove(next)) {
                    next.unsubscribe();
                }
            }
        }

        public c c() {
            while (!this.f26309b.isEmpty()) {
                c poll = this.f26309b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            return new c(a.f26304b);
        }

        public long d() {
            return System.nanoTime();
        }

        public void e(c cVar) {
            cVar.m(d() + this.f26308a);
            this.f26309b.offer(cVar);
        }
    }

    public static final class b extends d.a {

        /* renamed from: e */
        public static final AtomicIntegerFieldUpdater<b> f26312e = AtomicIntegerFieldUpdater.newUpdater(b.class, "d");

        /* renamed from: b */
        public final ik.b f26313b = new ik.b();

        /* renamed from: c */
        public final c f26314c;

        /* renamed from: d */
        public volatile int f26315d;

        public b(c cVar) {
            this.f26314c = cVar;
        }

        @Override // qj.d.a
        public qj.h b(wj.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // qj.d.a
        public qj.h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            if (this.f26313b.isUnsubscribed()) {
                return ik.f.e();
            }
            ScheduledAction h10 = this.f26314c.h(aVar, j10, timeUnit);
            this.f26313b.a(h10);
            h10.addParent(this.f26313b);
            return h10;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f26313b.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (f26312e.compareAndSet(this, 0, 1)) {
                C0700a.f26307d.e(this.f26314c);
            }
            this.f26313b.unsubscribe();
        }
    }

    public static final class c extends zj.b {

        /* renamed from: l */
        public long f26316l;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f26316l = 0L;
        }

        public long l() {
            return this.f26316l;
        }

        public void m(long j10) {
            this.f26316l = j10;
        }
    }

    @Override // qj.d
    public d.a a() {
        return new b(C0700a.f26307d.c());
    }
}
