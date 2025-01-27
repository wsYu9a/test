package com.vivo.mobilead.unified.base.h;

import com.vivo.mobilead.unified.banner.UnifiedVivoBannerAdListener;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.exitFloat.d;
import com.vivo.mobilead.unified.icon.UnifiedVivoFloatIconAdListener;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.util.z;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.vivo.mobilead.unified.base.h.a$a */
    static class C0617a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ UnifiedVivoFloatIconAdListener f29810a;

        /* renamed from: b */
        final /* synthetic */ VivoAdError f29811b;

        C0617a(UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener, VivoAdError vivoAdError) {
            this.f29810a = unifiedVivoFloatIconAdListener;
            this.f29811b = vivoAdError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f29810a.onAdFailed(this.f29811b);
        }
    }

    static class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ UnifiedVivoNativeExpressAdListener f29812a;

        /* renamed from: b */
        final /* synthetic */ VivoAdError f29813b;

        b(UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener, VivoAdError vivoAdError) {
            this.f29812a = unifiedVivoNativeExpressAdListener;
            this.f29813b = vivoAdError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f29812a.onAdFailed(this.f29813b);
        }
    }

    static class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ d f29814a;

        /* renamed from: b */
        final /* synthetic */ VivoAdError f29815b;

        c(d dVar, VivoAdError vivoAdError) {
            this.f29814a = dVar;
            this.f29815b = vivoAdError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f29814a.onAdFailed(this.f29815b);
        }
    }

    public static void a(UnifiedVivoBannerAdListener unifiedVivoBannerAdListener, VivoAdError vivoAdError) {
        if (unifiedVivoBannerAdListener == null || vivoAdError == null) {
            return;
        }
        unifiedVivoBannerAdListener.onAdFailed(vivoAdError);
    }

    public static void a(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener, VivoAdError vivoAdError) {
        if (unifiedVivoRewardVideoAdListener == null || vivoAdError == null) {
            return;
        }
        unifiedVivoRewardVideoAdListener.onAdFailed(vivoAdError);
    }

    public static void a(UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener, VivoAdError vivoAdError) {
        if (unifiedVivoInterstitialAdListener == null || vivoAdError == null) {
            return;
        }
        unifiedVivoInterstitialAdListener.onAdFailed(vivoAdError);
    }

    public static void a(UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener, VivoAdError vivoAdError) {
        if (unifiedVivoFloatIconAdListener == null || vivoAdError == null) {
            return;
        }
        z.b().a(new C0617a(unifiedVivoFloatIconAdListener, vivoAdError));
    }

    public static void a(UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener, VivoAdError vivoAdError) {
        if (unifiedVivoNativeExpressAdListener == null || vivoAdError == null) {
            return;
        }
        z.b().a(new b(unifiedVivoNativeExpressAdListener, vivoAdError));
    }

    public static void a(d dVar, VivoAdError vivoAdError) {
        if (dVar == null || vivoAdError == null) {
            return;
        }
        z.b().a(new c(dVar, vivoAdError));
    }
}
