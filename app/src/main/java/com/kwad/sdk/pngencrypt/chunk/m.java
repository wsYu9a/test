package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class m extends p {
    private int axg;
    private int[] axh;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.axg = 0;
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.axh[i2] = (i3 << 16) | (i4 << 8) | i5;
    }

    private void cc(int i2) {
        this.axg = i2;
        if (i2 <= 0 || i2 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.axg);
        }
        int[] iArr = this.axh;
        if (iArr == null || iArr.length != i2) {
            this.axh = new int[i2];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        cc(dVar.len / 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.axg) {
            byte[] bArr = dVar.data;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i2, bArr[i3] & 255, bArr[i4] & 255, bArr[i5] & 255);
            i2++;
            i3 = i5 + 1;
        }
    }
}
