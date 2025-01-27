package h5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public interface a0<N, V> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @CheckForNull
    V d(N n10);

    @CanIgnoreReturnValue
    @CheckForNull
    V e(N n10);

    void f(N n10);

    Iterator<t<N>> g(N n10);

    @CanIgnoreReturnValue
    @CheckForNull
    V h(N n10, V v10);

    void i(N n10, V v10);
}
