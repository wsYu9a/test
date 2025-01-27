package com.jd.ad.sdk.jad_n_an;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.nativead.JADNative;

/* loaded from: classes2.dex */
public class jad_n_er extends ShakeListener {
    public final /* synthetic */ float jad_n_an;
    public final /* synthetic */ float jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ jad_n_hu jad_n_dq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_n_er(jad_n_hu jad_n_huVar, Context context, float f10, float f11, float f12, boolean z10, float f13, float f14, float f15) {
        super(context, f10, f11, f12, z10);
        this.jad_n_dq = jad_n_huVar;
        this.jad_n_an = f13;
        this.jad_n_bo = f14;
        this.jad_n_cp = f15;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        JADNative jADNative = this.jad_n_dq.jad_n_an;
        if (jADNative == null || jADNative.getSlot() == null) {
            return;
        }
        if (this.jad_n_dq.jad_n_an.getSlot().getAdType() == 1) {
            jad_n_hu jad_n_huVar = this.jad_n_dq;
            if (jad_n_hu.jad_n_an(jad_n_huVar, jad_n_huVar.jad_n_fs)) {
                jad_n_hu jad_n_huVar2 = this.jad_n_dq;
                jad_n_huVar2.jad_n_jw = jad_n_hu.jad_n_an(jad_n_huVar2, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                jad_n_hu jad_n_huVar3 = this.jad_n_dq;
                jad_n_huVar3.jad_n_bo(jad_n_huVar3.jad_n_fs);
                return;
            }
            return;
        }
        jad_n_hu jad_n_huVar4 = this.jad_n_dq;
        if (jad_n_huVar4.jad_n_an(jad_n_huVar4.jad_n_fs)) {
            jad_n_hu jad_n_huVar5 = this.jad_n_dq;
            if (jad_n_hu.jad_n_an(jad_n_huVar5, jad_n_huVar5.jad_n_fs.getContext(), this.jad_n_dq.jad_n_an.getInstanceId())) {
                jad_n_hu jad_n_huVar6 = this.jad_n_dq;
                jad_n_huVar6.jad_n_jw = jad_n_hu.jad_n_an(jad_n_huVar6, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                jad_n_hu jad_n_huVar7 = this.jad_n_dq;
                jad_n_huVar7.jad_n_bo(jad_n_huVar7.jad_n_fs);
            }
        }
    }
}
