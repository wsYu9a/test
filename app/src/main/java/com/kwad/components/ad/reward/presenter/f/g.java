package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class g extends a implements com.kwad.components.ad.reward.d.h, a.InterfaceC0176a {
    private com.kwad.components.core.webview.a.f lH;
    private List<com.kwad.components.core.g.c> tb;
    private FrameLayout vJ;
    private FrameLayout wn;
    private FrameLayout wo;
    private FrameLayout wp;
    private boolean vK = false;
    private final com.kwad.components.core.webview.a.d.a pa = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.g.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (g.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = g.this.qt.fO ? 1 : 0;
                g.this.lH.b(aVar);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$1 */
    final class AnonymousClass1 implements com.kwad.components.core.webview.a.d.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (g.this.lH != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = g.this.qt.fO ? 1 : 0;
                g.this.lH.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$2 */
    final class AnonymousClass2 implements com.kwad.components.ad.reward.b.d {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.b.d
        public final void a(com.kwad.components.ad.reward.b.b bVar) {
            com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar.gT());
            g.this.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$3 */
    final class AnonymousClass3 implements b.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.a.b.a
        public final void es() {
            com.kwad.components.ad.reward.model.b.L(g.this.qt.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$4 */
    final class AnonymousClass4 implements com.kwad.components.core.webview.jshandler.i {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.i
        public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
            if (TextUtils.equals(str, "autoCallApp")) {
                AdTemplate adTemplate = g.this.qt.mAdTemplate;
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                eVar.h(!com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(cb) && com.kwad.sdk.core.c.a.vV() && g.this.qt.mScreenOrientation == 0);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$5 */
    final class AnonymousClass5 extends com.kwad.components.core.webview.a.f {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
            aVar.UV = g.this.qt.fO ? 1 : 0;
            cVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$6 */
    final class AnonymousClass6 extends com.kwad.components.core.webview.a.c {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
            cVar2.UX = com.kwad.components.ad.reward.model.b.cQ();
            cVar.a(cVar2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.g$7 */
    final class AnonymousClass7 implements com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a> {
        AnonymousClass7() {
        }

        private static void c(com.kwad.components.ad.reward.h.a aVar) {
            aVar.iH();
        }

        @Override // com.kwad.sdk.e.a
        public final /* synthetic */ void accept(com.kwad.components.ad.reward.h.a aVar) {
            c(aVar);
        }
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.g.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.g.c.i(list));
        return arrayList;
    }

    private void aa(boolean z) {
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.vJ;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
        this.wn.setVisibility(z ? 8 : 0);
        this.wo.setVisibility(z ? 8 : 0);
        this.wp.setVisibility(z ? 8 : 0);
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.reward.presenter.f.g.6
            AnonymousClass6() {
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
        return new com.kwad.components.core.webview.a.f() { // from class: com.kwad.components.ad.reward.presenter.f.g.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UV = g.this.qt.fO ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
        FrameLayout frameLayout;
        if (this.vK || (frameLayout = this.vJ) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (!this.vK) {
            aa(true);
        }
        j jVar = this.qt;
        jVar.pg = true ^ this.vK;
        jVar.a((a.InterfaceC0176a) this);
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        FrameLayout frameLayout;
        if (this.vK || (frameLayout = this.vJ) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.vJ;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.j.b("ksad-neo-video-card", this.qt.mAdTemplate);
    }

    public final BackPressHandleResult gs() {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.vM;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.gs();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.a.d.b(this.qt.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
            this.qt.mAdOpenInteractionListener.bN();
            return;
        }
        com.kwad.components.core.g.c a2 = j.a(this.tb, aVar.creativeId);
        if (a2 != null) {
            this.qt.a(a2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vJ = (FrameLayout) findViewById(R.id.ksad_js_reward_card);
        this.wn = (FrameLayout) findViewById(R.id.ksad_js_top);
        this.wo = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wp = (FrameLayout) findViewById(R.id.ksad_js_bottom);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onError(int i2, String str) {
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0 || this.vM == null) {
            return;
        }
        this.tb = list;
        List<AdTemplate> a2 = a(list, this.qt.mAdTemplate);
        com.kwad.sdk.core.webview.b jsBridgeContext = this.vM.getJsBridgeContext();
        if (jsBridgeContext != null) {
            jsBridgeContext.setAdTemplateList(a2);
        }
        com.kwad.components.ad.reward.h.l jj = this.vM.jj();
        if (jj != null) {
            jj.d(a2);
        } else {
            this.vM.e(a2);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.presenter.f.g.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.gT());
                g.this.a(bVar2);
            }
        }));
        this.lH = eo();
        this.qt.a(this.pa);
        lVar.c(this.lH);
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.g.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(g.this.qt.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.e(new com.kwad.components.core.webview.jshandler.i() { // from class: com.kwad.components.ad.reward.presenter.f.g.4
            AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = g.this.qt.mAdTemplate;
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    eVar.h(!com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(cb) && com.kwad.sdk.core.c.a.vV() && g.this.qt.mScreenOrientation == 0);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onRequestResult(int i2) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onSkipClick(u uVar) {
        com.kwad.components.ad.reward.d.b bVar;
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onSkipClick: " + uVar.Vl);
        j jVar = this.qt;
        if (jVar != null && (bVar = jVar.mAdOpenInteractionListener) != null) {
            bVar.onVideoSkipToEnd(uVar.Vl * 1000);
        }
        com.kwad.components.ad.reward.presenter.e.u(this.qt);
        j.a(this.qt.oW, new com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a>() { // from class: com.kwad.components.ad.reward.presenter.f.g.7
            AnonymousClass7() {
            }

            private static void c(com.kwad.components.ad.reward.h.a aVar) {
                aVar.iH();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.h.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.vK = true;
        this.qt.pg = false;
        aa(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.b((a.InterfaceC0176a) this);
        com.kwad.components.ad.reward.b.ff().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
    }

    public final void r(AdTemplate adTemplate) {
        this.vM.resetAdTemplate(adTemplate);
    }
}
