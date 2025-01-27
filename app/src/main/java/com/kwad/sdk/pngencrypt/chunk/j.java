package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class j extends t {
    private boolean axa;
    private String axb;
    private String axc;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.axa = false;
        this.axb = "";
        this.axc = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i2 >= bArr.length) {
                break;
            }
            if (bArr[i2] == 0) {
                iArr[i3] = i2;
                i3++;
                if (i3 == 1) {
                    i2 += 2;
                }
                if (i3 == 3) {
                    break;
                }
            }
            i2++;
        }
        if (i3 != 3) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i4 = iArr[0] + 1;
        byte[] bArr2 = dVar.data;
        boolean z = bArr2[i4] != 0;
        this.axa = z;
        int i5 = i4 + 1;
        if (z && bArr2[i5] != 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.axb = b.d(dVar.data, i5, iArr[1] - i5);
        this.axc = b.e(dVar.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i6 = iArr[2] + 1;
        boolean z2 = this.axa;
        byte[] bArr3 = dVar.data;
        this.axu = z2 ? b.j(b.b(bArr3, i6, bArr3.length - i6, false)) : b.e(bArr3, i6, bArr3.length - i6);
    }
}
