package xj;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import qj.a;
import qj.d;
import rx.Notification;

/* loaded from: classes5.dex */
public final class t<T> implements a.m0<T> {

    /* renamed from: g */
    public static final wj.o<qj.a<? extends Notification<?>>, qj.a<?>> f32633g = new a();

    /* renamed from: b */
    public final qj.a<T> f32634b;

    /* renamed from: c */
    public final wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> f32635c;

    /* renamed from: d */
    public final boolean f32636d;

    /* renamed from: e */
    public final boolean f32637e;

    /* renamed from: f */
    public final qj.d f32638f;

    public static class a implements wj.o<qj.a<? extends Notification<?>>, qj.a<?>> {

        /* renamed from: xj.t$a$a */
        public class C0835a implements wj.o<Notification<?>, Notification<?>> {
            public C0835a() {
            }

            @Override // wj.o
            public Notification<?> call(Notification<?> notification) {
                return Notification.e(null);
            }
        }

        @Override // wj.o
        public qj.a<?> call(qj.a<? extends Notification<?>> aVar) {
            return aVar.D1(new C0835a());
        }
    }

    public class b implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ qj.g f32640b;

        /* renamed from: c */
        public final /* synthetic */ hk.b f32641c;

        /* renamed from: d */
        public final /* synthetic */ yj.a f32642d;

        /* renamed from: e */
        public final /* synthetic */ AtomicLong f32643e;

        /* renamed from: f */
        public final /* synthetic */ ik.e f32644f;

        public class a extends qj.g<T> {

            /* renamed from: g */
            public boolean f32646g;

            public a() {
            }

            @Override // qj.g
            public void f(qj.c cVar) {
                b.this.f32642d.c(cVar);
            }

            public final void g() {
                long j10;
                do {
                    j10 = b.this.f32643e.get();
                    if (j10 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f32643e.compareAndSet(j10, j10 - 1));
            }

            @Override // qj.b
            public void onCompleted() {
                if (this.f32646g) {
                    return;
                }
                this.f32646g = true;
                unsubscribe();
                b.this.f32641c.onNext(Notification.b());
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                if (this.f32646g) {
                    return;
                }
                this.f32646g = true;
                unsubscribe();
                b.this.f32641c.onNext(Notification.d(th2));
            }

            @Override // qj.b
            public void onNext(T t10) {
                if (this.f32646g) {
                    return;
                }
                b.this.f32640b.onNext(t10);
                g();
                b.this.f32642d.b(1L);
            }
        }

        public b(qj.g gVar, hk.b bVar, yj.a aVar, AtomicLong atomicLong, ik.e eVar) {
            this.f32640b = gVar;
            this.f32641c = bVar;
            this.f32642d = aVar;
            this.f32643e = atomicLong;
            this.f32644f = eVar;
        }

        @Override // wj.a
        public void call() {
            if (this.f32640b.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f32644f.b(aVar);
            t.this.f32634b.T4(aVar);
        }
    }

    public class c implements a.n0<Notification<?>, Notification<?>> {

        public class a extends qj.g<Notification<?>> {

            /* renamed from: g */
            public final /* synthetic */ qj.g f32649g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(qj.g gVar, qj.g gVar2) {
                super(gVar);
                this.f32649g = gVar2;
            }

            @Override // qj.g
            public void f(qj.c cVar) {
                cVar.request(Long.MAX_VALUE);
            }

            @Override // qj.b
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                if (notification.k() && t.this.f32636d) {
                    this.f32649g.onCompleted();
                } else if (notification.l() && t.this.f32637e) {
                    this.f32649g.onError(notification.g());
                } else {
                    this.f32649g.onNext(notification);
                }
            }

            @Override // qj.b
            public void onCompleted() {
                this.f32649g.onCompleted();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                this.f32649g.onError(th2);
            }
        }

        public c() {
        }

        @Override // wj.o
        public qj.g<? super Notification<?>> call(qj.g<? super Notification<?>> gVar) {
            return new a(gVar, gVar);
        }
    }

    public class d implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32651b;

        /* renamed from: c */
        public final /* synthetic */ qj.g f32652c;

        /* renamed from: d */
        public final /* synthetic */ AtomicLong f32653d;

        /* renamed from: e */
        public final /* synthetic */ d.a f32654e;

        /* renamed from: f */
        public final /* synthetic */ wj.a f32655f;

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f32656g;

        public class a extends qj.g<Object> {
            public a(qj.g gVar) {
                super(gVar);
            }

            @Override // qj.g
            public void f(qj.c cVar) {
                cVar.request(Long.MAX_VALUE);
            }

            @Override // qj.b
            public void onCompleted() {
                d.this.f32652c.onCompleted();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                d.this.f32652c.onError(th2);
            }

            @Override // qj.b
            public void onNext(Object obj) {
                if (d.this.f32652c.isUnsubscribed()) {
                    return;
                }
                if (d.this.f32653d.get() <= 0) {
                    d.this.f32656g.compareAndSet(false, true);
                } else {
                    d dVar = d.this;
                    dVar.f32654e.b(dVar.f32655f);
                }
            }
        }

        public d(qj.a aVar, qj.g gVar, AtomicLong atomicLong, d.a aVar2, wj.a aVar3, AtomicBoolean atomicBoolean) {
            this.f32651b = aVar;
            this.f32652c = gVar;
            this.f32653d = atomicLong;
            this.f32654e = aVar2;
            this.f32655f = aVar3;
            this.f32656g = atomicBoolean;
        }

