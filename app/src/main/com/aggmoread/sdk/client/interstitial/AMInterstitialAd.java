package com.aggmoread.sdk.client.interstitial;

import android.app.Activity;
import com.aggmoread.sdk.client.AMAdInterface;

/* loaded from: classes.dex */
public interface AMInterstitialAd extends AMAdInterface {
    void show(Activity activity, AMInterstitialAdInteractionListener aMInterstitialAdInteractionListener);

    void show(AMInterstitialAdInteractionListener aMInterstitialAdInteractionListener);
}
