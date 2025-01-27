package com.kwad.sdk.core.videocache;

/* loaded from: classes3.dex */
public interface a {
    long Id();

    int a(byte[] bArr, long j10, int i10);

    void close();

    void complete();

    void d(byte[] bArr, int i10);

    boolean isCompleted();
}
