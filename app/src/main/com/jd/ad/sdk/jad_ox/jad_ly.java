package com.jd.ad.sdk.jad_ox;

import java.util.List;

/* loaded from: classes2.dex */
public class jad_ly extends jad_jt<com.jd.ad.sdk.jad_yh.jad_dq> {
    public final com.jd.ad.sdk.jad_yh.jad_dq jad_iv;

    public jad_ly(List<com.jd.ad.sdk.jad_yh.jad_an<com.jd.ad.sdk.jad_yh.jad_dq>> list) {
        super(list);
        this.jad_iv = new com.jd.ad.sdk.jad_yh.jad_dq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f10) {
        T t10;
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar;
        T t11 = jad_anVar.jad_bo;
        if (t11 == 0 || (t10 = jad_anVar.jad_cp) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar2 = (com.jd.ad.sdk.jad_yh.jad_dq) t11;
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar3 = (com.jd.ad.sdk.jad_yh.jad_dq) t10;
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (jad_dqVar = (com.jd.ad.sdk.jad_yh.jad_dq) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_dqVar2, jad_dqVar3, f10, jad_dq(), this.jad_dq)) != null) {
            return jad_dqVar;
        }
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar4 = this.jad_iv;
        float jad_an = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_dqVar2.jad_an, jad_dqVar3.jad_an, f10);
        float jad_an2 = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_dqVar2.jad_bo, jad_dqVar3.jad_bo, f10);
        jad_dqVar4.jad_an = jad_an;
        jad_dqVar4.jad_bo = jad_an2;
        return this.jad_iv;
    }
}
