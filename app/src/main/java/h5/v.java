package h5;

import com.google.common.graph.ElementOrder;
import java.util.Set;

@s
/* loaded from: classes2.dex */
public abstract class v<N> extends f<N> {
    @Override // h5.a
    public long N() {
        return Q().d().size();
    }

    public abstract l<N> Q();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a((v<N>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b((v<N>) obj);
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public boolean c(t<N> tVar) {
        return Q().c(tVar);
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public boolean e(N n10, N n11) {
        return Q().e(n10, n11);
    }

    @Override // h5.l, h5.z
    public boolean f() {
        return Q().f();
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public int g(N n10) {
        return Q().g(n10);
    }

    @Override // h5.l, h5.z
    public ElementOrder<N> h() {
        return Q().h();
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public int i(N n10) {
        return Q().i(n10);
    }

    @Override // h5.l, h5.z
    public boolean j() {
        return Q().j();
    }

    @Override // h5.l, h5.z
    public Set<N> k(N n10) {
        return Q().k(n10);
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public Set<t<N>> l(N n10) {
        return Q().l(n10);
    }

    @Override // h5.l, h5.z
    public Set<N> m() {
        return Q().m();
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public int n(N n10) {
        return Q().n(n10);
    }

    @Override // h5.f, h5.a, h5.l, h5.z
    public ElementOrder<N> p() {
        return Q().p();
    }

    @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
    public Set<N> a(N n10) {
        return Q().a((l<N>) n10);
    }

    @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
    public Set<N> b(N n10) {
        return Q().b((l<N>) n10);
    }
}
