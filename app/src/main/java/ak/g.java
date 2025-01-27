package ak;

import qj.a;
import qj.d;
import wj.o;

/* loaded from: classes5.dex */
public final class g<T> extends qj.a<T> {

    /* renamed from: d */
    public final T f256d;

    public class a implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ Object f257b;

        public a(Object obj) {
            this.f257b = obj;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            gVar.onNext((Object) this.f257b);
            gVar.onCompleted();
        }
    }

    public class b<R> implements a.m0<R> {

        /* renamed from: b */
        public final /* synthetic */ o f258b;

        public class a extends qj.g<R> {

            /* renamed from: g */
            public final /* synthetic */ qj.g f260g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(qj.g gVar, qj.g gVar2) {
                super(gVar);
                this.f260g = gVar2;
            }

            @Override // qj.b
            public void onCompleted() {
                this.f260g.onCompleted();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                this.f260g.onError(th2);
            }

            @Override // qj.b
            public void onNext(R r10) {
                this.f260g.onNext(r10);
            }
        }

        public b(o oVar) {
            this.f258b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.b
        public void call(qj.g<? super R> gVar) {
            qj.a aVar = (qj.a) this.f258b.call(g.this.f256d);
            if (aVar.getClass() != g.class) {
                aVar.T4(new a(gVar, gVar));
            } else {
                gVar.onNext((Object) ((g) aVar).f256d);
                gVar.onCompleted();
            }
        }
    }

    public static final class c<T> implements a.m0<T> {

        /* renamed from: b */
        public final zj.a f262b;

        /* renamed from: c */
        public final T f263c;

        public c(zj.a aVar, T t10) {
            this.f262b = aVar;
            this.f263c = t10;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            gVar.b(this.f262b.d(new e(gVar, this.f263c, null)));
        }
    }

    public static final class d<T> implements a.m0<T> {

        /* renamed from: b */
        public final qj.d f264b;

        /* renamed from: c */
        public final T f265c;

        public d(qj.d dVar, T t10) {
            this.f264b = dVar;
            this.f265c = t10;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            d.a a10 = this.f264b.a();
            gVar.b(a10);
            a10.b(new e(gVar, this.f265c, null));
        }
    }

    public static final class e<T> implements wj.a {

        /* renamed from: b */
        public final qj.g<? super T> f266b;

        /* renamed from: c */
        public final T f267c;

        public /* synthetic */ e(qj.g gVar, Object obj, a aVar) {
            this(gVar, obj);
        }

        @Override // wj.a
        public void call() {
            try {
                this.f266b.onNext(this.f267c);
                this.f266b.onCompleted();
            } catch (Throwable th2) {
                this.f266b.onError(th2);
            }
        }

        public e(qj.g<? super T> gVar, T t10) {
            this.f266b = gVar;
            this.f267c = t10;
        }
    }

    public g(T t10) {
        super(new a(t10));
        this.f256d = t10;
    }

    public static final <T> g<T> x5(T t10) {
        return new g<>(t10);
    }

    public qj.a<T> A5(qj.d dVar) {
        return dVar instanceof zj.a ? qj.a.b0(new c((zj.a) dVar, this.f256d)) : qj.a.b0(new d(dVar, this.f256d));
    }

    public T y5() {
        return this.f256d;
    }

    public <R> qj.a<R> z5(o<? super T, ? extends qj.a<? extends R>> oVar) {
        return qj.a.b0(new b(oVar));
    }
}
