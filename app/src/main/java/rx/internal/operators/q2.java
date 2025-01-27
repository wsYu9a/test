package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.a;

/* loaded from: classes5.dex */
public final class q2<T, K, V> implements a.n0<Map<K, Collection<V>>, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, ? extends K> f36388a;

    /* renamed from: b */
    private final rx.k.o<? super T, ? extends V> f36389b;

    /* renamed from: c */
    private final rx.k.n<? extends Map<K, Collection<V>>> f36390c;

    /* renamed from: d */
    private final rx.k.o<? super K, ? extends Collection<V>> f36391d;

    class a extends rx.g<T> {

        /* renamed from: f */
        private Map<K, Collection<V>> f36392f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36393g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36393g = gVar2;
            this.f36392f = (Map) q2.this.f36390c.call();
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            Map<K, Collection<V>> map = this.f36392f;
            this.f36392f = null;
            this.f36393g.onNext(map);
            this.f36393g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36392f = null;
            this.f36393g.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            Object call = q2.this.f36388a.call(t);
            Object call2 = q2.this.f36389b.call(t);
            Collection collection = this.f36392f.get(call);
            if (collection == null) {
                collection = (Collection) q2.this.f36391d.call(call);
                this.f36392f.put(call, collection);
            }
            collection.add(call2);
        }
    }

    public static final class b<K, V> implements rx.k.o<K, Collection<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k.o
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((b<K, V>) obj);
        }

        @Override // rx.k.o
        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }

    public static final class c<K, V> implements rx.k.n<Map<K, Collection<V>>> {
        @Override // rx.k.n, java.util.concurrent.Callable
        public Map<K, Collection<V>> call() {
            return new HashMap();
        }
    }

    public q2(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2) {
        this(oVar, oVar2, new c(), new b());
    }

    public q2(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, Collection<V>>> nVar) {
        this(oVar, oVar2, nVar, new b());
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super Map<K, Collection<V>>> gVar) {
        return new a(gVar, gVar);
    }

    public q2(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends V> oVar2, rx.k.n<? extends Map<K, Collection<V>>> nVar, rx.k.o<? super K, ? extends Collection<V>> oVar3) {
        this.f36388a = oVar;
        this.f36389b = oVar2;
        this.f36390c = nVar;
        this.f36391d = oVar3;
    }
}
