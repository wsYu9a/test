package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.u0;
import e5.u1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @a5.d
    public static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IncomparableValueException(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                int r1 = r1 + 22
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Cannot compare value: "
                r2.append(r1)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r3.<init>(r0)
                r3.value = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Ordering.IncomparableValueException.<init>(java.lang.Object):void");
        }
    }

    @a5.d
    public static class a extends Ordering<Object> {

        /* renamed from: b */
        public final AtomicInteger f9747b = new AtomicInteger(0);

        /* renamed from: c */
        public final ConcurrentMap<Object, Integer> f9748c = u.l(new MapMaker()).i();

        public final Integer a(Object obj) {
            Integer num = this.f9748c.get(obj);
            if (num != null) {
                return num;
            }
            Integer valueOf = Integer.valueOf(this.f9747b.getAndIncrement());
            Integer putIfAbsent = this.f9748c.putIfAbsent(obj, valueOf);
            return putIfAbsent != null ? putIfAbsent : valueOf;
        }

        public int b(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b10 = b(obj);
            int b11 = b(obj2);
            if (b10 != b11) {
                return b10 < b11 ? -1 : 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    public static class b {

        /* renamed from: a */
        public static final Ordering<Object> f9749a = new a();
    }

    @a5.b(serializable = true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f9749a;
    }

    @a5.b(serializable = true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @a5.b(serializable = true)
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @a5.b(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @a5.b(serializable = true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, @d1 T t10) {
        return Collections.binarySearch(list, t10, this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@d1 T t10, @d1 T t11);

    @a5.b(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) b5.u.E(comparator));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i10) {
        return reverse().leastOf(iterable, i10);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i10) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i10 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i10) {
                    array = Arrays.copyOf(array, i10);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i10);
    }

    @a5.b(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @d1
    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    @d1
    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @a5.b(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @a5.b(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.R());
    }

    @a5.b(serializable = true)
    public <F> Ordering<F> onResultOf(b5.n<F, ? extends T> nVar) {
        return new ByFunctionOrdering(nVar, this);
    }

    @a5.b(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] P = u0.P(iterable);
        Arrays.sort(P, this);
        return Lists.r(Arrays.asList(P));
    }

    @a5.b(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @a5.b(serializable = true)
    public static <T> Ordering<T> explicit(T t10, T... tArr) {
        return explicit(Lists.c(t10, tArr));
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i10) {
        return reverse().leastOf(it, i10);
    }

    @a5.b(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) b5.u.E(ordering);
    }

    @d1
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    @d1
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d1
    public <E extends T> E max(@d1 E e10, @d1 E e11) {
        return compare(e10, e11) >= 0 ? e10 : e11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d1
    public <E extends T> E min(@d1 E e10, @d1 E e11) {
        return compare(e10, e11) <= 0 ? e10 : e11;
    }

    @d1
    public <E extends T> E max(@d1 E e10, @d1 E e11, @d1 E e12, E... eArr) {
        E e13 = (E) max(max(e10, e11), e12);
        for (E e14 : eArr) {
            e13 = (E) max(e13, e14);
        }
        return e13;
    }

    @d1
    public <E extends T> E min(@d1 E e10, @d1 E e11, @d1 E e12, E... eArr) {
        E e13 = (E) min(min(e10, e11), e12);
        for (E e14 : eArr) {
            e13 = (E) min(e13, e14);
        }
        return e13;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i10) {
        b5.u.E(it);
        e5.i.b(i10, "k");
        if (i10 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i10 >= 1073741823) {
            ArrayList s10 = Lists.s(it);
            Collections.sort(s10, this);
            if (s10.size() > i10) {
                s10.subList(i10, s10.size()).clear();
            }
            s10.trimToSize();
            return Collections.unmodifiableList(s10);
        }
        u1 d10 = u1.d(i10, this);
        d10.g(it);
        return d10.j();
    }
}
