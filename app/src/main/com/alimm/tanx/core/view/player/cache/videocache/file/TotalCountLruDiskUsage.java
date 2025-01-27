package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

/* loaded from: classes.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i10;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(File file, long j10, int i10) {
        return i10 <= this.maxCount;
    }
}
