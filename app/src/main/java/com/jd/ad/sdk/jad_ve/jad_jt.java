package com.jd.ad.sdk.jad_ve;

import android.graphics.Color;

/* loaded from: classes2.dex */
public class jad_jt implements jad_mx<Integer> {
    public static final jad_jt jad_an = new jad_jt();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public Integer jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f10) {
        boolean z10 = jad_cpVar.jad_mz() == 1;
        if (z10) {
            jad_cpVar.jad_bo();
        }
        double jad_iv = jad_cpVar.jad_iv();
        double jad_iv2 = jad_cpVar.jad_iv();
        double jad_iv3 = jad_cpVar.jad_iv();
        double jad_iv4 = jad_cpVar.jad_mz() == 7 ? jad_cpVar.jad_iv() : 1.0d;
        if (z10) {
            jad_cpVar.jad_dq();
        }
        if (jad_iv <= 1.0d && jad_iv2 <= 1.0d && jad_iv3 <= 1.0d) {
            jad_iv *= 255.0d;
            jad_iv2 *= 255.0d;
            jad_iv3 *= 255.0d;
            if (jad_iv4 <= 1.0d) {
                jad_iv4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) jad_iv4, (int) jad_iv, (int) jad_iv2, (int) jad_iv3));
    }
}
