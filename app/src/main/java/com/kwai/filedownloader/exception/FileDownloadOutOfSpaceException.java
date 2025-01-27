package com.kwai.filedownloader.exception;

import android.annotation.TargetApi;
import com.kwai.filedownloader.e.f;
import java.io.IOException;

/* loaded from: classes2.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    public FileDownloadOutOfSpaceException(long j2, long j3, long j4) {
        super(f.j("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)));
        init(j2, j3, j4);
    }

    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j2, long j3, long j4, Throwable th) {
        super(f.j("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)), th);
        init(j2, j3, j4);
    }

    private void init(long j2, long j3, long j4) {
        this.freeSpaceBytes = j2;
        this.requiredSpaceBytes = j3;
        this.breakpointBytes = j4;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
