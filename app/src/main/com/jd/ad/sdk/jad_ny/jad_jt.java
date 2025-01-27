package com.jd.ad.sdk.jad_ny;

/* loaded from: classes2.dex */
public final class jad_jt implements jad_an<byte[]> {
    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public String jad_an() {
        return "ByteArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public byte[] newArray(int i10) {
        return new byte[i10];
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_an(byte[] bArr) {
        return bArr.length;
    }
}
