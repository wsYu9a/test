package com.kwad.components.ad.reward.presenter.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bw;

/* loaded from: classes2.dex */
public final class a extends g implements j {
    private i hw;
    private AdInfo mAdInfo;

    /* renamed from: vj */
    private long f11744vj;

    /* renamed from: vk */
    private long f11745vk;
    private boolean vl;
    private boolean vm;
    private g.b vn = new g.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.f11778yf != null && a.this.f11778yf.getVisibility() == 0;
        }
    };

    /* renamed from: ia */
    private final l f11743ia = new l() { // from class: com.kwad.components.ad.reward.presenter.a.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            long a10 = com.kwad.components.ad.reward.g.a(j10, a.this.mAdInfo);
            if (j11 <= a.this.f11744vj || a10 - j11 <= a.this.f11745vk || a.this.vl) {
                return;
            }
            a.a(a.this, true);
            a.this.hw.a(a.this.rO.getActivity(), a.this.rO.mAdResultData, a.this);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.a.a$1 */
    public class AnonymousClass1 implements g.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.f11778yf != null && a.this.f11778yf.getVisibility() == 0;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.a.a$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            long a10 = com.kwad.components.ad.reward.g.a(j10, a.this.mAdInfo);
            if (j11 <= a.this.f11744vj || a10 - j11 <= a.this.f11745vk || a.this.vl) {
                return;
            }
            a.a(a.this, true);
            a.this.hw.a(a.this.rO.getActivity(), a.this.rO.mAdResultData, a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.a.a$3 */
    public class AnonymousClass3 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
            if (a.this.rO.f11688qe != null) {
                a.this.rO.f11688qe.cg();
            }
        }
    }

    private i ii() {
        return new i(-1L, getContext());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.hw == null) {
            this.hw = ii();
        }
        this.mAdInfo = e.eb(this.rO.mAdTemplate);
        this.f11744vj = com.kwad.sdk.core.response.b.a.aJ(r0) * 1000;
        this.f11745vk = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo) * 1000;
        this.rO.f11689qf.a(this.f11743ia);
        this.rO.a(this.vn);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        c.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (an.NS()) {
            this.f11778yf.setVisibility(0);
            com.kwad.components.ad.reward.d.a.P(this.rO.mContext);
            this.rO.f11689qf.pause();
            this.vm = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_interact_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dI(this.rO.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.rO.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int ih() {
        return R.id.ksad_js_interact;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11743ia);
        this.rO.b(this.vn);
        this.hw.jK();
        this.hw = null;
        this.f11778yf.setVisibility(8);
        this.vl = false;
        this.vm = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.vl = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.f11778yf.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.rO;
        sVar.c(new q(bVar, gVar.mApkDownloadHelper, gVar, -1L, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.a.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (a.this.rO.f11688qe != null) {
                    a.this.rO.f11688qe.cg();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        com.kwad.components.ad.reward.g gVar = this.rO;
        boolean z10 = webCloseStatus != null && webCloseStatus.interactSuccess;
        gVar.qx = z10;
        if (z10) {
            gVar.f11689qf.ke();
        }
        if (this.vm && bw.o(this.f11778yf, 30)) {
            this.rO.f11689qf.resume();
        }
        this.f11778yf.setVisibility(8);
    }
}
