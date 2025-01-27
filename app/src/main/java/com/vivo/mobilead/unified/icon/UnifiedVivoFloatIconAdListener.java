package com.vivo.mobilead.unified.icon;

import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoFloatIconAdListener {
    void onAdClick();

    void onAdClose();

    void onAdFailed(@NonNull VivoAdError vivoAdError);

    void onAdReady();

    void onAdShow();
}
