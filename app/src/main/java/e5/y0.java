package e5;

import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.CheckForNull;

@a5.b
@a5.a
@m
/* loaded from: classes2.dex */
public final class y0<E> extends AbstractQueue<E> {

    /* renamed from: h */
    public static final int f25668h = 1431655765;

    /* renamed from: i */
    public static final int f25669i = -1431655766;

    /* renamed from: j */
    public static final int f25670j = 11;

    /* renamed from: b */
    public final y0<E>.c f25671b;

    /* renamed from: c */
    public final y0<E>.c f25672c;

    /* renamed from: d */
    @a5.d
    public final int f25673d;

    /* renamed from: e */
    public Object[] f25674e;

    /* renamed from: f */
    public int f25675f;

    /* renamed from: g */
    public int f25676g;

    @a5.a
    public static final class b<B> {

        /* renamed from: d */
        public static final int f25677d = -1;

        /* renamed from: a */
        public final Comparator<B> f25678a;

        /* renamed from: b */
        public int f25679b;

        /* renamed from: c */
        public int f25680c;

        public /* synthetic */ b(Comparator comparator, a aVar) {
            this(comparator);
        }

        public <T extends B> y0<T> c() {
            return d(Collections.emptySet());
        }

        public <T extends B> y0<T> d(Iterable<? extends T> iterable) {
            y0<T> y0Var = new y0<>(this, y0.o(this.f25679b, this.f25680c, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                y0Var.offer(it.next());
            }
            return y0Var;
        }

        @CanIgnoreReturnValue
        public b<B> e(int i10) {
            b5.u.d(i10 >= 0);
            this.f25679b = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public b<B> f(int i10) {
            b5.u.d(i10 > 0);
            this.f25680c = i10;
            return this;
        }

        public final <T extends B> Ordering<T> g() {
            return Ordering.from(this.f25678a);
        }

        public b(Comparator<B> comparator) {
            this.f25679b = -1;
            this.f25680c = Integer.MAX_VALUE;
            this.f25678a = (Comparator) b5.u.E(comparator);
        }
    }

    public class c {

        /* renamed from: a */
        public final Ordering<E> f25681a;

        /* renamed from: b */
        @Weak
        public y0<E>.c f25682b;

        public c(Ordering<E> ordering) {
            this.f25681a = ordering;
        }

        public void b(int i10, E e10) {
            c cVar;
            int f10 = f(i10, e10);
            if (f10 == i10) {
                f10 = i10;
                cVar = this;
            } else {
                cVar = this.f25682b;
            }
            cVar.c(f10, e10);
        }

        @CanIgnoreReturnValue
        public int c(int i10, E e10) {
            while (i10 > 2) {
                int k10 = k(i10);
                Object i11 = y0.this.i(k10);
                if (this.f25681a.compare(i11, e10) <= 0) {
                    break;
                }
                y0.this.f25674e[i10] = i11;
                i10 = k10;
            }
            y0.this.f25674e[i10] = e10;
            return i10;
        }

        public int d(int i10, int i11) {
            return this.f25681a.compare(y0.this.i(i10), y0.this.i(i11));
        }

        public int e(int i10, E e10) {
            int i11 = i(i10);
            if (i11 <= 0 || this.f25681a.compare(y0.this.i(i11), e10) >= 0) {
                return f(i10, e10);
            }
            y0.this.f25674e[i10] = y0.this.i(i11);
            y0.this.f25674e[i11] = e10;
            return i11;
        }

        public int f(int i10, E e10) {
            int n10;
            if (i10 == 0) {
                y0.this.f25674e[0] = e10;
                return 0;
            }
            int m10 = m(i10);
            Object i11 = y0.this.i(m10);
            if (m10 != 0 && (n10 = n(m(m10))) != m10 && l(n10) >= y0.this.f25675f) {
                Object i12 = y0.this.i(n10);
                if (this.f25681a.compare(i12, i11) < 0) {
                    m10 = n10;
                    i11 = i12;
                }
            }
            if (this.f25681a.compare(i11, e10) >= 0) {
                y0.this.f25674e[i10] = e10;
                return i10;
            }
            y0.this.f25674e[i10] = i11;
            y0.this.f25674e[m10] = e10;
            return m10;
        }

        public int g(int i10) {
            while (true) {
                int j10 = j(i10);
                if (j10 <= 0) {
                    return i10;
                }
                y0.this.f25674e[i10] = y0.this.i(j10);
                i10 = j10;
            }
        }

        public int h(int i10, int i11) {
            if (i10 >= y0.this.f25675f) {
                return -1;
            }
            b5.u.g0(i10 > 0);
            int min = Math.min(i10, y0.this.f25675f - i11) + i11;
            for (int i12 = i10 + 1; i12 < min; i12++) {
                if (d(i12, i10) < 0) {
                    i10 = i12;
                }
            }
            return i10;
        }

        public int i(int i10) {
            return h(l(i10), 2);
        }

        public int j(int i10) {
            int l10 = l(i10);
            if (l10 < 0) {
                return -1;
            }
            return h(l(l10), 4);
        }

        public final int k(int i10) {
            return m(m(i10));
        }

        public final int l(int i10) {
            return (i10 * 2) + 1;
        }

        public final int m(int i10) {
            return (i10 - 1) / 2;
        }

        public final int n(int i10) {
            return (i10 * 2) + 2;
        }

        public int o(E e10) {
            int n10;
            int m10 = m(y0.this.f25675f);
            if (m10 != 0 && (n10 = n(m(m10))) != m10 && l(n10) >= y0.this.f25675f) {
                Object i10 = y0.this.i(n10);
                if (this.f25681a.compare(i10, e10) < 0) {
                    y0.this.f25674e[n10] = e10;
                    y0.this.f25674e[y0.this.f25675f] = i10;
                    return n10;
                }
            }
            return y0.this.f25675f;
        }

        @CheckForNull
        public d<E> p(int i10, int i11, E e10) {
            int e11 = e(i11, e10);
            if (e11 == i11) {
                return null;
            }
            Object i12 = e11 < i10 ? y0.this.i(i10) : y0.this.i(m(i10));
            if (this.f25682b.c(e11, e10) < i10) {
                return new d<>(e10, i12);
            }
            return null;
        }

        public final boolean q(int i10) {
            if (l(i10) < y0.this.f25675f && d(i10, l(i10)) > 0) {
                return false;
            }
            if (n(i10) < y0.this.f25675f && d(i10, n(i10)) > 0) {
                return false;
            }
            if (i10 <= 0 || d(i10, m(i10)) <= 0) {
                return i10 <= 2 || d(k(i10), i10) <= 0;
            }
            return false;
        }
    }

    public static class d<E> {

        /* renamed from: a */
        public final E f25684a;

        /* renamed from: b */
        public final E f25685b;

        public d(E e10, E e11) {
            this.f25684a = e10;
            this.f25685b = e11;
        }
    }

    public /* synthetic */ y0(b bVar, int i10, a aVar) {
        this(bVar, i10);
    }

    public static int e(int i10, int i11) {
        return Math.min(i10 - 1, i11) + 1;
    }

    public static <E extends Comparable<E>> y0<E> g() {
        return new b(Ordering.natural()).c();
    }

    public static <E extends Comparable<E>> y0<E> h(Iterable<? extends E> iterable) {
        return new b(Ordering.natural()).d(iterable);
    }

    public static b<Comparable> j(int i10) {
        return new b(Ordering.natural()).e(i10);
    }

    @a5.d
    public static int o(int i10, int i11, Iterable<?> iterable) {
        if (i10 == -1) {
            i10 = 11;
        }
        if (iterable instanceof Collection) {
            i10 = Math.max(i10, ((Collection) iterable).size());
        }
        return e(i10, i11);
    }

    @a5.d
    public static boolean p(int i10) {
        int i11 = ~(~(i10 + 1));
        b5.u.h0(i11 > 0, "negative index");
        return (1431655765 & i11) > (i11 & f25669i);
    }

    public static b<Comparable> r(int i10) {
        return new b(Ordering.natural()).f(i10);
    }

    public static <B> b<B> s(Comparator<B> comparator) {
        return new b<>(comparator);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e10) {
        offer(e10);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            offer(it.next());
            z10 = true;
        }
        return z10;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i10 = 0; i10 < this.f25675f; i10++) {
            this.f25674e[i10] = null;
        }
        this.f25675f = 0;
    }

