package d5;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@a5.c
@d
/* loaded from: classes2.dex */
public abstract class a<K, V> extends com.google.common.cache.a<K, V> implements g<K, V> {
    @Override // d5.g, b5.n
    public final V apply(K k10) {
        return getUnchecked(k10);
    }

    @Override // d5.g
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap c02 = Maps.c0();
        for (K k10 : iterable) {
            if (!c02.containsKey(k10)) {
                c02.put(k10, get(k10));
            }
        }
        return ImmutableMap.copyOf((Map) c02);
    }

    @Override // d5.g
    public V getUnchecked(K k10) {
        try {
            return get(k10);
        } catch (ExecutionException e10) {
            throw new UncheckedExecutionException(e10.getCause());
        }
    }

    @Override // d5.g
    public void refresh(K k10) {
        throw new UnsupportedOperationException();
    }
}
