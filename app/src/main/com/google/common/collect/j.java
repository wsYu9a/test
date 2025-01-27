package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.l0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class j<K, V> extends l0 implements Map<K, V> {

    @a5.a
    public abstract class a extends Maps.q<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.Maps.q
        public Map<K, V> a() {
            return j.this;
        }
    }

    @a5.a
    public class b extends Maps.z<K, V> {
        public b(j jVar) {
            super(jVar);
        }
    }

    @a5.a
    public class c extends Maps.m0<K, V> {
        public c(j jVar) {
            super(jVar);
        }
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // e5.l0
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 K k10, @d1 V v10) {
        return delegate().put(k10, v10);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.h(entrySet().iterator());
    }

    @a5.a
    public boolean standardContainsKey(@CheckForNull Object obj) {
        return Maps.q(this, obj);
    }

    public boolean standardContainsValue(@CheckForNull Object obj) {
        return Maps.r(this, obj);
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        return Maps.w(this, obj);
    }

    public int standardHashCode() {
        return Sets.k(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.j0(this, map);
    }

    @a5.a
    @CheckForNull
    public V standardRemove(@CheckForNull Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (b5.r.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.w0(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
