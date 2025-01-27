package com.aggmoread.sdk.client.banner;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMBannerAdInteractionListener extends IAMAdInteractionListener {
    void onADCloseOverlay();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onAdClicked();

    void onAdClosed();

    void onAdExposed();
}
