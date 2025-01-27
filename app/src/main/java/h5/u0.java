package h5;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphConstants;
import com.google.common.graph.Graphs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class u0<N, V> extends w0<N, V> implements m0<N, V> {

    /* renamed from: f */
    public final ElementOrder<N> f26481f;

    public u0(g<? super N> gVar) {
        super(gVar);
        this.f26481f = (ElementOrder<N>) gVar.f26435d.a();
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    @CheckForNull
    public V C(t<N> tVar, V v10) {
        P(tVar);
        return K(tVar.d(), tVar.e(), v10);
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    @CheckForNull
    public V K(N n10, N n11, V v10) {
        b5.u.F(n10, "nodeU");
        b5.u.F(n11, "nodeV");
        b5.u.F(v10, "value");
        if (!j()) {
            b5.u.u(!n10.equals(n11), GraphConstants.f9993k, n10);
        }
        a0<N, V> f10 = this.f26492d.f(n10);
        if (f10 == null) {
            f10 = V(n10);
        }
        V h10 = f10.h(n11, v10);
        a0<N, V> f11 = this.f26492d.f(n11);
        if (f11 == null) {
            f11 = V(n11);
        }
        f11.i(n10, v10);
        if (h10 == null) {
            long j10 = this.f26493e + 1;
            this.f26493e = j10;
            Graphs.e(j10);
        }
        return h10;
    }

    @CanIgnoreReturnValue
    public final a0<N, V> V(N n10) {
        a0<N, V> W = W();
        b5.u.g0(this.f26492d.i(n10, W) == null);
        return W;
    }

    public final a0<N, V> W() {
        return f() ? com.google.common.graph.a.x(this.f26481f) : com.google.common.graph.f.l(this.f26481f);
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    public boolean o(N n10) {
        b5.u.F(n10, "node");
        a0<N, V> f10 = this.f26492d.f(n10);
        if (f10 == null) {
            return false;
        }
        if (j() && f10.e(n10) != null) {
            f10.f(n10);
            this.f26493e--;
        }
        Iterator<N> it = f10.a().iterator();
        while (it.hasNext()) {
            a0<N, V> h10 = this.f26492d.h(it.next());
            Objects.requireNonNull(h10);
            h10.f(n10);
            this.f26493e--;
        }
        if (f()) {
            Iterator<N> it2 = f10.b().iterator();
            while (it2.hasNext()) {
                a0<N, V> h11 = this.f26492d.h(it2.next());
                Objects.requireNonNull(h11);
                b5.u.g0(h11.e(n10) != null);
                this.f26493e--;
            }
        }
        this.f26492d.j(n10);
        Graphs.c(this.f26493e);
        return true;
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public ElementOrder<N> p() {
        return this.f26481f;
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    public boolean q(N n10) {
        b5.u.F(n10, "node");
        if (S(n10)) {
            return false;
        }
        V(n10);
        return true;
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    @CheckForNull
    public V r(N n10, N n11) {
        b5.u.F(n10, "nodeU");
        b5.u.F(n11, "nodeV");
        a0<N, V> f10 = this.f26492d.f(n10);
        a0<N, V> f11 = this.f26492d.f(n11);
        if (f10 == null || f11 == null) {
            return null;
        }
        V e10 = f10.e(n11);
        if (e10 != null) {
            f11.f(n10);
            long j10 = this.f26493e - 1;
            this.f26493e = j10;
            Graphs.c(j10);
        }
        return e10;
    }

    @Override // h5.m0
    @CanIgnoreReturnValue
    @CheckForNull
    public V t(t<N> tVar) {
        P(tVar);
        return r(tVar.d(), tVar.e());
    }
}
