package com.jd.ad.sdk.jad_xi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_it.jad_an;

/* loaded from: classes2.dex */
public final class jad_bo implements jad_an.InterfaceC0325jad_an {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;

    @Nullable
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;

    public jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, @Nullable com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_boVar;
    }

    @NonNull
    public byte[] jad_an(int i10) {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_bo;
        return jad_boVar == null ? new byte[i10] : (byte[]) jad_boVar.jad_an(i10, byte[].class);
    }
}
