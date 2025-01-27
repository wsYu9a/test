package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public interface t1<K, V> extends l1<K, V> {
    @Override // e5.l1, e5.z0, e5.x0
    Map<K, Collection<V>> asMap();

    @Override // e5.l1, e5.z0, e5.x0
    /* bridge */ /* synthetic */ Collection get(@d1 Object obj);

    @Override // e5.l1, e5.z0, e5.x0
    /* bridge */ /* synthetic */ Set get(@d1 Object obj);

    @Override // e5.l1, e5.z0, e5.x0
    SortedSet<V> get(@d1 K k10);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    SortedSet<V> removeAll(@CheckForNull Object obj);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set replaceValues(@d1 Object obj, Iterable iterable);

    @Override // e5.l1, e5.z0, e5.x0
    @CanIgnoreReturnValue
    SortedSet<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable);

    @CheckForNull
    Comparator<? super V> valueComparator();
}
