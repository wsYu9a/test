package com.wbl.ad.yzz.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes5.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.d entrySet;
    public final g<K, V> header;
    private LinkedHashTreeMap<K, V>.e keySet;
    public int modCount;
    public int size;
    public g<K, V>[] table;
    public int threshold;

    /* renamed from: b */
    public static final /* synthetic */ boolean f32225b = true;

    /* renamed from: a */
    public static final Comparator<Comparable> f32224a = new a();

    public static class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public final class d extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedHashTreeMap<K, V>.f<Map.Entry<K, V>> {
            public a(d dVar) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> a2;
            if (!(obj instanceof Map.Entry) || (a2 = LinkedHashTreeMap.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.b(a2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public final class e extends AbstractSet<K> {

        public class a extends LinkedHashTreeMap<K, V>.f<K> {
            public a(e eVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f32242f;
            }
        }

        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public abstract class f<T> implements Iterator<T> {

        /* renamed from: a */
        public g<K, V> f32233a;

        /* renamed from: b */
        public g<K, V> f32234b = null;

        /* renamed from: c */
        public int f32235c;

        public f() {
            this.f32233a = LinkedHashTreeMap.this.header.f32240d;
            this.f32235c = LinkedHashTreeMap.this.modCount;
        }

        public final g<K, V> a() {
            g<K, V> gVar = this.f32233a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.modCount != this.f32235c) {
                throw new ConcurrentModificationException();
            }
            this.f32233a = gVar.f32240d;
            this.f32234b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f32233a != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f32234b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.b(gVar, true);
            this.f32234b = null;
            this.f32235c = LinkedHashTreeMap.this.modCount;
        }
    }

    public LinkedHashTreeMap() {
        this(f32224a);
    }

    public static int a(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public g<K, V> a(K k, boolean z) {
        g<K, V> gVar;
        int i2;
        g<K, V> gVar2;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int a2 = a(k.hashCode());
        int length = (gVarArr.length - 1) & a2;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == f32224a ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(gVar3.f32242f) : comparator.compare(k, gVar3.f32242f);
                if (compareTo == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = compareTo < 0 ? gVar3.f32238b : gVar3.f32239c;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i2 = compareTo;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k, a2, gVar5, gVar5.f32241e);
            if (i2 < 0) {
                gVar.f32238b = gVar2;
            } else {
                gVar.f32239c = gVar2;
            }
            a((g) gVar, true);
        } else {
            if (comparator == f32224a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k, a2, gVar5, gVar5.f32241e);
            gVarArr[length] = gVar2;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            a();
        }
        this.modCount++;
        return gVar2;
    }

    public void b(g<K, V> gVar, boolean z) {
        int i2;
        if (z) {
            g<K, V> gVar2 = gVar.f32241e;
            gVar2.f32240d = gVar.f32240d;
            gVar.f32240d.f32241e = gVar2;
            gVar.f32241e = null;
            gVar.f32240d = null;
        }
        g<K, V> gVar3 = gVar.f32238b;
        g<K, V> gVar4 = gVar.f32239c;
        g<K, V> gVar5 = gVar.f32237a;
        int i3 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                a((g) gVar, (g) gVar3);
                gVar.f32238b = null;
            } else if (gVar4 != null) {
                a((g) gVar, (g) gVar4);
                gVar.f32239c = null;
            } else {
                a((g) gVar, (g) null);
            }
            a((g) gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> b2 = gVar3.f32245i > gVar4.f32245i ? gVar3.b() : gVar4.a();
        b(b2, false);
        g<K, V> gVar6 = gVar.f32238b;
        if (gVar6 != null) {
            i2 = gVar6.f32245i;
            b2.f32238b = gVar6;
            gVar6.f32237a = b2;
            gVar.f32238b = null;
        } else {
            i2 = 0;
        }
        g<K, V> gVar7 = gVar.f32239c;
        if (gVar7 != null) {
            i3 = gVar7.f32245i;
            b2.f32239c = gVar7;
            gVar7.f32237a = b2;
            gVar.f32239c = null;
        }
        b2.f32245i = Math.max(i2, i3) + 1;
        a((g) gVar, (g) b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f32240d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f32240d;
            gVar2.f32241e = null;
            gVar2.f32240d = null;
            gVar2 = gVar3;
        }
        gVar.f32241e = gVar;
        gVar.f32240d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f32244h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> a2 = a((LinkedHashTreeMap<K, V>) k, true);
        V v2 = a2.f32244h;
        a2.f32244h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f32244h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f32224a : comparator;
        this.header = new g<>();
        this.table = new g[16];
        this.threshold = 12;
    }

    public static class c<K, V> {

        /* renamed from: a */
        public g<K, V> f32230a;

        public void a(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f32237a = gVar2;
                gVar2 = gVar;
                gVar = gVar.f32238b;
            }
            this.f32230a = gVar2;
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f32230a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f32237a;
            gVar.f32237a = null;
            g<K, V> gVar3 = gVar.f32239c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f32237a = gVar4;
                    gVar3 = gVar2.f32238b;
                } else {
                    this.f32230a = gVar4;
                    return gVar;
                }
            }
        }
    }

    public static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public g<K, V> f32237a;

        /* renamed from: b */
        public g<K, V> f32238b;

        /* renamed from: c */
        public g<K, V> f32239c;

        /* renamed from: d */
        public g<K, V> f32240d;

        /* renamed from: e */
        public g<K, V> f32241e;

        /* renamed from: f */
        public final K f32242f;

        /* renamed from: g */
        public final int f32243g;

        /* renamed from: h */
        public V f32244h;

        /* renamed from: i */
        public int f32245i;

        public g() {
            this.f32242f = null;
            this.f32243g = -1;
            this.f32241e = this;
            this.f32240d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f32238b; gVar2 != null; gVar2 = gVar2.f32238b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f32239c; gVar2 != null; gVar2 = gVar2.f32239c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f32242f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f32244h;
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
            return this.f32242f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f32244h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f32242f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f32244h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f32244h;
            this.f32244h = v;
            return v2;
        }

        public String toString() {
            return this.f32242f + "=" + this.f32244h;
        }

        public g(g<K, V> gVar, K k, int i2, g<K, V> gVar2, g<K, V> gVar3) {
            this.f32237a = gVar;
            this.f32242f = k;
            this.f32243g = i2;
            this.f32245i = 1;
            this.f32240d = gVar2;
            this.f32241e = gVar3;
            gVar3.f32240d = this;
            gVar2.f32241e = this;
        }
    }

    public static final class b<K, V> {

        /* renamed from: a */
        public g<K, V> f32226a;

        /* renamed from: b */
        public int f32227b;

        /* renamed from: c */
        public int f32228c;

        /* renamed from: d */
        public int f32229d;

        public void a(int i2) {
            this.f32227b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f32229d = 0;
            this.f32228c = 0;
            this.f32226a = null;
        }

        public void a(g<K, V> gVar) {
            gVar.f32239c = null;
            gVar.f32237a = null;
            gVar.f32238b = null;
            gVar.f32245i = 1;
            int i2 = this.f32227b;
            if (i2 > 0) {
                int i3 = this.f32229d;
                if ((i3 & 1) == 0) {
                    this.f32229d = i3 + 1;
                    this.f32227b = i2 - 1;
                    this.f32228c++;
                }
            }
            gVar.f32237a = this.f32226a;
            this.f32226a = gVar;
            int i4 = this.f32229d + 1;
            this.f32229d = i4;
            int i5 = this.f32227b;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.f32229d = i4 + 1;
                this.f32227b = i5 - 1;
                this.f32228c++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f32229d & i7) != i7) {
                    return;
                }
                int i8 = this.f32228c;
                if (i8 == 0) {
                    g<K, V> gVar2 = this.f32226a;
                    g<K, V> gVar3 = gVar2.f32237a;
                    g<K, V> gVar4 = gVar3.f32237a;
                    gVar3.f32237a = gVar4.f32237a;
                    this.f32226a = gVar3;
                    gVar3.f32238b = gVar4;
                    gVar3.f32239c = gVar2;
                    gVar3.f32245i = gVar2.f32245i + 1;
                    gVar4.f32237a = gVar3;
                    gVar2.f32237a = gVar3;
                } else if (i8 == 1) {
                    g<K, V> gVar5 = this.f32226a;
                    g<K, V> gVar6 = gVar5.f32237a;
                    this.f32226a = gVar6;
                    gVar6.f32239c = gVar5;
                    gVar6.f32245i = gVar5.f32245i + 1;
                    gVar5.f32237a = gVar6;
                    this.f32228c = 0;
                } else if (i8 == 2) {
                    this.f32228c = 0;
                }
                i6 *= 2;
            }
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f32226a;
            if (gVar.f32237a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((LinkedHashTreeMap<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public g<K, V> a(Map.Entry<?, ?> entry) {
        g<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.f32244h, entry.getValue())) {
            return a2;
        }
        return null;
    }

    public final boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final void a(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f32237a;
        gVar.f32237a = null;
        if (gVar2 != null) {
            gVar2.f32237a = gVar3;
        }
        if (gVar3 != null) {
            if (gVar3.f32238b == gVar) {
                gVar3.f32238b = gVar2;
                return;
            } else {
                if (!f32225b && gVar3.f32239c != gVar) {
                    throw new AssertionError();
                }
                gVar3.f32239c = gVar2;
                return;
            }
        }
        int i2 = gVar.f32243g;
        this.table[i2 & (r0.length - 1)] = gVar2;
    }

    public g<K, V> b(Object obj) {
        g<K, V> a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        return a2;
    }

    public final void b(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f32238b;
        g<K, V> gVar3 = gVar.f32239c;
        g<K, V> gVar4 = gVar2.f32238b;
        g<K, V> gVar5 = gVar2.f32239c;
        gVar.f32238b = gVar5;
        if (gVar5 != null) {
            gVar5.f32237a = gVar;
        }
        a((g) gVar, (g) gVar2);
        gVar2.f32239c = gVar;
        gVar.f32237a = gVar2;
        int max = Math.max(gVar3 != null ? gVar3.f32245i : 0, gVar5 != null ? gVar5.f32245i : 0) + 1;
        gVar.f32245i = max;
        gVar2.f32245i = Math.max(max, gVar4 != null ? gVar4.f32245i : 0) + 1;
    }

    public final void a(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f32238b;
            g<K, V> gVar3 = gVar.f32239c;
            int i2 = gVar2 != null ? gVar2.f32245i : 0;
            int i3 = gVar3 != null ? gVar3.f32245i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                g<K, V> gVar4 = gVar3.f32238b;
                g<K, V> gVar5 = gVar3.f32239c;
                int i5 = (gVar4 != null ? gVar4.f32245i : 0) - (gVar5 != null ? gVar5.f32245i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f32225b && i5 != 1) {
                        throw new AssertionError();
                    }
                    b((g) gVar3);
                    a((g) gVar);
                } else {
                    a((g) gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                g<K, V> gVar6 = gVar2.f32238b;
                g<K, V> gVar7 = gVar2.f32239c;
                int i6 = (gVar6 != null ? gVar6.f32245i : 0) - (gVar7 != null ? gVar7.f32245i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f32225b && i6 != -1) {
                        throw new AssertionError();
                    }
                    a((g) gVar2);
                    b((g) gVar);
                } else {
                    b((g) gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                gVar.f32245i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f32225b && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                }
                gVar.f32245i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.f32237a;
        }
    }

    public final void a(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f32238b;
        g<K, V> gVar3 = gVar.f32239c;
        g<K, V> gVar4 = gVar3.f32238b;
        g<K, V> gVar5 = gVar3.f32239c;
        gVar.f32239c = gVar4;
        if (gVar4 != null) {
            gVar4.f32237a = gVar;
        }
        a((g) gVar, (g) gVar3);
        gVar3.f32238b = gVar;
        gVar.f32237a = gVar3;
        int max = Math.max(gVar2 != null ? gVar2.f32245i : 0, gVar4 != null ? gVar4.f32245i : 0) + 1;
        gVar.f32245i = max;
        gVar3.f32245i = Math.max(max, gVar5 != null ? gVar5.f32245i : 0) + 1;
    }

    public final void a() {
        g<K, V>[] a2 = a((g[]) this.table);
        this.table = a2;
        this.threshold = (a2.length / 2) + (a2.length / 4);
    }

    public static <K, V> g<K, V>[] a(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i2 = 0; i2 < length; i2++) {
            g<K, V> gVar = gVarArr[i2];
            if (gVar != null) {
                cVar.a(gVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    g<K, V> a2 = cVar.a();
                    if (a2 == null) {
                        break;
                    }
                    if ((a2.f32243g & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                bVar.a(i3);
                bVar2.a(i4);
                cVar.a(gVar);
                while (true) {
                    g<K, V> a3 = cVar.a();
                    if (a3 == null) {
                        break;
                    }
                    if ((a3.f32243g & length) == 0) {
                        bVar.a(a3);
                    } else {
                        bVar2.a(a3);
                    }
                }
                gVarArr2[i2] = i3 > 0 ? bVar.a() : null;
                gVarArr2[i2 + length] = i4 > 0 ? bVar2.a() : null;
            }
        }
        return gVarArr2;
    }
}
