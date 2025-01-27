package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public final class j extends DeflatedChunksSet {
    protected final e aOG;
    protected byte[] aPA;
    protected byte[] aPB;
    protected final k aPC;
    final p aPD;
    protected int[] aPE;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aPF;

        static {
            int[] iArr = new int[FilterType.values().length];
            aPF = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aPF[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aPF[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aPF[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aPF[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z10, k kVar, e eVar) {
        this(str, z10, kVar, eVar, null, null);
    }

    private void LL() {
        dM(this.aPD.aQk);
    }

    private int LM() {
        int LK;
        e eVar = this.aOG;
        int i10 = 0;
        if (eVar == null) {
            int LC = LC();
            k kVar = this.aPC;
            if (LC < kVar.aPn - 1) {
                LK = kVar.aPO;
                i10 = LK + 1;
            }
        } else if (eVar.LD()) {
            LK = this.aOG.LK();
            i10 = LK + 1;
        }
        if (!this.aOJ) {
            dI(i10);
        }
        return i10;
    }

    private void dM(int i10) {
        byte[] bArr = this.aPA;
        if (bArr == null || bArr.length < this.aOZ.length) {
            byte[] bArr2 = this.aOZ;
            this.aPA = new byte[bArr2.length];
            this.aPB = new byte[bArr2.length];
        }
        if (this.aPD.aQh == 0) {
            Arrays.fill(this.aPA, (byte) 0);
        }
        byte[] bArr3 = this.aPA;
        this.aPA = this.aPB;
        this.aPB = bArr3;
        byte b10 = this.aOZ[0];
        if (!FilterType.isValidStandard(b10)) {
            throw new PngjException("Filter type " + ((int) b10) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b10);
        int[] iArr = this.aPE;
        iArr[b10] = iArr[b10] + 1;
        this.aPA[0] = this.aOZ[0];
        int i11 = AnonymousClass1.aPF[byVal.ordinal()];
        if (i11 == 1) {
            dO(i10);
            return;
        }
        if (i11 == 2) {
            dQ(i10);
            return;
        }
        if (i11 == 3) {
            dR(i10);
            return;
        }
        if (i11 == 4) {
            dN(i10);
        } else {
            if (i11 == 5) {
                dP(i10);
                return;
            }
            throw new PngjException("Filter type " + ((int) b10) + " not implemented");
        }
    }

    private void dN(int i10) {
        int i11 = 1;
        int i12 = 1 - this.aPC.aPN;
        while (i11 <= i10) {
            this.aPA[i11] = (byte) (this.aOZ[i11] + (((i12 > 0 ? this.aPA[i12] & 255 : 0) + (this.aPB[i11] & 255)) / 2));
            i11++;
            i12++;
        }
    }

    private void dO(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.aPA[i11] = this.aOZ[i11];
        }
    }

    private void dP(int i10) {
        int i11 = 1;
        int i12 = 1 - this.aPC.aPN;
        while (i11 <= i10) {
            int i13 = 0;
            int i14 = i12 > 0 ? this.aPA[i12] & 255 : 0;
            if (i12 > 0) {
                i13 = this.aPB[i12] & 255;
            }
            this.aPA[i11] = (byte) (this.aOZ[i11] + n.b(i14, this.aPB[i11] & 255, i13));
            i11++;
            i12++;
        }
    }

    private void dQ(int i10) {
        int i11;
        int i12 = 1;
        while (true) {
            i11 = this.aPC.aPN;
            if (i12 > i11) {
                break;
            }
            this.aPA[i12] = this.aOZ[i12];
            i12++;
        }
        int i13 = i11 + 1;
        int i14 = 1;
        while (i13 <= i10) {
            byte[] bArr = this.aPA;
            bArr[i13] = (byte) (this.aOZ[i13] + bArr[i14]);
            i13++;
            i14++;
        }
    }

    private void dR(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.aPA[i11] = (byte) (this.aOZ[i11] + this.aPB[i11]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int LA() {
        return LM();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void Lz() {
        super.Lz();
        this.aPD.update(LC());
        LL();
        p pVar = this.aPD;
        pVar.h(this.aPA, pVar.aQk + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aPA = null;
        this.aPB = null;
    }

    private j(String str, boolean z10, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z10, (eVar != null ? eVar.LK() : kVar.aPO) + 1, kVar.aPO + 1, null, null);
        this.aPE = new int[5];
        this.aPC = kVar;
        this.aOG = eVar;
        this.aPD = new p(kVar, eVar);
        com.kwad.sdk.core.d.c.d("PNG_ENCRYPT", "Creating IDAT set ");
    }
}
