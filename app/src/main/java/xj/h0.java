package xj;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class h0<T> implements a.n0<T, qj.a<? extends T>> {

    public static class b<T> extends qj.g<T> {

        /* renamed from: k */
        public static final AtomicIntegerFieldUpdater<b> f32263k = AtomicIntegerFieldUpdater.newUpdater(b.class, "i");

        /* renamed from: g */
        public final qj.g<T> f32264g;

        /* renamed from: h */
        public final d<T> f32265h;

        /* renamed from: i */
        public volatile int f32266i = 0;

        /* renamed from: j */
        public final yj.a f32267j;

        public b(d<T> dVar, qj.g<T> gVar, yj.a aVar) {
            this.f32265h = dVar;
            this.f32264g = gVar;
            this.f32267j = aVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32267j.c(cVar);
        }

        @Override // qj.b
        public void onCompleted() {
            if (f32263k.compareAndSet(this, 0, 1)) {
                this.f32265h.i();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (f32263k.compareAndSet(this, 0, 1)) {
                this.f32265h.onError(th2);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32264g.onNext(t10);
            this.f32265h.j();
            this.f32267j.b(1L);
        }
    }

    public static final class c<T> implements qj.c {

        /* renamed from: b */
        public final d<T> f32268b;

        public c(d<T> dVar) {
            this.f32268b = dVar;
        }

        @Override // qj.c
        public void request(long j10) {
            this.f32268b.l(j10);
        }
    }

    public static final class d<T> extends qj.g<qj.a<? extends T>> {

        /* renamed from: o */
        public static final AtomicIntegerFieldUpdater<d> f32269o = AtomicIntegerFieldUpdater.newUpdater(d.class, com.kuaishou.weapon.p0.t.f11204d);

        /* renamed from: p */
        public static final AtomicLongFieldUpdater<d> f32270p = AtomicLongFieldUpdater.newUpdater(d.class, "m");

        /* renamed from: g */
        public final NotificationLite<qj.a<? extends T>> f32271g;

        /* renamed from: h */
        public final qj.g<T> f32272h;

        /* renamed from: i */
        public final ik.e f32273i;

        /* renamed from: j */
        public final ConcurrentLinkedQueue<Object> f32274j;

        /* renamed from: k */
        public volatile b<T> f32275k;

        /* renamed from: l */
        public volatile int f32276l;

        /* renamed from: m */
        public volatile long f32277m;

        /* renamed from: n */
        public final yj.a f32278n;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                d.this.f32274j.clear();
            }
        }

        public d(qj.g<T> gVar, ik.e eVar) {
            super(gVar);
            this.f32271g = NotificationLite.f();
            this.f32272h = gVar;
            this.f32273i = eVar;
            this.f32278n = new yj.a();
            this.f32274j = new ConcurrentLinkedQueue<>();
            b(ik.f.a(new a()));
        }

        @Override // qj.g
        public void d() {
            e(2L);
        }

        public void i() {
            this.f32275k = null;
            if (f32269o.decrementAndGet(this) > 0) {
                m();
            }
            e(1L);
        }

        public final void j() {
            f32270p.decrementAndGet(this);
        }

        @Override // qj.b
        /* renamed from: k */
        public void onNext(qj.a<? extends T> aVar) {
            this.f32274j.add(this.f32271g.l(aVar));
            if (f32269o.getAndIncrement(this) == 0) {
                m();
            }
        }

        public final void l(long j10) {
            if (j10 <= 0) {
                return;
            }
            long b10 = xj.a.b(f32270p, this, j10);
            this.f32278n.request(j10);
            if (b10 == 0 && this.f32275k == null && this.f32276l > 0) {
                m();
            }
        }

        public void m() {
            if (this.f32277m <= 0) {
                if (this.f32271g.g(this.f32274j.peek())) {
                    this.f32272h.onCompleted();
                    return;
                }
                return;
            }
            Object poll = this.f32274j.poll();
            if (this.f32271g.g(poll)) {
                this.f32272h.onCompleted();
            } else if (poll != null) {
                qj.a<? extends T> e10 = this.f32271g.e(poll);
                this.f32275k = new b<>(this, this.f32272h, this.f32278n);
                this.f32273i.b(this.f32275k);
                e10.T4(this.f32275k);
            }
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32274j.add(this.f32271g.b());
            if (f32269o.getAndIncrement(this) == 0) {
                m();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32272h.onError(th2);
            unsubscribe();
        }
    }

    public static final class e {

        /* renamed from: a */
        public static final h0<Object> f32280a = new h0<>();
    }

    public /* synthetic */ h0(a aVar) {
        this();
    }

    public static <T> h0<T> a() {
        return (h0<T>) e.f32280a;
    }

    public h0() {
    }

    @Override // wj.o
    public qj.g<? super qj.a<? extends T>> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        ik.e eVar = new ik.e();
        gVar.b(eVar);
        d dVar2 = new d(dVar, eVar);
        gVar.f(new c(dVar2));
        return dVar2;
    }
}
