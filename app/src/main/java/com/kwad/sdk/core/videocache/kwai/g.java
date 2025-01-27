package com.kwad.sdk.core.videocache.kwai;

/* loaded from: classes2.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j2;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    protected final boolean W(long j2) {
        return j2 <= this.maxSize;
    }
}
