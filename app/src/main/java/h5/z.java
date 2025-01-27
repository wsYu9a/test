package h5;

import com.google.common.graph.ElementOrder;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@DoNotMock("Use GraphBuilder to create a real instance")
@s
@a5.a
/* loaded from: classes2.dex */
public interface z<N> extends l<N> {
    /* bridge */ /* synthetic */ Iterable a(Object obj);

    @Override // h5.l, h5.s0, h5.z
    Set<N> a(N n10);

    /* bridge */ /* synthetic */ Iterable b(Object obj);

    @Override // h5.l, h5.x0, h5.z
    Set<N> b(N n10);

    boolean c(t<N> tVar);

    @Override // h5.l
    Set<t<N>> d();

    boolean e(N n10, N n11);

    boolean equals(@CheckForNull Object obj);

    boolean f();

    int g(N n10);

    ElementOrder<N> h();

    int hashCode();

    int i(N n10);

    boolean j();

    Set<N> k(N n10);

    Set<t<N>> l(N n10);

    Set<N> m();

    int n(N n10);

    ElementOrder<N> p();
}
