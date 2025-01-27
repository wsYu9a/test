package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.martian.libmars.activity.PermissionActivity;
import e5.u0;
import e5.z1;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());

    /* renamed from: com.google.common.collect.ImmutableSortedMap$1EntrySet */
    public class C1EntrySet extends ImmutableMapEntrySet<K, V> {

        /* renamed from: com.google.common.collect.ImmutableSortedMap$1EntrySet$1 */
        public class AnonymousClass1 extends ImmutableList<Map.Entry<K, V>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return ImmutableSortedMap.this.size();
            }

            @Override // java.util.List
            public Map.Entry<K, V> get(int i10) {
                return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
            }
        }

        public C1EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                public AnonymousClass1() {
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return ImmutableSortedMap.this.size();
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i10) {
                    return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        public ImmutableMap<K, V> map() {
            return ImmutableSortedMap.this;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
        public z1<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public b<K, V> makeBuilder(int i10) {
            return new b<>(this.comparator);
        }
    }

    public class a implements Comparator<Map.Entry<K, V>> {

        /* renamed from: b */
        public final /* synthetic */ Comparator f9490b;

        public a(Comparator comparator) {
            this.f9490b = comparator;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(@CheckForNull Map.Entry<K, V> entry, @CheckForNull Map.Entry<K, V> entry2) {
            Objects.requireNonNull(entry);
            Objects.requireNonNull(entry2);
            return this.f9490b.compare(entry.getKey(), entry2.getKey());
        }
    }

    public static class b<K, V> extends ImmutableMap.b<K, V> {

        /* renamed from: f */
        public transient Object[] f9491f;

        /* renamed from: g */
        public transient Object[] f9492g;

        /* renamed from: h */
        public final Comparator<? super K> f9493h;

        public b(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        public final void f(int i10) {
            Object[] objArr = this.f9491f;
            if (i10 > objArr.length) {
                int f10 = ImmutableCollection.b.f(objArr.length, i10);
                this.f9491f = Arrays.copyOf(this.f9491f, f10);
                this.f9492g = Arrays.copyOf(this.f9492g, f10);
            }
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: n */
        public ImmutableSortedMap<K, V> a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @DoNotCall
        @Deprecated
        /* renamed from: o */
        public final ImmutableSortedMap<K, V> c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: p */
        public ImmutableSortedMap<K, V> d() {
            int i10 = this.f9453c;
            if (i10 == 0) {
                return ImmutableSortedMap.emptyMap(this.f9493h);
            }
            if (i10 == 1) {
                Comparator<? super K> comparator = this.f9493h;
                Object obj = this.f9491f[0];
                Objects.requireNonNull(obj);
                Object obj2 = this.f9492g[0];
                Objects.requireNonNull(obj2);
                return ImmutableSortedMap.of(comparator, obj, obj2);
            }
            Object[] copyOf = Arrays.copyOf(this.f9491f, i10);
            Arrays.sort(copyOf, this.f9493h);
            Object[] objArr = new Object[this.f9453c];
            for (int i11 = 0; i11 < this.f9453c; i11++) {
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    if (this.f9493h.compare(copyOf[i12], copyOf[i11]) == 0) {
                        String valueOf = String.valueOf(copyOf[i12]);
                        String valueOf2 = String.valueOf(copyOf[i11]);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
                        sb2.append("keys required to be distinct but compared as equal: ");
                        sb2.append(valueOf);
                        sb2.append(" and ");
                        sb2.append(valueOf2);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                Object obj3 = this.f9491f[i11];
                Objects.requireNonNull(obj3);
                int binarySearch = Arrays.binarySearch(copyOf, obj3, this.f9493h);
                Object obj4 = this.f9492g[i11];
                Objects.requireNonNull(obj4);
                objArr[binarySearch] = obj4;
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.f9493h), ImmutableList.asImmutableList(objArr));
        }

        @CanIgnoreReturnValue
        public b<K, V> q(b<K, V> bVar) {
            f(this.f9453c + bVar.f9453c);
            System.arraycopy(bVar.f9491f, 0, this.f9491f, this.f9453c, bVar.f9453c);
            System.arraycopy(bVar.f9492g, 0, this.f9492g, this.f9453c, bVar.f9453c);
            this.f9453c += bVar.f9453c;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @a5.a
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        @CanIgnoreReturnValue
        /* renamed from: r */
        public final b<K, V> h(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: s */
        public b<K, V> i(K k10, V v10) {
            f(this.f9453c + 1);
            e5.i.a(k10, v10);
            Object[] objArr = this.f9491f;
            int i10 = this.f9453c;
            objArr[i10] = k10;
            this.f9492g[i10] = v10;
            this.f9453c = i10 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: t */
        public b<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @a5.a
        /* renamed from: u */
        public b<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.k(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: v */
        public b<K, V> l(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        public b(Comparator<? super K> comparator, int i10) {
            this.f9493h = (Comparator) b5.u.E(comparator);
            this.f9491f = new Object[i10];
            this.f9492g = new Object[i10];
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z10 = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z10 = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z10 = true;
            }
        }
        if (z10 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z10, map.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        return Ordering.natural().equals(comparator) ? of() : new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    private ImmutableSortedMap<K, V> getSubMap(int i10, int i11) {
        return (i10 == 0 && i11 == size()) ? this : i10 == i11 ? emptyMap(comparator()) : new ImmutableSortedMap<>(this.keySet.getSubSet(i10, i11), this.valueList.subList(i10, i11));
    }

    public static <K extends Comparable<?>, V> b<K, V> naturalOrder() {
        return new b<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    public static <K, V> b<K, V> orderedBy(Comparator<K> comparator) {
        return new b<>(comparator);
    }

    public static <K extends Comparable<?>, V> b<K, V> reverseOrder() {
        return new b<>(Ordering.natural().reverse());
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K k10) {
        return (K) Maps.T(ceilingEntry(k10));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet

            /* renamed from: com.google.common.collect.ImmutableSortedMap$1EntrySet$1 */
            public class AnonymousClass1 extends ImmutableList<Map.Entry<K, V>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return ImmutableSortedMap.this.size();
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i10) {
                    return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
                }
            }

            public C1EntrySet() {
            }

            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    public AnonymousClass1() {
                    }

                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean isPartialView() {
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    @Override // java.util.List
                    public Map.Entry<K, V> get(int i10) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
            public z1<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K k10) {
        return (K) Maps.T(floorEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z10) {
        return headMap((ImmutableSortedMap<K, V>) obj, z10);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K k10) {
        return (K) Maps.T(higherEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K k10) {
        return (K) Maps.T(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        return subMap((boolean) obj, z10, (boolean) obj2, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z10) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z10);
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, @CheckForNull ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z10, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) u0.R(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z10, entryArr, entryArr.length);
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return of(Ordering.natural(), comparable, obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        return immutableSortedMap == null ? isEmpty() ? emptyMap(Ordering.from(comparator()).reverse()) : new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this) : immutableSortedMap;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, e5.g
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) b5.u.E(comparator));
    }

    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k10, V v10) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k10), (Comparator) b5.u.E(comparator)), ImmutableList.of(v10));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k10, K k11) {
        return subMap((boolean) k10, true, (boolean) k11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, true);
    }

    @a5.a
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z10, Map.Entry<K, V>[] entryArr, int i10) {
        if (i10 == 0) {
            return emptyMap(comparator);
        }
        if (i10 != 1) {
            Object[] objArr = new Object[i10];
            Object[] objArr2 = new Object[i10];
            if (z10) {
                for (int i11 = 0; i11 < i10; i11++) {
                    Map.Entry<K, V> entry = entryArr[i11];
                    Objects.requireNonNull(entry);
                    Map.Entry<K, V> entry2 = entry;
                    K key = entry2.getKey();
                    V value = entry2.getValue();
                    e5.i.a(key, value);
                    objArr[i11] = key;
                    objArr2[i11] = value;
                }
            } else {
                Arrays.sort(entryArr, 0, i10, new a(comparator));
                Map.Entry<K, V> entry3 = entryArr[0];
                Objects.requireNonNull(entry3);
                Map.Entry<K, V> entry4 = entry3;
                Object key2 = entry4.getKey();
                objArr[0] = key2;
                V value2 = entry4.getValue();
                objArr2[0] = value2;
                e5.i.a(objArr[0], value2);
                int i12 = 1;
                while (i12 < i10) {
                    Map.Entry<K, V> entry5 = entryArr[i12 - 1];
                    Objects.requireNonNull(entry5);
                    Map.Entry<K, V> entry6 = entry5;
                    Map.Entry<K, V> entry7 = entryArr[i12];
                    Objects.requireNonNull(entry7);
                    Map.Entry<K, V> entry8 = entry7;
                    Object key3 = entry8.getKey();
                    V value3 = entry8.getValue();
                    e5.i.a(key3, value3);
                    objArr[i12] = key3;
                    objArr2[i12] = value3;
                    ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, PermissionActivity.f12046p, entry6, entry8);
                    i12++;
                    key2 = key3;
                }
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
        }
        Map.Entry<K, V> entry9 = entryArr[0];
        Objects.requireNonNull(entry9);
        Map.Entry<K, V> entry10 = entry9;
        return of(comparator, entry10.getKey(), entry10.getValue());
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k10, boolean z10) {
        return getSubMap(0, this.keySet.headIndex(b5.u.E(k10), z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
        b5.u.E(k10);
        b5.u.E(k11);
        b5.u.y(comparator().compare(k10, k11) <= 0, "expected fromKey <= toKey but %s > %s", k10, k11);
        return headMap((ImmutableSortedMap<K, V>) k11, z11).tailMap((ImmutableSortedMap<K, V>) k10, z10);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k10, boolean z10) {
        return getSubMap(this.keySet.tailIndex(b5.u.E(k10), z10), size());
    }

    @a5.a
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return fromEntries((Comparator) b5.u.E(comparator), false, iterable);
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5), ImmutableMap.entryOf(comparable6, obj6));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5), ImmutableMap.entryOf(comparable6, obj6), ImmutableMap.entryOf(comparable7, obj7));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5), ImmutableMap.entryOf(comparable6, obj6), ImmutableMap.entryOf(comparable7, obj7), ImmutableMap.entryOf(comparable8, obj8));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5), ImmutableMap.entryOf(comparable6, obj6), ImmutableMap.entryOf(comparable7, obj7), ImmutableMap.entryOf(comparable8, obj8), ImmutableMap.entryOf(comparable9, obj9));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9, Comparable comparable10, Object obj10) {
        return fromEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5), ImmutableMap.entryOf(comparable6, obj6), ImmutableMap.entryOf(comparable7, obj7), ImmutableMap.entryOf(comparable8, obj8), ImmutableMap.entryOf(comparable9, obj9), ImmutableMap.entryOf(comparable10, obj10));
    }
}
