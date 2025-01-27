package rx.k;

/* loaded from: classes5.dex */
public final class z {

    static class a<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ w f36861a;

        a(w wVar) {
            this.f36861a = wVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 9) {
                return (R) this.f36861a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new RuntimeException("Func9 expecting 9 arguments.");
        }
    }

    static class b implements x<Void> {

        /* renamed from: a */
        final /* synthetic */ rx.k.a f36862a;

        b(rx.k.a aVar) {
            this.f36862a = aVar;
        }

        @Override // rx.k.x
        public Void call(Object... objArr) {
            if (objArr.length != 0) {
                throw new RuntimeException("Action0 expecting 0 arguments.");
            }
            this.f36862a.call();
            return null;
        }
    }

    static class c implements x<Void> {

        /* renamed from: a */
        final /* synthetic */ rx.k.b f36863a;

        c(rx.k.b bVar) {
            this.f36863a = bVar;
        }

        @Override // rx.k.x
        public Void call(Object... objArr) {
            if (objArr.length != 1) {
                throw new RuntimeException("Action1 expecting 1 argument.");
            }
            this.f36863a.call(objArr[0]);
            return null;
        }
    }

    static class d implements x<Void> {

        /* renamed from: a */
        final /* synthetic */ rx.k.c f36864a;

        d(rx.k.c cVar) {
            this.f36864a = cVar;
        }

        @Override // rx.k.x
        public Void call(Object... objArr) {
            if (objArr.length != 2) {
                throw new RuntimeException("Action3 expecting 2 arguments.");
            }
            this.f36864a.call(objArr[0], objArr[1]);
            return null;
        }
    }

    static class e implements x<Void> {

        /* renamed from: a */
        final /* synthetic */ rx.k.d f36865a;

        e(rx.k.d dVar) {
            this.f36865a = dVar;
        }

        @Override // rx.k.x
        public Void call(Object... objArr) {
            if (objArr.length != 3) {
                throw new RuntimeException("Action3 expecting 3 arguments.");
            }
            this.f36865a.call(objArr[0], objArr[1], objArr[2]);
            return null;
        }
    }

    static class f<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ rx.k.n f36866a;

        f(rx.k.n nVar) {
            this.f36866a = nVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 0) {
                return (R) this.f36866a.call();
            }
            throw new RuntimeException("Func0 expecting 0 arguments.");
        }
    }

    static class g<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ o f36867a;

        g(o oVar) {
            this.f36867a = oVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 1) {
                return (R) this.f36867a.call(objArr[0]);
            }
            throw new RuntimeException("Func1 expecting 1 argument.");
        }
    }

    static class h<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ p f36868a;

        h(p pVar) {
            this.f36868a = pVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 2) {
                return (R) this.f36868a.call(objArr[0], objArr[1]);
            }
            throw new RuntimeException("Func2 expecting 2 arguments.");
        }
    }

    static class i<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ q f36869a;

        i(q qVar) {
            this.f36869a = qVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 3) {
                return (R) this.f36869a.call(objArr[0], objArr[1], objArr[2]);
            }
            throw new RuntimeException("Func3 expecting 3 arguments.");
        }
    }

    static class j<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ r f36870a;

        j(r rVar) {
            this.f36870a = rVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 4) {
                return (R) this.f36870a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new RuntimeException("Func4 expecting 4 arguments.");
        }
    }

    static class k<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ s f36871a;

        k(s sVar) {
            this.f36871a = sVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 5) {
                return (R) this.f36871a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new RuntimeException("Func5 expecting 5 arguments.");
        }
    }

    static class l<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ t f36872a;

        l(t tVar) {
            this.f36872a = tVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 6) {
                return (R) this.f36872a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new RuntimeException("Func6 expecting 6 arguments.");
        }
    }

    static class m<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ u f36873a;

        m(u uVar) {
            this.f36873a = uVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 7) {
                return (R) this.f36873a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new RuntimeException("Func7 expecting 7 arguments.");
        }
    }

    static class n<R> implements x<R> {

        /* renamed from: a */
        final /* synthetic */ v f36874a;

        n(v vVar) {
            this.f36874a = vVar;
        }

        @Override // rx.k.x
        public R call(Object... objArr) {
            if (objArr.length == 8) {
                return (R) this.f36874a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new RuntimeException("Func8 expecting 8 arguments.");
        }
    }

    private z() {
        throw new IllegalStateException("No instances!");
    }

    public static x<Void> a(rx.k.a aVar) {
        return new b(aVar);
    }

    public static <T0> x<Void> b(rx.k.b<? super T0> bVar) {
        return new c(bVar);
    }

    public static <T0, T1> x<Void> c(rx.k.c<? super T0, ? super T1> cVar) {
        return new d(cVar);
    }

    public static <T0, T1, T2> x<Void> d(rx.k.d<? super T0, ? super T1, ? super T2> dVar) {
        return new e(dVar);
    }

    public static <R> x<R> e(rx.k.n<? extends R> nVar) {
        return new f(nVar);
    }

    public static <T0, R> x<R> f(o<? super T0, ? extends R> oVar) {
        return new g(oVar);
    }

    public static <T0, T1, R> x<R> g(p<? super T0, ? super T1, ? extends R> pVar) {
        return new h(pVar);
    }

    public static <T0, T1, T2, R> x<R> h(q<? super T0, ? super T1, ? super T2, ? extends R> qVar) {
        return new i(qVar);
    }

    public static <T0, T1, T2, T3, R> x<R> i(r<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return new j(rVar);
    }

    public static <T0, T1, T2, T3, T4, R> x<R> j(s<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return new k(sVar);
    }

    public static <T0, T1, T2, T3, T4, T5, R> x<R> k(t<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return new l(tVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, R> x<R> l(u<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return new m(uVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, R> x<R> m(v<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return new n(vVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> x<R> n(w<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return new a(wVar);
    }
}
