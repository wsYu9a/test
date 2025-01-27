package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.a1;
import e5.a2;
import e5.d1;
import e5.e1;
import e5.u0;
import e5.v1;
import e5.z1;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Iterators {

    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            e5.i.e(false);
        }
    }

    public class a<T> extends z1<T> {

        /* renamed from: b */
        public final /* synthetic */ Enumeration f9503b;

        public a(Enumeration enumeration) {
            this.f9503b = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9503b.hasMoreElements();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            return (T) this.f9503b.nextElement();
        }
    }

    public class b<T> implements Enumeration<T> {

        /* renamed from: a */
        public final /* synthetic */ Iterator f9504a;

        public b(Iterator it) {
            this.f9504a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f9504a.hasNext();
        }

        @Override // java.util.Enumeration
        @d1
        public T nextElement() {
            return (T) this.f9504a.next();
        }
    }

    public class c<T> extends z1<T> {

        /* renamed from: b */
        public final /* synthetic */ Iterator f9505b;

        public c(Iterator it) {
            this.f9505b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9505b.hasNext();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            return (T) this.f9505b.next();
        }
    }

    public class d<T> implements Iterator<T> {

        /* renamed from: b */
        public Iterator<T> f9506b = Iterators.w();

        /* renamed from: c */
        public final /* synthetic */ Iterable f9507c;

        public d(Iterable iterable) {
            this.f9507c = iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9506b.hasNext() || this.f9507c.iterator().hasNext();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            if (!this.f9506b.hasNext()) {
                Iterator<T> it = this.f9507c.iterator();
                this.f9506b = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.f9506b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9506b.remove();
        }
    }

    public class e<I> extends z1<I> {

        /* renamed from: b */
        public int f9508b = 0;

        /* renamed from: c */
        public final /* synthetic */ Iterator[] f9509c;

        public e(Iterator[] itArr) {
            this.f9509c = itArr;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Iterator next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f9509c[this.f9508b];
            Objects.requireNonNull(it);
            Iterator it2 = it;
            Iterator[] itArr = this.f9509c;
            int i10 = this.f9508b;
            itArr[i10] = null;
            this.f9508b = i10 + 1;
            return it2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9508b < this.f9509c.length;
        }
    }

    public class f<T> extends z1<List<T>> {

        /* renamed from: b */
        public final /* synthetic */ Iterator f9510b;

        /* renamed from: c */
        public final /* synthetic */ int f9511c;

        /* renamed from: d */
        public final /* synthetic */ boolean f9512d;

        public f(Iterator it, int i10, boolean z10) {
            this.f9510b = it;
            this.f9511c = i10;
            this.f9512d = z10;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = new Object[this.f9511c];
            int i10 = 0;
            while (i10 < this.f9511c && this.f9510b.hasNext()) {
                objArr[i10] = this.f9510b.next();
                i10++;
            }
            for (int i11 = i10; i11 < this.f9511c; i11++) {
                objArr[i11] = null;
            }
            List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.f9512d || i10 == this.f9511c) ? unmodifiableList : unmodifiableList.subList(0, i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9510b.hasNext();
        }
    }

    public class g<T> extends AbstractIterator<T> {

        /* renamed from: d */
        public final /* synthetic */ Iterator f9513d;

        /* renamed from: e */
        public final /* synthetic */ b5.v f9514e;

        public g(Iterator it, b5.v vVar) {
            this.f9513d = it;
            this.f9514e = vVar;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public T a() {
            while (this.f9513d.hasNext()) {
                T t10 = (T) this.f9513d.next();
                if (this.f9514e.apply(t10)) {
                    return t10;
                }
            }
            return b();
        }
    }

    public class h<F, T> extends v1<F, T> {

        /* renamed from: c */
        public final /* synthetic */ b5.n f9515c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Iterator it, b5.n nVar) {
            super(it);
            this.f9515c = nVar;
        }

        @Override // e5.v1
        @d1
        public T a(@d1 F f10) {
            return (T) this.f9515c.apply(f10);
        }
    }

    public class i<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9516b;

        /* renamed from: c */
        public final /* synthetic */ int f9517c;

        /* renamed from: d */
        public final /* synthetic */ Iterator f9518d;

        public i(int i10, Iterator it) {
            this.f9517c = i10;
            this.f9518d = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9516b < this.f9517c && this.f9518d.hasNext();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f9516b++;
            return (T) this.f9518d.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9518d.remove();
        }
    }

    public class j<T> extends z1<T> {

        /* renamed from: b */
        public final /* synthetic */ Iterator f9519b;

        public j(Iterator it) {
            this.f9519b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9519b.hasNext();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            T t10 = (T) this.f9519b.next();
            this.f9519b.remove();
            return t10;
        }

        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    public class k<T> extends z1<T> {

        /* renamed from: b */
        public boolean f9520b;

        /* renamed from: c */
        public final /* synthetic */ Object f9521c;

        public k(Object obj) {
            this.f9521c = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f9520b;
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            if (this.f9520b) {
                throw new NoSuchElementException();
            }
            this.f9520b = true;
            return (T) this.f9521c;
        }
    }

    public static final class l<T> extends e5.a<T> {

        /* renamed from: f */
        public static final a2<Object> f9522f = new l(new Object[0], 0, 0, 0);

        /* renamed from: d */
        public final T[] f9523d;

        /* renamed from: e */
        public final int f9524e;

        public l(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.f9523d = tArr;
            this.f9524e = i10;
        }

        @Override // e5.a
        @d1
        public T a(int i10) {
            return this.f9523d[this.f9524e + i10];
        }
    }

    public static class m<T> implements Iterator<T> {

        /* renamed from: b */
        @CheckForNull
        public Iterator<? extends T> f9525b;

        /* renamed from: c */
        public Iterator<? extends T> f9526c = Iterators.u();

        /* renamed from: d */
        @CheckForNull
        public Iterator<? extends Iterator<? extends T>> f9527d;

        /* renamed from: e */
        @CheckForNull
        public Deque<Iterator<? extends Iterator<? extends T>>> f9528e;

        public m(Iterator<? extends Iterator<? extends T>> it) {
            this.f9527d = (Iterator) b5.u.E(it);
        }

        @CheckForNull
        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f9527d;
                if (it != null && it.hasNext()) {
                    return this.f9527d;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f9528e;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f9527d = this.f9528e.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) b5.u.E(this.f9526c)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a10 = a();
                this.f9527d = a10;
                if (a10 == null) {
                    return false;
                }
                Iterator<? extends T> next = a10.next();
                this.f9526c = next;
                if (next instanceof m) {
                    m mVar = (m) next;
                    this.f9526c = mVar.f9526c;
                    if (this.f9528e == null) {
                        this.f9528e = new ArrayDeque();
                    }
                    this.f9528e.addFirst(this.f9527d);
                    if (mVar.f9528e != null) {
                        while (!mVar.f9528e.isEmpty()) {
                            this.f9528e.addFirst(mVar.f9528e.removeLast());
                        }
                    }
                    this.f9527d = mVar.f9527d;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.f9526c;
            this.f9525b = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f9525b;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f9525b = null;
        }
    }

    public static class n<T> extends z1<T> {

        /* renamed from: b */
        public final Queue<e1<T>> f9529b;

        public n(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f9529b = new PriorityQueue(2, new Comparator() { // from class: e5.v0

                /* renamed from: b */
                public final /* synthetic */ Comparator f25661b;

                public /* synthetic */ v0(Comparator comparator2) {
                    comparator = comparator2;
                }

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int b10;
                    b10 = Iterators.n.b(comparator, (e1) obj, (e1) obj2);
                    return b10;
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f9529b.add(Iterators.T(it));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, e1 e1Var, e1 e1Var2) {
            return comparator.compare(e1Var.peek(), e1Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f9529b.isEmpty();
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            e1<T> remove = this.f9529b.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f9529b.add(remove);
            }
            return next;
        }
    }

    public static class o<E> implements e1<E> {

        /* renamed from: b */
        public final Iterator<? extends E> f9530b;

        /* renamed from: c */
        public boolean f9531c;

        /* renamed from: d */
        @CheckForNull
        public E f9532d;

        public o(Iterator<? extends E> it) {
            this.f9530b = (Iterator) b5.u.E(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9531c || this.f9530b.hasNext();
        }

        @Override // e5.e1, java.util.Iterator
        @d1
        public E next() {
            if (!this.f9531c) {
                return this.f9530b.next();
            }
            E e10 = (E) a1.a(this.f9532d);
            this.f9531c = false;
            this.f9532d = null;
            return e10;
        }

        @Override // e5.e1
        @d1
        public E peek() {
            if (!this.f9531c) {
                this.f9532d = this.f9530b.next();
                this.f9531c = true;
            }
            return (E) a1.a(this.f9532d);
        }

        @Override // e5.e1, java.util.Iterator
        public void remove() {
            b5.u.h0(!this.f9531c, "Can't remove after you've peeked at next");
            this.f9530b.remove();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T A(Iterator<? extends T> it, b5.v<? super T> vVar, @CheckForNull T t10) {
        b5.u.E(it);
        b5.u.E(vVar);
        while (it.hasNext()) {
            T next = it.next();
            if (vVar.apply(next)) {
                return next;
            }
        }
        return t10;
    }

    @SafeVarargs
    public static <T> z1<T> B(T... tArr) {
        return C(tArr, 0, tArr.length, 0);
    }

    public static <T> a2<T> C(T[] tArr, int i10, int i11, int i12) {
        b5.u.d(i11 >= 0);
        b5.u.f0(i10, i10 + i11, tArr.length);
        b5.u.d0(i12, i11);
        return i11 == 0 ? v() : new l(tArr, i10, i11, i12);
    }

    public static <T> z1<T> D(Enumeration<T> enumeration) {
        b5.u.E(enumeration);
        return new a(enumeration);
    }

    public static int E(Iterator<?> it, @CheckForNull Object obj) {
        int i10 = 0;
        while (q(it, obj)) {
            i10++;
        }
        return i10;
    }

    @d1
    public static <T> T F(Iterator<T> it, int i10) {
        g(i10);
        int b10 = b(it, i10);
        if (it.hasNext()) {
            return it.next();
        }
        StringBuilder sb2 = new StringBuilder(91);
        sb2.append("position (");
        sb2.append(i10);
        sb2.append(") must be less than the number of elements that remained (");
        sb2.append(b10);
        sb2.append(")");
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    @d1
    public static <T> T G(Iterator<? extends T> it, int i10, @d1 T t10) {
        g(i10);
        b(it, i10);
        return (T) J(it, t10);
    }

    @d1
    public static <T> T H(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @d1
    public static <T> T I(Iterator<? extends T> it, @d1 T t10) {
        return it.hasNext() ? (T) H(it) : t10;
    }

    @d1
    public static <T> T J(Iterator<? extends T> it, @d1 T t10) {
        return it.hasNext() ? it.next() : t10;
    }

    @d1
    public static <T> T K(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i10 = 0; i10 < 4 && it.hasNext(); i10++) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append(Typography.greater);
        throw new IllegalArgumentException(sb2.toString());
    }

    @d1
    public static <T> T L(Iterator<? extends T> it, @d1 T t10) {
        return it.hasNext() ? (T) K(it) : t10;
    }

    public static <T> int M(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.F(vVar, "predicate");
        int i10 = 0;
        while (it.hasNext()) {
            if (vVar.apply(it.next())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> Iterator<T> N(Iterator<T> it, int i10) {
        b5.u.E(it);
        b5.u.e(i10 >= 0, "limit is negative");
        return new i(i10, it);
    }

    @a5.a
    public static <T> z1<T> O(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        b5.u.F(iterable, "iterators");
        b5.u.F(comparator, "comparator");
        return new n(iterable, comparator);
    }

    public static <T> z1<List<T>> P(Iterator<T> it, int i10) {
        return R(it, i10, true);
    }

    public static <T> z1<List<T>> Q(Iterator<T> it, int i10) {
        return R(it, i10, false);
    }

    public static <T> z1<List<T>> R(Iterator<T> it, int i10, boolean z10) {
        b5.u.E(it);
        b5.u.d(i10 > 0);
        return new f(it, i10, z10);
    }

    @Deprecated
    public static <T> e1<T> S(e1<T> e1Var) {
        return (e1) b5.u.E(e1Var);
    }

    public static <T> e1<T> T(Iterator<? extends T> it) {
        return it instanceof o ? (o) it : new o(it);
    }

    @CheckForNull
    public static <T> T U(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean V(Iterator<?> it, Collection<?> collection) {
        b5.u.E(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @CanIgnoreReturnValue
    public static <T> boolean W(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.E(vVar);
        boolean z10 = false;
        while (it.hasNext()) {
            if (vVar.apply(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @CanIgnoreReturnValue
    public static boolean X(Iterator<?> it, Collection<?> collection) {
        b5.u.E(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> z1<T> Y(@d1 T t10) {
        return new k(t10);
    }

    public static int Z(Iterator<?> it) {
        long j10 = 0;
        while (it.hasNext()) {
            it.next();
            j10++;
        }
        return Ints.x(j10);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        b5.u.E(collection);
        b5.u.E(it);
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= collection.add(it.next());
        }
        return z10;
    }

    @a5.c
    public static <T> T[] a0(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) u0.Q(Lists.s(it), cls);
    }

    @CanIgnoreReturnValue
    public static int b(Iterator<?> it, int i10) {
        b5.u.E(it);
        int i11 = 0;
        b5.u.e(i10 >= 0, "numberToAdvance must be nonnegative");
        while (i11 < i10 && it.hasNext()) {
            it.next();
            i11++;
        }
        return i11;
    }

    public static String b0(Iterator<?> it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        while (it.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(it.next());
            z10 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <T> boolean c(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.E(vVar);
        while (it.hasNext()) {
            if (!vVar.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> c0(Iterator<F> it, b5.n<? super F, ? extends T> nVar) {
        b5.u.E(nVar);
        return new h(it, nVar);
    }

    public static <T> boolean d(Iterator<T> it, b5.v<? super T> vVar) {
        return M(it, vVar) != -1;
    }

    public static <T> Optional<T> d0(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.E(it);
        b5.u.E(vVar);
        while (it.hasNext()) {
            T next = it.next();
            if (vVar.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> Enumeration<T> e(Iterator<T> it) {
        b5.u.E(it);
        return new b(it);
    }

    @Deprecated
    public static <T> z1<T> e0(z1<T> z1Var) {
        return (z1) b5.u.E(z1Var);
    }

    public static <T> ListIterator<T> f(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static <T> z1<T> f0(Iterator<? extends T> it) {
        b5.u.E(it);
        return it instanceof z1 ? (z1) it : new c(it);
    }

    public static void g(int i10) {
        if (i10 >= 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("position (");
        sb2.append(i10);
        sb2.append(") must not be negative");
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public static void h(Iterator<?> it) {
        b5.u.E(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> i(Iterator<? extends Iterator<? extends T>> it) {
        return new m(it);
    }

    public static <T> Iterator<T> j(Iterator<? extends T> it, Iterator<? extends T> it2) {
        b5.u.E(it);
        b5.u.E(it2);
        return i(o(it, it2));
    }

    public static <T> Iterator<T> k(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        b5.u.E(it);
        b5.u.E(it2);
        b5.u.E(it3);
        return i(o(it, it2, it3));
    }

    public static <T> Iterator<T> l(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        b5.u.E(it);
        b5.u.E(it2);
        b5.u.E(it3);
        b5.u.E(it4);
        return i(o(it, it2, it3, it4));
    }

    public static <T> Iterator<T> m(Iterator<? extends T>... itArr) {
        return n((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> n(Iterator<? extends T>... itArr) {
        for (Iterator it : (Iterator[]) b5.u.E(itArr)) {
            b5.u.E(it);
        }
        return i(o(itArr));
    }

    public static <I extends Iterator<?>> Iterator<I> o(I... iArr) {
        return new e(iArr);
    }

    public static <T> Iterator<T> p(Iterator<T> it) {
        b5.u.E(it);
        return new j(it);
    }

    public static boolean q(Iterator<?> it, @CheckForNull Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> r(Iterable<T> iterable) {
        b5.u.E(iterable);
        return new d(iterable);
    }

    @SafeVarargs
    public static <T> Iterator<T> s(T... tArr) {
        return r(Lists.t(tArr));
    }

    public static boolean t(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !b5.r.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> z1<T> u() {
        return v();
    }

    public static <T> a2<T> v() {
        return (a2<T>) l.f9522f;
    }

    public static <T> Iterator<T> w() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> z1<T> x(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.E(it);
        b5.u.E(vVar);
        return new g(it, vVar);
    }

    @a5.c
    public static <T> z1<T> y(Iterator<?> it, Class<T> cls) {
        return x(it, Predicates.o(cls));
    }

    @d1
    public static <T> T z(Iterator<T> it, b5.v<? super T> vVar) {
        b5.u.E(it);
        b5.u.E(vVar);
        while (it.hasNext()) {
            T next = it.next();
            if (vVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }
}
