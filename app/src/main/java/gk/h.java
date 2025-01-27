package gk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import qj.d;

/* loaded from: classes5.dex */
public class h extends qj.d {

    /* renamed from: c */
    public static long f26345c;

    /* renamed from: a */
    public final Queue<d> f26346a = new PriorityQueue(11, new b());

    /* renamed from: b */
    public long f26347b;

    public static class b implements Comparator<d> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f26354a == dVar2.f26354a ? Long.valueOf(dVar.f26357d).compareTo(Long.valueOf(dVar2.f26357d)) : Long.valueOf(dVar.f26354a).compareTo(Long.valueOf(dVar2.f26354a));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class d {

        /* renamed from: a */
        public final long f26354a;

        /* renamed from: b */
        public final wj.a f26355b;

        /* renamed from: c */
        public final d.a f26356c;

        /* renamed from: d */
        public final long f26357d;

        public /* synthetic */ d(d.a aVar, long j10, wj.a aVar2, a aVar3) {
            this(aVar, j10, aVar2);
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f26354a), this.f26355b.toString());
        }

        public d(d.a aVar, long j10, wj.a aVar2) {
            this.f26357d = h.c();
            this.f26354a = j10;
            this.f26355b = aVar2;
            this.f26356c = aVar;
        }
    }

    public static /* synthetic */ long c() {
        long j10 = f26345c;
        f26345c = 1 + j10;
        return j10;
    }

    @Override // qj.d
    public d.a a() {
        return new c();
    }

    @Override // qj.d
    public long b() {
        return TimeUnit.NANOSECONDS.toMillis(this.f26347b);
    }

    public void f(long j10, TimeUnit timeUnit) {
        g(this.f26347b + timeUnit.toNanos(j10), TimeUnit.NANOSECONDS);
    }

    public void g(long j10, TimeUnit timeUnit) {
        i(timeUnit.toNanos(j10));
    }

    public void h() {
        i(this.f26347b);
    }

    public final void i(long j10) {
        while (!this.f26346a.isEmpty()) {
            d peek = this.f26346a.peek();
            if (peek.f26354a > j10) {
                break;
            }
            this.f26347b = peek.f26354a == 0 ? this.f26347b : peek.f26354a;
            this.f26346a.remove();
            if (!peek.f26356c.isUnsubscribed()) {
                peek.f26355b.call();
            }
        }
        this.f26347b = j10;
    }

    public final class c extends d.a {

        /* renamed from: b */
        public final ik.a f26348b;

        public class a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ d f26350b;

            public a(d dVar) {
                this.f26350b = dVar;
            }

            @Override // wj.a
            public void call() {
                h.this.f26346a.remove(this.f26350b);
            }
        }

        public class b implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ d f26352b;

            public b(d dVar) {
                this.f26352b = dVar;
            }

            @Override // wj.a
            public void call() {
                h.this.f26346a.remove(this.f26352b);
            }
        }

        public c() {
            this.f26348b = new ik.a();
        }

        @Override // qj.d.a
        public long a() {
            return h.this.b();
        }

        @Override // qj.d.a
        public qj.h b(wj.a aVar) {
            d dVar = new d(this, 0L, aVar);
            h.this.f26346a.add(dVar);
            return ik.f.a(new b(dVar));
        }

        @Override // qj.d.a
        public qj.h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            d dVar = new d(this, h.this.f26347b + timeUnit.toNanos(j10), aVar);
            h.this.f26346a.add(dVar);
            return ik.f.a(new a(dVar));
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f26348b.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f26348b.unsubscribe();
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this();
        }
    }
}
