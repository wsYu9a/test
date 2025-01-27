package com.vivo.mobilead.unified.reward;

import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoRewardVideoAdListener {
    void onAdClick();

    void onAdClose();

    void onAdFailed(VivoAdError vivoAdError);

    void onAdReady();

    void onAdShow();

    void onRewardVerify();
}
