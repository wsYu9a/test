package com.google.common.collect;

import com.google.common.collect.Maps;
import e5.d1;
import e5.u0;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public abstract class l<K, V> extends n<K, V> implements NavigableMap<K, V> {

    @a5.a
    public class a extends Maps.p<K, V> {

        /* renamed from: com.google.common.collect.l$a$a */
        public class C0293a implements Iterator<Map.Entry<K, V>> {

            /* renamed from: b */
            @CheckForNull
            public Map.Entry<K, V> f9951b = null;

            /* renamed from: c */
            @CheckForNull
            public Map.Entry<K, V> f9952c;

            public C0293a() {
                this.f9952c = a.this.g().lastEntry();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry = this.f9952c;
                if (entry == null) {
                    throw new NoSuchElementException();
                }
                this.f9951b = entry;
                this.f9952c = a.this.g().lowerEntry(this.f9952c.getKey());
                return entry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9952c != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.f9951b == null) {
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
                a.this.g().remove(this.f9951b.getKey());
                this.f9951b = null;
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> f() {
            return new C0293a();
        }

        @Override // com.google.common.collect.Maps.p
        public NavigableMap<K, V> g() {
            return l.this;
        }
    }

    @a5.a
    public class b extends Maps.c0<K, V> {
        public b(l lVar) {
            super(lVar);
        }
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@d1 K k10) {
        return delegate().ceilingEntry(k10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(@d1 K k10) {
        return delegate().ceilingKey(k10);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // com.google.common.collect.n, com.google.common.collect.j, e5.l0
    /* renamed from: e */
    public abstract NavigableMap<K, V> delegate();

    @CheckForNull
    public Map.Entry<K, V> f(@d1 K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(@d1 K k10) {
        return delegate().floorEntry(k10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(@d1 K k10) {
        return delegate().floorKey(k10);
    }

    @CheckForNull
    public K g(@d1 K k10) {
        return (K) Maps.T(ceilingEntry(k10));
    }

    @a5.a
    public NavigableSet<K> h() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(@d1 K k10, boolean z10) {
        return delegate().headMap(k10, z10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(@d1 K k10) {
        return delegate().higherEntry(k10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(@d1 K k10) {
        return delegate().higherKey(k10);
    }

    @CheckForNull
    public Map.Entry<K, V> i() {
        return (Map.Entry) u0.v(entrySet(), null);
    }

    public K j() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> k(@d1 K k10) {
        return headMap(k10, true).lastEntry();
    }

    @CheckForNull
    public K l(@d1 K k10) {
        return (K) Maps.T(floorEntry(k10));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@d1 K k10) {
        return delegate().lowerEntry(k10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(@d1 K k10) {
        return delegate().lowerKey(k10);
    }

    public SortedMap<K, V> m(@d1 K k10) {
        return headMap(k10, false);
    }

    @CheckForNull
    public Map.Entry<K, V> n(@d1 K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @CheckForNull
    public K o(@d1 K k10) {
        return (K) Maps.T(higherEntry(k10));
    }

    @CheckForNull
    public Map.Entry<K, V> p() {
        return (Map.Entry) u0.v(descendingMap().entrySet(), null);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public K q() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> r(@d1 K k10) {
        return headMap(k10, false).lastEntry();
    }

    @CheckForNull
    public K s(@d1 K k10) {
        return (K) Maps.T(lowerEntry(k10));
    }

    @Override // com.google.common.collect.n
    public SortedMap<K, V> standardSubMap(@d1 K k10, @d1 K k11) {
        return subMap(k10, true, k11, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
        return delegate().subMap(k10, z10, k11, z11);
    }

    @CheckForNull
    public Map.Entry<K, V> t() {
        return (Map.Entry) Iterators.U(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(@d1 K k10, boolean z10) {
        return delegate().tailMap(k10, z10);
    }

    @CheckForNull
    public Map.Entry<K, V> u() {
        return (Map.Entry) Iterators.U(descendingMap().entrySet().iterator());
    }

    public SortedMap<K, V> v(@d1 K k10) {
        return tailMap(k10, true);
    }
}
