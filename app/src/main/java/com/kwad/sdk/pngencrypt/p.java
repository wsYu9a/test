package com.kwad.sdk.pngencrypt;

/* loaded from: classes2.dex */
final class p {
    public final e auS;
    int avB;
    int avC;
    int avD;
    int avE;
    public final k avO;
    int avy;
    public final boolean awq;
    int awr;
    int aws;
    int awt;
    int awu;
    int awv;
    int aww;
    int awx;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.avO = kVar;
        this.auS = eVar;
        this.awq = eVar != null;
    }

    final void h(byte[] bArr, int i2) {
        this.buf = bArr;
        this.awx = i2;
    }

    final void update(int i2) {
        this.awr = i2;
        if (!this.awq) {
            this.avy = 1;
            this.avB = 1;
            this.avC = 1;
            this.avD = 0;
            this.avE = 0;
            this.awt = i2;
            this.aws = i2;
            k kVar = this.avO;
            this.awu = kVar.avz;
            this.awv = kVar.avA;
            this.aww = kVar.awa;
            return;
        }
        this.avy = this.auS.BE();
        e eVar = this.auS;
        this.avC = eVar.avC;
        this.avB = eVar.avB;
        this.avE = eVar.avE;
        this.avD = eVar.avD;
        this.aws = eVar.BD();
        this.awt = this.auS.BC();
        this.awu = this.auS.BF();
        int BG = this.auS.BG();
        this.awv = BG;
        this.aww = ((this.avO.avY * BG) + 7) / 8;
    }
}
