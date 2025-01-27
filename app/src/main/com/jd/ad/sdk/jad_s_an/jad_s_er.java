package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes2.dex */
public class jad_s_er implements JADExposureListener {
    public final /* synthetic */ int jad_s_an;
    public final /* synthetic */ View jad_s_bo;
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_cp;

    public class jad_s_an implements IDynamicCountdownListener {
        public jad_s_an() {
        }

        @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener
        public void onAdCountdown(int i10) {
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_er.this.jad_s_cp, i10);
        }
    }

    public class jad_s_bo implements Runnable {
        public jad_s_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplashSkipView jADSplashSkipView;
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = jad_s_er.this.jad_s_cp;
            View view = jad_s_anVar.jad_s_jt;
            if (view == null || (jADSplashSkipView = (JADSplashSkipView) view.findViewById(ResourceUtils.getResourceId(jad_s_anVar.jad_s_an(), "jad_splash_skip_btn", "id"))) == null) {
                return;
            }
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_s_an.jad_s_bo(jad_s_anVar, jADSplashSkipView));
        }
    }

    public jad_s_er(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, int i10, View view) {
        this.jad_s_cp = jad_s_anVar;
        this.jad_s_an = i10;
        this.jad_s_bo = view;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j10, String str, int i10) {
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i10);
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, true, str, i10, this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex(), this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
        JADSplashSkipView jADSplashSkipView;
        if (this.jad_s_an != 1 || (jADSplashSkipView = this.jad_s_cp.jad_s_kx) == null) {
            return;
        }
        jADSplashSkipView.removeCallbacks(null);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        int i10 = this.jad_s_an;
        if (i10 == 3) {
            View view = this.jad_s_bo;
            if (view != null && (view instanceof DynamicRenderView)) {
                ((DynamicRenderView) view).play();
                if (this.jad_s_cp.jad_s_ly != null) {
                    ((DynamicRenderView) this.jad_s_bo).startCount(new jad_s_an());
                }
            }
        } else if (i10 == 1) {
            if (this.jad_s_cp.jad_s_ob) {
                View view2 = this.jad_s_bo;
                if (view2 != null && (view2 instanceof VideoRenderView)) {
                    ((VideoRenderView) view2).play();
                }
            } else {
                WorkExecutor.execute(new jad_s_bo());
            }
        }
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex(), this.jad_s_an);
    }
}
