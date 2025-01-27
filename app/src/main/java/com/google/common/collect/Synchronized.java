package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.common.collect.s;
import com.google.j2objc.annotations.RetainedWith;
import e5.b1;
import e5.j0;
import e5.l1;
import e5.t1;
import e5.v1;
import e5.x0;
import e5.z0;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Synchronized {

    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;

        @CheckForNull
        transient Collection<Collection<V>> asMapValues;

        public SynchronizedAsMap(Map<K, Collection<V>> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(@CheckForNull Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                try {
                    if (this.asMapEntrySet == null) {
                        this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                    }
                    set = this.asMapEntrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.asMapValues == null) {
                        this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                    }
                    collection = this.asMapValues;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> A;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                A = collection == null ? null : Synchronized.A(collection, this.mutex);
            }
            return A;
        }
    }

    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        public class a extends v1<Collection<V>, Collection<V>> {
            public a(Iterator it) {
                super(it);
            }

            @Override // e5.v1
            /* renamed from: b */
            public Collection<V> a(Collection<V> collection) {
                return Synchronized.A(collection, SynchronizedAsMapValues.this.mutex);
            }
        }

        public SynchronizedAsMapValues(Collection<Collection<V>> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new a(super.iterator());
        }
    }

    @a5.d
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements e5.g<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @RetainedWith
        @CheckForNull
        private transient e5.g<V, K> inverse;

        @CheckForNull
        private transient Set<V> valueSet;

        public /* synthetic */ SynchronizedBiMap(e5.g gVar, Object obj, e5.g gVar2, a aVar) {
            this(gVar, obj, gVar2);
        }

        @Override // e5.g
        @CheckForNull
        public V forcePut(K k10, V v10) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k10, v10);
            }
            return forcePut;
        }

        @Override // e5.g
        public e5.g<V, K> inverse() {
            e5.g<V, K> gVar;
            synchronized (this.mutex) {
                try {
                    if (this.inverse == null) {
                        this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                    }
                    gVar = this.inverse;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return gVar;
        }

        private SynchronizedBiMap(e5.g<K, V> gVar, @CheckForNull Object obj, @CheckForNull e5.g<V, K> gVar2) {
            super(gVar, obj);
            this.inverse = gVar2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                try {
                    if (this.valueSet == null) {
                        this.valueSet = Synchronized.u(delegate().values(), this.mutex);
                    }
                    set = this.valueSet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public e5.g<K, V> delegate() {
            return (e5.g) super.delegate();
        }
    }

    @a5.d
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ SynchronizedCollection(Collection collection, Object obj, a aVar) {
            this(collection, obj);
        }

        @Override // java.util.Collection
        public boolean add(E e10) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e10);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(@CheckForNull Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(@CheckForNull Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection<E> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    @a5.c
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedEntry(Map.Entry<K, V> entry, @CheckForNull Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v10);
            }
            return value;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i10, E e10) {
            synchronized (this.mutex) {
                delegate().add(i10, e10);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i10, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i10) {
            E e10;
            synchronized (this.mutex) {
                e10 = delegate().get(i10);
            }
            return e10;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int i10) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i10);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i10, E e10) {
            E e11;
            synchronized (this.mutex) {
                e11 = delegate().set(i10, e10);
            }
            return e11;
        }

        @Override // java.util.List
        public List<E> subList(int i10, int i11) {
            List<E> j10;
            synchronized (this.mutex) {
                j10 = Synchronized.j(delegate().subList(i10, i11), this.mutex);
            }
            return j10;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i10) {
            return delegate().listIterator(i10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements x0<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedListMultimap(x0<K, V> x0Var, @CheckForNull Object obj) {
            super(x0Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public List<V> get(K k10) {
            List<V> j10;
            synchronized (this.mutex) {
                j10 = Synchronized.j(delegate().get((x0<K, V>) k10), this.mutex);
            }
            return j10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public List<V> removeAll(@CheckForNull Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((x0<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public x0<K, V> delegate() {
            return (x0) super.delegate();
        }
    }

    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, V>> entrySet;

        @CheckForNull
        transient Set<K> keySet;

        @CheckForNull
        transient Collection<V> values;

        public SynchronizedMap(Map<K, V> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.u(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v10;
            synchronized (this.mutex) {
                v10 = delegate().get(obj);
            }
            return v10;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.u(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Map
        @CheckForNull
        public V put(K k10, V v10) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k10, v10);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.values == null) {
                        this.values = Synchronized.h(delegate().values(), this.mutex);
                    }
                    collection = this.values;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements z0<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Map<K, Collection<V>> asMap;

        @CheckForNull
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        transient Set<K> keySet;

        @CheckForNull
        transient s<K> keys;

        @CheckForNull
        transient Collection<V> valuesCollection;

        public SynchronizedMultimap(z0<K, V> z0Var, @CheckForNull Object obj) {
            super(z0Var, obj);
        }

        @Override // e5.z0, e5.x0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                try {
                    if (this.asMap == null) {
                        this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                    }
                    map = this.asMap;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return map;
        }

        @Override // e5.z0
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // e5.z0
        public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // e5.z0
        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // e5.z0
        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // e5.z0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.entries == null) {
                        this.entries = Synchronized.A(delegate().entries(), this.mutex);
                    }
                    collection = this.entries;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // e5.z0, e5.x0
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public Collection<V> get(K k10) {
            Collection<V> A;
            synchronized (this.mutex) {
                A = Synchronized.A(delegate().get(k10), this.mutex);
            }
            return A;
        }

        @Override // e5.z0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // e5.z0
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // e5.z0
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.B(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // e5.z0
        public s<K> keys() {
            s<K> sVar;
            synchronized (this.mutex) {
                try {
                    if (this.keys == null) {
                        this.keys = Synchronized.n(delegate().keys(), this.mutex);
                    }
                    sVar = this.keys;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return sVar;
        }

        @Override // e5.z0
        public boolean put(K k10, V v10) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k10, v10);
            }
            return put;
        }

        @Override // e5.z0
        public boolean putAll(K k10, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k10, iterable);
            }
            return putAll;
        }

        @Override // e5.z0
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(@CheckForNull Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k10, iterable);
            }
            return replaceValues;
        }

        @Override // e5.z0
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // e5.z0
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.valuesCollection == null) {
                        this.valuesCollection = Synchronized.h(delegate().values(), this.mutex);
                    }
                    collection = this.valuesCollection;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public z0<K, V> delegate() {
            return (z0) super.delegate();
        }

        @Override // e5.z0
        public boolean putAll(z0<? extends K, ? extends V> z0Var) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(z0Var);
            }
            return putAll;
        }
    }

    public static class SynchronizedObject implements Serializable {

        @a5.c
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        public SynchronizedObject(Object obj, @CheckForNull Object obj2) {
            this.delegate = b5.u.E(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }
    }

    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements l1<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, V>> entrySet;

        public SynchronizedSetMultimap(l1<K, V> l1Var, @CheckForNull Object obj) {
            super(l1Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.u(delegate().entries(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public Set<V> get(K k10) {
            Set<V> u10;
            synchronized (this.mutex) {
                u10 = Synchronized.u(delegate().get((l1<K, V>) k10), this.mutex);
            }
            return u10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public Set<V> removeAll(@CheckForNull Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((l1<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public l1<K, V> delegate() {
            return (l1) super.delegate();
        }
    }

    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements t1<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSetMultimap(t1<K, V> t1Var, @CheckForNull Object obj) {
            super(t1Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // e5.t1
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public SortedSet<V> get(K k10) {
            SortedSet<V> x10;
            synchronized (this.mutex) {
                x10 = Synchronized.x(delegate().get((t1<K, V>) k10), this.mutex);
            }
            return x10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public SortedSet<V> removeAll(@CheckForNull Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, e5.z0, e5.x0
        public SortedSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((t1<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public t1<K, V> delegate() {
            return (t1) super.delegate();
        }
    }

    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements a0<R, C, V> {

        public class a implements b5.n<Map<C, V>, Map<C, V>> {
            public a() {
            }

            @Override // b5.n
            /* renamed from: a */
            public Map<C, V> apply(Map<C, V> map) {
                return Synchronized.l(map, SynchronizedTable.this.mutex);
            }
        }

        public class b implements b5.n<Map<R, V>, Map<R, V>> {
            public b() {
            }

            @Override // b5.n
            /* renamed from: a */
            public Map<R, V> apply(Map<R, V> map) {
                return Synchronized.l(map, SynchronizedTable.this.mutex);
            }
        }

        public SynchronizedTable(a0<R, C, V> a0Var, @CheckForNull Object obj) {
            super(a0Var, obj);
        }

        @Override // com.google.common.collect.a0
        public Set<a0.a<R, C, V>> cellSet() {
            Set<a0.a<R, C, V>> u10;
            synchronized (this.mutex) {
                u10 = Synchronized.u(delegate().cellSet(), this.mutex);
            }
            return u10;
        }

        @Override // com.google.common.collect.a0
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.a0
        public Map<R, V> column(C c10) {
            Map<R, V> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(delegate().column(c10), this.mutex);
            }
            return l10;
        }

        @Override // com.google.common.collect.a0
        public Set<C> columnKeySet() {
            Set<C> u10;
            synchronized (this.mutex) {
                u10 = Synchronized.u(delegate().columnKeySet(), this.mutex);
            }
            return u10;
        }

        @Override // com.google.common.collect.a0
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(Maps.B0(delegate().columnMap(), new b()), this.mutex);
            }
            return l10;
        }

        @Override // com.google.common.collect.a0
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.a0
        public boolean containsColumn(@CheckForNull Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.a0
        public boolean containsRow(@CheckForNull Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.a0
        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.a0
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.a0
        @CheckForNull
        public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V v10;
            synchronized (this.mutex) {
                v10 = delegate().get(obj, obj2);
            }
            return v10;
        }

        @Override // com.google.common.collect.a0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.a0
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.a0
        @CheckForNull
        public V put(R r10, C c10, V v10) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r10, c10, v10);
            }
            return put;
        }

        @Override // com.google.common.collect.a0
        public void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
            synchronized (this.mutex) {
                delegate().putAll(a0Var);
            }
        }

        @Override // com.google.common.collect.a0
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.a0
        public Map<C, V> row(R r10) {
            Map<C, V> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(delegate().row(r10), this.mutex);
            }
            return l10;
        }

        @Override // com.google.common.collect.a0
        public Set<R> rowKeySet() {
            Set<R> u10;
            synchronized (this.mutex) {
                u10 = Synchronized.u(delegate().rowKeySet(), this.mutex);
            }
            return u10;
        }

        @Override // com.google.common.collect.a0
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(Maps.B0(delegate().rowMap(), new a()), this.mutex);
            }
            return l10;
        }

        @Override // com.google.common.collect.a0
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.a0
        public Collection<V> values() {
            Collection<V> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(delegate().values(), this.mutex);
            }
            return h10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public a0<R, C, V> delegate() {
            return (a0) super.delegate();
        }
    }

    public static <E> Collection<E> A(Collection<E> collection, @CheckForNull Object obj) {
        return collection instanceof SortedSet ? x((SortedSet) collection, obj) : collection instanceof Set ? u((Set) collection, obj) : collection instanceof List ? j((List) collection, obj) : h(collection, obj);
    }

    public static <E> Set<E> B(Set<E> set, @CheckForNull Object obj) {
        return set instanceof SortedSet ? x((SortedSet) set, obj) : u(set, obj);
    }

    public static <K, V> e5.g<K, V> g(e5.g<K, V> gVar, @CheckForNull Object obj) {
        return ((gVar instanceof SynchronizedBiMap) || (gVar instanceof ImmutableBiMap)) ? gVar : new SynchronizedBiMap(gVar, obj, null);
    }

    public static <E> Collection<E> h(Collection<E> collection, @CheckForNull Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    public static <E> Deque<E> i(Deque<E> deque, @CheckForNull Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    public static <E> List<E> j(List<E> list, @CheckForNull Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    public static <K, V> x0<K, V> k(x0<K, V> x0Var, @CheckForNull Object obj) {
        return ((x0Var instanceof SynchronizedListMultimap) || (x0Var instanceof e5.e)) ? x0Var : new SynchronizedListMultimap(x0Var, obj);
    }

    @a5.d
    public static <K, V> Map<K, V> l(Map<K, V> map, @CheckForNull Object obj) {
        return new SynchronizedMap(map, obj);
    }

    public static <K, V> z0<K, V> m(z0<K, V> z0Var, @CheckForNull Object obj) {
        return ((z0Var instanceof SynchronizedMultimap) || (z0Var instanceof e5.e)) ? z0Var : new SynchronizedMultimap(z0Var, obj);
    }

    public static <E> s<E> n(s<E> sVar, @CheckForNull Object obj) {
        return ((sVar instanceof SynchronizedMultiset) || (sVar instanceof ImmutableMultiset)) ? sVar : new SynchronizedMultiset(sVar, obj);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> o(NavigableMap<K, V> navigableMap) {
        return p(navigableMap, null);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> p(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    @a5.c
    public static <E> NavigableSet<E> q(NavigableSet<E> navigableSet) {
        return r(navigableSet, null);
    }

    @a5.c
    public static <E> NavigableSet<E> r(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    @CheckForNull
    @a5.c
    public static <K, V> Map.Entry<K, V> s(@CheckForNull Map.Entry<K, V> entry, @CheckForNull Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    public static <E> Queue<E> t(Queue<E> queue, @CheckForNull Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    @a5.d
    public static <E> Set<E> u(Set<E> set, @CheckForNull Object obj) {
        return new SynchronizedSet(set, obj);
    }

    public static <K, V> l1<K, V> v(l1<K, V> l1Var, @CheckForNull Object obj) {
        return ((l1Var instanceof SynchronizedSetMultimap) || (l1Var instanceof e5.e)) ? l1Var : new SynchronizedSetMultimap(l1Var, obj);
    }

    public static <K, V> SortedMap<K, V> w(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    public static <E> SortedSet<E> x(SortedSet<E> sortedSet, @CheckForNull Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    public static <K, V> t1<K, V> y(t1<K, V> t1Var, @CheckForNull Object obj) {
        return t1Var instanceof SynchronizedSortedSetMultimap ? t1Var : new SynchronizedSortedSetMultimap(t1Var, obj);
    }

    public static <R, C, V> a0<R, C, V> z(a0<R, C, V> a0Var, @CheckForNull Object obj) {
        return new SynchronizedTable(a0Var, obj);
    }

    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements s<E> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<E> elementSet;

        @CheckForNull
        transient Set<s.a<E>> entrySet;

        public SynchronizedMultiset(s<E> sVar, @CheckForNull Object obj) {
            super(sVar, obj);
        }

        @Override // com.google.common.collect.s
        public int add(E e10, int i10) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e10, i10);
            }
            return add;
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.s
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                try {
                    if (this.elementSet == null) {
                        this.elementSet = Synchronized.B(delegate().elementSet(), this.mutex);
                    }
                    set = this.elementSet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.s
        public Set<s.a<E>> entrySet() {
            Set<s.a<E>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.B(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.s
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, com.google.common.collect.s
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.s
        public int remove(@CheckForNull Object obj, int i10) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i10);
            }
            return remove;
        }

        @Override // com.google.common.collect.s
        public int setCount(E e10, int i10) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e10, i10);
            }
            return count;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public s<E> delegate() {
            return (s) super.delegate();
        }

        @Override // com.google.common.collect.s
        public boolean setCount(E e10, int i10, int i11) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e10, i10, i11);
            }
            return count;
        }
    }

    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedQueue(Queue<E> queue, @CheckForNull Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e10) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e10);
            }
            return offer;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSet(Set<E> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedMap(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k10) {
            SortedMap<K, V> w10;
            synchronized (this.mutex) {
                w10 = Synchronized.w(delegate().headMap(k10), this.mutex);
            }
            return w10;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k10, K k11) {
            SortedMap<K, V> w10;
            synchronized (this.mutex) {
                w10 = Synchronized.w(delegate().subMap(k10, k11), this.mutex);
            }
            return w10;
        }

        public SortedMap<K, V> tailMap(K k10) {
            SortedMap<K, V> w10;
            synchronized (this.mutex) {
                w10 = Synchronized.w(delegate().tailMap(k10), this.mutex);
            }
            return w10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedDeque(Deque<E> deque, @CheckForNull Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e10) {
            synchronized (this.mutex) {
                delegate().addFirst(e10);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e10) {
            synchronized (this.mutex) {
                delegate().addLast(e10);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e10) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e10);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e10) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e10);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e10) {
            synchronized (this.mutex) {
                delegate().push(e10);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(@CheckForNull Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(@CheckForNull Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    @a5.d
    @a5.c
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient NavigableSet<K> descendingKeySet;

        @CheckForNull
        transient NavigableMap<K, V> descendingMap;

        @CheckForNull
        transient NavigableSet<K> navigableKeySet;

        public SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(K k10) {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().ceilingEntry(k10), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(K k10) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k10);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.descendingKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> r10 = Synchronized.r(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = r10;
                    return r10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                try {
                    NavigableMap<K, V> navigableMap = this.descendingMap;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap<K, V> p10 = Synchronized.p(delegate().descendingMap(), this.mutex);
                    this.descendingMap = p10;
                    return p10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().firstEntry(), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(K k10) {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().floorEntry(k10), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(K k10) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k10);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            NavigableMap<K, V> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().headMap(k10, z10), this.mutex);
            }
            return p10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(K k10) {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().higherEntry(k10), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(K k10) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k10);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().lastEntry(), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(K k10) {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().lowerEntry(k10), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(K k10) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k10);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.navigableKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> r10 = Synchronized.r(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = r10;
                    return r10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().pollFirstEntry(), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> s10;
            synchronized (this.mutex) {
                s10 = Synchronized.s(delegate().pollLastEntry(), this.mutex);
            }
            return s10;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            NavigableMap<K, V> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().subMap(k10, z10, k11, z11), this.mutex);
            }
            return p10;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            NavigableMap<K, V> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().tailMap(k10, z10), this.mutex);
            }
            return p10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    @a5.d
    @a5.c
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient NavigableSet<E> descendingSet;

        public SynchronizedNavigableSet(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(E e10) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e10);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<E> navigableSet = this.descendingSet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<E> r10 = Synchronized.r(delegate().descendingSet(), this.mutex);
                    this.descendingSet = r10;
                    return r10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(E e10) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e10);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e10, boolean z10) {
            NavigableSet<E> r10;
            synchronized (this.mutex) {
                r10 = Synchronized.r(delegate().headSet(e10, z10), this.mutex);
            }
            return r10;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(E e10) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e10);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(E e10) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e10);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
            NavigableSet<E> r10;
            synchronized (this.mutex) {
                r10 = Synchronized.r(delegate().subSet(e10, z10, e11, z11), this.mutex);
            }
            return r10;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e10, boolean z10) {
            NavigableSet<E> r10;
            synchronized (this.mutex) {
                r10 = Synchronized.r(delegate().tailSet(e10, z10), this.mutex);
            }
            return r10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e10) {
            return headSet(e10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e10) {
            return tailSet(e10, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e10, E e11) {
            return subSet(e10, true, e11, false);
        }
    }

    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSet(SortedSet<E> sortedSet, @CheckForNull Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e10) {
            SortedSet<E> x10;
            synchronized (this.mutex) {
                x10 = Synchronized.x(delegate().headSet(e10), this.mutex);
            }
            return x10;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e10, E e11) {
            SortedSet<E> x10;
            synchronized (this.mutex) {
                x10 = Synchronized.x(delegate().subSet(e10, e11), this.mutex);
            }
            return x10;
        }

        public SortedSet<E> tailSet(E e10) {
            SortedSet<E> x10;
            synchronized (this.mutex) {
                x10 = Synchronized.x(delegate().tailSet(e10), this.mutex);
            }
            return x10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }

    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        public class a extends v1<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$a$a */
            public class C0283a extends j0<K, Collection<V>> {

                /* renamed from: b */
                public final /* synthetic */ Map.Entry f9827b;

                public C0283a(Map.Entry entry) {
                    this.f9827b = entry;
                }

                @Override // e5.j0, e5.l0
                /* renamed from: e */
                public Map.Entry<K, Collection<V>> delegate() {
                    return this.f9827b;
                }

                @Override // e5.j0, java.util.Map.Entry
                /* renamed from: f */
                public Collection<V> getValue() {
                    return Synchronized.A((Collection) this.f9827b.getValue(), SynchronizedAsMapEntries.this.mutex);
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // e5.v1
            /* renamed from: b */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                return new C0283a(entry);
            }
        }

        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            boolean p10;
            synchronized (this.mutex) {
                p10 = Maps.p(delegate(), obj);
            }
            return p10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean b10;
            synchronized (this.mutex) {
                b10 = f.b(delegate(), collection);
            }
            return b10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            boolean g10;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                g10 = Sets.g(delegate(), obj);
            }
            return g10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(super.iterator());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            boolean k02;
            synchronized (this.mutex) {
                k02 = Maps.k0(delegate(), obj);
            }
            return k02;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean V;
            synchronized (this.mutex) {
                V = Iterators.V(delegate().iterator(), collection);
            }
            return V;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean X;
            synchronized (this.mutex) {
                X = Iterators.X(delegate().iterator(), collection);
            }
            return X;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] l10;
            synchronized (this.mutex) {
                l10 = b1.l(delegate());
            }
            return l10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) b1.m(delegate(), tArr);
            }
            return tArr2;
        }
    }
}
