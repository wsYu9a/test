package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: classes2.dex */
public final class i extends p {
    private int avA;
    private int avz;
    private int awV;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Cd();
        }
    }

    private int BF() {
        return this.avz;
    }

    private int BG() {
        return this.avA;
    }

    private int BZ() {
        return this.awV;
    }

    private int Ca() {
        return this.awW;
    }

    private int Cb() {
        return this.awZ;
    }

    private void Cd() {
        bV(this.avO.avA);
        bW(this.avO.avz);
        bX(this.avO.avS);
        com.kwad.sdk.pngencrypt.k kVar = this.avO;
        int i2 = kVar.avU ? 4 : 0;
        if (kVar.avW) {
            i2++;
        }
        if (!kVar.avV) {
            i2 += 2;
        }
        bY(i2);
        bZ(0);
        ca(0);
        cb(0);
    }

    private void Cf() {
        if (this.avA <= 0 || this.avz <= 0 || this.awX != 0 || this.awY != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i2 = this.awV;
        if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 8 && i2 != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i3 = this.awZ;
        if (i3 < 0 || i3 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i4 = this.awW;
        if (i4 != 0) {
            if (i4 != 6 && i4 != 2) {
                if (i4 == 3) {
                    if (i2 == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i4 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i2 != 8 && i2 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private void bV(int i2) {
        this.avA = i2;
    }

    private void bW(int i2) {
        this.avz = i2;
    }

    private void bX(int i2) {
        this.awV = i2;
    }

    private void bY(int i2) {
        this.awW = i2;
    }

    private void bZ(int i2) {
        this.awX = 0;
    }

    private void ca(int i2) {
        this.awY = 0;
    }

    private void cb(int i2) {
        this.awZ = 0;
    }

    public final boolean Cc() {
        return Cb() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Ce() {
        Cf();
        return new com.kwad.sdk.pngencrypt.k(BG(), BF(), BZ(), (Ca() & 4) != 0, Ca() == 0 || Ca() == 4, (Ca() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream BV = dVar.BV();
        this.avA = com.kwad.sdk.pngencrypt.n.f(BV);
        this.avz = com.kwad.sdk.pngencrypt.n.f(BV);
        this.awV = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awW = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awX = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awY = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awZ = com.kwad.sdk.pngencrypt.n.e(BV);
    }
}
