package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class g1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<Throwable, ? extends qj.a<? extends T>> f32241b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32242g = false;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32243h;

        /* renamed from: i */
        public final /* synthetic */ yj.a f32244i;

        /* renamed from: j */
        public final /* synthetic */ ik.e f32245j;

        /* renamed from: xj.g1$a$a */
        public class C0819a extends qj.g<T> {
            public C0819a() {
            }

            @Override // qj.g
            public void f(qj.c cVar) {
                a.this.f32244i.c(cVar);
            }

            @Override // qj.b
            public void onCompleted() {
                a.this.f32243h.onCompleted();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f32243h.onError(th2);
            }

            @Override // qj.b
            public void onNext(T t10) {
                a.this.f32243h.onNext(t10);
            }
        }

        public a(qj.g gVar, yj.a aVar, ik.e eVar) {
            this.f32243h = gVar;
            this.f32244i = aVar;
            this.f32245j = eVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32244i.c(cVar);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32242g) {
                return;
            }
            this.f32242g = true;
            this.f32243h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32242g) {
                vj.a.e(th2);
                return;
            }
            this.f32242g = true;
            try {
                fk.d.b().a().a(th2);
                unsubscribe();
                C0819a c0819a = new C0819a();
                this.f32245j.b(c0819a);
                ((qj.a) g1.this.f32241b.call(th2)).T4(c0819a);
            } catch (Throwable th3) {
                this.f32243h.onError(th3);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32242g) {
                return;
            }
            this.f32243h.onNext(t10);
        }
    }

    public g1(wj.o<Throwable, ? extends qj.a<? extends T>> oVar) {
        this.f32241b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        yj.a aVar = new yj.a();
        ik.e eVar = new ik.e();
        a aVar2 = new a(gVar, aVar, eVar);
        gVar.b(eVar);
        eVar.b(aVar2);
        gVar.f(aVar);
        return aVar2;
    }
}
