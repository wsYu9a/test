package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes3.dex */
public final class f extends c {
    private int QH = -1;
    private ViewGroup QI;
    private final a QJ;
    private WebView Qc;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11935ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11936eb;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    /* renamed from: com.kwad.components.core.page.c.f$1 */
    public class AnonymousClass1 implements ar.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            f.this.QH = aVar.status;
            if (f.this.QJ != null) {
                f.this.QJ.aB(aVar.status);
            }
            if (aVar.status == 1) {
                f.this.QI.setVisibility(0);
            } else {
                f.this.Qc.setVisibility(8);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.c.f$2 */
    public class AnonymousClass2 implements ap.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void a(com.kwad.components.core.webview.a.b bVar) {
            AdWebViewActivityProxy.launch(f.this.Qc.getContext(), new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).aw(f.this.mAdTemplate).qa());
        }
    }

    public interface a {
        void aB(int i10);
    }

    public f(a aVar, boolean z10) {
        this.QJ = aVar;
        this.mIsRewardLandPage = z10;
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11936eb = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11936eb;
        bVar2.QI = this.QI;
        bVar2.Qc = this.Qc;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aY() {
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Qc);
        this.f11935ea = aVar;
        a(aVar);
        this.Qc.addJavascriptInterface(this.f11935ea, "KwaiAd");
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11935ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11935ea = null;
        }
    }

    private void aw(String str) {
        aY();
        this.Qc.loadUrl(str);
    }

    private ap.a getOpenNewPageListener() {
        return new ap.a() { // from class: com.kwad.components.core.page.c.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.Qc.getContext(), new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).aw(f.this.mAdTemplate).qa());
            }
        };
    }

    private ar.b qh() {
        return new ar.b() { // from class: com.kwad.components.core.page.c.f.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar) {
                f.this.QH = aVar.status;
                if (f.this.QJ != null) {
                    f.this.QJ.aB(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.QI.setVisibility(0);
                } else {
                    f.this.Qc.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.QF.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String cE = com.kwad.sdk.core.response.b.b.cE(adTemplate);
        if (!TextUtils.isEmpty(cE)) {
            aW();
            aw(cE);
        } else {
            a aVar = this.QJ;
            if (aVar != null) {
                aVar.aB(this.QH);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Qc = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.QI = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.Qc.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        aZ();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.QF.mAdTemplate);
        aVar.a(new ae(this.f11936eb));
        aVar.a(new ah(this.f11936eb));
        aVar.a(new bb(this.f11936eb, cVar));
        aVar.a(new ad(this.f11936eb));
        aVar.a(new ay());
        aVar.a(new ar(qh(), com.kwad.sdk.core.response.b.b.cE(this.mAdTemplate)));
        aVar.a(new al(this.f11936eb));
        aVar.b(new n(this.f11936eb));
        aVar.b(new m(this.f11936eb));
        aVar.a(new ap(getOpenNewPageListener()));
        aVar.a(new ab(this.f11936eb, cVar, null, (byte) 0));
        aVar.a(new y(this.f11936eb, cVar, null, 2, this.mIsRewardLandPage));
    }
}
