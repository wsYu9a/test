package h5;

import com.google.common.graph.ElementOrder;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class x<N, V> extends j<N, V> {
    @CheckForNull
    public V L(t<N> tVar, @CheckForNull V v10) {
        return R().L(tVar, v10);
    }

    @Override // h5.a
    public long N() {
        return R().d().size();
    }

    public abstract c1<N, V> R();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.j, h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a((x<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.j, h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b((x<N, V>) obj);
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public boolean c(t<N> tVar) {
        return R().c(tVar);
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public boolean e(N n10, N n11) {
        return R().e(n10, n11);
    }

    @Override // h5.l, h5.z
    public boolean f() {
        return R().f();
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public int g(N n10) {
        return R().g(n10);
    }

    @Override // h5.l, h5.z
    public ElementOrder<N> h() {
        return R().h();
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public int i(N n10) {
        return R().i(n10);
    }

    @Override // h5.l, h5.z
    public boolean j() {
        return R().j();
    }

    @Override // h5.l, h5.z
    public Set<N> k(N n10) {
        return R().k(n10);
    }

    @Override // h5.l, h5.z
    public Set<N> m() {
        return R().m();
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public int n(N n10) {
        return R().n(n10);
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public ElementOrder<N> p() {
        return R().p();
    }

    @CheckForNull
    public V z(N n10, N n11, @CheckForNull V v10) {
        return R().z(n10, n11, v10);
    }

    @Override // h5.j, h5.a, h5.l, h5.s0, h5.z
    public Set<N> a(N n10) {
        return R().a((c1<N, V>) n10);
    }

    @Override // h5.j, h5.a, h5.l, h5.x0, h5.z
    public Set<N> b(N n10) {
        return R().b((c1<N, V>) n10);
    }
}
