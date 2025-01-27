package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.a;
import e5.a1;
import e5.d1;
import e5.l1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.a<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        @d1
        public V a(@d1 K k10, @d1 V v10) {
            return v10;
        }
    }

    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* renamed from: b */
        public Map.Entry<K, V> a(@d1 K k10, @d1 V v10) {
            return Maps.O(k10, v10);
        }
    }

    public class c extends Maps.n0<K, Collection<V>> {

        /* renamed from: e */
        public final transient Map<K, Collection<V>> f9334e;

        public class a extends Maps.q<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, Collection<V>> a() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return com.google.common.collect.f.j(c.this.f9334e.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }

        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: b */
            public final Iterator<Map.Entry<K, Collection<V>>> f9337b;

            /* renamed from: c */
            @CheckForNull
            public Collection<V> f9338c;

            public b() {
                this.f9337b = c.this.f9334e.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f9337b.next();
                this.f9338c = next.getValue();
                return c.this.h(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9337b.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                b5.u.h0(this.f9338c != null, "no calls to next() since the last call to remove()");
                this.f9337b.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f9338c.size());
                this.f9338c.clear();
                this.f9338c = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.f9334e = map;
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f9334e == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.h(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return Maps.o0(this.f9334e, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || this.f9334e.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = (Collection) Maps.p0(this.f9334e, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> remove = this.f9334e.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return createCollection;
        }

        public Map.Entry<K, Collection<V>> h(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.O(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f9334e.hashCode();
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9334e.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f9334e.toString();
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* renamed from: b */
        public final Iterator<Map.Entry<K, Collection<V>>> f9340b;

        /* renamed from: c */
        @CheckForNull
        public K f9341c = null;

        /* renamed from: d */
        @CheckForNull
        public Collection<V> f9342d = null;

        /* renamed from: e */
        public Iterator<V> f9343e = Iterators.w();

        public d() {
            this.f9340b = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T a(@d1 K k10, @d1 V v10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9340b.hasNext() || this.f9343e.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f9343e.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f9340b.next();
                this.f9341c = next.getKey();
                Collection<V> value = next.getValue();
                this.f9342d = value;
                this.f9343e = value.iterator();
            }
            return a(a1.a(this.f9341c), this.f9343e.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9343e.remove();
            Collection<V> collection = this.f9342d;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f9340b.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    public class e extends Maps.z<K, Collection<V>> {

        public class a implements Iterator<K> {

            /* renamed from: b */
            @CheckForNull
            public Map.Entry<K, Collection<V>> f9346b;

            /* renamed from: c */
            public final /* synthetic */ Iterator f9347c;

            public a(Iterator it) {
                this.f9347c = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9347c.hasNext();
            }

            @Override // java.util.Iterator
            @d1
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f9347c.next();
                this.f9346b = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                b5.u.h0(this.f9346b != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f9346b.getValue();
                this.f9347c.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, value.size());
                value.clear();
                this.f9346b = null;
            }
        }

        public e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.h(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(b().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int i10;
            Collection<V> remove = b().remove(obj);
            if (remove != null) {
                i10 = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i10);
            } else {
                i10 = 0;
            }
            return i10 > 0;
        }
    }

    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@d1 K k10) {
            Map.Entry<K, Collection<V>> ceilingEntry = k().ceilingEntry(k10);
            if (ceilingEntry == null) {
                return null;
            }
            return h(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@d1 K k10) {
            return k().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(k().descendingMap());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = k().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return h(firstEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@d1 K k10) {
            Map.Entry<K, Collection<V>> floorEntry = k().floorEntry(k10);
            if (floorEntry == null) {
                return null;
            }
            return h(floorEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@d1 K k10) {
            return k().floorKey(k10);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@d1 K k10) {
            Map.Entry<K, Collection<V>> higherEntry = k().higherEntry(k10);
            if (higherEntry == null) {
                return null;
            }
            return h(higherEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@d1 K k10) {
            return k().higherKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> i() {
            return new g(k());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = k().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return h(lastEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@d1 K k10) {
            Map.Entry<K, Collection<V>> lowerEntry = k().lowerEntry(k10);
            if (lowerEntry == null) {
                return null;
            }
            return h(lowerEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@d1 K k10) {
            return k().lowerKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: m */
        public NavigableMap<K, Collection<V>> headMap(@d1 K k10) {
            return headMap(k10, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return j();
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> o(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return Maps.O(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> k() {
            return (NavigableMap) super.k();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return o(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return o(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: q */
        public NavigableMap<K, Collection<V>> subMap(@d1 K k10, @d1 K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: r */
        public NavigableMap<K, Collection<V>> tailMap(@d1 K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@d1 K k10, boolean z10) {
            return new f(k().headMap(k10, z10));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return new f(k().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@d1 K k10, boolean z10) {
            return new f(k().tailMap(k10, z10));
        }
    }

    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: c */
        public NavigableSet<K> headSet(@d1 K k10) {
            return headSet(k10, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@d1 K k10) {
            return b().ceilingKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* renamed from: d */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(b().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: e */
        public NavigableSet<K> subSet(@d1 K k10, @d1 K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f */
        public NavigableSet<K> tailSet(@d1 K k10) {
            return tailSet(k10, true);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@d1 K k10) {
            return b().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@d1 K k10) {
            return b().higherKey(k10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@d1 K k10) {
            return b().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Iterators.U(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Iterators.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@d1 K k10, boolean z10) {
            return new g(b().headMap(k10, z10));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return new g(b().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@d1 K k10, boolean z10) {
            return new g(b().tailMap(k10, z10));
        }
    }

    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public h(@d1 AbstractMapBasedMultimap abstractMapBasedMultimap, K k10, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, list, kVar);
        }
    }

    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {

        /* renamed from: g */
        @CheckForNull
        public SortedSet<K> f9351g;

        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedMap
        @d1
        public K firstKey() {
            return k().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(@d1 K k10) {
            return new i(k().headMap(k10));
        }

        @Override // com.google.common.collect.Maps.n0
        public SortedSet<K> i() {
            return new j(k());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        /* renamed from: j */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f9351g;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> i10 = i();
            this.f9351g = i10;
            return i10;
        }

        public SortedMap<K, Collection<V>> k() {
            return (SortedMap) this.f9334e;
        }

        @Override // java.util.SortedMap
        @d1
        public K lastKey() {
            return k().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(@d1 K k10, @d1 K k11) {
            return new i(k().subMap(k10, k11));
        }

        public SortedMap<K, Collection<V>> tailMap(@d1 K k10) {
            return new i(k().tailMap(k10));
        }
    }

    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        @d1
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(@d1 K k10) {
            return new j(b().headMap(k10));
        }

        @Override // java.util.SortedSet
        @d1
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(@d1 K k10, @d1 K k11) {
            return new j(b().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(@d1 K k10) {
            return new j(b().tailMap(k10));
        }
    }

    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        public m(@d1 K k10, NavigableSet<V> navigableSet, @CheckForNull AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V ceiling(@d1 V v10) {
            return g().ceiling(v10);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V floor(@d1 V v10) {
            return g().floor(v10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(@d1 V v10, boolean z10) {
            return i(g().headSet(v10, z10));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V higher(@d1 V v10) {
            return g().higher(v10);
        }

        public final NavigableSet<V> i(NavigableSet<V> navigableSet) {
            return new m(this.f9354b, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V lower(@d1 V v10) {
            return g().lower(v10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollFirst() {
            return (V) Iterators.U(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollLast() {
            return (V) Iterators.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(@d1 V v10, boolean z10, @d1 V v11, boolean z11) {
            return i(g().subSet(v10, z10, v11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(@d1 V v10, boolean z10) {
            return i(g().tailSet(v10, z10));
        }
    }

    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        public n(@d1 K k10, Set<V> set) {
            super(k10, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean I = Sets.I((Set) this.f9355c, collection);
            if (I) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f9355c.size() - size);
                f();
            }
            return I;
        }
    }

    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        public o(@d1 K k10, SortedSet<V> sortedSet, @CheckForNull AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        @d1
        public V first() {
            e();
            return g().first();
        }

        public SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(@d1 V v10) {
            e();
            return new o(d(), g().headSet(v10), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        @d1
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(@d1 V v10, @d1 V v11) {
            e();
            return new o(d(), g().subSet(v10, v11), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(@d1 V v10) {
            e();
            return new o(d(), g().tailSet(v10), b() == null ? this : b());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        b5.u.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.totalSize + i10;
        abstractMapBasedMultimap.totalSize = i11;
        return i11;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.totalSize - i10;
        abstractMapBasedMultimap.totalSize = i11;
        return i11;
    }

    private Collection<V> getOrCreateCollection(@d1 K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k10);
        this.map.put(k10, createCollection);
        return createCollection;
    }

    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void removeValuesForKey(@CheckForNull Object obj) {
        Collection collection = (Collection) Maps.q0(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // e5.z0
    public void clear() {
        Iterator<Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // e5.z0
    public boolean containsKey(@CheckForNull Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.a
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(@d1 K k10) {
        return createCollection();
    }

    @Override // com.google.common.collect.a
    public Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof l1 ? new a.b(this) : new a.C0285a();
    }

    @Override // com.google.common.collect.a
    public Set<K> createKeySet() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.a
    public s<K> createKeys() {
        return new Multimaps.c(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new f((NavigableMap) this.map) : map instanceof SortedMap ? new i((SortedMap) this.map) : new c(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new g((NavigableMap) this.map) : map instanceof SortedMap ? new j((SortedMap) this.map) : new e(this.map);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.a
    public Collection<V> createValues() {
        return new a.c();
    }

    @Override // com.google.common.collect.a, e5.z0
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.a
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // e5.z0, e5.x0
    public Collection<V> get(@d1 K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection == null) {
            collection = createCollection(k10);
        }
        return wrapCollection(k10, collection);
    }

    @Override // com.google.common.collect.a, e5.z0
    public boolean put(@d1 K k10, @d1 V v10) {
        Collection<V> collection = this.map.get(k10);
        if (collection != null) {
            if (!collection.add(v10)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> createCollection = createCollection(k10);
        if (!createCollection.add(v10)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k10, createCollection);
        return true;
    }

    @Override // e5.z0, e5.x0
    public Collection<V> removeAll(@CheckForNull Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public Collection<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k10);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k10);
        Collection<V> createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            b5.u.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // e5.z0
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.a
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.a, e5.z0
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(@d1 K k10, Collection<V> collection) {
        return new k(k10, collection, null);
    }

    public final List<V> wrapList(@d1 K k10, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k10, list, kVar) : new l(k10, list, kVar);
    }

    public class k extends AbstractCollection<V> {

        /* renamed from: b */
        @d1
        public final K f9354b;

        /* renamed from: c */
        public Collection<V> f9355c;

        /* renamed from: d */
        @CheckForNull
        public final AbstractMapBasedMultimap<K, V>.k f9356d;

        /* renamed from: e */
        @CheckForNull
        public final Collection<V> f9357e;

        public k(@d1 K k10, Collection<V> collection, @CheckForNull AbstractMapBasedMultimap<K, V>.k kVar) {
            this.f9354b = k10;
            this.f9355c = collection;
            this.f9356d = kVar;
            this.f9357e = kVar == null ? null : kVar.c();
        }

        public void a() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f9356d;
            if (kVar != null) {
                kVar.a();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f9354b, this.f9355c);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@d1 V v10) {
            e();
            boolean isEmpty = this.f9355c.isEmpty();
            boolean add = this.f9355c.add(v10);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f9355c.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f9355c.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        @CheckForNull
        public AbstractMapBasedMultimap<K, V>.k b() {
            return this.f9356d;
        }

        public Collection<V> c() {
            return this.f9355c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f9355c.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            e();
            return this.f9355c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f9355c.containsAll(collection);
        }

        @d1
        public K d() {
            return this.f9354b;
        }

        public void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.k kVar = this.f9356d;
            if (kVar != null) {
                kVar.e();
                if (this.f9356d.c() != this.f9357e) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f9355c.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f9354b)) == null) {
                    return;
                }
                this.f9355c = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f9355c.equals(obj);
        }

        public void f() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f9356d;
            if (kVar != null) {
                kVar.f();
            } else if (this.f9355c.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f9354b);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f9355c.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            e();
            boolean remove = this.f9355c.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f9355c.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f9355c.size() - size);
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            b5.u.E(collection);
            int size = size();
            boolean retainAll = this.f9355c.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f9355c.size() - size);
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f9355c.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f9355c.toString();
        }

        public class a implements Iterator<V> {

            /* renamed from: b */
            public final Iterator<V> f9359b;

            /* renamed from: c */
            public final Collection<V> f9360c;

            public a() {
                Collection<V> collection = k.this.f9355c;
                this.f9360c = collection;
                this.f9359b = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            public Iterator<V> a() {
                b();
                return this.f9359b;
            }

            public void b() {
                k.this.e();
                if (k.this.f9355c != this.f9360c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f9359b.hasNext();
            }

            @Override // java.util.Iterator
            @d1
            public V next() {
                b();
                return this.f9359b.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f9359b.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.f();
            }

            public a(Iterator<V> it) {
                this.f9360c = k.this.f9355c;
                this.f9359b = it;
            }
        }
    }

    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(@d1 V v10) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v10);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            @d1
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(@d1 V v10) {
                c().set(v10);
            }

            public a(int i10) {
                super(l.this.g().listIterator(i10));
            }
        }

        public l(@d1 K k10, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, list, kVar);
        }

        @Override // java.util.List
        public void add(int i10, @d1 V v10) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i10, v10);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i10, collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        @d1
        public V get(int i10) {
            e();
            return g().get(i10);
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        @d1
        public V remove(int i10) {
            e();
            V remove = g().remove(i10);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        @d1
        public V set(int i10, @d1 V v10) {
            e();
            return g().set(i10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            e();
            return AbstractMapBasedMultimap.this.wrapList(d(), g().subList(i10, i11), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            e();
            return new a(i10);
        }
    }
}
