package com.jd.ad.sdk.banner.jad_b_an;

import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;

/* loaded from: classes2.dex */
public class jad_b_an implements JADExposureListener {
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_an jad_b_an;

    public jad_b_an(com.jd.ad.sdk.banner.jad_b_an jad_b_anVar) {
        this.jad_b_an = jad_b_anVar;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j10, String str, int i10) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i10);
        }
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.jad_b_an;
        jad_b_anVar.jad_b_an(jad_b_anVar.jad_b_jt, true, str, i10);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.jad_b_an;
        jad_b_anVar.jad_b_an(jad_b_anVar.jad_b_jt, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.jad_b_an;
        jad_b_anVar.jad_b_an(jad_b_anVar.jad_b_jt, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
