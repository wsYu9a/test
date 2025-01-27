package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class t<T> implements a.m0<T> {

    /* renamed from: a */
    static final rx.k.o<rx.a<? extends Notification<?>>, rx.a<?>> f36440a = new a();

    /* renamed from: b */
    private final rx.a<T> f36441b;

    /* renamed from: c */
    private final rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> f36442c;

    /* renamed from: d */
    private final boolean f36443d;

    /* renamed from: e */
    private final boolean f36444e;

    /* renamed from: f */
    private final rx.d f36445f;

    static class a implements rx.k.o<rx.a<? extends Notification<?>>, rx.a<?>> {

        /* renamed from: rx.internal.operators.t$a$a */
        class C0871a implements rx.k.o<Notification<?>, Notification<?>> {
            C0871a() {
            }

            @Override // rx.k.o
            public Notification<?> call(Notification<?> notification) {
                return Notification.e(null);
            }
        }

        a() {
        }

        @Override // rx.k.o
        public rx.a<?> call(rx.a<? extends Notification<?>> aVar) {
            return aVar.D1(new C0871a());
        }
    }

    class b implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.g f36447a;

        /* renamed from: b */
        final /* synthetic */ rx.o.b f36448b;

        /* renamed from: c */
        final /* synthetic */ rx.internal.producers.a f36449c;

        /* renamed from: d */
        final /* synthetic */ AtomicLong f36450d;

        /* renamed from: e */
        final /* synthetic */ rx.p.e f36451e;

        class a extends rx.g<T> {

            /* renamed from: f */
            boolean f36453f;

            a() {
            }

            private void g() {
                long j2;
                do {
                    j2 = b.this.f36450d.get();
                    if (j2 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f36450d.compareAndSet(j2, j2 - 1));
            }

            @Override // rx.g
            public void f(rx.c cVar) {
                b.this.f36449c.c(cVar);
            }

            @Override // rx.b
            public void onCompleted() {
                if (this.f36453f) {
                    return;
                }
                this.f36453f = true;
                unsubscribe();
                b.this.f36448b.onNext(Notification.b());
            }

            @Override // rx.b
            public void onError(Throwable th) {
                if (this.f36453f) {
                    return;
                }
                this.f36453f = true;
                unsubscribe();
                b.this.f36448b.onNext(Notification.d(th));
            }

            @Override // rx.b
            public void onNext(T t) {
                if (this.f36453f) {
                    return;
                }
                b.this.f36447a.onNext(t);
                g();
                b.this.f36449c.b(1L);
            }
        }

        b(rx.g gVar, rx.o.b bVar, rx.internal.producers.a aVar, AtomicLong atomicLong, rx.p.e eVar) {
            this.f36447a = gVar;
            this.f36448b = bVar;
            this.f36449c = aVar;
            this.f36450d = atomicLong;
            this.f36451e = eVar;
        }

        @Override // rx.k.a
        public void call() {
            if (this.f36447a.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f36451e.b(aVar);
            t.this.f36441b.T4(aVar);
        }
    }

    class c implements a.n0<Notification<?>, Notification<?>> {

        class a extends rx.g<Notification<?>> {

            /* renamed from: f */
            final /* synthetic */ rx.g f36456f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.g gVar, rx.g gVar2) {
                super(gVar);
                this.f36456f = gVar2;
            }

            @Override // rx.g
            public void f(rx.c cVar) {
                cVar.request(Long.MAX_VALUE);
            }

            @Override // rx.b
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                if (notification.k() && t.this.f36443d) {
                    this.f36456f.onCompleted();
                } else if (notification.l() && t.this.f36444e) {
                    this.f36456f.onError(notification.g());
                } else {
                    this.f36456f.onNext(notification);
                }
            }

            @Override // rx.b
            public void onCompleted() {
                this.f36456f.onCompleted();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                this.f36456f.onError(th);
            }
        }

        c() {
        }

        @Override // rx.k.o
        public rx.g<? super Notification<?>> call(rx.g<? super Notification<?>> gVar) {
            return new a(gVar, gVar);
        }
    }

    class d implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.a f36458a;

        /* renamed from: b */
        final /* synthetic */ rx.g f36459b;

        /* renamed from: c */
        final /* synthetic */ AtomicLong f36460c;

        /* renamed from: d */
        final /* synthetic */ d.a f36461d;

        /* renamed from: e */
        final /* synthetic */ rx.k.a f36462e;

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f36463f;

        class a extends rx.g<Object> {
            a(rx.g gVar) {
                super(gVar);
            }

            @Override // rx.g
            public void f(rx.c cVar) {
                cVar.request(Long.MAX_VALUE);
            }

            @Override // rx.b
            public void onCompleted() {
                d.this.f36459b.onCompleted();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                d.this.f36459b.onError(th);
            }

            @Override // rx.b
            public void onNext(Object obj) {
                if (d.this.f36459b.isUnsubscribed()) {
                    return;
                }
                if (d.this.f36460c.get() <= 0) {
                    d.this.f36463f.compareAndSet(false, true);
                } else {
                    d dVar = d.this;
                    dVar.f36461d.d(dVar.f36462e);
                }
            }
        }

        d(rx.a aVar, rx.g gVar, AtomicLong atomicLong, d.a aVar2, rx.k.a aVar3, AtomicBoolean atomicBoolean) {
            this.f36458a = aVar;
            this.f36459b = gVar;
            this.f36460c = atomicLong;
            this.f36461d = aVar2;
            this.f36462e = aVar3;
            this.f36463f = atomicBoolean;
        }

        @Override // rx.k.a
        public void call() {
            this.f36458a.T4(new a(this.f36459b));
        }
    }

    class e implements rx.c {

        /* renamed from: a */
        final /* synthetic */ AtomicLong f36466a;

        /* renamed from: b */
        final /* synthetic */ rx.internal.producers.a f36467b;

        /* renamed from: c */
        final /* synthetic */ AtomicBoolean f36468c;

        /* renamed from: d */
        final /* synthetic */ d.a f36469d;

        /* renamed from: e */
        final /* synthetic */ rx.k.a f36470e;

        e(AtomicLong atomicLong, rx.internal.producers.a aVar, AtomicBoolean atomicBoolean, d.a aVar2, rx.k.a aVar3) {
            this.f36466a = atomicLong;
            this.f36467b = aVar;
            this.f36468c = atomicBoolean;
            this.f36469d = aVar2;
            this.f36470e = aVar3;
        }

        @Override // rx.c
        public void request(long j2) {
            if (j2 > 0) {
                rx.internal.operators.a.a(this.f36466a, j2);
                this.f36467b.request(j2);
                if (this.f36468c.compareAndSet(true, false)) {
                    this.f36469d.d(this.f36470e);
                }
            }
        }
    }

    public static final class f implements rx.k.o<rx.a<? extends Notification<?>>, rx.a<?>> {

        /* renamed from: a */
        private final long f36472a;

        class a implements rx.k.o<Notification<?>, Notification<?>> {

            /* renamed from: a */
            int f36473a = 0;

            a() {
            }

            @Override // rx.k.o
            public Notification<?> call(Notification<?> notification) {
                if (f.this.f36472a == 0) {
                    return notification;
                }
                int i2 = this.f36473a + 1;
                this.f36473a = i2;
                return ((long) i2) <= f.this.f36472a ? Notification.e(Integer.valueOf(this.f36473a)) : notification;
            }
        }

        public f(long j2) {
            this.f36472a = j2;
        }

        @Override // rx.k.o
        public rx.a<?> call(rx.a<? extends Notification<?>> aVar) {
            return aVar.D1(new a()).o0();
        }
    }

    public static final class g implements rx.k.o<rx.a<? extends Notification<?>>, rx.a<? extends Notification<?>>> {

        /* renamed from: a */
        private rx.k.p<Integer, Throwable, Boolean> f36475a;

        class a implements rx.k.p<Notification<Integer>, Notification<?>, Notification<Integer>> {
            a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.k.p
            public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                int intValue = notification.h().intValue();
                return ((Boolean) g.this.f36475a.call(Integer.valueOf(intValue), notification2.g())).booleanValue() ? Notification.e(Integer.valueOf(intValue + 1)) : notification2;
            }
        }

        public g(rx.k.p<Integer, Throwable, Boolean> pVar) {
            this.f36475a = pVar;
        }

        @Override // rx.k.o
        public rx.a<? extends Notification<?>> call(rx.a<? extends Notification<?>> aVar) {
            return aVar.f3(Notification.e(0), new a());
        }
    }

    private t(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar, boolean z, boolean z2, rx.d dVar) {
        this.f36441b = aVar;
        this.f36442c = oVar;
        this.f36443d = z;
        this.f36444e = z2;
        this.f36445f = dVar;
    }

    public static <T> rx.a<T> d(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar, rx.d dVar) {
        return rx.a.b0(new t(aVar, oVar, false, false, dVar));
    }

    public static <T> rx.a<T> e(rx.a<T> aVar) {
        return h(aVar, rx.n.f.g());
    }

    public static <T> rx.a<T> f(rx.a<T> aVar, long j2) {
        return g(aVar, j2, rx.n.f.g());
    }

    public static <T> rx.a<T> g(rx.a<T> aVar, long j2, rx.d dVar) {
        if (j2 == 0) {
            return rx.a.E0();
        }
        if (j2 >= 0) {
            return j(aVar, new f(j2 - 1), dVar);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.a<T> h(rx.a<T> aVar, rx.d dVar) {
        return j(aVar, f36440a, dVar);
    }

    public static <T> rx.a<T> i(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar) {
        return rx.a.b0(new t(aVar, oVar, false, true, rx.n.f.g()));
    }

    public static <T> rx.a<T> j(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar, rx.d dVar) {
        return rx.a.b0(new t(aVar, oVar, false, true, dVar));
    }

    public static <T> rx.a<T> k(rx.a<T> aVar) {
        return m(aVar, f36440a);
    }

    public static <T> rx.a<T> l(rx.a<T> aVar, long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? aVar : m(aVar, new f(j2));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.a<T> m(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar) {
        return rx.a.b0(new t(aVar, oVar, true, false, rx.n.f.g()));
    }

    public static <T> rx.a<T> n(rx.a<T> aVar, rx.k.o<? super rx.a<? extends Notification<?>>, ? extends rx.a<?>> oVar, rx.d dVar) {
        return rx.a.b0(new t(aVar, oVar, true, false, dVar));
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong(0L);
        d.a a2 = this.f36445f.a();
        gVar.b(a2);
        rx.p.e eVar = new rx.p.e();
        gVar.b(eVar);
        rx.o.b F5 = rx.o.b.F5();
        F5.K3(rx.l.e.d());
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(gVar, F5, aVar, atomicLong, eVar);
        a2.d(new d(this.f36442c.call(F5.B1(new c())), gVar, atomicLong, a2, bVar, atomicBoolean));
        gVar.f(new e(atomicLong, aVar, atomicBoolean, a2, bVar));
    }
}
