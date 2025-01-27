package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.a;

/* loaded from: classes5.dex */
public final class p2<T, K, V> implements a.n0<Map<K, V>, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, ? extends K> f36352a;

    /* renamed from: b */
    private final rx.k.o<? super T, ? extends V> f36353b;

    /* renamed from: c */
    private final rx.k.n<? extends Map<K, V>> f36354c;

    class a extends rx.g<T> {

        /* renamed from: f */
        private Map<K, V> f36355f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36356g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36356g = gVar2;
            this.f36355f = (Map) p2.this.f36354c.call();
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            Map<K, V> map = this.f36355f;
            this.f36355f = null;
            this.f36356g.onNext(map);
            this.f36356g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36355f = null;
            this.f36356g.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            this.f36355f.put(p2.this.f36352a.call(t), p2.this.f36353b.call(t));
        }
    }

    public static final class b<K, V> implements rx.k.n<Map<K, V>> {
        @Override // rx.k.n, java.util.concurrent.Callable
        public Map<K, V> call() {
            return new HashMap();
        }
    }

    public p2(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2) {
        this(oVar, oVar2, new b());
    }

    public p2(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, V>> nVar) {
        this.f36352a = oVar;
        this.f36353b = oVar2;
        this.f36354c = nVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super Map<K, V>> gVar) {
        return new a(gVar, gVar);
    }
}
