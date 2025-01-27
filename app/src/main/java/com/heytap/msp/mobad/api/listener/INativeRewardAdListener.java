package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.NativeAdError;
import java.util.List;

/* loaded from: classes.dex */
public interface INativeRewardAdListener {
    void onAdError(NativeAdError nativeAdError, INativeAdData iNativeAdData);

    void onAdFailed(NativeAdError nativeAdError);

    void onAdSuccess(List<INativeAdData> list);

    void onInstallCompleted(String str);

    void onReward(Object... objArr);

    void onRewardFail(Object... objArr);
}
