package e5;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@m
/* loaded from: classes2.dex */
public abstract class w<E> implements Iterable<E> {

    /* renamed from: b */
    public final Optional<Iterable<E>> f25663b;

    public class a extends w<E> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25664c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f25664c = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f25664c.iterator();
        }
    }

    public class b<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25665c;

        public b(Iterable iterable) {
            this.f25665c = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.i(Iterators.c0(this.f25665c.iterator(), u0.S()));
        }
    }

    public class c<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable[] f25666c;

        public class a extends e5.a<Iterator<? extends T>> {
            public a(int i10) {
                super(i10);
            }

            @Override // e5.a
            /* renamed from: b */
            public Iterator<? extends T> a(int i10) {
                return c.this.f25666c[i10].iterator();
            }
        }

        public c(Iterable[] iterableArr) {
            this.f25666c = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.i(new a(this.f25666c.length));
        }
    }

    public static class d<E> implements b5.n<Iterable<E>, w<E>> {
        @Override // b5.n
        /* renamed from: a */
        public w<E> apply(Iterable<E> iterable) {
            return w.r(iterable);
        }
    }

    public w() {
        this.f25663b = Optional.absent();
    }

    @a5.a
    public static <T> w<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        b5.u.E(iterable);
        return new b(iterable);
    }

    @a5.a
    public static <T> w<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return j(iterable, iterable2);
    }

    @a5.a
    public static <T> w<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return j(iterable, iterable2, iterable3);
    }

    @a5.a
    public static <T> w<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return j(iterable, iterable2, iterable3, iterable4);
    }

    @a5.a
    public static <T> w<T> i(Iterable<? extends T>... iterableArr) {
        return j((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    public static <T> w<T> j(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            b5.u.E(iterable);
        }
        return new c(iterableArr);
    }

    @InlineMe(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> w<E> q(w<E> wVar) {
        return (w) b5.u.E(wVar);
    }

    public static <E> w<E> r(Iterable<E> iterable) {
        return iterable instanceof w ? (w) iterable : new a(iterable, iterable);
    }

    @a5.a
    public static <E> w<E> s(E[] eArr) {
        return r(Arrays.asList(eArr));
    }

    @a5.a
    public static <E> w<E> y() {
        return r(Collections.emptyList());
    }

    @a5.a
    public static <E> w<E> z(@d1 E e10, E... eArr) {
        return r(Lists.c(e10, eArr));
    }

    public final w<E> A(int i10) {
        return r(u0.N(t(), i10));
    }

    @a5.c
    public final E[] B(Class<E> cls) {
        return (E[]) u0.Q(t(), cls);
    }

    public final ImmutableList<E> C() {
        return ImmutableList.copyOf(t());
    }

    public final <V> ImmutableMap<E, V> D(b5.n<? super E, V> nVar) {
        return Maps.u0(t(), nVar);
    }

    public final ImmutableMultiset<E> E() {
        return ImmutableMultiset.copyOf(t());
    }

    public final ImmutableSet<E> F() {
        return ImmutableSet.copyOf(t());
    }

    public final ImmutableList<E> G(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(t());
    }

    public final ImmutableSortedSet<E> H(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, t());
    }

    public final <T> w<T> I(b5.n<? super E, T> nVar) {
        return r(u0.U(t(), nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> w<T> J(b5.n<? super E, ? extends Iterable<? extends T>> nVar) {
        return e(I(nVar));
    }

    public final <K> ImmutableMap<K, E> K(b5.n<? super E, K> nVar) {
        return Maps.E0(t(), nVar);
    }

    public final boolean a(b5.v<? super E> vVar) {
        return u0.b(t(), vVar);
    }

    public final boolean b(b5.v<? super E> vVar) {
        return u0.c(t(), vVar);
    }

    @a5.a
    public final w<E> c(Iterable<? extends E> iterable) {
        return f(t(), iterable);
    }

    public final boolean contains(@CheckForNull Object obj) {
        return u0.k(t(), obj);
    }

    @a5.a
    public final w<E> d(E... eArr) {
        return f(t(), Arrays.asList(eArr));
    }

    @d1
    public final E get(int i10) {
        return (E) u0.t(t(), i10);
    }

    public final boolean isEmpty() {
        return !t().iterator().hasNext();
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C k(C c10) {
        b5.u.E(c10);
        Iterable<E> t10 = t();
        if (t10 instanceof Collection) {
            c10.addAll((Collection) t10);
        } else {
            Iterator<E> it = t10.iterator();
            while (it.hasNext()) {
                c10.add(it.next());
            }
        }
        return c10;
    }

    public final w<E> l() {
        return r(u0.l(t()));
    }

    public final w<E> m(b5.v<? super E> vVar) {
        return r(u0.o(t(), vVar));
    }

    @a5.c
    public final <T> w<T> n(Class<T> cls) {
        return r(u0.p(t(), cls));
    }

    public final Optional<E> o() {
        Iterator<E> it = t().iterator();
        return it.hasNext() ? Optional.of(it.next()) : Optional.absent();
    }

    public final Optional<E> p(b5.v<? super E> vVar) {
        return u0.V(t(), vVar);
    }

    public final int size() {
        return u0.M(t());
    }

    public final Iterable<E> t() {
        return this.f25663b.or((Optional<Iterable<E>>) this);
    }

    public String toString() {
        return u0.T(t());
    }

    public final <K> ImmutableListMultimap<K, E> u(b5.n<? super E, K> nVar) {
        return Multimaps.r(t(), nVar);
    }

    @a5.a
    public final String v(b5.p pVar) {
        return pVar.k(this);
    }

    public final Optional<E> w() {
        E next;
        Iterable<E> t10 = t();
        if (t10 instanceof List) {
            List list = (List) t10;
            return list.isEmpty() ? Optional.absent() : Optional.of(list.get(list.size() - 1));
        }
        Iterator<E> it = t10.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (t10 instanceof SortedSet) {
            return Optional.of(((SortedSet) t10).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.of(next);
    }

    public final w<E> x(int i10) {
        return r(u0.D(t(), i10));
    }

    public w(Iterable<E> iterable) {
        this.f25663b = Optional.of(iterable);
    }
}
