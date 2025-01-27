package h5;

import com.google.common.collect.ImmutableList;
import com.google.common.graph.GraphConstants;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.z1;
import java.util.Collection;
import java.util.Objects;

@s
/* loaded from: classes2.dex */
public final class t0<N, E> extends v0<N, E> implements l0<N, E> {
    public t0(p0<? super N, ? super E> p0Var) {
        super(p0Var);
    }

    @Override // h5.l0
    @CanIgnoreReturnValue
    public boolean I(E e10) {
        b5.u.F(e10, "edge");
        N f10 = this.f26488g.f(e10);
        boolean z10 = false;
        if (f10 == null) {
            return false;
        }
        q0<N, E> f11 = this.f26487f.f(f10);
        Objects.requireNonNull(f11);
        q0<N, E> q0Var = f11;
        N h10 = q0Var.h(e10);
        q0<N, E> f12 = this.f26487f.f(h10);
        Objects.requireNonNull(f12);
        q0<N, E> q0Var2 = f12;
        q0Var.j(e10);
        if (j() && f10.equals(h10)) {
            z10 = true;
        }
        q0Var2.d(e10, z10);
        this.f26488g.j(e10);
        return true;
    }

    @Override // h5.l0
    @CanIgnoreReturnValue
    public boolean M(N n10, N n11, E e10) {
        b5.u.F(n10, "nodeU");
        b5.u.F(n11, "nodeV");
        b5.u.F(e10, "edge");
        if (T(e10)) {
            t<N> E = E(e10);
            t g10 = t.g(this, n10, n11);
            b5.u.z(E.equals(g10), GraphConstants.f9990h, e10, E, g10);
            return false;
        }
        q0<N, E> f10 = this.f26487f.f(n10);
        if (!y()) {
            b5.u.y(f10 == null || !f10.a().contains(n11), GraphConstants.f9992j, n10, n11);
        }
        boolean equals = n10.equals(n11);
        if (!j()) {
            b5.u.u(!equals, GraphConstants.f9993k, n10);
        }
        if (f10 == null) {
            f10 = V(n10);
        }
        f10.e(e10, n11);
        q0<N, E> f11 = this.f26487f.f(n11);
        if (f11 == null) {
            f11 = V(n11);
        }
        f11.f(e10, n10, equals);
        this.f26488g.i(e10, n10);
        return true;
    }

    @CanIgnoreReturnValue
    public final q0<N, E> V(N n10) {
        q0<N, E> W = W();
        b5.u.g0(this.f26487f.i(n10, W) == null);
        return W;
    }

    public final q0<N, E> W() {
        return f() ? y() ? p.p() : q.n() : y() ? z0.p() : a1.m();
    }

    @Override // h5.l0
    @CanIgnoreReturnValue
    public boolean o(N n10) {
        b5.u.F(n10, "node");
        q0<N, E> f10 = this.f26487f.f(n10);
        if (f10 == null) {
            return false;
        }
        z1<E> it = ImmutableList.copyOf((Collection) f10.g()).iterator();
        while (it.hasNext()) {
            I(it.next());
        }
        this.f26487f.j(n10);
        return true;
    }

    @Override // h5.l0
    @CanIgnoreReturnValue
    public boolean q(N n10) {
        b5.u.F(n10, "node");
        if (U(n10)) {
            return false;
        }
        V(n10);
        return true;
    }

    @Override // h5.l0
    @CanIgnoreReturnValue
    public boolean u(t<N> tVar, E e10) {
        Q(tVar);
        return M(tVar.d(), tVar.e(), e10);
    }
}
