package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bg;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.components.core.webview.tachikoma.a.j;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.components.core.webview.tachikoma.a.l;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.d;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    private KsAdWebView Jx;
    private KsAdWebView.c QN;
    private ViewGroup Yi;
    private com.kwad.components.core.webview.a.a Yj;
    private av Yk;
    private d Yl;
    private boolean Ym;
    private com.kwad.components.core.webview.jshandler.a.c Yn;
    private ar.b Yo = new ar.b() { // from class: com.kwad.components.core.webview.b.13
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            if (b.this.hl != null) {
                b.this.hl.a(aVar);
            }
        }
    };

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11942ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11943eb;
    private c hl;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mPageUrl;

    /* renamed from: com.kwad.components.core.webview.b$1 */
    public class AnonymousClass1 implements bg.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.bg.a
        public final void tj() {
            if (com.kwad.sdk.core.response.b.b.dg(b.this.mAdTemplate)) {
                com.kwad.components.core.e.c.b.a(b.this.f11943eb.Qc.getContext(), new b.a().at(b.this.mAdTemplate).ag(com.kwad.sdk.core.response.b.b.df(b.this.mAdTemplate)).oi());
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$10 */
    public class AnonymousClass10 extends j {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.j
        public final void a(n nVar) {
            super.a(nVar);
            AdWebViewActivityProxy.launch(b.this.f11943eb.Qc.getContext(), new AdWebViewActivityProxy.a.C0438a().au(nVar.title).av(nVar.url).aD(true).aw(b.this.mAdTemplate).qa());
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$11 */
    public class AnonymousClass11 implements ad.b {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ad.b
        public final void c(ad.a aVar) {
            if (b.this.hl != null) {
                b.this.hl.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$12 */
    public class AnonymousClass12 implements ak.b {
        public AnonymousClass12() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            if (b.this.hl != null) {
                b.this.hl.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$13 */
    public class AnonymousClass13 implements ar.b {
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            if (b.this.hl != null) {
                b.this.hl.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.hl != null) {
                b.this.hl.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$3 */
    public class AnonymousClass3 implements al.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.al.a
        public final void onAdShow() {
            if (b.this.hl != null) {
                b.this.hl.onAdShow();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$4 */
    public class AnonymousClass4 implements KsAdWebView.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            if (b.this.Yk != null) {
                b.this.Yk.onFailed();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            if (b.this.Yk != null) {
                b.this.Yk.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$5 */
    public class AnonymousClass5 implements KsAdWebView.e {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            if (b.this.hl != null) {
                b.this.hl.onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            if (b.this.hl != null) {
                b.this.hl.h(i10, str);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$6 */
    public class AnonymousClass6 implements com.kwad.sdk.core.webview.d.a.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            if (b.this.hl != null) {
                b.this.hl.a(webCloseStatus);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$7 */
    public class AnonymousClass7 implements s.a {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.s.a
        public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar) {
            if (TextUtils.isEmpty(sVar.message)) {
                return;
            }
            z.d(b.this.f11943eb.Qc.getContext(), sVar.message, 0L);
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$8 */
    public class AnonymousClass8 extends d {
        final /* synthetic */ l Yq;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(AdTemplate adTemplate, l lVar) {
            super(adTemplate);
            lVar = lVar;
        }

        @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
        public final void b(String str, String str2, e eVar) {
            super.b(str, str2, eVar);
            com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
            bVar.adl = 1;
            lVar.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.b$9 */
    public class AnonymousClass9 extends com.kwad.components.core.webview.tachikoma.a.d {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.d
        public final void a(g gVar) {
            com.kwad.components.core.o.a.ri().a(gVar.actionType, b.this.mAdTemplate, gVar.MI);
        }
    }

    public static class a {
        private KsAdWebView Jx;
        private KsAdWebView.c QN;
        private ViewGroup Yi;
        private boolean Ym;
        private com.kwad.components.core.webview.jshandler.a.c Yn;
        private c hl;
        private AdTemplate mAdTemplate;
        private com.kwad.components.core.e.d.c mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        @Nullable
        public final a a(c cVar) {
            this.hl = cVar;
            return this;
        }

        @Nullable
        public final a aG(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @NonNull
        public final a aI(String str) {
            this.mPageUrl = str;
            return this;
        }

        public final a aT(boolean z10) {
            this.Ym = z10;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.QN = cVar;
            return this;
        }

        @NonNull
        public final a d(KsAdWebView ksAdWebView) {
            this.Jx = ksAdWebView;
            return this;
        }

        public final a e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.c cVar) {
            this.mApkDownloadHelper = cVar;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final com.kwad.components.core.e.d.c hu() {
            return this.mApkDownloadHelper;
        }

        @NonNull
        public final a k(ViewGroup viewGroup) {
            this.Yi = viewGroup;
            return this;
        }

        public final String pV() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c qq() {
            return this.QN;
        }

        public final ViewGroup tk() {
            return this.Yi;
        }

        public final KsAdWebView tl() {
            return this.Jx;
        }

        public final c tm() {
            return this.hl;
        }

        public final boolean tn() {
            return this.Ym;
        }

        public final com.kwad.components.core.webview.jshandler.a.c to() {
            return this.Yn;
        }

        public final a a(com.kwad.components.core.webview.jshandler.a.c cVar) {
            this.Yn = cVar;
            return this;
        }
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11943eb = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11943eb;
        bVar2.mScreenOrientation = 0;
        bVar2.Qc = this.Jx;
        bVar2.QI = this.Yi;
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11942ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11942ea = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.Yj;
        if (aVar2 != null) {
            aVar2.destroy();
            this.Yj = null;
        }
    }

    private void eM() {
        this.Jx.setClientConfig(this.Jx.getClientConfig().ex(this.mAdTemplate).dB(ti()).b(th()).a(tg()).c(this.QN));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.hl != null) {
                    b.this.hl.a(aVar);
                }
            }
        };
    }

    private boolean td() {
        c cVar = this.hl;
        if (cVar == null) {
            return false;
        }
        return cVar.qy();
    }

    private boolean te() {
        return false;
    }

    private al.a tf() {
        return new al.a() { // from class: com.kwad.components.core.webview.b.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.al.a
            public final void onAdShow() {
                if (b.this.hl != null) {
                    b.this.hl.onAdShow();
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.b tg() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.Yk != null) {
                    b.this.Yk.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.Yk != null) {
                    b.this.Yk.onSuccess();
                }
            }
        };
    }

    private KsAdWebView.e th() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.webview.b.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (b.this.hl != null) {
                    b.this.hl.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                if (b.this.hl != null) {
                    b.this.hl.h(i10, str);
                }
            }
        };
    }

    private int ti() {
        return com.kwad.sdk.core.response.b.a.S(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)) ? 5 : 1;
    }

    public final void jK() {
        aZ();
        if (this.Yl != null) {
            com.kwad.sdk.core.download.b.EI().a(this.Yl);
        }
        this.Yn = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.f11942ea = aVar;
        b(aVar, this.f11943eb);
        c cVar = this.hl;
        if (cVar != null) {
            cVar.a(this.f11942ea, this.f11943eb);
        }
        ksAdWebView.addJavascriptInterface(this.f11942ea, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        aZ();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.f11943eb);
        this.Yj = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.pV();
        this.mAdTemplate = aVar.getAdTemplate();
        this.Yi = aVar.tk();
        this.Jx = aVar.tl();
        this.hl = aVar.tm();
        this.mApkDownloadHelper = aVar.hu();
        this.Ym = aVar.tn();
        this.QN = aVar.qq();
        this.Yn = aVar.to();
        eM();
        a(this.hl, this.Jx);
        aW();
        if (com.kwad.sdk.core.response.b.a.P(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
            c(this.Jx);
        } else if (com.kwad.sdk.core.response.b.b.eB(this.mPageUrl)) {
            b(this.Jx);
        }
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        ay ayVar = new ay();
        aVar.a(ayVar);
        a(ayVar);
        aVar.a(new u());
        aVar.a(new com.kwad.components.core.webview.jshandler.c());
        aVar.a(new v());
        aVar.a(new p());
        aVar.a(new q());
        al alVar = new al(bVar);
        aVar.b(new com.kwad.components.core.webview.jshandler.n(bVar));
        aVar.b(new m(bVar));
        alVar.a(tf());
        aVar.a(alVar);
        aVar.a(new ae(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (!this.Ym) {
            aVar.a(new ab(this.f11943eb, this.mApkDownloadHelper, getClickListener(), td(), false, true));
            aVar.a(new y(this.f11943eb, this.mApkDownloadHelper, getClickListener(), td(), 0, te(), true));
        }
        aVar.a(new bb(this.f11943eb, this.mApkDownloadHelper));
        aVar.a(new at(this.f11943eb));
        aVar.a(new aq(this.f11943eb.Qc.getContext(), this.mAdTemplate));
        aVar.a(new bg(new bg.a() { // from class: com.kwad.components.core.webview.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.bg.a
            public final void tj() {
                if (com.kwad.sdk.core.response.b.b.dg(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.f11943eb.Qc.getContext(), new b.a().at(b.this.mAdTemplate).ag(com.kwad.sdk.core.response.b.b.df(b.this.mAdTemplate)).oi());
                }
            }
        }));
        aVar.a(new ai(this.f11943eb));
        aVar.a(new ar(this.Yo, this.mPageUrl));
        av avVar = new av();
        this.Yk = avVar;
        aVar.a(avVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.z(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.hl != null) {
                    b.this.hl.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (TextUtils.isEmpty(sVar2.message)) {
                    return;
                }
                z.d(b.this.f11943eb.Qc.getContext(), sVar2.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new ah(bVar));
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
            l lVar = new l();
            aVar.a(lVar);
            this.Yl = new d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                final /* synthetic */ l Yq;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass8(AdTemplate adTemplate, l lVar2) {
                    super(adTemplate);
                    lVar = lVar2;
                }

                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar2 = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar2.adl = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.b.EI().a(this.Yl, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.b.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(g gVar) {
                com.kwad.components.core.o.a.ri().a(gVar.actionType, b.this.mAdTemplate, gVar.MI);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(b.this.f11943eb.Qc.getContext(), new AdWebViewActivityProxy.a.C0438a().au(nVar.title).av(nVar.url).aD(true).aw(b.this.mAdTemplate).qa());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.e());
        aVar.a(new h());
        aVar.a(new com.kwad.components.core.webview.jshandler.k());
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        ad adVar = new ad(this.f11943eb);
        adVar.a(new ad.b() { // from class: com.kwad.components.core.webview.b.11
            public AnonymousClass11() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ad.b
            public final void c(ad.a aVar2) {
                if (b.this.hl != null) {
                    b.this.hl.b(aVar2);
                }
            }
        });
        aVar.a(adVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.f11943eb.Qc.getContext(), this.mAdTemplate));
        aVar.a(new ak(this.f11943eb, new ak.b() { // from class: com.kwad.components.core.webview.b.12
            public AnonymousClass12() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(ak.a aVar2) {
                if (b.this.hl != null) {
                    b.this.hl.a(aVar2);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j());
        aVar.a(new t());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new r());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.f(this.f11943eb.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.d(this.f11943eb.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.b(this.Yn));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.a());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.e(this.f11943eb.getContext()));
    }

    private void a(ay ayVar) {
        c cVar = this.hl;
        if (cVar == null) {
            return;
        }
        cVar.a(ayVar);
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.qx()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }
}
