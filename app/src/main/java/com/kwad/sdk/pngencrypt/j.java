package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class j extends DeflatedChunksSet {
    protected final e auS;
    protected byte[] avM;
    protected byte[] avN;
    protected final k avO;
    final p avP;
    protected int[] avQ;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] avR;

        static {
            int[] iArr = new int[FilterType.values().length];
            avR = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                avR[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                avR[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                avR[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                avR[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.BI() : kVar.awa) + 1, kVar.awa + 1, null, null);
        this.avQ = new int[5];
        this.avO = kVar;
        this.auS = eVar;
        this.avP = new p(kVar, eVar);
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void BJ() {
        bO(this.avP.aww);
    }

    private int BK() {
        int BI;
        e eVar = this.auS;
        int i2 = 0;
        if (eVar == null) {
            int BA = BA();
            k kVar = this.avO;
            if (BA < kVar.avz - 1) {
                BI = kVar.awa;
                i2 = BI + 1;
            }
        } else if (eVar.BB()) {
            BI = this.auS.BI();
            i2 = BI + 1;
        }
        if (!this.auV) {
            bK(i2);
        }
        return i2;
    }

    private void bO(int i2) {
        byte[] bArr = this.avM;
        if (bArr == null || bArr.length < this.avl.length) {
            byte[] bArr2 = this.avl;
            this.avM = new byte[bArr2.length];
            this.avN = new byte[bArr2.length];
        }
        if (this.avP.awt == 0) {
            Arrays.fill(this.avM, (byte) 0);
        }
        byte[] bArr3 = this.avM;
        this.avM = this.avN;
        this.avN = bArr3;
        byte b2 = this.avl[0];
        if (!FilterType.isValidStandard(b2)) {
            throw new PngjException("Filter type " + ((int) b2) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b2);
        int[] iArr = this.avQ;
        iArr[b2] = iArr[b2] + 1;
        this.avM[0] = this.avl[0];
        int i3 = AnonymousClass1.avR[byVal.ordinal()];
        if (i3 == 1) {
            bQ(i2);
            return;
        }
        if (i3 == 2) {
            bS(i2);
            return;
        }
        if (i3 == 3) {
            bT(i2);
            return;
        }
        if (i3 == 4) {
            bP(i2);
        } else {
            if (i3 == 5) {
                bR(i2);
                return;
            }
            throw new PngjException("Filter type " + ((int) b2) + " not implemented");
        }
    }

    private void bP(int i2) {
        int i3 = 1;
        int i4 = 1 - this.avO.avZ;
        while (i3 <= i2) {
            this.avM[i3] = (byte) (this.avl[i3] + (((i4 > 0 ? this.avM[i4] & 255 : 0) + (this.avN[i3] & 255)) / 2));
            i3++;
            i4++;
        }
    }

    private void bQ(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.avM[i3] = this.avl[i3];
        }
    }

    private void bR(int i2) {
        int i3 = 1;
        int i4 = 1 - this.avO.avZ;
        while (i3 <= i2) {
            int i5 = 0;
            int i6 = i4 > 0 ? this.avM[i4] & 255 : 0;
            if (i4 > 0) {
                i5 = this.avN[i4] & 255;
            }
            this.avM[i3] = (byte) (this.avl[i3] + n.b(i6, this.avN[i3] & 255, i5));
            i3++;
            i4++;
        }
    }

    private void bS(int i2) {
        int i3;
        int i4 = 1;
        while (true) {
            i3 = this.avO.avZ;
            if (i4 > i3) {
                break;
            }
            this.avM[i4] = this.avl[i4];
            i4++;
        }
        int i5 = i3 + 1;
        int i6 = 1;
        while (i5 <= i2) {
            byte[] bArr = this.avM;
            bArr[i5] = (byte) (this.avl[i5] + bArr[i6]);
            i5++;
            i6++;
        }
    }

    private void bT(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.avM[i3] = (byte) (this.avl[i3] + this.avN[i3]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final void Bx() {
        super.Bx();
        this.avP.update(BA());
        BJ();
        p pVar = this.avP;
        pVar.h(this.avM, pVar.aww + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int By() {
        return BK();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.avM = null;
        this.avN = null;
    }
}
