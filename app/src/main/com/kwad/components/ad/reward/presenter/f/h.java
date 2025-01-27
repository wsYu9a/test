package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.e;
import com.kwad.sdk.R;
import com.kwad.sdk.components.s;

/* loaded from: classes2.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private ay cU;

    /* renamed from: yc */
    private boolean f11779yc;

    /* renamed from: yd */
    private boolean f11780yd;

    /* renamed from: yg */
    @Nullable
    private View f11781yg;

    /* renamed from: yh */
    private boolean f11782yh = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            h.this.f11778yf.setVisibility(8);
        }
    };

    /* renamed from: yi */
    private g.a f11783yi = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void go() {
            h.this.f11780yd = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gp() {
            h.this.f11780yd = true;
            h.this.jt();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gq() {
            h.this.f11780yd = false;
            if (h.this.cU != null) {
                h.this.cU.tz();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gr() {
            h.this.f11780yd = false;
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.h$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            h.this.f11778yf.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.h$2 */
    public class AnonymousClass2 implements g.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void go() {
            h.this.f11780yd = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gp() {
            h.this.f11780yd = true;
            h.this.jt();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gq() {
            h.this.f11780yd = false;
            if (h.this.cU != null) {
                h.this.cU.tz();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void gr() {
            h.this.f11780yd = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.h$3 */
    public class AnonymousClass3 implements e.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.e.b
        public final int jx() {
            if (h.this.rO.qM != null) {
                return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), r0.cB());
            }
            if (h.this.f11781yg == null) {
                return 0;
            }
            return h.this.f11781yg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.f11781yg.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.f11781yg.getHeight());
        }
    }

    public void jt() {
        ay ayVar = this.cU;
        if (ayVar == null || !this.f11780yd) {
            return;
        }
        if (this.f11779yc) {
            ayVar.ty();
            return;
        }
        ayVar.tu();
        this.cU.tv();
        this.f11779yc = true;
    }

    private e.b jw() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.e.b
            public final int jx() {
                if (h.this.rO.qM != null) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), r0.cB());
                }
                if (h.this.f11781yg == null) {
                    return 0;
                }
                return h.this.f11781yg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.f11781yg.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.f11781yg.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.a(this.f11783yi);
        this.rO.f11692qi.a(this);
        this.rO.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        super.ay();
        jt();
        this.f11782yh = true;
        this.f11778yf.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
        if (this.f11782yh) {
            this.f11778yf.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
        if (this.f11782yh) {
            this.f11778yf.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dv(this.rO.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int ih() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        super.onUnbind();
        this.rO.b(this.f11783yi);
        this.rO.f11692qi.b(this);
        this.rO.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().b(this);
        this.rO.a((com.kwad.components.core.webview.tachikoma.e.a) null);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        this.f11782yh = false;
        this.f11778yf.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((screenHeight / ba2) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(sVar, bVar);
        sVar.c(new com.kwad.components.core.webview.tachikoma.a.e(jw()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        super.a(ayVar);
        this.cU = ayVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.f11781yg = view;
    }
}
