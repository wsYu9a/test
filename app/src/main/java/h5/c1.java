package h5;

import com.google.common.graph.ElementOrder;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
@a5.a
/* loaded from: classes2.dex */
public interface c1<N, V> extends l<N> {
    @CheckForNull
    V L(t<N> tVar, @CheckForNull V v10);

    @Override // h5.l, h5.s0, h5.z
    /* bridge */ /* synthetic */ Iterable a(Object obj);

    @Override // h5.l, h5.s0, h5.z
    Set<N> a(N n10);

    @Override // h5.l, h5.x0, h5.z
    /* bridge */ /* synthetic */ Iterable b(Object obj);

    @Override // h5.l, h5.x0, h5.z
    Set<N> b(N n10);

    @Override // h5.l, h5.z
    boolean c(t<N> tVar);

    @Override // h5.l
    Set<t<N>> d();

    @Override // h5.l, h5.z
    boolean e(N n10, N n11);

    boolean equals(@CheckForNull Object obj);

    @Override // h5.l, h5.z
    boolean f();

    @Override // h5.l, h5.z
    int g(N n10);

    @Override // h5.l, h5.z
    ElementOrder<N> h();

    int hashCode();

    @Override // h5.l, h5.z
    int i(N n10);

    @Override // h5.l, h5.z
    boolean j();

    @Override // h5.l, h5.z
    Set<N> k(N n10);

    @Override // h5.l, h5.z
    Set<t<N>> l(N n10);

    @Override // h5.l, h5.z
    Set<N> m();

    @Override // h5.l, h5.z
    int n(N n10);

    @Override // h5.l, h5.z
    ElementOrder<N> p();

    z<N> s();

    @CheckForNull
    V z(N n10, N n11, @CheckForNull V v10);
}
