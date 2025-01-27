package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, ar.b {
    private com.kwad.components.core.webview.tachikoma.e.f il;
    private boolean uA;
    private boolean uB;
    private boolean uC;

    /* renamed from: uf */
    private float f11858uf;
    private boolean uu;

    @Nullable
    private a uv;

    @Nullable
    private q uw;

    @Nullable
    private o ux;
    private p uy;
    private int uz;

    /* renamed from: com.kwad.components.ad.reward.presenter.r$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            r.this.hZ();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.r$2 */
    public class AnonymousClass2 extends com.kwad.components.core.webview.tachikoma.e.f {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            r.this.hZ();
        }
    }

    public class a extends com.kwad.components.core.video.l {
        private long uE;
        private long videoDuration;

        private a() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            this.uE = j11;
            this.videoDuration = j10;
            if (r.this.rO.fR()) {
                return;
            }
            r.this.a(j10, j11, false);
        }

        public /* synthetic */ a(r rVar, byte b10) {
            this();
        }
    }

    public r(AdTemplate adTemplate, boolean z10, boolean z11) {
        this.uz = 0;
        this.uA = false;
        this.uB = z10;
        this.uC = z11;
        if (com.kwad.sdk.core.response.b.a.bJ(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            p pVar = new p();
            this.uy = pVar;
            a(pVar);
        }
    }

    private com.kwad.components.core.webview.tachikoma.e.f cr() {
        if (this.il == null) {
            this.il = new com.kwad.components.core.webview.tachikoma.e.f() { // from class: com.kwad.components.ad.reward.presenter.r.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void s(String str) {
                    r.this.hZ();
                }
            };
        }
        return this.il;
    }

    public void hZ() {
        if (this.uC) {
            q qVar = new q(this);
            this.uw = qVar;
            a((Presenter) qVar, true);
        }
        if (this.uB) {
            o oVar = new o(this);
            this.ux = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean ia() {
        return this.uu;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bJ(eb2)) {
            if (this.rO.qv) {
                com.kwad.components.core.webview.tachikoma.d.b.uj().a(cr());
            } else {
                bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        r.this.hZ();
                    }
                }, 100L);
            }
        } else if (!com.kwad.sdk.core.response.b.a.bM(eb2)) {
            com.kwad.components.core.o.a.ri().aC(this.rO.mAdTemplate);
        }
        this.rO.b(this);
        com.kwad.components.core.playable.a aVar = this.rO.f11691qh;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean gR = com.kwad.components.ad.reward.a.b.gR();
        this.f11858uf = com.kwad.components.ad.reward.a.b.gQ();
        if (gR) {
            a aVar2 = new a(this, (byte) 0);
            this.uv = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.rO.f11689qf;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.fr().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void ch() {
        RewardActionBarControl.ShowActionBarResult iB = this.rO.f11692qi.iB();
        if (iB != null) {
            iB.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.uy == null || this.rO.gb()) {
            return;
        }
        if (ia()) {
            this.uy.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.uy.hU();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
        this.rO.A(false);
        a aVar = this.uv;
        if (aVar == null || this.uz != 2) {
            return;
        }
        a(aVar.videoDuration, this.uv.uE, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean gf2 = this.rO.gf();
        if (!this.rO.fR() || gf2) {
            return false;
        }
        com.kwad.components.ad.reward.a.fr().fs();
        this.rO.A(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.rO.c(this);
        com.kwad.components.core.playable.a aVar = this.rO.f11691qh;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.uv;
        if (aVar2 != null && (eVar = this.rO.f11689qf) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.fr().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.il);
    }

    @Override // com.kwad.components.core.webview.jshandler.ar.b
    public final void a(ar.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.uu = isSuccess;
        if (!isSuccess || (aVar2 = this.uv) == null) {
            return;
        }
        a(aVar2.videoDuration, this.uv.uE, false);
    }

    public void a(long j10, long j11, boolean z10) {
        q qVar;
        if (!ia() || j11 < 10000 || j11 < j10 * this.f11858uf) {
            return;
        }
        if (com.kwad.components.ad.reward.a.b.gS()) {
            if (this.uA || (qVar = this.uw) == null) {
                return;
            }
            qVar.hV();
            this.uz = 1;
            this.uA = true;
            return;
        }
        o oVar = this.ux;
        if (oVar != null) {
            oVar.I(true ^ z10);
            this.uz = 2;
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.rO.A(true);
        int i10 = this.uz;
        if (i10 == 1 && (qVar = this.uw) != null) {
            qVar.hW();
        } else {
            if (i10 != 2 || (oVar = this.ux) == null) {
                return;
            }
            oVar.hide();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
