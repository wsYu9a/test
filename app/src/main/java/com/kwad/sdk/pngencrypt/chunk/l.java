package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes3.dex */
public final class l extends p {
    private long aQQ;
    private long aQR;
    private int aQS;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g10 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.aQQ = g10;
        if (g10 < 0) {
            this.aQQ = g10 + 4294967296L;
        }
        long g11 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.aQR = g11;
        if (g11 < 0) {
            this.aQR = g11 + 4294967296L;
        }
        this.aQS = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
