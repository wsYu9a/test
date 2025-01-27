package com.kwad.sdk.pngencrypt;

/* loaded from: classes2.dex */
public abstract class ChunkReader implements f {
    private boolean auB;
    public final ChunkReaderMode aux;
    private final com.kwad.sdk.pngencrypt.chunk.d auy;
    protected int auz = 0;
    private int auA = 0;
    protected ErrorBehaviour auC = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i2, String str, long j2, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aux = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.auy = dVar;
        dVar.ae(j2);
        this.auB = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d Bj() {
        return this.auy;
    }

    protected abstract void Bk();

    protected abstract void a(int i2, byte[] bArr, int i3, int i4);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("negative length??"));
        }
        if (this.auz == 0 && this.auA == 0 && this.auB) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.auy;
            dVar.f(dVar.awF, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.auy;
        int i5 = dVar2.len - this.auz;
        if (i5 > i3) {
            i5 = i3;
        }
        if (i5 > 0 || this.auA == 0) {
            if (this.auB && this.aux != ChunkReaderMode.BUFFER && i5 > 0) {
                dVar2.f(bArr, i2, i5);
            }
            ChunkReaderMode chunkReaderMode = this.aux;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.auy.data;
                if (bArr2 != bArr && i5 > 0) {
                    System.arraycopy(bArr, i2, bArr2, this.auz, i5);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.auz, bArr, i2, i5);
            }
            this.auz += i5;
            i2 += i5;
            i3 -= i5;
        }
        int i6 = this.auz;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.auy;
        if (i6 == dVar3.len) {
            int i7 = this.auA;
            int i8 = 4 - i7;
            if (i8 <= i3) {
                i3 = i8;
            }
            if (i3 > 0) {
                byte[] bArr3 = dVar3.awI;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i2, bArr3, i7, i3);
                }
                int i9 = this.auA + i3;
                this.auA = i9;
                if (i9 == 4) {
                    if (this.auB) {
                        if (this.aux == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.auy;
                            dVar4.f(dVar4.data, 0, dVar4.len);
                        }
                        this.auy.bo(this.auC == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "Chunk done");
                    Bk();
                }
            }
            i4 = i3;
        }
        if (i5 > 0 || i4 > 0) {
            return i5 + i4;
        }
        return -1;
    }

    public final void bm(boolean z) {
        this.auB = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.auy;
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).auy;
        if (dVar == null) {
            if (dVar2 != null) {
                return false;
            }
        } else if (!dVar.equals(dVar2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.auy;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.auA == 4;
    }

    public String toString() {
        return this.auy.toString();
    }
}
