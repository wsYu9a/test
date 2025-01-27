package com.google.common.graph;

import b5.u;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.DoNotMock;
import e5.z1;
import h5.l;
import h5.o0;
import h5.s;
import h5.x0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.a
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@s
/* loaded from: classes2.dex */
public abstract class Traverser<N> {

    /* renamed from: a */
    public final x0<N> f10002a;

    public enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t10) {
                deque.addFirst(t10);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t10) {
                deque.addLast(t10);
            }
        };

        /* renamed from: com.google.common.graph.Traverser$InsertionOrder$1 */
        public enum AnonymousClass1 extends InsertionOrder {
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t10) {
                deque.addFirst(t10);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$InsertionOrder$2 */
        public enum AnonymousClass2 extends InsertionOrder {
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t10) {
                deque.addLast(t10);
            }
        }

        public abstract <T> void insertInto(Deque<T> deque, T t10);

        /* synthetic */ InsertionOrder(a aVar) {
            this();
        }
    }

    public class a extends Traverser<N> {

        /* renamed from: b */
        public final /* synthetic */ x0 f10003b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x0 x0Var, x0 x0Var2) {
            super(x0Var, null);
            this.f10003b = x0Var2;
        }

        @Override // com.google.common.graph.Traverser
        public f<N> i() {
            return f.b(this.f10003b);
        }
    }

    public class b extends Traverser<N> {

        /* renamed from: b */
        public final /* synthetic */ x0 f10004b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x0 x0Var, x0 x0Var2) {
            super(x0Var, null);
            this.f10004b = x0Var2;
        }

        @Override // com.google.common.graph.Traverser
        public f<N> i() {
            return f.c(this.f10004b);
        }
    }

    public class c implements Iterable<N> {

        /* renamed from: b */
        public final /* synthetic */ ImmutableSet f10005b;

        public c(ImmutableSet immutableSet) {
            this.f10005b = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().a(this.f10005b.iterator());
        }
    }

    public class d implements Iterable<N> {

        /* renamed from: b */
        public final /* synthetic */ ImmutableSet f10007b;

        public d(ImmutableSet immutableSet) {
            this.f10007b = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().e(this.f10007b.iterator());
        }
    }

    public class e implements Iterable<N> {

        /* renamed from: b */
        public final /* synthetic */ ImmutableSet f10009b;

        public e(ImmutableSet immutableSet) {
            this.f10009b = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().d(this.f10009b.iterator());
        }
    }

    public static abstract class f<N> {

        /* renamed from: a */
        public final x0<N> f10011a;

        public class a extends f<N> {

            /* renamed from: b */
            public final /* synthetic */ Set f10012b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x0 x0Var, Set set) {
                super(x0Var);
                this.f10012b = set;
            }

            @Override // com.google.common.graph.Traverser.f
            @CheckForNull
            public N g(Deque<Iterator<? extends N>> deque) {
                Iterator<? extends N> first = deque.getFirst();
                while (first.hasNext()) {
                    N next = first.next();
                    Objects.requireNonNull(next);
                    if (this.f10012b.add(next)) {
                        return next;
                    }
                }
                deque.removeFirst();
                return null;
            }
        }

        public class b extends f<N> {
            public b(x0 x0Var) {
                super(x0Var);
            }

            @Override // com.google.common.graph.Traverser.f
            @CheckForNull
            public N g(Deque<Iterator<? extends N>> deque) {
                Iterator<? extends N> first = deque.getFirst();
                if (first.hasNext()) {
                    return (N) u.E(first.next());
                }
                deque.removeFirst();
                return null;
            }
        }

        public class c extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Deque f10013d;

            /* renamed from: e */
            public final /* synthetic */ InsertionOrder f10014e;

            public c(Deque deque, InsertionOrder insertionOrder) {
                this.f10013d = deque;
                this.f10014e = insertionOrder;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                do {
                    N n10 = (N) f.this.g(this.f10013d);
                    if (n10 != null) {
                        Iterator<? extends N> it = f.this.f10011a.b(n10).iterator();
                        if (it.hasNext()) {
                            this.f10014e.insertInto(this.f10013d, it);
                        }
                        return n10;
                    }
                } while (!this.f10013d.isEmpty());
                return b();
            }
        }

        public class d extends AbstractIterator<N> {

            /* renamed from: d */
            public final /* synthetic */ Deque f10016d;

            /* renamed from: e */
            public final /* synthetic */ Deque f10017e;

            public d(Deque deque, Deque deque2) {
                this.f10016d = deque;
                this.f10017e = deque2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N a() {
                while (true) {
                    N n10 = (N) f.this.g(this.f10016d);
                    if (n10 == null) {
                        return !this.f10017e.isEmpty() ? (N) this.f10017e.pop() : b();
                    }
                    Iterator<? extends N> it = f.this.f10011a.b(n10).iterator();
                    if (!it.hasNext()) {
                        return n10;
                    }
                    this.f10016d.addFirst(it);
                    this.f10017e.push(n10);
                }
            }
        }

        public f(x0<N> x0Var) {
            this.f10011a = x0Var;
        }

        public static <N> f<N> b(x0<N> x0Var) {
            return new a(x0Var, new HashSet());
        }

        public static <N> f<N> c(x0<N> x0Var) {
            return new b(x0Var);
        }

        public final Iterator<N> a(Iterator<? extends N> it) {
            return f(it, InsertionOrder.BACK);
        }

        public final Iterator<N> d(Iterator<? extends N> it) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new d(arrayDeque2, arrayDeque);
        }

        public final Iterator<N> e(Iterator<? extends N> it) {
            return f(it, InsertionOrder.FRONT);
        }

        public final Iterator<N> f(Iterator<? extends N> it, InsertionOrder insertionOrder) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new c(arrayDeque, insertionOrder);
        }

        @CheckForNull
        public abstract N g(Deque<Iterator<? extends N>> deque);
    }

    public /* synthetic */ Traverser(x0 x0Var, a aVar) {
        this(x0Var);
    }

    public static <N> Traverser<N> g(x0<N> x0Var) {
        return new a(x0Var, x0Var);
    }

    public static <N> Traverser<N> h(x0<N> x0Var) {
        if (x0Var instanceof l) {
            u.e(((l) x0Var).f(), "Undirected graphs can never be trees.");
        }
        if (x0Var instanceof o0) {
            u.e(((o0) x0Var).f(), "Undirected networks can never be trees.");
        }
        return new b(x0Var, x0Var);
    }

    public final Iterable<N> a(Iterable<? extends N> iterable) {
        return new c(j(iterable));
    }

    public final Iterable<N> b(N n10) {
        return a(ImmutableSet.of(n10));
    }

    public final Iterable<N> c(Iterable<? extends N> iterable) {
        return new e(j(iterable));
    }

    public final Iterable<N> d(N n10) {
        return c(ImmutableSet.of(n10));
    }

    public final Iterable<N> e(Iterable<? extends N> iterable) {
        return new d(j(iterable));
    }

    public final Iterable<N> f(N n10) {
        return e(ImmutableSet.of(n10));
    }

    public abstract f<N> i();

    public final ImmutableSet<N> j(Iterable<? extends N> iterable) {
        ImmutableSet<N> copyOf = ImmutableSet.copyOf(iterable);
        z1<N> it = copyOf.iterator();
        while (it.hasNext()) {
            this.f10002a.b(it.next());
        }
        return copyOf;
    }

    public Traverser(x0<N> x0Var) {
        this.f10002a = (x0) u.E(x0Var);
    }
}
