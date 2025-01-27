package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import e5.d1;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
/* loaded from: classes2.dex */
public interface a0<R, C, V> {

    public interface a<R, C, V> {
        boolean equals(@CheckForNull Object obj);

        @d1
        C getColumnKey();

        @d1
        R getRowKey();

        @d1
        V getValue();

        int hashCode();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(@d1 C c10);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith("C") Object obj2);

    boolean containsColumn(@CheckForNull @CompatibleWith("C") Object obj);

    boolean containsRow(@CheckForNull @CompatibleWith("R") Object obj);

    boolean containsValue(@CheckForNull @CompatibleWith("V") Object obj);

    boolean equals(@CheckForNull Object obj);

    @CheckForNull
    V get(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith("C") Object obj2);

    int hashCode();

    boolean isEmpty();

    @CanIgnoreReturnValue
    @CheckForNull
    V put(@d1 R r10, @d1 C c10, @d1 V v10);

    void putAll(a0<? extends R, ? extends C, ? extends V> a0Var);

    @CanIgnoreReturnValue
    @CheckForNull
    V remove(@CheckForNull @CompatibleWith("R") Object obj, @CheckForNull @CompatibleWith("C") Object obj2);

    Map<C, V> row(@d1 R r10);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
