package com.kwad.components.core.page.a;

import android.annotation.SuppressLint;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes2.dex */
public final class b extends Presenter {
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.core.page.a.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    /* renamed from: com.kwad.components.core.page.a.b$1 */
    final class AnonymousClass1 implements ai.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new v(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new ai(this.cZ, com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))));
        aVar.a(new ac(this.cV));
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = 0;
        bVar2.Lc = this.mAdWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aH() {
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cU = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) Bh()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().be(true).ct(this.mAdTemplate));
        aF();
        aH();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        aI();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
