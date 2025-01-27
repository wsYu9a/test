package com.kwad.components.ad.interstitial.f;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends b {
    public static float lG = 1.3333334f;
    private static float lH = 0.749f;
    private static float lI = 0.8f;
    private static float lJ = 1.0f;
    private com.kwad.sdk.core.video.videoview.a co;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11599dh;
    private KsAutoCloseView kV;
    private c kY;
    private boolean lE;
    private KSFrameLayout lF;
    private com.kwad.sdk.core.h.d lK = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.f.d.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bl() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.kY.f11590lc && d.this.kY.jr != null) {
                d.this.kY.jr.onAdShow();
                d.this.kY.jz.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.em().a(d.this.kY.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b cX = new com.kwad.sdk.core.adlog.c.b().cX(d.this.kY.ln);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.em().y(d.this.mAdTemplate);
            }
            com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, cX);
            d.this.kV.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bm() {
            d.this.kV.setCountDownPaused(true);
        }
    };

    /* renamed from: ld */
    private c.a f11600ld;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.interstitial.f.d$1 */
    public class AnonymousClass1 implements KsAutoCloseView.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.KsAutoCloseView.a
        public final void dA() {
            d.this.o(true);
        }

        @Override // com.kwad.components.core.widget.KsAutoCloseView.a
        public final void dB() {
            d.this.o(false);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$2 */
    public class AnonymousClass2 implements com.kwad.components.ad.interstitial.h.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void a(KSFrameLayout kSFrameLayout) {
            d.this.lF = kSFrameLayout;
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dB() {
            d.this.o(false);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dC() {
            d.this.e(3, d.this.kY.kZ.eD() ? 53 : 85);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dD() {
            d.this.e(1, 39);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dE() {
            d.this.e(1, 29);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dF() {
            d.this.e(3, 85);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dG() {
            d.this.e(3, 85);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dH() {
            d.this.e(2, 53);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dI() {
            d.this.e(2, 30);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dJ() {
            d.this.e(2, 31);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dK() {
            d.this.e(2, 32);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dL() {
            d.this.e(2, 15);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dM() {
            d.this.e(2, 16);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dN() {
            d.this.e(2, 17);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void dO() {
            d.this.e(2, 35);
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void p(boolean z10) {
            if (d.this.co != null) {
                d.this.co.setVideoSoundEnable(z10);
            }
        }

        @Override // com.kwad.components.ad.interstitial.h.e
        public final void q(boolean z10) {
            d.this.lE = z10;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ boolean lM;
        final /* synthetic */ boolean lN;
        final /* synthetic */ ViewGroup lO;

        /* renamed from: com.kwad.components.ad.interstitial.f.d$3$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (d.this.co != null) {
                    d.this.co.requestLayout();
                }
            }
        }

        public AnonymousClass3(boolean z10, boolean z11, ViewGroup viewGroup) {
            NS = z10;
            aW = z11;
            viewGroup = viewGroup;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ViewGroup.LayoutParams a10 = NS ? d.a(d.this.getRootView().getWidth(), aW) : d.B(d.this.getRootView().getHeight());
            ViewParent parent = d.this.kY.kZ.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(d.this.kY.kZ);
            }
            viewGroup.addView(d.this.kY.kZ);
            d.this.kY.kZ.f(a10.width, a10.height);
            viewGroup.requestLayout();
            viewGroup.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (d.this.co != null) {
                        d.this.co.requestLayout();
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$4 */
    public class AnonymousClass4 implements c.a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.interstitial.f.c.a
        public final void b(long j10, long j11) {
            com.kwad.components.ad.interstitial.report.a.ei().b(d.this.mAdTemplate, j10, j11);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$5 */
    public class AnonymousClass5 extends com.kwad.sdk.core.h.d {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bl() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.kY.f11590lc && d.this.kY.jr != null) {
                d.this.kY.jr.onAdShow();
                d.this.kY.jz.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.em().a(d.this.kY.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b cX = new com.kwad.sdk.core.adlog.c.b().cX(d.this.kY.ln);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.em().y(d.this.mAdTemplate);
            }
            com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, cX);
            d.this.kV.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bm() {
            d.this.kV.setCountDownPaused(true);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$6 */
    public class AnonymousClass6 implements a.c {
        final /* synthetic */ int lQ;
        final /* synthetic */ com.kwad.components.ad.interstitial.h.d lR;

        public AnonymousClass6(int i10, com.kwad.components.ad.interstitial.h.d dVar) {
            L = i10;
            dVar = dVar;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            dVar.c(false, false);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            d.this.co.setVisibility(8);
            if (d.this.kY.L(d.this.getContext())) {
                return;
            }
            dVar.eB();
        }

        @Override // com.kwad.components.core.video.a.c
        @SuppressLint({"SetTextI18n"})
        public final void d(long j10) {
            int i10 = L - ((int) (j10 / 1000));
            if (i10 >= 0) {
                dVar.x(String.valueOf(i10));
            } else {
                dVar.ez();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            dVar.u(true);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.d$7 */
    public class AnonymousClass7 implements c.InterfaceC0383c {
        final /* synthetic */ com.kwad.components.ad.interstitial.h.d lR;

        public AnonymousClass7(com.kwad.components.ad.interstitial.h.d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.components.ad.interstitial.f.c.InterfaceC0383c
        public final void dv() {
            dVar.eC();
            d.this.co.setVisibility(0);
        }
    }

    public static ViewGroup.LayoutParams B(int i10) {
        int i11 = (int) (i10 * lH);
        return new ViewGroup.LayoutParams((int) (i11 / 0.749f), i11);
    }

    private c.a dx() {
        AnonymousClass4 anonymousClass4 = new c.a() { // from class: com.kwad.components.ad.interstitial.f.d.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.ad.interstitial.f.c.a
            public final void b(long j10, long j11) {
                com.kwad.components.ad.interstitial.report.a.ei().b(d.this.mAdTemplate, j10, j11);
            }
        };
        this.f11600ld = anonymousClass4;
        return anonymousClass4;
    }

    private void dy() {
        com.kwad.components.ad.interstitial.h.d dVar = this.kY.kZ;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.u(false);
        } else {
            dVar.u(true);
            String url = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                dVar.c(false, false);
            } else {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.kY.co;
            this.co = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.co.getParent()).removeView(this.co);
            }
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).width, this.co);
            }
            dVar.v(this.kY.bS.isVideoSoundEnable());
            this.kY.a(new a.c() { // from class: com.kwad.components.ad.interstitial.f.d.6
                final /* synthetic */ int lQ;
                final /* synthetic */ com.kwad.components.ad.interstitial.h.d lR;

                public AnonymousClass6(int i10, com.kwad.components.ad.interstitial.h.d dVar2) {
                    L = i10;
                    dVar = dVar2;
                }

                @Override // com.kwad.components.core.video.a.c
                public final void ap() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void aq() {
                    d.this.co.setVisibility(8);
                    if (d.this.kY.L(d.this.getContext())) {
                        return;
                    }
                    dVar.eB();
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void d(long j10) {
                    int i10 = L - ((int) (j10 / 1000));
                    if (i10 >= 0) {
                        dVar.x(String.valueOf(i10));
                    } else {
                        dVar.ez();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.u(true);
                }
            });
            dVar2.a(this.mAdTemplate, this.mAdInfo);
            dVar2.u(true);
            this.kY.f11596li.add(new c.InterfaceC0383c() { // from class: com.kwad.components.ad.interstitial.f.d.7
                final /* synthetic */ com.kwad.components.ad.interstitial.h.d lR;

                public AnonymousClass7(com.kwad.components.ad.interstitial.h.d dVar2) {
                    dVar = dVar2;
                }

                @Override // com.kwad.components.ad.interstitial.f.c.InterfaceC0383c
                public final void dv() {
                    dVar.eC();
                    d.this.co.setVisibility(0);
                }
            });
        }
        this.kY.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar2.getBlurBgView());
        String O = com.kwad.sdk.core.response.b.a.O(this.mAdInfo);
        if (TextUtils.isEmpty(O)) {
            O = com.kwad.sdk.core.response.b.a.X(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar2.getTailFrameView(), O, this.mAdTemplate);
        if (!c(this.mAdInfo)) {
            this.kV.aZ(false);
        } else {
            this.kV.aZ(true);
            dz();
        }
    }

    private void dz() {
        AdInfo adInfo = this.mAdInfo;
        int i10 = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            i10 = Math.min(i10, com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
            this.kY.kZ.ez();
            this.kY.kZ.eA();
        }
        this.kV.V(i10);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    public void o(boolean z10) {
        c cVar = this.kY;
        if (!cVar.f11590lc && !z10 && !cVar.f11588la && !cVar.f11589lb && com.kwad.components.ad.interstitial.g.a.d(cVar)) {
            this.kY.f11589lb = true;
            com.kwad.components.ad.interstitial.c.b.J(getContext());
            return;
        }
        this.kY.a(z10, -1, this.co);
        this.kY.jz.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar != null) {
            aVar.release();
        }
        this.kY.X();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) Lj();
        this.kY = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.em().x(this.kY.mAdTemplate);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.kY.mAdTemplate);
        this.mAdInfo = eb2;
        int i10 = com.kwad.sdk.core.response.b.a.aX(eb2).width;
        if (i10 > 0) {
            lG = r0.height / i10;
        }
        this.kY.f11594lg.setBackgroundColor(Color.parseColor("#99000000"));
        this.kY.kZ.setVisibility(0);
        this.kY.kZ.C(this.mAdTemplate);
        this.kY.a(dx());
        dy();
        this.kY.kZ.setViewListener(new com.kwad.components.ad.interstitial.h.e() { // from class: com.kwad.components.ad.interstitial.f.d.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.lF = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dB() {
                d.this.o(false);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dC() {
                d.this.e(3, d.this.kY.kZ.eD() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dD() {
                d.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dE() {
                d.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dF() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dG() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dH() {
                d.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dI() {
                d.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dJ() {
                d.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dK() {
                d.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dL() {
                d.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dM() {
                d.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dN() {
                d.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void dO() {
                d.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void p(boolean z10) {
                if (d.this.co != null) {
                    d.this.co.setVideoSoundEnable(z10);
                }
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void q(boolean z10) {
                d.this.lE = z10;
            }
        });
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this.kY.kZ, 100);
        this.f11599dh = bVar;
        bVar.a(this.lK);
        this.f11599dh.uE();
        boolean aW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
        getContext();
        boolean NS = an.NS();
        this.kY.kZ.setRatio(b(NS, aW));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.d.3
            final /* synthetic */ boolean lM;
            final /* synthetic */ boolean lN;
            final /* synthetic */ ViewGroup lO;

            /* renamed from: com.kwad.components.ad.interstitial.f.d$3$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (d.this.co != null) {
                        d.this.co.requestLayout();
                    }
                }
            }

            public AnonymousClass3(boolean NS2, boolean aW2, ViewGroup viewGroup2) {
                NS = NS2;
                aW = aW2;
                viewGroup = viewGroup2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ViewGroup.LayoutParams a10 = NS ? d.a(d.this.getRootView().getWidth(), aW) : d.B(d.this.getRootView().getHeight());
                ViewParent parent = d.this.kY.kZ.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.kY.kZ);
                }
                viewGroup.addView(d.this.kY.kZ);
                d.this.kY.kZ.f(a10.width, a10.height);
                viewGroup.requestLayout();
                viewGroup.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (d.this.co != null) {
                            d.this.co.requestLayout();
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.kV = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.f.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dA() {
                d.this.o(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dB() {
                d.this.o(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.kY.b(this.f11600ld);
        com.kwad.components.core.widget.a.b bVar = this.f11599dh;
        if (bVar != null) {
            bVar.b(this.lK);
            this.f11599dh.uF();
        }
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.b.a.bJ(adInfo);
    }

    public void e(int i10, int i11) {
        this.kY.a(new c.b(getContext()).l(this.lE).a(this.lF.getTouchCoords()).z(i10).A(i11));
        if (com.kwad.components.ad.interstitial.d.b.o(this.mAdTemplate)) {
            c cVar = this.kY;
            if (cVar.jz != null) {
                cVar.a(false, -1, cVar.co);
                this.kY.jz.dismiss();
                this.kY.X();
            }
        }
    }

    private static float b(boolean z10, boolean z11) {
        if (z10 && z11) {
            return lG;
        }
        return 0.749f;
    }

    public static ViewGroup.LayoutParams a(int i10, boolean z10) {
        float f10;
        if (z10) {
            f10 = lI;
        } else {
            f10 = lJ;
        }
        int i11 = (int) (i10 * f10);
        return new ViewGroup.LayoutParams(i11, (int) (i11 * (z10 ? lG : 0.749f)));
    }
}
