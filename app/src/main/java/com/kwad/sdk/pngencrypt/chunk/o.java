package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class o extends p {
    private byte axl;

    public o(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 1) {
            this.axl = dVar.data[0];
        } else {
            throw new PngjException("bad chunk length " + dVar);
        }
    }
}
