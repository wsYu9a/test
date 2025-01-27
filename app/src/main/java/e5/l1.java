package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public interface l1<K, V> extends z0<K, V> {
    @Override // e5.z0, e5.x0
    Map<K, Collection<V>> asMap();

    @Override // e5.z0
    /* bridge */ /* synthetic */ Collection entries();

    @Override // e5.z0
    Set<Map.Entry<K, V>> entries();

    @Override // e5.z0, e5.x0
    boolean equals(@CheckForNull Object obj);

    @Override // e5.z0, e5.x0
    /* bridge */ /* synthetic */ Collection get(@d1 Object obj);

    @Override // e5.z0, e5.x0
    Set<V> get(@d1 K k10);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    Set<V> removeAll(@CheckForNull Object obj);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable);

    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable);
}
