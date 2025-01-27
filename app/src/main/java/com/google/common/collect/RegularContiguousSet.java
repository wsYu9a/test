package com.google.common.collect;

import e5.z1;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Objects;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    /* renamed from: com.google.common.collect.RegularContiguousSet$3 */
    public class AnonymousClass3 extends ImmutableAsList<C> {
        public AnonymousClass3() {
        }

        @Override // com.google.common.collect.ImmutableAsList
        public ImmutableSortedSet<C> delegateCollection() {
            return RegularContiguousSet.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public C get(int i10) {
            b5.u.C(i10, size());
            RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
            return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), i10);
        }
    }

    @a5.c
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        public /* synthetic */ SerializedForm(Range range, DiscreteDomain discreteDomain, a aVar) {
            this(range, discreteDomain);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }

        private SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            this.range = range;
            this.domain = discreteDomain;
        }
    }

    public class a extends e5.d<C> {

        /* renamed from: c */
        public final C f9753c;

        public a(Comparable comparable) {
            super(comparable);
            this.f9753c = (C) RegularContiguousSet.this.last();
        }

        @Override // e5.d
        @CheckForNull
        /* renamed from: b */
        public C a(C c10) {
            if (RegularContiguousSet.equalsOrThrow(c10, this.f9753c)) {
                return null;
            }
            return RegularContiguousSet.this.domain.next(c10);
        }
    }

    public class b extends e5.d<C> {

        /* renamed from: c */
        public final C f9755c;

        public b(Comparable comparable) {
            super(comparable);
            this.f9755c = (C) RegularContiguousSet.this.first();
        }

        @Override // e5.d
        @CheckForNull
        /* renamed from: b */
        public C a(C c10) {
            if (RegularContiguousSet.equalsOrThrow(c10, this.f9755c)) {
                return null;
            }
            return RegularContiguousSet.this.domain.previous(c10);
        }
    }

    public RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    public static boolean equalsOrThrow(Comparable<?> comparable, @CheckForNull Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> range) {
        return this.range.isConnected(range) ? ContiguousSet.create(this.range.intersection(range), this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return f.b(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        return this.domain.supportsFastOffset ? new ImmutableAsList<C>() { // from class: com.google.common.collect.RegularContiguousSet.3
            public AnonymousClass3() {
            }

            @Override // com.google.common.collect.ImmutableAsList
            public ImmutableSortedSet<C> delegateCollection() {
                return RegularContiguousSet.this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public C get(int i10) {
                b5.u.C(i10, size());
                RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), i10);
            }
        } : super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.k(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    @a5.c
    public int indexOf(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return -1;
        }
        DiscreteDomain<C> discreteDomain = this.domain;
        C first = first();
        Objects.requireNonNull(obj);
        return (int) discreteDomain.distance(first, (Comparable) obj);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        b5.u.E(contiguousSet);
        b5.u.d(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), (Comparable) contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), (Comparable) contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long distance = this.domain.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @a5.c
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @a5.c
    public z1<C> descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        C leastValueAbove = this.range.lowerBound.leastValueAbove(this.domain);
        Objects.requireNonNull(leastValueAbove);
        return leastValueAbove;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> headSetImpl(C c10, boolean z10) {
        return intersectionInCurrentDomain(Range.upTo(c10, BoundType.forBoolean(z10)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public z1<C> iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        C greatestValueBelow = this.range.upperBound.greatestValueBelow(this.domain);
        Objects.requireNonNull(greatestValueBelow);
        return greatestValueBelow;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> subSetImpl(C c10, boolean z10, C c11, boolean z11) {
        return (c10.compareTo(c11) != 0 || z10 || z11) ? intersectionInCurrentDomain(Range.range(c10, BoundType.forBoolean(z10), c11, BoundType.forBoolean(z11))) : new EmptyContiguousSet(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> tailSetImpl(C c10, boolean z10) {
        return intersectionInCurrentDomain(Range.downTo(c10, BoundType.forBoolean(z10)));
    }
}
