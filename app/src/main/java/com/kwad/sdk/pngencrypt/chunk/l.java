package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class l extends p {
    private long axd;
    private long axe;
    private int axf;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.axd = g2;
        if (g2 < 0) {
            this.axd = g2 + 4294967296L;
        }
        long g3 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.axe = g3;
        if (g3 < 0) {
            this.axe = g3 + 4294967296L;
        }
        this.axf = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
