package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;

/* loaded from: classes2.dex */
public class jad_s_jt implements VideoInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_jt(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdClicked(int i10, int i11) {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_an(), this.jad_s_an.jad_s_jt, 1, i10, i11);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdCountdown(int i10) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i10);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdSkip(View view) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, view);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdTimeOver() {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onVideoAnimationEnd() {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an);
    }
}
