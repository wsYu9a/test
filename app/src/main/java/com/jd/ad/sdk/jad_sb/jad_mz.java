package com.jd.ad.sdk.jad_sb;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class jad_mz implements jad_cp {
    public final String jad_an;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_ly jad_dq;
    public final boolean jad_er;

    public jad_mz(String str, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2, com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar, boolean z10) {
        this.jad_an = str;
        this.jad_bo = jad_boVar;
        this.jad_cp = jad_boVar2;
        this.jad_dq = jad_lyVar;
        this.jad_er = z10;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    @Nullable
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_pc(jad_mzVar, jad_anVar, this);
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_cp() {
        return this.jad_cp;
    }

    public com.jd.ad.sdk.jad_ra.jad_ly jad_dq() {
        return this.jad_dq;
    }

    public boolean jad_er() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_an() {
        return this.jad_bo;
    }
}
