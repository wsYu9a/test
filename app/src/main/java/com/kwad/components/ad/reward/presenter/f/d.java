package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class d extends c implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private com.kwad.components.core.webview.a.f lH;
    private final com.kwad.components.core.webview.a.d.a pa = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (d.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = d.this.qt.fO ? 1 : 0;
                d.this.lH.b(aVar);
            }
        }
    };
    private ViewGroup wa;
    private ViewGroup wb;
    private ViewGroup wc;
    private View wd;
    private ViewGroup we;
    private FrameLayout wf;

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$1 */
    final class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.b.a
        public final void es() {
            com.kwad.components.ad.reward.model.b.L(d.this.qt.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$2 */
    final class AnonymousClass2 implements com.kwad.components.core.webview.jshandler.i {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.i
        public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
            if (TextUtils.equals(str, "autoCallApp")) {
                AdTemplate adTemplate = d.this.qt.mAdTemplate;
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                eVar.h(!com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(cb) && com.kwad.sdk.core.c.a.vV() && d.this.qt.mScreenOrientation == 0);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ int wh;

        AnonymousClass3(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int iU = d.this.iU();
            int V = d.this.V(i2);
            if (d.this.wf != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.wf.getLayoutParams();
                layoutParams.width = -1;
                int height = (d.this.qt.mRootContainer.getHeight() - iU) - V;
                if (height < 0) {
                    height = 0;
                }
                layoutParams.topMargin = iU;
                layoutParams.height = height;
                d.this.wf.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$4 */
    final class AnonymousClass4 implements com.kwad.components.core.webview.a.d.a {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (d.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = d.this.qt.fO ? 1 : 0;
                d.this.lH.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$5 */
    final class AnonymousClass5 extends com.kwad.components.core.webview.a.e {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(d.this.qt.mAdTemplate);
            iVar.rewardTime = d.this.qt.pi ? com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(cb) : com.kwad.sdk.core.response.a.a.aC(cb) : 0;
            cVar.a(iVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$6 */
    final class AnonymousClass6 extends com.kwad.components.core.webview.a.f {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
            aVar.UV = d.this.qt.fO ? 1 : 0;
            cVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$7 */
    final class AnonymousClass7 extends com.kwad.components.core.webview.a.c {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
            cVar2.UX = com.kwad.components.ad.reward.model.b.cQ();
            cVar.a(cVar2);
        }
    }

    private void U(int i2) {
        this.qt.mRootContainer.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            final /* synthetic */ int wh;

            AnonymousClass3(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int iU = d.this.iU();
                int V = d.this.V(i2);
                if (d.this.wf != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.wf.getLayoutParams();
                    layoutParams.width = -1;
                    int height = (d.this.qt.mRootContainer.getHeight() - iU) - V;
                    if (height < 0) {
                        height = 0;
                    }
                    layoutParams.topMargin = iU;
                    layoutParams.height = height;
                    d.this.wf.setLayoutParams(layoutParams);
                }
            }
        }, 800L);
    }

    public int V(int i2) {
        ViewGroup viewGroup = this.wb;
        if (viewGroup != null && viewGroup.getHeight() > 0) {
            return this.wb.getHeight();
        }
        ViewGroup viewGroup2 = this.we;
        return (viewGroup2 == null || viewGroup2.getHeight() <= 0) ? i2 > 0 ? i2 : com.kwad.sdk.c.kwai.a.a(getContext(), 120.0f) : this.we.getHeight();
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UX = com.kwad.components.ad.reward.model.b.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.a.f eo() {
        return new com.kwad.components.core.webview.a.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = d.this.qt.fO ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    public int iU() {
        ViewGroup viewGroup;
        int height;
        if (this.wa.getHeight() > 0) {
            viewGroup = this.wa;
        } else {
            if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate)) && (height = ((ViewGroup.MarginLayoutParams) this.wd.getLayoutParams()).topMargin + 0 + this.wd.getHeight()) > 0) {
                return height;
            }
            viewGroup = this.wc;
        }
        return viewGroup.getHeight();
    }

    private com.kwad.components.core.webview.a.e iV() {
        return new com.kwad.components.core.webview.a.e() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(d.this.qt.mAdTemplate);
                iVar.rewardTime = d.this.qt.pi ? com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(cb) : com.kwad.sdk.core.response.a.a.aC(cb) : 0;
                cVar.a(iVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        U(layoutParams != null ? layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + layoutParams.height : layoutParams.height : 0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oQ.a(this);
        this.wf.setVisibility(0);
        U(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return !this.qt.oN.jF();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.wf;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.j.b("ksad-video-middle-card", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wf = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wa = (ViewGroup) findViewById(R.id.ksad_js_top);
        this.wc = (ViewGroup) findViewById(R.id.ksad_play_detail_top_toolbar);
        this.wb = (ViewGroup) findViewById(R.id.ksad_js_bottom);
        this.we = (ViewGroup) findViewById(R.id.ksad_play_web_card_webView);
        this.wd = findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        this.lH = eo();
        this.qt.a(this.pa);
        lVar.c(this.lH);
        lVar.c(iV());
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(d.this.qt.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.e(new com.kwad.components.core.webview.jshandler.i() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = d.this.qt.mAdTemplate;
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    eVar.h(!com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(cb) && com.kwad.sdk.core.c.a.vV() && d.this.qt.mScreenOrientation == 0);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.wf.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oQ.b(this);
        this.qt.a((com.kwad.components.core.webview.a.d.a) null);
    }
}
