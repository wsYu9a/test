package xj;

import qj.a;
import xj.j0;

/* loaded from: classes5.dex */
public final class i0<T, U> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends qj.a<U>> f32297b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final j0.b<T> f32298g;

        /* renamed from: h */
        public final qj.g<?> f32299h;

        /* renamed from: i */
        public final /* synthetic */ ek.d f32300i;

        /* renamed from: j */
        public final /* synthetic */ ik.e f32301j;

        /* renamed from: xj.i0$a$a */
        public class C0821a extends qj.g<U> {

            /* renamed from: g */
            public final /* synthetic */ int f32303g;

            public C0821a(int i10) {
                this.f32303g = i10;
            }

            @Override // qj.b
            public void onCompleted() {
                a aVar = a.this;
                aVar.f32298g.b(this.f32303g, aVar.f32300i, aVar.f32299h);
                unsubscribe();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f32299h.onError(th2);
            }

            @Override // qj.b
            public void onNext(U u10) {
                onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, ek.d dVar, ik.e eVar) {
            super(gVar);
            this.f32300i = dVar;
            this.f32301j = eVar;
            this.f32298g = new j0.b<>();
            this.f32299h = this;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32298g.c(this.f32300i, this);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32300i.onError(th2);
            unsubscribe();
            this.f32298g.a();
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                qj.a<U> call = i0.this.f32297b.call(t10);
                C0821a c0821a = new C0821a(this.f32298g.d(t10));
                this.f32301j.b(c0821a);
                call.T4(c0821a);
            } catch (Throwable th2) {
                onError(th2);
            }
        }
    }

    public i0(wj.o<? super T, ? extends qj.a<U>> oVar) {
        this.f32297b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        ik.e eVar = new ik.e();
        gVar.b(eVar);
        return new a(gVar, dVar, eVar);
    }
}
