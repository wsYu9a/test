package com.kwad.sdk.pngencrypt;

/* loaded from: classes3.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aOl;
    private final com.kwad.sdk.pngencrypt.chunk.d aOm;
    private boolean aOp;
    protected int aOn = 0;
    private int aOo = 0;
    protected ErrorBehaviour aOq = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i10, String str, long j10, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i10 < 0) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aOl = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i10, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aOm = dVar;
        dVar.aM(j10);
        this.aOp = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d Ll() {
        return this.aOm;
    }

    public abstract void Lm();

    public abstract void a(int i10, byte[] bArr, int i11, int i12);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (i11 < 0) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aOn == 0 && this.aOo == 0 && this.aOp) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aOm;
            dVar.f(dVar.aQt, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aOm;
        int i13 = dVar2.len - this.aOn;
        if (i13 > i11) {
            i13 = i11;
        }
        if (i13 > 0 || this.aOo == 0) {
            if (this.aOp && this.aOl != ChunkReaderMode.BUFFER && i13 > 0) {
                dVar2.f(bArr, i10, i13);
            }
            ChunkReaderMode chunkReaderMode = this.aOl;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aOm.data;
                if (bArr2 != bArr && i13 > 0) {
                    System.arraycopy(bArr, i10, bArr2, this.aOn, i13);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aOn, bArr, i10, i13);
            }
            this.aOn += i13;
            i10 += i13;
            i11 -= i13;
        }
        int i14 = this.aOn;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aOm;
        if (i14 == dVar3.len) {
            int i15 = this.aOo;
            int i16 = 4 - i15;
            if (i16 <= i11) {
                i11 = i16;
            }
            if (i11 > 0) {
                byte[] bArr3 = dVar3.aQv;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i10, bArr3, i15, i11);
                }
                int i17 = this.aOo + i11;
                this.aOo = i17;
                if (i17 == 4) {
                    if (this.aOp) {
                        if (this.aOl == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aOm;
                            dVar4.f(dVar4.data, 0, dVar4.len);
                        }
                        this.aOm.bL(this.aOq == ErrorBehaviour.STRICT);
                    }
                    Lm();
                }
            }
            i12 = i11;
        }
        if (i13 > 0 || i12 > 0) {
            return i13 + i12;
        }
        return -1;
    }

    public final void bJ(boolean z10) {
        this.aOp = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aOm;
        if (dVar == null) {
            if (chunkReader.aOm != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aOm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aOm;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aOo == 4;
    }

    public String toString() {
        return this.aOm.toString();
    }
}
