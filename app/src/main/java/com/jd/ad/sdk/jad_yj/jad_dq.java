package com.jd.ad.sdk.jad_yj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ir.jad_an;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class jad_dq implements jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> {
    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @Nullable
    public jad_xk<byte[]> jad_an(@NonNull jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = jad_xkVar.get().jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_ir.jad_an.jad_an;
        jad_an.jad_bo jad_boVar = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new jad_an.jad_bo(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        if (jad_boVar != null && jad_boVar.jad_an == 0 && jad_boVar.jad_bo == jad_boVar.jad_cp.length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new com.jd.ad.sdk.jad_uf.jad_bo(bArr);
    }
}
