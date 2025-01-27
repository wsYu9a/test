package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class l<T> implements a.m0<T> {

    /* renamed from: b */
    public final wj.n<? extends qj.a<? extends T>> f32395b;

    public l(wj.n<? extends qj.a<? extends T>> nVar) {
        this.f32395b = nVar;
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        try {
            this.f32395b.call().T4(ek.e.f(gVar));
        } catch (Throwable th2) {
            gVar.onError(th2);
        }
    }
}
