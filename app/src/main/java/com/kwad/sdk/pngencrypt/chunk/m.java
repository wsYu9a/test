package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes3.dex */
public final class m extends p {
    private int aQT;
    private int[] aQU;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aQT = 0;
    }

    private void ea(int i10) {
        this.aQT = i10;
        if (i10 <= 0 || i10 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.aQT);
        }
        int[] iArr = this.aQU;
        if (iArr == null || iArr.length != i10) {
            this.aQU = new int[i10];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        ea(dVar.len / 3);
        int i10 = 0;
        for (int i11 = 0; i11 < this.aQT; i11++) {
            byte[] bArr = dVar.data;
            int i12 = bArr[i10] & 255;
            int i13 = i10 + 2;
            int i14 = bArr[i10 + 1] & 255;
            i10 += 3;
            a(i11, i12, i14, bArr[i13] & 255);
        }
    }

    private void a(int i10, int i11, int i12, int i13) {
        this.aQU[i10] = (i11 << 16) | (i12 << 8) | i13;
    }
}
