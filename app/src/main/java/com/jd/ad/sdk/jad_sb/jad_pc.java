package com.jd.ad.sdk.jad_sb;

import com.jd.ad.sdk.jad_lu.jad_zm;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_pc implements jad_cp {
    public final String jad_an;
    public final List<jad_cp> jad_bo;
    public final boolean jad_cp;

    public jad_pc(String str, List<jad_cp> list, boolean z10) {
        this.jad_an = str;
        this.jad_bo = list;
        this.jad_cp = z10;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_dq(jad_mzVar, jad_anVar, this);
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public boolean jad_cp() {
        return this.jad_cp;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("ShapeGroup{name='");
        jad_an.append(this.jad_an);
        jad_an.append("' Shapes: ");
        jad_an.append(Arrays.toString(this.jad_bo.toArray()));
        jad_an.append('}');
        return jad_an.toString();
    }

    public List<jad_cp> jad_an() {
        return this.jad_bo;
    }
}
