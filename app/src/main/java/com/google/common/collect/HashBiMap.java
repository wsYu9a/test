package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import e5.a1;
import e5.d1;
import e5.s0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements e5.g<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient e5.g<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    public static class Inverse<K, V> extends AbstractMap<V, K> implements e5.g<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @a5.c("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@CheckForNull Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            d dVar = new d(this.forward);
            this.inverseEntrySet = dVar;
            return dVar;
        }

        @Override // e5.g
        @CanIgnoreReturnValue
        @CheckForNull
        public K forcePut(@d1 V v10, @d1 K k10) {
            return this.forward.putInverse(v10, k10, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // e5.g
        public e5.g<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, e5.g
        @CanIgnoreReturnValue
        @CheckForNull
        public K put(@d1 V v10, @d1 K k10) {
            return this.forward.putInverse(v10, k10, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @CheckForNull
        public K remove(@CheckForNull Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, e5.g
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public final class a extends e5.b<K, V> {

        /* renamed from: b */
        @d1
        public final K f9427b;

        /* renamed from: c */
        public int f9428c;

        public a(int i10) {
            this.f9427b = (K) a1.a(HashBiMap.this.keys[i10]);
            this.f9428c = i10;
        }

        public void a() {
            int i10 = this.f9428c;
            if (i10 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i10 <= hashBiMap.size && b5.r.a(hashBiMap.keys[i10], this.f9427b)) {
                    return;
                }
            }
            this.f9428c = HashBiMap.this.findEntryByKey(this.f9427b);
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getKey() {
            return this.f9427b;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V getValue() {
            a();
            int i10 = this.f9428c;
            return i10 == -1 ? (V) a1.b() : (V) a1.a(HashBiMap.this.values[i10]);
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V setValue(@d1 V v10) {
            a();
            int i10 = this.f9428c;
            if (i10 == -1) {
                HashBiMap.this.put(this.f9427b, v10);
                return (V) a1.b();
            }
            V v11 = (V) a1.a(HashBiMap.this.values[i10]);
            if (b5.r.a(v11, v10)) {
                return v10;
            }
            HashBiMap.this.replaceValueInEntry(this.f9428c, v10, false);
            return v11;
        }
    }

    public static final class b<K, V> extends e5.b<V, K> {

        /* renamed from: b */
        public final HashBiMap<K, V> f9430b;

        /* renamed from: c */
        @d1
        public final V f9431c;

        /* renamed from: d */
        public int f9432d;

        public b(HashBiMap<K, V> hashBiMap, int i10) {
            this.f9430b = hashBiMap;
            this.f9431c = (V) a1.a(hashBiMap.values[i10]);
            this.f9432d = i10;
        }

        private void a() {
            int i10 = this.f9432d;
            if (i10 != -1) {
                HashBiMap<K, V> hashBiMap = this.f9430b;
                if (i10 <= hashBiMap.size && b5.r.a(this.f9431c, hashBiMap.values[i10])) {
                    return;
                }
            }
            this.f9432d = this.f9430b.findEntryByValue(this.f9431c);
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V getKey() {
            return this.f9431c;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getValue() {
            a();
            int i10 = this.f9432d;
            return i10 == -1 ? (K) a1.b() : (K) a1.a(this.f9430b.keys[i10]);
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K setValue(@d1 K k10) {
            a();
            int i10 = this.f9432d;
            if (i10 == -1) {
                this.f9430b.putInverse(this.f9431c, k10, false);
                return (K) a1.b();
            }
            K k11 = (K) a1.a(this.f9430b.keys[i10]);
            if (b5.r.a(k11, k10)) {
                return k10;
            }
            this.f9430b.replaceKeyInEntry(this.f9432d, k10, false);
            return k11;
        }
    }

    public final class c extends g<K, V, Map.Entry<K, V>> {
        public c() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<K, V> a(int i10) {
            return new a(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && b5.r.a(value, HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d10 = s0.d(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, d10);
            if (findEntryByKey == -1 || !b5.r.a(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d10);
            return true;
        }
    }

    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<V, K> a(int i10) {
            return new b(this.f9436b, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.f9436b.findEntryByValue(key);
            return findEntryByValue != -1 && b5.r.a(this.f9436b.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d10 = s0.d(key);
            int findEntryByValue = this.f9436b.findEntryByValue(key, d10);
            if (findEntryByValue == -1 || !b5.r.a(this.f9436b.keys[findEntryByValue], value)) {
                return false;
            }
            this.f9436b.removeEntryValueHashKnown(findEntryByValue, d10);
            return true;
        }
    }

    public final class e extends g<K, V, K> {
        public e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        @d1
        public K a(int i10) {
            return (K) a1.a(HashBiMap.this.keys[i10]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int d10 = s0.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d10);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d10);
            return true;
        }
    }

    public final class f extends g<K, V, V> {
        public f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        @d1
        public V a(int i10) {
            return (V) a1.a(HashBiMap.this.values[i10]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int d10 = s0.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d10);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d10);
            return true;
        }
    }

    public static abstract class g<K, V, T> extends AbstractSet<T> {

        /* renamed from: b */
        public final HashBiMap<K, V> f9436b;

        public class a implements Iterator<T> {

            /* renamed from: b */
            public int f9437b;

            /* renamed from: c */
            public int f9438c = -1;

            /* renamed from: d */
            public int f9439d;

            /* renamed from: e */
            public int f9440e;

            public a() {
                this.f9437b = ((HashBiMap) g.this.f9436b).firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = g.this.f9436b;
                this.f9439d = hashBiMap.modCount;
                this.f9440e = hashBiMap.size;
            }

            public final void a() {
                if (g.this.f9436b.modCount != this.f9439d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f9437b != -2 && this.f9440e > 0;
            }

            @Override // java.util.Iterator
            @d1
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T t10 = (T) g.this.a(this.f9437b);
                this.f9438c = this.f9437b;
                this.f9437b = ((HashBiMap) g.this.f9436b).nextInInsertionOrder[this.f9437b];
                this.f9440e--;
                return t10;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                e5.i.e(this.f9438c != -1);
                g.this.f9436b.removeEntry(this.f9438c);
                int i10 = this.f9437b;
                HashBiMap<K, V> hashBiMap = g.this.f9436b;
                if (i10 == hashBiMap.size) {
                    this.f9437b = this.f9438c;
                }
                this.f9438c = -1;
                this.f9439d = hashBiMap.modCount;
            }
        }

        public g(HashBiMap<K, V> hashBiMap) {
            this.f9436b = hashBiMap;
        }

        @d1
        public abstract T a(int i10);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f9436b.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f9436b.size;
        }
    }

    private HashBiMap(int i10) {
        init(i10);
    }

    private int bucket(int i10) {
        return i10 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i10, int i11) {
        b5.u.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableKToV;
        int i12 = iArr[bucket];
        if (i12 == i10) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i13 = this.nextInBucketKToV[i12];
        while (true) {
            int i14 = i12;
            i12 = i13;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.keys[i10]);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
                sb2.append("Expected to find entry with key ");
                sb2.append(valueOf);
                throw new AssertionError(sb2.toString());
            }
            if (i12 == i10) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i14] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            }
            i13 = this.nextInBucketKToV[i12];
        }
    }

    private void deleteFromTableVToK(int i10, int i11) {
        b5.u.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableVToK;
        int i12 = iArr[bucket];
        if (i12 == i10) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i13 = this.nextInBucketVToK[i12];
        while (true) {
            int i14 = i12;
            i12 = i13;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.values[i10]);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                sb2.append("Expected to find entry with value ");
                sb2.append(valueOf);
                throw new AssertionError(sb2.toString());
            }
            if (i12 == i10) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i14] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            }
            i13 = this.nextInBucketVToK[i12];
        }
    }

    private void ensureCapacity(int i10) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i10) {
            int f10 = ImmutableCollection.b.f(iArr.length, i10);
            this.keys = (K[]) Arrays.copyOf(this.keys, f10);
            this.values = (V[]) Arrays.copyOf(this.values, f10);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, f10);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, f10);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, f10);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, f10);
        }
        if (this.hashTableKToV.length < i10) {
            int a10 = s0.a(i10, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a10);
            this.hashTableVToK = createFilledWithAbsent(a10);
            for (int i11 = 0; i11 < this.size; i11++) {
                int bucket = bucket(s0.d(this.keys[i11]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i11] = iArr3[bucket];
                iArr3[bucket] = i11;
                int bucket2 = bucket(s0.d(this.values[i11]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i11] = iArr5[bucket2];
                iArr5[bucket2] = i11;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i10) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i10);
        Arrays.fill(copyOf, length, i10, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i10, int i11) {
        b5.u.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void insertIntoTableVToK(int i10, int i11) {
        b5.u.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void moveEntryToIndex(int i10, int i11) {
        int i12;
        int i13;
        if (i10 == i11) {
            return;
        }
        int i14 = this.prevInInsertionOrder[i10];
        int i15 = this.nextInInsertionOrder[i10];
        setSucceeds(i14, i11);
        setSucceeds(i11, i15);
        K[] kArr = this.keys;
        K k10 = kArr[i10];
        V[] vArr = this.values;
        V v10 = vArr[i10];
        kArr[i11] = k10;
        vArr[i11] = v10;
        int bucket = bucket(s0.d(k10));
        int[] iArr = this.hashTableKToV;
        int i16 = iArr[bucket];
        if (i16 == i10) {
            iArr[bucket] = i11;
        } else {
            int i17 = this.nextInBucketKToV[i16];
            while (true) {
                i12 = i16;
                i16 = i17;
                if (i16 == i10) {
                    break;
                } else {
                    i17 = this.nextInBucketKToV[i16];
                }
            }
            this.nextInBucketKToV[i12] = i11;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i11] = iArr2[i10];
        iArr2[i10] = -1;
        int bucket2 = bucket(s0.d(v10));
        int[] iArr3 = this.hashTableVToK;
        int i18 = iArr3[bucket2];
        if (i18 == i10) {
            iArr3[bucket2] = i11;
        } else {
            int i19 = this.nextInBucketVToK[i18];
            while (true) {
                i13 = i18;
                i18 = i19;
                if (i18 == i10) {
                    break;
                } else {
                    i19 = this.nextInBucketVToK[i18];
                }
            }
            this.nextInBucketVToK[i13] = i11;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i11] = iArr4[i10];
        iArr4[i10] = -1;
    }

    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h10 = w.h(objectInputStream);
        init(16);
        w.c(this, objectInputStream, h10);
    }

    public void replaceKeyInEntry(int i10, @d1 K k10, boolean z10) {
        int i11;
        b5.u.d(i10 != -1);
        int d10 = s0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d10);
        int i12 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i11 = -2;
        } else {
            if (!z10) {
                String valueOf = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 28);
                sb2.append("Key already present in map: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
            i12 = this.prevInInsertionOrder[findEntryByKey];
            i11 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d10);
            if (i10 == this.size) {
                i10 = findEntryByKey;
            }
        }
        if (i12 == i10) {
            i12 = this.prevInInsertionOrder[i10];
        } else if (i12 == this.size) {
            i12 = findEntryByKey;
        }
        if (i11 == i10) {
            findEntryByKey = this.nextInInsertionOrder[i10];
        } else if (i11 != this.size) {
            findEntryByKey = i11;
        }
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        deleteFromTableKToV(i10, s0.d(this.keys[i10]));
        this.keys[i10] = k10;
        insertIntoTableKToV(i10, s0.d(k10));
        setSucceeds(i12, i10);
        setSucceeds(i10, findEntryByKey);
    }

    public void replaceValueInEntry(int i10, @d1 V v10, boolean z10) {
        b5.u.d(i10 != -1);
        int d10 = s0.d(v10);
        int findEntryByValue = findEntryByValue(v10, d10);
        if (findEntryByValue != -1) {
            if (!z10) {
                String valueOf = String.valueOf(v10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
                sb2.append("Value already present in map: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
            removeEntryValueHashKnown(findEntryByValue, d10);
            if (i10 == this.size) {
                i10 = findEntryByValue;
            }
        }
        deleteFromTableVToK(i10, s0.d(this.values[i10]));
        this.values[i10] = v10;
        insertIntoTableVToK(i10, d10);
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstInInsertionOrder = i11;
        } else {
            this.nextInInsertionOrder[i10] = i11;
        }
        if (i11 == -2) {
            this.lastInInsertionOrder = i10;
        } else {
            this.prevInInsertionOrder[i11] = i10;
        }
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    public int findEntry(@CheckForNull Object obj, int i10, int[] iArr, int[] iArr2, Object[] objArr) {
        int i11 = iArr[bucket(i10)];
        while (i11 != -1) {
            if (b5.r.a(objArr[i11], obj)) {
                return i11;
            }
            i11 = iArr2[i11];
        }
        return -1;
    }

    public int findEntryByKey(@CheckForNull Object obj) {
        return findEntryByKey(obj, s0.d(obj));
    }

    public int findEntryByValue(@CheckForNull Object obj) {
        return findEntryByValue(obj, s0.d(obj));
    }

    @Override // e5.g
    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(@d1 K k10, @d1 V v10) {
        return put(k10, v10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @CheckForNull
    public K getInverse(@CheckForNull Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i10) {
        e5.i.b(i10, "expectedSize");
        int a10 = s0.a(i10, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i10];
        this.values = (V[]) new Object[i10];
        this.hashTableKToV = createFilledWithAbsent(a10);
        this.hashTableVToK = createFilledWithAbsent(a10);
        this.nextInBucketKToV = createFilledWithAbsent(i10);
        this.nextInBucketVToK = createFilledWithAbsent(i10);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i10);
        this.nextInInsertionOrder = createFilledWithAbsent(i10);
    }

    @Override // e5.g
    public e5.g<V, K> inverse() {
        e5.g<V, K> gVar = this.inverse;
        if (gVar != null) {
            return gVar;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.keySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map, e5.g
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 K k10, @d1 V v10) {
        return put(k10, v10, false);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public K putInverse(@d1 V v10, @d1 K k10, boolean z10) {
        int d10 = s0.d(v10);
        int findEntryByValue = findEntryByValue(v10, d10);
        if (findEntryByValue != -1) {
            K k11 = this.keys[findEntryByValue];
            if (b5.r.a(k11, k10)) {
                return k10;
            }
            replaceKeyInEntry(findEntryByValue, k10, z10);
            return k11;
        }
        int i10 = this.lastInInsertionOrder;
        int d11 = s0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d11);
        if (!z10) {
            b5.u.u(findEntryByKey == -1, "Key already present: %s", k10);
        } else if (findEntryByKey != -1) {
            i10 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d11);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = k10;
        this.values[i11] = v10;
        insertIntoTableKToV(i11, d11);
        insertIntoTableVToK(this.size, d10);
        int i12 = i10 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i10];
        setSucceeds(i10, this.size);
        setSucceeds(this.size, i12);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        int d10 = s0.d(obj);
        int findEntryByKey = findEntryByKey(obj, d10);
        if (findEntryByKey == -1) {
            return null;
        }
        V v10 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d10);
        return v10;
    }

    public void removeEntry(int i10) {
        removeEntryKeyHashKnown(i10, s0.d(this.keys[i10]));
    }

    public void removeEntryKeyHashKnown(int i10, int i11) {
        removeEntry(i10, i11, s0.d(this.values[i10]));
    }

    public void removeEntryValueHashKnown(int i10, int i11) {
        removeEntry(i10, s0.d(this.keys[i10]), i11);
    }

    @CheckForNull
    public K removeInverse(@CheckForNull Object obj) {
        int d10 = s0.d(obj);
        int findEntryByValue = findEntryByValue(obj, d10);
        if (findEntryByValue == -1) {
            return null;
        }
        K k10 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d10);
        return k10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i10) {
        return new HashBiMap<>(i10);
    }

    private void removeEntry(int i10, int i11, int i12) {
        b5.u.d(i10 != -1);
        deleteFromTableKToV(i10, i11);
        deleteFromTableVToK(i10, i12);
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        moveEntryToIndex(this.size - 1, i10);
        K[] kArr = this.keys;
        int i13 = this.size;
        kArr[i13 - 1] = null;
        this.values[i13 - 1] = null;
        this.size = i13 - 1;
        this.modCount++;
    }

    public int findEntryByKey(@CheckForNull Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@CheckForNull Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @CheckForNull
    public V put(@d1 K k10, @d1 V v10, boolean z10) {
        int d10 = s0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d10);
        if (findEntryByKey != -1) {
            V v11 = this.values[findEntryByKey];
            if (b5.r.a(v11, v10)) {
                return v10;
            }
            replaceValueInEntry(findEntryByKey, v10, z10);
            return v11;
        }
        int d11 = s0.d(v10);
        int findEntryByValue = findEntryByValue(v10, d11);
        if (!z10) {
            b5.u.u(findEntryByValue == -1, "Value already present: %s", v10);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d11);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i10 = this.size;
        kArr[i10] = k10;
        this.values[i10] = v10;
        insertIntoTableKToV(i10, d10);
        insertIntoTableVToK(this.size, d11);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, e5.g
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.valueSet = fVar;
        return fVar;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
