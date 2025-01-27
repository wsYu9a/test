package com.vivo.mobilead.unified.interstitial;

import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class e implements UnifiedVivoInterstitialAdListener {

    /* renamed from: a */
    private UnifiedVivoInterstitialAdListener f30341a;

    public e(UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener) {
        this.f30341a = unifiedVivoInterstitialAdListener;
    }

    @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
    public void onAdClick() {
        try {
            this.f30341a.onAdClick();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoInterstitialAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
    public void onAdClose() {
        try {
            this.f30341a.onAdClose();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoInterstitialAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
    public void onAdFailed(VivoAdError vivoAdError) {
        try {
            this.f30341a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoInterstitialAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
    public void onAdReady() {
        try {
            this.f30341a.onAdReady();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoInterstitialAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
    public void onAdShow() {
        try {
            this.f30341a.onAdShow();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoInterstitialAdListener", "" + th.getMessage());
        }
    }
}
