package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void append(byte[] bArr, int i10) throws ProxyCacheException {
        Preconditions.checkNotNull(this.data);
        Preconditions.checkArgument(i10 >= 0 && i10 <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.data, this.data.length + i10);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i10);
        this.data = copyOf;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public long available() throws ProxyCacheException {
        return this.data.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void close() throws ProxyCacheException {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public int read(byte[] bArr, long j10, int i10) throws ProxyCacheException {
        if (j10 >= this.data.length) {
            return -1;
        }
        if (j10 <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j10, i10);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j10);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
    }
}
