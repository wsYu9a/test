package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public interface x0<K, V> extends z0<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@CheckForNull Object obj);

    /* bridge */ /* synthetic */ Collection get(@d1 Object obj);

    @Override // e5.z0, e5.x0
    List<V> get(@d1 K k10);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    List<V> removeAll(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    List<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable);
}