        @Override // wj.a
        public void call() {
            this.f32651b.T4(new a(this.f32652c));
        }
    }

    public class e implements qj.c {

        /* renamed from: b */
        public final /* synthetic */ AtomicLong f32659b;

        /* renamed from: c */
        public final /* synthetic */ yj.a f32660c;

        /* renamed from: d */
        public final /* synthetic */ AtomicBoolean f32661d;

        /* renamed from: e */
        public final /* synthetic */ d.a f32662e;

        /* renamed from: f */
        public final /* synthetic */ wj.a f32663f;

        public e(AtomicLong atomicLong, yj.a aVar, AtomicBoolean atomicBoolean, d.a aVar2, wj.a aVar3) {
            this.f32659b = atomicLong;
            this.f32660c = aVar;
            this.f32661d = atomicBoolean;
            this.f32662e = aVar2;
            this.f32663f = aVar3;
        }

        @Override // qj.c
        public void request(long j10) {
            if (j10 > 0) {
                xj.a.a(this.f32659b, j10);
                this.f32660c.request(j10);
                if (this.f32661d.compareAndSet(true, false)) {
                    this.f32662e.b(this.f32663f);
                }
            }
        }
    }

    public static final class f implements wj.o<qj.a<? extends Notification<?>>, qj.a<?>> {

        /* renamed from: b */
        public final long f32665b;

        public class a implements wj.o<Notification<?>, Notification<?>> {

            /* renamed from: b */
            public int f32666b = 0;

            public a() {
            }

            @Override // wj.o
            public Notification<?> call(Notification<?> notification) {
                if (f.this.f32665b == 0) {
                    return notification;
                }
                int i10 = this.f32666b + 1;
                this.f32666b = i10;
                return ((long) i10) <= f.this.f32665b ? Notification.e(Integer.valueOf(this.f32666b)) : notification;
            }
        }

        public f(long j10) {
            this.f32665b = j10;
        }

        @Override // wj.o
        public qj.a<?> call(qj.a<? extends Notification<?>> aVar) {
            return aVar.D1(new a()).o0();
        }
    }

    public static final class g implements wj.o<qj.a<? extends Notification<?>>, qj.a<? extends Notification<?>>> {

        /* renamed from: b */
        public wj.p<Integer, Throwable, Boolean> f32668b;

        public class a implements wj.p<Notification<Integer>, Notification<?>, Notification<Integer>> {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // wj.p
            public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                Integer h10 = notification.h();
                return ((Boolean) g.this.f32668b.call(h10, notification2.g())).booleanValue() ? Notification.e(Integer.valueOf(h10.intValue() + 1)) : notification2;
            }
        }

        public g(wj.p<Integer, Throwable, Boolean> pVar) {
            this.f32668b = pVar;
        }

        @Override // wj.o
        public qj.a<? extends Notification<?>> call(qj.a<? extends Notification<?>> aVar) {
            return aVar.f3(Notification.e(0), new a());
        }
    }

    public t(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar, boolean z10, boolean z11, qj.d dVar) {
        this.f32634b = aVar;
        this.f32635c = oVar;
        this.f32636d = z10;
        this.f32637e = z11;
        this.f32638f = dVar;
    }

    public static <T> qj.a<T> d(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar, qj.d dVar) {
        return qj.a.b0(new t(aVar, oVar, false, false, dVar));
    }

    public static <T> qj.a<T> e(qj.a<T> aVar) {
        return h(aVar, gk.f.g());
    }

    public static <T> qj.a<T> f(qj.a<T> aVar, long j10) {
        return g(aVar, j10, gk.f.g());
    }

    public static <T> qj.a<T> g(qj.a<T> aVar, long j10, qj.d dVar) {
        if (j10 == 0) {
            return qj.a.E0();
        }
        if (j10 >= 0) {
            return j(aVar, new f(j10 - 1), dVar);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> qj.a<T> h(qj.a<T> aVar, qj.d dVar) {
        return j(aVar, f32633g, dVar);
    }

    public static <T> qj.a<T> i(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar) {
        return qj.a.b0(new t(aVar, oVar, false, true, gk.f.g()));
    }

    public static <T> qj.a<T> j(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar, qj.d dVar) {
        return qj.a.b0(new t(aVar, oVar, false, true, dVar));
    }

    public static <T> qj.a<T> k(qj.a<T> aVar) {
        return m(aVar, f32633g);
    }

    public static <T> qj.a<T> l(qj.a<T> aVar, long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? aVar : m(aVar, new f(j10));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> qj.a<T> m(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar) {
        return qj.a.b0(new t(aVar, oVar, true, false, gk.f.g()));
    }

    public static <T> qj.a<T> n(qj.a<T> aVar, wj.o<? super qj.a<? extends Notification<?>>, ? extends qj.a<?>> oVar, qj.d dVar) {
        return qj.a.b0(new t(aVar, oVar, true, false, dVar));
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong(0L);
        d.a a10 = this.f32638f.a();
        gVar.b(a10);
        ik.e eVar = new ik.e();
        gVar.b(eVar);
        hk.b F5 = hk.b.F5();
        F5.K3(ek.e.d());
        yj.a aVar = new yj.a();
        b bVar = new b(gVar, F5, aVar, atomicLong, eVar);
        a10.b(new d(this.f32635c.call(F5.B1(new c())), gVar, atomicLong, a10, bVar, atomicBoolean));
        gVar.f(new e(atomicLong, aVar, atomicBoolean, a10, bVar));
    }
}
