package xj;

import java.util.HashMap;
import java.util.Map;
import qj.a;

/* loaded from: classes5.dex */
public final class p2<T, K, V> implements a.n0<Map<K, V>, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends K> f32544b;

    /* renamed from: c */
    public final wj.o<? super T, ? extends V> f32545c;

    /* renamed from: d */
    public final wj.n<? extends Map<K, V>> f32546d;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public Map<K, V> f32547g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32548h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32548h = gVar2;
            this.f32547g = (Map) p2.this.f32546d.call();
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            Map<K, V> map = this.f32547g;
            this.f32547g = null;
            this.f32548h.onNext(map);
            this.f32548h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32547g = null;
            this.f32548h.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            this.f32547g.put(p2.this.f32544b.call(t10), p2.this.f32545c.call(t10));
        }
    }

    public static final class b<K, V> implements wj.n<Map<K, V>> {
        @Override // wj.n, java.util.concurrent.Callable
        public Map<K, V> call() {
            return new HashMap();
        }
    }

    public p2(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2) {
        this(oVar, oVar2, new b());
    }

    public p2(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends V> oVar2, wj.n<? extends Map<K, V>> nVar) {
        this.f32544b = oVar;
        this.f32545c = oVar2;
        this.f32546d = nVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super Map<K, V>> gVar) {
        return new a(gVar, gVar);
    }
}
