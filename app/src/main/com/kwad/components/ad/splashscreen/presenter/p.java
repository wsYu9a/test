package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bt;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class p extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.h.c {
    private com.kwad.components.ad.splashscreen.e.b FA;
    private boolean FB;
    private long FD;
    private ay FE;
    private ViewGroup FG;

    @Nullable
    private KsAdWebView dY;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11903ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11904eb;
    private com.kwad.sdk.core.f.d fv;
    private Vibrator fx;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean FC = false;
    private boolean FF = false;
    private final Runnable FH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            p.a(p.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cq(p.this.mAdTemplate), SystemClock.elapsedRealtime() - p.this.FD, 1, "");
            p.this.lN();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            p.a(p.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cq(p.this.mAdTemplate), SystemClock.elapsedRealtime() - p.this.FD, 1, "");
            p.this.lN();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$10 */
    public class AnonymousClass10 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass10() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar.aan || !com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                p.this.a(false, aVar.aan ? 1 : 3, aVar.lz, "");
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$3 */
    public class AnonymousClass3 extends com.kwad.sdk.core.webview.f {
        final /* synthetic */ String FJ;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            super.onPageFinished();
            com.kwad.components.ad.splashscreen.monitor.c.b(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD);
        }

        @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            super.onReceivedHttpError(i10, str, str2);
            bt.c(p.this.FH);
            p.this.lN();
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD, 2, str);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$4 */
    public class AnonymousClass4 implements ar.b {
        final /* synthetic */ String FJ;

        public AnonymousClass4(String str) {
            str = str;
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar);
            bt.c(p.this.FH);
            if (aVar.status != 1) {
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD, 3, "");
                p.this.lN();
                return;
            }
            p.this.EJ.El = SystemClock.elapsedRealtime() - p.this.mStartTime;
            if (p.this.FF) {
                p.this.EJ.isWebTimeout = true;
            } else if (p.this.FE != null) {
                p.this.FE.tu();
                p.this.FE.tv();
            }
            if (com.kwad.sdk.core.response.b.b.dV(p.this.mAdInfo)) {
                p.this.lM();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$5 */
    public class AnonymousClass5 implements ba.a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ba.a
        public final void ca() {
            p.this.bU();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$6 */
    public class AnonymousClass6 implements com.kwad.sdk.core.f.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d10) {
            boolean of2 = com.kwad.components.core.e.c.b.of();
            if (!p.this.EJ.DV.uH() || of2) {
                return;
            }
            p.this.h(d10);
            if (p.this.fx == null) {
                p pVar = p.this;
                pVar.fx = pVar.E(pVar.getContext());
            }
            bt.a(p.this.getContext(), p.this.fx);
            p.this.fv.bA(p.this.getContext());
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bw() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$7 */
    public class AnonymousClass7 implements h.a {
        final /* synthetic */ double hu;

        public AnonymousClass7(double d10) {
            d10 = d10;
        }

        @Override // com.kwad.components.ad.splashscreen.h.a
        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
            bVar.l(d10);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$8 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ Presenter FK;

        public AnonymousClass8(Presenter presenter) {
            y10 = presenter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p.this.a(y10, true);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.p$9 */
    public class AnonymousClass9 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (com.kwad.sdk.c.a.a.BR()) {
                return;
            }
            if (aVar.IR() || com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                p.this.a(false, aVar.aap, aVar.lz, aVar.aaq.MI);
            }
        }
    }

    public Vibrator E(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11904eb = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11904eb;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.EJ.mRootContainer;
        bVar2.aIc = adBaseFrameLayout;
        bVar2.QI = adBaseFrameLayout;
        bVar2.Qc = this.dY;
        bVar2.mReportExtData = null;
        bVar2.aIe = false;
        bVar2.aIf = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11903ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11903ea = null;
        }
    }

    public void bU() {
        if (this.fv != null || this.FC) {
            return;
        }
        com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(com.kwad.sdk.core.response.b.b.db(this.EJ.mAdTemplate));
        this.fv = dVar;
        dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.splashscreen.presenter.p.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.core.f.b
            public final void a(double d10) {
                boolean of2 = com.kwad.components.core.e.c.b.of();
                if (!p.this.EJ.DV.uH() || of2) {
                    return;
                }
                p.this.h(d10);
                if (p.this.fx == null) {
                    p pVar = p.this;
                    pVar.fx = pVar.E(pVar.getContext());
                }
                bt.a(p.this.getContext(), p.this.fx);
                p.this.fv.bA(p.this.getContext());
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bw() {
            }
        });
        this.fv.bz(getContext());
    }

    public void lN() {
        this.FC = true;
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.FG;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        Presenter y10 = y(this.mAdInfo);
        if (y10 != null) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.p.8
                final /* synthetic */ Presenter FK;

                public AnonymousClass8(Presenter y102) {
                    y10 = y102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a(y10, true);
                }
            });
        } else {
            lO();
        }
    }

    private void lO() {
        lM();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate), this.EJ.mApkDownloadHelper);
        this.FA = bVar;
        bVar.al(this.mAdTemplate);
        this.FA.a(this);
        this.FA.lN();
    }

    private y lP() {
        return new y(this.f11904eb, this.EJ.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.c.a.a.BR()) {
                    return;
                }
                if (aVar.IR() || com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    p.this.a(false, aVar.aap, aVar.lz, aVar.aaq.MI);
                }
            }
        });
    }

    private ab lQ() {
        return new ab(this.f11904eb, this.EJ.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.aan || !com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    p.this.a(false, aVar.aan ? 1 : 3, aVar.lz, "");
                }
            }
        }, (byte) 0);
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.m37do(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.b.dQ(adInfo)) {
                return new l();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.b.b.dO(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.dQ(this.mAdInfo)) {
            return new l();
        }
        if (com.kwad.sdk.core.response.b.b.dT(this.mAdInfo)) {
            return new n();
        }
        return null;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void X(int i10) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.EJ.DV.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.FG = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.dY = new KsAdWebView(getContext());
            this.dY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.FG.addView(this.dY);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.EJ.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.FB = false;
        this.FC = false;
        String cq = com.kwad.sdk.core.response.b.b.cq(this.mAdTemplate);
        if (this.dY == null || TextUtils.isEmpty(cq) || this.EJ.Ea) {
            lN();
        } else {
            this.FD = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ak(this.mAdTemplate);
            a(this.dY, cq);
            bt.a(this.FH, null, com.kwad.sdk.core.response.b.b.dX(this.mAdInfo));
        }
        this.EJ.a(this);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bz(getContext());
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kS() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void lM() {
        if (this.FB) {
            return;
        }
        this.FB = true;
        a.C0484a c0484a = new a.C0484a();
        c0484a.asA = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.EJ.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(123).b(c0484a));
        com.kwad.components.core.webview.tachikoma.d.a.uf().aX(123);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.h.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.FA;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        ay ayVar = this.FE;
        if (ayVar != null) {
            ayVar.tw();
            this.FE.tx();
        }
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null && (aVar = hVar.DV) != null) {
            aVar.b(this);
        }
        aZ();
    }

    public void h(double d10) {
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            hVar.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.7
                final /* synthetic */ double hu;

                public AnonymousClass7(double d102) {
                    d10 = d102;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d10);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void i(boolean z10, boolean z11) {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z10 + ", isActionBar: " + z11);
        a(!z10, z11 ? 1 : 2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, null);
    }

    public static /* synthetic */ boolean a(p pVar, boolean z10) {
        pVar.FF = true;
        return true;
    }

    private void a(KsAdWebView ksAdWebView, String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        aW();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ex(this.EJ.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.p.3
            final /* synthetic */ String FJ;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str2, String str22) {
                super.onReceivedHttpError(i10, str2, str22);
                bt.c(p.this.FH);
                p.this.lN();
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str2, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str2);
        } catch (Throwable unused) {
            lN();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        aZ();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.f11903ea = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.f11903ea, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new bb(this.f11904eb, this.EJ.mApkDownloadHelper));
        aVar.a(lQ());
        aVar.a(lP());
        aVar.a(new ae(this.f11904eb));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new ar(new ar.b() { // from class: com.kwad.components.ad.splashscreen.presenter.p.4
            final /* synthetic */ String FJ;

            public AnonymousClass4(String str2) {
                str = str2;
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bt.c(p.this.FH);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.FD, 3, "");
                    p.this.lN();
                    return;
                }
                p.this.EJ.El = SystemClock.elapsedRealtime() - p.this.mStartTime;
                if (p.this.FF) {
                    p.this.EJ.isWebTimeout = true;
                } else if (p.this.FE != null) {
                    p.this.FE.tu();
                    p.this.FE.tv();
                }
                if (com.kwad.sdk.core.response.b.b.dV(p.this.mAdInfo)) {
                    p.this.lM();
                }
            }
        }, str2));
        aVar.a(new ba(new ba.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ba.a
            public final void ca() {
                p.this.bU();
            }
        }));
        aVar.a(new al(this.f11904eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.f11904eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.f11904eb));
        ay ayVar = new ay();
        this.FE = ayVar;
        aVar.a(ayVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r10, int r11, int r12, java.lang.String r13) {
        /*
            r9 = this;
            com.kwad.components.ad.splashscreen.h r0 = r9.EJ
            r0.W()
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r11 != r1) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r0 != 0) goto L4c
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r9.EJ     // Catch: org.json.JSONException -> L2a
            if (r5 == 0) goto L4c
            com.kwad.components.ad.splashscreen.d.a r5 = r5.DT     // Catch: org.json.JSONException -> L2a
            if (r5 == 0) goto L2d
            java.lang.String r6 = "duration"
            long r7 = r5.getCurrentPosition()     // Catch: org.json.JSONException -> L2a
            r4.put(r6, r7)     // Catch: org.json.JSONException -> L2a
            goto L2d
        L2a:
            r10 = move-exception
            r2 = r12
            goto L48
        L2d:
            if (r10 == 0) goto L32
            r2 = 153(0x99, float:2.14E-43)
            goto L36
        L32:
            if (r3 == 0) goto L36
            r2 = 132(0x84, float:1.85E-43)
        L36:
            com.kwad.sdk.core.adlog.c.b r10 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L47
            r10.<init>()     // Catch: org.json.JSONException -> L47
            com.kwad.sdk.core.adlog.c.b r10 = r10.cL(r2)     // Catch: org.json.JSONException -> L47
            com.kwad.components.ad.splashscreen.h r5 = r9.EJ     // Catch: org.json.JSONException -> L47
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate     // Catch: org.json.JSONException -> L47
            com.kwad.sdk.core.adlog.c.a(r5, r10, r4)     // Catch: org.json.JSONException -> L47
            goto L4d
        L47:
            r10 = move-exception
        L48:
            com.kwad.sdk.core.d.c.printStackTrace(r10)
            goto L4d
        L4c:
            r2 = r12
        L4d:
            com.kwad.components.core.e.d.a$a r10 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r4 = r9.EJ
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r10.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.EJ
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.e.d.a$a r10 = r10.au(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.EJ
            com.kwad.components.core.e.d.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r10 = r10.b(r4)
            com.kwad.components.core.e.d.a$a r10 = r10.ap(r3)
            com.kwad.components.core.e.d.a$a r10 = r10.ao(r11)
            if (r0 == 0) goto L75
            goto L76
        L75:
            r12 = r2
        L76:
            com.kwad.components.core.e.d.a$a r10 = r10.an(r12)
            com.kwad.components.core.e.d.a$a r10 = r10.ai(r13)
            com.kwad.components.core.e.d.a$a r10 = r10.am(r1)
            com.kwad.components.core.e.d.a$a r10 = r10.ar(r0)
            com.kwad.components.ad.splashscreen.presenter.p$2 r11 = new com.kwad.components.ad.splashscreen.presenter.p$2
            r11.<init>()
            com.kwad.components.core.e.d.a$a r10 = r10.a(r11)
            com.kwad.components.core.e.d.a.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.presenter.p.a(boolean, int, int, java.lang.String):void");
    }
}
