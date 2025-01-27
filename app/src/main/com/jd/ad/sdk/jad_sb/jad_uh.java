package com.jd.ad.sdk.jad_sb;

import com.jd.ad.sdk.jad_lu.jad_zm;
import p3.f;

/* loaded from: classes2.dex */
public class jad_uh implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_dq;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_er;
    public final boolean jad_fs;

    public jad_uh(String str, int i10, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3, boolean z10) {
        this.jad_an = str;
        this.jad_bo = i10;
        this.jad_cp = jad_boVar;
        this.jad_dq = jad_boVar2;
        this.jad_er = jad_boVar3;
        this.jad_fs = z10;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_sf(jad_anVar, this);
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_cp() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_dq() {
        return this.jad_cp;
    }

    public int jad_er() {
        return this.jad_bo;
    }

    public boolean jad_fs() {
        return this.jad_fs;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("Trim Path: {start: ");
        jad_an.append(this.jad_cp);
        jad_an.append(", end: ");
        jad_an.append(this.jad_dq);
        jad_an.append(", offset: ");
        jad_an.append(this.jad_er);
        jad_an.append(f.f29748d);
        return jad_an.toString();
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_an() {
        return this.jad_dq;
    }
}
