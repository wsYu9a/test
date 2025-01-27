package com.google.common.graph;

import com.google.common.graph.GraphConstants;
import h5.k0;
import h5.l;
import h5.m0;
import h5.s;
import h5.t;
import h5.u0;
import h5.v;

@s
/* loaded from: classes2.dex */
public final class e<N> extends v<N> implements k0<N> {

    /* renamed from: a */
    public final m0<N, GraphConstants.Presence> f10041a;

    public e(h5.g<? super N> gVar) {
        this.f10041a = new u0(gVar);
    }

    @Override // h5.k0
    public boolean A(t<N> tVar) {
        P(tVar);
        return F(tVar.d(), tVar.e());
    }

    @Override // h5.k0
    public boolean F(N n10, N n11) {
        return this.f10041a.K(n10, n11, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // h5.v
    public l<N> Q() {
        return this.f10041a;
    }

    @Override // h5.k0
    public boolean o(N n10) {
        return this.f10041a.o(n10);
    }

    @Override // h5.k0
    public boolean q(N n10) {
        return this.f10041a.q(n10);
    }

    @Override // h5.k0
    public boolean r(N n10, N n11) {
        return this.f10041a.r(n10, n11) != null;
    }

    @Override // h5.k0
    public boolean t(t<N> tVar) {
        P(tVar);
        return r(tVar.d(), tVar.e());
    }
}
