package h5;

import com.google.common.base.Optional;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import h5.e0;

@s
@a5.a
/* loaded from: classes2.dex */
public final class p0<N, E> extends g<N> {

    /* renamed from: f */
    public boolean f26469f;

    /* renamed from: g */
    public ElementOrder<? super E> f26470g;

    /* renamed from: h */
    public Optional<Integer> f26471h;

    public p0(boolean z10) {
        super(z10);
        this.f26469f = false;
        this.f26470g = ElementOrder.d();
        this.f26471h = Optional.absent();
    }

    public static p0<Object, Object> e() {
        return new p0<>(true);
    }

    public static <N, E> p0<N, E> i(o0<N, E> o0Var) {
        return new p0(o0Var.f()).a(o0Var.y()).b(o0Var.j()).k(o0Var.h()).f(o0Var.H());
    }

    public static p0<Object, Object> l() {
        return new p0<>(false);
    }

    public p0<N, E> a(boolean z10) {
        this.f26469f = z10;
        return this;
    }

    public p0<N, E> b(boolean z10) {
        this.f26433b = z10;
        return this;
    }

    public <N1 extends N, E1 extends E> l0<N1, E1> c() {
        return new t0(this);
    }

    public <E1 extends E> p0<N, E1> f(ElementOrder<E1> elementOrder) {
        p0<N, E1> p0Var = (p0<N, E1>) d();
        p0Var.f26470g = (ElementOrder) b5.u.E(elementOrder);
        return p0Var;
    }

    public p0<N, E> g(int i10) {
        this.f26471h = Optional.of(Integer.valueOf(Graphs.b(i10)));
        return this;
    }

    public p0<N, E> h(int i10) {
        this.f26436e = Optional.of(Integer.valueOf(Graphs.b(i10)));
        return this;
    }

    public <N1 extends N, E1 extends E> e0.a<N1, E1> j() {
        return new e0.a<>(d());
    }

    public <N1 extends N> p0<N1, E> k(ElementOrder<N1> elementOrder) {
        p0<N1, E> p0Var = (p0<N1, E>) d();
        p0Var.f26434c = (ElementOrder) b5.u.E(elementOrder);
        return p0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, E1 extends E> p0<N1, E1> d() {
        return this;
    }
}
