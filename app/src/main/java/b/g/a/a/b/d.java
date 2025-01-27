package b.g.a.a.b;

import java.util.Collection;

@Deprecated
/* loaded from: classes4.dex */
public interface d<K, V> {
    void clear();

    V get(K k);

    Collection<K> keys();

    boolean put(K k, V v);

    V remove(K k);
}
