package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes3.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aPC;
    public final boolean aQC;
    public final boolean aQD;
    public final boolean aQE;
    protected d aQF;
    private boolean aQG = false;
    protected int aQH = -1;
    public final String akr;

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i10, boolean z10) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i10 < 4 : this == BEFORE_PLTE_AND_IDAT ? i10 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z10 ? i10 < 4 : i10 < 4 && i10 > 2 : this == AFTER_IDAT && i10 > 4;
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
        this.akr = str;
        this.aPC = kVar;
        this.aQC = b.gw(str);
        this.aQD = b.gx(str);
        this.aQE = b.gy(str);
    }

    private long LY() {
        d dVar = this.aQF;
        if (dVar != null) {
            return dVar.LY();
        }
        return -1L;
    }

    private int Ma() {
        d dVar = this.aQF;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.aQF = dVar;
    }

    public final void dS(int i10) {
        this.aQH = i10;
    }

    public String toString() {
        return "chunk id= " + this.akr + " (len=" + Ma() + " offset=" + LY() + ")";
    }
}
