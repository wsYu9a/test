package com.google.common.collect;

import com.google.common.base.Predicates;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import e5.d1;
import e5.u0;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class f {

    public static class a<E> extends AbstractCollection<E> {

        /* renamed from: b */
        public final Collection<E> f9918b;

        /* renamed from: c */
        public final b5.v<? super E> f9919c;

        public a(Collection<E> collection, b5.v<? super E> vVar) {
            this.f9918b = collection;
            this.f9919c = vVar;
        }

        public a<E> a(b5.v<? super E> vVar) {
            return new a<>(this.f9918b, Predicates.d(this.f9919c, vVar));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@d1 E e10) {
            b5.u.d(this.f9919c.apply(e10));
            return this.f9918b.add(e10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                b5.u.d(this.f9919c.apply(it.next()));
            }
            return this.f9918b.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            u0.J(this.f9918b, this.f9919c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (f.j(this.f9918b, obj)) {
                return this.f9919c.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !u0.c(this.f9918b, this.f9919c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.x(this.f9918b.iterator(), this.f9919c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            return contains(obj) && this.f9918b.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.f9918b.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f9919c.apply(next) && collection.contains(next)) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.f9918b.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f9919c.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f9918b.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (this.f9919c.apply(it.next())) {
                    i10++;
                }
            }
            return i10;
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

    public static final class b<E> extends AbstractCollection<List<E>> {

        /* renamed from: b */
        public final ImmutableList<E> f9920b;

        /* renamed from: c */
        public final Comparator<? super E> f9921c;

        /* renamed from: d */
        public final int f9922d;

        public b(Iterable<E> iterable, Comparator<? super E> comparator) {
            ImmutableList<E> sortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.f9920b = sortedCopyOf;
            this.f9921c = comparator;
            this.f9922d = a(sortedCopyOf, comparator);
        }

        public static <E> int a(List<E> list, Comparator<? super E> comparator) {
            int i10 = 1;
            int i11 = 1;
            int i12 = 1;
            while (i10 < list.size()) {
                if (comparator.compare(list.get(i10 - 1), list.get(i10)) < 0) {
                    i11 = l5.f.u(i11, l5.f.a(i10, i12));
                    if (i11 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i12 = 0;
                }
                i10++;
                i12++;
            }
            return l5.f.u(i11, l5.f.a(i10, i12));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return f.e(this.f9920b, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new c(this.f9920b, this.f9921c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f9922d;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String valueOf = String.valueOf(this.f9920b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
            sb2.append("orderedPermutationCollection(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class c<E> extends AbstractIterator<List<E>> {

        /* renamed from: d */
        @CheckForNull
        public List<E> f9923d;

        /* renamed from: e */
        public final Comparator<? super E> f9924e;

        public c(List<E> list, Comparator<? super E> comparator) {
            this.f9923d = Lists.r(list);
            this.f9924e = comparator;
        }

        public void d() {
            int f10 = f();
            if (f10 == -1) {
                this.f9923d = null;
                return;
            }
            Objects.requireNonNull(this.f9923d);
            Collections.swap(this.f9923d, f10, g(f10));
            Collections.reverse(this.f9923d.subList(f10 + 1, this.f9923d.size()));
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            List<E> list = this.f9923d;
            if (list == null) {
                return b();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) list);
            d();
            return copyOf;
        }

        public int f() {
            Objects.requireNonNull(this.f9923d);
            for (int size = this.f9923d.size() - 2; size >= 0; size--) {
                if (this.f9924e.compare(this.f9923d.get(size), this.f9923d.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int g(int i10) {
            Objects.requireNonNull(this.f9923d);
            E e10 = this.f9923d.get(i10);
            for (int size = this.f9923d.size() - 1; size > i10; size--) {
                if (this.f9924e.compare(e10, this.f9923d.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static final class d<E> extends AbstractCollection<List<E>> {

        /* renamed from: b */
        public final ImmutableList<E> f9925b;

        public d(ImmutableList<E> immutableList) {
            this.f9925b = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return f.e(this.f9925b, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new e(this.f9925b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return l5.f.h(this.f9925b.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String valueOf = String.valueOf(this.f9925b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
            sb2.append("permutations(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class e<E> extends AbstractIterator<List<E>> {

        /* renamed from: d */
        public final List<E> f9926d;

        /* renamed from: e */
        public final int[] f9927e;

        /* renamed from: f */
        public final int[] f9928f;

        /* renamed from: g */
        public int f9929g;

        public e(List<E> list) {
            this.f9926d = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f9927e = iArr;
            int[] iArr2 = new int[size];
            this.f9928f = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f9929g = Integer.MAX_VALUE;
        }

        public void d() {
            int size = this.f9926d.size() - 1;
            this.f9929g = size;
            if (size == -1) {
                return;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f9927e;
                int i11 = this.f9929g;
                int i12 = iArr[i11];
                int i13 = this.f9928f[i11] + i12;
                if (i13 < 0) {
                    f();
                } else if (i13 != i11 + 1) {
                    Collections.swap(this.f9926d, (i11 - i12) + i10, (i11 - i13) + i10);
                    this.f9927e[this.f9929g] = i13;
                    return;
                } else {
                    if (i11 == 0) {
                        return;
                    }
                    i10++;
                    f();
                }
            }
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            if (this.f9929g <= 0) {
                return b();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f9926d);
            d();
            return copyOf;
        }

        public void f() {
            int[] iArr = this.f9928f;
            int i10 = this.f9929g;
            iArr[i10] = -iArr[i10];
            this.f9929g = i10 - 1;
        }
    }

    /* renamed from: com.google.common.collect.f$f */
    public static class C0290f<F, T> extends AbstractCollection<T> {

        /* renamed from: b */
        public final Collection<F> f9930b;

        /* renamed from: c */
        public final b5.n<? super F, ? extends T> f9931c;

        public C0290f(Collection<F> collection, b5.n<? super F, ? extends T> nVar) {
            this.f9930b = (Collection) b5.u.E(collection);
            this.f9931c = (b5.n) b5.u.E(nVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f9930b.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f9930b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.c0(this.f9930b.iterator(), this.f9931c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f9930b.size();
        }
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> t<E> c(Collection<E> collection) {
        t<E> tVar = new t<>();
        for (E e10 : collection) {
            tVar.v(e10, tVar.g(e10) + 1);
        }
        return tVar;
    }

    public static <E> Collection<E> d(Collection<E> collection, b5.v<? super E> vVar) {
        return collection instanceof a ? ((a) collection).a(vVar) : new a((Collection) b5.u.E(collection), (b5.v) b5.u.E(vVar));
    }

    public static boolean e(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        t c10 = c(list);
        t c11 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (c10.l(i10) != c11.g(c10.j(i10))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder f(int i10) {
        e5.i.b(i10, "size");
        return new StringBuilder((int) Math.min(i10 * 8, DownloadConstants.GB));
    }

    @a5.a
    public static <E extends Comparable<? super E>> Collection<List<E>> g(Iterable<E> iterable) {
        return h(iterable, Ordering.natural());
    }

    @a5.a
    public static <E> Collection<List<E>> h(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new b(iterable, comparator);
    }

    @a5.a
    public static <E> Collection<List<E>> i(Collection<E> collection) {
        return new d(ImmutableList.copyOf((Collection) collection));
    }

    public static boolean j(Collection<?> collection, @CheckForNull Object obj) {
        b5.u.E(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean k(Collection<?> collection, @CheckForNull Object obj) {
        b5.u.E(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String l(Collection<?> collection) {
        StringBuilder f10 = f(collection.size());
        f10.append('[');
        boolean z10 = true;
        for (Object obj : collection) {
            if (!z10) {
                f10.append(", ");
            }
            if (obj == collection) {
                f10.append("(this Collection)");
            } else {
                f10.append(obj);
            }
            z10 = false;
        }
        f10.append(']');
        return f10.toString();
    }

    public static <F, T> Collection<T> m(Collection<F> collection, b5.n<? super F, T> nVar) {
        return new C0290f(collection, nVar);
    }
}
