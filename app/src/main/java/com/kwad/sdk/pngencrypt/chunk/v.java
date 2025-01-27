package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            bArr = dVar.data;
            if (i2 >= bArr.length) {
                i2 = -1;
                break;
            } else if (bArr[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 > bArr.length - 2) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = b.d(dVar.data, 0, i2);
        if (dVar.data[i2 + 1] != 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        this.axu = b.i(b.b(dVar.data, i2 + 2, (r5.length - i2) - 2, false));
    }
}
