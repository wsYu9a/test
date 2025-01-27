package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import e5.d1;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
@DoNotMock("Use Maps.difference")
/* loaded from: classes2.dex */
public interface r<K, V> {

    @DoNotMock("Use Maps.difference")
    public interface a<V> {
        @d1
        V a();

        @d1
        V b();

        boolean equals(@CheckForNull Object obj);

        int hashCode();
    }

    Map<K, V> a();

    Map<K, V> b();

    Map<K, a<V>> c();

    Map<K, V> d();

    boolean e();

    boolean equals(@CheckForNull Object obj);

    int hashCode();
}
