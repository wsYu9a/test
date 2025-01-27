package com.kwai.filedownloader.download;

/* loaded from: classes2.dex */
public final class a {
    final long aGT;
    final long aGU;
    final long aGV;
    final long contentLength;

    a(long j2, long j3, long j4, long j5) {
        this.aGT = j2;
        this.aGU = j3;
        this.aGV = j4;
        this.contentLength = j5;
    }

    public final String toString() {
        return com.kwai.filedownloader.e.f.j("range[%d, %d) current offset[%d]", Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU));
    }
}
