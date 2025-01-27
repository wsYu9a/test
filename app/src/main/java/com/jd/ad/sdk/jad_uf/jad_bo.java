package com.jd.ad.sdk.jad_uf;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* loaded from: classes2.dex */
public class jad_bo implements jad_xk<byte[]> {
    public final byte[] jad_an;

    public jad_bo(byte[] bArr) {
        this.jad_an = (byte[]) jad_kx.jad_an(bArr);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @NonNull
    public byte[] get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return this.jad_an.length;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @NonNull
    public Class<byte[]> jad_cp() {
        return byte[].class;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
    }
}
