package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.a1;
import e5.d1;
import e5.u0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class TreeMultiset<E> extends com.google.common.collect.d<E> implements Serializable {

    @a5.c
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f9857b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f9859d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f9858c;
            }
        };

        /* renamed from: com.google.common.collect.TreeMultiset$Aggregate$1 */
        public enum AnonymousClass1 extends Aggregate {
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f9857b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f9859d;
            }
        }

        /* renamed from: com.google.common.collect.TreeMultiset$Aggregate$2 */
        public enum AnonymousClass2 extends Aggregate {
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f9858c;
            }
        }

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(@CheckForNull e<?> eVar);

        /* synthetic */ Aggregate(a aVar) {
            this();
        }
    }

    public class a extends Multisets.f<E> {

        /* renamed from: b */
        public final /* synthetic */ e f9847b;

        public a(e eVar) {
            this.f9847b = eVar;
        }

        @Override // com.google.common.collect.s.a
        public int getCount() {
            int w10 = this.f9847b.w();
            return w10 == 0 ? TreeMultiset.this.count(getElement()) : w10;
        }

        @Override // com.google.common.collect.s.a
        @d1
        public E getElement() {
            return (E) this.f9847b.x();
        }
    }

    public class b implements Iterator<s.a<E>> {

        /* renamed from: b */
        @CheckForNull
        public e<E> f9849b;

        /* renamed from: c */
        @CheckForNull
        public s.a<E> f9850c;

        public b() {
            this.f9849b = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public s.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            e<E> eVar = this.f9849b;
            Objects.requireNonNull(eVar);
            s.a<E> wrapEntry = treeMultiset.wrapEntry(eVar);
            this.f9850c = wrapEntry;
            if (this.f9849b.L() == TreeMultiset.this.header) {
                this.f9849b = null;
            } else {
                this.f9849b = this.f9849b.L();
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9849b == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f9849b.x())) {
                return true;
            }
            this.f9849b = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            b5.u.h0(this.f9850c != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f9850c.getElement(), 0);
            this.f9850c = null;
        }
    }

    public class c implements Iterator<s.a<E>> {

        /* renamed from: b */
        @CheckForNull
        public e<E> f9852b;

        /* renamed from: c */
        @CheckForNull
        public s.a<E> f9853c = null;

        public c() {
            this.f9852b = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public s.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f9852b);
            s.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f9852b);
            this.f9853c = wrapEntry;
            if (this.f9852b.z() == TreeMultiset.this.header) {
                this.f9852b = null;
            } else {
                this.f9852b = this.f9852b.z();
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9852b == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f9852b.x())) {
                return true;
            }
            this.f9852b = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            b5.u.h0(this.f9853c != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f9853c.getElement(), 0);
            this.f9853c = null;
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9855a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f9855a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9855a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class f<T> {

        /* renamed from: a */
        @CheckForNull
        public T f9865a;

        public f() {
        }

        public void a(@CheckForNull T t10, @CheckForNull T t11) {
            if (this.f9865a != t10) {
                throw new ConcurrentModificationException();
            }
            this.f9865a = t11;
        }

        public void b() {
            this.f9865a = null;
        }

        @CheckForNull
        public T c() {
            return this.f9865a;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, @CheckForNull e<E> eVar) {
        long treeAggregate;
        long aggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(a1.a(this.range.getUpperEndpoint()), eVar.x());
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f9862g);
        }
        if (compare == 0) {
            int i10 = d.f9855a[this.range.getUpperBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggregate.treeAggregate(eVar.f9862g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f9862g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f9862g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f9861f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @CheckForNull e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(a1.a(this.range.getLowerEndpoint()), eVar.x());
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f9861f);
        }
        if (compare == 0) {
            int i10 = d.f9855a[this.range.getLowerBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggregate.treeAggregate(eVar.f9861f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f9861f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f9861f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f9862g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> c10 = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c10);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c10);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c10) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    @CheckForNull
    public e<E> firstNode() {
        e<E> L;
        e<E> c10 = this.rootReference.c();
        if (c10 == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object a10 = a1.a(this.range.getLowerEndpoint());
            L = c10.s(comparator(), a10);
            if (L == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(a10, L.x()) == 0) {
                L = L.L();
            }
        } else {
            L = this.header.L();
        }
        if (L == this.header || !this.range.contains(L.x())) {
            return null;
        }
        return L;
    }

    @CheckForNull
    public e<E> lastNode() {
        e<E> z10;
        e<E> c10 = this.rootReference.c();
        if (c10 == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object a10 = a1.a(this.range.getUpperEndpoint());
            z10 = c10.v(comparator(), a10);
            if (z10 == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(a10, z10.x()) == 0) {
                z10 = z10.z();
            }
        } else {
            z10 = this.header.z();
        }
        if (z10 == this.header || !this.range.contains(z10.x())) {
            return null;
        }
        return z10;
    }

    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        w.a(com.google.common.collect.d.class, "comparator").b(this, comparator);
        w.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        w.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e();
        w.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        w.f(this, objectInputStream);
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.f9864i = eVar2;
        eVar2.f9863h = eVar;
    }

    public s.a<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        w.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int add(@d1 E e10, int i10) {
        e5.i.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e10);
        }
        b5.u.d(this.range.contains(e10));
        e<E> c10 = this.rootReference.c();
        if (c10 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c10, c10.o(comparator(), e10, i10, iArr));
            return iArr[0];
        }
        comparator().compare(e10, e10);
        e<E> eVar = new e<>(e10, i10);
        e<E> eVar2 = this.header;
        successor(eVar2, eVar, eVar2);
        this.rootReference.a(c10, eVar);
        return 0;
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.h(entryIterator());
            return;
        }
        e<E> L = this.header.L();
        while (true) {
            e<E> eVar = this.header;
            if (L == eVar) {
                successor(eVar, eVar);
                this.rootReference.b();
                return;
            }
            e<E> L2 = L.L();
            L.f9857b = 0;
            L.f9861f = null;
            L.f9862g = null;
            L.f9863h = null;
            L.f9864i = null;
            L = L2;
        }
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y, e5.m1
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        try {
            e<E> c10 = this.rootReference.c();
            if (this.range.contains(obj) && c10 != null) {
                return c10.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.d
    public Iterator<s.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y
    public /* bridge */ /* synthetic */ y descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.b
    public int distinctElements() {
        return Ints.x(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.b
    public Iterator<E> elementIterator() {
        return Multisets.h(entryIterator());
    }

    @Override // com.google.common.collect.d, com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.b
    public Iterator<s.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y
    @CheckForNull
    public /* bridge */ /* synthetic */ s.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.y
    public y<E> headMultiset(@d1 E e10, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e10, boundType)), this.header);
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y
    @CheckForNull
    public /* bridge */ /* synthetic */ s.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y
    @CheckForNull
    public /* bridge */ /* synthetic */ s.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y
    @CheckForNull
    public /* bridge */ /* synthetic */ s.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        e5.i.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        e<E> c10 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c10 != null) {
                this.rootReference.a(c10, c10.E(comparator(), obj, i10, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int setCount(@d1 E e10, int i10) {
        e5.i.b(i10, c7.g.f1744b);
        if (!this.range.contains(e10)) {
            b5.u.d(i10 == 0);
            return 0;
        }
        e<E> c10 = this.rootReference.c();
        if (c10 == null) {
            if (i10 > 0) {
                add(e10, i10);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c10, c10.K(comparator(), e10, i10, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public int size() {
        return Ints.x(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.y
    public /* bridge */ /* synthetic */ y subMultiset(@d1 Object obj, BoundType boundType, @d1 Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.y
    public y<E> tailMultiset(@d1 E e10, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e10, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(@CheckForNull e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f9858c;
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        u0.a(create, iterable);
        return create;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>();
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    public static final class e<E> {

        /* renamed from: a */
        @CheckForNull
        public final E f9856a;

        /* renamed from: b */
        public int f9857b;

        /* renamed from: c */
        public int f9858c;

        /* renamed from: d */
        public long f9859d;

        /* renamed from: e */
        public int f9860e;

        /* renamed from: f */
        @CheckForNull
        public e<E> f9861f;

        /* renamed from: g */
        @CheckForNull
        public e<E> f9862g;

        /* renamed from: h */
        @CheckForNull
        public e<E> f9863h;

        /* renamed from: i */
        @CheckForNull
        public e<E> f9864i;

        public e(@d1 E e10, int i10) {
            b5.u.d(i10 > 0);
            this.f9856a = e10;
            this.f9857b = i10;
            this.f9859d = i10;
            this.f9858c = 1;
            this.f9860e = 1;
            this.f9861f = null;
            this.f9862g = null;
        }

        public static long M(@CheckForNull e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f9859d;
        }

        public static int y(@CheckForNull e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f9860e;
        }

        public final e<E> A() {
            int r10 = r();
            if (r10 == -2) {
                Objects.requireNonNull(this.f9862g);
                if (this.f9862g.r() > 0) {
                    this.f9862g = this.f9862g.I();
                }
                return H();
            }
            if (r10 != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f9861f);
            if (this.f9861f.r() < 0) {
                this.f9861f = this.f9861f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f9860e = Math.max(y(this.f9861f), y(this.f9862g)) + 1;
        }

        public final void D() {
            this.f9858c = TreeMultiset.distinctElements(this.f9861f) + 1 + TreeMultiset.distinctElements(this.f9862g);
            this.f9859d = this.f9857b + M(this.f9861f) + M(this.f9862g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> E(Comparator<? super E> comparator, @d1 E e10, int i10, int[] iArr) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f9861f = eVar.E(comparator, e10, i10, iArr);
                int i11 = iArr[0];
                if (i11 > 0) {
                    if (i10 >= i11) {
                        this.f9858c--;
                        this.f9859d -= i11;
                    } else {
                        this.f9859d -= i10;
                    }
                }
                return i11 == 0 ? this : A();
            }
            if (compare <= 0) {
                int i12 = this.f9857b;
                iArr[0] = i12;
                if (i10 >= i12) {
                    return u();
                }
                this.f9857b = i12 - i10;
                this.f9859d -= i10;
                return this;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f9862g = eVar2.E(comparator, e10, i10, iArr);
            int i13 = iArr[0];
            if (i13 > 0) {
                if (i10 >= i13) {
                    this.f9858c--;
                    this.f9859d -= i13;
                } else {
                    this.f9859d -= i10;
                }
            }
            return A();
        }

        @CheckForNull
        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                return this.f9861f;
            }
            this.f9862g = eVar2.F(eVar);
            this.f9858c--;
            this.f9859d -= eVar.f9857b;
            return A();
        }

        @CheckForNull
        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f9861f;
            if (eVar2 == null) {
                return this.f9862g;
            }
            this.f9861f = eVar2.G(eVar);
            this.f9858c--;
            this.f9859d -= eVar.f9857b;
            return A();
        }

        public final e<E> H() {
            b5.u.g0(this.f9862g != null);
            e<E> eVar = this.f9862g;
            this.f9862g = eVar.f9861f;
            eVar.f9861f = this;
            eVar.f9859d = this.f9859d;
            eVar.f9858c = this.f9858c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            b5.u.g0(this.f9861f != null);
            e<E> eVar = this.f9861f;
            this.f9861f = eVar.f9862g;
            eVar.f9862g = this;
            eVar.f9859d = this.f9859d;
            eVar.f9858c = this.f9858c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> J(Comparator<? super E> comparator, @d1 E e10, int i10, int i11, int[] iArr) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : p(e10, i11);
                }
                this.f9861f = eVar.J(comparator, e10, i10, i11, iArr);
                int i12 = iArr[0];
                if (i12 == i10) {
                    if (i11 == 0 && i12 != 0) {
                        this.f9858c--;
                    } else if (i11 > 0 && i12 == 0) {
                        this.f9858c++;
                    }
                    this.f9859d += i11 - i12;
                }
                return A();
            }
            if (compare <= 0) {
                int i13 = this.f9857b;
                iArr[0] = i13;
                if (i10 == i13) {
                    if (i11 == 0) {
                        return u();
                    }
                    this.f9859d += i11 - i13;
                    this.f9857b = i11;
                }
                return this;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return (i10 != 0 || i11 <= 0) ? this : q(e10, i11);
            }
            this.f9862g = eVar2.J(comparator, e10, i10, i11, iArr);
            int i14 = iArr[0];
            if (i14 == i10) {
                if (i11 == 0 && i14 != 0) {
                    this.f9858c--;
                } else if (i11 > 0 && i14 == 0) {
                    this.f9858c++;
                }
                this.f9859d += i11 - i14;
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> K(Comparator<? super E> comparator, @d1 E e10, int i10, int[] iArr) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? p(e10, i10) : this;
                }
                this.f9861f = eVar.K(comparator, e10, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f9858c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f9858c++;
                }
                this.f9859d += i10 - iArr[0];
                return A();
            }
            if (compare <= 0) {
                iArr[0] = this.f9857b;
                if (i10 == 0) {
                    return u();
                }
                this.f9859d += i10 - r3;
                this.f9857b = i10;
                return this;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return i10 > 0 ? q(e10, i10) : this;
            }
            this.f9862g = eVar2.K(comparator, e10, i10, iArr);
            if (i10 == 0 && iArr[0] != 0) {
                this.f9858c--;
            } else if (i10 > 0 && iArr[0] == 0) {
                this.f9858c++;
            }
            this.f9859d += i10 - iArr[0];
            return A();
        }

        public final e<E> L() {
            e<E> eVar = this.f9864i;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> o(Comparator<? super E> comparator, @d1 E e10, int i10, int[] iArr) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return p(e10, i10);
                }
                int i11 = eVar.f9860e;
                e<E> o10 = eVar.o(comparator, e10, i10, iArr);
                this.f9861f = o10;
                if (iArr[0] == 0) {
                    this.f9858c++;
                }
                this.f9859d += i10;
                return o10.f9860e == i11 ? this : A();
            }
            if (compare <= 0) {
                int i12 = this.f9857b;
                iArr[0] = i12;
                long j10 = i10;
                b5.u.d(((long) i12) + j10 <= 2147483647L);
                this.f9857b += i10;
                this.f9859d += j10;
                return this;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return q(e10, i10);
            }
            int i13 = eVar2.f9860e;
            e<E> o11 = eVar2.o(comparator, e10, i10, iArr);
            this.f9862g = o11;
            if (iArr[0] == 0) {
                this.f9858c++;
            }
            this.f9859d += i10;
            return o11.f9860e == i13 ? this : A();
        }

        public final e<E> p(@d1 E e10, int i10) {
            this.f9861f = new e<>(e10, i10);
            TreeMultiset.successor(z(), this.f9861f, this);
            this.f9860e = Math.max(2, this.f9860e);
            this.f9858c++;
            this.f9859d += i10;
            return this;
        }

        public final e<E> q(@d1 E e10, int i10) {
            e<E> eVar = new e<>(e10, i10);
            this.f9862g = eVar;
            TreeMultiset.successor(this, eVar, L());
            this.f9860e = Math.max(2, this.f9860e);
            this.f9858c++;
            this.f9859d += i10;
            return this;
        }

        public final int r() {
            return y(this.f9861f) - y(this.f9862g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final e<E> s(Comparator<? super E> comparator, @d1 E e10) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                return eVar == null ? this : (e) com.google.common.base.a.a(eVar.s(comparator, e10), this);
            }
            if (compare == 0) {
                return this;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.s(comparator, e10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, @d1 E e10) {
            int compare = comparator.compare(e10, x());
            if (compare < 0) {
                e<E> eVar = this.f9861f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.t(comparator, e10);
            }
            if (compare <= 0) {
                return this.f9857b;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                return 0;
            }
            return eVar2.t(comparator, e10);
        }

        public String toString() {
            return Multisets.k(x(), w()).toString();
        }

        @CheckForNull
        public final e<E> u() {
            int i10 = this.f9857b;
            this.f9857b = 0;
            TreeMultiset.successor(z(), L());
            e<E> eVar = this.f9861f;
            if (eVar == null) {
                return this.f9862g;
            }
            e<E> eVar2 = this.f9862g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f9860e >= eVar2.f9860e) {
                e<E> z10 = z();
                z10.f9861f = this.f9861f.F(z10);
                z10.f9862g = this.f9862g;
                z10.f9858c = this.f9858c - 1;
                z10.f9859d = this.f9859d - i10;
                return z10.A();
            }
            e<E> L = L();
            L.f9862g = this.f9862g.G(L);
            L.f9861f = this.f9861f;
            L.f9858c = this.f9858c - 1;
            L.f9859d = this.f9859d - i10;
            return L.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final e<E> v(Comparator<? super E> comparator, @d1 E e10) {
            int compare = comparator.compare(e10, x());
            if (compare > 0) {
                e<E> eVar = this.f9862g;
                return eVar == null ? this : (e) com.google.common.base.a.a(eVar.v(comparator, e10), this);
            }
            if (compare == 0) {
                return this;
            }
            e<E> eVar2 = this.f9861f;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.v(comparator, e10);
        }

        public int w() {
            return this.f9857b;
        }

        @d1
        public E x() {
            return (E) a1.a(this.f9856a);
        }

        public final e<E> z() {
            e<E> eVar = this.f9863h;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        public e() {
            this.f9856a = null;
            this.f9857b = 1;
        }
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public boolean setCount(@d1 E e10, int i10, int i11) {
        e5.i.b(i11, "newCount");
        e5.i.b(i10, "oldCount");
        b5.u.d(this.range.contains(e10));
        e<E> c10 = this.rootReference.c();
        if (c10 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c10, c10.J(comparator(), e10, i10, i11, iArr));
            return iArr[0] == i10;
        }
        if (i10 != 0) {
            return false;
        }
        if (i11 > 0) {
            add(e10, i11);
        }
        return true;
    }
}
