package com.google.common.collect;

import com.google.common.collect.Maps;
import e5.d1;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public abstract class c<K, V> extends Maps.y<K, V> implements NavigableMap<K, V> {

    public final class b extends Maps.p<K, V> {
        public b() {
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> f() {
            return c.this.c();
        }

        @Override // com.google.common.collect.Maps.p
        public NavigableMap<K, V> g() {
            return c.this;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public abstract Iterator<Map.Entry<K, V>> c();

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@d1 K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(@d1 K k10) {
        return (K) Maps.T(ceilingEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new b();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.J(a(), null);
    }

    @Override // java.util.SortedMap
    @d1
    public K firstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(@d1 K k10) {
        return headMap(k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(@d1 K k10) {
        return (K) Maps.T(floorEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(@d1 K k10) {
        return headMap(k10, false);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(@d1 K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(@d1 K k10) {
        return (K) Maps.T(higherEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.J(c(), null);
    }

    @Override // java.util.SortedMap
    @d1
    public K lastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@d1 K k10) {
        return headMap(k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(@d1 K k10) {
        return (K) Maps.T(lowerEntry(k10));
    }

    public NavigableSet<K> navigableKeySet() {
        return new Maps.c0(this);
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.U(a());
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.U(c());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
        return subMap(k10, true, k11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(@d1 K k10) {
        return tailMap(k10, true);
    }
}
