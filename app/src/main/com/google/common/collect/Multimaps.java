package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.common.collect.a;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.Weak;
import e5.a1;
import e5.d1;
import e5.k0;
import e5.l1;
import e5.t1;
import e5.v1;
import e5.x0;
import e5.z0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Multimaps {

    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        @a5.c
        private static final long serialVersionUID = 0;
        transient b5.z<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, b5.z<? extends List<V>> zVar) {
            super(map);
            this.factory = (b5.z) b5.u.E(zVar);
        }

        @a5.c
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (b5.z) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {

        @a5.c
        private static final long serialVersionUID = 0;
        transient b5.z<? extends Collection<V>> factory;

        public CustomMultimap(Map<K, Collection<V>> map, b5.z<? extends Collection<V>> zVar) {
            super(map);
            this.factory = (b5.z) b5.u.E(zVar);
        }

        @a5.c
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (b5.z) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            return collection instanceof NavigableSet ? Sets.O((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@d1 K k10, Collection<V> collection) {
            return collection instanceof List ? wrapList(k10, (List) collection, null) : collection instanceof NavigableSet ? new AbstractMapBasedMultimap.m(k10, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.o(k10, (SortedSet) collection, null) : collection instanceof Set ? new AbstractMapBasedMultimap.n(k10, (Set) collection) : new AbstractMapBasedMultimap.k(k10, collection, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {

        @a5.c
        private static final long serialVersionUID = 0;
        transient b5.z<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> map, b5.z<? extends Set<V>> zVar) {
            super(map);
            this.factory = (b5.z) b5.u.E(zVar);
        }

        @a5.c
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (b5.z) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            return collection instanceof NavigableSet ? Sets.O((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@d1 K k10, Collection<V> collection) {
            return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.m(k10, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.o(k10, (SortedSet) collection, null) : new AbstractMapBasedMultimap.n(k10, (Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class MapMultimap<K, V> extends com.google.common.collect.a<K, V> implements l1<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        public class a extends Sets.j<V> {

            /* renamed from: b */
            public final /* synthetic */ Object f9703b;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a */
            public class C0272a implements Iterator<V> {

                /* renamed from: b */
                public int f9705b;

                public C0272a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f9705b == 0) {
                        a aVar = a.this;
                        if (MapMultimap.this.map.containsKey(aVar.f9703b)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                @d1
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f9705b++;
                    a aVar = a.this;
                    return (V) a1.a(MapMultimap.this.map.get(aVar.f9703b));
                }

                @Override // java.util.Iterator
                public void remove() {
                    e5.i.e(this.f9705b == 1);
                    this.f9705b = -1;
                    a aVar = a.this;
                    MapMultimap.this.map.remove(aVar.f9703b);
                }
            }

            public a(Object obj) {
                this.f9703b = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new C0272a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapMultimap.this.map.containsKey(this.f9703b) ? 1 : 0;
            }
        }

        public MapMultimap(Map<K, V> map) {
            this.map = (Map) b5.u.E(map);
        }

        @Override // e5.z0
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.map.entrySet().contains(Maps.O(obj, obj2));
        }

        @Override // e5.z0
        public boolean containsKey(@CheckForNull Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean containsValue(@CheckForNull Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // com.google.common.collect.a
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.a
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.a
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.a
        public s<K> createKeys() {
            return new c(this);
        }

        @Override // com.google.common.collect.a
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.a
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
            return get((MapMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.a, e5.z0
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean put(@d1 K k10, @d1 V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean putAll(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.map.entrySet().remove(Maps.O(obj, obj2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.a, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((MapMultimap<K, V>) obj, iterable);
        }

        @Override // e5.z0
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.a, e5.z0
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // e5.z0, e5.x0
        public Set<V> get(@d1 K k10) {
            return new a(k10);
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean putAll(z0<? extends K, ? extends V> z0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.z0, e5.x0
        public Set<V> removeAll(@CheckForNull Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.a, e5.z0, e5.x0
        public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements x0<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(x0<K, V> x0Var) {
            super(x0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
            return get((UnmodifiableListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public List<V> get(@d1 K k10) {
            return Collections.unmodifiableList(delegate().get((x0<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public List<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public List<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.l0
        public x0<K, V> delegate() {
            return (x0) super.delegate();
        }
    }

    public static class UnmodifiableMultimap<K, V> extends k0<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final z0<K, V> delegate;

        @CheckForNull
        @LazyInit
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        @LazyInit
        transient Set<K> keySet;

        @CheckForNull
        @LazyInit
        transient s<K> keys;

        @CheckForNull
        @LazyInit
        transient Map<K, Collection<V>> map;

        @CheckForNull
        @LazyInit
        transient Collection<V> values;

        public class a implements b5.n<Collection<V>, Collection<V>> {
            public a(UnmodifiableMultimap unmodifiableMultimap) {
            }

            @Override // b5.n
            /* renamed from: a */
            public Collection<V> apply(Collection<V> collection) {
                return Multimaps.O(collection);
            }
        }

        public UnmodifiableMultimap(z0<K, V> z0Var) {
            this.delegate = (z0) b5.u.E(z0Var);
        }

        @Override // e5.k0, e5.z0, e5.x0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.map;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.B0(this.delegate.asMap(), new a(this)));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }

        @Override // e5.k0, e5.z0
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> G = Multimaps.G(this.delegate.entries());
            this.entries = G;
            return G;
        }

        @Override // e5.k0, e5.z0, e5.x0
        public Collection<V> get(@d1 K k10) {
            return Multimaps.O(this.delegate.get(k10));
        }

        @Override // e5.k0, e5.z0
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // e5.k0, e5.z0
        public s<K> keys() {
            s<K> sVar = this.keys;
            if (sVar != null) {
                return sVar;
            }
            s<K> A = Multisets.A(this.delegate.keys());
            this.keys = A;
            return A;
        }

        @Override // e5.k0, e5.z0
        public boolean put(@d1 K k10, @d1 V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0
        public boolean putAll(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0, e5.x0
        public Collection<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0, e5.x0
        public Collection<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.k0, e5.z0
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }

        @Override // e5.k0, e5.l0
        public z0<K, V> delegate() {
            return this.delegate;
        }

        @Override // e5.k0, e5.z0
        public boolean putAll(z0<? extends K, ? extends V> z0Var) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements l1<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(l1<K, V> l1Var) {
            super(l1Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
            return get((UnmodifiableSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0
        public Set<Map.Entry<K, V>> entries() {
            return Maps.J0(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public Set<V> get(@d1 K k10) {
            return Collections.unmodifiableSet(delegate().get((l1<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public Set<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.l0
        public l1<K, V> delegate() {
            return (l1) super.delegate();
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements t1<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(t1<K, V> t1Var) {
            super(t1Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // e5.t1
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Set get(@d1 Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Set replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public SortedSet<V> get(@d1 K k10) {
            return Collections.unmodifiableSortedSet(delegate().get((t1<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public SortedSet<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.z0, e5.x0
        public SortedSet<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, e5.k0, e5.l0
        public t1<K, V> delegate() {
            return (t1) super.delegate();
        }
    }

    public static final class a<K, V> extends Maps.n0<K, Collection<V>> {

        /* renamed from: e */
        @Weak
        public final z0<K, V> f9707e;

        /* renamed from: com.google.common.collect.Multimaps$a$a */
        public class C0273a extends Maps.q<K, Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$a$a$a */
            public class C0274a implements b5.n<K, Collection<V>> {
                public C0274a() {
                }

                @Override // b5.n
                /* renamed from: a */
                public Collection<V> apply(@d1 K k10) {
                    return a.this.f9707e.get(k10);
                }
            }

            public C0273a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.m(a.this.f9707e.keySet(), new C0274a());
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.i(entry.getKey());
                return true;
            }
        }

        public a(z0<K, V> z0Var) {
            this.f9707e = (z0) b5.u.E(z0Var);
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0273a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f9707e.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9707e.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Collection<V> get(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f9707e.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: h */
        public Collection<V> remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f9707e.removeAll(obj);
            }
            return null;
        }

        public void i(@CheckForNull Object obj) {
            this.f9707e.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f9707e.isEmpty();
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f9707e.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9707e.keySet().size();
        }
    }

    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract z0<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static class c<K, V> extends com.google.common.collect.b<K> {

        /* renamed from: b */
        @Weak
        public final z0<K, V> f9710b;

        public class a extends v1<Map.Entry<K, Collection<V>>, s.a<K>> {

            /* renamed from: com.google.common.collect.Multimaps$c$a$a */
            public class C0275a extends Multisets.f<K> {

                /* renamed from: b */
                public final /* synthetic */ Map.Entry f9711b;

                public C0275a(a aVar, Map.Entry entry) {
                    this.f9711b = entry;
                }

                @Override // com.google.common.collect.s.a
                public int getCount() {
                    return ((Collection) this.f9711b.getValue()).size();
                }

                @Override // com.google.common.collect.s.a
                @d1
                public K getElement() {
                    return (K) this.f9711b.getKey();
                }
            }

            public a(c cVar, Iterator it) {
                super(it);
            }

            @Override // e5.v1
            /* renamed from: b */
            public s.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0275a(this, entry);
            }
        }

        public c(z0<K, V> z0Var) {
            this.f9710b = z0Var;
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f9710b.clear();
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public boolean contains(@CheckForNull Object obj) {
            return this.f9710b.containsKey(obj);
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            Collection collection = (Collection) Maps.p0(this.f9710b.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.b
        public int distinctElements() {
            return this.f9710b.asMap().size();
        }

        @Override // com.google.common.collect.b
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b, com.google.common.collect.s
        public Set<K> elementSet() {
            return this.f9710b.keySet();
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<K>> entryIterator() {
            return new a(this, this.f9710b.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
        public Iterator<K> iterator() {
            return Maps.S(this.f9710b.entries().iterator());
        }

        @Override // com.google.common.collect.b, com.google.common.collect.s
        public int remove(@CheckForNull Object obj, int i10) {
            e5.i.b(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.p0(this.f9710b.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i10 >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i11 = 0; i11 < i10; i11++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public int size() {
            return this.f9710b.size();
        }
    }

    public static final class d<K, V1, V2> extends e<K, V1, V2> implements x0<K, V2> {
        public d(x0<K, V1> x0Var, Maps.r<? super K, ? super V1, V2> rVar) {
            super(x0Var, rVar);
        }

        @Override // com.google.common.collect.Multimaps.e
        /* renamed from: d */
        public List<V2> b(@d1 K k10, Collection<V1> collection) {
            return Lists.D((List) collection, Maps.n(this.f9713c, k10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.e, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
            return get((d<K, V1, V2>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.e, com.google.common.collect.a, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
            return replaceValues((d<K, V1, V2>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.e, e5.z0, e5.x0
        public List<V2> get(@d1 K k10) {
            return b(k10, this.f9712b.get(k10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.e, e5.z0, e5.x0
        public List<V2> removeAll(@CheckForNull Object obj) {
            return b(obj, this.f9712b.removeAll(obj));
        }

        @Override // com.google.common.collect.Multimaps.e, com.google.common.collect.a, e5.z0, e5.x0
        public List<V2> replaceValues(@d1 K k10, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class e<K, V1, V2> extends com.google.common.collect.a<K, V2> {

        /* renamed from: b */
        public final z0<K, V1> f9712b;

        /* renamed from: c */
        public final Maps.r<? super K, ? super V1, V2> f9713c;

        public class a implements Maps.r<K, Collection<V1>, Collection<V2>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.r
            /* renamed from: b */
            public Collection<V2> a(@d1 K k10, Collection<V1> collection) {
                return e.this.b(k10, collection);
            }
        }

        public e(z0<K, V1> z0Var, Maps.r<? super K, ? super V1, V2> rVar) {
            this.f9712b = (z0) b5.u.E(z0Var);
            this.f9713c = (Maps.r) b5.u.E(rVar);
        }

        public Collection<V2> b(@d1 K k10, Collection<V1> collection) {
            b5.n n10 = Maps.n(this.f9713c, k10);
            return collection instanceof List ? Lists.D((List) collection, n10) : f.m(collection, n10);
        }

        @Override // e5.z0
        public void clear() {
            this.f9712b.clear();
        }

        @Override // e5.z0
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9712b.containsKey(obj);
        }

        @Override // com.google.common.collect.a
        public Map<K, Collection<V2>> createAsMap() {
            return Maps.x0(this.f9712b.asMap(), new a());
        }

        @Override // com.google.common.collect.a
        public Collection<Map.Entry<K, V2>> createEntries() {
            return new a.C0285a();
        }

        @Override // com.google.common.collect.a
        public Set<K> createKeySet() {
            return this.f9712b.keySet();
        }

        @Override // com.google.common.collect.a
        public s<K> createKeys() {
            return this.f9712b.keys();
        }

        @Override // com.google.common.collect.a
        public Collection<V2> createValues() {
            return f.m(this.f9712b.entries(), Maps.h(this.f9713c));
        }

        @Override // com.google.common.collect.a
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.c0(this.f9712b.entries().iterator(), Maps.g(this.f9713c));
        }

        @Override // e5.z0, e5.x0
        public Collection<V2> get(@d1 K k10) {
            return b(k10, this.f9712b.get(k10));
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean isEmpty() {
            return this.f9712b.isEmpty();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean put(@d1 K k10, @d1 V2 v22) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean putAll(@d1 K k10, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.a, e5.z0
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return get(obj).remove(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e5.z0, e5.x0
        public Collection<V2> removeAll(@CheckForNull Object obj) {
            return b(obj, this.f9712b.removeAll(obj));
        }

        @Override // com.google.common.collect.a, e5.z0, e5.x0
        public Collection<V2> replaceValues(@d1 K k10, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.z0
        public int size() {
            return this.f9712b.size();
        }

        @Override // com.google.common.collect.a, e5.z0
        public boolean putAll(z0<? extends K, ? extends V2> z0Var) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> l1<K, V> A(l1<K, V> l1Var) {
        return Synchronized.v(l1Var, null);
    }

    public static <K, V> t1<K, V> B(t1<K, V> t1Var) {
        return Synchronized.y(t1Var, null);
    }

    public static <K, V1, V2> x0<K, V2> C(x0<K, V1> x0Var, Maps.r<? super K, ? super V1, V2> rVar) {
        return new d(x0Var, rVar);
    }

    public static <K, V1, V2> z0<K, V2> D(z0<K, V1> z0Var, Maps.r<? super K, ? super V1, V2> rVar) {
        return new e(z0Var, rVar);
    }

    public static <K, V1, V2> x0<K, V2> E(x0<K, V1> x0Var, b5.n<? super V1, V2> nVar) {
        b5.u.E(nVar);
        return C(x0Var, Maps.i(nVar));
    }

    public static <K, V1, V2> z0<K, V2> F(z0<K, V1> z0Var, b5.n<? super V1, V2> nVar) {
        b5.u.E(nVar);
        return D(z0Var, Maps.i(nVar));
    }

    public static <K, V> Collection<Map.Entry<K, V>> G(Collection<Map.Entry<K, V>> collection) {
        return collection instanceof Set ? Maps.J0((Set) collection) : new Maps.j0(Collections.unmodifiableCollection(collection));
    }

    @Deprecated
    public static <K, V> x0<K, V> H(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (x0) b5.u.E(immutableListMultimap);
    }

    public static <K, V> x0<K, V> I(x0<K, V> x0Var) {
        return ((x0Var instanceof UnmodifiableListMultimap) || (x0Var instanceof ImmutableListMultimap)) ? x0Var : new UnmodifiableListMultimap(x0Var);
    }

    @Deprecated
    public static <K, V> z0<K, V> J(ImmutableMultimap<K, V> immutableMultimap) {
        return (z0) b5.u.E(immutableMultimap);
    }

    public static <K, V> z0<K, V> K(z0<K, V> z0Var) {
        return ((z0Var instanceof UnmodifiableMultimap) || (z0Var instanceof ImmutableMultimap)) ? z0Var : new UnmodifiableMultimap(z0Var);
    }

    @Deprecated
    public static <K, V> l1<K, V> L(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (l1) b5.u.E(immutableSetMultimap);
    }

    public static <K, V> l1<K, V> M(l1<K, V> l1Var) {
        return ((l1Var instanceof UnmodifiableSetMultimap) || (l1Var instanceof ImmutableSetMultimap)) ? l1Var : new UnmodifiableSetMultimap(l1Var);
    }

    public static <K, V> t1<K, V> N(t1<K, V> t1Var) {
        return t1Var instanceof UnmodifiableSortedSetMultimap ? t1Var : new UnmodifiableSortedSetMultimap(t1Var);
    }

    public static <V> Collection<V> O(Collection<V> collection) {
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    @a5.a
    public static <K, V> Map<K, List<V>> c(x0<K, V> x0Var) {
        return x0Var.asMap();
    }

    @a5.a
    public static <K, V> Map<K, Collection<V>> d(z0<K, V> z0Var) {
        return z0Var.asMap();
    }

    @a5.a
    public static <K, V> Map<K, Set<V>> e(l1<K, V> l1Var) {
        return l1Var.asMap();
    }

    @a5.a
    public static <K, V> Map<K, SortedSet<V>> f(t1<K, V> t1Var) {
        return t1Var.asMap();
    }

    public static boolean g(z0<?, ?> z0Var, @CheckForNull Object obj) {
        if (obj == z0Var) {
            return true;
        }
        if (obj instanceof z0) {
            return z0Var.asMap().equals(((z0) obj).asMap());
        }
        return false;
    }

    public static <K, V> z0<K, V> h(z0<K, V> z0Var, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(vVar);
        return z0Var instanceof l1 ? i((l1) z0Var, vVar) : z0Var instanceof e5.s ? j((e5.s) z0Var, vVar) : new i((z0) b5.u.E(z0Var), vVar);
    }

    public static <K, V> l1<K, V> i(l1<K, V> l1Var, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(vVar);
        return l1Var instanceof e5.v ? k((e5.v) l1Var, vVar) : new e5.o((l1) b5.u.E(l1Var), vVar);
    }

    public static <K, V> z0<K, V> j(e5.s<K, V> sVar, b5.v<? super Map.Entry<K, V>> vVar) {
        return new i(sVar.a(), Predicates.d(sVar.c(), vVar));
    }

    public static <K, V> l1<K, V> k(e5.v<K, V> vVar, b5.v<? super Map.Entry<K, V>> vVar2) {
        return new e5.o(vVar.a(), Predicates.d(vVar.c(), vVar2));
    }

    public static <K, V> x0<K, V> l(x0<K, V> x0Var, b5.v<? super K> vVar) {
        if (!(x0Var instanceof e5.p)) {
            return new e5.p(x0Var, vVar);
        }
        e5.p pVar = (e5.p) x0Var;
        return new e5.p(pVar.a(), Predicates.d(pVar.f25629c, vVar));
    }

    public static <K, V> z0<K, V> m(z0<K, V> z0Var, b5.v<? super K> vVar) {
        if (z0Var instanceof l1) {
            return n((l1) z0Var, vVar);
        }
        if (z0Var instanceof x0) {
            return l((x0) z0Var, vVar);
        }
        if (!(z0Var instanceof e5.q)) {
            return z0Var instanceof e5.s ? j((e5.s) z0Var, Maps.U(vVar)) : new e5.q(z0Var, vVar);
        }
        e5.q qVar = (e5.q) z0Var;
        return new e5.q(qVar.f25628b, Predicates.d(qVar.f25629c, vVar));
    }

    public static <K, V> l1<K, V> n(l1<K, V> l1Var, b5.v<? super K> vVar) {
        if (!(l1Var instanceof e5.r)) {
            return l1Var instanceof e5.v ? k((e5.v) l1Var, Maps.U(vVar)) : new e5.r(l1Var, vVar);
        }
        e5.r rVar = (e5.r) l1Var;
        return new e5.r(rVar.a(), Predicates.d(rVar.f25629c, vVar));
    }

    public static <K, V> z0<K, V> o(z0<K, V> z0Var, b5.v<? super V> vVar) {
        return h(z0Var, Maps.Q0(vVar));
    }

    public static <K, V> l1<K, V> p(l1<K, V> l1Var, b5.v<? super V> vVar) {
        return i(l1Var, Maps.Q0(vVar));
    }

    public static <K, V> l1<K, V> q(Map<K, V> map) {
        return new MapMultimap(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> r(Iterable<V> iterable, b5.n<? super V, K> nVar) {
        return s(iterable.iterator(), nVar);
    }

    public static <K, V> ImmutableListMultimap<K, V> s(Iterator<V> it, b5.n<? super V, K> nVar) {
        b5.u.E(nVar);
        ImmutableListMultimap.a builder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            b5.u.F(next, it);
            builder.f(nVar.apply(next), next);
        }
        return builder.a();
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends z0<K, V>> M t(z0<? extends V, ? extends K> z0Var, M m10) {
        b5.u.E(m10);
        for (Map.Entry<? extends V, ? extends K> entry : z0Var.entries()) {
            m10.put(entry.getValue(), entry.getKey());
        }
        return m10;
    }

    public static <K, V> x0<K, V> u(Map<K, Collection<V>> map, b5.z<? extends List<V>> zVar) {
        return new CustomListMultimap(map, zVar);
    }

    public static <K, V> z0<K, V> v(Map<K, Collection<V>> map, b5.z<? extends Collection<V>> zVar) {
        return new CustomMultimap(map, zVar);
    }

    public static <K, V> l1<K, V> w(Map<K, Collection<V>> map, b5.z<? extends Set<V>> zVar) {
        return new CustomSetMultimap(map, zVar);
    }

    public static <K, V> t1<K, V> x(Map<K, Collection<V>> map, b5.z<? extends SortedSet<V>> zVar) {
        return new CustomSortedSetMultimap(map, zVar);
    }

    public static <K, V> x0<K, V> y(x0<K, V> x0Var) {
        return Synchronized.k(x0Var, null);
    }

    public static <K, V> z0<K, V> z(z0<K, V> z0Var) {
        return Synchronized.m(z0Var, null);
    }

    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {

        @a5.c
        private static final long serialVersionUID = 0;
        transient b5.z<? extends SortedSet<V>> factory;

        @CheckForNull
        transient Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(Map<K, Collection<V>> map, b5.z<? extends SortedSet<V>> zVar) {
            super(map);
            this.factory = (b5.z) b5.u.E(zVar);
            this.valueComparator = zVar.get().comparator();
        }

        @a5.c
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            b5.z<? extends SortedSet<V>> zVar = (b5.z) objectInputStream.readObject();
            this.factory = zVar;
            this.valueComparator = zVar.get().comparator();
            setMap((Map) objectInputStream.readObject());
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // e5.t1
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }
}
