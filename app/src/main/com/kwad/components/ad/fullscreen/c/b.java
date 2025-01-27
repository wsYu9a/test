package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {

    /* renamed from: ie */
    private com.kwad.components.ad.fullscreen.b f11521ie;

    /* renamed from: if */
    private ViewGroup f1if;

    /* renamed from: ig */
    private com.kwad.components.core.l.b f11522ig;

    /* renamed from: ih */
    @Nullable
    private r f11523ih;

    /* renamed from: ij */
    private FrameLayout f11524ij;

    /* renamed from: ik */
    private com.kwad.components.ad.reward.presenter.f.b f11525ik;
    private com.kwad.components.core.webview.tachikoma.e.f il;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a im;

    /* renamed from: io */
    private com.kwad.components.ad.reward.presenter.f.f f11526io;
    private boolean iq = false;

    /* renamed from: com.kwad.components.ad.fullscreen.c.b$1 */
    public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.e.f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            b.this.rO.lm = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_fullscreen".equals(str) || "tk_live_video".equals(str)) {
                b bVar = b.this;
                bVar.a(bVar);
                com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.rO, b.this.cs());
                b.this.cm();
                return;
            }
            if ("tk_image_video".equals(str)) {
                b bVar2 = b.this;
                bVar2.a(bVar2);
                b.this.rO.a(RewardRenderResult.DEFAULT);
                b.this.cm();
            }
        }
    }

    public b(com.kwad.components.core.l.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.f11522ig = bVar;
        this.f11521ie = bVar2;
        this.f1if = viewGroup;
        this.rO = gVar;
        cl();
    }

    private void cl() {
        if (this.f11521ie == null) {
            return;
        }
        cq();
        AdInfo ce2 = this.f11521ie.ce();
        boolean dd2 = com.kwad.sdk.core.response.b.a.dd(ce2);
        boolean em = com.kwad.sdk.core.response.b.b.em(ce2);
        if (dd2) {
            this.rO.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(cr());
            cn();
        } else if (em) {
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(cr());
            this.rO.a(RewardRenderResult.TK_IMAGE);
            co();
        } else if (!a(this.rO)) {
            this.rO.a(RewardRenderResult.DEFAULT);
            cm();
        } else {
            this.rO.a(RewardRenderResult.FULLSCREEN_TK);
            cp();
            com.kwad.components.core.webview.tachikoma.d.b.uj().a(cr());
        }
    }

    public void cm() {
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.il);
        com.kwad.components.core.e.e.g.pg().a(this);
        AdTemplate adTemplate = this.f11521ie.getAdTemplate();
        AdInfo ce2 = this.f11521ie.ce();
        boolean z10 = this.f11521ie.cf() && !an.isOrientationPortrait();
        if (this.f11521ie.hG) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(ce2)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dx(ce2)) {
            a(new h(), true);
        }
        if (!z10) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.dq(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.cS(ce2)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.f11523ih = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new e(ce2, this.f1if), true);
        a(new j(), true);
    }

    private void cn() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.f11525ik = cVar;
        a(cVar);
    }

    private void co() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.f11526io = aVar;
        a(aVar);
    }

    private void cp() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void cq() {
        AdInfo ce2 = this.f11521ie.ce();
        if (!this.f11521ie.hG) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.ej(ce2) && an.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.im = aVar;
            a((Presenter) aVar, true);
        }
    }

    private com.kwad.components.core.webview.tachikoma.e.f cr() {
        if (this.il == null) {
            this.il = new com.kwad.components.core.webview.tachikoma.e.f() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.f
                public final void a(String str, long j10, long j11, long j12) {
                    b.this.rO.lm = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void s(String str) {
                    if ("tk_fullscreen".equals(str) || "tk_live_video".equals(str)) {
                        b bVar = b.this;
                        bVar.a(bVar);
                        com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.rO, b.this.cs());
                        b.this.cm();
                        return;
                    }
                    if ("tk_image_video".equals(str)) {
                        b bVar2 = b.this;
                        bVar2.a(bVar2);
                        b.this.rO.a(RewardRenderResult.DEFAULT);
                        b.this.cm();
                    }
                }
            };
        }
        return this.il;
    }

    public FrameLayout cs() {
        if (this.f11524ij == null) {
            this.f11524ij = (FrameLayout) this.f1if.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.f11524ij;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.b(this);
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

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        r rVar = this.f11523ih;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.im;
        if (aVar != null && aVar.gI() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.f11525ik;
        return bVar != null && bVar.gI() == BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11524ij = (FrameLayout) this.f1if.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this);
        com.kwad.components.core.e.e.g.pg().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.il);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.rO.fP();
        this.rO.E(true);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!com.kwad.sdk.core.config.d.Du()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo dl = com.kwad.sdk.core.response.b.b.dl(gVar.mAdTemplate);
        if (dl != null && dl.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    public void a(b bVar) {
        if (this.iq) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.rO), true);
        this.iq = true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
