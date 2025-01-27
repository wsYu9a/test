package com.kwad.components.ad.interstitial.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.ad.fullscreen.g;
import com.kwad.components.ad.interstitial.c;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private final boolean kP;
    private g kQ;
    private com.kwad.components.ad.interstitial.b kR;

    @NonNull
    private final c kS;

    public a(boolean z10, @NonNull AdResultData adResultData) {
        super(adResultData);
        this.kP = z10;
        if (z10) {
            this.kQ = new g(adResultData);
        } else {
            this.kR = new com.kwad.components.ad.interstitial.b(adResultData);
        }
        this.kS = new c();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kS.a(adInteractionListener);
        if (this.kP) {
            this.kQ.setFullScreenVideoAdInteractionListener(this.kS);
        } else {
            this.kR.setAdInteractionListener(this.kS);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (this.kP) {
            this.kQ.showFullScreenVideoAd(activity, ksVideoPlayConfig);
        } else {
            this.kR.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }
}
