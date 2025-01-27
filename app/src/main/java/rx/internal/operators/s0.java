package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public class s0<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.a f36425a;

    public s0(rx.k.a aVar) {
        this.f36425a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        gVar.b(rx.p.f.a(this.f36425a));
        return rx.l.e.f(gVar);
    }
}
