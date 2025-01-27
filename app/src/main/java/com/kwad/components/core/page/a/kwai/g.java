package com.kwad.components.core.page.a.kwai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class g extends a {
    private com.kwad.components.core.webview.b Mf;
    private an Mh;
    private al Mi;
    private KsAdWebView mAdWebView;
    private boolean Mg = false;
    private final com.kwad.sdk.core.b.c wK = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.page.a.kwai.g.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            g.this.show();
        }
    };
    private al.b LK = new al.b() { // from class: com.kwad.components.core.page.a.kwai.g.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void ox() {
            if (g.this.Mi != null) {
                g.this.Mi.qY();
            }
        }
    };
    private com.kwad.components.core.webview.c Mj = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.a.kwai.g.3

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$1 */
        final class AnonymousClass1 implements at.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                f.a aVar2 = g.this.LG.LJ;
                if (aVar2 == null || aVar == null) {
                    return;
                }
                aVar2.az(aVar.visibility);
            }
        }

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$2 */
        final class AnonymousClass2 implements al.c {
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.al.c
            public final void oB() {
                g gVar = g.this;
                gVar.LG.a(gVar.LK);
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new at(new at.b() { // from class: com.kwad.components.core.page.a.kwai.g.3.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.jshandler.at.b
                public final void a(at.a aVar2) {
                    f.a aVar22 = g.this.LG.LJ;
                    if (aVar22 == null || aVar2 == null) {
                        return;
                    }
                    aVar22.az(aVar2.visibility);
                }
            }));
            g.this.Mi = new al(new al.c() { // from class: com.kwad.components.core.page.a.kwai.g.3.2
                AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.jshandler.al.c
                public final void oB() {
                    g gVar = g.this;
                    gVar.LG.a(gVar.LK);
                }
            });
            aVar.a(g.this.Mi);
            aVar.a(new com.kwad.components.core.webview.a.kwai.b(bVar, g.this.LG.mAdTemplate));
            k kVar = new k();
            kVar.Vd = g.this.LG.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.a.kwai.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ai.a aVar) {
            g.this.LG.LL = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void oA() {
            g.this.Mg = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Mg = true;
            if (g.this.LG.ol()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onRegisterLifecycleLisener(an anVar) {
            g.this.Mh = anVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oz() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void pageClose(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.c.kwai.b bVar = g.this.LG.mWebCardCloseListener;
            if (bVar != null) {
                bVar.a(webCloseStatus);
            }
        }
    };

    /* renamed from: com.kwad.components.core.page.a.kwai.g$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.b.d {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            g.this.show();
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.g$2 */
    final class AnonymousClass2 implements al.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void ox() {
            if (g.this.Mi != null) {
                g.this.Mi.qY();
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.g$3 */
    final class AnonymousClass3 extends com.kwad.components.core.webview.c {

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$1 */
        final class AnonymousClass1 implements at.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar2) {
                f.a aVar22 = g.this.LG.LJ;
                if (aVar22 == null || aVar2 == null) {
                    return;
                }
                aVar22.az(aVar2.visibility);
            }
        }

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$2 */
        final class AnonymousClass2 implements al.c {
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.al.c
            public final void oB() {
                g gVar = g.this;
                gVar.LG.a(gVar.LK);
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new at(new at.b() { // from class: com.kwad.components.core.page.a.kwai.g.3.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.jshandler.at.b
                public final void a(at.a aVar2) {
                    f.a aVar22 = g.this.LG.LJ;
                    if (aVar22 == null || aVar2 == null) {
                        return;
                    }
                    aVar22.az(aVar2.visibility);
                }
            }));
            g.this.Mi = new al(new al.c() { // from class: com.kwad.components.core.page.a.kwai.g.3.2
                AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.jshandler.al.c
                public final void oB() {
                    g gVar = g.this;
                    gVar.LG.a(gVar.LK);
                }
            });
            aVar.a(g.this.Mi);
            aVar.a(new com.kwad.components.core.webview.a.kwai.b(bVar, g.this.LG.mAdTemplate));
            k kVar = new k();
            kVar.Vd = g.this.LG.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.a.kwai.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ai.a aVar) {
            g.this.LG.LL = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void oA() {
            g.this.Mg = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Mg = true;
            if (g.this.LG.ol()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onRegisterLifecycleLisener(an anVar) {
            g.this.Mh = anVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oz() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void pageClose(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.c.kwai.b bVar = g.this.LG.mWebCardCloseListener;
            if (bVar != null) {
                bVar.a(webCloseStatus);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.g$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public final void run() {
            if (g.this.mAdWebView != null) {
                g.this.mAdWebView.getClientConfig().bc(true);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.g$5 */
    final class AnonymousClass5 implements View.OnTouchListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            g.this.mAdWebView.getClientConfig().bc(true);
            return false;
        }
    }

    static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    private void eP() {
        this.Mf = new com.kwad.components.core.webview.b();
        this.Mf.a(new b.a().Q(this.LG.mAdTemplate).aH(this.LG.mPageUrl).d(this.mAdWebView).j(this.LG.gv).a(this.Mj).b(this.LG.LI));
        ow();
        this.mAdWebView.loadUrl(this.LG.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ow() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().be(true).ct(this.LG.mAdTemplate).bc(false));
        if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)) > 0) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.g.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bc(true);
                    }
                }
            }, com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bc(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.a.kwai.g.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().bc(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        eP();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(this.wK);
    }

    public final void hide() {
        an anVar = this.Mh;
        if (anVar != null) {
            anVar.rb();
        }
        ViewGroup viewGroup = this.LG.gv;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        an anVar2 = this.Mh;
        if (anVar2 != null) {
            anVar2.rc();
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
        this.Mf.unBind();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.b(this.wK);
    }

    public final void show() {
        if (this.Mg) {
            an anVar = this.Mh;
            if (anVar != null) {
                anVar.qZ();
            }
            try {
                ViewGroup viewGroup = this.LG.gv;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
            } catch (Exception e2) {
                com.kwad.components.core.c.a.b(e2);
            }
            an anVar2 = this.Mh;
            if (anVar2 != null) {
                anVar2.ra();
            }
        }
    }
}
