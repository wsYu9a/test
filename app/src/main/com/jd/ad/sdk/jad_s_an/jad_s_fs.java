package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;

/* loaded from: classes2.dex */
public class jad_s_fs implements IDynamicInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_fs(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdClicked(int i10, int i11) {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_an(), this.jad_s_an.jad_s_jt, 3, i10, i11);
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdSkip(View view) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, view);
    }
}
