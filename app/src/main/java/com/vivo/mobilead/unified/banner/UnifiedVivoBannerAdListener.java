package com.vivo.mobilead.unified.banner;

import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoBannerAdListener {
    void onAdClick();

    void onAdClose();

    void onAdFailed(@NonNull VivoAdError vivoAdError);

    void onAdReady(@NonNull View view);

    void onAdShow();
}
