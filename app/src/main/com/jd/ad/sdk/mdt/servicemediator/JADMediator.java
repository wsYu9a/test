package com.jd.ad.sdk.mdt.servicemediator;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_zi.jad_er;
import com.jd.ad.sdk.jad_zi.jad_fs;
import com.jd.ad.sdk.jad_zi.jad_hu;
import com.jd.ad.sdk.jad_zi.jad_iv;
import com.jd.ad.sdk.jad_zi.jad_jt;
import com.jd.ad.sdk.jad_zi.jad_jw;
import com.jd.ad.sdk.jad_zi.jad_kx;
import com.jd.ad.sdk.mdt.service.JADAdService;
import com.jd.ad.sdk.mdt.service.JADAdVideoLoadService;
import com.jd.ad.sdk.mdt.service.JADDynamicRenderService;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.service.JADExposureService;
import com.jd.ad.sdk.mdt.service.JADFoundationService;
import com.jd.ad.sdk.mdt.service.JADInitService;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import com.jd.ad.sdk.mdt.service.JADVideoRenderService;

/* loaded from: classes2.dex */
public class JADMediator {
    private com.jd.ad.sdk.jad_gj.jad_an mMediatorService;

    public static class jad_bo {
        public static final JADMediator jad_an = new JADMediator();
    }

    public /* synthetic */ JADMediator(jad_an jad_anVar) {
        this();
    }

    public static JADMediator getInstance() {
        return jad_bo.jad_an;
    }

    @NonNull
    public JADAdService getAdService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_zi.jad_an();
        }
        return jad_anVar.jad_bo;
    }

    @NonNull
    public JADAdVideoLoadService getAdVideoService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_hu == null) {
            jad_anVar.jad_hu = new com.jd.ad.sdk.jad_zi.jad_bo();
        }
        return jad_anVar.jad_hu;
    }

    @NonNull
    public JADDynamicRenderService getDynamicRenderService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_jt == null) {
            jad_anVar.jad_jt = new jad_er();
        }
        return jad_anVar.jad_jt;
    }

    @NonNull
    public JADEventService getEventService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_cp == null) {
            jad_anVar.jad_cp = new jad_fs();
        }
        return jad_anVar.jad_cp;
    }

    @NonNull
    public JADExposureService getExposureService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_dq == null) {
            jad_anVar.jad_dq = new jad_jt();
        }
        return jad_anVar.jad_dq;
    }

    @NonNull
    public JADFoundationService getFoundationService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_er == null) {
            jad_anVar.jad_er = new jad_hu();
        }
        return jad_anVar.jad_er;
    }

    @NonNull
    public JADInitService getInitService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_an == null) {
            jad_anVar.jad_an = new jad_iv();
        }
        return jad_anVar.jad_an;
    }

    @NonNull
    public JADTouchService getTouchService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_fs == null) {
            jad_anVar.jad_fs = new jad_jw();
        }
        return jad_anVar.jad_fs;
    }

    @NonNull
    public JADVideoRenderService getVideoRenderService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_iv == null) {
            jad_anVar.jad_iv = new jad_kx();
        }
        return jad_anVar.jad_iv;
    }

    private JADMediator() {
        if (this.mMediatorService == null) {
            this.mMediatorService = new com.jd.ad.sdk.jad_gj.jad_an();
        }
    }
}
