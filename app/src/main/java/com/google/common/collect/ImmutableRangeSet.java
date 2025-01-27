package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.e1;
import e5.h1;
import e5.u0;
import e5.z1;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.CheckForNull;

@a5.a
@e5.m
@a5.c
/* loaded from: classes2.dex */
public final class ImmutableRangeSet<C extends Comparable> extends e5.c<C> implements Serializable {

    @CheckForNull
    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* renamed from: com.google.common.collect.ImmutableRangeSet$1 */
    public class AnonymousClass1 extends ImmutableList<Range<C>> {
        final /* synthetic */ int val$fromIndex;
        final /* synthetic */ int val$length;
        final /* synthetic */ Range val$range;

        public AnonymousClass1(int i10, int i11, Range range) {
            a11 = i10;
            a10 = i11;
            range = range;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return a11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int i10) {
            b5.u.C(i10, a11);
            return (i10 == 0 || i10 == a11 + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i10 + a10)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(i10 + a10);
        }
    }

    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;

        @CheckForNull
        private transient Integer size;

        public class a extends AbstractIterator<C> {

            /* renamed from: d */
            public final Iterator<Range<C>> f9480d;

            /* renamed from: e */
            public Iterator<C> f9481e = Iterators.u();

            public a() {
                this.f9480d = ImmutableRangeSet.this.ranges.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public C a() {
                while (!this.f9481e.hasNext()) {
                    if (!this.f9480d.hasNext()) {
                        return (C) b();
                    }
                    this.f9481e = ContiguousSet.create(this.f9480d.next(), AsSet.this.domain).iterator();
                }
                return this.f9481e.next();
            }
        }

        public class b extends AbstractIterator<C> {

            /* renamed from: d */
            public final Iterator<Range<C>> f9483d;

            /* renamed from: e */
            public Iterator<C> f9484e = Iterators.u();

            public b() {
                this.f9483d = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public C a() {
                while (!this.f9484e.hasNext()) {
                    if (!this.f9483d.hasNext()) {
                        return (C) b();
                    }
                    this.f9484e = ContiguousSet.create(this.f9483d.next(), AsSet.this.domain).descendingIterator();
                }
                return this.f9484e.next();
            }
        }

