package com.google.gason;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
final class LruCache<K, V> extends LinkedHashMap<K, V> implements Cache<K, V> {
    private static final long serialVersionUID = 1;
    private final int maxCapacity;

    public LruCache(int i2) {
        super(i2, ((Float) new Object[]{new Float(0.7f)}[0]).floatValue(), true);
        this.maxCapacity = i2;
    }

    @Override // com.google.gason.Cache
    public void addElement(K k, V v) {
        synchronized (this) {
            put(k, v);
        }
    }

    @Override // com.google.gason.Cache
    public V getElement(K k) {
        V v;
        synchronized (this) {
            v = get(k);
        }
        return v;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxCapacity;
    }
}
