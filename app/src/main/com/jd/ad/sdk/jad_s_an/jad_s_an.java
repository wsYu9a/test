package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes2.dex */
public class jad_s_an implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADSplashSkipView jADSplashSkipView = this.jad_s_an.jad_s_kx;
        if (jADSplashSkipView != null) {
            jADSplashSkipView.removeCallbacks(null);
        }
        if (this.jad_s_an.jad_s_iv.getContext() == null) {
            return;
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_iv.getContext(), this.jad_s_an.jad_s_iv, 1, 0, CommonConstants.AdTriggerSourceType.CLICK.ordinal());
    }
}
