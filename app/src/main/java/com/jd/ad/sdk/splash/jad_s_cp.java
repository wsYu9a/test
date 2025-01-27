package com.jd.ad.sdk.splash;

import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.jad_s_an;

/* loaded from: classes2.dex */
public class jad_s_cp implements Runnable {
    public final /* synthetic */ jad_s_an jad_s_an;

    public jad_s_cp(jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.jad_s_an.jad_s_jt;
        if (view == null || view.getParent() == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_s_an.jad_s_dq);
        jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_an.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.reportCloseEvent(CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
            JADSplash.this.callbackAdCloseOnUiThread();
            JADSplash.this.destroy();
        }
    }
}
