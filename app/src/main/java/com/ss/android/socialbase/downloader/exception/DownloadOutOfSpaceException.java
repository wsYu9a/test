package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes4.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long j2, long j3) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j3), String.valueOf(j2)));
        this.avaliableSpaceBytes = j2;
        this.requiredSpaceBytes = j3;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
