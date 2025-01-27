package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@m
/* loaded from: classes2.dex */
public interface z0<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@CheckForNull @CompatibleWith("K") Object obj, @CheckForNull @CompatibleWith("V") Object obj2);

    boolean containsKey(@CheckForNull @CompatibleWith("K") Object obj);

    boolean containsValue(@CheckForNull @CompatibleWith("V") Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object obj);

    Collection<V> get(@d1 K k10);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    com.google.common.collect.s<K> keys();

    @CanIgnoreReturnValue
    boolean put(@d1 K k10, @d1 V v10);

    @CanIgnoreReturnValue
    boolean putAll(z0<? extends K, ? extends V> z0Var);

    @CanIgnoreReturnValue
    boolean putAll(@d1 K k10, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    boolean remove(@CheckForNull @CompatibleWith("K") Object obj, @CheckForNull @CompatibleWith("V") Object obj2);

    @CanIgnoreReturnValue
    Collection<V> removeAll(@CheckForNull @CompatibleWith("K") Object obj);

    @CanIgnoreReturnValue
    Collection<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
