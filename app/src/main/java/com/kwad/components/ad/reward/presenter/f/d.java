package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.h;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.a.q;
import com.kwad.components.core.webview.tachikoma.a.y;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    protected com.kwad.components.ad.reward.k.a.d xN;
    private p xO;
    private o xP;
    private i xQ;
    private j xR;
    private com.kwad.components.core.webview.tachikoma.b.y xS;
    private boolean xT;
    private com.kwad.components.core.webview.tachikoma.a.h xU;

    @Nullable
    protected e xV;
    private bh.b xW = new bh.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.bh.b
        public final void R(int i10) {
            com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cL(i10).f(d.this.rO.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ap(false));
            com.kwad.components.ad.reward.j.b.a(d.this.rO.mAdTemplate, d.this.jq(), (String) null, f10, (JSONObject) null);
        }
    };
    private final i.a iF = new i.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.xP == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            m mVar = new m();
            mVar.adu = true;
            d.this.xP.c(mVar);
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.xQ != null) {
                com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
                hVar.adp = 1;
                d.this.xQ.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7

        /* renamed from: com.kwad.components.ad.reward.presenter.f.d$7$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                oVar.scene = 1;
                d.this.xR.a(oVar);
                if (d.this.xU != null) {
                    d.this.xU.aW(d.this.rO.qY);
                }
            }
        }

        public AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (d.this.xR != null) {
                bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                        oVar.scene = 1;
                        d.this.xR.a(oVar);
                        if (d.this.xU != null) {
                            d.this.xU.aW(d.this.rO.qY);
                        }
                    }
                }, 0L);
            }
        }
    };

    /* renamed from: ia */
    private final com.kwad.components.core.video.l f11766ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            d.this.jo();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.a(j10, j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.g(l5.c.f27899e);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            d.this.g(l5.c.f27899e);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$1 */
    public class AnonymousClass1 implements bh.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.bh.b
        public final void R(int i10) {
            com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cL(i10).f(d.this.rO.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ap(false));
            com.kwad.components.ad.reward.j.b.a(d.this.rO.mAdTemplate, d.this.jq(), (String) null, f10, (JSONObject) null);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$10 */
    public class AnonymousClass10 implements aj.b {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            d.this.getTKContainer().setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$11 */
    public class AnonymousClass11 implements d.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.d$11$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.p xZ;

            public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.p pVar) {
                pVar = pVar;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (pVar.adw) {
                    d.this.jk();
                } else {
                    d.this.jl();
                }
            }
        }

        public AnonymousClass11() {
        }

        @Override // com.kwad.components.ad.reward.k.d.a
        public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ao(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.p xZ;

                public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.p pVar2) {
                    pVar = pVar2;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (pVar.adw) {
                        d.this.jk();
                    } else {
                        d.this.jl();
                    }
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$12 */
    public class AnonymousClass12 implements e.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.d$12$1 */
        public class AnonymousClass1 implements a.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                d.this.jm();
            }
        }

        public AnonymousClass12() {
        }

        @Override // com.kwad.components.ad.reward.k.e.a
        public final void jr() {
            com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ao(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.jm();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$13 */
    public class AnonymousClass13 implements h.a {
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.ad.reward.k.h.a
        public final void S(int i10) {
            if (com.kwad.components.ad.reward.g.K(d.this.rO.mAdTemplate)) {
                if (!com.kwad.components.ad.reward.g.I(d.this.rO.mAdTemplate) || d.this.rO.qO == null) {
                    if (com.kwad.components.ad.reward.g.J(d.this.rO.mAdTemplate) && d.this.rO.qP != null && !d.this.rO.qP.jW()) {
                        d.this.rO.qP.jV();
                    }
                } else if (!d.this.rO.qO.jW()) {
                    d.this.rO.qO.jV();
                }
            }
            if (d.this.rO.gd() != RewardRenderResult.DEFAULT) {
                d.this.rO.qE = i10;
            }
            d.this.notifyRewardVerify();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$14 */
    public class AnonymousClass14 extends com.kwad.components.ad.reward.k.c {
        public AnonymousClass14() {
        }

        @Override // com.kwad.components.ad.reward.k.c
        public final void js() {
            super.js();
            d.this.jj();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$15 */
    public class AnonymousClass15 extends com.kwad.components.ad.reward.k.f {
        public AnonymousClass15() {
        }

        @Override // com.kwad.components.ad.reward.k.f
        public final void V(boolean z10) {
            super.V(z10);
            com.kwad.components.ad.reward.presenter.f.v(d.this.rO);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$16 */
    public class AnonymousClass16 extends com.kwad.components.ad.reward.k.b {
        public AnonymousClass16() {
        }

        @Override // com.kwad.components.ad.reward.k.b
        public final void js() {
            super.js();
            d.this.ji();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$2 */
    public class AnonymousClass2 extends q {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            com.kwad.components.core.s.j.f(d.this.getContext(), d.this.rO.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$3 */
    public class AnonymousClass3 implements h.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.h.a
        public final void a(com.kwad.components.core.webview.tachikoma.a.h hVar) {
            hVar.aW(d.this.rO.qY);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$4 */
    public class AnonymousClass4 extends bd {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            boolean z10 = com.kwad.components.core.s.a.av(d.this.getContext()).sa() || !d.this.rO.mVideoPlayConfig.isVideoSoundEnable();
            m mVar = new m();
            mVar.adu = z10;
            d.this.xP.c(mVar);
            if (d.this.rO.f11689qf != null) {
                d.this.rO.f11689qf.setAudioEnabled(!z10, false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$5 */
    public class AnonymousClass5 implements i.a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.xP == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            m mVar = new m();
            mVar.adu = true;
            d.this.xP.c(mVar);
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$6 */
    public class AnonymousClass6 implements l {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.xQ != null) {
                com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
                hVar.adp = 1;
                d.this.xQ.a(hVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$7 */
    public class AnonymousClass7 extends com.kwad.components.ad.reward.e.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.d$7$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                oVar.scene = 1;
                d.this.xR.a(oVar);
                if (d.this.xU != null) {
                    d.this.xU.aW(d.this.rO.qY);
                }
            }
        }

        public AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (d.this.xR != null) {
                bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                        oVar.scene = 1;
                        d.this.xR.a(oVar);
                        if (d.this.xU != null) {
                            d.this.xU.aW(d.this.rO.qY);
                        }
                    }
                }, 0L);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$8 */
    public class AnonymousClass8 extends com.kwad.components.core.video.l {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            d.this.jo();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.a(j10, j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.g(l5.c.f27899e);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            d.this.g(l5.c.f27899e);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.d$9 */
    public class AnonymousClass9 implements k.a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.reward.k.k.a
        public final void d(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            com.kwad.components.ad.reward.c.fy().c(qVar);
        }
    }

    public d() {
        if (jh()) {
            this.xV = new e();
        }
    }

    public void hR() {
        if (this.rO.qz) {
            jo();
        } else {
            jn();
        }
    }

    public void ji() {
        com.kwad.components.ad.reward.g gVar = this.rO;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    public void jj() {
        this.rO.z(jq());
    }

    public void jk() {
        com.kwad.components.ad.reward.j.b.a(this.rO.mAdTemplate, jq(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().cL(39).f(this.rO.mRootContainer.getTouchCoords()), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    public void jl() {
        com.kwad.components.ad.reward.j.b.a(this.rO.mAdTemplate, jq(), (String) null, new com.kwad.sdk.core.adlog.c.b().cL(40).f(this.rO.mRootContainer.getTouchCoords()), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    public void jm() {
        com.kwad.components.ad.reward.j.b.a(this.rO.mAdTemplate, jq(), (String) null, new com.kwad.sdk.core.adlog.c.b().cL(41).f(this.rO.mRootContainer.getTouchCoords()), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    private void jn() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.xS;
        yVar.Tz = true;
        yVar.adC = false;
        yVar.oZ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate));
        jp();
    }

    public void jo() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.xS;
        yVar.adC = true;
        yVar.Tz = false;
        jp();
    }

    private void jp() {
        com.kwad.components.core.webview.tachikoma.b.y yVar;
        p pVar = this.xO;
        if (pVar == null || (yVar = this.xS) == null) {
            return;
        }
        pVar.a(yVar);
    }

    public String jq() {
        com.kwad.components.ad.reward.k.a.d dVar = this.xN;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    public void notifyRewardVerify() {
        this.rO.f11688qe.onRewardVerify();
    }

    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.xT = true;
        this.rO.a(this);
        if (this.xN == null) {
            this.xN = new com.kwad.components.ad.reward.k.a.d(this.rO, -1L, getContext());
        }
        if (this.xS == null) {
            this.xS = new com.kwad.components.core.webview.tachikoma.b.y();
        }
        this.xN.a(this.rO.getActivity(), this.rO.mAdResultData, this);
        e eVar = this.xV;
        if (eVar != null) {
            eVar.A(this.rO);
        }
    }

    public void ay() {
        e eVar = this.xV;
        if (eVar != null) {
            eVar.ay();
        }
    }

    public void az() {
    }

    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.rO.mRootContainer;
    }

    public boolean jh() {
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.xN;
        if (dVar == null || dVar.jI() == null) {
            return;
        }
        this.xN.jI().hl();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.xT) {
            e eVar = this.xV;
            if (eVar != null) {
                eVar.B(this.rO);
            }
            this.rO.b(this);
            com.kwad.components.ad.reward.k.a.d dVar = this.xN;
            if (dVar != null) {
                dVar.jK();
            }
            com.kwad.components.ad.reward.m.e eVar2 = this.rO.f11689qf;
            if (eVar2 != null) {
                eVar2.b(this.f11766ia);
                this.rO.f11689qf.b(this.iF);
            }
            com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
            this.rO.c(this.mPlayEndPageListener);
        }
    }

    private void d(long j10, long j11) {
        if (j11 < Math.min(com.kwad.sdk.core.response.b.a.ag(this.rO.mAdTemplate.adInfoList.get(0)), j10) - 800) {
            this.rO.qQ = (int) (((r4 - j11) / 1000.0f) + 0.5f);
        }
    }

    public void g(double d10) {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.xS;
        yVar.adC = false;
        yVar.Tz = false;
        yVar.oZ = (int) ((d10 / 1000.0d) + 0.5d);
        jp();
    }

    public void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(com.kwad.components.core.webview.tachikoma.b.q qVar) {
                com.kwad.components.ad.reward.c.fy().c(qVar);
            }
        });
        sVar.c(kVar);
        long j10 = this.rO.qS;
        sVar.c(new com.kwad.components.ad.reward.k.g(j10 > 0 ? ((int) j10) / 1000 : 0));
        com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i();
        this.xQ = iVar;
        sVar.c(iVar);
        j jVar = new j();
        this.xR = jVar;
        sVar.c(jVar);
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.rO.b(this.mPlayEndPageListener);
        sVar.c(new aj(new aj.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11

            /* renamed from: com.kwad.components.ad.reward.presenter.f.d$11$1 */
            public class AnonymousClass1 implements a.b {
                final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.p xZ;

                public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.p pVar2) {
                    pVar = pVar2;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (pVar.adw) {
                        d.this.jk();
                    } else {
                        d.this.jl();
                    }
                }
            }

            public AnonymousClass11() {
            }

            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar2) {
                com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ao(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.p xZ;

                    public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.p pVar22) {
                        pVar = pVar22;
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (pVar.adw) {
                            d.this.jk();
                        } else {
                            d.this.jl();
                        }
                    }
                }));
            }
        });
        sVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12

            /* renamed from: com.kwad.components.ad.reward.presenter.f.d$12$1 */
            public class AnonymousClass1 implements a.b {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.jm();
                }
            }

            public AnonymousClass12() {
            }

            @Override // com.kwad.components.ad.reward.k.e.a
            public final void jr() {
                com.kwad.components.core.e.d.a.a(new a.C0427a(d.this.getContext()).au(d.this.rO.mAdTemplate).b(d.this.rO.mApkDownloadHelper).ao(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.jm();
                    }
                }));
            }
        });
        sVar.c(eVar);
        sVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            public AnonymousClass13() {
            }

            @Override // com.kwad.components.ad.reward.k.h.a
            public final void S(int i10) {
                if (com.kwad.components.ad.reward.g.K(d.this.rO.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.g.I(d.this.rO.mAdTemplate) || d.this.rO.qO == null) {
                        if (com.kwad.components.ad.reward.g.J(d.this.rO.mAdTemplate) && d.this.rO.qP != null && !d.this.rO.qP.jW()) {
                            d.this.rO.qP.jV();
                        }
                    } else if (!d.this.rO.qO.jW()) {
                        d.this.rO.qO.jV();
                    }
                }
                if (d.this.rO.gd() != RewardRenderResult.DEFAULT) {
                    d.this.rO.qE = i10;
                }
                d.this.notifyRewardVerify();
            }
        }));
        sVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            public AnonymousClass14() {
            }

            @Override // com.kwad.components.ad.reward.k.c
            public final void js() {
                super.js();
                d.this.jj();
            }
        });
        sVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            public AnonymousClass15() {
            }

            @Override // com.kwad.components.ad.reward.k.f
            public final void V(boolean z10) {
                super.V(z10);
                com.kwad.components.ad.reward.presenter.f.v(d.this.rO);
            }
        });
        sVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            public AnonymousClass16() {
            }

            @Override // com.kwad.components.ad.reward.k.b
            public final void js() {
                super.js();
                d.this.ji();
            }
        });
        sVar.c(new q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.s.j.f(d.this.getContext(), d.this.rO.mAdTemplate);
            }
        });
        sVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.rO.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.a.h hVar = new com.kwad.components.core.webview.tachikoma.a.h();
        this.xU = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.a.h hVar2) {
                hVar2.aW(d.this.rO.qY);
            }
        });
        sVar.c(this.xU);
        sVar.c(new ag());
        sVar.c(new bh(bVar, this.rO.mApkDownloadHelper, this.xW));
        sVar.c(new y(this));
    }

    public void a(p pVar) {
        this.xO = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.a(this.f11766ia);
        }
    }

    public void a(t tVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.rO, false);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.xV;
        if (eVar != null) {
            eVar.ju();
        }
    }

    public void a(ay ayVar) {
        e eVar = this.xV;
        if (eVar != null) {
            eVar.b(ayVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
        char c10;
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (gVar == null || gVar.f11688qe == null) {
            return;
        }
        try {
            a.c cVar = new a.c();
            cVar.parseJson(new JSONObject(c0448a.YD));
            String str = c0448a.YC;
            switch (str.hashCode()) {
                case -1552949011:
                    if (str.equals("rewardVerifyCallback")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1228923142:
                    if (str.equals("adCloseCallback")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -402746255:
                    if (str.equals("videoPlayEndCallback")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 601135198:
                    if (str.equals("videoPlayErrorCallback")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1620545720:
                    if (str.equals("videoPlayStartCallback")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1852274314:
                    if (str.equals("adClickCallback")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1917267918:
                    if (str.equals("adSkipWithPlayTimeCallback")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    this.rO.f11688qe.cg();
                    break;
                case 1:
                    this.rO.f11688qe.onVideoPlayStart();
                    break;
                case 2:
                    this.rO.f11688qe.onVideoPlayError(cVar.errorCode, cVar.YE);
                    break;
                case 3:
                    this.rO.f11688qe.onVideoPlayEnd();
                    break;
                case 4:
                    this.rO.f11688qe.onVideoSkipToEnd(cVar.YF);
                    break;
                case 5:
                    this.rO.f11688qe.i(cVar.YG);
                    break;
                case 6:
                    this.rO.f11688qe.onRewardVerify();
                    break;
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e("TKBasePresenter", "onOutCallback Error: " + th2.getMessage());
        }
    }

    public void a(m mVar) {
        com.kwad.components.ad.reward.m.e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.setAudioEnabled(!mVar.adu, true);
        }
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.rO.f11688qe.cg();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    public void a(o oVar) {
        this.xP = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.a(this.iF);
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                boolean z10 = com.kwad.components.core.s.a.av(d.this.getContext()).sa() || !d.this.rO.mVideoPlayConfig.isVideoSoundEnable();
                m mVar = new m();
                mVar.adu = z10;
                d.this.xP.c(mVar);
                if (d.this.rO.f11689qf != null) {
                    d.this.rO.f11689qf.setAudioEnabled(!z10, false);
                }
            }
        });
    }

    public final void a(long j10, long j11) {
        d(j10, j11);
        g(j11);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.rO.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
