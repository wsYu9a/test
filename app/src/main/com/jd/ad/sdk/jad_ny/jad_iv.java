package com.jd.ad.sdk.jad_ny;

/* loaded from: classes2.dex */
public final class jad_iv implements jad_an<int[]> {
    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public String jad_an() {
        return "IntegerArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_bo() {
        return 4;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int[] newArray(int i10) {
        return new int[i10];
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_an(int[] iArr) {
        return iArr.length;
    }
}
