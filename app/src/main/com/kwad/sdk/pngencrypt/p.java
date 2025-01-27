package com.kwad.sdk.pngencrypt;

/* loaded from: classes3.dex */
final class p {
    public final e aOG;
    public final k aPC;
    int aPm;
    int aPp;
    int aPq;
    int aPr;
    int aPs;
    public final boolean aQe;
    int aQf;
    int aQg;
    int aQh;
    int aQi;
    int aQj;
    int aQk;
    int aQl;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.aPC = kVar;
        this.aOG = eVar;
        this.aQe = eVar != null;
    }

    public final void h(byte[] bArr, int i10) {
        this.buf = bArr;
        this.aQl = i10;
    }

    public final void update(int i10) {
        this.aQf = i10;
        if (!this.aQe) {
            this.aPm = 1;
            this.aPp = 1;
            this.aPq = 1;
            this.aPr = 0;
            this.aPs = 0;
            this.aQh = i10;
            this.aQg = i10;
            k kVar = this.aPC;
            this.aQi = kVar.aPn;
            this.aQj = kVar.aPo;
            this.aQk = kVar.aPO;
            return;
        }
        this.aPm = this.aOG.LG();
        e eVar = this.aOG;
        this.aPq = eVar.aPq;
        this.aPp = eVar.aPp;
        this.aPs = eVar.aPs;
        this.aPr = eVar.aPr;
        this.aQg = eVar.LF();
        this.aQh = this.aOG.LE();
        this.aQi = this.aOG.LH();
        int LI = this.aOG.LI();
        this.aQj = LI;
        this.aQk = ((this.aPC.aPM * LI) + 7) / 8;
    }
}
