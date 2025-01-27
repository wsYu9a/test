package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes2.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k avO;
    public final String awG;
    public final boolean awP;
    public final boolean awQ;
    public final boolean awR;
    protected d awS;
    private boolean awT = false;
    protected int awU = -1;

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i2, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i2 < 4 : this == BEFORE_PLTE_AND_IDAT ? i2 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i2 < 4 : i2 < 4 && i2 > 2 : this == AFTER_IDAT && i2 > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.awG = str;
        this.avO = kVar;
        this.awP = b.em(str);
        this.awQ = b.en(str);
        this.awR = b.eo(str);
    }

    private long BW() {
        d dVar = this.awS;
        if (dVar != null) {
            return dVar.BW();
        }
        return -1L;
    }

    private int BY() {
        d dVar = this.awS;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    protected abstract void a(d dVar);

    final void b(d dVar) {
        this.awS = dVar;
    }

    final void bU(int i2) {
        this.awU = i2;
    }

    public String toString() {
        return "chunk id= " + this.awG + " (len=" + BY() + " offset=" + BW() + ")";
    }
}
