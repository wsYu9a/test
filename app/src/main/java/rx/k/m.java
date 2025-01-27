package rx.k;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a */
    private static final l f36838a = new l(null);

    static class a<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements w<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.j f36839a;

        /* renamed from: b */
        final /* synthetic */ Object f36840b;

        a(rx.k.j jVar, Object obj) {
            this.f36839a = jVar;
            this.f36840b = obj;
        }

        @Override // rx.k.w
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            this.f36839a.call(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            return (R) this.f36840b;
        }
    }

    static class b<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.l f36841a;

        /* renamed from: b */
        final /* synthetic */ Object f36842b;

        b(rx.k.l lVar, Object obj) {
            this.f36841a = lVar;
            this.f36842b = obj;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            this.f36841a.call(objArr);
            return (R) this.f36842b;
        }
    }

    static class c<R> implements n<R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.a f36843a;

        /* renamed from: b */
        final /* synthetic */ Object f36844b;

        c(rx.k.a aVar, Object obj) {
            this.f36843a = aVar;
            this.f36844b = obj;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public R call() {
            this.f36843a.call();
            return (R) this.f36844b;
        }
    }

    static class d<R, T1> implements o<T1, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f36845a;

        /* renamed from: b */
        final /* synthetic */ Object f36846b;

        d(rx.k.b bVar, Object obj) {
            this.f36845a = bVar;
            this.f36846b = obj;
        }

        @Override // rx.k.o
        public R call(T1 t1) {
            this.f36845a.call(t1);
            return (R) this.f36846b;
        }
    }

    static class e<R, T1, T2> implements p<T1, T2, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.c f36847a;

        /* renamed from: b */
        final /* synthetic */ Object f36848b;

        e(rx.k.c cVar, Object obj) {
            this.f36847a = cVar;
            this.f36848b = obj;
        }

        @Override // rx.k.p
        public R call(T1 t1, T2 t2) {
            this.f36847a.call(t1, t2);
            return (R) this.f36848b;
        }
    }

    static class f<R, T1, T2, T3> implements q<T1, T2, T3, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.d f36849a;

        /* renamed from: b */
        final /* synthetic */ Object f36850b;

        f(rx.k.d dVar, Object obj) {
            this.f36849a = dVar;
            this.f36850b = obj;
        }

        @Override // rx.k.q
        public R call(T1 t1, T2 t2, T3 t3) {
            this.f36849a.call(t1, t2, t3);
            return (R) this.f36850b;
        }
    }

    static class g<R, T1, T2, T3, T4> implements r<T1, T2, T3, T4, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.e f36851a;

        /* renamed from: b */
        final /* synthetic */ Object f36852b;

        g(rx.k.e eVar, Object obj) {
            this.f36851a = eVar;
            this.f36852b = obj;
        }

        @Override // rx.k.r
        public R call(T1 t1, T2 t2, T3 t3, T4 t4) {
            this.f36851a.call(t1, t2, t3, t4);
            return (R) this.f36852b;
        }
    }

    static class h<R, T1, T2, T3, T4, T5> implements s<T1, T2, T3, T4, T5, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.f f36853a;

        /* renamed from: b */
        final /* synthetic */ Object f36854b;

        h(rx.k.f fVar, Object obj) {
            this.f36853a = fVar;
            this.f36854b = obj;
        }

        @Override // rx.k.s
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
            this.f36853a.call(t1, t2, t3, t4, t5);
            return (R) this.f36854b;
        }
    }

    static class i<R, T1, T2, T3, T4, T5, T6> implements t<T1, T2, T3, T4, T5, T6, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.g f36855a;

        /* renamed from: b */
        final /* synthetic */ Object f36856b;

        i(rx.k.g gVar, Object obj) {
            this.f36855a = gVar;
            this.f36856b = obj;
        }

        @Override // rx.k.t
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
            this.f36855a.call(t1, t2, t3, t4, t5, t6);
            return (R) this.f36856b;
        }
    }

    static class j<R, T1, T2, T3, T4, T5, T6, T7> implements u<T1, T2, T3, T4, T5, T6, T7, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.h f36857a;

        /* renamed from: b */
        final /* synthetic */ Object f36858b;

        j(rx.k.h hVar, Object obj) {
            this.f36857a = hVar;
            this.f36858b = obj;
        }

        @Override // rx.k.u
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
            this.f36857a.call(t1, t2, t3, t4, t5, t6, t7);
            return (R) this.f36858b;
        }
    }

    static class k<R, T1, T2, T3, T4, T5, T6, T7, T8> implements v<T1, T2, T3, T4, T5, T6, T7, T8, R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.i f36859a;

        /* renamed from: b */
        final /* synthetic */ Object f36860b;

        k(rx.k.i iVar, Object obj) {
            this.f36859a = iVar;
            this.f36860b = obj;
        }

        @Override // rx.k.v
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
            this.f36859a.call(t1, t2, t3, t4, t5, t6, t7, t8);
            return (R) this.f36860b;
        }
    }

    public static final class l<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements rx.k.a, rx.k.b<T0>, rx.k.c<T0, T1>, rx.k.d<T0, T1, T2>, rx.k.e<T0, T1, T2, T3>, rx.k.f<T0, T1, T2, T3, T4>, rx.k.g<T0, T1, T2, T3, T4, T5>, rx.k.h<T0, T1, T2, T3, T4, T5, T6>, rx.k.i<T0, T1, T2, T3, T4, T5, T6, T7>, rx.k.j<T0, T1, T2, T3, T4, T5, T6, T7, T8>, rx.k.l {
        private l() {
        }

        @Override // rx.k.a
        public void call() {
        }

        @Override // rx.k.b
        public void call(T0 t0) {
        }

        @Override // rx.k.c
        public void call(T0 t0, T1 t1) {
        }

        @Override // rx.k.d
        public void call(T0 t0, T1 t1, T2 t2) {
        }

        @Override // rx.k.e
        public void call(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        @Override // rx.k.f
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
        }

        @Override // rx.k.g
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        }

        @Override // rx.k.h
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        @Override // rx.k.i
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        @Override // rx.k.j
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        @Override // rx.k.l
        public void call(Object... objArr) {
        }

        /* synthetic */ l(c cVar) {
            this();
        }
    }

    private m() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> l<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> a() {
        return f36838a;
    }

    public static n<Void> b(rx.k.a aVar) {
        return c(aVar, null);
    }

    public static <R> n<R> c(rx.k.a aVar, R r) {
        return new c(aVar, r);
    }

    public static <T1> o<T1, Void> d(rx.k.b<T1> bVar) {
        return e(bVar, null);
    }

    public static <T1, R> o<T1, R> e(rx.k.b<T1> bVar, R r) {
        return new d(bVar, r);
    }

    public static <T1, T2> p<T1, T2, Void> f(rx.k.c<T1, T2> cVar) {
        return g(cVar, null);
    }

    public static <T1, T2, R> p<T1, T2, R> g(rx.k.c<T1, T2> cVar, R r) {
        return new e(cVar, r);
    }

    public static <T1, T2, T3> q<T1, T2, T3, Void> h(rx.k.d<T1, T2, T3> dVar) {
        return i(dVar, null);
    }

    public static <T1, T2, T3, R> q<T1, T2, T3, R> i(rx.k.d<T1, T2, T3> dVar, R r) {
        return new f(dVar, r);
    }

    public static <T1, T2, T3, T4> r<T1, T2, T3, T4, Void> j(rx.k.e<T1, T2, T3, T4> eVar) {
        return k(eVar, null);
    }

    public static <T1, T2, T3, T4, R> r<T1, T2, T3, T4, R> k(rx.k.e<T1, T2, T3, T4> eVar, R r) {
        return new g(eVar, r);
    }

    public static <T1, T2, T3, T4, T5> s<T1, T2, T3, T4, T5, Void> l(rx.k.f<T1, T2, T3, T4, T5> fVar) {
        return m(fVar, null);
    }

    public static <T1, T2, T3, T4, T5, R> s<T1, T2, T3, T4, T5, R> m(rx.k.f<T1, T2, T3, T4, T5> fVar, R r) {
        return new h(fVar, r);
    }

    public static <T1, T2, T3, T4, T5, T6> t<T1, T2, T3, T4, T5, T6, Void> n(rx.k.g<T1, T2, T3, T4, T5, T6> gVar) {
        return o(gVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, R> t<T1, T2, T3, T4, T5, T6, R> o(rx.k.g<T1, T2, T3, T4, T5, T6> gVar, R r) {
        return new i(gVar, r);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> u<T1, T2, T3, T4, T5, T6, T7, Void> p(rx.k.h<T1, T2, T3, T4, T5, T6, T7> hVar) {
        return q(hVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> u<T1, T2, T3, T4, T5, T6, T7, R> q(rx.k.h<T1, T2, T3, T4, T5, T6, T7> hVar, R r) {
        return new j(hVar, r);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> v<T1, T2, T3, T4, T5, T6, T7, T8, Void> r(rx.k.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar) {
        return s(iVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> v<T1, T2, T3, T4, T5, T6, T7, T8, R> s(rx.k.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar, R r) {
        return new k(iVar, r);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> w<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> t(rx.k.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar) {
        return u(jVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> w<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> u(rx.k.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar, R r) {
        return new a(jVar, r);
    }

    public static x<Void> v(rx.k.l lVar) {
        return w(lVar, null);
    }

    public static <R> x<R> w(rx.k.l lVar, R r) {
        return new b(lVar, r);
    }
}
