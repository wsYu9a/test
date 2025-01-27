package com.vivo.mobilead.unified.splash;

import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class d implements UnifiedVivoSplashAdListener {

    /* renamed from: a */
    private UnifiedVivoSplashAdListener f30512a;

    public d(UnifiedVivoSplashAdListener unifiedVivoSplashAdListener) {
        this.f30512a = unifiedVivoSplashAdListener;
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdClick() {
        try {
            this.f30512a.onAdClick();
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdFailed(@NonNull VivoAdError vivoAdError) {
        try {
            this.f30512a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdReady(@NonNull View view) {
        try {
            this.f30512a.onAdReady(view);
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdShow() {
        try {
            this.f30512a.onAdShow();
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdSkip() {
        try {
            this.f30512a.onAdSkip();
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
    public void onAdTimeOver() {
        try {
            this.f30512a.onAdTimeOver();
        } catch (Throwable th) {
            VOpenLog.w("SafeSplashAdListener", "" + th.getMessage());
        }
    }
}
