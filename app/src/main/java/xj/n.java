package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class n<T, U> implements a.m0<T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32458b;

    /* renamed from: c */
    public final wj.n<? extends qj.a<U>> f32459c;

    public n(qj.a<? extends T> aVar, wj.n<? extends qj.a<U>> nVar) {
        this.f32458b = aVar;
        this.f32459c = nVar;
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        try {
            this.f32459c.call().S3(1).T4(new a(gVar));
        } catch (Throwable th2) {
            gVar.onError(th2);
        }
    }

    public class a extends qj.g<U> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32460g;

        public a(qj.g gVar) {
            this.f32460g = gVar;
        }

        @Override // qj.b
        public void onCompleted() {
            n.this.f32458b.T4(ek.e.f(this.f32460g));
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32460g.onError(th2);
        }

        @Override // qj.b
        public void onNext(U u10) {
        }
    }
}
