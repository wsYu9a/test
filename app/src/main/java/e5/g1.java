package e5;

import com.google.common.collect.Range;
import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.a
@m
@DoNotMock("Use ImmutableRangeMap or TreeRangeMap")
@a5.c
/* loaded from: classes2.dex */
public interface g1<K extends Comparable, V> {
    Map<Range<K>, V> asDescendingMapOfRanges();

    Map<Range<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@CheckForNull Object obj);

    @CheckForNull
    V get(K k10);

    @CheckForNull
    Map.Entry<Range<K>, V> getEntry(K k10);

    int hashCode();

    void put(Range<K> range, V v10);

    void putAll(g1<K, V> g1Var);

    void putCoalescing(Range<K> range, V v10);

    void remove(Range<K> range);

    Range<K> span();

    g1<K, V> subRangeMap(Range<K> range);

    String toString();
}
