package com.kwad.components.ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class n extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {

    /* renamed from: if */
    private ViewGroup f3if;

    /* renamed from: ig */
    private com.kwad.components.core.l.b f11730ig;

    /* renamed from: ih */
    @Nullable
    private r f11731ih;

    /* renamed from: ij */
    private FrameLayout f11732ij;

    /* renamed from: ik */
    private com.kwad.components.ad.reward.presenter.f.b f11733ik;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a im;

    /* renamed from: io */
    private com.kwad.components.ad.reward.presenter.f.f f11734io;
    private boolean iq = false;

    /* renamed from: lf */
    private com.kwad.components.core.webview.tachikoma.e.f f11735lf = new com.kwad.components.core.webview.tachikoma.e.f() { // from class: com.kwad.components.ad.reward.n.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            n.this.rO.lm = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_reward".equals(str) || "tk_live_video".equals(str)) {
                n nVar = n.this;
                nVar.a(nVar);
                g.a(n.this.getContext(), n.this.rO, n.this.cs());
                n.this.rO.a(RewardRenderResult.DEFAULT);
                n nVar2 = n.this;
                nVar2.a(nVar2.f11730ig, n.this.mModel);
                return;
            }
            if ("tk_image_video".equals(str)) {
                n nVar3 = n.this;
                nVar3.a(nVar3);
                n.this.rO.a(RewardRenderResult.DEFAULT);
                n nVar4 = n.this;
                nVar4.a(nVar4.f11730ig, n.this.mModel);
            }
        }
    };
    private Context mContext;
    private com.kwad.components.ad.reward.model.c mModel;
    private g rO;

    @Nullable
    private a rP;

    /* renamed from: com.kwad.components.ad.reward.n$1 */
    public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.e.f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            n.this.rO.lm = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_reward".equals(str) || "tk_live_video".equals(str)) {
                n nVar = n.this;
                nVar.a(nVar);
                g.a(n.this.getContext(), n.this.rO, n.this.cs());
                n.this.rO.a(RewardRenderResult.DEFAULT);
                n nVar2 = n.this;
                nVar2.a(nVar2.f11730ig, n.this.mModel);
                return;
            }
            if ("tk_image_video".equals(str)) {
                n nVar3 = n.this;
                nVar3.a(nVar3);
                n.this.rO.a(RewardRenderResult.DEFAULT);
                n nVar4 = n.this;
                nVar4.a(nVar4.f11730ig, n.this.mModel);
            }
        }
    }

    public interface a {
        void onUnbind();
    }

    public n(com.kwad.components.core.l.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z10 = false;
        this.mContext = context;
        this.f3if = viewGroup;
        this.mModel = cVar;
        this.rO = gVar;
        this.f11730ig = bVar;
        a(cVar);
        AdInfo ce2 = cVar.ce();
        boolean em = com.kwad.sdk.core.response.b.b.em(ce2);
        boolean z11 = (com.kwad.sdk.core.response.b.a.cS(ce2) && a(this.rO.mAdResultData.adGlobalConfigInfo)) || com.kwad.sdk.core.response.b.a.bd(ce2) || g.K(cVar.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.dd(ce2) && a(this.rO.mAdResultData.adGlobalConfigInfo)) {
            z10 = true;
        }
        com.kwad.sdk.core.d.c.d("RewardPresenter", "notFullTk: " + z11 + ", mLoadStrategy: " + this.rO.qZ);
        if (z10) {
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11735lf);
            gVar.a(RewardRenderResult.LIVE_TK);
            cn();
        } else if (em) {
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11735lf);
            gVar.a(RewardRenderResult.TK_IMAGE);
            co();
        } else if (z11 || !this.rO.qZ.equals(LoadStrategy.FULL_TK)) {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        } else {
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11735lf);
            gVar.a(RewardRenderResult.NEO_TK);
            gH();
        }
    }

    private void cn() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.f11733ik = bVar;
        a(bVar);
    }

    private void co() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.f11734io = cVar;
        a(cVar);
    }

    public FrameLayout cs() {
        if (this.f11732ij == null) {
            this.f11732ij = (FrameLayout) this.f3if.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.f11732ij;
    }

    private void gH() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.f11734io = fVar;
        a(fVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.b(this);
        com.kwad.components.ad.reward.c.a.hg().setCallerContext(this.rO);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void ch() {
        this.rO.D(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.rO.E(false);
        this.rO.fO();
    }

    public final BackPressHandleResult gI() {
        r rVar = this.f11731ih;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.im;
        if (aVar != null) {
            BackPressHandleResult gI = aVar.gI();
            BackPressHandleResult backPressHandleResult = BackPressHandleResult.HANDLED;
            if (gI == backPressHandleResult) {
                return backPressHandleResult;
            }
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.f11733ik;
        if (bVar != null) {
            return bVar.gI();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.f11734io;
        return fVar != null ? fVar.gI() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11732ij = (FrameLayout) this.f3if.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f11730ig = null;
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.f11735lf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this);
        a aVar = this.rP;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.pg().b(this);
        com.kwad.components.ad.reward.c.a.hg().reset();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.rO.fP();
        this.rO.E(true);
    }

    private static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    public void a(n nVar) {
        if (this.iq) {
            return;
        }
        nVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.rO), true);
        this.iq = true;
    }

    public void a(com.kwad.components.core.l.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.pg().a(this);
        AdInfo ce2 = this.mModel.ce();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.hG) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean hD = cVar.hD();
        boolean hE = cVar.hE();
        boolean z10 = cVar.cf() && !an.isOrientationPortrait();
        if (!hD && !hE && !z10) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(ce2), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(ce2, this.f3if), true);
        r rVar = new r(adTemplate);
        this.f11731ih = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        g gVar = this.rO;
        if (gVar.qu && com.kwad.components.ad.reward.d.a.b(gVar.mContext, com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.b.b.dr(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.b.a.cS(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo ce2 = cVar.ce();
        if (!cVar.hG) {
            a(this);
        }
        if (g.g(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.b.a.aO(ce2) && an.NS()) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.b.b.dx(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.b.b.ej(ce2) && an.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.im = aVar;
            a(aVar);
        }
    }

    public final void a(@Nullable a aVar) {
        this.rP = aVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
