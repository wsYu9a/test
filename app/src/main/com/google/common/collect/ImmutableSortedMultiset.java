package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements y<E> {

    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(y<E> yVar) {
            this.comparator = yVar.comparator();
            int size = yVar.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (s.a<E> aVar : yVar.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i10 = 0; i10 < length; i10++) {
                aVar.k(this.elements[i10], this.counts[i10]);
            }
            return aVar.e();
        }
    }

    public static class a<E> extends ImmutableMultiset.b<E> {

        /* renamed from: e */
        public final Comparator<? super E> f9494e;

        /* renamed from: f */
        @a5.d
        public E[] f9495f;

        /* renamed from: g */
        public int[] f9496g;

        /* renamed from: h */
        public int f9497h;

        /* renamed from: i */
        public boolean f9498i;

        public a(Comparator<? super E> comparator) {
            super(true);
            this.f9494e = (Comparator) b5.u.E(comparator);
            this.f9495f = (E[]) new Object[4];
            this.f9496g = new int[4];
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: o */
        public a<E> g(E e10) {
            return k(e10, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: p */
        public a<E> b(E... eArr) {
            for (E e10 : eArr) {
                g(e10);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: q */
        public a<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof s) {
                for (s.a<E> aVar : ((s) iterable).entrySet()) {
                    k(aVar.getElement(), aVar.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    g(it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: r */
        public a<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: s */
        public a<E> k(E e10, int i10) {
            b5.u.E(e10);
            e5.i.b(i10, "occurrences");
            if (i10 == 0) {
                return this;
            }
            w();
            E[] eArr = this.f9495f;
            int i11 = this.f9497h;
            eArr[i11] = e10;
            this.f9496g[i11] = i10;
            this.f9497h = i11 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: t */
        public ImmutableSortedMultiset<E> e() {
            v();
            int i10 = this.f9497h;
            if (i10 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f9494e);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f9494e, i10, this.f9495f);
            long[] jArr = new long[this.f9497h + 1];
            int i11 = 0;
            while (i11 < this.f9497h) {
                int i12 = i11 + 1;
                jArr[i12] = jArr[i11] + this.f9496g[i11];
                i11 = i12;
            }
            this.f9498i = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f9497h);
        }

        public final void u(boolean z10) {
            int i10 = this.f9497h;
            if (i10 == 0) {
                return;
            }
            Object[] objArr = (E[]) Arrays.copyOf(this.f9495f, i10);
            Arrays.sort(objArr, this.f9494e);
            int i11 = 1;
            for (int i12 = 1; i12 < objArr.length; i12++) {
                if (this.f9494e.compare((Object) objArr[i11 - 1], (Object) objArr[i12]) < 0) {
                    objArr[i11] = objArr[i12];
                    i11++;
                }
            }
            Arrays.fill(objArr, i11, this.f9497h, (Object) null);
            if (z10) {
                int i13 = i11 * 4;
                int i14 = this.f9497h;
                if (i13 > i14 * 3) {
                    objArr = (E[]) Arrays.copyOf(objArr, l5.f.t(i14, (i14 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i15 = 0; i15 < this.f9497h; i15++) {
                int binarySearch = Arrays.binarySearch(objArr, 0, i11, this.f9495f[i15], this.f9494e);
                int i16 = this.f9496g[i15];
                if (i16 >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + i16;
                } else {
                    iArr[binarySearch] = ~i16;
                }
            }
            this.f9495f = (E[]) objArr;
            this.f9496g = iArr;
            this.f9497h = i11;
        }

        public final void v() {
            u(false);
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = this.f9497h;
                if (i10 >= i12) {
                    Arrays.fill(this.f9495f, i11, i12, (Object) null);
                    Arrays.fill(this.f9496g, i11, this.f9497h, 0);
                    this.f9497h = i11;
                    return;
                }
                int[] iArr = this.f9496g;
                int i13 = iArr[i10];
                if (i13 > 0) {
                    E[] eArr = this.f9495f;
                    eArr[i11] = eArr[i10];
                    iArr[i11] = i13;
                    i11++;
                }
                i10++;
            }
        }

        public final void w() {
            int i10 = this.f9497h;
            E[] eArr = this.f9495f;
            if (i10 == eArr.length) {
                u(true);
            } else if (this.f9498i) {
                this.f9495f = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.f9498i = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* renamed from: x */
        public a<E> m(E e10, int i10) {
            b5.u.E(e10);
            e5.i.b(i10, c7.g.f1744b);
            w();
            E[] eArr = this.f9495f;
            int i11 = this.f9497h;
            eArr[i11] = e10;
            this.f9496g[i11] = ~i10;
            this.f9497h = i11 + 1;
            return this;
        }
    }

    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(y<E> yVar) {
        return copyOfSortedEntries(yVar.comparator(), Lists.r(yVar.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<s.a<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        Iterator<s.a<E>> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            aVar.a(it.next().getElement());
            int i11 = i10 + 1;
            jArr[i11] = jArr[i10] + r5.getCount();
            i10 = i11;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.e(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.y, e5.m1
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ y headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final s.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final s.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ y subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ y tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y
    public ImmutableSortedMultiset<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2) {
        b5.u.y(comparator().compare(e10, e11) <= 0, "Expected lowerBound <= upperBound but %s > %s", e10, e11);
        return tailMultiset((ImmutableSortedMultiset<E>) e10, boundType).headMultiset((ImmutableSortedMultiset<E>) e11, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        b5.u.E(comparator);
        return new a(comparator).d(it).e();
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).c(iterable).e();
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList u10 = Lists.u(comparableArr.length + 6);
        Collections.addAll(u10, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(u10, comparableArr);
        return copyOf(Ordering.natural(), u10);
    }
}
