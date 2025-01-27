package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: classes3.dex */
public final class d {
    public final byte[] aQt;
    private CRC32 aQw;
    public final String akr;
    public final int len;
    public byte[] data = null;
    private long aQu = 0;
    public byte[] aQv = new byte[4];

    public d(int i10, String str, boolean z10) {
        this.len = i10;
        this.akr = str;
        this.aQt = b.gv(str);
        for (int i11 = 0; i11 < 4; i11++) {
            byte b10 = this.aQt[i11];
            if (b10 < 65 || b10 > 122 || (b10 > 90 && b10 < 97)) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z10) {
            LW();
        }
    }

    private void LW() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream LX() {
        return new ByteArrayInputStream(this.data);
    }

    public final long LY() {
        return this.aQu;
    }

    public final void aM(long j10) {
        this.aQu = j10;
    }

    public final void bL(boolean z10) {
        int value = (int) this.aQw.getValue();
        int g10 = com.kwad.sdk.pngencrypt.n.g(this.aQv, 0);
        if (value != g10) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.akr, Long.valueOf(this.aQu), Integer.valueOf(g10), Integer.valueOf(value));
            if (z10) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.c.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.akr;
        if (str == null) {
            if (dVar.akr != null) {
                return false;
            }
        } else if (!str.equals(dVar.akr)) {
            return false;
        }
        return this.aQu == dVar.aQu;
    }

    public final void f(byte[] bArr, int i10, int i11) {
        if (this.aQw == null) {
            this.aQw = new CRC32();
        }
        this.aQw.update(bArr, i10, i11);
    }

    public final int hashCode() {
        String str = this.akr;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.aQu;
        return ((hashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.aQt) + " len=" + this.len;
    }
}
