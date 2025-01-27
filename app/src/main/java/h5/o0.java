package h5;

import com.google.common.graph.ElementOrder;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@DoNotMock("Use NetworkBuilder to create a real instance")
@s
@a5.a
/* loaded from: classes2.dex */
public interface o0<N, E> extends x0<N>, s0<N> {
    Set<E> B(t<N> tVar);

    @CheckForNull
    E D(N n10, N n11);

    t<N> E(E e10);

    @CheckForNull
    E G(t<N> tVar);

    ElementOrder<E> H();

    Set<E> J(N n10);

    /* bridge */ /* synthetic */ Iterable a(Object obj);

    @Override // h5.s0, h5.z
    Set<N> a(N n10);

    @Override // h5.x0, h5.z
    /* bridge */ /* synthetic */ Iterable b(Object obj);

    @Override // h5.x0, h5.z
    Set<N> b(N n10);

    boolean c(t<N> tVar);

    Set<E> d();

    boolean e(N n10, N n11);

    boolean equals(@CheckForNull Object obj);

    boolean f();

    int g(N n10);

    ElementOrder<N> h();

    int hashCode();

    int i(N n10);

    boolean j();

    Set<N> k(N n10);

    Set<E> l(N n10);

    Set<N> m();

    int n(N n10);

    z<N> s();

    Set<E> v(N n10);

    Set<E> w(E e10);

    Set<E> x(N n10, N n11);

    boolean y();
}
