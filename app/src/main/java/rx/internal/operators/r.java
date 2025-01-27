package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class r<TInput, TIntermediate, TResult> implements a.m0<TResult> {

    /* renamed from: a */
    final rx.a<? extends TInput> f36395a;

    /* renamed from: b */
    final rx.k.n<? extends rx.o.f<? super TInput, ? extends TIntermediate>> f36396b;

    /* renamed from: c */
    final rx.k.o<? super rx.a<TIntermediate>, ? extends rx.a<TResult>> f36397c;

    class a implements rx.k.b<rx.h> {

        /* renamed from: a */
        final /* synthetic */ rx.l.b f36398a;

        a(rx.l.b bVar) {
            this.f36398a = bVar;
        }

        @Override // rx.k.b
        public void call(rx.h hVar) {
            this.f36398a.b(hVar);
        }
    }

    public r(rx.a<? extends TInput> aVar, rx.k.n<? extends rx.o.f<? super TInput, ? extends TIntermediate>> nVar, rx.k.o<? super rx.a<TIntermediate>, ? extends rx.a<TResult>> oVar) {
        this.f36395a = aVar;
        this.f36396b = nVar;
        this.f36397c = oVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super TResult> gVar) {
        try {
            a1 a1Var = new a1(this.f36395a, this.f36396b);
            rx.a call = this.f36397c.call(a1Var);
            rx.l.b bVar = new rx.l.b(gVar);
            call.T4(bVar);
            a1Var.A5(new a(bVar));
        } catch (Throwable th) {
            gVar.onError(th);
        }
    }
}
