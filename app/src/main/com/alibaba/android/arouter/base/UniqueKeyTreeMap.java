package com.alibaba.android.arouter.base;

import java.util.TreeMap;

/* loaded from: classes.dex */
public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (containsKey(k10)) {
            throw new RuntimeException(String.format(this.tipText, k10));
        }
        return (V) super.put(k10, v10);
    }
}
