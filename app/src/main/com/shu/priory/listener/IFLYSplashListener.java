package com.shu.priory.listener;

import com.shu.priory.conn.SplashDataRef;

/* loaded from: classes3.dex */
public interface IFLYSplashListener extends IFLYBaseAdListener<SplashDataRef> {
    void onAdClick();

    void onAdExposure();

    void onAdSkip();

    void onAdTimeOver();
}
