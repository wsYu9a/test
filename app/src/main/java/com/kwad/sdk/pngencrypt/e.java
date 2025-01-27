package com.kwad.sdk.pngencrypt;

/* loaded from: classes2.dex */
public final class e {
    private int avA;
    int avB;
    int avC;
    int avD;
    int avE;
    int avF;
    int avG;
    private boolean avL;
    final k avx;
    private int avz;
    private int avy = 0;
    private int avH = -1;
    private int avI = -1;
    private int avJ = 0;
    int avK = 0;

    public e(k kVar) {
        this.avL = false;
        this.avx = kVar;
        this.avL = false;
        bM(1);
        bL(0);
    }

    private int BH() {
        return BG();
    }

    private void bL(int i2) {
        this.avH = i2;
        int i3 = (i2 * this.avB) + this.avD;
        this.avI = i3;
        if (i3 < 0 || i3 >= this.avx.avz) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void bM(int i2) {
        if (this.avy == i2) {
            return;
        }
        this.avy = i2;
        byte[] bN = bN(i2);
        byte b2 = bN[0];
        this.avC = b2;
        byte b3 = bN[1];
        this.avB = b3;
        byte b4 = bN[2];
        this.avE = b4;
        byte b5 = bN[3];
        this.avD = b5;
        k kVar = this.avx;
        int i3 = kVar.avz;
        this.avz = i3 > b5 ? (((i3 + b3) - 1) - b5) / b3 : 0;
        int i4 = kVar.avA;
        int i5 = i4 > b4 ? (((i4 + b2) - 1) - b4) / b2 : 0;
        this.avA = i5;
        if (i5 == 0) {
            this.avz = 0;
        }
        int i6 = kVar.avT;
        this.avG = b2 * i6;
        this.avF = b4 * i6;
    }

    private static byte[] bN(int i2) {
        switch (i2) {
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
                throw new PngjException("bad interlace pass" + i2);
        }
    }

    final boolean BB() {
        int i2;
        while (true) {
            this.avJ++;
            int i3 = this.avz;
            if (i3 != 0 && (i2 = this.avH) < i3 - 1) {
                bL(i2 + 1);
                break;
            }
            int i4 = this.avy;
            if (i4 != 7) {
                bM(i4 + 1);
                if (this.avz != 0) {
                    bL(0);
                    break;
                }
                this.avJ--;
            } else {
                this.avL = true;
                return false;
            }
        }
        return true;
    }

    final int BC() {
        return this.avH;
    }

    final int BD() {
        return this.avI;
    }

    final int BE() {
        return this.avy;
    }

    final int BF() {
        return this.avz;
    }

    final int BG() {
        return this.avA;
    }

    public final int BI() {
        return ((this.avx.avY * BH()) + 7) / 8;
    }
}
