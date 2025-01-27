package com.heytap.msp.mobad.api.listener;

/* loaded from: classes.dex */
public interface IHotSplashListener {
    void onAdClick();

    void onAdDismissed();

    void onAdFailed(int i2, String str);

    void onAdReady();

    void onAdShow(String str);
}
