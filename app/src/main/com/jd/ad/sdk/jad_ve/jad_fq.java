package com.jd.ad.sdk.jad_ve;

/* loaded from: classes2.dex */
public class jad_fq implements jad_mx<com.jd.ad.sdk.jad_yh.jad_dq> {
    public static final jad_fq jad_an = new jad_fq();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_yh.jad_dq jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f10) {
        boolean z10 = jad_cpVar.jad_mz() == 1;
        if (z10) {
            jad_cpVar.jad_bo();
        }
        float jad_iv = (float) jad_cpVar.jad_iv();
        float jad_iv2 = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        if (z10) {
            jad_cpVar.jad_dq();
        }
        return new com.jd.ad.sdk.jad_yh.jad_dq((jad_iv / 100.0f) * f10, (jad_iv2 / 100.0f) * f10);
    }
}
