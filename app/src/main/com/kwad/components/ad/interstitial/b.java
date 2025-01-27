package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c bz;

    /* renamed from: jj */
    private c f11582jj;

    /* renamed from: jk */
    private d f11583jk;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.interstitial.b$1 */
    public class AnonymousClass1 extends c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c, com.kwad.components.ad.fullscreen.h
        public final void onAdShow() {
            super.onAdShow();
            com.kwad.components.ad.interstitial.report.a.ei().q(b.this.mAdTemplate);
            b.this.bz.h(b.this);
        }

        @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onPageDismiss() {
            super.onPageDismiss();
            com.kwad.components.ad.interstitial.report.a.ei().r(b.this.mAdTemplate);
            b.this.bz.i(b.this);
        }
    }

    public b(@NonNull AdResultData adResultData) {
        super(adResultData);
        this.bz = new com.kwad.components.core.internal.api.c();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.f11582jj == null) {
            this.f11582jj = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.components.ad.fullscreen.h
                public final void onAdShow() {
                    super.onAdShow();
                    com.kwad.components.ad.interstitial.report.a.ei().q(b.this.mAdTemplate);
                    b.this.bz.h(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    com.kwad.components.ad.interstitial.report.a.ei().r(b.this.mAdTemplate);
                    b.this.bz.i(b.this);
                }
            };
        }
        this.f11582jj.a(adInteractionListener);
        d dVar = this.f11583jk;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.f11582jj);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.interstitial.report.c.em().t(this.mAdTemplate);
        if (com.kwad.sdk.core.config.d.CZ() && (activity == null || activity.isFinishing())) {
            com.kwad.sdk.core.c.b.Fi();
            activity = com.kwad.sdk.core.c.b.getCurrentActivity();
        }
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd activity must not be null");
            com.kwad.components.ad.interstitial.report.realtime.a.eq();
            com.kwad.components.ad.interstitial.report.realtime.a.B(this.mAdTemplate);
            com.kwad.components.ad.interstitial.report.c em = com.kwad.components.ad.interstitial.report.c.em();
            AdTemplate adTemplate = this.mAdTemplate;
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azG;
            em.a(adTemplate, eVar.errorCode, eVar.msg);
            return;
        }
        if (!l.At().zE()) {
            com.kwad.components.ad.interstitial.report.c em2 = com.kwad.components.ad.interstitial.report.c.em();
            AdTemplate adTemplate2 = this.mAdTemplate;
            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azH;
            em2.a(adTemplate2, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd please init sdk first");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.a.a.c.Bg().bk(true);
        if (this.f11583jk == null) {
            try {
                d dVar = new d(activity, this.mAdResultData, ksVideoPlayConfig, this.f11582jj);
                this.f11583jk = dVar;
                dVar.show();
                com.kwad.components.ad.interstitial.c.b.I(activity);
            } catch (Throwable th2) {
                com.kwad.components.ad.interstitial.report.realtime.a.eq();
                com.kwad.components.ad.interstitial.report.realtime.a.a(th2.getMessage(), this.mAdTemplate);
            }
            com.kwad.components.ad.interstitial.report.c.em().u(this.mAdTemplate);
        }
    }
}
