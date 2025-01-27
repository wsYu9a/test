package com.google.common.graph;

import b5.n;
import b5.r;
import b5.u;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import h5.c1;
import h5.g0;
import h5.k0;
import h5.l;
import h5.l0;
import h5.m0;
import h5.o0;
import h5.p0;
import h5.s;
import h5.t;
import h5.t0;
import h5.u0;
import h5.v;
import h5.w;
import h5.x;
import h5.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
@a5.a
/* loaded from: classes2.dex */
public final class Graphs {

    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    public static class a<N> extends v<N> {

        /* renamed from: a */
        public final z<N> f9997a;

        /* renamed from: com.google.common.graph.Graphs$a$a */
        public class C0294a extends g0<N> {

            /* renamed from: com.google.common.graph.Graphs$a$a$a */
            public class C0295a implements n<t<N>, t<N>> {
                public C0295a() {
                }

                @Override // b5.n
                /* renamed from: a */
                public t<N> apply(t<N> tVar) {
                    return t.f(a.this.Q(), tVar.e(), tVar.d());
                }
            }

            public C0294a(l lVar, Object obj) {
                super(lVar, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<t<N>> iterator() {
                return Iterators.c0(a.this.Q().l(this.f26437b).iterator(), new C0295a());
            }
        }

        public a(z<N> zVar) {
            this.f9997a = zVar;
        }

        @Override // h5.v
        /* renamed from: S */
        public z<N> Q() {
            return this.f9997a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.v, h5.f, h5.a, h5.l, h5.s0, h5.z
        public /* bridge */ /* synthetic */ Iterable a(Object obj) {
            return a((a<N>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.v, h5.f, h5.a, h5.l, h5.x0, h5.z
        public /* bridge */ /* synthetic */ Iterable b(Object obj) {
            return b((a<N>) obj);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.z
        public boolean c(t<N> tVar) {
            return Q().c(Graphs.q(tVar));
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.z
        public boolean e(N n10, N n11) {
            return Q().e(n11, n10);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.z
        public int i(N n10) {
            return Q().n(n10);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.z
        public Set<t<N>> l(N n10) {
            return new C0294a(this, n10);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.z
        public int n(N n10) {
            return Q().i(n10);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.s0, h5.z
        public Set<N> a(N n10) {
            return Q().b((z<N>) n10);
        }

        @Override // h5.v, h5.f, h5.a, h5.l, h5.x0, h5.z
        public Set<N> b(N n10) {
            return Q().a((z<N>) n10);
        }
    }

    public static class b<N, E> extends w<N, E> {

        /* renamed from: a */
        public final o0<N, E> f10000a;

        public b(o0<N, E> o0Var) {
            this.f10000a = o0Var;
        }

        @Override // h5.w, h5.h, h5.o0
        public Set<E> B(t<N> tVar) {
            return R().B(Graphs.q(tVar));
        }

        @Override // h5.w, h5.h, h5.o0
        @CheckForNull
        public E D(N n10, N n11) {
            return R().D(n11, n10);
        }

        @Override // h5.w, h5.o0
        public t<N> E(E e10) {
            t<N> E = R().E(e10);
            return t.g(this.f10000a, E.e(), E.d());
        }

        @Override // h5.w, h5.h, h5.o0
        @CheckForNull
        public E G(t<N> tVar) {
            return R().G(Graphs.q(tVar));
        }

        @Override // h5.w, h5.o0
        public Set<E> J(N n10) {
            return R().v(n10);
        }

        @Override // h5.w
        public o0<N, E> R() {
            return this.f10000a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.w, h5.h, h5.o0, h5.s0, h5.z
        public /* bridge */ /* synthetic */ Iterable a(Object obj) {
            return a((b<N, E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.w, h5.h, h5.o0, h5.x0, h5.z
        public /* bridge */ /* synthetic */ Iterable b(Object obj) {
            return b((b<N, E>) obj);
        }

        @Override // h5.w, h5.h, h5.o0
        public boolean c(t<N> tVar) {
            return R().c(Graphs.q(tVar));
        }

        @Override // h5.w, h5.h, h5.o0
        public boolean e(N n10, N n11) {
            return R().e(n11, n10);
        }

        @Override // h5.w, h5.h, h5.o0
        public int i(N n10) {
            return R().n(n10);
        }

        @Override // h5.w, h5.h, h5.o0
        public int n(N n10) {
            return R().i(n10);
        }

        @Override // h5.w, h5.o0
        public Set<E> v(N n10) {
            return R().J(n10);
        }

        @Override // h5.w, h5.h, h5.o0
        public Set<E> x(N n10, N n11) {
            return R().x(n11, n10);
        }

        @Override // h5.w, h5.h, h5.o0, h5.s0, h5.z
        public Set<N> a(N n10) {
            return R().b((o0<N, E>) n10);
        }

        @Override // h5.w, h5.h, h5.o0, h5.x0, h5.z
        public Set<N> b(N n10) {
            return R().a((o0<N, E>) n10);
        }
    }

    public static class c<N, V> extends x<N, V> {

        /* renamed from: a */
        public final c1<N, V> f10001a;

        public c(c1<N, V> c1Var) {
            this.f10001a = c1Var;
        }

        @Override // h5.x, h5.c1
        @CheckForNull
        public V L(t<N> tVar, @CheckForNull V v10) {
            return R().L(Graphs.q(tVar), v10);
        }

        @Override // h5.x
        public c1<N, V> R() {
            return this.f10001a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.x, h5.j, h5.a, h5.l, h5.s0, h5.z
        public /* bridge */ /* synthetic */ Iterable a(Object obj) {
            return a((c<N, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h5.x, h5.j, h5.a, h5.l, h5.x0, h5.z
        public /* bridge */ /* synthetic */ Iterable b(Object obj) {
            return b((c<N, V>) obj);
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.z
        public boolean c(t<N> tVar) {
            return R().c(Graphs.q(tVar));
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.z
        public boolean e(N n10, N n11) {
            return R().e(n11, n10);
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.z
        public int i(N n10) {
            return R().n(n10);
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.z
        public int n(N n10) {
            return R().i(n10);
        }

        @Override // h5.x, h5.c1
        @CheckForNull
        public V z(N n10, N n11, @CheckForNull V v10) {
            return R().z(n11, n10, v10);
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.s0, h5.z
        public Set<N> a(N n10) {
            return R().b((c1<N, V>) n10);
        }

        @Override // h5.x, h5.j, h5.a, h5.l, h5.x0, h5.z
        public Set<N> b(N n10) {
            return R().a((c1<N, V>) n10);
        }
    }

    public static boolean a(z<?> zVar, Object obj, @CheckForNull Object obj2) {
        return zVar.f() || !r.a(obj2, obj);
    }

    @CanIgnoreReturnValue
    public static int b(int i10) {
        u.k(i10 >= 0, "Not true that %s is non-negative.", i10);
        return i10;
    }

    @CanIgnoreReturnValue
    public static long c(long j10) {
        u.p(j10 >= 0, "Not true that %s is non-negative.", j10);
        return j10;
    }

    @CanIgnoreReturnValue
    public static int d(int i10) {
        u.k(i10 > 0, "Not true that %s is positive.", i10);
        return i10;
    }

    @CanIgnoreReturnValue
    public static long e(long j10) {
        u.p(j10 > 0, "Not true that %s is positive.", j10);
        return j10;
    }

    public static <N> k0<N> f(z<N> zVar) {
        k0<N> k0Var = (k0<N>) com.google.common.graph.b.g(zVar).f(zVar.m().size()).b();
        Iterator<N> it = zVar.m().iterator();
        while (it.hasNext()) {
            k0Var.q(it.next());
        }
        for (t<N> tVar : zVar.d()) {
            k0Var.F(tVar.d(), tVar.e());
        }
        return k0Var;
    }

    public static <N, E> l0<N, E> g(o0<N, E> o0Var) {
        l0<N, E> l0Var = (l0<N, E>) p0.i(o0Var).h(o0Var.m().size()).g(o0Var.d().size()).c();
        Iterator<N> it = o0Var.m().iterator();
        while (it.hasNext()) {
            l0Var.q(it.next());
        }
        for (E e10 : o0Var.d()) {
            t<N> E = o0Var.E(e10);
            l0Var.M(E.d(), E.e(), e10);
        }
        return l0Var;
    }

    public static <N, V> m0<N, V> h(c1<N, V> c1Var) {
        m0<N, V> m0Var = (m0<N, V>) g.g(c1Var).f(c1Var.m().size()).b();
        Iterator<N> it = c1Var.m().iterator();
        while (it.hasNext()) {
            m0Var.q(it.next());
        }
        for (t<N> tVar : c1Var.d()) {
            N d10 = tVar.d();
            N e10 = tVar.e();
            V z10 = c1Var.z(tVar.d(), tVar.e(), null);
            Objects.requireNonNull(z10);
            m0Var.K(d10, e10, z10);
        }
        return m0Var;
    }

    public static <N> boolean i(z<N> zVar) {
        int size = zVar.d().size();
        if (size == 0) {
            return false;
        }
        if (!zVar.f() && size >= zVar.m().size()) {
            return true;
        }
        HashMap a02 = Maps.a0(zVar.m().size());
        Iterator<N> it = zVar.m().iterator();
        while (it.hasNext()) {
            if (o(zVar, a02, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(o0<?, ?> o0Var) {
        if (o0Var.f() || !o0Var.y() || o0Var.d().size() <= o0Var.s().d().size()) {
            return i(o0Var.s());
        }
        return true;
    }

    public static <N> k0<N> k(z<N> zVar, Iterable<? extends N> iterable) {
        e eVar = iterable instanceof Collection ? (k0<N>) com.google.common.graph.b.g(zVar).f(((Collection) iterable).size()).b() : (k0<N>) com.google.common.graph.b.g(zVar).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            eVar.q(it.next());
        }
        for (N n10 : eVar.m()) {
            for (N n11 : zVar.b((z<N>) n10)) {
                if (eVar.m().contains(n11)) {
                    eVar.F(n10, n11);
                }
            }
        }
        return eVar;
    }

    public static <N, E> l0<N, E> l(o0<N, E> o0Var, Iterable<? extends N> iterable) {
        t0 t0Var = iterable instanceof Collection ? (l0<N, E>) p0.i(o0Var).h(((Collection) iterable).size()).c() : (l0<N, E>) p0.i(o0Var).c();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            t0Var.q(it.next());
        }
        for (E e10 : t0Var.m()) {
            for (E e11 : o0Var.v(e10)) {
                N a10 = o0Var.E(e11).a(e10);
                if (t0Var.m().contains(a10)) {
                    t0Var.M(e10, a10, e11);
                }
            }
        }
        return t0Var;
    }

    public static <N, V> m0<N, V> m(c1<N, V> c1Var, Iterable<? extends N> iterable) {
        u0 u0Var = iterable instanceof Collection ? (m0<N, V>) g.g(c1Var).f(((Collection) iterable).size()).b() : (m0<N, V>) g.g(c1Var).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            u0Var.q(it.next());
        }
        for (N n10 : u0Var.m()) {
            for (N n11 : c1Var.b((c1<N, V>) n10)) {
                if (u0Var.m().contains(n11)) {
                    V z10 = c1Var.z(n10, n11, null);
                    Objects.requireNonNull(z10);
                    u0Var.K(n10, n11, z10);
                }
            }
        }
        return u0Var;
    }

    public static <N> Set<N> n(z<N> zVar, N n10) {
        u.u(zVar.m().contains(n10), GraphConstants.f9988f, n10);
        return ImmutableSet.copyOf(Traverser.g(zVar).b(n10));
    }

    public static <N> boolean o(z<N> zVar, Map<Object, NodeVisitState> map, N n10, @CheckForNull N n11) {
        NodeVisitState nodeVisitState = map.get(n10);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n10, nodeVisitState2);
        for (N n12 : zVar.b((z<N>) n10)) {
            if (a(zVar, n12, n11) && o(zVar, map, n12, n10)) {
                return true;
            }
        }
        map.put(n10, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> z<N> p(z<N> zVar) {
        e b10 = com.google.common.graph.b.g(zVar).a(true).b();
        if (zVar.f()) {
            for (N n10 : zVar.m()) {
                Iterator it = n(zVar, n10).iterator();
                while (it.hasNext()) {
                    b10.F(n10, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n11 : zVar.m()) {
                if (!hashSet.contains(n11)) {
                    Set n12 = n(zVar, n11);
                    hashSet.addAll(n12);
                    int i10 = 1;
                    for (Object obj : n12) {
                        int i11 = i10 + 1;
                        Iterator it2 = e5.u0.D(n12, i10).iterator();
                        while (it2.hasNext()) {
                            b10.F(obj, it2.next());
                        }
                        i10 = i11;
                    }
                }
            }
        }
        return b10;
    }

    public static <N> t<N> q(t<N> tVar) {
        return tVar.b() ? t.h(tVar.j(), tVar.i()) : tVar;
    }

    public static <N> z<N> r(z<N> zVar) {
        return !zVar.f() ? zVar : zVar instanceof a ? ((a) zVar).f9997a : new a(zVar);
    }

    public static <N, E> o0<N, E> s(o0<N, E> o0Var) {
        return !o0Var.f() ? o0Var : o0Var instanceof b ? ((b) o0Var).f10000a : new b(o0Var);
    }

    public static <N, V> c1<N, V> t(c1<N, V> c1Var) {
        return !c1Var.f() ? c1Var : c1Var instanceof c ? ((c) c1Var).f10001a : new c(c1Var);
    }
}
