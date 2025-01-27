package com.aggmoread.sdk.client.feedlist;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMExpressInteractionListener extends IAMAdInteractionListener {
    void onADCloseOverlay(AMExpressAd aMExpressAd);

    void onADLeftApplication(AMExpressAd aMExpressAd);

    void onADOpenOverlay(AMExpressAd aMExpressAd);

    void onAdClicked(AMExpressAd aMExpressAd);

    void onAdClosed(AMExpressAd aMExpressAd);

    void onAdExposed(AMExpressAd aMExpressAd);

    void onRenderFail(AMExpressAd aMExpressAd);

    void onRenderSuccess(AMExpressAd aMExpressAd);
}
