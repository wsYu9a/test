package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes3.dex */
public final class n extends k {
    private String aQV;
    private int aQW;
    private int[] aQX;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Mi() {
        return this.aQV;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int f10;
        int f11;
        int f12;
        int f13;
        int i10;
        int i11 = 0;
        while (true) {
            bArr = dVar.data;
            if (i11 >= bArr.length) {
                i11 = -1;
                break;
            } else if (bArr[i11] == 0) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 <= 0 || i11 > bArr.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.aQV = b.d(bArr, 0, i11);
        int e10 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i11 + 1);
        this.aQW = e10;
        int i12 = i11 + 2;
        int length = (dVar.data.length - i12) / (e10 == 8 ? 6 : 10);
        this.aQX = new int[length * 5];
        int i13 = i12;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            if (this.aQW == 8) {
                f10 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13);
                f11 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13 + 1);
                int i16 = i13 + 3;
                f12 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13 + 2);
                i10 = i13 + 4;
                f13 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i16);
            } else {
                f10 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i13);
                f11 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i13 + 2);
                f12 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i13 + 4);
                f13 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i13 + 6);
                i10 = i13 + 8;
            }
            int f14 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
            i13 = i10 + 2;
            int[] iArr = this.aQX;
            iArr[i14] = f10;
            iArr[i14 + 1] = f11;
            iArr[i14 + 2] = f12;
            int i17 = i14 + 4;
            iArr[i14 + 3] = f13;
            i14 += 5;
            iArr[i17] = f14;
        }
    }
}
