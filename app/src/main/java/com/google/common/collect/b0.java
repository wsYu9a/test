package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import e5.g1;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.a
@e5.m
@a5.c
/* loaded from: classes2.dex */
public final class b0<K extends Comparable, V> implements g1<K, V> {

    /* renamed from: c */
    public static final g1<Comparable<?>, Object> f9897c = new a();

    /* renamed from: b */
    public final NavigableMap<Cut<K>, c<K, V>> f9898b = Maps.f0();

    public class a implements g1<Comparable<?>, Object> {
        @Override // e5.g1
        public Map<Range<Comparable<?>>, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // e5.g1
        public Map<Range<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // e5.g1
        public void clear() {
        }

        @Override // e5.g1
        @CheckForNull
        public Object get(Comparable<?> comparable) {
            return null;
        }

        @Override // e5.g1
        @CheckForNull
        public Map.Entry<Range<Comparable<?>>, Object> getEntry(Comparable<?> comparable) {
            return null;
        }

        @Override // e5.g1
        public void put(Range<Comparable<?>> range, Object obj) {
            b5.u.E(range);
            String valueOf = String.valueOf(range);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 46);
            sb2.append("Cannot insert range ");
            sb2.append(valueOf);
            sb2.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // e5.g1
        public void putAll(g1<Comparable<?>, Object> g1Var) {
            if (!g1Var.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // e5.g1
        public void putCoalescing(Range<Comparable<?>> range, Object obj) {
            b5.u.E(range);
            String valueOf = String.valueOf(range);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 46);
            sb2.append("Cannot insert range ");
            sb2.append(valueOf);
            sb2.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // e5.g1
        public void remove(Range<Comparable<?>> range) {
            b5.u.E(range);
        }

        @Override // e5.g1
        public Range<Comparable<?>> span() {
            throw new NoSuchElementException();
        }

        @Override // e5.g1
        public g1<Comparable<?>, Object> subRangeMap(Range<Comparable<?>> range) {
            b5.u.E(range);
            return this;
        }
    }

    public final class b extends Maps.y<Range<K>, V> {

        /* renamed from: b */
        public final Iterable<Map.Entry<Range<K>, V>> f9899b;

        public b(Iterable<c<K, V>> iterable) {
            this.f9899b = iterable;
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<Range<K>, V>> a() {
            return this.f9899b.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            c cVar = (c) b0.this.f9898b.get(range.lowerBound);
            if (cVar == null || !cVar.getKey().equals(range)) {
                return null;
            }
            return (V) cVar.getValue();
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return b0.this.f9898b.size();
        }
    }

    public static final class c<K extends Comparable, V> extends e5.b<Range<K>, V> {

        /* renamed from: b */
        public final Range<K> f9901b;

        /* renamed from: c */
        public final V f9902c;

        public c(Cut<K> cut, Cut<K> cut2, V v10) {
            this(Range.create(cut, cut2), v10);
        }

        public boolean a(K k10) {
            return this.f9901b.contains(k10);
        }

        @Override // e5.b, java.util.Map.Entry
        /* renamed from: b */
        public Range<K> getKey() {
            return this.f9901b;
        }

        public Cut<K> c() {
            return this.f9901b.lowerBound;
        }

        public Cut<K> d() {
            return this.f9901b.upperBound;
        }

        @Override // e5.b, java.util.Map.Entry
        public V getValue() {
            return this.f9902c;
        }

        public c(Range<K> range, V v10) {
            this.f9901b = range;
            this.f9902c = v10;
        }
    }

    public class d implements g1<K, V> {

        /* renamed from: b */
        public final Range<K> f9903b;

        public class a extends b0<K, V>.d.b {

            /* renamed from: com.google.common.collect.b0$d$a$a */
            public class C0287a extends AbstractIterator<Map.Entry<Range<K>, V>> {

                /* renamed from: d */
                public final /* synthetic */ Iterator f9906d;

                public C0287a(Iterator it) {
                    this.f9906d = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Range<K>, V> a() {
                    if (!this.f9906d.hasNext()) {
                        return (Map.Entry) b();
                    }
                    c cVar = (c) this.f9906d.next();
                    return cVar.d().compareTo((Cut) d.this.f9903b.lowerBound) <= 0 ? (Map.Entry) b() : Maps.O(cVar.getKey().intersection(d.this.f9903b), cVar.getValue());
                }
            }

            public a() {
                super();
            }

            @Override // com.google.common.collect.b0.d.b
            public Iterator<Map.Entry<Range<K>, V>> c() {
                return d.this.f9903b.isEmpty() ? Iterators.u() : new C0287a(b0.this.f9898b.headMap(d.this.f9903b.upperBound, false).descendingMap().values().iterator());
            }
        }

        public class b extends AbstractMap<Range<K>, V> {

            public class a extends Maps.z<Range<K>, V> {
                public a(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@CheckForNull Object obj) {
                    return b.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.e(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.R()));
                }
            }

            /* renamed from: com.google.common.collect.b0$d$b$b */
            public class C0288b extends Maps.q<Range<K>, V> {
                public C0288b() {
                }

                @Override // com.google.common.collect.Maps.q
                public Map<Range<K>, V> a() {
                    return b.this;
                }

                @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<Range<K>, V>> iterator() {
                    return b.this.c();
                }

                @Override // com.google.common.collect.Maps.q, com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.e(Predicates.q(Predicates.n(collection)));
                }

                @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.Z(iterator());
                }
            }

            public class c extends AbstractIterator<Map.Entry<Range<K>, V>> {

                /* renamed from: d */
                public final /* synthetic */ Iterator f9911d;

                public c(Iterator it) {
                    this.f9911d = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Range<K>, V> a() {
                    while (this.f9911d.hasNext()) {
                        c cVar = (c) this.f9911d.next();
                        if (cVar.c().compareTo((Cut) d.this.f9903b.upperBound) >= 0) {
                            return (Map.Entry) b();
                        }
                        if (cVar.d().compareTo((Cut) d.this.f9903b.lowerBound) > 0) {
                            return Maps.O(cVar.getKey().intersection(d.this.f9903b), cVar.getValue());
                        }
                    }
                    return (Map.Entry) b();
                }
            }

            /* renamed from: com.google.common.collect.b0$d$b$d */
            public class C0289d extends Maps.m0<Range<K>, V> {
                public C0289d(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return b.this.e(Predicates.h(Predicates.n(collection), Maps.N0()));
                }

                @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return b.this.e(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.N0()));
                }
            }

            public b() {
            }

            public Iterator<Map.Entry<Range<K>, V>> c() {
                if (d.this.f9903b.isEmpty()) {
                    return Iterators.u();
                }
                return new c(b0.this.f9898b.tailMap((Cut) com.google.common.base.a.a((Cut) b0.this.f9898b.floorKey(d.this.f9903b.lowerBound), d.this.f9903b.lowerBound), true).values().iterator());
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(@CheckForNull Object obj) {
                return get(obj) != null;
            }

            public final boolean e(b5.v<? super Map.Entry<Range<K>, V>> vVar) {
                ArrayList q10 = Lists.q();
                for (Map.Entry<Range<K>, V> entry : entrySet()) {
                    if (vVar.apply(entry)) {
                        q10.add(entry.getKey());
                    }
                }
                Iterator it = q10.iterator();
                while (it.hasNext()) {
                    b0.this.remove((Range) it.next());
                }
                return !q10.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new C0288b();
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V get(@CheckForNull Object obj) {
                c cVar;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (d.this.f9903b.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo((Cut) d.this.f9903b.lowerBound) == 0) {
                                Map.Entry floorEntry = b0.this.f9898b.floorEntry(range.lowerBound);
                                cVar = floorEntry != null ? (c) floorEntry.getValue() : null;
                            } else {
                                cVar = (c) b0.this.f9898b.get(range.lowerBound);
                            }
                            if (cVar != null && cVar.getKey().isConnected(d.this.f9903b) && cVar.getKey().intersection(d.this.f9903b).equals(range)) {
                                return (V) cVar.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V remove(@CheckForNull Object obj) {
                V v10 = (V) get(obj);
                if (v10 == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                b0.this.remove((Range) obj);
                return v10;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new C0289d(this);
            }
        }

        public d(Range<K> range) {
            this.f9903b = range;
        }

        @Override // e5.g1
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new a();
        }

        @Override // e5.g1
        public Map<Range<K>, V> asMapOfRanges() {
            return new b();
        }

        @Override // e5.g1
        public void clear() {
            b0.this.remove(this.f9903b);
        }

        @Override // e5.g1
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof g1) {
                return asMapOfRanges().equals(((g1) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // e5.g1
        @CheckForNull
        public V get(K k10) {
            if (this.f9903b.contains(k10)) {
                return (V) b0.this.get(k10);
            }
            return null;
        }

        @Override // e5.g1
        @CheckForNull
        public Map.Entry<Range<K>, V> getEntry(K k10) {
            Map.Entry<Range<K>, V> entry;
            if (!this.f9903b.contains(k10) || (entry = b0.this.getEntry(k10)) == null) {
                return null;
            }
            return Maps.O(entry.getKey().intersection(this.f9903b), entry.getValue());
        }

        @Override // e5.g1
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // e5.g1
        public void put(Range<K> range, V v10) {
            b5.u.y(this.f9903b.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.f9903b);
            b0.this.put(range, v10);
        }

        @Override // e5.g1
        public void putAll(g1<K, V> g1Var) {
            if (g1Var.asMapOfRanges().isEmpty()) {
                return;
            }
            Range<K> span = g1Var.span();
            b5.u.y(this.f9903b.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.f9903b);
            b0.this.putAll(g1Var);
        }

        @Override // e5.g1
        public void putCoalescing(Range<K> range, V v10) {
            if (b0.this.f9898b.isEmpty() || !this.f9903b.encloses(range)) {
                put(range, v10);
            } else {
                put(b0.this.e(range, b5.u.E(v10)).intersection(this.f9903b), v10);
            }
        }

        @Override // e5.g1
        public void remove(Range<K> range) {
            if (range.isConnected(this.f9903b)) {
                b0.this.remove(range.intersection(this.f9903b));
            }
        }

        @Override // e5.g1
        public Range<K> span() {
            Cut<K> cut;
            Map.Entry floorEntry = b0.this.f9898b.floorEntry(this.f9903b.lowerBound);
            if (floorEntry == null || ((c) floorEntry.getValue()).d().compareTo((Cut) this.f9903b.lowerBound) <= 0) {
                cut = (Cut) b0.this.f9898b.ceilingKey(this.f9903b.lowerBound);
                if (cut == null || cut.compareTo(this.f9903b.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.f9903b.lowerBound;
            }
            Map.Entry lowerEntry = b0.this.f9898b.lowerEntry(this.f9903b.upperBound);
            if (lowerEntry != null) {
                return Range.create(cut, ((c) lowerEntry.getValue()).d().compareTo((Cut) this.f9903b.upperBound) >= 0 ? this.f9903b.upperBound : ((c) lowerEntry.getValue()).d());
            }
            throw new NoSuchElementException();
        }

        @Override // e5.g1
        public g1<K, V> subRangeMap(Range<K> range) {
            return !range.isConnected(this.f9903b) ? b0.this.g() : b0.this.subRangeMap(range.intersection(this.f9903b));
        }

        @Override // e5.g1
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    public static <K extends Comparable, V> Range<K> d(Range<K> range, V v10, @CheckForNull Map.Entry<Cut<K>, c<K, V>> entry) {
        return (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(v10)) ? range.span(entry.getValue().getKey()) : range;
    }

    public static <K extends Comparable, V> b0<K, V> f() {
        return new b0<>();
    }

    @Override // e5.g1
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new b(this.f9898b.descendingMap().values());
    }

    @Override // e5.g1
    public Map<Range<K>, V> asMapOfRanges() {
        return new b(this.f9898b.values());
    }

    @Override // e5.g1
    public void clear() {
        this.f9898b.clear();
    }

    public final Range<K> e(Range<K> range, V v10) {
        return d(d(range, v10, this.f9898b.lowerEntry(range.lowerBound)), v10, this.f9898b.floorEntry(range.upperBound));
    }

    @Override // e5.g1
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof g1) {
            return asMapOfRanges().equals(((g1) obj).asMapOfRanges());
        }
        return false;
    }

    public final g1<K, V> g() {
        return f9897c;
    }

    @Override // e5.g1
    @CheckForNull
    public V get(K k10) {
        Map.Entry<Range<K>, V> entry = getEntry(k10);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // e5.g1
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k10) {
        Map.Entry<Cut<K>, c<K, V>> floorEntry = this.f9898b.floorEntry(Cut.belowValue(k10));
        if (floorEntry == null || !floorEntry.getValue().a(k10)) {
            return null;
        }
        return floorEntry.getValue();
    }

    public final void h(Cut<K> cut, Cut<K> cut2, V v10) {
        this.f9898b.put(cut, new c<>(cut, cut2, v10));
    }

    @Override // e5.g1
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // e5.g1
    public void put(Range<K> range, V v10) {
        if (range.isEmpty()) {
            return;
        }
        b5.u.E(v10);
        remove(range);
        this.f9898b.put(range.lowerBound, new c<>(range, v10));
    }

    @Override // e5.g1
    public void putAll(g1<K, V> g1Var) {
        for (Map.Entry<Range<K>, V> entry : g1Var.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.g1
    public void putCoalescing(Range<K> range, V v10) {
        if (this.f9898b.isEmpty()) {
            put(range, v10);
        } else {
            put(e(range, b5.u.E(v10)), v10);
        }
    }

    @Override // e5.g1
    public void remove(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<K>, c<K, V>> lowerEntry = this.f9898b.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            c<K, V> value = lowerEntry.getValue();
            if (value.d().compareTo(range.lowerBound) > 0) {
                if (value.d().compareTo(range.upperBound) > 0) {
                    h(range.upperBound, value.d(), lowerEntry.getValue().getValue());
                }
                h(value.c(), range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        Map.Entry<Cut<K>, c<K, V>> lowerEntry2 = this.f9898b.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            c<K, V> value2 = lowerEntry2.getValue();
            if (value2.d().compareTo(range.upperBound) > 0) {
                h(range.upperBound, value2.d(), lowerEntry2.getValue().getValue());
            }
        }
        this.f9898b.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // e5.g1
    public Range<K> span() {
        Map.Entry<Cut<K>, c<K, V>> firstEntry = this.f9898b.firstEntry();
        Map.Entry<Cut<K>, c<K, V>> lastEntry = this.f9898b.lastEntry();
        if (firstEntry == null || lastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
    }

    @Override // e5.g1
    public g1<K, V> subRangeMap(Range<K> range) {
        return range.equals(Range.all()) ? this : new d(range);
    }

    @Override // e5.g1
    public String toString() {
        return this.f9898b.values().toString();
    }
}
