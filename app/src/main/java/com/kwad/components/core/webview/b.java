package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.g;
import com.kwad.components.core.webview.a.a.n;
import com.kwad.components.core.webview.a.a.t;
import com.kwad.components.core.webview.a.kwai.d;
import com.kwad.components.core.webview.a.kwai.j;
import com.kwad.components.core.webview.a.kwai.k;
import com.kwad.components.core.webview.a.kwai.l;
import com.kwad.components.core.webview.a.kwai.s;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.v;

/* loaded from: classes2.dex */
public final class b {
    private KsAdWebView Go;
    private KsAdWebView.c LI;
    private c Mj;
    private ViewGroup RN;
    private com.kwad.components.core.webview.kwai.a RO;
    private am RP;
    private ai.b RQ = new ai.b() { // from class: com.kwad.components.core.webview.b.10
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (b.this.Mj != null) {
                b.this.Mj.a(aVar);
            }
        }
    };
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private e mDownloadSyncInterfaceAdapter;
    private String mPageUrl;

    /* renamed from: com.kwad.components.core.webview.b$1 */
    final class AnonymousClass1 implements au.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.au.a
        public final void qQ() {
            if (com.kwad.sdk.core.response.a.b.bB(b.this.mAdTemplate)) {
                com.kwad.components.core.d.a.b.a(b.this.cV.Lc.getContext(), new b.a().H(b.this.mAdTemplate).ao(com.kwad.sdk.core.response.a.b.bA(b.this.mAdTemplate)).mI());
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$10 */
    final class AnonymousClass10 implements ai.b {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (b.this.Mj != null) {
                b.this.Mj.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$11 */
    final class AnonymousClass11 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass11() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$2 */
    final class AnonymousClass2 implements KsAdWebView.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            if (b.this.RP != null) {
                b.this.RP.onFailed();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            if (b.this.RP != null) {
                b.this.RP.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$3 */
    final class AnonymousClass3 implements KsAdWebView.d {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            if (b.this.Mj != null) {
                b.this.Mj.onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            if (b.this.Mj != null) {
                b.this.Mj.oA();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$4 */
    final class AnonymousClass4 implements com.kwad.sdk.core.webview.c.kwai.b {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            if (b.this.Mj != null) {
                b.this.Mj.pageClose(webCloseStatus);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$5 */
    final class AnonymousClass5 implements s.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.s.a
        public final void a(t tVar) {
            if (TextUtils.isEmpty(tVar.message)) {
                return;
            }
            v.d(b.this.cV.Lc.getContext(), tVar.message, 0L);
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$6 */
    final class AnonymousClass6 extends e {
        final /* synthetic */ l RS;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(AdTemplate adTemplate, l lVar) {
            super(adTemplate);
            lVar = lVar;
        }

        @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
        public final void a(String str, int i2, f fVar) {
            super.a(str, i2, fVar);
            com.kwad.components.core.webview.a.a.b bVar = new com.kwad.components.core.webview.a.a.b();
            bVar.UW = 1;
            lVar.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$7 */
    final class AnonymousClass7 extends d {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.d
        public final void a(g gVar) {
            super.a(gVar);
            com.kwad.components.core.m.a.pb().a(gVar.Tr, b.this.mAdTemplate, gVar.Ts);
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$8 */
    final class AnonymousClass8 extends j {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.j
        public final void a(n nVar) {
            super.a(nVar);
            AdWebViewActivityProxy.launch(b.this.cV.Lc.getContext(), new AdWebViewActivityProxy.a.C0182a().au(nVar.title).av(nVar.url).aA(true).L(b.this.mAdTemplate).oc());
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$9 */
    final class AnonymousClass9 implements ab.b {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
        }
    }

    public static class a {
        private KsAdWebView Go;
        private KsAdWebView.c LI;
        private c Mj;
        private ViewGroup RN;
        private AdTemplate mAdTemplate;
        private String mPageUrl;

        @Nullable
        public final a Q(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @Nullable
        public final a a(c cVar) {
            this.Mj = cVar;
            return this;
        }

        @NonNull
        public final a aH(String str) {
            this.mPageUrl = str;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.LI = cVar;
            return this;
        }

        @NonNull
        public final a d(KsAdWebView ksAdWebView) {
            this.Go = ksAdWebView;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        @NonNull
        public final a j(ViewGroup viewGroup) {
            this.RN = viewGroup;
            return this;
        }

        public final String nZ() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c os() {
            return this.LI;
        }

        public final ViewGroup qR() {
            return this.RN;
        }

        public final KsAdWebView qS() {
            return this.Go;
        }

        public final c qT() {
            return this.Mj;
        }
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.oy()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = 0;
        bVar2.Lc = this.Go;
        bVar2.LD = this.RN;
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
        com.kwad.components.core.webview.kwai.a aVar2 = this.RO;
        if (aVar2 != null) {
            aVar2.destroy();
            this.RO = null;
        }
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        an anVar = new an();
        aVar.a(anVar);
        onRegisterLifecycleLisener(anVar);
        aVar.a(new ac(bVar));
        aVar.a(new com.kwad.components.core.webview.jshandler.v(bVar));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        aVar.a(new com.kwad.components.core.webview.jshandler.s(this.cV, cVar, getClickListener(), qK(), false));
        aVar.a(new p(this.cV, cVar, getClickListener(), qK(), 0, qL()));
        aVar.a(new aq(this.cV, cVar));
        aVar.a(new ak(this.cV));
        aVar.a(new ah(this.cV.Lc.getContext(), this.mAdTemplate));
        aVar.a(new au(new au.a() { // from class: com.kwad.components.core.webview.b.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.au.a
            public final void qQ() {
                if (com.kwad.sdk.core.response.a.b.bB(b.this.mAdTemplate)) {
                    com.kwad.components.core.d.a.b.a(b.this.cV.Lc.getContext(), new b.a().H(b.this.mAdTemplate).ao(com.kwad.sdk.core.response.a.b.bA(b.this.mAdTemplate)).mI());
                }
            }
        }));
        aVar.a(new z(this.cV));
        aVar.a(new ai(this.RQ, this.mPageUrl));
        am amVar = new am();
        this.RP = amVar;
        aVar.a(amVar);
        aVar.a(new q(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.webview.b.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                if (b.this.Mj != null) {
                    b.this.Mj.pageClose(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.s.a
            public final void a(t tVar) {
                if (TextUtils.isEmpty(tVar.message)) {
                    return;
                }
                v.d(b.this.cV.Lc.getContext(), tVar.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new y(bVar));
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            l lVar = new l();
            aVar.a(lVar);
            this.mDownloadSyncInterfaceAdapter = new e(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.6
                final /* synthetic */ l RS;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass6(AdTemplate adTemplate, l lVar2) {
                    super(adTemplate);
                    lVar = lVar2;
                }

                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void a(String str, int i2, f fVar) {
                    super.a(str, i2, fVar);
                    com.kwad.components.core.webview.a.a.b bVar2 = new com.kwad.components.core.webview.a.a.b();
                    bVar2.UW = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.c.vu().a(this.mDownloadSyncInterfaceAdapter, this.mAdTemplate);
        }
        aVar.a(new d() { // from class: com.kwad.components.core.webview.b.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.d
            public final void a(g gVar) {
                super.a(gVar);
                com.kwad.components.core.m.a.pb().a(gVar.Tr, b.this.mAdTemplate, gVar.Ts);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(b.this.cV.Lc.getContext(), new AdWebViewActivityProxy.a.C0182a().au(nVar.title).av(nVar.url).aA(true).L(b.this.mAdTemplate).oc());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.b());
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        aVar.a(new com.kwad.components.core.webview.jshandler.g());
        aVar.a(new com.kwad.components.core.webview.jshandler.a());
        aVar.a(new u(this.cV));
        aVar.a(new h(this.cV.Lc.getContext(), this.mAdTemplate));
        aVar.a(new ab(this.cV, new ab.b() { // from class: com.kwad.components.core.webview.b.9
            AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ab.b
            public final void a(ab.a aVar2) {
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.f());
        aVar.a(new m());
        aVar.a(new com.kwad.components.core.webview.jshandler.l());
        aVar.a(new com.kwad.components.core.webview.jshandler.k());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.cU = aVar;
        b(aVar, this.cV);
        c cVar = this.Mj;
        if (cVar != null) {
            cVar.a(this.cU, this.cV);
        }
        ksAdWebView.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        aI();
        com.kwad.components.core.webview.kwai.a aVar = new com.kwad.components.core.webview.kwai.a(ksAdWebView, this.cV);
        this.RO = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void eP() {
        this.Go.setClientConfig(this.Go.getClientConfig().ct(this.mAdTemplate).b(qN()).b(qO()).a(qM()).c(this.LI));
    }

    @NonNull
    private com.kwad.sdk.core.webview.c.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.core.webview.b.11
            AnonymousClass11() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            }
        };
    }

    private void onRegisterLifecycleLisener(an anVar) {
        c cVar = this.Mj;
        if (cVar == null) {
            return;
        }
        cVar.onRegisterLifecycleLisener(anVar);
    }

    private boolean qK() {
        c cVar = this.Mj;
        if (cVar == null) {
            return false;
        }
        return cVar.oz();
    }

    private boolean qL() {
        c cVar = this.Mj;
        return false;
    }

    @NonNull
    private KsAdWebView.b qM() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.RP != null) {
                    b.this.RP.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.RP != null) {
                    b.this.RP.onSuccess();
                }
            }
        };
    }

    private y.b qN() {
        y.b bVar = new y.b();
        bVar.akv = 0;
        bVar.akH = qP();
        return bVar;
    }

    private KsAdWebView.d qO() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.webview.b.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (b.this.Mj != null) {
                    b.this.Mj.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                if (b.this.Mj != null) {
                    b.this.Mj.oA();
                }
            }
        };
    }

    private int qP() {
        return com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) ? 5 : 1;
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.nZ();
        this.mAdTemplate = aVar.getAdTemplate();
        this.RN = aVar.qR();
        this.Go = aVar.qS();
        this.Mj = aVar.qT();
        this.LI = aVar.os();
        eP();
        a(this.Mj, this.Go);
        aF();
        if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            c(this.Go);
        } else if (com.kwad.sdk.core.response.a.b.cI(this.mPageUrl)) {
            b(this.Go);
        }
    }

    public final void unBind() {
        aI();
        if (this.mDownloadSyncInterfaceAdapter != null) {
            com.kwad.sdk.core.download.c.vu().a(this.mDownloadSyncInterfaceAdapter);
        }
    }
}
