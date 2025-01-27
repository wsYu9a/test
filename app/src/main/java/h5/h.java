package h5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphConstants;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
@a5.a
/* loaded from: classes2.dex */
public abstract class h<N, E> implements o0<N, E> {

    public class a extends f<N> {

        /* renamed from: h5.h$a$a */
        public class C0706a extends AbstractSet<t<N>> {

            /* renamed from: h5.h$a$a$a */
            public class C0707a implements b5.n<E, t<N>> {
                public C0707a() {
                }

                @Override // b5.n
                /* renamed from: a */
                public t<N> apply(E e10) {
                    return h.this.E(e10);
                }
            }

            public C0706a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof t)) {
                    return false;
                }
                t<?> tVar = (t) obj;
                return a.this.O(tVar) && a.this.m().contains(tVar.d()) && a.this.b((a) tVar.d()).contains(tVar.e());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<t<N>> iterator() {
                return Iterators.c0(h.this.d().iterator(), new C0707a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h.this.d().size();
            }
        }

        public a() {
        }

        @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
        public /* bridge */ /* synthetic */ Iterable a(Object obj) {
            return a((a) obj);
        }

        @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
        public /* bridge */ /* synthetic */ Iterable b(Object obj) {
            return b((a) obj);
        }

        @Override // h5.f, h5.a, h5.l
        public Set<t<N>> d() {
            return h.this.y() ? super.d() : new C0706a();
        }

        @Override // h5.l, h5.z
        public boolean f() {
            return h.this.f();
        }

        @Override // h5.l, h5.z
        public ElementOrder<N> h() {
            return h.this.h();
        }

        @Override // h5.l, h5.z
        public boolean j() {
            return h.this.j();
        }

        @Override // h5.l, h5.z
        public Set<N> k(N n10) {
            return h.this.k(n10);
        }

        @Override // h5.l, h5.z
        public Set<N> m() {
            return h.this.m();
        }

        @Override // h5.f, h5.a, h5.l, h5.z
        public ElementOrder<N> p() {
            return ElementOrder.i();
        }

        @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
        public Set<N> a(N n10) {
            return h.this.a((h) n10);
        }

        @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
        public Set<N> b(N n10) {
            return h.this.b((h) n10);
        }
    }

    public class b implements b5.v<E> {

        /* renamed from: b */
        public final /* synthetic */ Object f26442b;

        /* renamed from: c */
        public final /* synthetic */ Object f26443c;

        public b(Object obj, Object obj2) {
            this.f26442b = obj;
            this.f26443c = obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b5.v
        public boolean apply(E e10) {
            return h.this.E(e10).a(this.f26442b).equals(this.f26443c);
        }
    }

    public class c implements b5.n<E, t<N>> {

        /* renamed from: b */
        public final /* synthetic */ o0 f26445b;

        public c(o0 o0Var) {
            this.f26445b = o0Var;
        }

        @Override // b5.n
        /* renamed from: a */
        public t<N> apply(E e10) {
            return this.f26445b.E(e10);
        }
    }

    public static <N, E> Map<E, t<N>> O(o0<N, E> o0Var) {
        return Maps.j(o0Var.d(), new c(o0Var));
    }

    @Override // h5.o0
    public Set<E> B(t<N> tVar) {
        Q(tVar);
        return x(tVar.d(), tVar.e());
    }

    @Override // h5.o0
    @CheckForNull
    public E D(N n10, N n11) {
        Set<E> x10 = x(n10, n11);
        int size = x10.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return x10.iterator().next();
        }
        throw new IllegalArgumentException(String.format(GraphConstants.f9991i, n10, n11));
    }

    @Override // h5.o0
    @CheckForNull
    public E G(t<N> tVar) {
        Q(tVar);
        return D(tVar.d(), tVar.e());
    }

    public final b5.v<E> N(N n10, N n11) {
        return new b(n10, n11);
    }

    public final boolean P(t<?> tVar) {
        return tVar.b() || !f();
    }

    public final void Q(t<?> tVar) {
        b5.u.E(tVar);
        b5.u.e(P(tVar), GraphConstants.f9996n);
    }

    @Override // h5.o0, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        Iterable a10;
        a10 = a((h<N, E>) ((o0) obj));
        return a10;
    }

    @Override // h5.o0, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        Iterable b10;
        b10 = b((h<N, E>) ((o0) obj));
        return b10;
    }

    @Override // h5.o0
    public boolean c(t<N> tVar) {
        b5.u.E(tVar);
        if (P(tVar)) {
            return e(tVar.d(), tVar.e());
        }
        return false;
    }

    @Override // h5.o0
    public boolean e(N n10, N n11) {
        b5.u.E(n10);
        b5.u.E(n11);
        return m().contains(n10) && b((h<N, E>) n10).contains(n11);
    }

    @Override // h5.o0
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return f() == o0Var.f() && m().equals(o0Var.m()) && O(this).equals(O(o0Var));
    }

    @Override // h5.o0
    public int g(N n10) {
        return f() ? l5.f.t(J(n10).size(), v(n10).size()) : l5.f.t(l(n10).size(), x(n10, n10).size());
    }

    @Override // h5.o0
    public final int hashCode() {
        return O(this).hashCode();
    }

    @Override // h5.o0
    public int i(N n10) {
        return f() ? v(n10).size() : g(n10);
    }

    @Override // h5.o0
    public int n(N n10) {
        return f() ? J(n10).size() : g(n10);
    }

    @Override // h5.o0
    public z<N> s() {
        return new a();
    }

    public String toString() {
        boolean f10 = f();
        boolean y10 = y();
        boolean j10 = j();
        String valueOf = String.valueOf(m());
        String valueOf2 = String.valueOf(O(this));
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 87 + valueOf2.length());
        sb2.append("isDirected: ");
        sb2.append(f10);
        sb2.append(", allowsParallelEdges: ");
        sb2.append(y10);
        sb2.append(", allowsSelfLoops: ");
        sb2.append(j10);
        sb2.append(", nodes: ");
        sb2.append(valueOf);
        sb2.append(", edges: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    @Override // h5.o0
    public Set<E> w(E e10) {
        t<N> E = E(e10);
        return Sets.f(Sets.N(l(E.d()), l(E.e())), ImmutableSet.of((Object) e10));
    }

    @Override // h5.o0
    public Set<E> x(N n10, N n11) {
        Set<E> v10 = v(n10);
        Set<E> J = J(n11);
        return v10.size() <= J.size() ? Collections.unmodifiableSet(Sets.i(v10, N(n10, n11))) : Collections.unmodifiableSet(Sets.i(J, N(n11, n10)));
    }
}
