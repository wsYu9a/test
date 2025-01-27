package com.kwad.components.core.d.a;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;

/* loaded from: classes2.dex */
public final class e extends c implements View.OnClickListener {
    private Runnable IE;

    @Nullable
    public b Iv;
    public b.C0171b Iw;
    private KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private an mCardLifecycleHandler;
    private boolean IF = false;
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.core.d.a.e.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.IF);
            e.a(e.this, true);
        }
    };
    private ab.b cX = new ab.b() { // from class: com.kwad.components.core.d.a.e.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.cS.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    private aa.b cY = new aa.b() { // from class: com.kwad.components.core.d.a.e.5
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aN();
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.core.d.a.e.6
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.d.b.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.mL();
                return;
            }
            e.this.aN();
            if (e.this.getContext() != null) {
                v.H(e.this.getContext(), w.bO(e.this.getContext()));
            }
        }
    };

    /* renamed from: com.kwad.components.core.d.a.e$1 */
    final class AnonymousClass1 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.IF);
            e.a(e.this, true);
        }
    }

    /* renamed from: com.kwad.components.core.d.a.e$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.aN();
            if (e.this.getContext() != null) {
                v.H(e.this.getContext(), w.bO(e.this.getContext()));
            }
        }
    }

    /* renamed from: com.kwad.components.core.d.a.e$3 */
    final class AnonymousClass3 extends com.kwad.sdk.core.download.kwai.c {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            super.onInstalled();
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(e.this.mAdTemplate);
            String aq = com.kwad.sdk.core.response.a.a.aq(cb);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.ax(cb) && ak.ah(e.this.getContext(), aq) && com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                e.this.Iv.dismiss();
            }
        }
    }

    /* renamed from: com.kwad.components.core.d.a.e$4 */
    final class AnonymousClass4 implements ab.b {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.cS.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    }

    /* renamed from: com.kwad.components.core.d.a.e$5 */
    final class AnonymousClass5 implements aa.b {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aN();
        }
    }

    /* renamed from: com.kwad.components.core.d.a.e$6 */
    final class AnonymousClass6 implements ai.b {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.d.b.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.mL();
                return;
            }
            e.this.aN();
            if (e.this.getContext() != null) {
                v.H(e.this.getContext(), w.bO(e.this.getContext()));
            }
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new s(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener, false, true));
        aVar.a(new p(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener, 1));
        aVar.a(new com.kwad.components.core.webview.jshandler.v(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ab(this.cV, this.cX));
        aVar.a(new ai(this.cZ, this.Iw.url));
        an anVar = new an();
        this.mCardLifecycleHandler = anVar;
        aVar.a(anVar);
        aVar.a(new aq(this.cV, this.mApkDownloadHelper, new com.kwad.sdk.core.download.kwai.c() { // from class: com.kwad.components.core.d.a.e.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(e.this.mAdTemplate);
                String aq = com.kwad.sdk.core.response.a.a.aq(cb);
                if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.ax(cb) && ak.ah(e.this.getContext(), aq) && com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                    e.this.Iv.dismiss();
                }
            }
        }));
        aVar.a(new aa(this.cY));
        aVar.a(new ac(this.cV));
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.IF = true;
        return true;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.Ix.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        AdBaseFrameLayout adBaseFrameLayout = this.Ix.mRootContainer;
        bVar2.app = adBaseFrameLayout;
        bVar2.LD = adBaseFrameLayout;
        bVar2.Lc = this.cS;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aH() {
        com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    public void aN() {
        com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.IF);
        if (this.cS.getVisibility() != 0) {
            return;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
        }
        this.cS.setVisibility(4);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.rc();
        }
        if (this.IF) {
            com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
        }
        b bVar = this.Iv;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.Iv.an(this.IF);
    }

    private void mJ() {
        aH();
        this.cS.loadUrl(this.Iw.url);
        this.cS.postDelayed(mK(), 1500L);
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(0);
    }

    private Runnable mK() {
        if (this.IE == null) {
            this.IE = new Runnable() { // from class: com.kwad.components.core.d.a.e.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aN();
                    if (e.this.getContext() != null) {
                        v.H(e.this.getContext(), w.bO(e.this.getContext()));
                    }
                }
            };
        }
        return this.IE;
    }

    public void mL() {
        Runnable runnable = this.IE;
        if (runnable != null) {
            this.cS.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.cS.setVisibility(8);
        this.cS.release();
        aI();
    }

    @Override // com.kwad.components.core.d.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        d dVar = this.Ix;
        this.Iv = dVar.Iv;
        this.Iw = dVar.Iw;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Ix.mApkDownloadHelper;
        aF();
        mJ();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
        b bVar = this.Iv;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        mL();
    }
}
