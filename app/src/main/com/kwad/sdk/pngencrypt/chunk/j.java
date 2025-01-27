package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes3.dex */
public final class j extends t {
    private boolean aQN;
    private String aQO;
    private String aQP;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.aQN = false;
        this.aQO = "";
        this.aQP = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i10 >= bArr.length) {
                break;
            }
            if (bArr[i10] == 0) {
                iArr[i11] = i10;
                i11++;
                if (i11 == 1) {
                    i10 += 2;
                }
                if (i11 == 3) {
                    break;
                }
            }
            i10++;
        }
        if (i11 != 3) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i12 = iArr[0];
        byte[] bArr2 = dVar.data;
        boolean z10 = bArr2[i12 + 1] != 0;
        this.aQN = z10;
        int i13 = i12 + 2;
        if (z10 && bArr2[i13] != 0) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aQO = b.d(dVar.data, i13, iArr[1] - i13);
        byte[] bArr3 = dVar.data;
        int i14 = iArr[1];
        this.aQP = b.e(bArr3, i14 + 1, (iArr[2] - i14) - 1);
        int i15 = iArr[2] + 1;
        if (this.aQN) {
            byte[] bArr4 = dVar.data;
            this.aRh = b.j(b.b(bArr4, i15, bArr4.length - i15, false));
        } else {
            byte[] bArr5 = dVar.data;
            this.aRh = b.e(bArr5, i15, bArr5.length - i15);
        }
    }
}
