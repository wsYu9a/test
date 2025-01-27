package com.google.common.collect;

import com.google.common.collect.Maps;
import e5.d1;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class n<K, V> extends j<K, V> implements SortedMap<K, V> {

    @a5.a
    public class a extends Maps.e0<K, V> {
        public a(n nVar) {
            super(nVar);
        }
    }

    public static int unsafeCompare(@CheckForNull Comparator<?> comparator, @CheckForNull Object obj, @CheckForNull Object obj2) {
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.j, e5.l0
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    @d1
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(@d1 K k10) {
        return delegate().headMap(k10);
    }

    @Override // java.util.SortedMap
    @d1
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j
    @a5.a
    public boolean standardContainsKey(@CheckForNull Object obj) {
        try {
            return unsafeCompare(comparator(), tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @a5.a
    public SortedMap<K, V> standardSubMap(K k10, K k11) {
        b5.u.e(unsafeCompare(comparator(), k10, k11) <= 0, "fromKey must be <= toKey");
        return tailMap(k10).headMap(k11);
    }

    public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
        return delegate().subMap(k10, k11);
    }

    public SortedMap<K, V> tailMap(@d1 K k10) {
        return delegate().tailMap(k10);
    }
}
