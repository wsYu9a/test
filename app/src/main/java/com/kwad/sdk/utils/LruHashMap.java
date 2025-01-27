package com.kwad.sdk.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final long maxSize;

    public LruHashMap(long j2) {
        super(((int) Math.ceil(j2 / 0.75f)) + 1, 0.75f, true);
        this.maxSize = j2;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return ((long) size()) > this.maxSize;
    }
}
