package com.vivo.mobilead.unified.nativead;

import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class c implements UnifiedVivoNativeExpressAdListener {

    /* renamed from: a */
    private UnifiedVivoNativeExpressAdListener f30481a;

    public c(UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener) {
        this.f30481a = unifiedVivoNativeExpressAdListener;
    }

    @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
    public void onAdClick(VivoNativeExpressView vivoNativeExpressView) {
        try {
            this.f30481a.onAdClick(vivoNativeExpressView);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoNativeExpressAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
    public void onAdClose(VivoNativeExpressView vivoNativeExpressView) {
        try {
            this.f30481a.onAdClose(vivoNativeExpressView);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoNativeExpressAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
    public void onAdFailed(VivoAdError vivoAdError) {
        try {
            this.f30481a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoNativeExpressAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
    public void onAdReady(VivoNativeExpressView vivoNativeExpressView) {
        try {
            this.f30481a.onAdReady(vivoNativeExpressView);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoNativeExpressAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
    public void onAdShow(VivoNativeExpressView vivoNativeExpressView) {
        try {
            this.f30481a.onAdShow(vivoNativeExpressView);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoNativeExpressAdListener", "" + th.getMessage());
        }
    }
}
