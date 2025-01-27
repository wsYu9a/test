package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* loaded from: classes2.dex */
public final class f extends e {
    private final List<PngChunk> awO;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + BX().size() + " queue: " + this.awO.size();
    }
}
