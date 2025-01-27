package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class j1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32337b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32338g = false;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32339h;

        /* renamed from: xj.j1$a$a */
        public class C0824a implements qj.c {

            /* renamed from: b */
            public final /* synthetic */ qj.c f32341b;

            public C0824a(qj.c cVar) {
                this.f32341b = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                this.f32341b.request(j10);
            }
        }

        public a(qj.g gVar) {
            this.f32339h = gVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32339h.f(new C0824a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32338g) {
                return;
            }
            this.f32338g = true;
            this.f32339h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32338g) {
                vj.a.e(th2);
                return;
            }
            this.f32338g = true;
            if (!(th2 instanceof Exception)) {
                this.f32339h.onError(th2);
                return;
            }
            fk.d.b().a().a(th2);
            unsubscribe();
            j1.this.f32337b.T4(this.f32339h);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32338g) {
                return;
            }
            this.f32339h.onNext(t10);
        }
    }

    public j1(qj.a<? extends T> aVar) {
        this.f32337b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
