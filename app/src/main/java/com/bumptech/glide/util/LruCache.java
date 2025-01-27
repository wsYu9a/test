package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long j10) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t10) {
        return this.cache.containsKey(t10);
    }

    @Nullable
    public synchronized Y get(@NonNull T t10) {
        return this.cache.get(t10);
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y10) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t10, @Nullable Y y10) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t10, @Nullable Y y10) {
        long size = getSize(y10);
        if (size >= this.maxSize) {
            onItemEvicted(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.currentSize += size;
        }
        Y put = this.cache.put(t10, y10);
        if (put != null) {
            this.currentSize -= getSize(put);
            if (!put.equals(y10)) {
                onItemEvicted(t10, put);
            }
        }
        evict();
        return put;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t10) {
        Y remove;
        remove = this.cache.remove(t10);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public synchronized void setSizeMultiplier(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f10);
        evict();
    }

    public synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            Iterator<Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
