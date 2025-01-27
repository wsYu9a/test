package com.vivo.mobilead.unified.banner;

import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class d implements UnifiedVivoBannerAdListener {

    /* renamed from: a */
    private UnifiedVivoBannerAdListener f29694a;

    public d(UnifiedVivoBannerAdListener unifiedVivoBannerAdListener) {
        this.f29694a = unifiedVivoBannerAdListener;
    }

    @Override // com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener
    public void onAdClick() {
        try {
            this.f29694a.onAdClick();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoBannerAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener
    public void onAdClose() {
        try {
            this.f29694a.onAdClose();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoBannerAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener
    public void onAdFailed(@NonNull VivoAdError vivoAdError) {
        try {
            this.f29694a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoBannerAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener
    public void onAdReady(@NonNull View view) {
        try {
            this.f29694a.onAdReady(view);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoBannerAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener
    public void onAdShow() {
        try {
            this.f29694a.onAdShow();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoBannerAdListener", "" + th.getMessage());
        }
    }
}
