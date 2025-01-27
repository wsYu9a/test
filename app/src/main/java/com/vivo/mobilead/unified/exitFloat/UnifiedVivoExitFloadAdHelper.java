package com.vivo.mobilead.unified.exitFloat;

import android.app.Activity;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public class UnifiedVivoExitFloadAdHelper {

    static class a implements d {

        /* renamed from: a */
        final /* synthetic */ UnifiedVivoExitFloatExtraAdListener f30262a;

        a(UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener) {
            this.f30262a = unifiedVivoExitFloatExtraAdListener;
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdClick(int i2) {
            UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener = this.f30262a;
            if (unifiedVivoExitFloatExtraAdListener != null) {
                unifiedVivoExitFloatExtraAdListener.onAdClick(i2);
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdClose() {
            UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener = this.f30262a;
            if (unifiedVivoExitFloatExtraAdListener != null) {
                unifiedVivoExitFloatExtraAdListener.onAdClose();
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdFailed(VivoAdError vivoAdError) {
            UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener = this.f30262a;
            if (unifiedVivoExitFloatExtraAdListener != null) {
                unifiedVivoExitFloatExtraAdListener.onAdFailed(vivoAdError);
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdReady() {
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdShow() {
            UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener = this.f30262a;
            if (unifiedVivoExitFloatExtraAdListener != null) {
                unifiedVivoExitFloatExtraAdListener.onAdShow();
            }
        }
    }

    public static boolean hasAd() {
        return e.c().a();
    }

    public static void showAd(Activity activity, UnifiedVivoExitFloatExtraAdListener unifiedVivoExitFloatExtraAdListener) {
        if (hasAd()) {
            e.c().a(activity, new a(unifiedVivoExitFloatExtraAdListener));
        } else if (unifiedVivoExitFloatExtraAdListener != null) {
            unifiedVivoExitFloatExtraAdListener.onAdFailed(new VivoAdError(402137, "广告不可用，请重新请求"));
        }
    }
}
