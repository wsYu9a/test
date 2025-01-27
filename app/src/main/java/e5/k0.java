package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class k0<K, V> extends l0 implements z0<K, V> {
    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    public void clear() {
        delegate().clear();
    }

    @Override // e5.z0
    public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    @Override // e5.z0
    public boolean containsKey(@CheckForNull Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // e5.z0
    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // e5.l0
    public abstract z0<K, V> delegate();

    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // e5.z0, e5.x0
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public Collection<V> get(@d1 K k10) {
        return delegate().get(k10);
    }

    @Override // e5.z0
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // e5.z0
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public com.google.common.collect.s<K> keys() {
        return delegate().keys();
    }

    @CanIgnoreReturnValue
    public boolean put(@d1 K k10, @d1 V v10) {
        return delegate().put(k10, v10);
    }

    @CanIgnoreReturnValue
    public boolean putAll(@d1 K k10, Iterable<? extends V> iterable) {
        return delegate().putAll(k10, iterable);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @CanIgnoreReturnValue
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Collection<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k10, iterable);
    }

    @Override // e5.z0
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    @CanIgnoreReturnValue
    public boolean putAll(z0<? extends K, ? extends V> z0Var) {
        return delegate().putAll(z0Var);
    }
}
