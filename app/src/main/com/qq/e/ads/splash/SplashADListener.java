package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

/* loaded from: classes3.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j10);

    void onADPresent();

    void onADTick(long j10);

    void onNoAD(AdError adError);
}
