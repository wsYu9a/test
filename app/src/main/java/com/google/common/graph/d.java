package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import b5.n;
import b5.u;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import h5.a0;
import h5.c1;
import h5.f0;
import h5.m0;
import h5.s;
import h5.t;
import h5.w0;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@a5.a
@s
/* loaded from: classes2.dex */
public final class d<N, V> extends w0<N, V> {

    public static class a<N, V> {

        /* renamed from: a */
        public final m0<N, V> f10040a;

        public a(g<N, V> gVar) {
            this.f10040a = gVar.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public a<N, V> a(N n10) {
            this.f10040a.q(n10);
            return this;
        }

        public d<N, V> b() {
            return d.Z(this.f10040a);
        }

        @CanIgnoreReturnValue
        public a<N, V> c(t<N> tVar, V v10) {
            this.f10040a.C(tVar, v10);
            return this;
        }

        @CanIgnoreReturnValue
        public a<N, V> d(N n10, N n11, V v10) {
            this.f10040a.K(n10, n11, v10);
            return this;
        }
    }

    public d(c1<N, V> c1Var) {
        super(g.g(c1Var), a0(c1Var), c1Var.d().size());
    }

    public static <N, V> a0<N, V> X(c1<N, V> c1Var, N n10) {
        f0 f0Var = new n() { // from class: h5.f0

            /* renamed from: c */
            public final /* synthetic */ Object f26431c;

            public /* synthetic */ f0(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                Object b02;
                b02 = com.google.common.graph.d.b0(c1.this, n10, obj);
                return b02;
            }
        };
        return c1Var.f() ? com.google.common.graph.a.y(n102, c1Var.l(n102), f0Var) : f.m(Maps.j(c1Var.k(n102), f0Var));
    }

    @Deprecated
    public static <N, V> d<N, V> Y(d<N, V> dVar) {
        return (d) u.E(dVar);
    }

    public static <N, V> d<N, V> Z(c1<N, V> c1Var) {
        return c1Var instanceof d ? (d) c1Var : new d<>(c1Var);
    }

    public static <N, V> ImmutableMap<N, a0<N, V>> a0(c1<N, V> c1Var) {
        ImmutableMap.b builder = ImmutableMap.builder();
        for (N n10 : c1Var.m()) {
            builder.i(n10, X(c1Var, n10));
        }
        return builder.d();
    }

    public static /* synthetic */ Object b0(c1 c1Var, Object obj, Object obj2) {
        Object z10 = c1Var.z(obj, obj2, null);
        Objects.requireNonNull(z10);
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.c1
    @CheckForNull
    public /* bridge */ /* synthetic */ Object L(t tVar, @CheckForNull Object obj) {
        return super.L(tVar, obj);
    }

    @Override // h5.j, h5.c1
    /* renamed from: W */
    public c<N> s() {
        return new c<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.j, h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a((d<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.j, h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b((d<N, V>) obj);
    }

    @Override // h5.w0, h5.j, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean c(t tVar) {
        return super.c(tVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.j, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // h5.w0, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // h5.w0, h5.l, h5.z
    public /* bridge */ /* synthetic */ ElementOrder h() {
        return super.h();
    }

    @Override // h5.w0, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.j, h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    @Override // h5.w0, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public ElementOrder<N> p() {
        return ElementOrder.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.w0, h5.c1
    @CheckForNull
    public /* bridge */ /* synthetic */ Object z(Object obj, Object obj2, @CheckForNull Object obj3) {
        return super.z(obj, obj2, obj3);
    }
}
