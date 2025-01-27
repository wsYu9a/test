package com.vivo.mobilead.unified.interstitial;

import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoInterstitialAdListener {
    void onAdClick();

    void onAdClose();

    void onAdFailed(VivoAdError vivoAdError);

    void onAdReady();

    void onAdShow();
}
