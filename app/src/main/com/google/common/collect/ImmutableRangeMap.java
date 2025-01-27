package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import e5.g1;
import e5.z1;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@a5.a
@e5.m
@a5.c
/* loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements g1<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* renamed from: com.google.common.collect.ImmutableRangeMap$1 */
    public class AnonymousClass1 extends ImmutableList<Range<K>> {
        final /* synthetic */ int val$len;
        final /* synthetic */ int val$off;
        final /* synthetic */ Range val$range;

        public AnonymousClass1(int i10, int i11, Range range) {
            i10 = i10;
            a10 = i11;
            range = range;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<K> get(int i10) {
            b5.u.C(i10, i10);
            return (i10 == 0 || i10 == i10 + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i10 + a10)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i10 + a10);
        }
    }

    /* renamed from: com.google.common.collect.ImmutableRangeMap$2 */
    public class AnonymousClass2 extends ImmutableRangeMap<K, V> {
        final /* synthetic */ ImmutableRangeMap val$outer;
        final /* synthetic */ Range val$range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
            super(immutableList, immutableList2);
            range = range;
            this = immutableRangeMap2;
        }

        @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
        public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
            return super.asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
        public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
            return range.isConnected(range) ? this.subRangeMap((Range) range.intersection(range)) : ImmutableRangeMap.of();
        }
    }

    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            a aVar = new a();
            z1<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                aVar.c(next.getKey(), next.getValue());
            }
            return aVar.a();
        }

        public Object readResolve() {
            return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.of() : createRangeMap();
        }
    }

    @DoNotMock
    public static final class a<K extends Comparable<?>, V> {

        /* renamed from: a */
        public final List<Map.Entry<Range<K>, V>> f9479a = Lists.q();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f9479a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f9479a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f9479a.size());
            for (int i10 = 0; i10 < this.f9479a.size(); i10++) {
                Range<K> key = this.f9479a.get(i10).getKey();
                if (i10 > 0) {
                    Range<K> key2 = this.f9479a.get(i10 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        String valueOf = String.valueOf(key2);
                        String valueOf2 = String.valueOf(key);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 47 + valueOf2.length());
                        sb2.append("Overlapping ranges: range ");
                        sb2.append(valueOf);
                        sb2.append(" overlaps with entry ");
                        sb2.append(valueOf2);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                aVar.a(key);
                aVar2.a(this.f9479a.get(i10).getValue());
            }
            return new ImmutableRangeMap<>(aVar.e(), aVar2.e());
        }

        @CanIgnoreReturnValue
        public a<K, V> b(a<K, V> aVar) {
            this.f9479a.addAll(aVar.f9479a);
            return this;
        }

        @CanIgnoreReturnValue
        public a<K, V> c(Range<K> range, V v10) {
            b5.u.E(range);
            b5.u.E(v10);
            b5.u.u(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f9479a.add(Maps.O(range, v10));
            return this;
        }

        @CanIgnoreReturnValue
        public a<K, V> d(g1<K, ? extends V> g1Var) {
            for (Map.Entry<Range<K>, ? extends V> entry : g1Var.asMapOfRanges().entrySet()) {
                c(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(g1<K, ? extends V> g1Var) {
        if (g1Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) g1Var;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = g1Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            aVar.a(entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.e(), aVar2.e());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    @Override // e5.g1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
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
        int a10 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a10 != -1 && this.ranges.get(a10).contains(k10)) {
            return this.values.get(a10);
        }
        return null;
    }

    @Override // e5.g1
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k10) {
        int a10 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a10 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a10);
        if (range.contains(k10)) {
            return Maps.O(range, this.values.get(a10));
        }
        return null;
    }

    @Override // e5.g1
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // e5.g1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void put(Range<K> range, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.g1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(g1<K, V> g1Var) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.g1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putCoalescing(Range<K> range, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.g1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.g1
    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    @Override // e5.g1
    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v10) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v10));
    }

    @Override // e5.g1
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // e5.g1
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // e5.g1
    public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
        if (((Range) b5.u.E(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        b5.n upperBoundFn = Range.upperBoundFn();
        Cut<K> cut = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        int a10 = SortedLists.a(immutableList, upperBoundFn, cut, keyPresentBehavior, keyAbsentBehavior);
        int a11 = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        return a10 >= a11 ? of() : new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            final /* synthetic */ int val$len;
            final /* synthetic */ int val$off;
            final /* synthetic */ Range val$range;

            public AnonymousClass1(int i10, int a102, Range range2) {
                i10 = i10;
                a10 = a102;
                range = range2;
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i10) {
                b5.u.C(i10, i10);
                return (i10 == 0 || i10 == i10 + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i10 + a10)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i10 + a10);
            }
        }, this.values.subList(a102, a11)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            final /* synthetic */ ImmutableRangeMap val$outer;
            final /* synthetic */ Range val$range;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ImmutableRangeMap this, ImmutableList immutableList2, ImmutableList immutableList22, Range range2, ImmutableRangeMap this) {
                super(immutableList2, immutableList22);
                range = range2;
                this = this;
            }

            @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
            public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                return super.asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, e5.g1
            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range2) {
                return range.isConnected(range2) ? this.subRangeMap((Range) range2.intersection(range)) : ImmutableRangeMap.of();
            }
        };
    }
}
