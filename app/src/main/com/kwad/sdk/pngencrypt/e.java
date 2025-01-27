package com.kwad.sdk.pngencrypt;

/* loaded from: classes3.dex */
public final class e {
    final k aPl;
    private int aPn;
    private int aPo;
    int aPp;
    int aPq;
    int aPr;
    int aPs;
    int aPt;
    int aPu;
    private int aPm = 0;
    private int aPv = -1;
    private int aPw = -1;
    private int aPx = 0;
    private boolean aPz = false;
    int aPy = 0;

    public e(k kVar) {
        this.aPl = kVar;
        dK(1);
        dJ(0);
    }

    private int LJ() {
        return LI();
    }

    private void dJ(int i10) {
        this.aPv = i10;
        int i11 = (i10 * this.aPp) + this.aPr;
        this.aPw = i11;
        if (i11 < 0 || i11 >= this.aPl.aPn) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void dK(int i10) {
        if (this.aPm == i10) {
            return;
        }
        this.aPm = i10;
        byte[] dL = dL(i10);
        byte b10 = dL[0];
        this.aPq = b10;
        byte b11 = dL[1];
        this.aPp = b11;
        byte b12 = dL[2];
        this.aPs = b12;
        byte b13 = dL[3];
        this.aPr = b13;
        k kVar = this.aPl;
        int i11 = kVar.aPn;
        this.aPn = i11 > b13 ? (((i11 + b11) - 1) - b13) / b11 : 0;
        int i12 = kVar.aPo;
        int i13 = i12 > b12 ? (((i12 + b10) - 1) - b12) / b10 : 0;
        this.aPo = i13;
        if (i13 == 0) {
            this.aPn = 0;
        }
        int i14 = kVar.aPH;
        this.aPu = b10 * i14;
        this.aPt = b12 * i14;
    }

    private static byte[] dL(int i10) {
        switch (i10) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i10);
        }
    }

    public final boolean LD() {
        int i10;
        while (true) {
            this.aPx++;
            int i11 = this.aPn;
            if (i11 != 0 && (i10 = this.aPv) < i11 - 1) {
                dJ(i10 + 1);
                break;
            }
            int i12 = this.aPm;
            if (i12 != 7) {
                dK(i12 + 1);
                if (this.aPn != 0) {
                    dJ(0);
                    break;
                }
                this.aPx--;
            } else {
                this.aPz = true;
                return false;
            }
        }
        return true;
    }

    public final int LE() {
        return this.aPv;
    }

    public final int LF() {
        return this.aPw;
    }

    public final int LG() {
        return this.aPm;
    }

    public final int LH() {
        return this.aPn;
    }

    public final int LI() {
        return this.aPo;
    }

    public final int LK() {
        return ((this.aPl.aPM * LJ()) + 7) / 8;
    }
}
