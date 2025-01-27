package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.l0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class p<R, C, V> extends l0 implements a0<R, C, V> {
    public Set<a0.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(@d1 C c10) {
        return delegate().column(c10);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.a0
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.a0
    public boolean containsColumn(@CheckForNull Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.a0
    public boolean containsRow(@CheckForNull Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.a0
    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // e5.l0
    public abstract a0<R, C, V> delegate();

    @Override // com.google.common.collect.a0
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.a0
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.a0
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.a0
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 R r10, @d1 C c10, @d1 V v10) {
        return delegate().put(r10, c10, v10);
    }

    public void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
        delegate().putAll(a0Var);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public Map<C, V> row(@d1 R r10) {
        return delegate().row(r10);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.a0
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
