package e5;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@a5.b
@m
/* loaded from: classes2.dex */
public interface j1<R, C, V> extends com.google.common.collect.a0<R, C, V> {
    @Override // com.google.common.collect.a0
    /* bridge */ /* synthetic */ Set rowKeySet();

    @Override // com.google.common.collect.a0
    SortedSet<R> rowKeySet();

    @Override // com.google.common.collect.a0
    /* bridge */ /* synthetic */ Map rowMap();

    @Override // com.google.common.collect.a0
    SortedMap<R, Map<C, V>> rowMap();
}
