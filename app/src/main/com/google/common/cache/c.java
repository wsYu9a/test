package com.google.common.cache;

import com.google.common.cache.LocalCache;
import d5.d;
import javax.annotation.CheckForNull;

@a5.c
@d
/* loaded from: classes2.dex */
public interface c<K, V> {
    long getAccessTime();

    int getHash();

    @CheckForNull
    K getKey();

    @CheckForNull
    c<K, V> getNext();

    c<K, V> getNextInAccessQueue();

    c<K, V> getNextInWriteQueue();

    c<K, V> getPreviousInAccessQueue();

    c<K, V> getPreviousInWriteQueue();

    @CheckForNull
    LocalCache.s<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j10);

    void setNextInAccessQueue(c<K, V> cVar);

    void setNextInWriteQueue(c<K, V> cVar);

    void setPreviousInAccessQueue(c<K, V> cVar);

    void setPreviousInWriteQueue(c<K, V> cVar);

    void setValueReference(LocalCache.s<K, V> sVar);

    void setWriteTime(long j10);
}