    public Comparator<? super E> comparator() {
        return this.f25671b.f25681a;
    }

    public final int d() {
        int length = this.f25674e.length;
        return e(length < 64 ? (length + 1) * 2 : l5.f.d(length / 2, 3), this.f25673d);
    }

    @a5.d
    public int f() {
        return this.f25674e.length;
    }

    public E i(int i10) {
        E e10 = (E) this.f25674e[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new e();
    }

    @CheckForNull
    public final d<E> k(int i10, E e10) {
        y0<E>.c n10 = n(i10);
        int g10 = n10.g(i10);
        int c10 = n10.c(g10, e10);
        if (c10 == g10) {
            return n10.p(i10, g10, e10);
        }
        if (c10 < i10) {
            return new d<>(e10, i(i10));
        }
        return null;
    }

    public final int l() {
        int i10 = this.f25675f;
        if (i10 != 1) {
            return (i10 == 2 || this.f25672c.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    public final void m() {
        if (this.f25675f > this.f25674e.length) {
            Object[] objArr = new Object[d()];
            Object[] objArr2 = this.f25674e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f25674e = objArr;
        }
    }

    public final y0<E>.c n(int i10) {
        return p(i10) ? this.f25671b : this.f25672c;
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e10) {
        b5.u.E(e10);
        this.f25676g++;
        int i10 = this.f25675f;
        this.f25675f = i10 + 1;
        m();
        n(i10).b(i10, e10);
        return this.f25675f <= this.f25673d || pollLast() != e10;
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return i(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return i(l());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return t(0);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return t(l());
    }

    @a5.d
    public boolean q() {
        for (int i10 = 1; i10 < this.f25675f; i10++) {
            if (!n(i10).q(i10)) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return t(l());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f25675f;
    }

    public final E t(int i10) {
        E i11 = i(i10);
        u(i10);
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i10 = this.f25675f;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f25674e, 0, objArr, 0, i10);
        return objArr;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @a5.d
    public d<E> u(int i10) {
        b5.u.d0(i10, this.f25675f);
        this.f25676g++;
        int i11 = this.f25675f - 1;
        this.f25675f = i11;
        if (i11 == i10) {
            this.f25674e[i11] = null;
            return null;
        }
        E i12 = i(i11);
        int o10 = n(this.f25675f).o(i12);
        if (o10 == i10) {
            this.f25674e[this.f25675f] = null;
            return null;
        }
        E i13 = i(this.f25675f);
        this.f25674e[this.f25675f] = null;
        d<E> k10 = k(i10, i13);
        return o10 < i10 ? k10 == null ? new d<>(i12, i13) : new d<>(i12, k10.f25685b) : k10;
    }

    public y0(b<? super E> bVar, int i10) {
        Ordering g10 = bVar.g();
        y0<E>.c cVar = new c(g10);
        this.f25671b = cVar;
        y0<E>.c cVar2 = new c(g10.reverse());
        this.f25672c = cVar2;
        cVar.f25682b = cVar2;
        cVar2.f25682b = cVar;
        this.f25673d = bVar.f25680c;
        this.f25674e = new Object[i10];
    }

    public class e implements Iterator<E> {

        /* renamed from: b */
        public int f25686b;

        /* renamed from: c */
        public int f25687c;

        /* renamed from: d */
        public int f25688d;

        /* renamed from: e */
        @CheckForNull
        public Queue<E> f25689e;

        /* renamed from: f */
        @CheckForNull
        public List<E> f25690f;

        /* renamed from: g */
        @CheckForNull
        public E f25691g;

        /* renamed from: h */
        public boolean f25692h;

        public e() {
            this.f25686b = -1;
            this.f25687c = -1;
            this.f25688d = y0.this.f25676g;
        }

        public final void a() {
            if (y0.this.f25676g != this.f25688d) {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean b(Iterable<E> iterable, E e10) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e10) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int i10) {
            if (this.f25687c < i10) {
                if (this.f25690f != null) {
                    while (i10 < y0.this.size() && b(this.f25690f, y0.this.i(i10))) {
                        i10++;
                    }
                }
                this.f25687c = i10;
            }
        }

        public final boolean d(Object obj) {
            for (int i10 = 0; i10 < y0.this.f25675f; i10++) {
                if (y0.this.f25674e[i10] == obj) {
                    y0.this.u(i10);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.f25686b + 1);
            if (this.f25687c < y0.this.size()) {
                return true;
            }
            Queue<E> queue = this.f25689e;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.f25686b + 1);
            if (this.f25687c < y0.this.size()) {
                int i10 = this.f25687c;
                this.f25686b = i10;
                this.f25692h = true;
                return (E) y0.this.i(i10);
            }
            if (this.f25689e != null) {
                this.f25686b = y0.this.size();
                E poll = this.f25689e.poll();
                this.f25691g = poll;
                if (poll != null) {
                    this.f25692h = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            i.e(this.f25692h);
            a();
            this.f25692h = false;
            this.f25688d++;
            if (this.f25686b >= y0.this.size()) {
                E e10 = this.f25691g;
                Objects.requireNonNull(e10);
                b5.u.g0(d(e10));
                this.f25691g = null;
                return;
            }
            d<E> u10 = y0.this.u(this.f25686b);
            if (u10 != null) {
                if (this.f25689e == null || this.f25690f == null) {
                    this.f25689e = new ArrayDeque();
                    this.f25690f = new ArrayList(3);
                }
                if (!b(this.f25690f, u10.f25684a)) {
                    this.f25689e.add(u10.f25684a);
                }
                if (!b(this.f25689e, u10.f25685b)) {
                    this.f25690f.add(u10.f25685b);
                }
            }
            this.f25686b--;
            this.f25687c--;
        }

        public /* synthetic */ e(y0 y0Var, a aVar) {
            this();
        }
    }
}
