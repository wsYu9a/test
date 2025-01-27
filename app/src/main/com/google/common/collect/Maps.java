package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.r;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import e5.a1;
import e5.d1;
import e5.p0;
import e5.u0;
import e5.v1;
import e5.z1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Maps {

    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final e5.g<A, B> bimap;

        public BiMapConverter(e5.g<A, B> gVar) {
            this.bimap = (e5.g) b5.u.E(gVar);
        }

        private static <X, Y> Y convert(e5.g<X, Y> gVar, X x10) {
            Y y10 = gVar.get(x10);
            b5.u.u(y10 != null, "No non-null mapping present for input: %s", x10);
            return y10;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b10) {
            return (A) convert(this.bimap.inverse(), b10);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a10) {
            return (B) convert(this.bimap, a10);
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.bimap);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
            sb2.append("Maps.asConverter(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public enum EntryFunction implements b5.n<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // b5.n
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // b5.n
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* renamed from: com.google.common.collect.Maps$EntryFunction$1 */
        public enum AnonymousClass1 extends EntryFunction {
            @Override // b5.n
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* renamed from: com.google.common.collect.Maps$EntryFunction$2 */
        public enum AnonymousClass2 extends EntryFunction {
            @Override // b5.n
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        /* synthetic */ EntryFunction(e eVar) {
            this();
        }
    }

    public static class UnmodifiableBiMap<K, V> extends com.google.common.collect.j<K, V> implements e5.g<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final e5.g<? extends K, ? extends V> delegate;

        @RetainedWith
        @CheckForNull
        e5.g<V, K> inverse;
        final Map<K, V> unmodifiableMap;

        @CheckForNull
        transient Set<V> values;

        public UnmodifiableBiMap(e5.g<? extends K, ? extends V> gVar, @CheckForNull e5.g<V, K> gVar2) {
            this.unmodifiableMap = Collections.unmodifiableMap(gVar);
            this.delegate = gVar;
            this.inverse = gVar2;
        }

        @Override // e5.g
        @CheckForNull
        public V forcePut(@d1 K k10, @d1 V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.g
        public e5.g<V, K> inverse() {
            e5.g<V, K> gVar = this.inverse;
            if (gVar != null) {
                return gVar;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.j, e5.l0
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.j, java.util.Map, e5.g
        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    @a5.c
    public static class UnmodifiableNavigableMap<K, V> extends com.google.common.collect.n<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;

        @CheckForNull
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@d1 K k10) {
            return Maps.M0(this.delegate.ceilingEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@d1 K k10) {
            return this.delegate.ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.O(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return Maps.M0(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(@d1 K k10) {
            return Maps.M0(this.delegate.floorEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@d1 K k10) {
            return this.delegate.floorKey(k10);
        }

        @Override // com.google.common.collect.n, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(@d1 K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(@d1 K k10) {
            return Maps.M0(this.delegate.higherEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@d1 K k10) {
            return this.delegate.higherKey(k10);
        }

        @Override // com.google.common.collect.j, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return Maps.M0(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@d1 K k10) {
            return Maps.M0(this.delegate.lowerEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@d1 K k10) {
            return this.delegate.lowerKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.O(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.n, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.n, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(@d1 K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@d1 K k10, boolean z10) {
            return Maps.L0(this.delegate.headMap(k10, z10));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return Maps.L0(this.delegate.subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@d1 K k10, boolean z10) {
            return Maps.L0(this.delegate.tailMap(k10, z10));
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        @Override // com.google.common.collect.n, com.google.common.collect.j, e5.l0
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    public class a<V1, V2> implements b5.n<V1, V2> {

        /* renamed from: b */
        public final /* synthetic */ r f9631b;

        /* renamed from: c */
        public final /* synthetic */ Object f9632c;

        public a(r rVar, Object obj) {
            this.f9631b = rVar;
            this.f9632c = obj;
        }

        @Override // b5.n
        @d1
        public V2 apply(@d1 V1 v12) {
            return (V2) this.f9631b.a(this.f9632c, v12);
        }
    }

    public static class a0<K, V> implements com.google.common.collect.r<K, V> {

        /* renamed from: a */
        public final Map<K, V> f9633a;

        /* renamed from: b */
        public final Map<K, V> f9634b;

        /* renamed from: c */
        public final Map<K, V> f9635c;

        /* renamed from: d */
        public final Map<K, r.a<V>> f9636d;

        public a0(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, r.a<V>> map4) {
            this.f9633a = Maps.K0(map);
            this.f9634b = Maps.K0(map2);
            this.f9635c = Maps.K0(map3);
            this.f9636d = Maps.K0(map4);
        }

        @Override // com.google.common.collect.r
        public Map<K, V> a() {
            return this.f9634b;
        }

        @Override // com.google.common.collect.r
        public Map<K, V> b() {
            return this.f9633a;
        }

        @Override // com.google.common.collect.r
        public Map<K, r.a<V>> c() {
            return this.f9636d;
        }

        @Override // com.google.common.collect.r
        public Map<K, V> d() {
            return this.f9635c;
        }

        @Override // com.google.common.collect.r
        public boolean e() {
            return this.f9633a.isEmpty() && this.f9634b.isEmpty() && this.f9636d.isEmpty();
        }

        @Override // com.google.common.collect.r
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.collect.r)) {
                return false;
            }
            com.google.common.collect.r rVar = (com.google.common.collect.r) obj;
            return b().equals(rVar.b()) && a().equals(rVar.a()) && d().equals(rVar.d()) && c().equals(rVar.c());
        }

        @Override // com.google.common.collect.r
        public int hashCode() {
            return b5.r.b(b(), a(), d(), c());
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder sb2 = new StringBuilder("not equal");
            if (!this.f9633a.isEmpty()) {
                sb2.append(": only on left=");
                sb2.append(this.f9633a);
            }
            if (!this.f9634b.isEmpty()) {
                sb2.append(": only on right=");
                sb2.append(this.f9634b);
            }
            if (!this.f9636d.isEmpty()) {
                sb2.append(": value differences=");
                sb2.append(this.f9636d);
            }
            return sb2.toString();
        }
    }

    public class b<K, V1, V2> implements b5.n<Map.Entry<K, V1>, V2> {

        /* renamed from: b */
        public final /* synthetic */ r f9637b;

        public b(r rVar) {
            this.f9637b = rVar;
        }

        @Override // b5.n
        @d1
        /* renamed from: a */
        public V2 apply(Map.Entry<K, V1> entry) {
            return (V2) this.f9637b.a(entry.getKey(), entry.getValue());
        }
    }

    @a5.c
    public static final class b0<K, V> extends com.google.common.collect.c<K, V> {

        /* renamed from: b */
        public final NavigableSet<K> f9638b;

        /* renamed from: c */
        public final b5.n<? super K, V> f9639c;

        public b0(NavigableSet<K> navigableSet, b5.n<? super K, V> nVar) {
            this.f9638b = (NavigableSet) b5.u.E(navigableSet);
            this.f9639c = (b5.n) b5.u.E(nVar);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<K, V>> a() {
            return Maps.m(this.f9638b, this.f9639c);
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<K, V>> c() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f9638b.clear();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.f9638b.comparator();
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.k(this.f9638b.descendingSet(), this.f9639c);
        }

        @Override // com.google.common.collect.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (com.google.common.collect.f.j(this.f9638b, obj)) {
                return this.f9639c.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@d1 K k10, boolean z10) {
            return Maps.k(this.f9638b.headSet(k10, z10), this.f9639c);
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Maps.l0(this.f9638b);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9638b.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return Maps.k(this.f9638b.subSet(k10, z10, k11, z11), this.f9639c);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@d1 K k10, boolean z10) {
            return Maps.k(this.f9638b.tailSet(k10, z10), this.f9639c);
        }
    }

    public class c<K, V2> extends e5.b<K, V2> {

        /* renamed from: b */
        public final /* synthetic */ Map.Entry f9640b;

        /* renamed from: c */
        public final /* synthetic */ r f9641c;

        public c(Map.Entry entry, r rVar) {
            this.f9640b = entry;
            this.f9641c = rVar;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getKey() {
            return (K) this.f9640b.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e5.b, java.util.Map.Entry
        @d1
        public V2 getValue() {
            return (V2) this.f9641c.a(this.f9640b.getKey(), this.f9640b.getValue());
        }
    }

    @a5.c
    public static class c0<K, V> extends e0<K, V> implements NavigableSet<K> {
        public c0(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.Maps.e0
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> b() {
            return (NavigableMap) this.f9685b;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@d1 K k10) {
            return a().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@d1 K k10) {
            return a().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@d1 K k10, boolean z10) {
            return a().headMap(k10, z10).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@d1 K k10) {
            return a().higherKey(k10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@d1 K k10) {
            return a().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Maps.T(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Maps.T(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return a().subMap(k10, z10, k11, z11).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@d1 K k10, boolean z10) {
            return a().tailMap(k10, z10).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.e0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(@d1 K k10) {
            return headSet(k10, false);
        }

        @Override // com.google.common.collect.Maps.e0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(@d1 K k10, @d1 K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Maps.e0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(@d1 K k10) {
            return tailSet(k10, true);
        }
    }

    public class d<K, V1, V2> implements b5.n<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* renamed from: b */
        public final /* synthetic */ r f9642b;

        public d(r rVar) {
            this.f9642b = rVar;
        }

        @Override // b5.n
        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.A0(this.f9642b, entry);
        }
    }

    public static class d0<K, V> extends o<K, V> implements SortedMap<K, V> {
        public d0(SortedSet<K> sortedSet, b5.n<? super K, V> nVar) {
            super(sortedSet, nVar);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return f().comparator();
        }

        @Override // java.util.SortedMap
        @d1
        public K firstKey() {
            return f().first();
        }

        @Override // com.google.common.collect.Maps.o
        /* renamed from: g */
        public SortedSet<K> f() {
            return (SortedSet) super.f();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@d1 K k10) {
            return Maps.l(f().headSet(k10), this.f9662f);
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return Maps.n0(f());
        }

        @Override // java.util.SortedMap
        @d1
        public K lastKey() {
            return f().last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
            return Maps.l(f().subSet(k10, k11), this.f9662f);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@d1 K k10) {
            return Maps.l(f().tailSet(k10), this.f9662f);
        }
    }

    public class e<K, V> extends v1<Map.Entry<K, V>, K> {
        public e(Iterator it) {
            super(it);
        }

        @Override // e5.v1
        @d1
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    public static class e0<K, V> extends z<K, V> implements SortedSet<K> {
        public e0(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // com.google.common.collect.Maps.z
        public SortedMap<K, V> b() {
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
            return new e0(b().headMap(k10));
        }

        @Override // java.util.SortedSet
        @d1
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(@d1 K k10, @d1 K k11) {
            return new e0(b().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(@d1 K k10) {
            return new e0(b().tailMap(k10));
        }
    }

    public class f<K, V> extends v1<Map.Entry<K, V>, V> {
        public f(Iterator it) {
            super(it);
        }

        @Override // e5.v1
        @d1
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    public static class f0<K, V> extends a0<K, V> implements com.google.common.collect.x<K, V> {
        public f0(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, r.a<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.Maps.a0, com.google.common.collect.r
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        @Override // com.google.common.collect.Maps.a0, com.google.common.collect.r
        public SortedMap<K, V> b() {
            return (SortedMap) super.b();
        }

        @Override // com.google.common.collect.Maps.a0, com.google.common.collect.r
        public SortedMap<K, r.a<V>> c() {
            return (SortedMap) super.c();
        }

        @Override // com.google.common.collect.Maps.a0, com.google.common.collect.r
        public SortedMap<K, V> d() {
            return (SortedMap) super.d();
        }
    }

    public class g<K, V> extends v1<K, Map.Entry<K, V>> {

        /* renamed from: c */
        public final /* synthetic */ b5.n f9643c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Iterator it, b5.n nVar) {
            super(it);
            this.f9643c = nVar;
        }

        @Override // e5.v1
        /* renamed from: b */
        public Map.Entry<K, V> a(@d1 K k10) {
            return Maps.O(k10, this.f9643c.apply(k10));
        }
    }

    public static class g0<K, V1, V2> extends y<K, V2> {

        /* renamed from: b */
        public final Map<K, V1> f9644b;

        /* renamed from: c */
        public final r<? super K, ? super V1, V2> f9645c;

        public g0(Map<K, V1> map, r<? super K, ? super V1, V2> rVar) {
            this.f9644b = (Map) b5.u.E(map);
            this.f9645c = (r) b5.u.E(rVar);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.c0(this.f9644b.entrySet().iterator(), Maps.g(this.f9645c));
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f9644b.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9644b.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V2 get(@CheckForNull Object obj) {
            V1 v12 = this.f9644b.get(obj);
            if (v12 != null || this.f9644b.containsKey(obj)) {
                return this.f9645c.a(obj, (Object) a1.a(v12));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f9644b.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V2 remove(@CheckForNull Object obj) {
            if (this.f9644b.containsKey(obj)) {
                return this.f9645c.a(obj, (Object) a1.a(this.f9644b.remove(obj)));
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9644b.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new m0(this);
        }
    }

    @a5.c
    public static class h0<K, V1, V2> extends i0<K, V1, V2> implements NavigableMap<K, V2> {
        public h0(NavigableMap<K, V1> navigableMap, r<? super K, ? super V1, V2> rVar) {
            super(navigableMap, rVar);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> ceilingEntry(@d1 K k10) {
            return i(c().ceilingEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@d1 K k10) {
            return c().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return c().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return Maps.y0(c().descendingMap(), this.f9645c);
        }

        @Override // com.google.common.collect.Maps.i0
        /* renamed from: e */
        public NavigableMap<K, V1> c() {
            return (NavigableMap) super.c();
        }

        @Override // com.google.common.collect.Maps.i0, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<K, V2> headMap(@d1 K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> firstEntry() {
            return i(c().firstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> floorEntry(@d1 K k10) {
            return i(c().floorEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@d1 K k10) {
            return c().floorKey(k10);
        }

        @Override // com.google.common.collect.Maps.i0, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<K, V2> subMap(@d1 K k10, @d1 K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Maps.i0, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<K, V2> tailMap(@d1 K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> higherEntry(@d1 K k10) {
            return i(c().higherEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@d1 K k10) {
            return c().higherKey(k10);
        }

        @CheckForNull
        public final Map.Entry<K, V2> i(@CheckForNull Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.A0(this.f9645c, entry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> lastEntry() {
            return i(c().lastEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> lowerEntry(@d1 K k10) {
            return i(c().lowerEntry(k10));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@d1 K k10) {
            return c().lowerKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return c().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> pollFirstEntry() {
            return i(c().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> pollLastEntry() {
            return i(c().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(@d1 K k10, boolean z10) {
            return Maps.y0(c().headMap(k10, z10), this.f9645c);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return Maps.y0(c().subMap(k10, z10, k11, z11), this.f9645c);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(@d1 K k10, boolean z10) {
            return Maps.y0(c().tailMap(k10, z10), this.f9645c);
        }
    }

    public static class i0<K, V1, V2> extends g0<K, V1, V2> implements SortedMap<K, V2> {
        public i0(SortedMap<K, V1> sortedMap, r<? super K, ? super V1, V2> rVar) {
            super(sortedMap, rVar);
        }

        public SortedMap<K, V1> c() {
            return (SortedMap) this.f9644b;
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedMap
        @d1
        public K firstKey() {
            return c().firstKey();
        }

        public SortedMap<K, V2> headMap(@d1 K k10) {
            return Maps.z0(c().headMap(k10), this.f9645c);
        }

        @Override // java.util.SortedMap
        @d1
        public K lastKey() {
            return c().lastKey();
        }

        public SortedMap<K, V2> subMap(@d1 K k10, @d1 K k11) {
            return Maps.z0(c().subMap(k10, k11), this.f9645c);
        }

        public SortedMap<K, V2> tailMap(@d1 K k10) {
            return Maps.z0(c().tailMap(k10), this.f9645c);
        }
    }

    public class j<E> extends com.google.common.collect.m<E> {

        /* renamed from: b */
        public final /* synthetic */ NavigableSet f9648b;

        public j(NavigableSet navigableSet) {
            this.f9648b = navigableSet;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Maps.l0(super.descendingSet());
        }

        @Override // com.google.common.collect.m, e5.p0, e5.n0, e5.y, e5.l0
        /* renamed from: e */
        public NavigableSet<E> delegate() {
            return this.f9648b;
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> headSet(@d1 E e10) {
            return Maps.n0(super.headSet(e10));
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
            return Maps.n0(super.subSet(e10, e11));
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> tailSet(@d1 E e10) {
            return Maps.n0(super.tailSet(e10));
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
            return Maps.l0(super.headSet(e10, z10));
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
            return Maps.l0(super.subSet(e10, z10, e11, z11));
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
            return Maps.l0(super.tailSet(e10, z10));
        }
    }

    public static class j0<K, V> extends e5.y<Map.Entry<K, V>> {

        /* renamed from: b */
        public final Collection<Map.Entry<K, V>> f9649b;

        public j0(Collection<Map.Entry<K, V>> collection) {
            this.f9649b = collection;
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.I0(this.f9649b.iterator());
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // e5.y, e5.l0
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f9649b;
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    public class k<K, V> extends e5.b<K, V> {

        /* renamed from: b */
        public final /* synthetic */ Map.Entry f9650b;

        public k(Map.Entry entry) {
            this.f9650b = entry;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getKey() {
            return (K) this.f9650b.getKey();
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V getValue() {
            return (V) this.f9650b.getValue();
        }
    }

    public static class k0<K, V> extends j0<K, V> implements Set<Map.Entry<K, V>> {
        public k0(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }
    }

    public class l<K, V> extends z1<Map.Entry<K, V>> {

        /* renamed from: b */
        public final /* synthetic */ Iterator f9651b;

        public l(Iterator it) {
            this.f9651b = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return Maps.H0((Map.Entry) this.f9651b.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9651b.hasNext();
        }
    }

    public static class l0<V> implements r.a<V> {

        /* renamed from: a */
        @d1
        public final V f9652a;

        /* renamed from: b */
        @d1
        public final V f9653b;

        public l0(@d1 V v10, @d1 V v11) {
            this.f9652a = v10;
            this.f9653b = v11;
        }

        public static <V> r.a<V> c(@d1 V v10, @d1 V v11) {
            return new l0(v10, v11);
        }

        @Override // com.google.common.collect.r.a
        @d1
        public V a() {
            return this.f9652a;
        }

        @Override // com.google.common.collect.r.a
        @d1
        public V b() {
            return this.f9653b;
        }

        @Override // com.google.common.collect.r.a
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof r.a)) {
                return false;
            }
            r.a aVar = (r.a) obj;
            return b5.r.a(this.f9652a, aVar.a()) && b5.r.a(this.f9653b, aVar.b());
        }

        @Override // com.google.common.collect.r.a
        public int hashCode() {
            return b5.r.b(this.f9652a, this.f9653b);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f9652a);
            String valueOf2 = String.valueOf(this.f9653b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length());
            sb2.append("(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public class m<K, V1, V2> implements r<K, V1, V2> {

        /* renamed from: a */
        public final /* synthetic */ b5.n f9654a;

        public m(b5.n nVar) {
            this.f9654a = nVar;
        }

        @Override // com.google.common.collect.Maps.r
        @d1
        public V2 a(@d1 K k10, @d1 V1 v12) {
            return (V2) this.f9654a.apply(v12);
        }
    }

    public static class m0<K, V> extends AbstractCollection<V> {

        /* renamed from: b */
        @Weak
        public final Map<K, V> f9655b;

        public m0(Map<K, V> map) {
            this.f9655b = (Map) b5.u.E(map);
        }

        public final Map<K, V> a() {
            return this.f9655b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.O0(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (b5.r.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) b5.u.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet u10 = Sets.u();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        u10.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(u10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) b5.u.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet u10 = Sets.u();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        u10.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(u10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static abstract class n<K, V> extends n0<K, V> {

        /* renamed from: e */
        public final Map<K, V> f9656e;

        /* renamed from: f */
        public final b5.v<? super Map.Entry<K, V>> f9657f;

        public n(Map<K, V> map, b5.v<? super Map.Entry<K, V>> vVar) {
            this.f9656e = map;
            this.f9657f = vVar;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9656e.containsKey(obj) && f(obj, this.f9656e.get(obj));
        }

        @Override // com.google.common.collect.Maps.n0
        public Collection<V> e() {
            return new x(this, this.f9656e, this.f9657f);
        }

        public boolean f(@CheckForNull Object obj, @d1 V v10) {
            return this.f9657f.apply(Maps.O(obj, v10));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v10 = this.f9656e.get(obj);
            if (v10 == null || !f(obj, v10)) {
                return null;
            }
            return v10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(@d1 K k10, @d1 V v10) {
            b5.u.d(f(k10, v10));
            return this.f9656e.put(k10, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                b5.u.d(f(entry.getKey(), entry.getValue()));
            }
            this.f9656e.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f9656e.remove(obj);
            }
            return null;
        }
    }

    @a5.b
    public static abstract class n0<K, V> extends AbstractMap<K, V> {

        /* renamed from: b */
        @CheckForNull
        public transient Set<Map.Entry<K, V>> f9658b;

        /* renamed from: c */
        @CheckForNull
        public transient Set<K> f9659c;

        /* renamed from: d */
        @CheckForNull
        public transient Collection<V> f9660d;

        public abstract Set<Map.Entry<K, V>> a();

        /* renamed from: c */
        public Set<K> i() {
            return new z(this);
        }

        public Collection<V> e() {
            return new m0(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f9658b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a10 = a();
            this.f9658b = a10;
            return a10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f9659c;
            if (set != null) {
                return set;
            }
            Set<K> i10 = i();
            this.f9659c = i10;
            return i10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f9660d;
            if (collection != null) {
                return collection;
            }
            Collection<V> e10 = e();
            this.f9660d = e10;
            return e10;
        }
    }

    public static class o<K, V> extends n0<K, V> {

        /* renamed from: e */
        public final Set<K> f9661e;

        /* renamed from: f */
        public final b5.n<? super K, V> f9662f;

        public class a extends q<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, V> a() {
                return o.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return Maps.m(o.this.f(), o.this.f9662f);
            }
        }

        public o(Set<K> set, b5.n<? super K, V> nVar) {
            this.f9661e = (Set) b5.u.E(set);
            this.f9662f = (b5.n) b5.u.E(nVar);
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: c */
        public Set<K> i() {
            return Maps.m0(f());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return f().contains(obj);
        }

        @Override // com.google.common.collect.Maps.n0
        public Collection<V> e() {
            return com.google.common.collect.f.m(this.f9661e, this.f9662f);
        }

        public Set<K> f() {
            return this.f9661e;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (com.google.common.collect.f.j(f(), obj)) {
                return this.f9662f.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (f().remove(obj)) {
                return this.f9662f.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return f().size();
        }
    }

    @a5.c
    public static abstract class p<K, V> extends com.google.common.collect.j<K, V> implements NavigableMap<K, V> {

        /* renamed from: b */
        @CheckForNull
        public transient Comparator<? super K> f9664b;

        /* renamed from: c */
        @CheckForNull
        public transient Set<Map.Entry<K, V>> f9665c;

        /* renamed from: d */
        @CheckForNull
        public transient NavigableSet<K> f9666d;

        public class a extends q<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, V> a() {
                return p.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return p.this.f();
            }
        }

        private static <T> Ordering<T> h(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@d1 K k10) {
            return g().floorEntry(k10);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@d1 K k10) {
            return g().floorKey(k10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f9664b;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = g().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering h10 = h(comparator2);
            this.f9664b = h10;
            return h10;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return g().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return g();
        }

        public Set<Map.Entry<K, V>> e() {
            return new a();
        }

        @Override // com.google.common.collect.j, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f9665c;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> e10 = e();
            this.f9665c = e10;
            return e10;
        }

        public abstract Iterator<Map.Entry<K, V>> f();

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return g().lastEntry();
        }

        @Override // java.util.SortedMap
        @d1
        public K firstKey() {
            return g().lastKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(@d1 K k10) {
            return g().ceilingEntry(k10);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@d1 K k10) {
            return g().ceilingKey(k10);
        }

        public abstract NavigableMap<K, V> g();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@d1 K k10, boolean z10) {
            return g().tailMap(k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(@d1 K k10) {
            return g().lowerEntry(k10);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@d1 K k10) {
            return g().lowerKey(k10);
        }

        @Override // com.google.common.collect.j, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return g().firstEntry();
        }

        @Override // java.util.SortedMap
        @d1
        public K lastKey() {
            return g().firstKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@d1 K k10) {
            return g().higherEntry(k10);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@d1 K k10) {
            return g().higherKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f9666d;
            if (navigableSet != null) {
                return navigableSet;
            }
            c0 c0Var = new c0(this);
            this.f9666d = c0Var;
            return c0Var;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return g().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return g().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return g().subMap(k11, z11, k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@d1 K k10, boolean z10) {
            return g().headMap(k10, z10).descendingMap();
        }

        @Override // e5.l0
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.j, java.util.Map, e5.g
        public Collection<V> values() {
            return new m0(this);
        }

        @Override // com.google.common.collect.j, e5.l0
        public final Map<K, V> delegate() {
            return g();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(@d1 K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(@d1 K k10) {
            return tailMap(k10, true);
        }
    }

    public static abstract class q<K, V> extends Sets.j<Map.Entry<K, V>> {
        public abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object p02 = Maps.p0(a(), key);
            if (b5.r.a(p02, entry.getValue())) {
                return p02 != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) b5.u.E(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.J(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) b5.u.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet y10 = Sets.y(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        y10.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(y10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    public interface r<K, V1, V2> {
        V2 a(@d1 K k10, @d1 V1 v12);
    }

    public static final class s<K, V> extends t<K, V> implements e5.g<K, V> {

        /* renamed from: h */
        @RetainedWith
        public final e5.g<V, K> f9668h;

        public class a implements b5.v<Map.Entry<V, K>> {

            /* renamed from: b */
            public final /* synthetic */ b5.v f9669b;

            public a(b5.v vVar) {
                this.f9669b = vVar;
            }

            @Override // b5.v
            /* renamed from: a */
            public boolean apply(Map.Entry<V, K> entry) {
                return this.f9669b.apply(Maps.O(entry.getValue(), entry.getKey()));
            }
        }

        public s(e5.g<K, V> gVar, b5.v<? super Map.Entry<K, V>> vVar) {
            super(gVar, vVar);
            this.f9668h = new s(gVar.inverse(), i(vVar), this);
        }

        public static <K, V> b5.v<Map.Entry<V, K>> i(b5.v<? super Map.Entry<K, V>> vVar) {
            return new a(vVar);
        }

        @Override // e5.g
        @CheckForNull
        public V forcePut(@d1 K k10, @d1 V v10) {
            b5.u.d(f(k10, v10));
            return j().forcePut(k10, v10);
        }

        @Override // e5.g
        public e5.g<V, K> inverse() {
            return this.f9668h;
        }

        public e5.g<K, V> j() {
            return (e5.g) this.f9656e;
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.f9668h.keySet();
        }

        public s(e5.g<K, V> gVar, b5.v<? super Map.Entry<K, V>> vVar, e5.g<V, K> gVar2) {
            super(gVar, vVar);
            this.f9668h = gVar2;
        }
    }

    public static class t<K, V> extends n<K, V> {

        /* renamed from: g */
        public final Set<Map.Entry<K, V>> f9670g;

        public class a extends e5.n0<Map.Entry<K, V>> {

            /* renamed from: com.google.common.collect.Maps$t$a$a */
            public class C0269a extends v1<Map.Entry<K, V>, Map.Entry<K, V>> {

                /* renamed from: com.google.common.collect.Maps$t$a$a$a */
                public class C0270a extends e5.j0<K, V> {

                    /* renamed from: b */
                    public final /* synthetic */ Map.Entry f9673b;

                    public C0270a(Map.Entry entry) {
                        this.f9673b = entry;
                    }

                    @Override // e5.j0, e5.l0
                    /* renamed from: e */
                    public Map.Entry<K, V> delegate() {
                        return this.f9673b;
                    }

                    @Override // e5.j0, java.util.Map.Entry
                    @d1
                    public V setValue(@d1 V v10) {
                        b5.u.d(t.this.f(getKey(), v10));
                        return (V) super.setValue(v10);
                    }
                }

                public C0269a(Iterator it) {
                    super(it);
                }

                @Override // e5.v1
                /* renamed from: b */
                public Map.Entry<K, V> a(Map.Entry<K, V> entry) {
                    return new C0270a(entry);
                }
            }

            public a() {
            }

            @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new C0269a(t.this.f9670g.iterator());
            }

            public /* synthetic */ a(t tVar, e eVar) {
                this();
            }

            @Override // e5.n0, e5.y, e5.l0
            public Set<Map.Entry<K, V>> delegate() {
                return t.this.f9670g;
            }
        }

        public class b extends z<K, V> {
            public b() {
                super(t.this);
            }

            @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!t.this.containsKey(obj)) {
                    return false;
                }
                t.this.f9656e.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                t tVar = t.this;
                return t.g(tVar.f9656e, tVar.f9657f, collection);
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                t tVar = t.this;
                return t.h(tVar.f9656e, tVar.f9657f, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.s(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) Lists.s(iterator()).toArray(tArr);
            }
        }

        public t(Map<K, V> map, b5.v<? super Map.Entry<K, V>> vVar) {
            super(map, vVar);
            this.f9670g = Sets.i(map.entrySet(), this.f9657f);
        }

        public static <K, V> boolean g(Map<K, V> map, b5.v<? super Map.Entry<K, V>> vVar, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (vVar.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        public static <K, V> boolean h(Map<K, V> map, b5.v<? super Map.Entry<K, V>> vVar, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (vVar.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, V>> a() {
            return new a(this, null);
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: c */
        public Set<K> i() {
            return new b();
        }
    }

    @a5.c
    public static class u<K, V> extends com.google.common.collect.c<K, V> {

        /* renamed from: b */
        public final NavigableMap<K, V> f9676b;

        /* renamed from: c */
        public final b5.v<? super Map.Entry<K, V>> f9677c;

        /* renamed from: d */
        public final Map<K, V> f9678d;

        public class a extends c0<K, V> {
            public a(NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return t.g(u.this.f9676b, u.this.f9677c, collection);
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return t.h(u.this.f9676b, u.this.f9677c, collection);
            }
        }

        public u(NavigableMap<K, V> navigableMap, b5.v<? super Map.Entry<K, V>> vVar) {
            this.f9676b = (NavigableMap) b5.u.E(navigableMap);
            this.f9677c = vVar;
            this.f9678d = new t(navigableMap, vVar);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<K, V>> a() {
            return Iterators.x(this.f9676b.entrySet().iterator(), this.f9677c);
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<K, V>> c() {
            return Iterators.x(this.f9676b.descendingMap().entrySet().iterator(), this.f9677c);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f9678d.clear();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.f9676b.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9678d.containsKey(obj);
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.z(this.f9676b.descendingMap(), this.f9677c);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return this.f9678d.entrySet();
        }

        @Override // com.google.common.collect.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return this.f9678d.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@d1 K k10, boolean z10) {
            return Maps.z(this.f9676b.headMap(k10, z10), this.f9677c);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !u0.c(this.f9676b.entrySet(), this.f9677c);
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new a(this);
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) u0.I(this.f9676b.entrySet(), this.f9677c);
        }

        @Override // com.google.common.collect.c, java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) u0.I(this.f9676b.descendingMap().entrySet(), this.f9677c);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(@d1 K k10, @d1 V v10) {
            return this.f9678d.put(k10, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f9678d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return this.f9678d.remove(obj);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9678d.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@d1 K k10, boolean z10, @d1 K k11, boolean z11) {
            return Maps.z(this.f9676b.subMap(k10, z10, k11, z11), this.f9677c);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@d1 K k10, boolean z10) {
            return Maps.z(this.f9676b.tailMap(k10, z10), this.f9677c);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new x(this, this.f9676b, this.f9677c);
        }
    }

    public static class v<K, V> extends t<K, V> implements SortedMap<K, V> {

        public class a extends t<K, V>.b implements SortedSet<K> {
            public a() {
                super();
            }

            @Override // java.util.SortedSet
            @CheckForNull
            public Comparator<? super K> comparator() {
                return v.this.k().comparator();
            }

            @Override // java.util.SortedSet
            @d1
            public K first() {
                return (K) v.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(@d1 K k10) {
                return (SortedSet) v.this.headMap(k10).keySet();
            }

            @Override // java.util.SortedSet
            @d1
            public K last() {
                return (K) v.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(@d1 K k10, @d1 K k11) {
                return (SortedSet) v.this.subMap(k10, k11).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(@d1 K k10) {
                return (SortedSet) v.this.tailMap(k10).keySet();
            }
        }

        public v(SortedMap<K, V> sortedMap, b5.v<? super Map.Entry<K, V>> vVar) {
            super(sortedMap, vVar);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedMap
        @d1
        public K firstKey() {
            return keySet().iterator().next();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@d1 K k10) {
            return new v(k().headMap(k10), this.f9657f);
        }

        @Override // com.google.common.collect.Maps.t, com.google.common.collect.Maps.n0
        public SortedSet<K> i() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        /* renamed from: j */
        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        public SortedMap<K, V> k() {
            return (SortedMap) this.f9656e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        @d1
        public K lastKey() {
            SortedMap<K, V> k10 = k();
            while (true) {
                K lastKey = k10.lastKey();
                if (f(lastKey, a1.a(this.f9656e.get(lastKey)))) {
                    return lastKey;
                }
                k10 = k().headMap(lastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@d1 K k10, @d1 K k11) {
            return new v(k().subMap(k10, k11), this.f9657f);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@d1 K k10) {
            return new v(k().tailMap(k10), this.f9657f);
        }
    }

    public static class w<K, V> extends n<K, V> {

        /* renamed from: g */
        public final b5.v<? super K> f9681g;

        public w(Map<K, V> map, b5.v<? super K> vVar, b5.v<? super Map.Entry<K, V>> vVar2) {
            super(map, vVar2);
            this.f9681g = vVar;
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, V>> a() {
            return Sets.i(this.f9656e.entrySet(), this.f9657f);
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: c */
        public Set<K> i() {
            return Sets.i(this.f9656e.keySet(), this.f9681g);
        }

        @Override // com.google.common.collect.Maps.n, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9656e.containsKey(obj) && this.f9681g.apply(obj);
        }
    }

    public static final class x<K, V> extends m0<K, V> {

        /* renamed from: c */
        public final Map<K, V> f9682c;

        /* renamed from: d */
        public final b5.v<? super Map.Entry<K, V>> f9683d;

        public x(Map<K, V> map, Map<K, V> map2, b5.v<? super Map.Entry<K, V>> vVar) {
            super(map);
            this.f9682c = map2;
            this.f9683d = vVar;
        }

        @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            Iterator<Map.Entry<K, V>> it = this.f9682c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f9683d.apply(next) && b5.r.a(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f9682c.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f9683d.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f9682c.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f9683d.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.s(iterator()).toArray(tArr);
        }
    }

    public static abstract class y<K, V> extends AbstractMap<K, V> {

        public class a extends q<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, V> a() {
                return y.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return y.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.h(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    public static class z<K, V> extends Sets.j<K> {

        /* renamed from: b */
        @Weak
        public final Map<K, V> f9685b;

        public z(Map<K, V> map) {
            this.f9685b = (Map) b5.u.E(map);
        }

        /* renamed from: a */
        public Map<K, V> b() {
            return this.f9685b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.S(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    public static <K, V> SortedMap<K, V> A(SortedMap<K, V> sortedMap, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(vVar);
        return sortedMap instanceof v ? E((v) sortedMap, vVar) : new v((SortedMap) b5.u.E(sortedMap), vVar);
    }

    public static <V2, K, V1> Map.Entry<K, V2> A0(r<? super K, ? super V1, V2> rVar, Map.Entry<K, V1> entry) {
        b5.u.E(rVar);
        b5.u.E(entry);
        return new c(entry, rVar);
    }

    public static <K, V> e5.g<K, V> B(s<K, V> sVar, b5.v<? super Map.Entry<K, V>> vVar) {
        return new s(sVar.j(), Predicates.d(sVar.f9657f, vVar));
    }

    public static <K, V1, V2> Map<K, V2> B0(Map<K, V1> map, b5.n<? super V1, V2> nVar) {
        return x0(map, i(nVar));
    }

    public static <K, V> Map<K, V> C(n<K, V> nVar, b5.v<? super Map.Entry<K, V>> vVar) {
        return new t(nVar.f9656e, Predicates.d(nVar.f9657f, vVar));
    }

    @a5.c
    public static <K, V1, V2> NavigableMap<K, V2> C0(NavigableMap<K, V1> navigableMap, b5.n<? super V1, V2> nVar) {
        return y0(navigableMap, i(nVar));
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> D(u<K, V> uVar, b5.v<? super Map.Entry<K, V>> vVar) {
        return new u(uVar.f9676b, Predicates.d(uVar.f9677c, vVar));
    }

    public static <K, V1, V2> SortedMap<K, V2> D0(SortedMap<K, V1> sortedMap, b5.n<? super V1, V2> nVar) {
        return z0(sortedMap, i(nVar));
    }

    public static <K, V> SortedMap<K, V> E(v<K, V> vVar, b5.v<? super Map.Entry<K, V>> vVar2) {
        return new v(vVar.k(), Predicates.d(vVar.f9657f, vVar2));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> E0(Iterable<V> iterable, b5.n<? super V, K> nVar) {
        return F0(iterable.iterator(), nVar);
    }

    public static <K, V> e5.g<K, V> F(e5.g<K, V> gVar, b5.v<? super K> vVar) {
        b5.u.E(vVar);
        return x(gVar, U(vVar));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> F0(Iterator<V> it, b5.n<? super V, K> nVar) {
        b5.u.E(nVar);
        ImmutableMap.b builder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.i(nVar.apply(next), next);
        }
        try {
            return builder.d();
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(String.valueOf(e10.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    public static <K, V> Map<K, V> G(Map<K, V> map, b5.v<? super K> vVar) {
        b5.u.E(vVar);
        b5.v U = U(vVar);
        return map instanceof n ? C((n) map, U) : new w((Map) b5.u.E(map), vVar, U);
    }

    public static <K, V> e5.g<K, V> G0(e5.g<? extends K, ? extends V> gVar) {
        return new UnmodifiableBiMap(gVar, null);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> H(NavigableMap<K, V> navigableMap, b5.v<? super K> vVar) {
        return z(navigableMap, U(vVar));
    }

    public static <K, V> Map.Entry<K, V> H0(Map.Entry<? extends K, ? extends V> entry) {
        b5.u.E(entry);
        return new k(entry);
    }

    public static <K, V> SortedMap<K, V> I(SortedMap<K, V> sortedMap, b5.v<? super K> vVar) {
        return A(sortedMap, U(vVar));
    }

    public static <K, V> z1<Map.Entry<K, V>> I0(Iterator<Map.Entry<K, V>> it) {
        return new l(it);
    }

    public static <K, V> e5.g<K, V> J(e5.g<K, V> gVar, b5.v<? super V> vVar) {
        return x(gVar, Q0(vVar));
    }

    public static <K, V> Set<Map.Entry<K, V>> J0(Set<Map.Entry<K, V>> set) {
        return new k0(Collections.unmodifiableSet(set));
    }

    public static <K, V> Map<K, V> K(Map<K, V> map, b5.v<? super V> vVar) {
        return y(map, Q0(vVar));
    }

    public static <K, V> Map<K, V> K0(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> L(NavigableMap<K, V> navigableMap, b5.v<? super V> vVar) {
        return z(navigableMap, Q0(vVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.c
    public static <K, V> NavigableMap<K, V> L0(NavigableMap<K, ? extends V> navigableMap) {
        b5.u.E(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    public static <K, V> SortedMap<K, V> M(SortedMap<K, V> sortedMap, b5.v<? super V> vVar) {
        return A(sortedMap, Q0(vVar));
    }

    @CheckForNull
    public static <K, V> Map.Entry<K, V> M0(@CheckForNull Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return H0(entry);
    }

    @a5.c
    public static ImmutableMap<String, String> N(Properties properties) {
        ImmutableMap.b builder = ImmutableMap.builder();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            Object nextElement = propertyNames.nextElement();
            Objects.requireNonNull(nextElement);
            String str = (String) nextElement;
            String property = properties.getProperty(str);
            Objects.requireNonNull(property);
            builder.i(str, property);
        }
        return builder.d();
    }

    public static <V> b5.n<Map.Entry<?, V>, V> N0() {
        return EntryFunction.VALUE;
    }

    @a5.b(serializable = true)
    public static <K, V> Map.Entry<K, V> O(@d1 K k10, @d1 V v10) {
        return new ImmutableEntry(k10, v10);
    }

    public static <K, V> Iterator<V> O0(Iterator<Map.Entry<K, V>> it) {
        return new f(it);
    }

    @a5.b(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> P(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        e5.i.a(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((EnumMap) key, (K) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            e5.i.a(key2, value2);
            enumMap.put((EnumMap) key2, (K) value2);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    @CheckForNull
    public static <V> V P0(@CheckForNull Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <E> ImmutableMap<E, Integer> Q(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bVar.i(it.next(), Integer.valueOf(i10));
            i10++;
        }
        return bVar.d();
    }

    public static <V> b5.v<Map.Entry<?, V>> Q0(b5.v<? super V> vVar) {
        return Predicates.h(vVar, N0());
    }

    public static <K> b5.n<Map.Entry<K, ?>, K> R() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> S(Iterator<Map.Entry<K, V>> it) {
        return new e(it);
    }

    @CheckForNull
    public static <K> K T(@CheckForNull Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> b5.v<Map.Entry<K, ?>> U(b5.v<? super K> vVar) {
        return Predicates.h(vVar, R());
    }

    public static <K, V> ConcurrentMap<K, V> V() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> W(Class<K> cls) {
        return new EnumMap<>((Class) b5.u.E(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> X(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> Y() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> Z(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> a0(int i10) {
        return new HashMap<>(o(i10));
    }

    public static <K, V> IdentityHashMap<K, V> b0() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> c0() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> d0(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> e0(int i10) {
        return new LinkedHashMap<>(o(i10));
    }

    public static <A, B> Converter<A, B> f(e5.g<A, B> gVar) {
        return new BiMapConverter(gVar);
    }

    public static <K extends Comparable, V> TreeMap<K, V> f0() {
        return new TreeMap<>();
    }

    public static <K, V1, V2> b5.n<Map.Entry<K, V1>, Map.Entry<K, V2>> g(r<? super K, ? super V1, V2> rVar) {
        b5.u.E(rVar);
        return new d(rVar);
    }

    public static <C, K extends C, V> TreeMap<K, V> g0(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K, V1, V2> b5.n<Map.Entry<K, V1>, V2> h(r<? super K, ? super V1, V2> rVar) {
        b5.u.E(rVar);
        return new b(rVar);
    }

    public static <K, V> TreeMap<K, V> h0(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <K, V1, V2> r<K, V1, V2> i(b5.n<? super V1, V2> nVar) {
        b5.u.E(nVar);
        return new m(nVar);
    }

    public static <E> Comparator<? super E> i0(@CheckForNull Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> Map<K, V> j(Set<K> set, b5.n<? super K, V> nVar) {
        return new o(set, nVar);
    }

    public static <K, V> void j0(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> k(NavigableSet<K> navigableSet, b5.n<? super K, V> nVar) {
        return new b0(navigableSet, nVar);
    }

    public static <K, V> boolean k0(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(H0((Map.Entry) obj));
        }
        return false;
    }

    public static <K, V> SortedMap<K, V> l(SortedSet<K> sortedSet, b5.n<? super K, V> nVar) {
        return new d0(sortedSet, nVar);
    }

    @a5.c
    public static <E> NavigableSet<E> l0(NavigableSet<E> navigableSet) {
        return new j(navigableSet);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> m(Set<K> set, b5.n<? super K, V> nVar) {
        return new g(set.iterator(), nVar);
    }

    public static <E> Set<E> m0(Set<E> set) {
        return new h(set);
    }

    public static <K, V1, V2> b5.n<V1, V2> n(r<? super K, V1, V2> rVar, @d1 K k10) {
        b5.u.E(rVar);
        return new a(rVar, k10);
    }

    public static <E> SortedSet<E> n0(SortedSet<E> sortedSet) {
        return new i(sortedSet);
    }

    public static int o(int i10) {
        if (i10 < 3) {
            e5.i.b(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean o0(Map<?, ?> map, @CheckForNull Object obj) {
        b5.u.E(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <K, V> boolean p(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(H0((Map.Entry) obj));
        }
        return false;
    }

    @CheckForNull
    public static <V> V p0(Map<?, V> map, @CheckForNull Object obj) {
        b5.u.E(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean q(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(S(map.entrySet().iterator()), obj);
    }

    @CheckForNull
    public static <V> V q0(Map<?, V> map, @CheckForNull Object obj) {
        b5.u.E(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean r(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(O0(map.entrySet().iterator()), obj);
    }

    @a5.a
    @a5.c
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> r0(NavigableMap<K, V> navigableMap, Range<K> range) {
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            b5.u.e(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            return navigableMap.subMap(lowerEndpoint, lowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableMap.tailMap(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableMap.headMap(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
        return (NavigableMap) b5.u.E(navigableMap);
    }

    public static <K, V> com.google.common.collect.r<K, V> s(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return map instanceof SortedMap ? u((SortedMap) map, map2) : t(map, map2, Equivalence.equals());
    }

    public static <K, V> e5.g<K, V> s0(e5.g<K, V> gVar) {
        return Synchronized.g(gVar, null);
    }

    public static <K, V> com.google.common.collect.r<K, V> t(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        b5.u.E(equivalence);
        LinkedHashMap c02 = c0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap c03 = c0();
        LinkedHashMap c04 = c0();
        v(map, map2, equivalence, c02, linkedHashMap, c03, c04);
        return new a0(c02, linkedHashMap, c03, c04);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> t0(NavigableMap<K, V> navigableMap) {
        return Synchronized.o(navigableMap);
    }

    public static <K, V> com.google.common.collect.x<K, V> u(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        b5.u.E(sortedMap);
        b5.u.E(map);
        Comparator i02 = i0(sortedMap.comparator());
        TreeMap g02 = g0(i02);
        TreeMap g03 = g0(i02);
        g03.putAll(map);
        TreeMap g04 = g0(i02);
        TreeMap g05 = g0(i02);
        v(sortedMap, map, Equivalence.equals(), g02, g03, g04, g05);
        return new f0(g02, g03, g04, g05);
    }

    public static <K, V> ImmutableMap<K, V> u0(Iterable<K> iterable, b5.n<? super K, V> nVar) {
        return v0(iterable.iterator(), nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void v(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, r.a<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                defpackage.a aVar = (Object) a1.a(map4.remove(key));
                if (equivalence.equivalent(value, aVar)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, l0.c(value, aVar));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> v0(Iterator<K> it, b5.n<? super K, V> nVar) {
        b5.u.E(nVar);
        ImmutableMap.b builder = ImmutableMap.builder();
        while (it.hasNext()) {
            K next = it.next();
            builder.i(next, nVar.apply(next));
        }
        return builder.c();
    }

    public static boolean w(Map<?, ?> map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static String w0(Map<?, ?> map) {
        StringBuilder f10 = com.google.common.collect.f.f(map.size());
        f10.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                f10.append(", ");
            }
            f10.append(entry.getKey());
            f10.append('=');
            f10.append(entry.getValue());
            z10 = false;
        }
        f10.append('}');
        return f10.toString();
    }

    public static <K, V> e5.g<K, V> x(e5.g<K, V> gVar, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(gVar);
        b5.u.E(vVar);
        return gVar instanceof s ? B((s) gVar, vVar) : new s(gVar, vVar);
    }

    public static <K, V1, V2> Map<K, V2> x0(Map<K, V1> map, r<? super K, ? super V1, V2> rVar) {
        return new g0(map, rVar);
    }

    public static <K, V> Map<K, V> y(Map<K, V> map, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(vVar);
        return map instanceof n ? C((n) map, vVar) : new t((Map) b5.u.E(map), vVar);
    }

    @a5.c
    public static <K, V1, V2> NavigableMap<K, V2> y0(NavigableMap<K, V1> navigableMap, r<? super K, ? super V1, V2> rVar) {
        return new h0(navigableMap, rVar);
    }

    @a5.c
    public static <K, V> NavigableMap<K, V> z(NavigableMap<K, V> navigableMap, b5.v<? super Map.Entry<K, V>> vVar) {
        b5.u.E(vVar);
        return navigableMap instanceof u ? D((u) navigableMap, vVar) : new u((NavigableMap) b5.u.E(navigableMap), vVar);
    }

    public static <K, V1, V2> SortedMap<K, V2> z0(SortedMap<K, V1> sortedMap, r<? super K, ? super V1, V2> rVar) {
        return new i0(sortedMap, rVar);
    }

    public class h<E> extends e5.n0<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9646b;

        public h(Set set) {
            this.f9646b = set;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<E> delegate() {
            return this.f9646b;
        }
    }

    public class i<E> extends p0<E> {

        /* renamed from: b */
        public final /* synthetic */ SortedSet f9647b;

        public i(SortedSet sortedSet) {
            this.f9647b = sortedSet;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> headSet(@d1 E e10) {
            return Maps.n0(super.headSet(e10));
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
            return Maps.n0(super.subSet(e10, e11));
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> tailSet(@d1 E e10) {
            return Maps.n0(super.tailSet(e10));
        }

        @Override // e5.p0, e5.n0, e5.y, e5.l0
        public SortedSet<E> delegate() {
            return this.f9647b;
        }
    }
}
