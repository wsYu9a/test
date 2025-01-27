package com.kwad.sdk.pngencrypt;

/* loaded from: classes3.dex */
public final class k {
    public final int aPG;
    public final int aPH;
    public final boolean aPI;
    public final boolean aPJ;
    public final boolean aPK;
    public final boolean aPL;
    public final int aPM;
    public final int aPN;
    public final int aPO;
    public final int aPP;
    public final int aPQ;
    private long aPR = -1;
    private long aPS = -1;
    public final int aPn;
    public final int aPo;

    public k(int i10, int i11, int i12, boolean z10, boolean z11, boolean z12) {
        this.aPo = i10;
        this.aPn = i11;
        this.aPI = z10;
        this.aPK = z12;
        this.aPJ = z11;
        if (z11 && z12) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i13 = (z11 || z12) ? z10 ? 2 : 1 : z10 ? 4 : 3;
        this.aPH = i13;
        this.aPG = i12;
        boolean z13 = i12 < 8;
        this.aPL = z13;
        int i14 = i13 * i12;
        this.aPM = i14;
        this.aPN = (i14 + 7) / 8;
        int i15 = ((i14 * i10) + 7) / 8;
        this.aPO = i15;
        int i16 = i13 * i10;
        this.aPP = i16;
        this.aPQ = z13 ? i15 : i16;
        if (i12 == 1 || i12 == 2 || i12 == 4) {
            if (!z12 && !z11) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i12);
            }
        } else if (i12 != 8) {
            if (i12 != 16) {
                throw new PngjException("invalid bitdepth=" + i12);
            }
            if (z12) {
                throw new PngjException("indexed can't have bitdepth=" + i12);
            }
        }
        if (i10 <= 0 || i10 > 16777216) {
            throw new PngjException("invalid cols=" + i10 + " ???");
        }
        if (i11 > 0 && i11 <= 16777216) {
            if (i16 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i11 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.aPI == kVar.aPI && this.aPG == kVar.aPG && this.aPo == kVar.aPo && this.aPJ == kVar.aPJ && this.aPK == kVar.aPK && this.aPn == kVar.aPn;
    }

    public final int hashCode() {
        return (((((((((((this.aPI ? 1231 : 1237) + 31) * 31) + this.aPG) * 31) + this.aPo) * 31) + (this.aPJ ? 1231 : 1237)) * 31) + (this.aPK ? 1231 : 1237)) * 31) + this.aPn;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aPo + ", rows=" + this.aPn + ", bitDepth=" + this.aPG + ", channels=" + this.aPH + ", alpha=" + this.aPI + ", greyscale=" + this.aPJ + ", indexed=" + this.aPK + "]";
    }
}
