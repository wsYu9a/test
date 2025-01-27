package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: classes3.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aOU;
    protected boolean aOV;
    protected boolean aOW;
    protected byte[] aOX;
    protected int aOY;

    public d(int i10, String str, long j10, DeflatedChunksSet deflatedChunksSet) {
        super(i10, str, j10, ChunkReader.ChunkReaderMode.PROCESS);
        this.aOV = false;
        this.aOW = false;
        this.aOY = -1;
        this.aOU = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void Lm() {
        int g10;
        if (!this.aOW || this.aOY < 0 || (g10 = n.g(this.aOX, 0)) == this.aOY) {
            return;
        }
        com.kwad.sdk.core.d.c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g10 + " expected " + this.aOY));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i10, byte[] bArr, int i11, int i12) {
        if (this.aOW && i10 < 4) {
            while (i10 < 4 && i12 > 0) {
                this.aOX[i10] = bArr[i11];
                i10++;
                i11++;
                i12--;
            }
        }
        if (i12 > 0) {
            this.aOU.c(bArr, i11, i12);
            if (this.aOV) {
                System.arraycopy(bArr, i11, Ll().data, this.aOn, i12);
            }
        }
    }

    public final void dH(int i10) {
        this.aOY = i10;
    }
}
