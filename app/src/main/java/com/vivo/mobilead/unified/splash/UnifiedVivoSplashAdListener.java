package com.vivo.mobilead.unified.splash;

import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface UnifiedVivoSplashAdListener {
    void onAdClick();

    void onAdFailed(@NonNull VivoAdError vivoAdError);

    void onAdReady(@NonNull View view);

    void onAdShow();

    void onAdSkip();

    void onAdTimeOver();
}
