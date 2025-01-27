package rx.n;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.d;

/* loaded from: classes5.dex */
public class h extends rx.d {

    /* renamed from: a */
    private static long f36962a;

    /* renamed from: b */
    private final Queue<d> f36963b = new PriorityQueue(11, new b());

    /* renamed from: c */
    private long f36964c;

    private static class b implements Comparator<d> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f36971a == dVar2.f36971a ? Long.valueOf(dVar.f36974d).compareTo(Long.valueOf(dVar2.f36974d)) : Long.valueOf(dVar.f36971a).compareTo(Long.valueOf(dVar2.f36971a));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private static final class d {

        /* renamed from: a */
        private final long f36971a;

        /* renamed from: b */
        private final rx.k.a f36972b;

        /* renamed from: c */
        private final d.a f36973c;

        /* renamed from: d */
        private final long f36974d;

        /* synthetic */ d(d.a aVar, long j2, rx.k.a aVar2, a aVar3) {
            this(aVar, j2, aVar2);
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f36971a), this.f36972b.toString());
        }

        private d(d.a aVar, long j2, rx.k.a aVar2) {
            this.f36974d = h.c();
            this.f36971a = j2;
            this.f36972b = aVar2;
            this.f36973c = aVar;
        }
    }

    static /* synthetic */ long c() {
        long j2 = f36962a;
        f36962a = 1 + j2;
        return j2;
    }

    private void i(long j2) {
        while (!this.f36963b.isEmpty()) {
            d peek = this.f36963b.peek();
            if (peek.f36971a > j2) {
                break;
            }
            this.f36964c = peek.f36971a == 0 ? this.f36964c : peek.f36971a;
            this.f36963b.remove();
            if (!peek.f36973c.isUnsubscribed()) {
                peek.f36972b.call();
            }
        }
        this.f36964c = j2;
    }

    @Override // rx.d
    public d.a a() {
        return new c();
    }

    @Override // rx.d
    public long b() {
        return TimeUnit.NANOSECONDS.toMillis(this.f36964c);
    }

    public void f(long j2, TimeUnit timeUnit) {
        g(this.f36964c + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    public void g(long j2, TimeUnit timeUnit) {
        i(timeUnit.toNanos(j2));
    }

    public void h() {
        i(this.f36964c);
    }

    private final class c extends d.a {

        /* renamed from: a */
        private final rx.p.a f36965a;

        class a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ d f36967a;

            a(d dVar) {
                this.f36967a = dVar;
            }

            @Override // rx.k.a
            public void call() {
                h.this.f36963b.remove(this.f36967a);
            }
        }

        class b implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ d f36969a;

            b(d dVar) {
                this.f36969a = dVar;
            }

            @Override // rx.k.a
            public void call() {
                h.this.f36963b.remove(this.f36969a);
            }
        }

        private c() {
            this.f36965a = new rx.p.a();
        }

        @Override // rx.d.a
        public long c() {
            return h.this.b();
        }

        @Override // rx.d.a
        public rx.h d(rx.k.a aVar) {
            d dVar = new d(this, 0L, aVar);
            h.this.f36963b.add(dVar);
            return rx.p.f.a(new b(dVar));
        }

        @Override // rx.d.a
        public rx.h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            d dVar = new d(this, h.this.f36964c + timeUnit.toNanos(j2), aVar);
            h.this.f36963b.add(dVar);
            return rx.p.f.a(new a(dVar));
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36965a.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36965a.unsubscribe();
        }

        /* synthetic */ c(h hVar, a aVar) {
            this();
        }
    }
}
