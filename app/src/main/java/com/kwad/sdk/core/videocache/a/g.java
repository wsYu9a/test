package com.kwad.sdk.core.videocache.a;

/* loaded from: classes3.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j10;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean aD(long j10) {
        return j10 <= this.maxSize;
    }
}
