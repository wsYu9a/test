package com.aggmoread.sdk.client.interstitial;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMInterstitialAdInteractionListener extends IAMAdInteractionListener {
    void onADLeftApplication();

    void onAdClicked();

    void onAdClosed();

    void onAdExposed();

    void onAdVideoCompleted();
}
