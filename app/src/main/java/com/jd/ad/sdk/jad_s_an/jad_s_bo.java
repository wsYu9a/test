package com.jd.ad.sdk.jad_s_an;

import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes2.dex */
public class jad_s_bo implements Runnable {
    public final /* synthetic */ JADSplashSkipView jad_s_an;

    public jad_s_bo(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        JADSplashSkipView jADSplashSkipView = this.jad_s_an;
        if (jADSplashSkipView != null) {
            int i10 = jADSplashSkipView.jad_s_an;
            if (i10 < 1 || i10 > 30) {
                jADSplashSkipView.jad_s_an = 5;
            }
            jADSplashSkipView.post(jADSplashSkipView.jad_s_er);
        }
    }
}
