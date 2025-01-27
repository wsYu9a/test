package com.jd.ad.sdk.jad_n_an;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jd.ad.sdk.dl.event.JADVideoReporter;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ConversionUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_n_dq implements JADVideoReporter {
    public final JADSlot jad_n_an;
    public final JADEventService jad_n_bo = JADMediator.getInstance().getEventService();

    public jad_n_dq(JADSlot jADSlot) {
        this.jad_n_an = jADSlot;
    }

    public final void jad_n_an(int i10, float f10) {
        JADEventService jADEventService;
        JADSlot jADSlot = this.jad_n_an;
        if (jADSlot == null || (jADEventService = this.jad_n_bo) == null) {
            return;
        }
        jADEventService.reportVideoEvent(jADSlot.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), i10, ConversionUtils.floatToDouble(f10));
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoCompleted(float f10) {
        jad_n_an(4, f10);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoError(float f10, int i10, int i11) {
        JADSlot jADSlot = this.jad_n_an;
        String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "duration", Float.valueOf(f10));
        JsonUtils.put(jSONObject, MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "extraCode", Integer.valueOf(i11));
        JADEventService jADEventService = this.jad_n_bo;
        if (jADEventService != null) {
            jADEventService.reportVideoExceptionEvent(requestId, 11, jSONObject.toString());
        }
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPause(float f10) {
        jad_n_an(3, f10);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPreloadCompleted() {
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoResume(float f10) {
        jad_n_an(5, f10);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoStart(float f10) {
        jad_n_an(2, f10);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoWillStart() {
        jad_n_an(1, 0.0f);
    }
}
