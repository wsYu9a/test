package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.z;

/* loaded from: classes3.dex */
public final class e extends c implements View.OnClickListener {

    @Nullable
    public b Mf;
    public b.C0426b Mg;
    private Runnable Mo;
    private KsAdWebView dY;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11916ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11917eb;

    /* renamed from: ed */
    private ay f11918ed;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean Mp = false;

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11919ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.Mp);
            e.a(e.this, true);
        }
    };

    /* renamed from: ef */
    private ak.b f11920ef = new ak.b() { // from class: com.kwad.components.core.e.c.e.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.dY.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };

    /* renamed from: eg */
    private aj.b f11921eg = new aj.b() { // from class: com.kwad.components.core.e.c.e.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.be();
        }
    };

    /* renamed from: eh */
    private ar.b f11922eh = new ar.b() { // from class: com.kwad.components.core.e.c.e.6
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            com.kwad.sdk.core.d.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.ol();
                return;
            }
            e.this.be();
            if (e.this.getContext() != null) {
                z.P(e.this.getContext(), ab.cp(e.this.getContext()));
            }
        }
    };

    /* renamed from: com.kwad.components.core.e.c.e$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.Mp);
            e.a(e.this, true);
        }
    }

    /* renamed from: com.kwad.components.core.e.c.e$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.be();
            if (e.this.getContext() != null) {
                z.P(e.this.getContext(), ab.cp(e.this.getContext()));
            }
        }
    }

    /* renamed from: com.kwad.components.core.e.c.e$3 */
    public class AnonymousClass3 extends com.kwad.sdk.core.download.a.c {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            super.onInstalled();
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(e.this.mAdTemplate);
            String ay = com.kwad.sdk.core.response.b.a.ay(eb2);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aF(eb2) && ap.an(e.this.getContext(), ay) && com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                e.this.Mf.dismiss();
            }
        }
    }

    /* renamed from: com.kwad.components.core.e.c.e$4 */
    public class AnonymousClass4 implements ak.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.dY.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    }

    /* renamed from: com.kwad.components.core.e.c.e$5 */
    public class AnonymousClass5 implements aj.b {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.be();
        }
    }

    /* renamed from: com.kwad.components.core.e.c.e$6 */
    public class AnonymousClass6 implements ar.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            com.kwad.sdk.core.d.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.ol();
                return;
            }
            e.this.be();
            if (e.this.getContext() != null) {
                z.P(e.this.getContext(), ab.cp(e.this.getContext()));
            }
        }
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11917eb = bVar;
        bVar.setAdTemplate(this.Mh.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11917eb;
        AdBaseFrameLayout adBaseFrameLayout = this.Mh.mRootContainer;
        bVar2.aIc = adBaseFrameLayout;
        bVar2.QI = adBaseFrameLayout;
        bVar2.Qc = this.dY;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aY() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.dY);
        this.f11916ea = aVar;
        a(aVar);
        this.dY.addJavascriptInterface(this.f11916ea, "KwaiAd");
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11916ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11916ea = null;
        }
    }

    public void be() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.Mp);
        if (this.dY.getVisibility() != 0) {
            return;
        }
        ay ayVar = this.f11918ed;
        if (ayVar != null) {
            ayVar.tw();
        }
        this.dY.setVisibility(4);
        ay ayVar2 = this.f11918ed;
        if (ayVar2 != null) {
            ayVar2.tx();
        }
        if (this.Mp) {
            com.kwad.sdk.core.adlog.c.bW(this.mAdTemplate);
        }
        b bVar = this.Mf;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.Mf.ak(this.Mp);
    }

    private void oj() {
        aY();
        this.dY.loadUrl(this.Mg.url);
        this.dY.postDelayed(ok(), qe.a.f30009d);
        this.dY.setBackgroundColor(0);
        this.dY.getBackground().setAlpha(0);
        this.dY.setVisibility(0);
    }

    private Runnable ok() {
        if (this.Mo == null) {
            this.Mo = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.be();
                    if (e.this.getContext() != null) {
                        z.P(e.this.getContext(), ab.cp(e.this.getContext()));
                    }
                }
            };
        }
        return this.Mo;
    }

    public void ol() {
        Runnable runnable = this.Mo;
        if (runnable != null) {
            this.dY.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.dY.setVisibility(8);
        this.dY.release();
        aZ();
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        d dVar = this.Mh;
        this.Mf = dVar.Mf;
        this.Mg = dVar.Mg;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Mh.mApkDownloadHelper;
        aW();
        oj();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.bW(this.mAdTemplate);
        b bVar = this.Mf;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dY = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ol();
    }

    public static /* synthetic */ boolean a(e eVar, boolean z10) {
        eVar.Mp = true;
        return true;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new com.kwad.components.core.webview.jshandler.ab(this.f11917eb, this.mApkDownloadHelper, this.f11919ee));
        aVar.a(new y(this.f11917eb, this.mApkDownloadHelper, this.f11919ee, 1));
        aVar.a(new ae(this.f11917eb));
        aVar.a(new ah(this.f11917eb));
        aVar.a(new ad(this.f11917eb));
        aVar.a(new ak(this.f11917eb, this.f11920ef));
        aVar.a(new ar(this.f11922eh, this.Mg.url));
        ay ayVar = new ay();
        this.f11918ed = ayVar;
        aVar.a(ayVar);
        aVar.a(new bb(this.f11917eb, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(e.this.mAdTemplate);
                String ay = com.kwad.sdk.core.response.b.a.ay(eb2);
                if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aF(eb2) && ap.an(e.this.getContext(), ay) && com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                    e.this.Mf.dismiss();
                }
            }
        }));
        aVar.a(new aj(this.f11921eg));
        aVar.a(new al(this.f11917eb));
        aVar.b(new n(this.f11917eb));
        aVar.b(new m(this.f11917eb));
    }
}
