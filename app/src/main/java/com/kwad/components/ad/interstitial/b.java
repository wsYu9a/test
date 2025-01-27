package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.martian.ads.ad.AdConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private KsScene hE;
    private c hF;
    private d hG;

    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.interstitial.b$1 */
    final class AnonymousClass1 extends c {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onAdShow() {
            super.onAdShow();
            b.this.cg.a(b.this);
        }

        @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onPageDismiss() {
            super.onPageDismiss();
            b.this.cg.b(b.this);
        }
    }

    public b(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
        this.hE = ksScene;
        this.mAdTemplate = adTemplate;
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.cg.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.cg.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        return com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.hF == null) {
            this.hF = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onAdShow() {
                    super.onAdShow();
                    b.this.cg.a(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    b.this.cg.b(b.this);
                }
            };
        }
        this.hF.a(adInteractionListener);
        d dVar = this.hG;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.hF);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.i(adTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.b.e("StayAdHelper", "showInterstitialAd activity must not be null");
            return;
        }
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("StayAdHelper", "showInterstitialAd please init sdk first");
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        com.kwad.sdk.g.a.U(AdConfig.AdType.INTERSTITIAL, "show");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "callShow").report();
        com.kwad.components.ad.interstitial.monitor.b.cR();
        com.kwad.components.ad.interstitial.monitor.b.h(this.hE.getPosId());
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.kwai.kwai.c.sZ().aU(true);
        if (this.hG == null) {
            d dVar = new d(activity, this.mAdTemplate, ksVideoPlayConfig, this.hF);
            this.hG = dVar;
            dVar.show();
            com.kwad.components.ad.interstitial.a.b.J(activity);
        }
    }
}
