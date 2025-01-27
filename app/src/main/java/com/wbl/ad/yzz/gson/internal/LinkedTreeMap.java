package com.wbl.ad.yzz.gson.internal;

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

/* loaded from: classes5.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    public final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    public int modCount;
    public e<K, V> root;
    public int size;

    /* renamed from: b */
    public static final /* synthetic */ boolean f32247b = true;

    /* renamed from: a */
    public static final Comparator<Comparable> f32246a = new a();

    public static class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> a2;
            if (!(obj instanceof Map.Entry) || (a2 = LinkedTreeMap.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.b(a2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f32259f;
            }
        }

        public c() {
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
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a */
        public e<K, V> f32250a;

        /* renamed from: b */
        public e<K, V> f32251b = null;

        /* renamed from: c */
        public int f32252c;

        public d() {
            this.f32250a = LinkedTreeMap.this.header.f32257d;
            this.f32252c = LinkedTreeMap.this.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f32250a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.f32252c) {
                throw new ConcurrentModificationException();
            }
            this.f32250a = eVar.f32257d;
            this.f32251b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f32250a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f32251b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.b(eVar, true);
            this.f32251b = null;
            this.f32252c = LinkedTreeMap.this.modCount;
        }
    }

    public LinkedTreeMap() {
        this(f32246a);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public e<K, V> a(K k, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == f32246a ? (Comparable) k : null;
            while (true) {
                i2 = comparable != null ? comparable.compareTo(eVar2.f32259f) : comparator.compare(k, eVar2.f32259f);
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f32255b : eVar2.f32256c;
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
            eVar = new e<>(eVar2, k, eVar4, eVar4.f32258e);
            if (i2 < 0) {
                eVar2.f32255b = eVar;
            } else {
                eVar2.f32256c = eVar;
            }
            a((e) eVar2, true);
        } else {
            if (comparator == f32246a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.f32258e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    public void b(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f32258e;
            eVar2.f32257d = eVar.f32257d;
            eVar.f32257d.f32258e = eVar2;
        }
        e<K, V> eVar3 = eVar.f32255b;
        e<K, V> eVar4 = eVar.f32256c;
        e<K, V> eVar5 = eVar.f32254a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a((e) eVar, (e) eVar3);
                eVar.f32255b = null;
            } else if (eVar4 != null) {
                a((e) eVar, (e) eVar4);
                eVar.f32256c = null;
            } else {
                a((e) eVar, (e) null);
            }
            a((e) eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> b2 = eVar3.f32261h > eVar4.f32261h ? eVar3.b() : eVar4.a();
        b(b2, false);
        e<K, V> eVar6 = eVar.f32255b;
        if (eVar6 != null) {
            i2 = eVar6.f32261h;
            b2.f32255b = eVar6;
            eVar6.f32254a = b2;
            eVar.f32255b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f32256c;
        if (eVar7 != null) {
            i3 = eVar7.f32261h;
            b2.f32256c = eVar7;
            eVar7.f32254a = b2;
            eVar.f32256c = null;
        }
        b2.f32261h = Math.max(i2, i3) + 1;
        a((e) eVar, (e) b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f32258e = eVar;
        eVar.f32257d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
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

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f32260g;
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
        e<K, V> a2 = a((LinkedTreeMap<K, V>) k, true);
        V v2 = a2.f32260g;
        a2.f32260g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f32260g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? f32246a : comparator;
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public e<K, V> f32254a;

        /* renamed from: b */
        public e<K, V> f32255b;

        /* renamed from: c */
        public e<K, V> f32256c;

        /* renamed from: d */
        public e<K, V> f32257d;

        /* renamed from: e */
        public e<K, V> f32258e;

        /* renamed from: f */
        public final K f32259f;

        /* renamed from: g */
        public V f32260g;

        /* renamed from: h */
        public int f32261h;

        public e() {
            this.f32259f = null;
            this.f32258e = this;
            this.f32257d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f32255b; eVar2 != null; eVar2 = eVar2.f32255b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f32256c; eVar2 != null; eVar2 = eVar2.f32256c) {
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
            K k = this.f32259f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f32260g;
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
            return this.f32259f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f32260g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f32259f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f32260g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f32260g;
            this.f32260g = v;
            return v2;
        }

        public String toString() {
            return this.f32259f + "=" + this.f32260g;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f32254a = eVar;
            this.f32259f = k;
            this.f32261h = 1;
            this.f32257d = eVar2;
            this.f32258e = eVar3;
            eVar3.f32257d = this;
            eVar2.f32258e = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((LinkedTreeMap<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public e<K, V> a(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.f32260g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    public final boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f32254a;
        eVar.f32254a = null;
        if (eVar2 != null) {
            eVar2.f32254a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f32255b == eVar) {
                eVar3.f32255b = eVar2;
                return;
            } else {
                if (!f32247b && eVar3.f32256c != eVar) {
                    throw new AssertionError();
                }
                eVar3.f32256c = eVar2;
                return;
            }
        }
        this.root = eVar2;
    }

    public e<K, V> b(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        return a2;
    }

    public final void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f32255b;
        e<K, V> eVar3 = eVar.f32256c;
        e<K, V> eVar4 = eVar2.f32255b;
        e<K, V> eVar5 = eVar2.f32256c;
        eVar.f32255b = eVar5;
        if (eVar5 != null) {
            eVar5.f32254a = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.f32256c = eVar;
        eVar.f32254a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f32261h : 0, eVar5 != null ? eVar5.f32261h : 0) + 1;
        eVar.f32261h = max;
        eVar2.f32261h = Math.max(max, eVar4 != null ? eVar4.f32261h : 0) + 1;
    }

    public final void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f32255b;
            e<K, V> eVar3 = eVar.f32256c;
            int i2 = eVar2 != null ? eVar2.f32261h : 0;
            int i3 = eVar3 != null ? eVar3.f32261h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f32255b;
                e<K, V> eVar5 = eVar3.f32256c;
                int i5 = (eVar4 != null ? eVar4.f32261h : 0) - (eVar5 != null ? eVar5.f32261h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f32247b && i5 != 1) {
                        throw new AssertionError();
                    }
                    b((e) eVar3);
                    a((e) eVar);
                } else {
                    a((e) eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f32255b;
                e<K, V> eVar7 = eVar2.f32256c;
                int i6 = (eVar6 != null ? eVar6.f32261h : 0) - (eVar7 != null ? eVar7.f32261h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f32247b && i6 != -1) {
                        throw new AssertionError();
                    }
                    a((e) eVar2);
                    b((e) eVar);
                } else {
                    b((e) eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f32261h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f32247b && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                }
                eVar.f32261h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f32254a;
        }
    }

    public final void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f32255b;
        e<K, V> eVar3 = eVar.f32256c;
        e<K, V> eVar4 = eVar3.f32255b;
        e<K, V> eVar5 = eVar3.f32256c;
        eVar.f32256c = eVar4;
        if (eVar4 != null) {
            eVar4.f32254a = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.f32255b = eVar;
        eVar.f32254a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f32261h : 0, eVar4 != null ? eVar4.f32261h : 0) + 1;
        eVar.f32261h = max;
        eVar3.f32261h = Math.max(max, eVar5 != null ? eVar5.f32261h : 0) + 1;
    }
}
