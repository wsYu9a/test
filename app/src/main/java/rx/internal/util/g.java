package rx.internal.util;

import rx.a;
import rx.d;
import rx.k.o;

/* loaded from: classes5.dex */
public final class g<T> extends rx.a<T> {

    /* renamed from: c */
    private final T f36794c;

    class a implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ Object f36795a;

        a(Object obj) {
            this.f36795a = obj;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            gVar.onNext((Object) this.f36795a);
            gVar.onCompleted();
        }
    }

    class b<R> implements a.m0<R> {

        /* renamed from: a */
        final /* synthetic */ o f36796a;

        class a extends rx.g<R> {

            /* renamed from: f */
            final /* synthetic */ rx.g f36798f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.g gVar, rx.g gVar2) {
                super(gVar);
                this.f36798f = gVar2;
            }

            @Override // rx.b
            public void onCompleted() {
                this.f36798f.onCompleted();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                this.f36798f.onError(th);
            }

            @Override // rx.b
            public void onNext(R r) {
                this.f36798f.onNext(r);
            }
        }

        b(o oVar) {
            this.f36796a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            rx.a aVar = (rx.a) this.f36796a.call(g.this.f36794c);
            if (aVar.getClass() != g.class) {
                aVar.T4(new a(gVar, gVar));
            } else {
                gVar.onNext((Object) ((g) aVar).f36794c);
                gVar.onCompleted();
            }
        }
    }

    static final class c<T> implements a.m0<T> {

        /* renamed from: a */
        private final rx.internal.schedulers.a f36800a;

        /* renamed from: b */
        private final T f36801b;

        c(rx.internal.schedulers.a aVar, T t) {
            this.f36800a = aVar;
            this.f36801b = t;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            gVar.b(this.f36800a.d(new e(gVar, this.f36801b, null)));
        }
    }

    static final class d<T> implements a.m0<T> {

        /* renamed from: a */
        private final rx.d f36802a;

        /* renamed from: b */
        private final T f36803b;

        d(rx.d dVar, T t) {
            this.f36802a = dVar;
            this.f36803b = t;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            d.a a2 = this.f36802a.a();
            gVar.b(a2);
            a2.d(new e(gVar, this.f36803b, null));
        }
    }

    static final class e<T> implements rx.k.a {

        /* renamed from: a */
        private final rx.g<? super T> f36804a;

        /* renamed from: b */
        private final T f36805b;

        /* synthetic */ e(rx.g gVar, Object obj, a aVar) {
            this(gVar, obj);
        }

        @Override // rx.k.a
        public void call() {
            try {
                this.f36804a.onNext(this.f36805b);
                this.f36804a.onCompleted();
            } catch (Throwable th) {
                this.f36804a.onError(th);
            }
        }

        private e(rx.g<? super T> gVar, T t) {
            this.f36804a = gVar;
            this.f36805b = t;
        }
    }

    protected g(T t) {
        super(new a(t));
        this.f36794c = t;
    }

    public static final <T> g<T> x5(T t) {
        return new g<>(t);
    }

    public rx.a<T> A5(rx.d dVar) {
        return dVar instanceof rx.internal.schedulers.a ? rx.a.b0(new c((rx.internal.schedulers.a) dVar, this.f36794c)) : rx.a.b0(new d(dVar, this.f36794c));
    }

    public T y5() {
        return this.f36794c;
    }

    public <R> rx.a<R> z5(o<? super T, ? extends rx.a<? extends R>> oVar) {
        return rx.a.b0(new b(oVar));
    }
}
