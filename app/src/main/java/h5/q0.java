package h5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public interface q0<N, E> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @CanIgnoreReturnValue
    @CheckForNull
    N d(E e10, boolean z10);

    void e(E e10, N n10);

    void f(E e10, N n10, boolean z10);

    Set<E> g();

    N h(E e10);

    Set<E> i();

    @CanIgnoreReturnValue
    N j(E e10);

    Set<E> k();

    Set<E> l(N n10);
}
