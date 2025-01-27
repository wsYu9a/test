package com.google.common.collect;

import com.google.common.primitives.Ints;
import e5.d1;
import e5.u0;
import e5.w1;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Lists {

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @d1
        final E first;
        final E[] rest;

        public OnePlusArrayList(@d1 E e10, E[] eArr) {
            this.first = e10;
            this.rest = (E[]) ((Object[]) b5.u.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public E get(int i10) {
            b5.u.C(i10, size());
            return i10 == 0 ? this.first : this.rest[i10 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return l5.f.t(this.rest.length, 1);
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int i10) {
            b5.u.C(i10, size());
            return Character.valueOf(this.string.charAt(i10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i10, int i11) {
            b5.u.f0(i10, i11, size());
            return Lists.g(this.string.substring(i10, i11));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final b5.n<? super F, ? extends T> function;

        public class a extends w1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // e5.v1
            public T a(F f10) {
                return TransformingRandomAccessList.this.function.apply(f10);
            }
        }

        public TransformingRandomAccessList(List<F> list, b5.n<? super F, ? extends T> nVar) {
            this.fromList = (List) b5.u.E(list);
            this.function = (b5.n) b5.u.E(nVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public T get(int i10) {
            return this.function.apply(this.fromList.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.fromList.listIterator(i10));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i10) {
            return this.function.apply(this.fromList.remove(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final b5.n<? super F, ? extends T> function;

        public class a extends w1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // e5.v1
            @d1
            public T a(@d1 F f10) {
                return TransformingSequentialList.this.function.apply(f10);
            }
        }

        public TransformingSequentialList(List<F> list, b5.n<? super F, ? extends T> nVar) {
            this.fromList = (List) b5.u.E(list);
            this.function = (b5.n) b5.u.E(nVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.fromList.listIterator(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @d1
        final E first;
        final E[] rest;

        @d1
        final E second;

        public TwoPlusArrayList(@d1 E e10, @d1 E e11, E[] eArr) {
            this.first = e10;
            this.second = e11;
            this.rest = (E[]) ((Object[]) b5.u.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public E get(int i10) {
            if (i10 == 0) {
                return this.first;
            }
            if (i10 == 1) {
                return this.second;
            }
            b5.u.C(i10, size());
            return this.rest[i10 - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return l5.f.t(this.rest.length, 2);
        }
    }

    public class a<E> extends f<E> {

        /* renamed from: c */
        public static final long f9581c = 0;

        public a(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i10) {
            return this.f9583b.listIterator(i10);
        }
    }

    public class b<E> extends c<E> {

        /* renamed from: c */
        public static final long f9582c = 0;

        public b(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i10) {
            return this.f9583b.listIterator(i10);
        }
    }

    public static class c<E> extends AbstractList<E> {

        /* renamed from: b */
        public final List<E> f9583b;

        public c(List<E> list) {
            this.f9583b = (List) b5.u.E(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i10, @d1 E e10) {
            this.f9583b.add(i10, e10);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i10, Collection<? extends E> collection) {
            return this.f9583b.addAll(i10, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return this.f9583b.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public E get(int i10) {
            return this.f9583b.get(i10);
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public E remove(int i10) {
            return this.f9583b.remove(i10);
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public E set(int i10, @d1 E e10) {
            return this.f9583b.set(i10, e10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f9583b.size();
        }
    }

    public static final class d extends AbstractList<Character> {

        /* renamed from: b */
        public final CharSequence f9584b;

        public d(CharSequence charSequence) {
            this.f9584b = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Character get(int i10) {
            b5.u.C(i10, size());
            return Character.valueOf(this.f9584b.charAt(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f9584b.length();
        }
    }

    public static class e<T> extends AbstractList<List<T>> {

        /* renamed from: b */
        public final List<T> f9585b;

        /* renamed from: c */
        public final int f9586c;

        public e(List<T> list, int i10) {
            this.f9585b = list;
            this.f9586c = i10;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public List<T> get(int i10) {
            b5.u.C(i10, size());
            int i11 = this.f9586c;
            int i12 = i10 * i11;
            return this.f9585b.subList(i12, Math.min(i11 + i12, this.f9585b.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f9585b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return l5.f.g(this.f9585b.size(), this.f9586c, RoundingMode.CEILING);
        }
    }

    public static class f<E> extends c<E> implements RandomAccess {
        public f(List<E> list) {
            super(list);
        }
    }

    public static class g<T> extends e<T> implements RandomAccess {
        public g(List<T> list, int i10) {
            super(list, i10);
        }
    }

    public static class h<T> extends i<T> implements RandomAccess {
        public h(List<T> list) {
            super(list);
        }
    }

    public static class i<T> extends AbstractList<T> {

        /* renamed from: b */
        public final List<T> f9587b;

        public class a implements ListIterator<T> {

            /* renamed from: b */
            public boolean f9588b;

            /* renamed from: c */
            public final /* synthetic */ ListIterator f9589c;

            public a(ListIterator listIterator) {
                this.f9589c = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(@d1 T t10) {
                this.f9589c.add(t10);
                this.f9589c.previous();
                this.f9588b = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f9589c.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f9589c.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            @d1
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f9588b = true;
                return (T) this.f9589c.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return i.this.d(this.f9589c.nextIndex());
            }

            @Override // java.util.ListIterator
            @d1
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.f9588b = true;
                return (T) this.f9589c.next();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                e5.i.e(this.f9588b);
                this.f9589c.remove();
                this.f9588b = false;
            }

            @Override // java.util.ListIterator
            public void set(@d1 T t10) {
                b5.u.g0(this.f9588b);
                this.f9589c.set(t10);
            }
        }

        public i(List<T> list) {
            this.f9587b = (List) b5.u.E(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i10, @d1 T t10) {
            this.f9587b.add(d(i10), t10);
        }

        public List<T> b() {
            return this.f9587b;
        }

        public final int c(int i10) {
            int size = size();
            b5.u.C(i10, size);
            return (size - 1) - i10;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f9587b.clear();
        }

        public final int d(int i10) {
            int size = size();
            b5.u.d0(i10, size);
            return size - i10;
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public T get(int i10) {
            return this.f9587b.get(c(i10));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.f9587b.listIterator(d(i10)));
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public T remove(int i10) {
            return this.f9587b.remove(c(i10));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i10, int i11) {
            subList(i10, i11).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @d1
        public T set(int i10, @d1 T t10) {
            return this.f9587b.set(c(i10), t10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f9587b.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i10, int i11) {
            b5.u.f0(i10, i11, size());
            return Lists.B(this.f9587b.subList(d(i11), d(i10)));
        }
    }

    public static <T> List<List<T>> A(List<T> list, int i10) {
        b5.u.E(list);
        b5.u.d(i10 > 0);
        return list instanceof RandomAccess ? new g(list, i10) : new e(list, i10);
    }

    public static <T> List<T> B(List<T> list) {
        return list instanceof ImmutableList ? ((ImmutableList) list).reverse() : list instanceof i ? ((i) list).b() : list instanceof RandomAccess ? new h(list) : new i(list);
    }

    public static <E> List<E> C(List<E> list, int i10, int i11) {
        return (list instanceof RandomAccess ? new a(list) : new b(list)).subList(i10, i11);
    }

    public static <F, T> List<T> D(List<F> list, b5.n<? super F, ? extends T> nVar) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, nVar) : new TransformingSequentialList(list, nVar);
    }

    public static <E> boolean a(List<E> list, int i10, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i10);
        Iterator<? extends E> it = iterable.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z10 = true;
        }
        return z10;
    }

    public static <E> List<E> b(@d1 E e10, @d1 E e11, E[] eArr) {
        return new TwoPlusArrayList(e10, e11, eArr);
    }

    public static <E> List<E> c(@d1 E e10, E[] eArr) {
        return new OnePlusArrayList(e10, eArr);
    }

    public static <B> List<List<B>> d(List<? extends List<? extends B>> list) {
        return CartesianList.c(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> e(List<? extends B>... listArr) {
        return d(Arrays.asList(listArr));
    }

    public static <T> List<T> f(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> g(String str) {
        return new StringAsImmutableList((String) b5.u.E(str));
    }

    @a5.a
    public static List<Character> h(CharSequence charSequence) {
        return new d((CharSequence) b5.u.E(charSequence));
    }

    @a5.d
    public static int i(int i10) {
        e5.i.b(i10, "arraySize");
        return Ints.x(i10 + 5 + (i10 / 10));
    }

    public static boolean j(List<?> list, @CheckForNull Object obj) {
        if (obj == b5.u.E(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.t(list.iterator(), list2.iterator());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!b5.r.a(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int k(List<?> list) {
        Iterator<?> it = list.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~((i10 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i10;
    }

    public static int l(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return m(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (b5.r.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int m(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int n(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return o(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (b5.r.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int o(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> p(List<E> list, int i10) {
        return new c(list).listIterator(i10);
    }

    @a5.b(serializable = true)
    public static <E> ArrayList<E> q() {
        return new ArrayList<>();
    }

    @a5.b(serializable = true)
    public static <E> ArrayList<E> r(Iterable<? extends E> iterable) {
        b5.u.E(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : s(iterable.iterator());
    }

    @a5.b(serializable = true)
    public static <E> ArrayList<E> s(Iterator<? extends E> it) {
        ArrayList<E> q10 = q();
        Iterators.a(q10, it);
        return q10;
    }

    @a5.b(serializable = true)
    @SafeVarargs
    public static <E> ArrayList<E> t(E... eArr) {
        b5.u.E(eArr);
        ArrayList<E> arrayList = new ArrayList<>(i(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @a5.b(serializable = true)
    public static <E> ArrayList<E> u(int i10) {
        e5.i.b(i10, "initialArraySize");
        return new ArrayList<>(i10);
    }

    @a5.b(serializable = true)
    public static <E> ArrayList<E> v(int i10) {
        return new ArrayList<>(i(i10));
    }

    @a5.c
    public static <E> CopyOnWriteArrayList<E> w() {
        return new CopyOnWriteArrayList<>();
    }

    @a5.c
    public static <E> CopyOnWriteArrayList<E> x(Iterable<? extends E> iterable) {
        return new CopyOnWriteArrayList<>(iterable instanceof Collection ? (Collection) iterable : r(iterable));
    }

    @a5.b(serializable = true)
    public static <E> LinkedList<E> y() {
        return new LinkedList<>();
    }

    @a5.b(serializable = true)
    public static <E> LinkedList<E> z(Iterable<? extends E> iterable) {
        LinkedList<E> y10 = y();
        u0.a(y10, iterable);
        return y10;
    }
}
