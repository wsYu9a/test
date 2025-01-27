package xe;

import java.util.Collection;

@Deprecated
/* loaded from: classes3.dex */
public interface d<K, V> {
    void clear();

    V get(K k10);

    Collection<K> keys();

    boolean put(K k10, V v10);

    V remove(K k10);
}