        public AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Objects.requireNonNull(obj);
            Comparable comparable = (Comparable) obj;
            z1 it = ImmutableRangeSet.this.ranges.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                if (((Range) it.next()).contains(comparable)) {
                    return Ints.x(j10 + ContiguousSet.create(r3, this.domain).indexOf(comparable));
                }
                j10 += ContiguousSet.create(r3, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.size;
            if (num == null) {
                z1 it = ImmutableRangeSet.this.ranges.iterator();
                long j10 = 0;
                while (it.hasNext()) {
                    j10 += ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j10 >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.x(j10));
                this.size = num;
            }
            return num.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.domain);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @a5.c("NavigableSet")
        public z1<C> descendingIterator() {
            return new b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> headSetImpl(C c10, boolean z10) {
            return subSet(Range.upTo(c10, BoundType.forBoolean(z10)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
        public z1<C> iterator() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> subSetImpl(C c10, boolean z10, C c11, boolean z11) {
            return (z10 || z11 || Range.compareOrThrow(c10, c11) != 0) ? subSet(Range.range(c10, BoundType.forBoolean(z10), c11, BoundType.forBoolean(z11))) : ImmutableSortedSet.of();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> tailSetImpl(C c10, boolean z10) {
            return subSet(Range.downTo(c10, BoundType.forBoolean(z10)));
        }
    }

    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((Range) u0.w(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size();
            size = hasLowerBound ? size : size - 1;
            this.size = hasUpperBound ? size + 1 : size;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int i10) {
            b5.u.C(i10, this.size);
            return Range.create(this.positiveBoundedBelow ? i10 == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i10 - 1)).upperBound : ((Range) ImmutableRangeSet.this.ranges.get(i10)).upperBound, (this.positiveBoundedAbove && i10 == this.size + (-1)) ? Cut.aboveAll() : ((Range) ImmutableRangeSet.this.ranges.get(i10 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound);
        }
    }

    public static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public Object readResolve() {
            return this.ranges.isEmpty() ? ImmutableRangeSet.of() : this.ranges.equals(ImmutableList.of(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet(this.ranges);
        }
    }

    public static class a<C extends Comparable<?>> {

        /* renamed from: a */
        public final List<Range<C>> f9486a = Lists.q();

        @CanIgnoreReturnValue
        public a<C> a(Range<C> range) {
            b5.u.u(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f9486a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public a<C> b(h1<C> h1Var) {
            return c(h1Var.asRanges());
        }

        @CanIgnoreReturnValue
        public a<C> c(Iterable<Range<C>> iterable) {
            Iterator<Range<C>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableRangeSet<C> d() {
            ImmutableList.a aVar = new ImmutableList.a(this.f9486a.size());
            Collections.sort(this.f9486a, Range.rangeLexOrdering());
            e1 T = Iterators.T(this.f9486a.iterator());
            while (T.hasNext()) {
                Range range = (Range) T.next();
                while (T.hasNext()) {
                    Range<C> range2 = (Range) T.peek();
                    if (range.isConnected(range2)) {
                        b5.u.y(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) T.next());
                    }
                }
                aVar.a(range);
            }
            ImmutableList e10 = aVar.e();
            return e10.isEmpty() ? ImmutableRangeSet.of() : (e10.size() == 1 && ((Range) u0.z(e10)).equals(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet<>(e10);
        }

        @CanIgnoreReturnValue
        public a<C> e(a<C> aVar) {
            c(aVar.f9486a);
            return this;
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(h1<C> h1Var) {
        b5.u.E(h1Var);
        if (h1Var.isEmpty()) {
            return of();
        }
        if (h1Var.encloses(Range.all())) {
            return all();
        }
        if (h1Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) h1Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) h1Var.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        int a10 = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        int a11 = (range.hasUpperBound() ? SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size()) - a10;
        return a11 == 0 ? ImmutableList.of() : new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
            final /* synthetic */ int val$fromIndex;
            final /* synthetic */ int val$length;
            final /* synthetic */ Range val$range;

            public AnonymousClass1(int a112, int a102, Range range2) {
                a11 = a112;
                a10 = a102;
                range = range2;
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a11;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<C> get(int i10) {
                b5.u.C(i10, a11);
                return (i10 == 0 || i10 == a11 + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i10 + a10)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(i10 + a10);
            }
        };
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(h1<C> h1Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        b5.u.E(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (!canonical.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!canonical.hasUpperBound()) {
            try {
                discreteDomain.maxValue();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new AsSet(discreteDomain);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(h1<C> h1Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(h1Var);
        return copyOf(create);
    }

    @Override // e5.c, e5.h1
    public boolean encloses(Range<C> range) {
        int b10 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b10 != -1 && this.ranges.get(b10).encloses(range);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean enclosesAll(h1 h1Var) {
        return super.enclosesAll(h1Var);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(h1<C> h1Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(h1Var.complement());
        return copyOf(create);
    }

    @Override // e5.c, e5.h1
    public boolean intersects(Range<C> range) {
        int b10 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b10 < this.ranges.size() && this.ranges.get(b10).isConnected(range) && !this.ranges.get(b10).intersection(range).isEmpty()) {
            return true;
        }
        if (b10 > 0) {
            int i10 = b10 - 1;
            if (this.ranges.get(i10).isConnected(range) && !this.ranges.get(i10).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // e5.c, e5.h1
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // e5.c, e5.h1
    @CheckForNull
    public Range<C> rangeContaining(C c10) {
        int b10 = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c10), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b10 == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(b10);
        if (range.contains(c10)) {
            return range;
        }
        return null;
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(h1<C> h1Var) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.h1
    public Range<C> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    public ImmutableRangeSet<C> union(h1<C> h1Var) {
        return unionOf(u0.f(asRanges(), h1Var.asRanges()));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        b5.u.E(range);
        return range.isEmpty() ? of() : range.equals(Range.all()) ? all() : new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.h1
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // e5.h1
    public ImmutableSet<Range<C>> asRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // e5.h1
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> of2 = of();
            this.complement = of2;
            return of2;
        }
        ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
        this.complement = immutableRangeSet2;
        return immutableRangeSet2;
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // e5.c, e5.h1
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.h1
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new a().c(iterable).d();
    }
}
