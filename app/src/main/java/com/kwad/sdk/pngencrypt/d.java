package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: classes2.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet avg;
    protected boolean avh;
    protected boolean avi;
    protected byte[] avj;
    protected int avk;

    public d(int i2, String str, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.avh = false;
        this.avi = false;
        this.avk = -1;
        this.avg = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void Bk() {
        int g2;
        if (!this.avi || this.avk < 0 || (g2 = n.g(this.avj, 0)) == this.avk) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g2 + " expected " + this.avk));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.avi && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.avj[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.avg.c(bArr, i3, i4);
            if (this.avh) {
                System.arraycopy(bArr, i3, Bj().data, this.auz, i4);
            }
        }
    }

    public final void bJ(int i2) {
        this.avk = i2;
    }
}
