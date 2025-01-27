package dk;

import qj.a;
import qj.g;

/* loaded from: classes5.dex */
public class c<K, T> extends qj.a<T> {

    /* renamed from: d */
    public final K f25574d;

    public static class a implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f25575b;

        public a(qj.a aVar) {
            this.f25575b = aVar;
        }

        @Override // wj.b
        public void call(g<? super T> gVar) {
            this.f25575b.T4(gVar);
        }
    }

    public c(K k10, a.m0<T> m0Var) {
        super(m0Var);
        this.f25574d = k10;
    }

    public static final <K, T> c<K, T> w5(K k10, a.m0<T> m0Var) {
        return new c<>(k10, m0Var);
    }

    public static <K, T> c<K, T> x5(K k10, qj.a<T> aVar) {
        return new c<>(k10, new a(aVar));
    }

    public K y5() {
        return this.f25574d;
    }
}
