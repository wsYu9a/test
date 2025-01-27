package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class f extends a implements j, a.InterfaceC0432a {
    private List<com.kwad.components.core.i.c> bJ;
    private com.kwad.components.core.webview.tachikoma.e mv;
    protected FrameLayout xJ;
    private boolean xK = false;
    private final com.kwad.components.core.webview.tachikoma.e.a qr = new com.kwad.components.core.webview.tachikoma.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.a
        public final void jv() {
            if (f.this.mv != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = f.this.rO.f11685hc ? 1 : 0;
                f.this.mv.b(aVar);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$1 */
    public class AnonymousClass1 implements com.kwad.components.core.webview.tachikoma.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.a
        public final void jv() {
            if (f.this.mv != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = f.this.rO.f11685hc ? 1 : 0;
                f.this.mv.b(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$2 */
    public class AnonymousClass2 implements com.kwad.components.ad.reward.c.d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.c.d
        public final void a(com.kwad.components.ad.reward.c.b bVar) {
            com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar.hj());
            f.this.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$3 */
    public class AnonymousClass3 implements b.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.b.a
        public final void eh() {
            com.kwad.components.ad.reward.model.b.K(f.this.rO.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$4 */
    public class AnonymousClass4 implements o {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.o
        public final void a(i iVar, String str) {
            if (TextUtils.equals(str, "autoCallApp")) {
                iVar.aU(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.eb(f.this.rO.mAdTemplate)) && com.kwad.sdk.core.local.a.Fl() && f.this.rO.mScreenOrientation == 0);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$5 */
    public class AnonymousClass5 extends com.kwad.components.core.webview.tachikoma.e {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
            aVar.adk = f.this.rO.f11685hc ? 1 : 0;
            cVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$6 */
    public class AnonymousClass6 extends com.kwad.components.core.webview.tachikoma.c {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
            cVar2.adm = com.kwad.components.ad.reward.model.b.dk();
            cVar.a(cVar2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.f$7 */
    public class AnonymousClass7 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a> {
        public AnonymousClass7() {
        }

        private static void c(com.kwad.components.ad.reward.k.a aVar) {
            aVar.jg();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
            c(aVar);
        }
    }

    private void W(boolean z10) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "fullTK: " + z10);
        FrameLayout frameLayout = this.xJ;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z10 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c dX() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.adm = com.kwad.components.ad.reward.model.b.dk();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e dY() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.adk = f.this.rO.f11685hc ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (!this.xK) {
            W(true);
        }
        com.kwad.components.ad.reward.g gVar = this.rO;
        gVar.qv = true ^ this.xK;
        gVar.a((a.InterfaceC0432a) this);
        com.kwad.components.ad.reward.a.fr().a(this);
    }

    @IdRes
    public int cE() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
        FrameLayout frameLayout;
        if (this.xK || (frameLayout = this.xJ) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
    }

    public final BackPressHandleResult gI() {
        com.kwad.components.ad.reward.k.a.d dVar = this.xN;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.gI();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.xJ;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dw(this.rO.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xJ = (FrameLayout) findViewById(cE());
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onError(int i10, String str) {
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onRequestResult(int i10) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.b((a.InterfaceC0432a) this);
        com.kwad.components.ad.reward.a.fr().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.b.e.b(this.rO.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            this.rO.f11688qe.cg();
            return;
        }
        if (aVar.adTemplate != null && !aVar.aJh) {
            this.rO.f11688qe.cg();
            return;
        }
        com.kwad.components.core.i.c a10 = com.kwad.components.ad.reward.g.a(this.bJ, aVar.creativeId);
        if (a10 != null) {
            this.rO.a(a10);
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0 || this.xN == null) {
            return;
        }
        this.bJ = list;
        List<AdTemplate> a10 = a(list, this.rO.mAdTemplate);
        com.kwad.sdk.core.webview.b tJ = this.xN.tJ();
        if (tJ != null) {
            tJ.setAdTemplateList(a10);
        }
        l jJ = this.xN.jJ();
        if (jJ != null) {
            jJ.g(a10);
        } else {
            this.xN.h(a10);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.xK = true;
        this.rO.qv = false;
        W(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.hj());
                f.this.a(bVar2);
            }
        }));
        this.mv = dY();
        this.rO.a(this.qr);
        sVar.c(this.mv);
        sVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eh() {
                com.kwad.components.ad.reward.model.b.K(f.this.rO.mContext);
            }
        }));
        sVar.c(dX());
        sVar.c(new i(new o() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.jshandler.o
            public final void a(i iVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    iVar.aU(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.eb(f.this.rO.mAdTemplate)) && com.kwad.sdk.core.local.a.Fl() && f.this.rO.mScreenOrientation == 0);
                }
            }
        }));
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.i.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
        FrameLayout frameLayout;
        if (this.xK || (frameLayout = this.xJ) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onSkipClick: " + tVar.YF);
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (gVar != null && (bVar = gVar.f11688qe) != null) {
            bVar.onVideoSkipToEnd(tVar.YF * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.u(this.rO);
        com.kwad.components.ad.reward.g.a(this.rO.qn, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            public AnonymousClass7() {
            }

            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jg();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }
}
