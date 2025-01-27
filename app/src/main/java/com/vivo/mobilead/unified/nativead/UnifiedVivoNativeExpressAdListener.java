package com.vivo.mobilead.unified.nativead;

import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoNativeExpressAdListener {
    void onAdClick(VivoNativeExpressView vivoNativeExpressView);

    void onAdClose(VivoNativeExpressView vivoNativeExpressView);

    void onAdFailed(VivoAdError vivoAdError);

    void onAdReady(VivoNativeExpressView vivoNativeExpressView);

    void onAdShow(VivoNativeExpressView vivoNativeExpressView);
}
