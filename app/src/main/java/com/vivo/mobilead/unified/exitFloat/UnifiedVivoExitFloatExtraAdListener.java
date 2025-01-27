package com.vivo.mobilead.unified.exitFloat;

import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoExitFloatExtraAdListener {
    void onAdClick(int i2);

    void onAdClose();

    void onAdFailed(VivoAdError vivoAdError);

    void onAdShow();
}
