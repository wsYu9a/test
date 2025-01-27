package h5;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.graph.ElementOrder;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@Immutable(containerOf = {"N", ExifInterface.LONGITUDE_EAST})
@a5.a
@s
/* loaded from: classes2.dex */
public final class e0<N, E> extends v0<N, E> {

    public static class a<N, E> {

        /* renamed from: a */
        public final l0<N, E> f26429a;

        public a(p0<N, E> p0Var) {
            this.f26429a = (l0<N, E>) p0Var.c();
        }

        @CanIgnoreReturnValue
        public a<N, E> a(t<N> tVar, E e10) {
            this.f26429a.u(tVar, e10);
            return this;
        }

        @CanIgnoreReturnValue
        public a<N, E> b(N n10, N n11, E e10) {
            this.f26429a.M(n10, n11, e10);
            return this;
        }

        @CanIgnoreReturnValue
        public a<N, E> c(N n10) {
            this.f26429a.q(n10);
            return this;
        }

        public e0<N, E> d() {
            return e0.c0(this.f26429a);
        }
    }

    public e0(o0<N, E> o0Var) {
        super(p0.i(o0Var), e0(o0Var), d0(o0Var));
    }

    public static <N, E> b5.n<E, N> Y(o0<N, E> o0Var, N n10) {
        return new b5.n() { // from class: h5.c0

            /* renamed from: c */
            public final /* synthetic */ Object f26422c;

            public /* synthetic */ c0(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                Object f02;
                f02 = e0.f0(o0.this, n10, obj);
                return f02;
            }
        };
    }

    public static <N, E> q0<N, E> a0(o0<N, E> o0Var, N n10) {
        if (!o0Var.f()) {
            Map j10 = Maps.j(o0Var.l(n10), Y(o0Var, n10));
            return o0Var.y() ? z0.q(j10) : a1.n(j10);
        }
        Map j11 = Maps.j(o0Var.J(n10), i0(o0Var));
        Map j12 = Maps.j(o0Var.v(n10), j0(o0Var));
        int size = o0Var.x(n10, n10).size();
        return o0Var.y() ? p.q(j11, j12, size) : q.o(j11, j12, size);
    }

    @Deprecated
    public static <N, E> e0<N, E> b0(e0<N, E> e0Var) {
        return (e0) b5.u.E(e0Var);
    }

    public static <N, E> e0<N, E> c0(o0<N, E> o0Var) {
        return o0Var instanceof e0 ? (e0) o0Var : new e0<>(o0Var);
    }

    public static <N, E> Map<E, N> d0(o0<N, E> o0Var) {
        ImmutableMap.b builder = ImmutableMap.builder();
        for (E e10 : o0Var.d()) {
            builder.i(e10, o0Var.E(e10).d());
        }
        return builder.d();
    }

    public static <N, E> Map<N, q0<N, E>> e0(o0<N, E> o0Var) {
        ImmutableMap.b builder = ImmutableMap.builder();
        for (N n10 : o0Var.m()) {
            builder.i(n10, a0(o0Var, n10));
        }
        return builder.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object f0(o0 o0Var, Object obj, Object obj2) {
        return o0Var.E(obj2).a(obj);
    }

    public static /* synthetic */ Object g0(o0 o0Var, Object obj) {
        return o0Var.E(obj).i();
    }

    public static /* synthetic */ Object h0(o0 o0Var, Object obj) {
        return o0Var.E(obj).j();
    }

    public static <N, E> b5.n<E, N> i0(o0<N, E> o0Var) {
        return new b5.n() { // from class: h5.b0
            public /* synthetic */ b0() {
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                Object g02;
                g02 = e0.g0(o0.this, obj);
                return g02;
            }
        };
    }

    public static <N, E> b5.n<E, N> j0(o0<N, E> o0Var) {
        return new b5.n() { // from class: h5.d0
            public /* synthetic */ d0() {
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                Object h02;
                h02 = e0.h0(o0.this, obj);
                return h02;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ t E(Object obj) {
        return super.E(obj);
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ ElementOrder H() {
        return super.H();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set J(Object obj) {
        return super.J(obj);
    }

    @Override // h5.h, h5.o0
    /* renamed from: Z */
    public com.google.common.graph.c<N> s() {
        return new com.google.common.graph.c<>(super.s());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.h, h5.o0, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a((e0<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.h, h5.o0, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b((e0<N, E>) obj);
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ ElementOrder h() {
        return super.h();
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ Set v(Object obj) {
        return super.v(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.v0, h5.h, h5.o0
    public /* bridge */ /* synthetic */ Set x(Object obj, Object obj2) {
        return super.x(obj, obj2);
    }

    @Override // h5.v0, h5.o0
    public /* bridge */ /* synthetic */ boolean y() {
        return super.y();
    }
}
