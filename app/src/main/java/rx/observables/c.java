package rx.observables;

import rx.a;
import rx.g;

/* loaded from: classes5.dex */
public class c<K, T> extends rx.a<T> {

    /* renamed from: c */
    private final K f37095c;

    static class a implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ rx.a f37096a;

        a(rx.a aVar) {
            this.f37096a = aVar;
        }

        @Override // rx.k.b
        public void call(g<? super T> gVar) {
            this.f37096a.T4(gVar);
        }
    }

    protected c(K k, a.m0<T> m0Var) {
        super(m0Var);
        this.f37095c = k;
    }

    public static final <K, T> c<K, T> w5(K k, a.m0<T> m0Var) {
        return new c<>(k, m0Var);
    }

    public static <K, T> c<K, T> x5(K k, rx.a<T> aVar) {
        return new c<>(k, new a(aVar));
    }

    public K y5() {
        return this.f37095c;
    }
}
