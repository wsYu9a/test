package com.kwad.components.ad.interstitial.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.i.a.a.b;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.s.j;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.g;
import com.kwad.components.core.webview.tachikoma.a.n;
import com.kwad.components.core.webview.tachikoma.a.q;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.components.core.webview.tachikoma.e.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.File;

/* loaded from: classes2.dex */
public final class b extends a {
    private static long ms = 400;
    private FrameLayout cS;
    private d fv;
    private Vibrator fx;
    private ay gT;

    @Nullable
    private com.kwad.components.ad.i.a.a.b mr;
    private boolean mu;
    private e mv;
    private boolean mt = false;

    /* renamed from: ld */
    private final c.a f11585ld = new c.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.f.c.a
        public final void b(long j10, long j11) {
            com.kwad.components.ad.interstitial.report.a.ei().b(b.this.kY.mAdTemplate, j10, j11);
            if (b.this.mv != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = b.this.kY.f11588la ? 1 : 0;
                b.this.mv.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.h.c eu = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.9
        public AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bl() {
            if (b.this.gT != null && !b.this.mt) {
                b.a(b.this, true);
                b.this.gT.tu();
                b.this.gT.tv();
            }
            if (b.this.gT != null) {
                b.this.gT.ty();
            }
            if (b.this.mr != null) {
                b.this.mr.fb();
            }
            if (!b.this.mu) {
                b.this.kY.jz.getTimerHelper().startTiming();
            }
            if (b.this.mu || b.this.kY.f11590lc || b.this.kY.jr == null) {
                return;
            }
            b.this.kY.jr.onAdShow();
            com.kwad.components.ad.interstitial.report.c.em().a(b.this.kY.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bm() {
            if (b.this.gT != null) {
                b.this.gT.tz();
            }
            if (b.this.mr != null) {
                b.this.mr.fa();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$1 */
    public class AnonymousClass1 implements c.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.f.c.a
        public final void b(long j10, long j11) {
            com.kwad.components.ad.interstitial.report.a.ei().b(b.this.kY.mAdTemplate, j10, j11);
            if (b.this.mv != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = b.this.kY.f11588la ? 1 : 0;
                b.this.mv.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$10 */
    public class AnonymousClass10 implements b.InterfaceC0376b {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.i.a.a.b.InterfaceC0376b
        public final void E(int i10) {
            if (i10 == com.kwad.components.ad.i.a.a.b.oP) {
                b.this.kY.c(b.this.getContext(), b.this.kY.mAdTemplate);
                b.this.kY.a(true, -1, null);
            }
            b.this.dP();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$11 */
    public class AnonymousClass11 implements ba.a {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ba.a
        public final void ca() {
            b.this.bU();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$12 */
    public class AnonymousClass12 extends q {
        public AnonymousClass12() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            j.f(b.this.getContext(), b.this.kY.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$13 */
    public class AnonymousClass13 implements b.a {
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.b.a
        public final void eh() {
            com.kwad.components.ad.interstitial.d.a.K(b.this.getContext());
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$14 */
    public class AnonymousClass14 extends com.kwad.components.core.webview.tachikoma.c {
        public AnonymousClass14() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
            cVar2.adm = com.kwad.components.ad.interstitial.d.a.dk();
            cVar.a(cVar2);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$15 */
    public class AnonymousClass15 extends e {
        public AnonymousClass15() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
            aVar.adk = b.this.kY.f11588la ? 1 : 0;
            cVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$16 */
    public class AnonymousClass16 implements c.InterfaceC0383c {
        final /* synthetic */ com.kwad.components.ad.i.a.a.a mD;

        public AnonymousClass16(com.kwad.components.ad.i.a.a.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.ad.interstitial.f.c.InterfaceC0383c
        public final void dv() {
            aVar.eZ();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null) {
                com.kwad.components.ad.interstitial.report.a.ei().a(b.this.kY.mAdTemplate, aVar.aJf, aVar.lz);
                b.this.kY.f11588la = true;
                if (!b.this.kY.f11590lc) {
                    b.this.kY.b(aVar.aJf, aVar.lz);
                }
                if (b.this.kY.jz == null || !com.kwad.components.ad.interstitial.d.b.o(b.this.kY.mAdTemplate)) {
                    return;
                }
                b.this.kY.a(false, -1, b.this.kY.co);
                b.this.kY.jz.dismiss();
                b.this.kY.X();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$3 */
    public class AnonymousClass3 implements bi.a {

        /* renamed from: com.kwad.components.ad.interstitial.f.a.b$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.dP();
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.bi.a
        public final boolean eg() {
            com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.kY.mAdTemplate);
            b.this.kY.a(true, -1, null);
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.f.a.b.3.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.dP();
                }
            }, 0L);
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$4 */
    public class AnonymousClass4 extends n {

        /* renamed from: com.kwad.components.ad.interstitial.f.a.b$4$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

            public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar) {
                cVar = cVar;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                dVar.adn = al.isWifiConnected(b.this.getContext()) || b.this.kY.bS.isDataFlowAutoStart() || b.p(b.this.kY.mAdTemplate);
                cVar.a(dVar);
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.4.1
                final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

                public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                    dVar.adn = al.isWifiConnected(b.this.getContext()) || b.this.kY.bS.isDataFlowAutoStart() || b.p(b.this.kY.mAdTemplate);
                    cVar.a(dVar);
                }
            }, 0L);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$5 */
    public class AnonymousClass5 implements aj.b {

        /* renamed from: com.kwad.components.ad.interstitial.f.a.b$5$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ aj.a mA;

            public AnonymousClass1(aj.a aVar) {
                aVar = aVar;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (aVar.type == 0 && !b.this.kY.f11588la && !b.this.kY.f11589lb && com.kwad.components.ad.interstitial.g.a.d(b.this.kY)) {
                    b.this.kY.f11589lb = true;
                    com.kwad.components.ad.interstitial.c.b.J(b.this.getContext());
                    return;
                }
                b.this.ef();
                c cVar = b.this.kY;
                aj.a aVar = aVar;
                cVar.a(aVar.type == 3, aVar.aaa, null);
                b.this.dP();
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            if (b.this.kY.jz != null) {
                b.this.kY.f11594lg.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.5.1
                    final /* synthetic */ aj.a mA;

                    public AnonymousClass1(aj.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (aVar.type == 0 && !b.this.kY.f11588la && !b.this.kY.f11589lb && com.kwad.components.ad.interstitial.g.a.d(b.this.kY)) {
                            b.this.kY.f11589lb = true;
                            com.kwad.components.ad.interstitial.c.b.J(b.this.getContext());
                            return;
                        }
                        b.this.ef();
                        c cVar = b.this.kY;
                        aj.a aVar2 = aVar;
                        cVar.a(aVar2.type == 3, aVar2.aaa, null);
                        b.this.dP();
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$6 */
    public class AnonymousClass6 extends w {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void a(x xVar) {
            super.a(xVar);
            if (b.this.kY.f11590lc || b.this.kY.jr == null) {
                return;
            }
            b.this.kY.jr.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void c(x xVar) {
            super.c(xVar);
            if (b.this.kY.f11590lc || b.this.kY.jr == null) {
                return;
            }
            b.this.kY.jr.onVideoPlayEnd();
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void d(x xVar) {
            super.d(xVar);
            b.this.kY.mAdTemplate.setmCurPlayTime(xVar.oZ);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$7 */
    public class AnonymousClass7 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.interstitial.f.a.b$7$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.fv.Hb();
            }
        }

        public AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d10) {
            if (bw.o(b.this.getTKContainer(), 100)) {
                b.this.d(d10);
            }
            bt.a(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.7.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.this.fv.Hb();
                }
            }, null, 500L);
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bw() {
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$8 */
    public class AnonymousClass8 implements ap.a {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void a(com.kwad.components.core.webview.a.b bVar) {
            AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).n(b.this.kY.mAdResultData).qa());
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.a.b$9 */
    public class AnonymousClass9 extends com.kwad.sdk.core.h.d {
        public AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bl() {
            if (b.this.gT != null && !b.this.mt) {
                b.a(b.this, true);
                b.this.gT.tu();
                b.this.gT.tv();
            }
            if (b.this.gT != null) {
                b.this.gT.ty();
            }
            if (b.this.mr != null) {
                b.this.mr.fb();
            }
            if (!b.this.mu) {
                b.this.kY.jz.getTimerHelper().startTiming();
            }
            if (b.this.mu || b.this.kY.f11590lc || b.this.kY.jr == null) {
                return;
            }
            b.this.kY.jr.onAdShow();
            com.kwad.components.ad.interstitial.report.c.em().a(b.this.kY.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bm() {
            if (b.this.gT != null) {
                b.this.gT.tz();
            }
            if (b.this.mr != null) {
                b.this.mr.fa();
            }
        }
    }

    public void bU() {
        if (getContext() != null) {
            this.fx = (Vibrator) getContext().getSystemService("vibrator");
        }
        float cZ = com.kwad.sdk.core.response.b.b.cZ(this.kY.mAdTemplate);
        if (this.fv == null) {
            d dVar = new d(cZ);
            this.fv = dVar;
            dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.7

                /* renamed from: com.kwad.components.ad.interstitial.f.a.b$7$1 */
                public class AnonymousClass1 extends bd {
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        b.this.fv.Hb();
                    }
                }

                public AnonymousClass7() {
                }

                @Override // com.kwad.sdk.core.f.b
                public final void a(double d10) {
                    if (bw.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d10);
                    }
                    bt.a(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.7.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            b.this.fv.Hb();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.f.b
                public final void bw() {
                }
            });
        }
        this.fv.g(cZ);
        this.fv.bz(getContext());
    }

    public void dP() {
        c cVar = this.kY;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.jz;
        if (dVar != null && a(dVar)) {
            this.kY.jz.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.kY.jr;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
    }

    private com.kwad.components.core.webview.tachikoma.c dX() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.f.a.b.14
            public AnonymousClass14() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.adm = com.kwad.components.ad.interstitial.d.a.dk();
                cVar.a(cVar2);
            }
        };
    }

    private e dY() {
        return new e() { // from class: com.kwad.components.ad.interstitial.f.a.b.15
            public AnonymousClass15() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = b.this.kY.f11588la ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private g dZ() {
        k kVar = new k();
        kVar.adr = this.kY.ln;
        return new g(kVar);
    }

    private com.kwad.components.ad.i.a.a.a ea() {
        com.kwad.components.ad.i.a.a.a aVar = new com.kwad.components.ad.i.a.a.a();
        this.kY.f11596li.add(new c.InterfaceC0383c() { // from class: com.kwad.components.ad.interstitial.f.a.b.16
            final /* synthetic */ com.kwad.components.ad.i.a.a.a mD;

            public AnonymousClass16(com.kwad.components.ad.i.a.a.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.components.ad.interstitial.f.c.InterfaceC0383c
            public final void dv() {
                aVar.eZ();
            }
        });
        return aVar2;
    }

    private bi eb() {
        bi biVar = new bi(getContext(), this.kY.mAdTemplate);
        biVar.a(new bi.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.3

            /* renamed from: com.kwad.components.ad.interstitial.f.a.b$3$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.dP();
                }
            }

            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.bi.a
            public final boolean eg() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.kY.mAdTemplate);
                b.this.kY.a(true, -1, null);
                bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.f.a.b.3.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dP();
                    }
                }, 0L);
                return false;
            }
        });
        return biVar;
    }

    @NonNull
    private n ec() {
        return new n() { // from class: com.kwad.components.ad.interstitial.f.a.b.4

            /* renamed from: com.kwad.components.ad.interstitial.f.a.b$4$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

                public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                    dVar.adn = al.isWifiConnected(b.this.getContext()) || b.this.kY.bS.isDataFlowAutoStart() || b.p(b.this.kY.mAdTemplate);
                    cVar.a(dVar);
                }
            }

            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                super.a(str, cVar2);
                bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.4.1
                    final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

                    public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar22) {
                        cVar = cVar22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                        dVar.adn = al.isWifiConnected(b.this.getContext()) || b.this.kY.bS.isDataFlowAutoStart() || b.p(b.this.kY.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private aj ed() {
        return new aj(new aj.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.5

            /* renamed from: com.kwad.components.ad.interstitial.f.a.b$5$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ aj.a mA;

                public AnonymousClass1(aj.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (aVar.type == 0 && !b.this.kY.f11588la && !b.this.kY.f11589lb && com.kwad.components.ad.interstitial.g.a.d(b.this.kY)) {
                        b.this.kY.f11589lb = true;
                        com.kwad.components.ad.interstitial.c.b.J(b.this.getContext());
                        return;
                    }
                    b.this.ef();
                    c cVar = b.this.kY;
                    aj.a aVar2 = aVar;
                    cVar.a(aVar2.type == 3, aVar2.aaa, null);
                    b.this.dP();
                }
            }

            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar2) {
                if (b.this.kY.jz != null) {
                    b.this.kY.f11594lg.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.a.b.5.1
                        final /* synthetic */ aj.a mA;

                        public AnonymousClass1(aj.a aVar22) {
                            aVar = aVar22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            if (aVar.type == 0 && !b.this.kY.f11588la && !b.this.kY.f11589lb && com.kwad.components.ad.interstitial.g.a.d(b.this.kY)) {
                                b.this.kY.f11589lb = true;
                                com.kwad.components.ad.interstitial.c.b.J(b.this.getContext());
                                return;
                            }
                            b.this.ef();
                            c cVar = b.this.kY;
                            aj.a aVar22 = aVar;
                            cVar.a(aVar22.type == 3, aVar22.aaa, null);
                            b.this.dP();
                        }
                    });
                }
            }
        });
    }

    private w ee() {
        return new w() { // from class: com.kwad.components.ad.interstitial.f.a.b.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void a(x xVar) {
                super.a(xVar);
                if (b.this.kY.f11590lc || b.this.kY.jr == null) {
                    return;
                }
                b.this.kY.jr.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void c(x xVar) {
                super.c(xVar);
                if (b.this.kY.f11590lc || b.this.kY.jr == null) {
                    return;
                }
                b.this.kY.jr.onVideoPlayEnd();
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void d(x xVar) {
                super.d(xVar);
                b.this.kY.mAdTemplate.setmCurPlayTime(xVar.oZ);
            }
        };
    }

    public void ef() {
        ay ayVar = this.gT;
        if (ayVar != null) {
            ayVar.tw();
            this.gT.tx();
        }
        com.kwad.components.ad.i.a.a.b bVar = this.mr;
        if (bVar != null) {
            bVar.fa();
        }
    }

    private ap.a getOpenNewPageListener() {
        return new ap.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.8
            public AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).n(b.this.kY.mAdResultData).qa());
            }
        };
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        com.kwad.components.ad.interstitial.report.c.em().w(this.kY.mAdTemplate);
        f fVar = this.kY.f11593lf;
        if (fVar != null) {
            fVar.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.gT != null && this.kY.f11587jp.ad()) {
            this.mt = true;
            this.gT.tu();
            this.gT.tv();
        }
        this.kY.f11587jp.a(this.eu);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cS;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dE(this.kY.mAdTemplate);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.cS = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mt = false;
        this.mu = false;
        bt.b(getContext(), this.fx);
        d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        com.kwad.components.ad.interstitial.g.b bVar = this.kY.f11587jp;
        if (bVar != null) {
            bVar.b(this.eu);
        }
        this.kY.b(this.f11585ld);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z10) {
        bVar.mu = true;
        return true;
    }

    public void d(double d10) {
        this.kY.a(new c.b(getContext()).m(true).c(d10).z(2).a(this.kY.f11594lg.getTouchCoords()).A(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META));
        bt.vibrate(getContext(), this.fx, ms);
    }

    public static boolean p(@NonNull AdTemplate adTemplate) {
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        return ca2 != null && ca2.exists();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z10) {
        bVar.mt = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.cS.setVisibility(8);
        f fVar = this.kY.f11593lf;
        if (fVar != null) {
            getTkTemplateId();
            fVar.s(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        com.kwad.components.ad.i.a.a.b D = com.kwad.components.ad.i.a.a.b.D(this.kY.mAdTemplate);
        this.mr = D;
        if (D != null) {
            D.a(new b.InterfaceC0376b() { // from class: com.kwad.components.ad.interstitial.f.a.b.10
                public AnonymousClass10() {
                }

                @Override // com.kwad.components.ad.i.a.a.b.InterfaceC0376b
                public final void E(int i10) {
                    if (i10 == com.kwad.components.ad.i.a.a.b.oP) {
                        b.this.kY.c(b.this.getContext(), b.this.kY.mAdTemplate);
                        b.this.kY.a(true, -1, null);
                    }
                    b.this.dP();
                }
            });
            sVar.c(this.mr);
            this.mr.at();
        }
        sVar.c(ed());
        sVar.c(new ap(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.dF(com.kwad.sdk.core.response.b.e.eb(this.kY.mAdTemplate))) {
            sVar.c(new ba(new ba.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.11
                public AnonymousClass11() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ba.a
                public final void ca() {
                    b.this.bU();
                }
            }));
        }
        sVar.c(ec());
        sVar.c(eb());
        sVar.c(dZ());
        sVar.c(a(bVar));
        sVar.c(ee());
        sVar.c(ea());
        sVar.c(new q() { // from class: com.kwad.components.ad.interstitial.f.a.b.12
            public AnonymousClass12() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                j.f(b.this.getContext(), b.this.kY.mAdTemplate);
            }
        });
        this.mv = dY();
        this.kY.a(this.f11585ld);
        sVar.c(this.mv);
        sVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.13
            public AnonymousClass13() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eh() {
                com.kwad.components.ad.interstitial.d.a.K(b.this.getContext());
            }
        }));
        sVar.c(dX());
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        super.a(ayVar);
        this.gT = ayVar;
    }

    @NonNull
    private y a(com.kwad.sdk.core.webview.b bVar) {
        return new y(bVar, this.kY.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.ei().a(b.this.kY.mAdTemplate, aVar.aJf, aVar.lz);
                    b.this.kY.f11588la = true;
                    if (!b.this.kY.f11590lc) {
                        b.this.kY.b(aVar.aJf, aVar.lz);
                    }
                    if (b.this.kY.jz == null || !com.kwad.components.ad.interstitial.d.b.o(b.this.kY.mAdTemplate)) {
                        return;
                    }
                    b.this.kY.a(false, -1, b.this.kY.co);
                    b.this.kY.jz.dismiss();
                    b.this.kY.X();
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kY.jr;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.kY.a(webCloseStatus.closeType == 2, -1, null);
        dP();
    }
}
