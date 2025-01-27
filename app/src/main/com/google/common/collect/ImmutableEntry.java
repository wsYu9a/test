package com.google.common.collect;

import e5.d1;
import java.io.Serializable;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
class ImmutableEntry<K, V> extends e5.b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @d1
    final K key;

    @d1
    final V value;

    public ImmutableEntry(@d1 K k10, @d1 V v10) {
        this.key = k10;
        this.value = v10;
    }

    @Override // e5.b, java.util.Map.Entry
    @d1
    public final K getKey() {
        return this.key;
    }

    @Override // e5.b, java.util.Map.Entry
    @d1
    public final V getValue() {
        return this.value;
    }

    @Override // e5.b, java.util.Map.Entry
    @d1
    public final V setValue(@d1 V v10) {
        throw new UnsupportedOperationException();
    }
}
