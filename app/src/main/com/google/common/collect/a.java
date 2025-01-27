package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.d1;
import e5.z0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class a<K, V> implements z0<K, V> {

    @CheckForNull
    @LazyInit
    private transient Map<K, Collection<V>> asMap;

    @CheckForNull
    @LazyInit
    private transient Collection<Map.Entry<K, V>> entries;

    @CheckForNull
    @LazyInit
    private transient Set<K> keySet;

    @CheckForNull
    @LazyInit
    private transient s<K> keys;

    @CheckForNull
    @LazyInit
    private transient Collection<V> values;

    /* renamed from: com.google.common.collect.a$a */
    public class C0285a extends Multimaps.b<K, V> {
        public C0285a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        public z0<K, V> a() {
            return a.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return a.this.entryIterator();
        }
    }

    public class b extends a<K, V>.C0285a implements Set<Map.Entry<K, V>> {
        public b(a aVar) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }
    }

    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return a.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return a.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a.this.size();
        }
    }

    @Override // e5.z0, e5.x0
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    @Override // e5.z0
    public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // e5.z0
    public boolean containsValue(@CheckForNull Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract s<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // e5.z0
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> createEntries = createEntries();
        this.entries = createEntries;
        return createEntries;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // e5.z0, e5.x0
    public boolean equals(@CheckForNull Object obj) {
        return Multimaps.g(this, obj);
    }

    @Override // e5.z0
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // e5.z0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // e5.z0
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // e5.z0
    public s<K> keys() {
        s<K> sVar = this.keys;
        if (sVar != null) {
            return sVar;
        }
        s<K> createKeys = createKeys();
        this.keys = createKeys;
        return createKeys;
    }

    @Override // e5.z0
    @CanIgnoreReturnValue
    public boolean put(@d1 K k10, @d1 V v10) {
        return get(k10).add(v10);
    }

    @Override // e5.z0
    @CanIgnoreReturnValue
    public boolean putAll(@d1 K k10, Iterable<? extends V> iterable) {
        b5.u.E(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k10).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k10), it);
    }

    @Override // e5.z0
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    public Collection<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        b5.u.E(iterable);
        Collection<V> removeAll = removeAll(k10);
        putAll(k10, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.O0(entries().iterator());
    }

    @Override // e5.z0
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    @Override // e5.z0
    @CanIgnoreReturnValue
    public boolean putAll(z0<? extends K, ? extends V> z0Var) {
        boolean z10 = false;
        for (Map.Entry<? extends K, ? extends V> entry : z0Var.entries()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }
}
