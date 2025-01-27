package com.martian.ttbook.sdk.client.splash;

import com.martian.ttbook.sdk.client.AdController;

/* loaded from: classes4.dex */
public interface SplashAdExtListener extends SplashAdListener {
    void onAdLoaded(AdController adController);

    void onAdSkip();

    void onAdTick(long j2);
}
