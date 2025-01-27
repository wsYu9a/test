package h5;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphConstants;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@s
/* loaded from: classes2.dex */
public class v0<N, E> extends h<N, E> {

    /* renamed from: a */
    public final boolean f26482a;

    /* renamed from: b */
    public final boolean f26483b;

    /* renamed from: c */
    public final boolean f26484c;

    /* renamed from: d */
    public final ElementOrder<N> f26485d;

    /* renamed from: e */
    public final ElementOrder<E> f26486e;

    /* renamed from: f */
    public final h0<N, q0<N, E>> f26487f;

    /* renamed from: g */
    public final h0<E, N> f26488g;

    public v0(p0<? super N, ? super E> p0Var) {
        this(p0Var, p0Var.f26434c.c(p0Var.f26436e.or((Optional<Integer>) 10).intValue()), p0Var.f26470g.c(p0Var.f26471h.or((Optional<Integer>) 20).intValue()));
    }

    @Override // h5.o0
    public t<N> E(E e10) {
        N S = S(e10);
        q0<N, E> f10 = this.f26487f.f(S);
        Objects.requireNonNull(f10);
        return t.g(this, S, f10.h(e10));
    }

    @Override // h5.o0
    public ElementOrder<E> H() {
        return this.f26486e;
    }

    @Override // h5.o0
    public Set<E> J(N n10) {
        return R(n10).i();
    }

    public final q0<N, E> R(N n10) {
        q0<N, E> f10 = this.f26487f.f(n10);
        if (f10 != null) {
            return f10;
        }
        b5.u.E(n10);
        throw new IllegalArgumentException(String.format(GraphConstants.f9988f, n10));
    }

    public final N S(E e10) {
        N f10 = this.f26488g.f(e10);
        if (f10 != null) {
            return f10;
        }
        b5.u.E(e10);
        throw new IllegalArgumentException(String.format(GraphConstants.f9989g, e10));
    }

    public final boolean T(E e10) {
        return this.f26488g.e(e10);
    }

    public final boolean U(N n10) {
        return this.f26487f.e(n10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.h, h5.o0, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a((v0<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.h, h5.o0, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b((v0<N, E>) obj);
    }

    @Override // h5.o0
    public Set<E> d() {
        return this.f26488g.k();
    }

    @Override // h5.o0
    public boolean f() {
        return this.f26482a;
    }

    @Override // h5.o0
    public ElementOrder<N> h() {
        return this.f26485d;
    }

    @Override // h5.o0
    public boolean j() {
        return this.f26484c;
    }

    @Override // h5.o0
    public Set<N> k(N n10) {
        return R(n10).c();
    }

    @Override // h5.o0
    public Set<E> l(N n10) {
        return R(n10).g();
    }

    @Override // h5.o0
    public Set<N> m() {
        return this.f26487f.k();
    }

    @Override // h5.o0
    public Set<E> v(N n10) {
        return R(n10).k();
    }

    @Override // h5.h, h5.o0
    public Set<E> x(N n10, N n11) {
        q0<N, E> R = R(n10);
        if (!this.f26484c && n10 == n11) {
            return ImmutableSet.of();
        }
        b5.u.u(U(n11), GraphConstants.f9988f, n11);
        return R.l(n11);
    }

    @Override // h5.o0
    public boolean y() {
        return this.f26483b;
    }

    @Override // h5.h, h5.o0, h5.s0, h5.z
    public Set<N> a(N n10) {
        return R(n10).b();
    }

    @Override // h5.h, h5.o0, h5.x0, h5.z
    public Set<N> b(N n10) {
        return R(n10).a();
    }

    public v0(p0<? super N, ? super E> p0Var, Map<N, q0<N, E>> map, Map<E, N> map2) {
        h0<N, q0<N, E>> h0Var;
        this.f26482a = p0Var.f26432a;
        this.f26483b = p0Var.f26469f;
        this.f26484c = p0Var.f26433b;
        this.f26485d = (ElementOrder<N>) p0Var.f26434c.a();
        this.f26486e = (ElementOrder<E>) p0Var.f26470g.a();
        if (map instanceof TreeMap) {
            h0Var = new i0<>(map);
        } else {
            h0Var = new h0<>(map);
        }
        this.f26487f = h0Var;
        this.f26488g = new h0<>(map2);
    }
}
