package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes2.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            bArr = dVar.data;
            if (i2 >= bArr.length || bArr[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        this.key = b.d(bArr, 0, i2);
        int i3 = i2 + 1;
        byte[] bArr2 = dVar.data;
        this.axu = i3 < bArr2.length ? b.d(bArr2, i3, bArr2.length - i3) : "";
    }
}
