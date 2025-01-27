package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import java.util.List;

/* loaded from: classes.dex */
public interface INativeTempletAdListener {
    void onAdClick(INativeTempletAdView iNativeTempletAdView);

    void onAdClose(INativeTempletAdView iNativeTempletAdView);

    void onAdFailed(NativeAdError nativeAdError);

    void onAdShow(INativeTempletAdView iNativeTempletAdView);

    void onAdSuccess(List<INativeTempletAdView> list);

    void onRenderFailed(NativeAdError nativeAdError, INativeTempletAdView iNativeTempletAdView);

    void onRenderSuccess(INativeTempletAdView iNativeTempletAdView);
}
