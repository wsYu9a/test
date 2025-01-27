package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import e5.z1;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
@DoNotMock("Use ImmutableMap.of or another implementation")
/* loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<K> keySet;

    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableCollection<V> values;

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {

        /* renamed from: com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl */
        public class C1EntrySetImpl extends ImmutableMapEntrySet<K, V> {
            public C1EntrySetImpl() {
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> map() {
                return IteratorBasedImmutableMap.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
            public z1<Map.Entry<K, V>> iterator() {
                return IteratorBasedImmutableMap.this.entryIterator();
            }
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                public C1EntrySetImpl() {
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
                public z1<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract z1<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, e5.g
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        public class a extends z1<Map.Entry<K, ImmutableSet<V>>> {

            /* renamed from: b */
            public final /* synthetic */ Iterator f9448b;

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a */
            public class C0268a extends e5.b<K, ImmutableSet<V>> {

                /* renamed from: b */
                public final /* synthetic */ Map.Entry f9449b;

                public C0268a(a aVar, Map.Entry entry) {
                    this.f9449b = entry;
                }

                @Override // e5.b, java.util.Map.Entry
                /* renamed from: a */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f9449b.getValue());
                }

                @Override // e5.b, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f9449b.getKey();
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.f9448b = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0268a(this, (Map.Entry) this.f9448b.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9448b.hasNext();
            }
        }

        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public z1<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public ImmutableSet<V> get(@CheckForNull Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    public static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            z1<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i10] = next.getKey();
                objArr2[i10] = next.getValue();
                i10++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            b<K, V> makeBuilder = makeBuilder(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                makeBuilder.i(objArr[i10], objArr2[i10]);
            }
            return makeBuilder.d();
        }

        public b<K, V> makeBuilder(int i10) {
            return new b<>(i10);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            b<K, V> makeBuilder = makeBuilder(immutableSet.size());
            z1 it = immutableSet.iterator();
            z1 it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                makeBuilder.i(it.next(), it2.next());
            }
            return makeBuilder.d();
        }
    }

    public class a extends z1<K> {

        /* renamed from: b */
        public final /* synthetic */ z1 f9450b;

        public a(ImmutableMap immutableMap, z1 z1Var) {
            this.f9450b = z1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9450b.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f9450b.next()).getKey();
        }
    }

    @DoNotMock
    public static class b<K, V> {

        /* renamed from: a */
        @CheckForNull
        public Comparator<? super V> f9451a;

        /* renamed from: b */
        public Object[] f9452b;

        /* renamed from: c */
        public int f9453c;

        /* renamed from: d */
        public boolean f9454d;

        /* renamed from: e */
        public a f9455e;

        public static final class a {

            /* renamed from: a */
            public final Object f9456a;

            /* renamed from: b */
            public final Object f9457b;

            /* renamed from: c */
            public final Object f9458c;

            public a(Object obj, Object obj2, Object obj3) {
                this.f9456a = obj;
                this.f9457b = obj2;
                this.f9458c = obj3;
            }

            public IllegalArgumentException a() {
                String valueOf = String.valueOf(this.f9456a);
                String valueOf2 = String.valueOf(this.f9457b);
                String valueOf3 = String.valueOf(this.f9456a);
                String valueOf4 = String.valueOf(this.f9458c);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb2.append("Multiple entries with same key: ");
                sb2.append(valueOf);
                sb2.append("=");
                sb2.append(valueOf2);
                sb2.append(" and ");
                sb2.append(valueOf3);
                sb2.append("=");
                sb2.append(valueOf4);
                return new IllegalArgumentException(sb2.toString());
            }
        }

        public b() {
            this(4);
        }

        private void f(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f9452b;
            if (i11 > objArr.length) {
                this.f9452b = Arrays.copyOf(objArr, ImmutableCollection.b.f(objArr.length, i11));
                this.f9454d = false;
            }
        }

        public static <V> void m(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, Ordering.from(comparator).onResultOf(Maps.N0()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return d();
        }

        public final ImmutableMap<K, V> b(boolean z10) {
            Object[] objArr;
            a aVar;
            a aVar2;
            if (z10 && (aVar2 = this.f9455e) != null) {
                throw aVar2.a();
            }
            int i10 = this.f9453c;
            if (this.f9451a == null) {
                objArr = this.f9452b;
            } else {
                if (this.f9454d) {
                    this.f9452b = Arrays.copyOf(this.f9452b, i10 * 2);
                }
                objArr = this.f9452b;
                if (!z10) {
                    objArr = g(objArr, this.f9453c);
                    if (objArr.length < this.f9452b.length) {
                        i10 = objArr.length >>> 1;
                    }
                }
                m(objArr, i10, this.f9451a);
            }
            this.f9454d = true;
            RegularImmutableMap create = RegularImmutableMap.create(i10, objArr, this);
            if (!z10 || (aVar = this.f9455e) == null) {
                return create;
            }
            throw aVar.a();
        }

        public ImmutableMap<K, V> c() {
            return b(false);
        }

        public ImmutableMap<K, V> d() {
            return b(true);
        }

        @CanIgnoreReturnValue
        public b<K, V> e(b<K, V> bVar) {
            b5.u.E(bVar);
            f(this.f9453c + bVar.f9453c);
            System.arraycopy(bVar.f9452b, 0, this.f9452b, this.f9453c * 2, bVar.f9453c * 2);
            this.f9453c += bVar.f9453c;
            return this;
        }

        public final Object[] g(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 += 2;
                    i12 += 2;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        @CanIgnoreReturnValue
        @a5.a
        public b<K, V> h(Comparator<? super V> comparator) {
            b5.u.h0(this.f9451a == null, "valueComparator was already set");
            this.f9451a = (Comparator) b5.u.F(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> i(K k10, V v10) {
            f(this.f9453c + 1);
            e5.i.a(k10, v10);
            Object[] objArr = this.f9452b;
            int i10 = this.f9453c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v10;
            this.f9453c = i10 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            return i(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @a5.a
        public b<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                f(this.f9453c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> l(Map<? extends K, ? extends V> map) {
            return k(map.entrySet());
        }

        public b(int i10) {
            this.f9452b = new Object[i10 * 2];
            this.f9453c = 0;
            this.f9454d = false;
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    @a5.a
    public static <K, V> b<K, V> builderWithExpectedSize(int i10) {
        e5.i.b(i10, "expectedSize");
        return new b<>(i10);
    }

    public static void checkNoConflict(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw conflictException(str, obj, obj2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + valueOf.length() + valueOf2.length());
        sb2.append("Multiple entries with same ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(valueOf);
        sb2.append(" and ");
        sb2.append(valueOf2);
        return new IllegalArgumentException(sb2.toString());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k10, V v10) {
        e5.i.a(k10, v10);
        return new AbstractMap.SimpleImmutableEntry(k10, v10);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return Maps.w(this, obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.k(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public z1<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.w0(this);
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10) {
        e5.i.a(k10, v10);
        return RegularImmutableMap.create(1, new Object[]{k10, v10});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map, e5.g
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        return RegularImmutableMap.create(2, new Object[]{k10, v10, k11, v11});
    }

    @a5.a
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.k(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        return RegularImmutableMap.create(3, new Object[]{k10, v10, k11, v11, k12, v12});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        return RegularImmutableMap.create(4, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        return RegularImmutableMap.create(5, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        return RegularImmutableMap.create(6, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        return RegularImmutableMap.create(7, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        return RegularImmutableMap.create(8, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        e5.i.a(k18, v18);
        return RegularImmutableMap.create(9, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        e5.i.a(k18, v18);
        e5.i.a(k19, v19);
        return RegularImmutableMap.create(10, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19});
    }
}
