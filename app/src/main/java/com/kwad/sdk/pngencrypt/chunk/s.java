package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes2.dex */
public final class s extends p {
    private int axp;
    private int axq;
    private int axr;
    private int axs;
    private int[] axt;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.axt = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.avO;
        if (kVar.avV) {
            this.axp = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.avW) {
            this.axq = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.axr = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.axs = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.axt = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.axt[i2] = dVar.data[i2] & 255;
            }
        }
    }
}
