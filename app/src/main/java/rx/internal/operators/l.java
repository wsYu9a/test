package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class l<T> implements a.m0<T> {

    /* renamed from: a */
    final rx.k.n<? extends rx.a<? extends T>> f36210a;

    public l(rx.k.n<? extends rx.a<? extends T>> nVar) {
        this.f36210a = nVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        try {
            this.f36210a.call().T4(rx.l.e.f(gVar));
        } catch (Throwable th) {
            gVar.onError(th);
        }
    }
}
