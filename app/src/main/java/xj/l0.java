package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class l0<T, V> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32396b;

    /* renamed from: c */
    public final wj.o<? super T, ? extends qj.a<V>> f32397c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ hk.c f32398g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32399h;

        /* renamed from: xj.l0$a$a */
        public class C0826a implements wj.o<V, T> {

            /* renamed from: b */
            public final /* synthetic */ Object f32401b;

            public C0826a(Object obj) {
                this.f32401b = obj;
            }

            @Override // wj.o
            public T call(V v10) {
                return (T) this.f32401b;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, hk.c cVar, ek.d dVar) {
            super(gVar);
            this.f32398g = cVar;
            this.f32399h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32398g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32399h.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f32398g.onNext(l0.this.f32397c.call(t10).S3(1).f0(null).D1(new C0826a(t10)));
            } catch (Throwable th2) {
                onError(th2);
            }
        }
    }

    public l0(qj.a<? extends T> aVar, wj.o<? super T, ? extends qj.a<V>> oVar) {
        this.f32396b = aVar;
        this.f32397c = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        hk.c F5 = hk.c.F5();
        gVar.b(qj.a.I1(F5).T4(ek.e.e(dVar)));
        return new a(gVar, F5, dVar);
    }
}
