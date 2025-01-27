package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.d1;
import e5.v1;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class e<R, C, V> implements a0<R, C, V> {

    @CheckForNull
    @LazyInit
    private transient Set<a0.a<R, C, V>> cellSet;

    @CheckForNull
    @LazyInit
    private transient Collection<V> values;

    public class a extends v1<a0.a<R, C, V>, V> {
        public a(e eVar, Iterator it) {
            super(it);
        }

        @Override // e5.v1
        @d1
        /* renamed from: b */
        public V a(a0.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    public class b extends AbstractSet<a0.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof a0.a)) {
                return false;
            }
            a0.a aVar = (a0.a) obj;
            Map map = (Map) Maps.p0(e.this.rowMap(), aVar.getRowKey());
            return map != null && f.j(map.entrySet(), Maps.O(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<a0.a<R, C, V>> iterator() {
            return e.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof a0.a)) {
                return false;
            }
            a0.a aVar = (a0.a) obj;
            Map map = (Map) Maps.p0(e.this.rowMap(), aVar.getRowKey());
            return map != null && f.k(map.entrySet(), Maps.O(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e.this.size();
        }
    }

    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return e.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return e.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return e.this.size();
        }
    }

    public abstract Iterator<a0.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.a0
    public Set<a0.a<R, C, V>> cellSet() {
        Set<a0.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<a0.a<R, C, V>> createCellSet = createCellSet();
        this.cellSet = createCellSet;
        return createCellSet;
    }

    @Override // com.google.common.collect.a0
    public void clear() {
        Iterators.h(cellSet().iterator());
    }

    @Override // com.google.common.collect.a0
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.a0
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(rowMap(), obj);
        return map != null && Maps.o0(map, obj2);
    }

    @Override // com.google.common.collect.a0
    public boolean containsColumn(@CheckForNull Object obj) {
        return Maps.o0(columnMap(), obj);
    }

    @Override // com.google.common.collect.a0
    public boolean containsRow(@CheckForNull Object obj) {
        return Maps.o0(rowMap(), obj);
    }

    @Override // com.google.common.collect.a0
    public boolean containsValue(@CheckForNull Object obj) {
        Iterator<Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<a0.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    @Override // com.google.common.collect.a0
    public boolean equals(@CheckForNull Object obj) {
        return Tables.b(this, obj);
    }

    @Override // com.google.common.collect.a0
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.p0(map, obj2);
    }

    @Override // com.google.common.collect.a0
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.a0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 R r10, @d1 C c10, @d1 V v10) {
        return row(r10).put(c10, v10);
    }

    @Override // com.google.common.collect.a0
    public void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
        for (a0.a<? extends R, ? extends C, ? extends V> aVar : a0Var.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    @Override // com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.q0(map, obj2);
    }

    @Override // com.google.common.collect.a0
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.a0
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new a(this, cellSet().iterator());
    }
}
