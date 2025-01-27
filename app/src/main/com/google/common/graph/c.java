package com.google.common.graph;

import b5.n;
import b5.u;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphConstants;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import h5.a0;
import h5.k0;
import h5.l;
import h5.s;
import h5.t;
import h5.v;
import h5.w0;
import h5.z;
import java.util.Set;

@Immutable(containerOf = {"N"})
@a5.a
@s
/* loaded from: classes2.dex */
public class c<N> extends v<N> {

    /* renamed from: a */
    public final l<N> f10038a;

    public static class a<N> {

        /* renamed from: a */
        public final k0<N> f10039a;

        public a(b<N> bVar) {
            this.f10039a = bVar.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public a<N> a(N n10) {
            this.f10039a.q(n10);
            return this;
        }

        public c<N> b() {
            return c.T(this.f10039a);
        }

        @CanIgnoreReturnValue
        public a<N> c(t<N> tVar) {
            this.f10039a.A(tVar);
            return this;
        }

        @CanIgnoreReturnValue
        public a<N> d(N n10, N n11) {
            this.f10039a.F(n10, n11);
            return this;
        }
    }

    public c(l<N> lVar) {
        this.f10038a = lVar;
    }

    public static <N> a0<N, GraphConstants.Presence> R(z<N> zVar, N n10) {
        n b10 = Functions.b(GraphConstants.Presence.EDGE_EXISTS);
        return zVar.f() ? com.google.common.graph.a.y(n10, zVar.l(n10), b10) : f.m(Maps.j(zVar.k(n10), b10));
    }

    @Deprecated
    public static <N> c<N> S(c<N> cVar) {
        return (c) u.E(cVar);
    }

    public static <N> c<N> T(z<N> zVar) {
        return zVar instanceof c ? (c) zVar : new c<>(new w0(b.g(zVar), U(zVar), zVar.d().size()));
    }

    public static <N> ImmutableMap<N, a0<N, GraphConstants.Presence>> U(z<N> zVar) {
        ImmutableMap.b builder = ImmutableMap.builder();
        for (N n10 : zVar.m()) {
            builder.i(n10, R(zVar, n10));
        }
        return builder.d();
    }

    @Override // h5.v
    public l<N> Q() {
        return this.f10038a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a((c<N>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b((c<N>) obj);
    }

    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean c(t tVar) {
        return super.c(tVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // h5.v, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int g(Object obj) {
        return super.g(obj);
    }

    @Override // h5.v, h5.l, h5.z
    public /* bridge */ /* synthetic */ ElementOrder h() {
        return super.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int i(Object obj) {
        return super.i(obj);
    }

    @Override // h5.v, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    @Override // h5.v, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int n(Object obj) {
        return super.n(obj);
    }

    @Override // h5.v, h5.f, h5.a, h5.l, h5.z
    public ElementOrder<N> p() {
        return ElementOrder.g();
    }
}
