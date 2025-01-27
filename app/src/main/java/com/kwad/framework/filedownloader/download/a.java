package com.kwad.framework.filedownloader.download;

/* loaded from: classes3.dex */
public final class a {
    final long aiX;
    final long aiY;
    final long aiZ;
    final long contentLength;

    public a(long j10, long j11, long j12, long j13) {
        this.aiX = j10;
        this.aiY = j11;
        this.aiZ = j12;
        this.contentLength = j13;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("range[%d, %d) current offset[%d]", Long.valueOf(this.aiX), Long.valueOf(this.aiZ), Long.valueOf(this.aiY));
    }
}
