package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes2.dex */
public final class n extends k {
    private String axi;
    private int axj;
    private int[] axk;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Cg() {
        return this.axi;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            bArr = dVar.data;
            if (i8 >= bArr.length) {
                i8 = -1;
                break;
            } else if (bArr[i8] == 0) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 <= 0 || i8 > bArr.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.axi = b.d(bArr, 0, i8);
        int e2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i8 + 1);
        this.axj = e2;
        int i9 = i8 + 2;
        int length = (dVar.data.length - i9) / (e2 == 8 ? 6 : 10);
        this.axk = new int[length * 5];
        int i10 = i9;
        int i11 = 0;
        while (i7 < length) {
            if (this.axj == 8) {
                int i12 = i10 + 1;
                i3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i10);
                int i13 = i12 + 1;
                i4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i12);
                int i14 = i13 + 1;
                i5 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13);
                i2 = i14 + 1;
                i6 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i14);
            } else {
                int f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
                int i15 = i10 + 2;
                int f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i15);
                int i16 = i15 + 2;
                int f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i16);
                int i17 = i16 + 2;
                int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i17);
                i2 = i17 + 2;
                i3 = f2;
                i4 = f3;
                i5 = f4;
                i6 = f5;
            }
            int f6 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i2);
            int[] iArr = this.axk;
            int i18 = i11 + 1;
            iArr[i11] = i3;
            int i19 = i18 + 1;
            iArr[i18] = i4;
            int i20 = i19 + 1;
            iArr[i19] = i5;
            int i21 = i20 + 1;
            iArr[i20] = i6;
            iArr[i21] = f6;
            i7++;
            i11 = i21 + 1;
            i10 = i2 + 2;
        }
    }
}
