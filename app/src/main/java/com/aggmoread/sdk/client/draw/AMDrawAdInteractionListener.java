package com.aggmoread.sdk.client.draw;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMDrawAdInteractionListener extends IAMAdInteractionListener {
    void onADCloseOverlay();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onAdClicked();

    void onAdExposed();

    void onRenderFail();

    void onRenderSuccess();
}
