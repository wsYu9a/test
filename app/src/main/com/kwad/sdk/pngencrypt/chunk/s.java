package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes3.dex */
public final class s extends p {
    private int aRc;
    private int aRd;
    private int aRe;
    private int aRf;
    private int[] aRg;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aRg = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aPC;
        if (kVar.aPJ) {
            this.aRc = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.aPK) {
            this.aRd = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aRe = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.aRf = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.aRg = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.aRg[i10] = dVar.data[i10] & 255;
            }
        }
    }
}
