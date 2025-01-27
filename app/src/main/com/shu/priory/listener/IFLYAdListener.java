package com.shu.priory.listener;

import com.shu.priory.config.AdError;
import com.shu.priory.download.DialogListener;

/* loaded from: classes3.dex */
public interface IFLYAdListener extends DialogListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdFailed(AdError adError);

    void onAdReceive();
}
