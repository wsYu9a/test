package d5;

import b5.u;
import com.google.common.collect.ImmutableMap;
import e5.l0;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

@a5.c
@d
/* loaded from: classes2.dex */
public abstract class e<K, V> extends l0 implements b<K, V> {

    public static abstract class a<K, V> extends e<K, V> {

        /* renamed from: b */
        public final b<K, V> f25255b;

        public a(b<K, V> bVar) {
            this.f25255b = (b) u.E(bVar);
        }

        @Override // d5.e, e5.l0
        public final b<K, V> delegate() {
            return this.f25255b;
        }
    }

    @Override // d5.b
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // d5.b
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // e5.l0
    public abstract b<K, V> delegate();

    @Override // d5.b
    public V get(K k10, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k10, callable);
    }

    @Override // d5.b
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        return delegate().getAllPresent(iterable);
    }

    @Override // d5.b
    @CheckForNull
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // d5.b
    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    @Override // d5.b
    public void invalidateAll(Iterable<? extends Object> iterable) {
        delegate().invalidateAll(iterable);
    }

    @Override // d5.b
    public void put(K k10, V v10) {
        delegate().put(k10, v10);
    }

    @Override // d5.b
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // d5.b
    public long size() {
        return delegate().size();
    }

    @Override // d5.b
    public c stats() {
        return delegate().stats();
    }

    @Override // d5.b
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
