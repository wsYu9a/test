package com.google.common.collect;

import e5.e1;
import e5.h1;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@a5.a
@e5.m
@a5.c
/* loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends e5.c<C> implements Serializable {

    @CheckForNull
    private transient Set<Range<C>> asDescendingSetOfRanges;

    @CheckForNull
    private transient Set<Range<C>> asRanges;

    @CheckForNull
    private transient h1<C> complement;

    @a5.d
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.h1
        public h1<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public boolean contains(C c10) {
            return !TreeRangeSet.this.contains(c10);
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        public SubRangeSet(Range<C> range) {
            super(new e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public void add(Range<C> range) {
            b5.u.y(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public boolean contains(C c10) {
            return this.restriction.contains(c10) && TreeRangeSet.this.contains(c10);
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        @CheckForNull
        public Range<C> rangeContaining(C c10) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c10) && (rangeContaining = TreeRangeSet.this.rangeContaining(c10)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.c, e5.h1
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, e5.h1
        public h1<C> subRangeSet(Range<C> range) {
            return range.encloses(this.restriction) ? this : range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    public final class b extends e5.y<Range<C>> implements Set<Range<C>> {

        /* renamed from: b */
        public final Collection<Range<C>> f9866b;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f9866b = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }

        @Override // e5.y, e5.l0
        public Collection<Range<C>> delegate() {
            return this.f9866b;
        }
    }

    public static final class c<C extends Comparable<?>> extends com.google.common.collect.c<Cut<C>, Range<C>> {

        /* renamed from: b */
        public final NavigableMap<Cut<C>, Range<C>> f9867b;

        /* renamed from: c */
        public final NavigableMap<Cut<C>, Range<C>> f9868c;

        /* renamed from: d */
        public final Range<Cut<C>> f9869d;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public Cut<C> f9870d;

            /* renamed from: e */
            public final /* synthetic */ Cut f9871e;

            /* renamed from: f */
            public final /* synthetic */ e1 f9872f;

            public a(Cut cut, e1 e1Var) {
                this.f9871e = cut;
                this.f9872f = e1Var;
                this.f9870d = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range create;
                if (c.this.f9869d.upperBound.isLessThan(this.f9870d) || this.f9870d == Cut.aboveAll()) {
                    return (Map.Entry) b();
                }
                if (this.f9872f.hasNext()) {
                    Range range = (Range) this.f9872f.next();
                    create = Range.create(this.f9870d, range.lowerBound);
                    this.f9870d = range.upperBound;
                } else {
                    create = Range.create(this.f9870d, Cut.aboveAll());
                    this.f9870d = Cut.aboveAll();
                }
                return Maps.O(create.lowerBound, create);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public Cut<C> f9874d;

            /* renamed from: e */
            public final /* synthetic */ Cut f9875e;

            /* renamed from: f */
            public final /* synthetic */ e1 f9876f;

            public b(Cut cut, e1 e1Var) {
                this.f9875e = cut;
                this.f9876f = e1Var;
                this.f9874d = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.f9874d == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.f9876f.hasNext()) {
                    Range range = (Range) this.f9876f.next();
                    Range create = Range.create(range.upperBound, this.f9874d);
                    this.f9874d = range.lowerBound;
                    if (c.this.f9869d.lowerBound.isLessThan(create.lowerBound)) {
                        return Maps.O(create.lowerBound, create);
                    }
                } else if (c.this.f9869d.lowerBound.isLessThan(Cut.belowAll())) {
                    Range create2 = Range.create(Cut.belowAll(), this.f9874d);
                    this.f9874d = Cut.belowAll();
                    return Maps.O(Cut.belowAll(), create2);
                }
                return (Map.Entry) b();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            Cut cut;
            if (this.f9869d.hasLowerBound()) {
                values = this.f9868c.tailMap(this.f9869d.lowerEndpoint(), this.f9869d.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.f9868c.values();
            }
            e1 T = Iterators.T(values.iterator());
            if (this.f9869d.contains(Cut.belowAll()) && (!T.hasNext() || ((Range) T.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else {
                if (!T.hasNext()) {
                    return Iterators.u();
                }
                cut = ((Range) T.next()).upperBound;
            }
            return new a(cut, T);
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            Cut<C> higherKey;
            e1 T = Iterators.T(this.f9868c.headMap(this.f9869d.hasUpperBound() ? this.f9869d.upperEndpoint() : Cut.aboveAll(), this.f9869d.hasUpperBound() && this.f9869d.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (T.hasNext()) {
                higherKey = ((Range) T.peek()).upperBound == Cut.aboveAll() ? ((Range) T.next()).lowerBound : this.f9867b.higherKey(((Range) T.peek()).upperBound);
            } else {
                if (!this.f9869d.contains(Cut.belowAll()) || this.f9867b.containsKey(Cut.belowAll())) {
                    return Iterators.u();
                }
                higherKey = this.f9867b.higherKey(Cut.belowAll());
            }
            return new b((Cut) com.google.common.base.a.a(higherKey, Cut.aboveAll()), T);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return i(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return i(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        public final NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
            if (!this.f9869d.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f9867b, range.intersection(this.f9869d));
        }

        @Override // java.util.NavigableMap
        /* renamed from: j */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return i(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.Z(a());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f9867b = navigableMap;
            this.f9868c = new d(navigableMap);
            this.f9869d = range;
        }
    }

    public static final class e<C extends Comparable<?>> extends com.google.common.collect.c<Cut<C>, Range<C>> {

        /* renamed from: b */
        public final Range<Cut<C>> f9884b;

        /* renamed from: c */
        public final Range<C> f9885c;

        /* renamed from: d */
        public final NavigableMap<Cut<C>, Range<C>> f9886d;

        /* renamed from: e */
        public final NavigableMap<Cut<C>, Range<C>> f9887e;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9888d;

            /* renamed from: e */
            public final /* synthetic */ Cut f9889e;

            public a(Iterator it, Cut cut) {
                this.f9888d = it;
                this.f9889e = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f9888d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f9888d.next();
                if (this.f9889e.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.f9885c);
                return Maps.O(intersection.lowerBound, intersection);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9891d;

            public b(Iterator it) {
                this.f9891d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f9891d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f9891d.next();
                if (e.this.f9885c.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.f9885c);
                return e.this.f9884b.contains(intersection.lowerBound) ? Maps.O(intersection.lowerBound, intersection) : (Map.Entry) b();
            }
        }

        public /* synthetic */ e(Range range, Range range2, NavigableMap navigableMap, a aVar) {
            this(range, range2, navigableMap);
        }

        private NavigableMap<Cut<C>, Range<C>> j(Range<Cut<C>> range) {
            return !range.isConnected(this.f9884b) ? ImmutableSortedMap.of() : new e(this.f9884b.intersection(range), this.f9885c, this.f9886d);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.f9885c.isEmpty()) {
                return Iterators.u();
            }
            if (this.f9884b.upperBound.isLessThan(this.f9885c.lowerBound)) {
                return Iterators.u();
            }
            if (this.f9884b.lowerBound.isLessThan(this.f9885c.lowerBound)) {
                it = this.f9887e.tailMap(this.f9885c.lowerBound, false).values().iterator();
            } else {
                it = this.f9886d.tailMap(this.f9884b.lowerBound.endpoint(), this.f9884b.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new a(it, (Cut) Ordering.natural().min(this.f9884b.upperBound, Cut.belowValue(this.f9885c.upperBound)));
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            if (this.f9885c.isEmpty()) {
                return Iterators.u();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f9884b.upperBound, Cut.belowValue(this.f9885c.upperBound));
            return new b(this.f9886d.headMap((Cut) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f9884b.contains(cut) && cut.compareTo(this.f9885c.lowerBound) >= 0 && cut.compareTo(this.f9885c.upperBound) < 0) {
                        if (cut.equals(this.f9885c.lowerBound)) {
                            Range range = (Range) Maps.P0(this.f9886d.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f9885c.lowerBound) > 0) {
                                return range.intersection(this.f9885c);
                            }
                        } else {
                            Range<C> range2 = this.f9886d.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f9885c);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return j(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return j(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: k */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return j(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.Z(a());
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f9884b = (Range) b5.u.E(range);
            this.f9885c = (Range) b5.u.E(range2);
            this.f9886d = (NavigableMap) b5.u.E(navigableMap);
            this.f9887e = new d(navigableMap);
        }
    }

    public /* synthetic */ TreeRangeSet(NavigableMap navigableMap, a aVar) {
        this(navigableMap);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    @CheckForNull
    public Range<C> rangeEnclosing(Range<C> range) {
        b5.u.E(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // e5.c, e5.h1
    public void add(Range<C> range) {
        b5.u.E(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void addAll(h1 h1Var) {
        super.addAll(h1Var);
    }

    @Override // e5.h1
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // e5.h1
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // e5.h1
    public h1<C> complement() {
        h1<C> h1Var = this.complement;
        if (h1Var != null) {
            return h1Var;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // e5.c, e5.h1
    public boolean encloses(Range<C> range) {
        b5.u.E(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean enclosesAll(h1 h1Var) {
        return super.enclosesAll(h1Var);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // e5.c, e5.h1
    public boolean intersects(Range<C> range) {
        b5.u.E(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // e5.c, e5.h1
    @CheckForNull
    public Range<C> rangeContaining(C c10) {
        b5.u.E(c10);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c10));
        if (floorEntry == null || !floorEntry.getValue().contains(c10)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // e5.c, e5.h1
    public void remove(Range<C> range) {
        b5.u.E(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void removeAll(h1 h1Var) {
        super.removeAll(h1Var);
    }

    @Override // e5.h1
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry == null || lastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
    }

    @Override // e5.h1
    public h1<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(h1<C> h1Var) {
        TreeRangeSet<C> create = create();
        create.addAll(h1Var);
        return create;
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // e5.c, e5.h1
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    @a5.d
    public static final class d<C extends Comparable<?>> extends com.google.common.collect.c<Cut<C>, Range<C>> {

        /* renamed from: b */
        public final NavigableMap<Cut<C>, Range<C>> f9878b;

        /* renamed from: c */
        public final Range<Cut<C>> f9879c;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9880d;

            public a(Iterator it) {
                this.f9880d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f9880d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f9880d.next();
                return d.this.f9879c.upperBound.isLessThan(range.upperBound) ? (Map.Entry) b() : Maps.O(range.upperBound, range);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d */
            public final /* synthetic */ e1 f9882d;

            public b(e1 e1Var) {
                this.f9882d = e1Var;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f9882d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f9882d.next();
                return d.this.f9879c.lowerBound.isLessThan(range.upperBound) ? Maps.O(range.upperBound, range) : (Map.Entry) b();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f9878b = navigableMap;
            this.f9879c = Range.all();
        }

        private NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
            return range.isConnected(this.f9879c) ? new d(this.f9878b, range.intersection(this.f9879c)) : ImmutableSortedMap.of();
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.f9879c.hasLowerBound()) {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f9878b.lowerEntry(this.f9879c.lowerEndpoint());
                it = lowerEntry == null ? this.f9878b.values().iterator() : this.f9879c.lowerBound.isLessThan(lowerEntry.getValue().upperBound) ? this.f9878b.tailMap(lowerEntry.getKey(), true).values().iterator() : this.f9878b.tailMap(this.f9879c.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f9878b.values().iterator();
            }
            return new a(it);
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            e1 T = Iterators.T((this.f9879c.hasUpperBound() ? this.f9878b.headMap(this.f9879c.upperEndpoint(), false).descendingMap().values() : this.f9878b.descendingMap().values()).iterator());
            if (T.hasNext() && this.f9879c.upperBound.isLessThan(((Range) T.peek()).upperBound)) {
                T.next();
            }
            return new b(T);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Range<C> get(@CheckForNull Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f9879c.contains(cut) && (lowerEntry = this.f9878b.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return i(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return i(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f9879c.equals(Range.all()) ? this.f9878b.isEmpty() : !a().hasNext();
        }

        @Override // java.util.NavigableMap
        /* renamed from: j */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return i(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9879c.equals(Range.all()) ? this.f9878b.size() : Iterators.Z(a());
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f9878b = navigableMap;
            this.f9879c = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
