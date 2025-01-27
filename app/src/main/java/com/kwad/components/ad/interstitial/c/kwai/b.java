package com.kwad.components.ad.interstitial.c.kwai;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.c.h;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.y;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.f;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.g;
import com.kwad.components.core.webview.a.kwai.n;
import com.kwad.components.core.webview.a.kwai.q;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.File;

/* loaded from: classes.dex */
public final class b extends a {
    private static long ka = 400;
    private d ef;
    private Vibrator eg;
    private an fC;

    @Nullable
    private com.kwad.components.ad.f.kwai.kwai.b km;
    private FrameLayout lE;
    private boolean lG;
    private f lH;
    private boolean lF = false;
    private final c.a jz = new c.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            if (b.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = b.this.jt.jw ? 1 : 0;
                b.this.lH.b(aVar);
            }
        }
    };
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.10
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            b.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            b.this.dk.onPageInvisible();
        }
    };
    private com.kwad.sdk.core.g.c dk = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.11
        AnonymousClass11() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            if (b.this.fC != null) {
                b.this.fC.re();
            }
            if (b.this.km != null) {
                b.this.km.fd();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            if (b.this.fC != null && !b.this.lF) {
                b.a(b.this, true);
                b.this.fC.qZ();
                b.this.fC.ra();
            }
            if (b.this.fC != null) {
                b.this.fC.rd();
            }
            if (b.this.km != null) {
                b.this.km.fe();
            }
            if (!b.this.lG) {
                b.this.jt.hU.getTimerHelper().startTiming();
            }
            if (b.this.lG || b.this.jt.jy || b.this.jt.hN == null) {
                return;
            }
            b.this.jt.hN.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(b.this.jt.mAdTemplate, 3);
            b.b(b.this, true);
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$1 */
    final class AnonymousClass1 implements c.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            if (b.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = b.this.jt.jw ? 1 : 0;
                b.this.lH.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$10 */
    final class AnonymousClass10 implements h {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            b.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            b.this.dk.onPageInvisible();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$11 */
    final class AnonymousClass11 extends com.kwad.sdk.core.g.d {
        AnonymousClass11() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            if (b.this.fC != null) {
                b.this.fC.re();
            }
            if (b.this.km != null) {
                b.this.km.fd();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            if (b.this.fC != null && !b.this.lF) {
                b.a(b.this, true);
                b.this.fC.qZ();
                b.this.fC.ra();
            }
            if (b.this.fC != null) {
                b.this.fC.rd();
            }
            if (b.this.km != null) {
                b.this.km.fe();
            }
            if (!b.this.lG) {
                b.this.jt.hU.getTimerHelper().startTiming();
            }
            if (b.this.lG || b.this.jt.jy || b.this.jt.hN == null) {
                return;
            }
            b.this.jt.hN.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(b.this.jt.mAdTemplate, 3);
            b.b(b.this, true);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$12 */
    final class AnonymousClass12 implements b.InterfaceC0125b {
        AnonymousClass12() {
        }

        @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0125b
        public final void G(int i2) {
            if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                b.this.jt.b(b.this.getContext(), b.this.jt.mAdTemplate);
                b bVar = b.this;
                bVar.b(bVar.jt.mAdTemplate, true);
            }
            b.this.dx();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$13 */
    final class AnonymousClass13 implements ap.a {
        AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void bJ() {
            b.this.bB();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$14 */
    final class AnonymousClass14 extends q {
        AnonymousClass14() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.r.h.g(b.this.getContext(), b.this.jt.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$15 */
    final class AnonymousClass15 implements b.a {
        AnonymousClass15() {
        }

        @Override // com.kwad.components.core.webview.a.b.a
        public final void es() {
            com.kwad.components.ad.interstitial.b.a.L(b.this.getContext());
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$16 */
    final class AnonymousClass16 extends com.kwad.components.core.webview.a.c {
        AnonymousClass16() {
        }

        @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
            cVar2.UX = com.kwad.components.ad.interstitial.b.a.cQ();
            cVar.a(cVar2);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$17 */
    final class AnonymousClass17 extends f {
        AnonymousClass17() {
        }

        @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
            aVar.UV = b.this.jt.jw ? 1 : 0;
            cVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$2 */
    final class AnonymousClass2 implements c.InterfaceC0137c {
        final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a ks;

        AnonymousClass2(com.kwad.components.ad.f.kwai.kwai.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
        public final void dg() {
            aVar.fb();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$3 */
    final class AnonymousClass3 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar != null) {
                if (!b.this.jt.jy && b.this.jt.hN != null) {
                    b.this.jt.hN.onAdClicked();
                }
                b.this.jt.jw = true;
                if (!b.this.jt.jy) {
                    b.this.jt.cr();
                }
                if (b.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                    return;
                }
                b.this.jt.a(false, -1, b.this.jt.eN);
                b.this.jt.hU.dismiss();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$4 */
    final class AnonymousClass4 implements aw.a {

        /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$4$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.dx();
            }
        }

        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aw.a
        public final boolean dC() {
            com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jt.mAdTemplate);
            b.this.jt.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.dx();
                }
            }, 0L);
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$5 */
    final class AnonymousClass5 extends n {

        /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$5$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

            AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar) {
                cVar = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                dVar.UY = ag.isWifiConnected(b.this.getContext()) || b.this.jt.dZ.isDataFlowAutoStart() || b.i(b.this.jt.mAdTemplate);
                cVar.a(dVar);
            }
        }

        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5.1
                final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

                AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar2) {
                    cVar = cVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                    dVar.UY = ag.isWifiConnected(b.this.getContext()) || b.this.jt.dZ.isDataFlowAutoStart() || b.i(b.this.jt.mAdTemplate);
                    cVar.a(dVar);
                }
            }, 0L);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$6 */
    final class AnonymousClass6 implements aa.b {

        /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$6$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ aa.a kv;

            AnonymousClass1(aa.a aVar) {
                aVar = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (aVar.type == 0 && !b.this.jt.jw && !b.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(b.this.jt)) {
                    b.this.jt.jx = true;
                    com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                    return;
                }
                b.this.er();
                c cVar = b.this.jt;
                aa.a aVar = aVar;
                cVar.a(aVar.type == 3, aVar.Tm, (com.kwad.sdk.core.video.videoview.a) null);
                b.this.dx();
            }
        }

        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            if (b.this.jt.hU != null) {
                b.this.jt.jC.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6.1
                    final /* synthetic */ aa.a kv;

                    AnonymousClass1(aa.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (aVar.type == 0 && !b.this.jt.jw && !b.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(b.this.jt)) {
                            b.this.jt.jx = true;
                            com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                            return;
                        }
                        b.this.er();
                        c cVar = b.this.jt;
                        aa.a aVar2 = aVar;
                        cVar.a(aVar2.type == 3, aVar2.Tm, (com.kwad.sdk.core.video.videoview.a) null);
                        b.this.dx();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$7 */
    final class AnonymousClass7 extends com.kwad.components.core.webview.jshandler.n {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void a(y yVar) {
            super.a(yVar);
            if (b.this.jt.jy || b.this.jt.hN == null) {
                return;
            }
            b.this.jt.hN.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void b(y yVar) {
            super.b(yVar);
            b.this.jt.mAdTemplate.setmCurPlayTime(yVar.nZ);
        }

        @Override // com.kwad.components.core.webview.jshandler.n
        public final void c(y yVar) {
            super.c(yVar);
            if (b.this.jt.jy || b.this.jt.hN == null) {
                return;
            }
            b.this.jt.hN.onVideoPlayEnd();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$8 */
    final class AnonymousClass8 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$8$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.ef.xD();
            }
        }

        AnonymousClass8() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d2) {
            if (bl.o(b.this.getTKContainer(), 100)) {
                b.this.d(d2);
            }
            bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.ef.xD();
                }
            }, null, 500L);
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bd() {
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$9 */
    final class AnonymousClass9 implements ag.a {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.a
        public final void a(com.kwad.components.core.webview.kwai.b bVar) {
            AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(b.this.jt.mAdTemplate).oc());
        }
    }

    @NonNull
    private p a(com.kwad.sdk.core.webview.b bVar) {
        return new p(bVar, this.jt.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!b.this.jt.jy && b.this.jt.hN != null) {
                        b.this.jt.hN.onAdClicked();
                    }
                    b.this.jt.jw = true;
                    if (!b.this.jt.jy) {
                        b.this.jt.cr();
                    }
                    if (b.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    b.this.jt.a(false, -1, b.this.jt.eN);
                    b.this.jt.hU.dismiss();
                }
            }
        });
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.lF = true;
        return true;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.lG = true;
        return true;
    }

    public void bB() {
        if (getContext() != null) {
            this.eg = (Vibrator) getContext().getSystemService("vibrator");
        }
        float bt = com.kwad.sdk.core.response.a.b.bt(this.jt.mAdTemplate);
        if (this.ef == null) {
            d dVar = new d(bt);
            this.ef = dVar;
            dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8

                /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$8$1 */
                final class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.ef.xD();
                    }
                }

                AnonymousClass8() {
                }

                @Override // com.kwad.sdk.core.f.b
                public final void a(double d2) {
                    if (bl.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d2);
                    }
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.ef.xD();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.f.b
                public final void bd() {
                }
            });
        }
        this.ef.e(bt);
        this.ef.aX(getContext());
    }

    public void d(double d2) {
        this.jt.a(new c.b(getContext()).l(true).c(d2).C(2).a(this.jt.jC.getTouchCoords()).D(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META));
        bi.vibrate(getContext(), this.eg, ka);
    }

    private g dl() {
        k kVar = new k();
        kVar.Vc = this.jt.jI;
        return new g(kVar);
    }

    /* renamed from: do */
    private com.kwad.components.ad.f.kwai.kwai.a m56do() {
        com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jt.jE.add(new c.InterfaceC0137c() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.2
            final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a ks;

            AnonymousClass2(com.kwad.components.ad.f.kwai.kwai.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar2;
    }

    private aw du() {
        aw awVar = new aw(getContext(), this.jt.mAdTemplate);
        awVar.a(new aw.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4

            /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$4$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.dx();
                }
            }

            AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aw.a
            public final boolean dC() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jt.mAdTemplate);
                b.this.jt.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dx();
                    }
                }, 0L);
                return false;
            }
        });
        return awVar;
    }

    @NonNull
    private aa dv() {
        return new aa(new aa.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6

            /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$6$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ aa.a kv;

                AnonymousClass1(aa.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (aVar.type == 0 && !b.this.jt.jw && !b.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(b.this.jt)) {
                        b.this.jt.jx = true;
                        com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                        return;
                    }
                    b.this.er();
                    c cVar = b.this.jt;
                    aa.a aVar2 = aVar;
                    cVar.a(aVar2.type == 3, aVar2.Tm, (com.kwad.sdk.core.video.videoview.a) null);
                    b.this.dx();
                }
            }

            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aa.b
            public final void a(aa.a aVar2) {
                if (b.this.jt.hU != null) {
                    b.this.jt.jC.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6.1
                        final /* synthetic */ aa.a kv;

                        AnonymousClass1(aa.a aVar22) {
                            aVar = aVar22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (aVar.type == 0 && !b.this.jt.jw && !b.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(b.this.jt)) {
                                b.this.jt.jx = true;
                                com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                                return;
                            }
                            b.this.er();
                            c cVar = b.this.jt;
                            aa.a aVar22 = aVar;
                            cVar.a(aVar22.type == 3, aVar22.Tm, (com.kwad.sdk.core.video.videoview.a) null);
                            b.this.dx();
                        }
                    });
                }
            }
        });
    }

    public void dx() {
        c cVar = this.jt;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.hU;
        if (dVar != null && a(dVar)) {
            this.jt.hU.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jt.hN;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.16
            AnonymousClass16() {
            }

            @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UX = com.kwad.components.ad.interstitial.b.a.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private f eo() {
        return new f() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.17
            AnonymousClass17() {
            }

            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = b.this.jt.jw ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @NonNull
    private n ep() {
        return new n() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5

            /* renamed from: com.kwad.components.ad.interstitial.c.kwai.b$5$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

                AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar2) {
                    cVar = cVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                    dVar.UY = com.kwad.sdk.utils.ag.isWifiConnected(b.this.getContext()) || b.this.jt.dZ.isDataFlowAutoStart() || b.i(b.this.jt.mAdTemplate);
                    cVar.a(dVar);
                }
            }

            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar2) {
                super.handleJsCall(str, cVar2);
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5.1
                    final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

                    AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar22) {
                        cVar = cVar22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                        dVar.UY = com.kwad.sdk.utils.ag.isWifiConnected(b.this.getContext()) || b.this.jt.dZ.isDataFlowAutoStart() || b.i(b.this.jt.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    private com.kwad.components.core.webview.jshandler.n eq() {
        return new com.kwad.components.core.webview.jshandler.n() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(y yVar) {
                super.a(yVar);
                if (b.this.jt.jy || b.this.jt.hN == null) {
                    return;
                }
                b.this.jt.hN.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void b(y yVar) {
                super.b(yVar);
                b.this.jt.mAdTemplate.setmCurPlayTime(yVar.nZ);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void c(y yVar) {
                super.c(yVar);
                if (b.this.jt.jy || b.this.jt.hN == null) {
                    return;
                }
                b.this.jt.hN.onVideoPlayEnd();
            }
        };
    }

    public void er() {
        an anVar = this.fC;
        if (anVar != null) {
            anVar.rb();
            this.fC.rc();
        }
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fd();
        }
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.9
            AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(b.this.jt.mAdTemplate).oc());
            }
        };
    }

    public static boolean i(@NonNull AdTemplate adTemplate) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return aX != null && aX.exists();
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jt.a(this.ko);
    }

    public final void b(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.report.a.a(adTemplate, 14, -1L, -1, this.jt.hU.getTimerHelper().getTime(), null);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-interstitial-card", this.jt.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.lE = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.fC = anVar;
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        com.kwad.components.ad.f.kwai.kwai.b k = com.kwad.components.ad.f.kwai.kwai.b.k(this.jt.mAdTemplate);
        this.km = k;
        if (k != null) {
            k.a(new b.InterfaceC0125b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.12
                AnonymousClass12() {
                }

                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0125b
                public final void G(int i2) {
                    if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                        b.this.jt.b(b.this.getContext(), b.this.jt.mAdTemplate);
                        b bVar2 = b.this;
                        bVar2.b(bVar2.jt.mAdTemplate, true);
                    }
                    b.this.dx();
                }
            });
            lVar.c(this.km);
            this.km.fc();
        }
        lVar.c(dv());
        lVar.c(new com.kwad.components.core.webview.jshandler.ag(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cS(com.kwad.sdk.core.response.a.d.cb(this.jt.mAdTemplate))) {
            lVar.c(new ap(new ap.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.13
                AnonymousClass13() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ap.a
                public final void bJ() {
                    b.this.bB();
                }
            }));
        }
        lVar.c(ep());
        lVar.c(du());
        lVar.c(dl());
        lVar.c(a(bVar));
        lVar.c(eq());
        lVar.c(m56do());
        lVar.c(new q() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.14
            AnonymousClass14() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.r.h.g(b.this.getContext(), b.this.jt.mAdTemplate);
            }
        });
        this.lH = eo();
        this.jt.a(this.jz);
        lVar.c(this.lH);
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.15
            AnonymousClass15() {
            }

            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.interstitial.b.a.L(b.this.getContext());
            }
        }));
        lVar.c(en());
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
        super.onSkipClick(uVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.jt.hN;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        this.lE.setVisibility(8);
        e eVar = this.jt.gG;
        if (eVar != null) {
            eVar.u(getTkTemplateId());
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        if (this.fC != null && this.jt.hL.et()) {
            this.lF = true;
            this.fC.qZ();
            this.fC.ra();
        }
        this.jt.hL.a(this.dk);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.lF = false;
        this.lG = false;
        bi.b(getContext(), this.eg);
        d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        com.kwad.components.ad.interstitial.d.b bVar = this.jt.hL;
        if (bVar != null) {
            bVar.b(this.dk);
        }
        this.jt.b(this.jz);
        this.jt.b(this.ko);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        b(this.jt.mAdTemplate, true);
        dx();
    }
}
