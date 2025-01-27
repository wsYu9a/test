package e5;

import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@m
/* loaded from: classes2.dex */
public final class u0 {

    public class a<T> implements b5.n<Iterable<? extends T>, Iterator<? extends T>> {
        @Override // b5.n
        /* renamed from: a */
        public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    public class b<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25637c;

        public b(Iterable iterable) {
            this.f25637c = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.r(this.f25637c);
        }

        @Override // e5.w
        public String toString() {
            return String.valueOf(this.f25637c.toString()).concat(" (cycled)");
        }
    }

    public class c<T> extends w<List<T>> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25638c;

        /* renamed from: d */
        public final /* synthetic */ int f25639d;

        public c(Iterable iterable, int i10) {
            this.f25638c = iterable;
            this.f25639d = i10;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.Q(this.f25638c.iterator(), this.f25639d);
        }
    }

    public class d<T> extends w<List<T>> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25640c;

        /* renamed from: d */
        public final /* synthetic */ int f25641d;

        public d(Iterable iterable, int i10) {
            this.f25640c = iterable;
            this.f25641d = i10;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.P(this.f25640c.iterator(), this.f25641d);
        }
    }

    public class e<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25642c;

        /* renamed from: d */
        public final /* synthetic */ b5.v f25643d;

        public e(Iterable iterable, b5.v vVar) {
            this.f25642c = iterable;
            this.f25643d = vVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.x(this.f25642c.iterator(), this.f25643d);
        }
    }

    public class f<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25644c;

        /* renamed from: d */
        public final /* synthetic */ b5.n f25645d;

        public f(Iterable iterable, b5.n nVar) {
            this.f25644c = iterable;
            this.f25645d = nVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.c0(this.f25644c.iterator(), this.f25645d);
        }
    }

    public class g<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25646c;

        /* renamed from: d */
        public final /* synthetic */ int f25647d;

        public class a implements Iterator<T> {

            /* renamed from: b */
            public boolean f25648b = true;

            /* renamed from: c */
            public final /* synthetic */ Iterator f25649c;

            public a(g gVar, Iterator it) {
                this.f25649c = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f25649c.hasNext();
            }

            @Override // java.util.Iterator
            @d1
            public T next() {
                T t10 = (T) this.f25649c.next();
                this.f25648b = false;
                return t10;
            }

            @Override // java.util.Iterator
            public void remove() {
                e5.i.e(!this.f25648b);
                this.f25649c.remove();
            }
        }

        public g(Iterable iterable, int i10) {
            this.f25646c = iterable;
            this.f25647d = i10;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f25646c;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f25647d), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.b(it, this.f25647d);
            return new a(this, it);
        }
    }

    public class h<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25650c;

        /* renamed from: d */
        public final /* synthetic */ int f25651d;

        public h(Iterable iterable, int i10) {
            this.f25650c = iterable;
            this.f25651d = i10;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.N(this.f25650c.iterator(), this.f25651d);
        }
    }

    public class i<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25652c;

        public i(Iterable iterable) {
            this.f25652c = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f25652c;
            return iterable instanceof Queue ? new l((Queue) iterable) : Iterators.p(iterable.iterator());
        }

        @Override // e5.w
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    public class j<T> extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Iterable f25653c;

        /* renamed from: d */
        public final /* synthetic */ Comparator f25654d;

        public j(Iterable iterable, Comparator comparator) {
            this.f25653c = iterable;
            this.f25654d = comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.O(u0.U(this.f25653c, u0.S()), this.f25654d);
        }
    }

    public static final class k<T> extends w<T> {

        /* renamed from: c */
        public final Iterable<? extends T> f25655c;

        public /* synthetic */ k(Iterable iterable, b bVar) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.f0(this.f25655c.iterator());
        }

        @Override // e5.w
        public String toString() {
            return this.f25655c.toString();
        }

        public k(Iterable<? extends T> iterable) {
            this.f25655c = iterable;
        }
    }

    @d1
    public static <T> T A(Iterable<? extends T> iterable, @d1 T t10) {
        return (T) Iterators.L(iterable.iterator(), t10);
    }

    public static <T> int B(Iterable<T> iterable, b5.v<? super T> vVar) {
        return Iterators.M(iterable.iterator(), vVar);
    }

    public static boolean C(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> D(Iterable<T> iterable, int i10) {
        b5.u.E(iterable);
        b5.u.e(i10 >= 0, "limit is negative");
        return new h(iterable, i10);
    }

    @a5.a
    public static <T> Iterable<T> E(Iterable<? extends Iterable<? extends T>> iterable, Comparator<? super T> comparator) {
        b5.u.F(iterable, "iterables");
        b5.u.F(comparator, "comparator");
        return new k(new j(iterable, comparator), null);
    }

    public static <T> Iterable<List<T>> F(Iterable<T> iterable, int i10) {
        b5.u.E(iterable);
        b5.u.d(i10 > 0);
        return new d(iterable, i10);
    }

    public static <T> Iterable<List<T>> G(Iterable<T> iterable, int i10) {
        b5.u.E(iterable);
        b5.u.d(i10 > 0);
        return new c(iterable, i10);
    }

    @CanIgnoreReturnValue
    public static boolean H(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).removeAll((Collection) b5.u.E(collection)) : Iterators.V(iterable.iterator(), collection);
    }

    @CheckForNull
    public static <T> T I(Iterable<T> iterable, b5.v<? super T> vVar) {
        b5.u.E(vVar);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (vVar.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean J(Iterable<T> iterable, b5.v<? super T> vVar) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? K((List) iterable, (b5.v) b5.u.E(vVar)) : Iterators.W(iterable.iterator(), vVar);
    }

    public static <T> boolean K(List<T> list, b5.v<? super T> vVar) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size()) {
            T t10 = list.get(i10);
            if (!vVar.apply(t10)) {
                if (i10 > i11) {
                    try {
                        list.set(i11, t10);
                    } catch (IllegalArgumentException unused) {
                        O(list, vVar, i11, i10);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        O(list, vVar, i11, i10);
                        return true;
                    }
                }
                i11++;
            }
            i10++;
        }
        list.subList(i11, list.size()).clear();
        return i10 != i11;
    }

    @CanIgnoreReturnValue
    public static boolean L(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).retainAll((Collection) b5.u.E(collection)) : Iterators.X(iterable.iterator(), collection);
    }

    public static int M(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : Iterators.Z(iterable.iterator());
    }

    public static <T> Iterable<T> N(Iterable<T> iterable, int i10) {
        b5.u.E(iterable);
        b5.u.e(i10 >= 0, "number to skip cannot be negative");
        return new g(iterable, i10);
    }

    public static <T> void O(List<T> list, b5.v<? super T> vVar, int i10, int i11) {
        for (int size = list.size() - 1; size > i11; size--) {
            if (vVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            list.remove(i12);
        }
    }

    public static Object[] P(Iterable<?> iterable) {
        return d(iterable).toArray();
    }

    @a5.c
    public static <T> T[] Q(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) R(iterable, b1.i(cls, 0));
    }

    public static <T> T[] R(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) d(iterable).toArray(tArr);
    }

    public static <T> b5.n<Iterable<? extends T>, Iterator<? extends T>> S() {
        return new a();
    }

    public static String T(Iterable<?> iterable) {
        return Iterators.b0(iterable.iterator());
    }

    public static <F, T> Iterable<T> U(Iterable<F> iterable, b5.n<? super F, ? extends T> nVar) {
        b5.u.E(iterable);
        b5.u.E(nVar);
        return new f(iterable, nVar);
    }

    public static <T> Optional<T> V(Iterable<T> iterable, b5.v<? super T> vVar) {
        return Iterators.d0(iterable.iterator(), vVar);
    }

    @Deprecated
    public static <E> Iterable<E> W(ImmutableCollection<E> immutableCollection) {
        return (Iterable) b5.u.E(immutableCollection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> X(Iterable<? extends T> iterable) {
        b5.u.E(iterable);
        return ((iterable instanceof k) || (iterable instanceof ImmutableCollection)) ? iterable : new k(iterable, null);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : Iterators.a(collection, ((Iterable) b5.u.E(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, b5.v<? super T> vVar) {
        return Iterators.c(iterable.iterator(), vVar);
    }

    public static <T> boolean c(Iterable<T> iterable, b5.v<? super T> vVar) {
        return Iterators.d(iterable.iterator(), vVar);
    }

    public static <E> Collection<E> d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.s(iterable.iterator());
    }

    public static <T> Iterable<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        return w.e(iterable);
    }

    public static <T> Iterable<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return w.f(iterable, iterable2);
    }

    public static <T> Iterable<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return w.g(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return w.h(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> i(Iterable<? extends T>... iterableArr) {
        return w.i(iterableArr);
    }

    public static <T> Iterable<T> j(Iterable<T> iterable) {
        b5.u.E(iterable);
        return new i(iterable);
    }

    public static boolean k(Iterable<? extends Object> iterable, @CheckForNull Object obj) {
        return iterable instanceof Collection ? com.google.common.collect.f.j((Collection) iterable, obj) : Iterators.q(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> l(Iterable<T> iterable) {
        b5.u.E(iterable);
        return new b(iterable);
    }

    @SafeVarargs
    public static <T> Iterable<T> m(T... tArr) {
        return l(Lists.t(tArr));
    }

    public static boolean n(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return Iterators.t(iterable.iterator(), iterable2.iterator());
    }

    public static <T> Iterable<T> o(Iterable<T> iterable, b5.v<? super T> vVar) {
        b5.u.E(iterable);
        b5.u.E(vVar);
        return new e(iterable, vVar);
    }

    @a5.c
    public static <T> Iterable<T> p(Iterable<?> iterable, Class<T> cls) {
        b5.u.E(iterable);
        b5.u.E(cls);
        return o(iterable, Predicates.o(cls));
    }

    @d1
    public static <T> T q(Iterable<T> iterable, b5.v<? super T> vVar) {
        return (T) Iterators.z(iterable.iterator(), vVar);
    }

    @CheckForNull
    public static <T> T r(Iterable<? extends T> iterable, b5.v<? super T> vVar, @CheckForNull T t10) {
        return (T) Iterators.A(iterable.iterator(), vVar, t10);
    }

    public static int s(Iterable<?> iterable, @CheckForNull Object obj) {
        return iterable instanceof com.google.common.collect.s ? ((com.google.common.collect.s) iterable).count(obj) : iterable instanceof Set ? ((Set) iterable).contains(obj) ? 1 : 0 : Iterators.E(iterable.iterator(), obj);
    }

    @d1
    public static <T> T t(Iterable<T> iterable, int i10) {
        b5.u.E(iterable);
        return iterable instanceof List ? (T) ((List) iterable).get(i10) : (T) Iterators.F(iterable.iterator(), i10);
    }

    @d1
    public static <T> T u(Iterable<? extends T> iterable, int i10, @d1 T t10) {
        b5.u.E(iterable);
        Iterators.g(i10);
        if (iterable instanceof List) {
            List f10 = Lists.f(iterable);
            return i10 < f10.size() ? (T) f10.get(i10) : t10;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.b(it, i10);
        return (T) Iterators.J(it, t10);
    }

    @d1
    public static <T> T v(Iterable<? extends T> iterable, @d1 T t10) {
        return (T) Iterators.J(iterable.iterator(), t10);
    }

    @d1
    public static <T> T w(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.H(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) y(list);
    }

    @d1
    public static <T> T x(Iterable<? extends T> iterable, @d1 T t10) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t10;
            }
            if (iterable instanceof List) {
                return (T) y(Lists.f(iterable));
            }
        }
        return (T) Iterators.I(iterable.iterator(), t10);
    }

    @d1
    public static <T> T y(List<T> list) {
        return list.get(list.size() - 1);
    }

    @d1
    public static <T> T z(Iterable<T> iterable) {
        return (T) Iterators.K(iterable.iterator());
    }
}
