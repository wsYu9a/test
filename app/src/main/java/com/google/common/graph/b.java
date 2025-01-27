package com.google.common.graph;

import b5.u;
import com.google.common.base.Optional;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.c;
import com.google.errorprone.annotations.DoNotMock;
import h5.k0;
import h5.s;
import h5.z;

@DoNotMock
@s
@a5.a
/* loaded from: classes2.dex */
public final class b<N> extends h5.g<N> {
    public b(boolean z10) {
        super(z10);
    }

    public static b<Object> e() {
        return new b<>(true);
    }

    public static <N> b<N> g(z<N> zVar) {
        return new b(zVar.f()).a(zVar.j()).j(zVar.h()).i(zVar.p());
    }

    public static b<Object> k() {
        return new b<>(false);
    }

    public b<N> a(boolean z10) {
        this.f26433b = z10;
        return this;
    }

    public <N1 extends N> k0<N1> b() {
        return new e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N> b<N1> c() {
        return this;
    }

    public b<N> d() {
        b<N> bVar = new b<>(this.f26432a);
        bVar.f26433b = this.f26433b;
        bVar.f26434c = this.f26434c;
        bVar.f26436e = this.f26436e;
        bVar.f26435d = this.f26435d;
        return bVar;
    }

    public b<N> f(int i10) {
        this.f26436e = Optional.of(Integer.valueOf(Graphs.b(i10)));
        return this;
    }

    public <N1 extends N> c.a<N1> h() {
        return new c.a<>(c());
    }

    public <N1 extends N> b<N1> i(ElementOrder<N1> elementOrder) {
        u.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        b<N1> c10 = c();
        c10.f26435d = (ElementOrder) u.E(elementOrder);
        return c10;
    }

    public <N1 extends N> b<N1> j(ElementOrder<N1> elementOrder) {
        b<N1> c10 = c();
        c10.f26434c = (ElementOrder) u.E(elementOrder);
        return c10;
    }
}
