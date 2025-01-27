package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class h1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32281b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32282g = false;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32283h;

        /* renamed from: xj.h1$a$a */
        public class C0820a implements qj.c {

            /* renamed from: b */
            public final /* synthetic */ qj.c f32285b;

            public C0820a(qj.c cVar) {
                this.f32285b = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                this.f32285b.request(j10);
            }
        }

        public a(qj.g gVar) {
            this.f32283h = gVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32283h.f(new C0820a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32282g) {
                return;
            }
            this.f32282g = true;
            this.f32283h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32282g) {
                vj.a.e(th2);
                return;
            }
            this.f32282g = true;
            fk.d.b().a().a(th2);
            unsubscribe();
            h1.this.f32281b.T4(this.f32283h);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32282g) {
                return;
            }
            this.f32283h.onNext(t10);
        }
    }

    public h1(qj.a<? extends T> aVar) {
        this.f32281b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
