package com.kwad.sdk.pngencrypt;

/* loaded from: classes2.dex */
public final class k {
    public final int avA;
    public final int avS;
    public final int avT;
    public final boolean avU;
    public final boolean avV;
    public final boolean avW;
    public final boolean avX;
    public final int avY;
    public final int avZ;
    public final int avz;
    public final int awa;
    public final int awb;
    public final int awc;
    private long awd = -1;
    private long awe = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.avA = i2;
        this.avz = i3;
        this.avU = z;
        this.avW = z3;
        this.avV = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i5 = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.avT = i5;
        this.avS = i4;
        boolean z4 = i4 < 8;
        this.avX = z4;
        int i6 = i5 * i4;
        this.avY = i6;
        this.avZ = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.awa = i7;
        int i8 = i5 * i2;
        this.awb = i8;
        this.awc = z4 ? i7 : i8;
        if (i4 == 1 || i4 == 2 || i4 == 4) {
            if (!z3 && !z2) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i4);
            }
        } else if (i4 != 8) {
            if (i4 != 16) {
                throw new PngjException("invalid bitdepth=" + i4);
            }
            if (z3) {
                throw new PngjException("indexed can't have bitdepth=" + i4);
            }
        }
        if (i2 <= 0 || i2 > 16777216) {
            throw new PngjException("invalid cols=" + i2 + " ???");
        }
        if (i3 > 0 && i3 <= 16777216) {
            if (i8 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i3 + " ???");
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
        return this.avU == kVar.avU && this.avS == kVar.avS && this.avA == kVar.avA && this.avV == kVar.avV && this.avW == kVar.avW && this.avz == kVar.avz;
    }

    public final int hashCode() {
        return (((((((((((this.avU ? 1231 : 1237) + 31) * 31) + this.avS) * 31) + this.avA) * 31) + (this.avV ? 1231 : 1237)) * 31) + (this.avW ? 1231 : 1237)) * 31) + this.avz;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.avA + ", rows=" + this.avz + ", bitDepth=" + this.avS + ", channels=" + this.avT + ", alpha=" + this.avU + ", greyscale=" + this.avV + ", indexed=" + this.avW + "]";
    }
}
