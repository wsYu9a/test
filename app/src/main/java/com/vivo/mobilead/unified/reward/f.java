package com.vivo.mobilead.unified.reward;

import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class f implements UnifiedVivoRewardVideoAdListener {

    /* renamed from: a */
    private UnifiedVivoRewardVideoAdListener f30503a;

    public f(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        this.f30503a = unifiedVivoRewardVideoAdListener;
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onAdClick() {
        try {
            this.f30503a.onAdClick();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onAdClose() {
        d.c().a(false);
        try {
            this.f30503a.onAdClose();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onAdFailed(VivoAdError vivoAdError) {
        try {
            this.f30503a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onAdReady() {
        try {
            this.f30503a.onAdReady();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onAdShow() {
        try {
            this.f30503a.onAdShow();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener
    public void onRewardVerify() {
        try {
            this.f30503a.onRewardVerify();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoRewardVideoAdListener", "" + th.getMessage());
        }
    }
}
