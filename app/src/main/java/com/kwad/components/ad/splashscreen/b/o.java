package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class o extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g {
    private com.kwad.components.ad.splashscreen.e.b Dd;
    private boolean De;
    private long Dg;
    private an Dh;

    @Nullable
    private KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean Df = false;
    private boolean Di = false;
    private final Runnable Dj = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(o.this, true);
            com.kwad.components.ad.splashscreen.monitor.a.a(com.kwad.sdk.core.response.a.b.aN(o.this.mAdTemplate), SystemClock.elapsedRealtime() - o.this.Dg, 1, "");
            o.this.li();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(o.this, true);
            com.kwad.components.ad.splashscreen.monitor.a.a(com.kwad.sdk.core.response.a.b.aN(o.this.mAdTemplate), SystemClock.elapsedRealtime() - o.this.Dg, 1, "");
            o.this.li();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$10 */
    final class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.ef.xD();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$11 */
    final class AnonymousClass11 implements h.a {
        final /* synthetic */ double fZ;

        AnonymousClass11(double d2) {
            d2 = d2;
        }

        @Override // com.kwad.components.ad.splashscreen.h.a
        public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
            iVar.i(d2);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$12 */
    final class AnonymousClass12 implements Runnable {
        AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.a((Presenter) new l(), true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$13 */
    final class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.a((Presenter) new k(), true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.a((Presenter) new m(), true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$3 */
    final class AnonymousClass3 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (com.kwad.sdk.c.kwai.a.tC()) {
                return;
            }
            if (aVar.zg() || o.o(o.this.mAdInfo)) {
                y.b bVar = new y.b();
                bVar.Ts = aVar.TD.Ts;
                o.this.a(false, aVar.TC, bVar, aVar.jU);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$4 */
    final class AnonymousClass4 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar.TA || !o.o(o.this.mAdInfo)) {
                o.this.a(false, aVar.TA ? 1 : 3, null, aVar.jU);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$5 */
    final class AnonymousClass5 implements a.b {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$6 */
    final class AnonymousClass6 extends com.kwad.components.a {
        final /* synthetic */ String hD;

        AnonymousClass6(String str) {
            str = str;
        }

        @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            super.onPageFinished();
            com.kwad.components.ad.splashscreen.monitor.a.d(str, SystemClock.elapsedRealtime() - o.this.Dg);
        }

        @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            super.onReceivedHttpError(i2, str, str2);
            bi.b(o.this.Dj);
            o.this.li();
            com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 2, str);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$7 */
    final class AnonymousClass7 implements ai.b {
        final /* synthetic */ String hD;

        AnonymousClass7(String str) {
            str = str;
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "updatePageStatus: " + aVar);
            bi.b(o.this.Dj);
            if (aVar.status != 1) {
                com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 3, "");
                o.this.li();
                return;
            }
            if (!o.this.Di && o.this.Dh != null) {
                o.this.Dh.qZ();
                o.this.Dh.ra();
            }
            if (com.kwad.sdk.core.response.a.b.dh(o.this.mAdInfo)) {
                o.this.lh();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$8 */
    final class AnonymousClass8 implements ap.a {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void bJ() {
            o.this.bB();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.o$9 */
    final class AnonymousClass9 implements com.kwad.sdk.core.f.b {
        AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d2) {
            boolean mF = com.kwad.components.core.d.a.b.mF();
            if (!o.this.Cg.BH.rG() || mF) {
                o.this.lg();
                return;
            }
            o.this.h(d2);
            o.this.lg();
            if (o.this.eg == null) {
                o oVar = o.this;
                oVar.eg = oVar.F(oVar.getContext());
            }
            bi.a(o.this.getContext(), o.this.eg);
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bd() {
        }
    }

    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        aI();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.cU = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new aq(this.cV, this.Cg.mApkDownloadHelper));
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new v(this.cV));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new ai(new ai.b() { // from class: com.kwad.components.ad.splashscreen.b.o.7
            final /* synthetic */ String hD;

            AnonymousClass7(String str2) {
                str = str2;
            }

            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar2) {
                com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bi.b(o.this.Dj);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 3, "");
                    o.this.li();
                    return;
                }
                if (!o.this.Di && o.this.Dh != null) {
                    o.this.Dh.qZ();
                    o.this.Dh.ra();
                }
                if (com.kwad.sdk.core.response.a.b.dh(o.this.mAdInfo)) {
                    o.this.lh();
                }
            }
        }, str2));
        aVar.a(new ap(new ap.a() { // from class: com.kwad.components.ad.splashscreen.b.o.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                o.this.bB();
            }
        }));
        aVar.a(new ac(this.cV));
        an anVar = new an();
        this.Dh = anVar;
        aVar.a(anVar);
    }

    private void a(KsAdWebView ksAdWebView, String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.getBackground().setAlpha(0);
        ksAdWebView.setVisibility(0);
        aF();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ct(this.Cg.mAdTemplate).b(new com.kwad.components.a() { // from class: com.kwad.components.ad.splashscreen.b.o.6
            final /* synthetic */ String hD;

            AnonymousClass6(String str2) {
                str = str2;
            }

            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.a.d(str, SystemClock.elapsedRealtime() - o.this.Dg);
            }

            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str2, String str22) {
                super.onReceivedHttpError(i2, str2, str22);
                bi.b(o.this.Dj);
                o.this.li();
                com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.a.aa(str2);
        ksAdWebView.loadUrl(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r10, int r11, @androidx.annotation.Nullable com.kwad.sdk.core.report.y.b r12, int r13) {
        /*
            r9 = this;
            com.kwad.components.ad.splashscreen.h r0 = r9.Cg
            r0.ku()
            r0 = 0
            r1 = 1
            if (r12 == 0) goto Lb
            r2 = 1
            goto Lc
        Lb:
            r2 = 0
        Lc:
            if (r11 != r1) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r2 != 0) goto L43
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r9.Cg     // Catch: org.json.JSONException -> L3d
            if (r5 == 0) goto L43
            com.kwad.components.ad.splashscreen.d.a r5 = r5.BG     // Catch: org.json.JSONException -> L3d
            if (r5 == 0) goto L29
            java.lang.String r6 = "duration"
            long r7 = r5.getCurrentPosition()     // Catch: org.json.JSONException -> L3d
            r4.put(r6, r7)     // Catch: org.json.JSONException -> L3d
        L29:
            if (r10 == 0) goto L2e
            r0 = 153(0x99, float:2.14E-43)
            goto L32
        L2e:
            if (r3 == 0) goto L32
            r0 = 132(0x84, float:1.85E-43)
        L32:
            com.kwad.components.ad.splashscreen.h r10 = r9.Cg     // Catch: org.json.JSONException -> L3b
            com.kwad.sdk.core.response.model.AdTemplate r10 = r10.mAdTemplate     // Catch: org.json.JSONException -> L3b
            r5 = 0
            com.kwad.sdk.core.report.a.a(r10, r0, r5, r4)     // Catch: org.json.JSONException -> L3b
            goto L44
        L3b:
            r10 = move-exception
            goto L3f
        L3d:
            r10 = move-exception
            r0 = r13
        L3f:
            com.kwad.sdk.core.d.b.printStackTrace(r10)
            goto L44
        L43:
            r0 = r13
        L44:
            com.kwad.components.core.d.b.a$a r10 = new com.kwad.components.core.d.b.a$a
            com.kwad.components.ad.splashscreen.h r4 = r9.Cg
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r10.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.Cg
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.d.b.a$a r10 = r10.I(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.Cg
            com.kwad.components.core.d.b.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.d.b.a$a r10 = r10.b(r4)
            com.kwad.components.core.d.b.a$a r10 = r10.ao(r3)
            com.kwad.components.core.d.b.a$a r10 = r10.ap(r11)
            com.kwad.components.core.d.b.a$a r10 = r10.a(r12)
            if (r2 == 0) goto L70
            goto L71
        L70:
            r13 = r0
        L71:
            com.kwad.components.core.d.b.a$a r10 = r10.ao(r13)
            com.kwad.components.core.d.b.a$a r10 = r10.an(r1)
            com.kwad.components.core.d.b.a$a r10 = r10.aq(r2)
            com.kwad.components.ad.splashscreen.b.o$5 r11 = new com.kwad.components.ad.splashscreen.b.o$5
            r11.<init>()
            com.kwad.components.core.d.b.a$a r10 = r10.a(r11)
            com.kwad.components.core.d.b.a.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.o.a(boolean, int, com.kwad.sdk.core.report.y$b, int):void");
    }

    static /* synthetic */ boolean a(o oVar, boolean z) {
        oVar.Di = true;
        return true;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Cg.mRootContainer;
        bVar2.app = adBaseFrameLayout;
        bVar2.LD = adBaseFrameLayout;
        bVar2.Lc = this.cS;
        bVar2.mReportExtData = null;
        bVar2.apr = false;
        bVar2.aps = o(this.mAdInfo);
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    public void bB() {
        if (this.ef != null || this.Df) {
            return;
        }
        com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(com.kwad.sdk.core.response.a.b.bx(this.Cg.mAdTemplate));
        this.ef = dVar;
        dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.splashscreen.b.o.9
            AnonymousClass9() {
            }

            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                boolean mF = com.kwad.components.core.d.a.b.mF();
                if (!o.this.Cg.BH.rG() || mF) {
                    o.this.lg();
                    return;
                }
                o.this.h(d2);
                o.this.lg();
                if (o.this.eg == null) {
                    o oVar = o.this;
                    oVar.eg = oVar.F(oVar.getContext());
                }
                bi.a(o.this.getContext(), o.this.eg);
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ef.aX(getContext());
    }

    private com.kwad.components.core.webview.jshandler.p dy() {
        return new com.kwad.components.core.webview.jshandler.p(this.cV, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (com.kwad.sdk.c.kwai.a.tC()) {
                    return;
                }
                if (aVar.zg() || o.o(o.this.mAdInfo)) {
                    y.b bVar = new y.b();
                    bVar.Ts = aVar.TD.Ts;
                    o.this.a(false, aVar.TC, bVar, aVar.jU);
                }
            }
        });
    }

    private s dz() {
        return new s(this.cV, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar.TA || !o.o(o.this.mAdInfo)) {
                    o.this.a(false, aVar.TA ? 1 : 3, null, aVar.jU);
                }
            }
        });
    }

    public void h(double d2) {
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            hVar.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.o.11
                final /* synthetic */ double fZ;

                AnonymousClass11(double d22) {
                    d2 = d22;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                    iVar.i(d2);
                }
            });
        }
    }

    public void lg() {
        bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.10
            AnonymousClass10() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                o.this.ef.xD();
            }
        }, null, 500L);
    }

    public void li() {
        Runnable anonymousClass2;
        this.Df = true;
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.a.b.cZ(this.mAdInfo)) {
            anonymousClass2 = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.12
                AnonymousClass12() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new l(), true);
                }
            };
        } else if (com.kwad.sdk.core.response.a.b.db(this.mAdInfo)) {
            anonymousClass2 = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.13
                AnonymousClass13() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new k(), true);
                }
            };
        } else {
            if (!com.kwad.sdk.core.response.a.b.de(this.mAdInfo)) {
                lj();
                return;
            }
            anonymousClass2 = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new m(), true);
                }
            };
        }
        bi.postOnUiThread(anonymousClass2);
    }

    private void lj() {
        lh();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate), this.Cg.mApkDownloadHelper);
        this.Dd = bVar;
        bVar.C(this.mAdTemplate);
        this.Dd.a(this);
        this.Dd.li();
    }

    public static boolean o(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_splash_web_card_webView);
        AdTemplate adTemplate = this.Cg.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.De = false;
        this.Df = false;
        String aN = com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate);
        if (this.cS == null || TextUtils.isEmpty(aN) || this.Cg.BL) {
            li();
        } else {
            this.Dg = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.a.kD();
            a(this.cS, aN);
            bi.a(this.Dj, null, com.kwad.sdk.core.response.a.b.dj(this.mAdInfo));
        }
        this.Cg.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void f(boolean z, boolean z2) {
        com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, null, 132);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void lh() {
        if (this.De) {
            return;
        }
        this.De = true;
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        aVar.ajY = com.kwad.components.ad.splashscreen.local.d.p(this.mAdInfo);
        bVar.akG = aVar;
        com.kwad.sdk.core.report.a.a(this.Cg.mAdTemplate, 123, bVar, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Dd;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        an anVar = this.Dh;
        if (anVar != null) {
            anVar.rb();
            this.Dh.rc();
        }
        aI();
    }
}
