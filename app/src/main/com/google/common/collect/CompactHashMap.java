package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.a1;
import e5.d1;
import e5.s0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    @a5.d
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();

    @CheckForNull
    @a5.d
    transient int[] entries;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;

    @CheckForNull
    private transient Set<K> keySetView;

    @CheckForNull
    @a5.d
    transient Object[] keys;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    @CheckForNull
    @a5.d
    transient Object[] values;

    @CheckForNull
    private transient Collection<V> valuesView;

    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        @d1
        public K b(int i10) {
            return (K) CompactHashMap.this.key(i10);
        }
    }

    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: d */
        public Map.Entry<K, V> b(int i10) {
            return new g(i10);
        }
    }

    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        @d1
        public V b(int i10) {
            return (V) CompactHashMap.this.value(i10);
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && b5.r.a(CompactHashMap.this.value(indexOf), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int hashTableMask = CompactHashMap.this.hashTableMask();
            int f10 = e5.j.f(entry.getKey(), entry.getValue(), hashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (f10 == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(f10, hashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            return delegateOrNull != null ? delegateOrNull.keySet().remove(obj) : CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public final class g extends e5.b<K, V> {

        /* renamed from: b */
        @d1
        public final K f9400b;

        /* renamed from: c */
        public int f9401c;

        public g(int i10) {
            this.f9400b = (K) CompactHashMap.this.key(i10);
            this.f9401c = i10;
        }

        public final void a() {
            int i10 = this.f9401c;
            if (i10 == -1 || i10 >= CompactHashMap.this.size() || !b5.r.a(this.f9400b, CompactHashMap.this.key(this.f9401c))) {
                this.f9401c = CompactHashMap.this.indexOf(this.f9400b);
            }
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getKey() {
            return this.f9400b;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) a1.a(delegateOrNull.get(this.f9400b));
            }
            a();
            int i10 = this.f9401c;
            return i10 == -1 ? (V) a1.b() : (V) CompactHashMap.this.value(i10);
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V setValue(@d1 V v10) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) a1.a(delegateOrNull.put(this.f9400b, v10));
            }
            a();
            int i10 = this.f9401c;
            if (i10 == -1) {
                CompactHashMap.this.put(this.f9400b, v10);
                return (V) a1.b();
            }
            V v11 = (V) CompactHashMap.this.value(i10);
            CompactHashMap.this.setValue(this.f9401c, v10);
            return v11;
        }
    }

    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i10 = compactHashMap.size;
        compactHashMap.size = i10 - 1;
        return i10;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i10) {
        return new CompactHashMap<>(i10);
    }

    private int entry(int i10) {
        return requireEntries()[i10];
    }

    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    public int indexOf(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d10 = s0.d(obj);
        int hashTableMask = hashTableMask();
        int h10 = e5.j.h(requireTable(), d10 & hashTableMask);
        if (h10 == 0) {
            return -1;
        }
        int b10 = e5.j.b(d10, hashTableMask);
        do {
            int i10 = h10 - 1;
            int entry = entry(i10);
            if (e5.j.b(entry, hashTableMask) == b10 && b5.r.a(obj, key(i10))) {
                return i10;
            }
            h10 = e5.j.c(entry, hashTableMask);
        } while (h10 != 0);
        return -1;
    }

    public K key(int i10) {
        return (K) requireKeys()[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Invalid size: ");
            sb2.append(readInt);
            throw new InvalidObjectException(sb2.toString());
        }
        init(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public Object removeHelper(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int f10 = e5.j.f(obj, null, hashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (f10 == -1) {
            return NOT_FOUND;
        }
        V value = value(f10);
        moveLastEntry(f10, hashTableMask);
        this.size--;
        incrementModCount();
        return value;
    }

    public int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    public Object[] requireValues() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i10) {
        int min;
        int length = requireEntries().length;
        if (i10 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    @CanIgnoreReturnValue
    private int resizeTable(int i10, int i11, int i12, int i13) {
        Object a10 = e5.j.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            e5.j.i(a10, i12 & i14, i13 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = e5.j.h(requireTable, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = requireEntries[i16];
                int b10 = e5.j.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = e5.j.h(a10, i18);
                e5.j.i(a10, i18, h10);
                requireEntries[i16] = e5.j.d(b10, h11, i14);
                h10 = e5.j.c(i17, i10);
            }
        }
        this.table = a10;
        setHashTableMask(i14);
        return i14;
    }

    private void setEntry(int i10, int i11) {
        requireEntries()[i10] = i11;
    }

    private void setHashTableMask(int i10) {
        this.metadata = e5.j.d(this.metadata, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void setKey(int i10, K k10) {
        requireKeys()[i10] = k10;
    }

    public void setValue(int i10, V v10) {
        requireValues()[i10] = v10;
    }

    public V value(int i10) {
        return (V) requireValues()[i10];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public void accessEntry(int i10) {
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    @CanIgnoreReturnValue
    public int allocArrays() {
        b5.u.h0(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.metadata;
        int j10 = e5.j.j(i10);
        this.table = e5.j.a(j10);
        setHashTableMask(j10 - 1);
        this.entries = new int[i10];
        this.keys = new Object[i10];
        this.values = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.g(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        e5.j.g(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.containsKey(obj) : indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.size; i10++) {
            if (b5.r.a(obj, value(i10))) {
                return true;
            }
        }
        return false;
    }

    @CanIgnoreReturnValue
    @a5.d
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(key(firstEntryIndex), value(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    public Set<K> createKeySet() {
        return new f();
    }

    public Collection<V> createValues() {
        return new h();
    }

    @CheckForNull
    @a5.d
    public Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.entrySet().iterator() : new b();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return value(indexOf);
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i10) {
        b5.u.e(i10 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.g(i10, 1, 1073741823);
    }

    public void insertEntry(int i10, @d1 K k10, @d1 V v10, int i11, int i12) {
        setEntry(i10, e5.j.d(i11, 0, i12));
        setKey(i10, k10);
        setValue(i10, v10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.keySet().iterator() : new a();
    }

    public void moveLastEntry(int i10, int i11) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int size = size();
        int i12 = size - 1;
        if (i10 >= i12) {
            requireKeys[i10] = null;
            requireValues[i10] = null;
            requireEntries[i10] = 0;
            return;
        }
        Object obj = requireKeys[i12];
        requireKeys[i10] = obj;
        requireValues[i10] = requireValues[i12];
        requireKeys[i12] = null;
        requireValues[i12] = null;
        requireEntries[i10] = requireEntries[i12];
        requireEntries[i12] = 0;
        int d10 = s0.d(obj) & i11;
        int h10 = e5.j.h(requireTable, d10);
        if (h10 == size) {
            e5.j.i(requireTable, d10, i10 + 1);
            return;
        }
        while (true) {
            int i13 = h10 - 1;
            int i14 = requireEntries[i13];
            int c10 = e5.j.c(i14, i11);
            if (c10 == size) {
                requireEntries[i13] = e5.j.d(i14, i10 + 1, i11);
                return;
            }
            h10 = c10;
        }
    }

    @a5.d
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 K k10, @d1 V v10) {
        int resizeTable;
        int i10;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k10, v10);
        }
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int i11 = this.size;
        int i12 = i11 + 1;
        int d10 = s0.d(k10);
        int hashTableMask = hashTableMask();
        int i13 = d10 & hashTableMask;
        int h10 = e5.j.h(requireTable(), i13);
        if (h10 != 0) {
            int b10 = e5.j.b(d10, hashTableMask);
            int i14 = 0;
            while (true) {
                int i15 = h10 - 1;
                int i16 = requireEntries[i15];
                if (e5.j.b(i16, hashTableMask) == b10 && b5.r.a(k10, requireKeys[i15])) {
                    V v11 = (V) requireValues[i15];
                    requireValues[i15] = v10;
                    accessEntry(i15);
                    return v11;
                }
                int c10 = e5.j.c(i16, hashTableMask);
                i14++;
                if (c10 != 0) {
                    h10 = c10;
                } else {
                    if (i14 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k10, v10);
                    }
                    if (i12 > hashTableMask) {
                        resizeTable = resizeTable(hashTableMask, e5.j.e(hashTableMask), d10, i11);
                    } else {
                        requireEntries[i15] = e5.j.d(i16, i12, hashTableMask);
                    }
                }
            }
        } else if (i12 > hashTableMask) {
            resizeTable = resizeTable(hashTableMask, e5.j.e(hashTableMask), d10, i11);
            i10 = resizeTable;
        } else {
            e5.j.i(requireTable(), i13, i12);
            i10 = hashTableMask;
        }
        resizeMeMaybe(i12);
        insertEntry(i11, k10, v10, d10, i10);
        this.size = i12;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v10 = (V) removeHelper(obj);
        if (v10 == NOT_FOUND) {
            return null;
        }
        return v10;
    }

    public void resizeEntries(int i10) {
        this.entries = Arrays.copyOf(requireEntries(), i10);
        this.keys = Arrays.copyOf(requireKeys(), i10);
        this.values = Arrays.copyOf(requireValues(), i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.putAll(delegateOrNull);
            this.table = createHashFloodingResistantDelegate;
            return;
        }
        int i10 = this.size;
        if (i10 < requireEntries().length) {
            resizeEntries(i10);
        }
        int j10 = e5.j.j(i10);
        int hashTableMask = hashTableMask();
        if (j10 < hashTableMask) {
            resizeTable(hashTableMask, j10, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.values().iterator() : new c();
    }

    public CompactHashMap(int i10) {
        init(i10);
    }

    public abstract class e<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9395b;

        /* renamed from: c */
        public int f9396c;

        /* renamed from: d */
        public int f9397d;

        public e() {
            this.f9395b = CompactHashMap.this.metadata;
            this.f9396c = CompactHashMap.this.firstEntryIndex();
            this.f9397d = -1;
        }

        public final void a() {
            if (CompactHashMap.this.metadata != this.f9395b) {
                throw new ConcurrentModificationException();
            }
        }

        @d1
        public abstract T b(int i10);

        public void c() {
            this.f9395b += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9396c >= 0;
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f9396c;
            this.f9397d = i10;
            T b10 = b(i10);
            this.f9396c = CompactHashMap.this.getSuccessor(this.f9396c);
            return b10;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e5.i.e(this.f9397d >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.f9397d));
            this.f9396c = CompactHashMap.this.adjustAfterRemove(this.f9396c, this.f9397d);
            this.f9397d = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
