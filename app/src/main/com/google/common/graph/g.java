package com.google.common.graph;

import b5.u;
import com.google.common.base.Optional;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.d;
import h5.c1;
import h5.m0;
import h5.s;
import h5.u0;

@s
@a5.a
/* loaded from: classes2.dex */
public final class g<N, V> extends h5.g<N> {
    public g(boolean z10) {
        super(z10);
    }

    public static g<Object, Object> e() {
        return new g<>(true);
    }

    public static <N, V> g<N, V> g(c1<N, V> c1Var) {
        return new g(c1Var.f()).a(c1Var.j()).j(c1Var.h()).i(c1Var.p());
    }

    public static g<Object, Object> k() {
        return new g<>(false);
    }

    public g<N, V> a(boolean z10) {
        this.f26433b = z10;
        return this;
    }

    public <N1 extends N, V1 extends V> m0<N1, V1> b() {
        return new u0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, V1 extends V> g<N1, V1> c() {
        return this;
    }

    public g<N, V> d() {
        g<N, V> gVar = new g<>(this.f26432a);
        gVar.f26433b = this.f26433b;
        gVar.f26434c = this.f26434c;
        gVar.f26436e = this.f26436e;
        gVar.f26435d = this.f26435d;
        return gVar;
    }

    public g<N, V> f(int i10) {
        this.f26436e = Optional.of(Integer.valueOf(Graphs.b(i10)));
        return this;
    }

    public <N1 extends N, V1 extends V> d.a<N1, V1> h() {
        return new d.a<>(c());
    }

    public <N1 extends N> g<N1, V> i(ElementOrder<N1> elementOrder) {
        u.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        g<N1, V> gVar = (g<N1, V>) c();
        gVar.f26435d = (ElementOrder) u.E(elementOrder);
        return gVar;
    }

    public <N1 extends N> g<N1, V> j(ElementOrder<N1> elementOrder) {
        g<N1, V> gVar = (g<N1, V>) c();
        gVar.f26434c = (ElementOrder) u.E(elementOrder);
        return gVar;
    }
}
