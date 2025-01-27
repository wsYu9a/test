package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

/* loaded from: classes.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j10;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(File file, long j10, int i10) {
        return j10 <= this.maxSize;
    }
}
