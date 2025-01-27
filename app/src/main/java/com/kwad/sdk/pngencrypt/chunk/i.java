package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: classes3.dex */
public final class i extends p {
    private int aPn;
    private int aPo;
    private int aQI;
    private int aQJ;
    private int aQK;
    private int aQL;
    private int aQM;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Mf();
        }
    }

    private int LH() {
        return this.aPn;
    }

    private int LI() {
        return this.aPo;
    }

    private int Mb() {
        return this.aQI;
    }

    private int Mc() {
        return this.aQJ;
    }

    private int Md() {
        return this.aQM;
    }

    private void Mf() {
        dT(this.aPC.aPo);
        dU(this.aPC.aPn);
        dV(this.aPC.aPG);
        com.kwad.sdk.pngencrypt.k kVar = this.aPC;
        int i10 = kVar.aPI ? 4 : 0;
        if (kVar.aPK) {
            i10++;
        }
        if (!kVar.aPJ) {
            i10 += 2;
        }
        dW(i10);
        dX(0);
        dY(0);
        dZ(0);
    }

    private void Mh() {
        if (this.aPo <= 0 || this.aPn <= 0 || this.aQK != 0 || this.aQL != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i10 = this.aQI;
        if (i10 != 1 && i10 != 2 && i10 != 4 && i10 != 8 && i10 != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i11 = this.aQM;
        if (i11 < 0 || i11 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i12 = this.aQJ;
        if (i12 != 0) {
            if (i12 != 6 && i12 != 2) {
                if (i12 == 3) {
                    if (i10 == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i12 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i10 != 8 && i10 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private void dT(int i10) {
        this.aPo = i10;
    }

    private void dU(int i10) {
        this.aPn = i10;
    }

    private void dV(int i10) {
        this.aQI = i10;
    }

    private void dW(int i10) {
        this.aQJ = i10;
    }

    private void dX(int i10) {
        this.aQK = 0;
    }

    private void dY(int i10) {
        this.aQL = 0;
    }

    private void dZ(int i10) {
        this.aQM = 0;
    }

    public final boolean Me() {
        return Md() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Mg() {
        Mh();
        return new com.kwad.sdk.pngencrypt.k(LI(), LH(), Mb(), (Mc() & 4) != 0, Mc() == 0 || Mc() == 4, (Mc() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream LX = dVar.LX();
        this.aPo = com.kwad.sdk.pngencrypt.n.f(LX);
        this.aPn = com.kwad.sdk.pngencrypt.n.f(LX);
        this.aQI = com.kwad.sdk.pngencrypt.n.e(LX);
        this.aQJ = com.kwad.sdk.pngencrypt.n.e(LX);
        this.aQK = com.kwad.sdk.pngencrypt.n.e(LX);
        this.aQL = com.kwad.sdk.pngencrypt.n.e(LX);
        this.aQM = com.kwad.sdk.pngencrypt.n.e(LX);
    }
}
