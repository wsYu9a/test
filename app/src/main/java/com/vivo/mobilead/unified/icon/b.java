package com.vivo.mobilead.unified.icon;

import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class b implements UnifiedVivoFloatIconAdListener {

    /* renamed from: a */
    private UnifiedVivoFloatIconAdListener f30329a;

    public b(UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener) {
        this.f30329a = unifiedVivoFloatIconAdListener;
    }

    @Override // com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener
    public void onAdClick() {
        try {
            this.f30329a.onAdClick();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoFloatIconAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener
    public void onAdClose() {
        try {
            this.f30329a.onAdClose();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoFloatIconAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener
    public void onAdFailed(@NonNull VivoAdError vivoAdError) {
        try {
            this.f30329a.onAdFailed(vivoAdError);
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoFloatIconAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener
    public void onAdReady() {
        try {
            this.f30329a.onAdReady();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoFloatIconAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener
    public void onAdShow() {
        try {
            this.f30329a.onAdShow();
        } catch (Throwable th) {
            VOpenLog.w("SafeUnifiedVivoFloatIconAdListener", "" + th.getMessage());
        }
    }
}
