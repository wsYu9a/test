package d5;

import b5.u;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

@a5.c
@d
/* loaded from: classes2.dex */
public abstract class f<K, V> extends e<K, V> implements g<K, V> {

    public static abstract class a<K, V> extends f<K, V> {

        /* renamed from: b */
        public final g<K, V> f25256b;

        public a(g<K, V> gVar) {
            this.f25256b = (g) u.E(gVar);
        }

        @Override // d5.f, d5.e, e5.l0
        /* renamed from: e */
        public final g<K, V> delegate() {
            return this.f25256b;
        }
    }

    @Override // d5.g, b5.n
    public V apply(K k10) {
        return delegate().apply(k10);
    }

    @Override // d5.e, e5.l0
    /* renamed from: e */
    public abstract g<K, V> delegate();

    @Override // d5.g
    public V get(K k10) throws ExecutionException {
        return delegate().get(k10);
    }

    @Override // d5.g
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    @Override // d5.g
    public V getUnchecked(K k10) {
        return delegate().getUnchecked(k10);
    }

    @Override // d5.g
    public void refresh(K k10) {
        delegate().refresh(k10);
    }
}
