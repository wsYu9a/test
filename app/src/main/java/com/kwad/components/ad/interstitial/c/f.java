package com.kwad.components.ad.interstitial.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f extends b {
    private com.kwad.sdk.core.video.videoview.a eN;
    private KsAutoCloseView jq;
    private c jt;
    private boolean kX;
    private KSFrameLayout kY;
    private com.kwad.sdk.core.g.d kZ = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.f.4
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            f.this.jq.setCountDownPaused(true);
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            if (!f.this.mAdTemplate.mPvReported && !f.this.jt.jy && f.this.jt.hN != null) {
                f.this.jt.hN.onAdShow();
                f.this.jt.hU.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.b(f.this.jt.mAdTemplate, 1);
            }
            com.kwad.components.core.r.b.pK().a(f.this.mAdTemplate, null, new com.kwad.sdk.core.report.i().bs(f.this.jt.jI));
            f.this.jq.setCountDownPaused(false);
        }
    };
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;

    /* renamed from: com.kwad.components.ad.interstitial.c.f$1 */
    final class AnonymousClass1 implements KsAutoCloseView.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.KsAutoCloseView.a
        public final void dO() {
            f.this.n(true);
        }

        @Override // com.kwad.components.core.widget.KsAutoCloseView.a
        public final void dP() {
            f.this.n(false);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.f$2 */
    final class AnonymousClass2 implements c.e {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.interstitial.c.c.e
        public final void onError() {
            f.this.dM();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.f$3 */
    final class AnonymousClass3 implements com.kwad.components.ad.interstitial.e.i {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void a(KSFrameLayout kSFrameLayout) {
            f.this.kY = kSFrameLayout;
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dP() {
            f.this.n(false);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dQ() {
            f.this.e(3, f.this.jt.ju.eE() ? 53 : 85);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dR() {
            f.this.e(1, 39);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dS() {
            f.this.e(1, 29);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dT() {
            f.this.e(3, 85);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dU() {
            f.this.e(3, 85);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dV() {
            f.this.e(2, 53);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dW() {
            f.this.e(2, 30);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dX() {
            f.this.e(2, 31);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dY() {
            f.this.e(2, 32);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void dZ() {
            f.this.e(2, 15);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void ea() {
            f.this.e(2, 16);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void eb() {
            f.this.e(2, 17);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void ec() {
            f.this.e(2, 35);
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void o(boolean z) {
            if (f.this.eN != null) {
                f.this.eN.setVideoSoundEnable(z);
            }
        }

        @Override // com.kwad.components.ad.interstitial.e.i
        public final void p(boolean z) {
            f.this.kX = z;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.f$4 */
    final class AnonymousClass4 extends com.kwad.sdk.core.g.d {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            f.this.jq.setCountDownPaused(true);
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            if (!f.this.mAdTemplate.mPvReported && !f.this.jt.jy && f.this.jt.hN != null) {
                f.this.jt.hN.onAdShow();
                f.this.jt.hU.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.b(f.this.jt.mAdTemplate, 1);
            }
            com.kwad.components.core.r.b.pK().a(f.this.mAdTemplate, null, new com.kwad.sdk.core.report.i().bs(f.this.jt.jI));
            f.this.jq.setCountDownPaused(false);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.f$5 */
    final class AnonymousClass5 implements a.c {
        final /* synthetic */ int lb;
        final /* synthetic */ com.kwad.components.ad.interstitial.e.f lc;

        AnonymousClass5(int i2, com.kwad.components.ad.interstitial.e.f fVar) {
            F = i2;
            fVar = fVar;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            f.this.eN.setVisibility(8);
            if (f.this.jt.M(f.this.getContext())) {
                return;
            }
            fVar.eC();
        }

        @Override // com.kwad.components.core.video.a.c
        @SuppressLint({"SetTextI18n"})
        public final void d(long j2) {
            int i2 = F - ((int) (j2 / 1000));
            com.kwad.components.ad.interstitial.e.f fVar = fVar;
            if (i2 >= 0) {
                fVar.C(String.valueOf(i2));
            } else {
                fVar.eA();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            fVar.t(true);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            fVar.b(false, false);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.f$6 */
    final class AnonymousClass6 implements c.InterfaceC0137c {
        final /* synthetic */ com.kwad.components.ad.interstitial.e.f lc;

        AnonymousClass6(com.kwad.components.ad.interstitial.e.f fVar) {
            fVar = fVar;
        }

        @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
        public final void dg() {
            fVar.eD();
            f.this.eN.setVisibility(0);
        }
    }

    private static boolean d(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.bv(adInfo);
    }

    public void dM() {
        com.kwad.components.ad.interstitial.e.f fVar = this.jt.ju;
        fVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.aV(this.mAdInfo)) {
            fVar.a(com.kwad.sdk.core.response.a.a.aM(this.mAdInfo).materialUrl, this.mAdTemplate);
            fVar.b(true, true);
            fVar.t(false);
        } else {
            fVar.t(true);
            String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                fVar.b(false, false);
            } else {
                fVar.a(url, this.mAdTemplate);
                fVar.b(true, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.jt.eN;
            this.eN = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            }
            if (com.kwad.sdk.core.response.a.a.aU(this.mAdInfo)) {
                fVar.a(com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).height / com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).width, this.eN);
            }
            fVar.u(this.jt.dZ.isVideoSoundEnable());
            this.jt.a(new a.c() { // from class: com.kwad.components.ad.interstitial.c.f.5
                final /* synthetic */ int lb;
                final /* synthetic */ com.kwad.components.ad.interstitial.e.f lc;

                AnonymousClass5(int i2, com.kwad.components.ad.interstitial.e.f fVar2) {
                    F = i2;
                    fVar = fVar2;
                }

                @Override // com.kwad.components.core.video.a.c
                public final void bt() {
                    f.this.eN.setVisibility(8);
                    if (f.this.jt.M(f.this.getContext())) {
                        return;
                    }
                    fVar.eC();
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void d(long j2) {
                    int i2 = F - ((int) (j2 / 1000));
                    com.kwad.components.ad.interstitial.e.f fVar2 = fVar;
                    if (i2 >= 0) {
                        fVar2.C(String.valueOf(i2));
                    } else {
                        fVar2.eA();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    fVar.t(true);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlaying() {
                    fVar.b(false, false);
                }
            });
            fVar2.a(this.mAdTemplate, this.mAdInfo);
            fVar2.t(true);
            this.jt.jE.add(new c.InterfaceC0137c() { // from class: com.kwad.components.ad.interstitial.c.f.6
                final /* synthetic */ com.kwad.components.ad.interstitial.e.f lc;

                AnonymousClass6(com.kwad.components.ad.interstitial.e.f fVar2) {
                    fVar = fVar2;
                }

                @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
                public final void dg() {
                    fVar.eD();
                    f.this.eN.setVisibility(0);
                }
            });
        }
        this.jt.a(getContext(), this.mAdInfo, this.mAdTemplate, fVar2.getBlurBgView());
        String H = com.kwad.sdk.core.response.a.a.H(this.mAdInfo);
        if (TextUtils.isEmpty(H)) {
            H = com.kwad.sdk.core.response.a.a.O(this.mAdInfo);
        }
        KSImageLoader.loadImage(fVar2.getTailFrameView(), H, this.mAdTemplate);
        if (!d(this.mAdInfo)) {
            this.jq.aS(false);
        } else {
            this.jq.aS(true);
            dN();
        }
    }

    private void dN() {
        AdInfo adInfo = this.mAdInfo;
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            i2 = Math.min(i2, com.kwad.sdk.core.response.a.a.F(this.mAdInfo));
            this.jt.ju.eA();
            this.jt.ju.eB();
        }
        this.jq.Y(i2);
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    public void e(int i2, int i3) {
        this.jt.a(new c.b(getContext()).k(this.kX).a(this.kY.getTouchCoords()).C(i2).D(i3));
        if (com.kwad.components.ad.interstitial.kwai.b.cN()) {
            c cVar = this.jt;
            if (cVar.hU != null) {
                cVar.a(false, -1, cVar.eN);
                this.jt.hU.dismiss();
            }
        }
    }

    public void n(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.jt;
        if (!cVar.jy && !z && !cVar.jw && !cVar.jx && com.kwad.components.ad.interstitial.d.a.c(cVar)) {
            this.jt.jx = true;
            com.kwad.components.ad.interstitial.a.b.K(getContext());
            return;
        }
        this.jt.a(z, -1, this.eN);
        this.jt.hU.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            aVar.release();
        }
        c cVar2 = this.jt;
        if (cVar2.jy || (adInteractionListener = cVar2.hN) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.jt.ju.j(this.mAdTemplate);
        this.jt.a(new c.e() { // from class: com.kwad.components.ad.interstitial.c.f.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.interstitial.c.c.e
            public final void onError() {
                f.this.dM();
            }
        });
        this.jt.ju.setViewListener(new com.kwad.components.ad.interstitial.e.i() { // from class: com.kwad.components.ad.interstitial.c.f.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void a(KSFrameLayout kSFrameLayout) {
                f.this.kY = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dP() {
                f.this.n(false);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dQ() {
                f.this.e(3, f.this.jt.ju.eE() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dR() {
                f.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dS() {
                f.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dT() {
                f.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dU() {
                f.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dV() {
                f.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dW() {
                f.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dX() {
                f.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dY() {
                f.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dZ() {
                f.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void ea() {
                f.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void eb() {
                f.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void ec() {
                f.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void o(boolean z) {
                if (f.this.eN != null) {
                    f.this.eN.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void p(boolean z) {
                f.this.kX = z;
            }
        });
        com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this.jt.ju, 100);
        this.mViewVisibleHelper = bVar;
        bVar.a(this.kZ);
        this.mViewVisibleHelper.rD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.jq = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.c.f.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dO() {
                f.this.n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dP() {
                f.this.n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mViewVisibleHelper.b(this.kZ);
        this.mViewVisibleHelper.rE();
    }
}
