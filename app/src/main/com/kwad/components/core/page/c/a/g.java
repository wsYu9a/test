package com.kwad.components.core.page.c.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class g extends a implements com.kwad.components.core.webview.jshandler.a.c {

    /* renamed from: hf */
    private static final Handler f11930hf = new Handler(Looper.getMainLooper());
    public AdWebViewActivityProxy.a Qw;
    private ay Rn;
    private au Ro;
    private String Rp;
    private Runnable Rq;

    /* renamed from: hk */
    private com.kwad.components.core.webview.b f11931hk;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean Rl = false;
    private boolean Rm = false;
    private final com.kwad.sdk.core.c.c yv = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    private com.kwad.components.core.webview.jshandler.b QP = new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.core.page.c.a.g.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.b
        public final void qw() {
            if (g.this.Ro != null) {
                g.this.Ro.tt();
            }
        }
    };
    private com.kwad.components.core.webview.c hl = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.4

        /* renamed from: com.kwad.components.core.page.c.a.g$4$1 */
        public class AnonymousClass1 implements bf.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.bf.b
            public final void a(bf.a aVar) {
                f.a aVar2 = g.this.QL.QO;
                if (aVar2 == null || aVar == null) {
                    return;
                }
                aVar2.aC(aVar.visibility);
            }
        }

        /* renamed from: com.kwad.components.core.page.c.a.g$4$2 */
        public class AnonymousClass2 implements au.b {
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.au.b
            public final void qz() {
                g gVar = g.this;
                gVar.QL.a(gVar.QP);
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bf(new bf.b() { // from class: com.kwad.components.core.page.c.a.g.4.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.jshandler.bf.b
                public final void a(bf.a aVar2) {
                    f.a aVar22 = g.this.QL.QO;
                    if (aVar22 == null || aVar2 == null) {
                        return;
                    }
                    aVar22.aC(aVar2.visibility);
                }
            }));
            g.this.Ro = new au(new au.b() { // from class: com.kwad.components.core.page.c.a.g.4.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.jshandler.au.b
                public final void qz() {
                    g gVar = g.this;
                    gVar.QL.a(gVar.QP);
                }
            });
            aVar.a(g.this.Ro);
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.b(bVar, g.this.QL.mAdTemplate));
            k kVar = new k();
            kVar.ads = g.this.QL.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i10, String str) {
            g.this.Rl = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.g.a.a(gVar.mAdTemplate, gVar.Qw.pW(), g.this.Qw.pV(), i10, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Rl = true;
            if (!g.this.Rm) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.g.a.m(gVar.mAdTemplate, gVar.Qw.pW(), g.this.Qw.pV());
            }
            if (g.this.QL.qj()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qx() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ay ayVar) {
            g.this.Rn = ayVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ar.a aVar) {
            g.this.QL.QQ = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.QL.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    };

    /* renamed from: com.kwad.components.core.page.c.a.g$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.webview.a.c {

        /* renamed from: com.kwad.components.core.page.c.a.g$1$1 */
        public class RunnableC04401 implements Runnable {
            final /* synthetic */ Object Rs;
            final /* synthetic */ com.kwad.components.core.urlReplace.c Rt;
            final /* synthetic */ c.a Ru;

            public RunnableC04401(Object obj, com.kwad.components.core.urlReplace.c cVar, c.a aVar) {
                obj = obj;
                cVar2 = cVar;
                clientConfig = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (obj) {
                    try {
                        com.kwad.components.core.urlReplace.c cVar = cVar2;
                        if (cVar != null) {
                            cVar.rY();
                        }
                        c.a aVar = clientConfig;
                        if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                            com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                        } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                            com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                        } else {
                            com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        /* renamed from: com.kwad.components.core.page.c.a.g$1$2 */
        public class AnonymousClass2 implements com.kwad.components.core.urlReplace.a {
            final /* synthetic */ Object Rs;
            final /* synthetic */ c.a Ru;

            public AnonymousClass2(Object obj, c.a aVar) {
                obj = obj;
                clientConfig = aVar;
            }

            @Override // com.kwad.components.core.urlReplace.a
            public final void onSuccess(String str) {
                synchronized (obj) {
                    try {
                        g.this.Rp = str;
                        if (g.this.Rq != null) {
                            g.f11930hf.removeCallbacks(g.this.Rq);
                        }
                        c.a aVar = clientConfig;
                        if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                            com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                        } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                            com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                        } else {
                            com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
            com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(g.this.mAdTemplate);
            g.this.Rp = str;
            if (!com.kwad.sdk.core.response.b.a.bj(eb2) || !aj.cA(g.this.QL.mContext) || !aj.gN(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            c.a clientConfig = g.this.mAdWebView.getClientConfig();
            com.kwad.components.core.urlReplace.c cVar = new com.kwad.components.core.urlReplace.c();
            Object obj = new Object();
            g.this.Rq = new Runnable() { // from class: com.kwad.components.core.page.c.a.g.1.1
                final /* synthetic */ Object Rs;
                final /* synthetic */ com.kwad.components.core.urlReplace.c Rt;
                final /* synthetic */ c.a Ru;

                public RunnableC04401(Object obj2, com.kwad.components.core.urlReplace.c cVar2, c.a clientConfig2) {
                    obj = obj2;
                    cVar2 = cVar2;
                    clientConfig = clientConfig2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (obj) {
                        try {
                            com.kwad.components.core.urlReplace.c cVar2 = cVar2;
                            if (cVar2 != null) {
                                cVar2.rY();
                            }
                            c.a aVar = clientConfig;
                            if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                            } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                            } else {
                                com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            };
            g.f11930hf.postDelayed(g.this.Rq, com.kwad.sdk.core.response.b.a.bk(eb2));
            cVar2.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.c.a.g.1.2
                final /* synthetic */ Object Rs;
                final /* synthetic */ c.a Ru;

                public AnonymousClass2(Object obj2, c.a clientConfig2) {
                    obj = obj2;
                    clientConfig = clientConfig2;
                }

                @Override // com.kwad.components.core.urlReplace.a
                public final void onSuccess(String str2) {
                    synchronized (obj) {
                        try {
                            g.this.Rp = str2;
                            if (g.this.Rq != null) {
                                g.f11930hf.removeCallbacks(g.this.Rq);
                            }
                            c.a aVar = clientConfig;
                            if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                            } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                            } else {
                                com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            });
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.g$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.c.d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.g$3 */
    public class AnonymousClass3 implements com.kwad.components.core.webview.jshandler.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.b
        public final void qw() {
            if (g.this.Ro != null) {
                g.this.Ro.tt();
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.g$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public final void run() {
            if (g.this.mAdWebView != null) {
                g.this.mAdWebView.getClientConfig().bx(true);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.g$6 */
    public class AnonymousClass6 implements View.OnTouchListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            g.this.mAdWebView.getClientConfig().bx(true);
            return false;
        }
    }

    private void eM() {
        this.f11931hk = new com.kwad.components.core.webview.b();
        this.f11931hk.a(new b.a().aG(this.QL.mAdTemplate).aI(this.QL.mPageUrl).d(this.mAdWebView).k(this.QL.f8if).a(this.hl).b(this.QL.QN).a(this));
        qt();
        com.kwad.sdk.commercial.g.a.l(this.mAdTemplate, this.Qw.pW(), this.Qw.pV());
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.components.core.page.c.a.g.1

            /* renamed from: com.kwad.components.core.page.c.a.g$1$1 */
            public class RunnableC04401 implements Runnable {
                final /* synthetic */ Object Rs;
                final /* synthetic */ com.kwad.components.core.urlReplace.c Rt;
                final /* synthetic */ c.a Ru;

                public RunnableC04401(Object obj2, com.kwad.components.core.urlReplace.c cVar2, c.a clientConfig2) {
                    obj = obj2;
                    cVar2 = cVar2;
                    clientConfig = clientConfig2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (obj) {
                        try {
                            com.kwad.components.core.urlReplace.c cVar2 = cVar2;
                            if (cVar2 != null) {
                                cVar2.rY();
                            }
                            c.a aVar = clientConfig;
                            if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                            } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                            } else {
                                com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }

            /* renamed from: com.kwad.components.core.page.c.a.g$1$2 */
            public class AnonymousClass2 implements com.kwad.components.core.urlReplace.a {
                final /* synthetic */ Object Rs;
                final /* synthetic */ c.a Ru;

                public AnonymousClass2(Object obj2, c.a clientConfig2) {
                    obj = obj2;
                    clientConfig = clientConfig2;
                }

                @Override // com.kwad.components.core.urlReplace.a
                public final void onSuccess(String str2) {
                    synchronized (obj) {
                        try {
                            g.this.Rp = str2;
                            if (g.this.Rq != null) {
                                g.f11930hf.removeCallbacks(g.this.Rq);
                            }
                            c.a aVar = clientConfig;
                            if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                            } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                            } else {
                                com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
                com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(g.this.mAdTemplate);
                g.this.Rp = str;
                if (!com.kwad.sdk.core.response.b.a.bj(eb2) || !aj.cA(g.this.QL.mContext) || !aj.gN(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                c.a clientConfig2 = g.this.mAdWebView.getClientConfig();
                com.kwad.components.core.urlReplace.c cVar2 = new com.kwad.components.core.urlReplace.c();
                Object obj2 = new Object();
                g.this.Rq = new Runnable() { // from class: com.kwad.components.core.page.c.a.g.1.1
                    final /* synthetic */ Object Rs;
                    final /* synthetic */ com.kwad.components.core.urlReplace.c Rt;
                    final /* synthetic */ c.a Ru;

                    public RunnableC04401(Object obj22, com.kwad.components.core.urlReplace.c cVar22, c.a clientConfig22) {
                        obj = obj22;
                        cVar2 = cVar22;
                        clientConfig = clientConfig22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        synchronized (obj) {
                            try {
                                com.kwad.components.core.urlReplace.c cVar22 = cVar2;
                                if (cVar22 != null) {
                                    cVar22.rY();
                                }
                                c.a aVar = clientConfig;
                                if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                    com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                                } else {
                                    com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                };
                g.f11930hf.postDelayed(g.this.Rq, com.kwad.sdk.core.response.b.a.bk(eb2));
                cVar22.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.c.a.g.1.2
                    final /* synthetic */ Object Rs;
                    final /* synthetic */ c.a Ru;

                    public AnonymousClass2(Object obj22, c.a clientConfig22) {
                        obj = obj22;
                        clientConfig = clientConfig22;
                    }

                    @Override // com.kwad.components.core.urlReplace.a
                    public final void onSuccess(String str2) {
                        synchronized (obj) {
                            try {
                                g.this.Rp = str2;
                                if (g.this.Rq != null) {
                                    g.f11930hf.removeCallbacks(g.this.Rq);
                                }
                                c.a aVar = clientConfig;
                                if (aVar == null || !aVar.IK() || !clientConfig.IG()) {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Rp) == 1) {
                                    com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                                } else {
                                    com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                });
                return true;
            }
        };
        anonymousClass1.setClientConfig(this.mAdWebView.getClientConfig());
        this.mAdWebView.setWebViewClient(anonymousClass1);
        this.mAdWebView.loadUrl(this.QL.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void qt() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bz(true).ex(this.QL.mAdTemplate).bx(false));
        if (com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate)) > 0) {
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.5
                public AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bx(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bx(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.6
            public AnonymousClass6() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().bx(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        b bVar = this.QL;
        this.Qw = bVar.Qw;
        this.mAdTemplate = bVar.mAdTemplate;
        eM();
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(this.yv);
    }

    public final void hide() {
        ay ayVar = this.Rn;
        if (ayVar != null) {
            ayVar.tw();
        }
        KsAdWebView ksAdWebView = this.QL.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ay ayVar2 = this.Rn;
        if (ayVar2 != null) {
            ayVar2.tx();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11931hk.jK();
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.b(this.yv);
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void qu() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void show() {
        if (this.Rl) {
            ay ayVar = this.Rn;
            if (ayVar != null) {
                ayVar.tu();
            }
            try {
                KsAdWebView ksAdWebView = this.QL.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(0);
                }
            } catch (Exception e10) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e10);
            }
            ay ayVar2 = this.Rn;
            if (ayVar2 != null) {
                ayVar2.tv();
            }
        }
    }

    public static /* synthetic */ boolean b(g gVar, boolean z10) {
        gVar.Rm = true;
        return true;
    }

    public static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    /* renamed from: com.kwad.components.core.page.c.a.g$4 */
    public class AnonymousClass4 extends com.kwad.components.core.webview.c {

        /* renamed from: com.kwad.components.core.page.c.a.g$4$1 */
        public class AnonymousClass1 implements bf.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.bf.b
            public final void a(bf.a aVar2) {
                f.a aVar22 = g.this.QL.QO;
                if (aVar22 == null || aVar2 == null) {
                    return;
                }
                aVar22.aC(aVar2.visibility);
            }
        }

        /* renamed from: com.kwad.components.core.page.c.a.g$4$2 */
        public class AnonymousClass2 implements au.b {
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.au.b
            public final void qz() {
                g gVar = g.this;
                gVar.QL.a(gVar.QP);
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bf(new bf.b() { // from class: com.kwad.components.core.page.c.a.g.4.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.jshandler.bf.b
                public final void a(bf.a aVar2) {
                    f.a aVar22 = g.this.QL.QO;
                    if (aVar22 == null || aVar2 == null) {
                        return;
                    }
                    aVar22.aC(aVar2.visibility);
                }
            }));
            g.this.Ro = new au(new au.b() { // from class: com.kwad.components.core.page.c.a.g.4.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.jshandler.au.b
                public final void qz() {
                    g gVar = g.this;
                    gVar.QL.a(gVar.QP);
                }
            });
            aVar.a(g.this.Ro);
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.b(bVar, g.this.QL.mAdTemplate));
            k kVar = new k();
            kVar.ads = g.this.QL.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i10, String str) {
            g.this.Rl = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.g.a.a(gVar.mAdTemplate, gVar.Qw.pW(), g.this.Qw.pV(), i10, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Rl = true;
            if (!g.this.Rm) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.g.a.m(gVar.mAdTemplate, gVar.Qw.pW(), g.this.Qw.pV());
            }
            if (g.this.QL.qj()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qx() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ay ayVar) {
            g.this.Rn = ayVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ar.a aVar) {
            g.this.QL.QQ = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.QL.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    }
}
