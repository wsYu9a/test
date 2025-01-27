package d5;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a5.b
@d
/* loaded from: classes2.dex */
public interface g<K, V> extends b<K, V>, b5.n<K, V> {
    @Override // b5.n
    @Deprecated
    V apply(K k10);

    @Override // d5.b
    ConcurrentMap<K, V> asMap();

    V get(K k10) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k10);

    void refresh(K k10);
}
