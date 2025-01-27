package h5;

import com.google.common.graph.ElementOrder;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class w<N, E> extends h<N, E> {
    @Override // h5.h, h5.o0
    public Set<E> B(t<N> tVar) {
        return R().B(tVar);
    }

    @Override // h5.h, h5.o0
    @CheckForNull
    public E D(N n10, N n11) {
        return R().D(n10, n11);
    }

    @Override // h5.o0
    public t<N> E(E e10) {
        return R().E(e10);
    }

    @Override // h5.h, h5.o0
    @CheckForNull
    public E G(t<N> tVar) {
        return R().G(tVar);
    }

    @Override // h5.o0
    public ElementOrder<E> H() {
        return R().H();
    }

    @Override // h5.o0
    public Set<E> J(N n10) {
        return R().J(n10);
    }

    public abstract o0<N, E> R();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.h, h5.o0, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a((w<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.h, h5.o0, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b((w<N, E>) obj);
    }

    @Override // h5.h, h5.o0
    public boolean c(t<N> tVar) {
        return R().c(tVar);
    }

    @Override // h5.o0
    public Set<E> d() {
        return R().d();
    }

    @Override // h5.h, h5.o0
    public boolean e(N n10, N n11) {
        return R().e(n10, n11);
    }

    @Override // h5.o0
    public boolean f() {
        return R().f();
    }

    @Override // h5.h, h5.o0
    public int g(N n10) {
        return R().g(n10);
    }

    @Override // h5.o0
    public ElementOrder<N> h() {
        return R().h();
    }

    @Override // h5.h, h5.o0
    public int i(N n10) {
        return R().i(n10);
    }

    @Override // h5.o0
    public boolean j() {
        return R().j();
    }

    @Override // h5.o0
    public Set<N> k(N n10) {
        return R().k(n10);
    }

    @Override // h5.o0
    public Set<E> l(N n10) {
        return R().l(n10);
    }

    @Override // h5.o0
    public Set<N> m() {
        return R().m();
    }

    @Override // h5.h, h5.o0
    public int n(N n10) {
        return R().n(n10);
    }

    @Override // h5.o0
    public Set<E> v(N n10) {
        return R().v(n10);
    }

    @Override // h5.h, h5.o0
    public Set<E> w(E e10) {
        return R().w(e10);
    }

    @Override // h5.h, h5.o0
    public Set<E> x(N n10, N n11) {
        return R().x(n10, n11);
    }

    @Override // h5.o0
    public boolean y() {
        return R().y();
    }

    @Override // h5.h, h5.o0, h5.s0, h5.z
    public Set<N> a(N n10) {
        return R().a((o0<N, E>) n10);
    }

    @Override // h5.h, h5.o0, h5.x0, h5.z
    public Set<N> b(N n10) {
        return R().b((o0<N, E>) n10);
    }
}
