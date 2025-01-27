package d5;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

@a5.b
@DoNotMock("Use CacheBuilder.newBuilder().build()")
@d
/* loaded from: classes2.dex */
public interface b<K, V> {
    @CheckReturnValue
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k10, Callable<? extends V> callable) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable);

    @CheckForNull
    V getIfPresent(@CompatibleWith("K") Object obj);

    void invalidate(@CompatibleWith("K") Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> iterable);

    void put(K k10, V v10);

    void putAll(Map<? extends K, ? extends V> map);

    @CheckReturnValue
    long size();

    @CheckReturnValue
    c stats();
}
