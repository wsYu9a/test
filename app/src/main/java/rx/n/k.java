package rx.n;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.d;

/* loaded from: classes5.dex */
public final class k extends rx.d {

    /* renamed from: a */
    private static final k f36979a = new k();

    private static final class c implements Comparable<c> {

        /* renamed from: a */
        final rx.k.a f36987a;

        /* renamed from: b */
        final Long f36988b;

        /* renamed from: c */
        final int f36989c;

        /* synthetic */ c(rx.k.a aVar, Long l, int i2, a aVar2) {
            this(aVar, l, i2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int compareTo = this.f36988b.compareTo(cVar.f36988b);
            return compareTo == 0 ? k.d(this.f36989c, cVar.f36989c) : compareTo;
        }

        private c(rx.k.a aVar, Long l, int i2) {
            this.f36987a = aVar;
            this.f36988b = l;
            this.f36989c = i2;
        }
    }

    k() {
    }

    public static int d(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    static k e() {
        return f36979a;
    }

    @Override // rx.d
    public d.a a() {
        return new b();
    }

    private static class b extends d.a implements rx.h {

        /* renamed from: a */
        private static final AtomicIntegerFieldUpdater<b> f36980a = AtomicIntegerFieldUpdater.newUpdater(b.class, "b");

        /* renamed from: b */
        volatile int f36981b;

        /* renamed from: c */
        private final PriorityBlockingQueue<c> f36982c;

        /* renamed from: d */
        private final rx.p.a f36983d;

        /* renamed from: e */
        private final AtomicInteger f36984e;

        class a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ c f36985a;

            a(c cVar) {
                this.f36985a = cVar;
            }

            @Override // rx.k.a
            public void call() {
                b.this.f36982c.remove(this.f36985a);
            }
        }

        private b() {
            this.f36982c = new PriorityBlockingQueue<>();
            this.f36983d = new rx.p.a();
            this.f36984e = new AtomicInteger();
        }

        private rx.h h(rx.k.a aVar, long j2) {
            if (this.f36983d.isUnsubscribed()) {
                return rx.p.f.e();
            }
            c cVar = new c(aVar, Long.valueOf(j2), f36980a.incrementAndGet(this));
            this.f36982c.add(cVar);
            if (this.f36984e.getAndIncrement() != 0) {
                return rx.p.f.a(new a(cVar));
            }
            do {
                c poll = this.f36982c.poll();
                if (poll != null) {
                    poll.f36987a.call();
                }
            } while (this.f36984e.decrementAndGet() > 0);
            return rx.p.f.e();
        }

        @Override // rx.d.a
        public rx.h d(rx.k.a aVar) {
            return h(aVar, c());
        }

        @Override // rx.d.a
        public rx.h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            long c2 = c() + timeUnit.toMillis(j2);
            return h(new g(aVar, this, c2), c2);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36983d.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36983d.unsubscribe();
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }
}
