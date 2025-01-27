package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public final class b extends Presenter {

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11932ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11933eb;

    /* renamed from: eh */
    private ar.b f11934eh = new ar.b() { // from class: com.kwad.components.core.page.c.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    /* renamed from: com.kwad.components.core.page.c.b$1 */
    public class AnonymousClass1 implements ar.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ae(this.f11933eb));
        aVar.a(new ah(this.f11933eb));
        aVar.a(new ar(this.f11934eh, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))));
        aVar.a(new al(this.f11933eb));
        aVar.b(new n(this.f11933eb));
        aVar.b(new m(this.f11933eb));
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11933eb = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11933eb;
        bVar2.mScreenOrientation = 0;
        bVar2.Qc = this.mAdWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aY() {
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.f11932ea = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.f11932ea, "KwaiAd");
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11932ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11932ea = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) Lj()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().bz(true).ex(this.mAdTemplate));
        aW();
        aY();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        aZ();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
