package xj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import qj.a;

/* loaded from: classes5.dex */
public final class q2<T, K, V> implements a.n0<Map<K, Collection<V>>, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends K> f32580b;

    /* renamed from: c */
    public final wj.o<? super T, ? extends V> f32581c;

    /* renamed from: d */
    public final wj.n<? extends Map<K, Collection<V>>> f32582d;

    /* renamed from: e */
    public final wj.o<? super K, ? extends Collection<V>> f32583e;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public Map<K, Collection<V>> f32584g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32585h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32585h = gVar2;
            this.f32584g = (Map) q2.this.f32582d.call();
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            Map<K, Collection<V>> map = this.f32584g;
            this.f32584g = null;
            this.f32585h.onNext(map);
            this.f32585h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32584g = null;
            this.f32585h.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            Object call = q2.this.f32580b.call(t10);
            Object call2 = q2.this.f32581c.call(t10);
            Collection collection = this.f32584g.get(call);
            if (collection == null) {
                collection = (Collection) q2.this.f32583e.call(call);
                this.f32584g.put(call, collection);
            }
            collection.add(call2);
        }
    }

    public static final class b<K, V> implements wj.o<K, Collection<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // wj.o
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((b<K, V>) obj);
        }

        @Override // wj.o
        public Collection<V> call(K k10) {
            return new ArrayList();
        }
    }

    public static final class c<K, V> implements wj.n<Map<K, Collection<V>>> {
        @Override // wj.n, java.util.concurrent.Callable
        public Map<K, Collection<V>> call() {
            return new HashMap();
        }
    }

    public q2(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2) {
        this(oVar, oVar2, new c(), new b());
    }

    public q2(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, Collection<V>>> nVar) {
        this(oVar, oVar2, nVar, new b());
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super Map<K, Collection<V>>> gVar) {
        return new a(gVar, gVar);
    }

    public q2(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, Collection<V>>> nVar, wj.o<? super K, ? extends Collection<V>> oVar3) {
        this.f32580b = oVar;
        this.f32581c = oVar2;
        this.f32582d = nVar;
        this.f32583e = oVar3;
    }
}
