package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface Cache {
    void append(byte[] bArr, int i10) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();

    int read(byte[] bArr, long j10, int i10) throws ProxyCacheException;
}
