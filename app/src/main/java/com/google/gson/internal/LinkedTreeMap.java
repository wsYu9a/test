package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            a() {
                super(LinkedTreeMap.this, null);
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends LinkedTreeMap<K, V>.d<K> {
            a() {
                super(LinkedTreeMap.this, null);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f8054f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f8050b;
            e<K, V> eVar3 = eVar.f8051c;
            int i2 = eVar2 != null ? eVar2.f8056h : 0;
            int i3 = eVar3 != null ? eVar3.f8056h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f8050b;
                e<K, V> eVar5 = eVar3.f8051c;
                int i5 = (eVar4 != null ? eVar4.f8056h : 0) - (eVar5 != null ? eVar5.f8056h : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    rotateLeft(eVar);
                } else {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f8050b;
                e<K, V> eVar7 = eVar2.f8051c;
                int i6 = (eVar6 != null ? eVar6.f8056h : 0) - (eVar7 != null ? eVar7.f8056h : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    rotateRight(eVar);
                } else {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f8056h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f8056h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f8049a;
        }
    }

    private void replaceInParent(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f8049a;
        eVar.f8049a = null;
        if (eVar2 != null) {
            eVar2.f8049a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f8050b == eVar) {
            eVar3.f8050b = eVar2;
        } else {
            eVar3.f8051c = eVar2;
        }
    }

    private void rotateLeft(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8050b;
        e<K, V> eVar3 = eVar.f8051c;
        e<K, V> eVar4 = eVar3.f8050b;
        e<K, V> eVar5 = eVar3.f8051c;
        eVar.f8051c = eVar4;
        if (eVar4 != null) {
            eVar4.f8049a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.f8050b = eVar;
        eVar.f8049a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f8056h : 0, eVar4 != null ? eVar4.f8056h : 0) + 1;
        eVar.f8056h = max;
        eVar3.f8056h = Math.max(max, eVar5 != null ? eVar5.f8056h : 0) + 1;
    }

    private void rotateRight(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8050b;
        e<K, V> eVar3 = eVar.f8051c;
        e<K, V> eVar4 = eVar2.f8050b;
        e<K, V> eVar5 = eVar2.f8051c;
        eVar.f8050b = eVar5;
        if (eVar5 != null) {
            eVar5.f8049a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f8051c = eVar;
        eVar.f8049a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f8056h : 0, eVar5 != null ? eVar5.f8056h : 0) + 1;
        eVar.f8056h = max;
        eVar2.f8056h = Math.max(max, eVar4 != null ? eVar4.f8056h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f8053e = eVar;
        eVar.f8052d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e<K, V> find(K k, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                i2 = comparable != null ? comparable.compareTo(eVar2.f8054f) : comparator.compare(k, eVar2.f8054f);
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f8050b : eVar2.f8051c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.f8053e);
            if (i2 < 0) {
                eVar2.f8050b = eVar;
            } else {
                eVar2.f8051c = eVar;
            }
            rebalance(eVar2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.f8053e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f8055g, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f8055g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> find = find(k, true);
        V v2 = find.f8055g;
        find.f8055g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f8055g;
        }
        return null;
    }

    void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f8053e;
            eVar2.f8052d = eVar.f8052d;
            eVar.f8052d.f8053e = eVar2;
        }
        e<K, V> eVar3 = eVar.f8050b;
        e<K, V> eVar4 = eVar.f8051c;
        e<K, V> eVar5 = eVar.f8049a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                replaceInParent(eVar, eVar3);
                eVar.f8050b = null;
            } else if (eVar4 != null) {
                replaceInParent(eVar, eVar4);
                eVar.f8051c = null;
            } else {
                replaceInParent(eVar, null);
            }
            rebalance(eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> b2 = eVar3.f8056h > eVar4.f8056h ? eVar3.b() : eVar4.a();
        removeInternal(b2, false);
        e<K, V> eVar6 = eVar.f8050b;
        if (eVar6 != null) {
            i2 = eVar6.f8056h;
            b2.f8050b = eVar6;
            eVar6.f8049a = b2;
            eVar.f8050b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f8051c;
        if (eVar7 != null) {
            i3 = eVar7.f8056h;
            b2.f8051c = eVar7;
            eVar7.f8049a = b2;
            eVar.f8051c = null;
        }
        b2.f8056h = Math.max(i2, i3) + 1;
        replaceInParent(eVar, b2);
    }

    e<K, V> removeInternalByKey(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f8049a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f8050b;

        /* renamed from: c, reason: collision with root package name */
        e<K, V> f8051c;

        /* renamed from: d, reason: collision with root package name */
        e<K, V> f8052d;

        /* renamed from: e, reason: collision with root package name */
        e<K, V> f8053e;

        /* renamed from: f, reason: collision with root package name */
        final K f8054f;

        /* renamed from: g, reason: collision with root package name */
        V f8055g;

        /* renamed from: h, reason: collision with root package name */
        int f8056h;

        e() {
            this.f8054f = null;
            this.f8053e = this;
            this.f8052d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f8050b; eVar2 != null; eVar2 = eVar2.f8050b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f8051c; eVar2 != null; eVar2 = eVar2.f8051c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f8054f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f8055g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f8054f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f8055g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f8054f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f8055g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f8055g;
            this.f8055g = v;
            return v2;
        }

        public String toString() {
            return this.f8054f + "=" + this.f8055g;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f8049a = eVar;
            this.f8054f = k;
            this.f8056h = 1;
            this.f8052d = eVar2;
            this.f8053e = eVar3;
            eVar3.f8052d = this;
            eVar2.f8053e = this;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f8045a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f8046b;

        /* renamed from: c, reason: collision with root package name */
        int f8047c;

        private d() {
            this.f8045a = LinkedTreeMap.this.header.f8052d;
            this.f8046b = null;
            this.f8047c = LinkedTreeMap.this.modCount;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f8045a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.f8047c) {
                throw new ConcurrentModificationException();
            }
            this.f8045a = eVar.f8052d;
            this.f8046b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f8045a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f8046b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(eVar, true);
            this.f8046b = null;
            this.f8047c = LinkedTreeMap.this.modCount;
        }

        /* synthetic */ d(LinkedTreeMap linkedTreeMap, a aVar) {
            this();
        }
    }
}
