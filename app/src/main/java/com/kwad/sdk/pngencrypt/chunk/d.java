package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: classes2.dex */
public final class d {
    public final byte[] awF;
    public final String awG;
    private CRC32 awJ;
    public final int len;
    public byte[] data = null;
    private long awH = 0;
    public byte[] awI = new byte[4];

    public d(int i2, String str, boolean z) {
        this.len = i2;
        this.awG = str;
        this.awF = b.el(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.awF;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            BU();
        }
    }

    private void BU() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    final ByteArrayInputStream BV() {
        return new ByteArrayInputStream(this.data);
    }

    public final long BW() {
        return this.awH;
    }

    public final void ae(long j2) {
        this.awH = j2;
    }

    public final void bo(boolean z) {
        int value = (int) this.awJ.getValue();
        int g2 = com.kwad.sdk.pngencrypt.n.g(this.awI, 0);
        if (value != g2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.awG, Long.valueOf(this.awH), Integer.valueOf(g2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", format);
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
        String str = this.awG;
        if (str == null) {
            if (dVar.awG != null) {
                return false;
            }
        } else if (!str.equals(dVar.awG)) {
            return false;
        }
        return this.awH == dVar.awH;
    }

    public final void f(byte[] bArr, int i2, int i3) {
        if (this.awJ == null) {
            this.awJ = new CRC32();
        }
        this.awJ.update(bArr, i2, i3);
    }

    public final int hashCode() {
        String str = this.awG;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.awH;
        return ((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.awF) + " len=" + this.len;
    }
}
