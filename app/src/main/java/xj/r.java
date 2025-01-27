package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class r<TInput, TIntermediate, TResult> implements a.m0<TResult> {

    /* renamed from: b */
    public final qj.a<? extends TInput> f32587b;

    /* renamed from: c */
    public final wj.n<? extends hk.f<? super TInput, ? extends TIntermediate>> f32588c;

    /* renamed from: d */
    public final wj.o<? super qj.a<TIntermediate>, ? extends qj.a<TResult>> f32589d;

    public class a implements wj.b<qj.h> {

        /* renamed from: b */
        public final /* synthetic */ ek.b f32590b;

        public a(ek.b bVar) {
            this.f32590b = bVar;
        }

        @Override // wj.b
        public void call(qj.h hVar) {
            this.f32590b.b(hVar);
        }
    }

    public r(qj.a<? extends TInput> aVar, wj.n<? extends hk.f<? super TInput, ? extends TIntermediate>> nVar, wj.o<? super qj.a<TIntermediate>, ? extends qj.a<TResult>> oVar) {
        this.f32587b = aVar;
        this.f32588c = nVar;
        this.f32589d = oVar;
    }

    @Override // wj.b
    public void call(qj.g<? super TResult> gVar) {
        try {
            a1 a1Var = new a1(this.f32587b, this.f32588c);
            qj.a call = this.f32589d.call(a1Var);
            ek.b bVar = new ek.b(gVar);
            call.T4(bVar);
            a1Var.A5(new a(bVar));
        } catch (Throwable th2) {
            gVar.onError(th2);
        }
    }
}
