package com.aggmoread.sdk.client.fullscreen;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMFullScreenAdInteractionListener extends IAMAdInteractionListener {
    void onADLeftApplication();

    void onAdClicked();

    void onAdClosed();

    void onAdExposed();

    void onAdVideoCompleted();
}
