package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;

/* loaded from: classes2.dex */
public final class d extends g {
    private com.kwad.components.ad.interstitial.h.a jn;
    private boolean jo;

    /* renamed from: jp */
    private com.kwad.components.ad.interstitial.g.b f11584jp;

    @NonNull
    private final KsAdVideoPlayConfig jq;
    private KsInterstitialAd.AdInteractionListener jr;
    private final com.kwad.components.core.widget.g js;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private bs mTimerHelper;

    /* renamed from: com.kwad.components.ad.interstitial.d$1 */
    public class AnonymousClass1 implements com.kwad.components.core.widget.g {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.g
        public final void k(boolean z10) {
            if (d.this.jo) {
                Activity activity = d.this.mActivity;
                com.kwad.sdk.core.c.b.Fi();
                if (activity == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                    com.kwad.sdk.core.adlog.c.i(d.this.mAdTemplate, z10 ? 2 : 1);
                    d.this.cJ();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.d$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.h.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bl() {
            d.this.getTimerHelper().Pn();
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bm() {
            d.this.getTimerHelper().Po();
        }
    }

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.js = new com.kwad.components.core.widget.g() { // from class: com.kwad.components.ad.interstitial.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.widget.g
            public final void k(boolean z10) {
                if (d.this.jo) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.Fi();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.i(d.this.mAdTemplate, z10 ? 2 : 1);
                        d.this.cJ();
                    }
                }
            }
        };
        this.jr = adInteractionListener;
        this.jq = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.da()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    private boolean cH() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        return com.kwad.sdk.core.response.b.a.cy(eb2) && !cI() && com.kwad.components.ad.interstitial.c.a.di() < com.kwad.sdk.core.response.b.a.cB(eb2);
    }

    private boolean cI() {
        return com.kwad.sdk.core.response.b.b.co(this.mAdTemplate) && com.kwad.components.ad.interstitial.d.a.dk() < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avg);
    }

    public void cJ() {
        com.kwad.components.ad.interstitial.h.a bVar = cH() ? new com.kwad.components.ad.interstitial.aggregate.b(this.mContext) : new com.kwad.components.ad.interstitial.h.c(this.mContext);
        this.jn = bVar;
        bVar.a(this.mAdResultData, this, this.jq, this.jr);
        this.AK.removeAllViews();
        this.AK.addView(this.jn);
        cK();
    }

    private void cK() {
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(this.jn, 100);
        this.f11584jp = bVar;
        bVar.a(new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.d.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bl() {
                d.this.getTimerHelper().Pn();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bm() {
                d.this.getTimerHelper().Po();
            }
        });
        this.f11584jp.uE();
    }

    @Override // com.kwad.components.core.proxy.g
    public final float cF() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup cG() {
        com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f(this.mContext);
        fVar.setOrientationChangeListener(this.js);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.Bg().Bj();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jr;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.h.a aVar = this.jn;
            if ((aVar instanceof com.kwad.components.ad.interstitial.h.c) && !((com.kwad.components.ad.interstitial.h.c) aVar).ex() && com.kwad.sdk.core.response.b.a.cT(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
            }
            h.oa();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    public final bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bs();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        h.a(getWindow());
        cJ();
        com.kwad.components.ad.interstitial.report.c.em().v(this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bG(this.mAdTemplate);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.de()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.g.b bVar = this.f11584jp;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.jo = z10;
        com.kwad.components.ad.interstitial.h.a aVar = this.jn;
        if (aVar != null) {
            if (z10) {
                aVar.cN();
            } else {
                aVar.cO();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.jr = adInteractionListener;
        com.kwad.components.ad.interstitial.h.a aVar = this.jn;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
