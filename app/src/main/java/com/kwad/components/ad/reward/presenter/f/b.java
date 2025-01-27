package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.R;
import com.kwad.sdk.components.s;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public class b extends d {
    private FrameLayout xJ;
    private boolean xK = false;

    /* renamed from: com.kwad.components.ad.reward.presenter.f.b$1 */
    public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
            cVar2.adm = com.kwad.components.ad.reward.model.b.dk();
            cVar.a(cVar2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.b$2 */
    public class AnonymousClass2 implements b.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.b.a
        public final void eh() {
            com.kwad.components.ad.reward.model.b.K(b.this.rO.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.b$3 */
    public class AnonymousClass3 extends w {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void a(x xVar) {
            super.a(xVar);
            b.this.rO.f11688qe.onVideoPlayStart();
            com.kwad.components.ad.reward.monitor.c.b(b.this.rO.qu, b.this.rO.mAdTemplate, b.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void b(x xVar) {
            super.b(xVar);
            long ub2 = xVar.ub();
            b.this.rO.f11688qe.onVideoPlayError(xVar.errorCode, (int) ub2);
            com.kwad.components.ad.reward.monitor.c.a(b.this.rO.qu, b.this.rO.mAdTemplate, b.this.rO.qT, xVar.errorCode, ub2);
            com.kwad.components.ad.reward.monitor.b.c(b.this.rO.qu, b.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void c(x xVar) {
            super.c(xVar);
            b.this.rO.f11688qe.onVideoPlayEnd();
            b.this.rO.mAdTemplate.setmCurPlayTime(-1L);
            com.kwad.components.ad.reward.presenter.f.u(b.this.rO);
        }

        @Override // com.kwad.components.core.webview.jshandler.w
        public final void d(x xVar) {
            super.d(xVar);
            b.this.rO.mAdTemplate.setmCurPlayTime(xVar.oZ);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.b$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ t xM;

        public AnonymousClass4(t tVar) {
            tVar = tVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (b.this.rO != null && b.this.rO.f11688qe != null) {
                b.this.rO.f11688qe.onVideoSkipToEnd(tVar.YF * 1000);
            }
            com.kwad.components.ad.reward.presenter.f.u(b.this.rO);
        }
    }

    private void U(boolean z10) {
        this.xJ.setVisibility(z10 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c dX() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            public AnonymousClass1() {
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

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.xK) {
            return;
        }
        U(true);
    }

    @IdRes
    public int cE() {
        return R.id.ksad_js_reward_card;
    }

    public final BackPressHandleResult gI() {
        com.kwad.components.ad.reward.k.a.d dVar = this.xN;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.gI();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.xJ;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dx(this.rO.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean jh() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xJ = (FrameLayout) findViewById(cE());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(dX());
        sVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eh() {
                com.kwad.components.ad.reward.model.b.K(b.this.rO.mContext);
            }
        }));
        sVar.c(new w() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void a(x xVar) {
                super.a(xVar);
                b.this.rO.f11688qe.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(b.this.rO.qu, b.this.rO.mAdTemplate, b.this.rO.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void b(x xVar) {
                super.b(xVar);
                long ub2 = xVar.ub();
                b.this.rO.f11688qe.onVideoPlayError(xVar.errorCode, (int) ub2);
                com.kwad.components.ad.reward.monitor.c.a(b.this.rO.qu, b.this.rO.mAdTemplate, b.this.rO.qT, xVar.errorCode, ub2);
                com.kwad.components.ad.reward.monitor.b.c(b.this.rO.qu, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void c(x xVar) {
                super.c(xVar);
                b.this.rO.f11688qe.onVideoPlayEnd();
                b.this.rO.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(b.this.rO);
            }

            @Override // com.kwad.components.core.webview.jshandler.w
            public final void d(x xVar) {
                super.d(xVar);
                b.this.rO.mAdTemplate.setmCurPlayTime(xVar.oZ);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        com.kwad.sdk.core.d.c.d("TKLivePresenter", "onSkipClick: " + tVar.YF);
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            final /* synthetic */ t xM;

            public AnonymousClass4(t tVar2) {
                tVar = tVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (b.this.rO != null && b.this.rO.f11688qe != null) {
                    b.this.rO.f11688qe.onVideoSkipToEnd(tVar.YF * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.u(b.this.rO);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.xK = true;
        U(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((screenHeight / ba2) + 0.5f);
    }
}
