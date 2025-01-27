package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.h.d;
import com.kwad.components.ad.reward.h.e;
import com.kwad.components.ad.reward.h.h;
import com.kwad.components.ad.reward.h.j;
import com.kwad.components.ad.reward.h.k;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.q;
import com.kwad.components.core.webview.a.a.r;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.kwai.h;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.w;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.h;

/* loaded from: classes2.dex */
public abstract class c extends com.kwad.components.ad.reward.presenter.a implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.h.kwai.e, w.a {
    private com.kwad.components.ad.reward.j.a gU;
    private z mVideoProgress;
    protected com.kwad.components.ad.reward.h.kwai.d vM;
    private p vN;
    private o vO;
    private com.kwad.components.ad.reward.h.i vP;
    private j vQ;
    private boolean vR;
    private com.kwad.components.core.webview.a.kwai.h vS;

    @Nullable
    protected e vT;
    private av.b vU = new av.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.av.b
        public final void S(int i2) {
            y.b bVar = new y.b();
            bVar.jU = i2;
            bVar.jW = c.this.qt.mRootContainer.getTouchCoords();
            com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ao(false).a(bVar).aq(true));
        }
    };
    private final h.a gV = new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.5
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.vO == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            m mVar = new m();
            mVar.Vf = true;
            c.this.vO.b(mVar);
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.f.c.6
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.vP != null) {
                com.kwad.components.core.webview.a.a.h hVar = new com.kwad.components.core.webview.a.a.h();
                hVar.Va = 1;
                c.this.vP.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.7

        /* renamed from: com.kwad.components.ad.reward.presenter.f.c$7$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.a.a.o oVar = new com.kwad.components.core.webview.a.a.o();
                oVar.Vg = 1;
                c.this.vQ.a(oVar);
                if (c.this.vS != null) {
                    c.this.vS.aO(c.this.qt.pH);
                }
            }
        }

        AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (c.this.vQ != null) {
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.c.7.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.a.a.o oVar = new com.kwad.components.core.webview.a.a.o();
                        oVar.Vg = 1;
                        c.this.vQ.a(oVar);
                        if (c.this.vS != null) {
                            c.this.vS.aO(c.this.qt.pH);
                        }
                    }
                }, 0L);
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.f.c.8
        AnonymousClass8() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            c.this.hx();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            c.this.a(30000L, j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            c.this.g(0.0d);
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.f.c.9
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            c.this.hx();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            c.this.iQ();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            c.this.a(j2, j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            c.this.g(0.0d);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPreparing() {
            c.this.g(0.0d);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$1 */
    final class AnonymousClass1 implements av.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.jshandler.av.b
        public final void S(int i2) {
            y.b bVar = new y.b();
            bVar.jU = i2;
            bVar.jW = c.this.qt.mRootContainer.getTouchCoords();
            com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ao(false).a(bVar).aq(true));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$10 */
    final class AnonymousClass10 implements k.a {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.reward.h.k.a
        public final void d(r rVar) {
            com.kwad.components.ad.reward.d.fm().c(rVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$11 */
    final class AnonymousClass11 implements aa.b {
        AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            c.this.getTKContainer().setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$12 */
    final class AnonymousClass12 implements d.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.c$12$1 */
        final class AnonymousClass1 implements a.b {
            final /* synthetic */ q vX;

            AnonymousClass1(q qVar) {
                qVar = qVar;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (qVar.Vi) {
                    c.this.iM();
                } else {
                    c.this.iN();
                }
            }
        }

        AnonymousClass12() {
        }

        @Override // com.kwad.components.ad.reward.h.d.a
        public final void a(q qVar) {
            com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ap(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.12.1
                final /* synthetic */ q vX;

                AnonymousClass1(q qVar2) {
                    qVar = qVar2;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (qVar.Vi) {
                        c.this.iM();
                    } else {
                        c.this.iN();
                    }
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$13 */
    final class AnonymousClass13 implements e.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.c$13$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.iO();
            }
        }

        AnonymousClass13() {
        }

        @Override // com.kwad.components.ad.reward.h.e.a
        public final void iS() {
            com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.13.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.iO();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$14 */
    final class AnonymousClass14 implements h.a {
        AnonymousClass14() {
        }

        @Override // com.kwad.components.ad.reward.h.h.a
        public final void T(int i2) {
            if (com.kwad.components.ad.reward.j.q(c.this.qt.mAdTemplate)) {
                if (!com.kwad.components.ad.reward.j.o(c.this.qt.mAdTemplate) || c.this.qt.pw == null) {
                    if (com.kwad.components.ad.reward.j.p(c.this.qt.mAdTemplate) && c.this.qt.px != null && !c.this.qt.px.jv()) {
                        c.this.qt.px.ju();
                    }
                } else if (!c.this.qt.pw.jv()) {
                    c.this.qt.pw.ju();
                }
            }
            if (c.this.qt.fS() != RewardRenderResult.DEFAULT) {
                c.this.qt.pn = i2;
            }
            c.this.notifyRewardVerify();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$15 */
    final class AnonymousClass15 extends com.kwad.components.ad.reward.h.c {
        AnonymousClass15() {
        }

        @Override // com.kwad.components.ad.reward.h.c
        public final void iT() {
            super.iT();
            c.this.iL();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$16 */
    final class AnonymousClass16 extends com.kwad.components.ad.reward.h.f {
        AnonymousClass16() {
        }

        @Override // com.kwad.components.ad.reward.h.f
        public final void Z(boolean z) {
            super.Z(z);
            com.kwad.components.ad.reward.presenter.e.a(c.this.qt, c.this.qt.fR());
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$17 */
    final class AnonymousClass17 extends com.kwad.components.ad.reward.h.b {
        AnonymousClass17() {
        }

        @Override // com.kwad.components.ad.reward.h.b
        public final void iT() {
            super.iT();
            c.this.iK();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$2 */
    final class AnonymousClass2 extends com.kwad.components.core.webview.a.kwai.q {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            com.kwad.components.core.r.h.g(c.this.getContext(), c.this.qt.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$3 */
    final class AnonymousClass3 implements h.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.h.a
        public final void a(com.kwad.components.core.webview.a.kwai.h hVar) {
            hVar.aO(c.this.qt.pH);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = com.kwad.components.core.r.a.aj(c.this.getContext()).pI() || !c.this.qt.mVideoPlayConfig.isVideoSoundEnable();
            m mVar = new m();
            mVar.Vf = z;
            c.this.vO.b(mVar);
            c.this.gU.setAudioEnabled(!z, false);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$5 */
    final class AnonymousClass5 implements h.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.vO == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            m mVar = new m();
            mVar.Vf = true;
            c.this.vO.b(mVar);
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$6 */
    final class AnonymousClass6 implements com.kwad.components.ad.reward.d.j {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.vP != null) {
                com.kwad.components.core.webview.a.a.h hVar = new com.kwad.components.core.webview.a.a.h();
                hVar.Va = 1;
                c.this.vP.a(hVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$7 */
    final class AnonymousClass7 extends com.kwad.components.ad.reward.d.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.f.c$7$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.a.a.o oVar = new com.kwad.components.core.webview.a.a.o();
                oVar.Vg = 1;
                c.this.vQ.a(oVar);
                if (c.this.vS != null) {
                    c.this.vS.aO(c.this.qt.pH);
                }
            }
        }

        AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (c.this.vQ != null) {
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.c.7.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.a.a.o oVar = new com.kwad.components.core.webview.a.a.o();
                        oVar.Vg = 1;
                        c.this.vQ.a(oVar);
                        if (c.this.vS != null) {
                            c.this.vS.aO(c.this.qt.pH);
                        }
                    }
                }, 0L);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$8 */
    final class AnonymousClass8 extends AdLivePlayStateListenerAdapter {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            c.this.hx();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            c.this.a(30000L, j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            c.this.g(0.0d);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.c$9 */
    final class AnonymousClass9 extends com.kwad.components.core.video.j {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            c.this.hx();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            c.this.iQ();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            c.this.a(j2, j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            c.this.g(0.0d);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPreparing() {
            c.this.g(0.0d);
        }
    }

    public c() {
        if (iI()) {
            this.vT = new e();
        }
    }

    private void c(long j2, long j3) {
        if (j3 < Math.min(com.kwad.sdk.core.response.a.a.X(this.qt.mAdTemplate.adInfoList.get(0)), j2) - 800) {
            this.qt.py = (int) (((r4 - j3) / 1000.0f) + 0.5f);
        }
    }

    public void g(double d2) {
        z zVar = this.mVideoProgress;
        zVar.Vq = false;
        zVar.Vm = false;
        zVar.nZ = (int) ((d2 / 1000.0d) + 0.5d);
        iR();
    }

    public void hx() {
        if (this.qt.pk) {
            iQ();
        } else {
            iP();
        }
    }

    public void iK() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 17, jVar.mReportExtData);
    }

    public void iL() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 18, jVar.mReportExtData);
    }

    public void iM() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 39, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    public void iN() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 40, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    public void iO() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 41, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    private void iP() {
        z zVar = this.mVideoProgress;
        zVar.Vm = true;
        zVar.Vq = false;
        zVar.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate));
        iR();
    }

    public void iQ() {
        z zVar = this.mVideoProgress;
        zVar.Vq = true;
        zVar.Vm = false;
        iR();
    }

    private void iR() {
        z zVar;
        p pVar = this.vN;
        if (pVar == null || (zVar = this.mVideoProgress) == null) {
            return;
        }
        pVar.a(zVar);
    }

    public void notifyRewardVerify() {
        this.qt.mAdOpenInteractionListener.onRewardVerify();
    }

    public void a(long j2, long j3) {
        c(j2, j3);
        g(j3);
    }

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.j jVar = this.qt;
        if (jVar != null) {
            jVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.w.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.qt.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        boolean ck = ck();
        this.vR = ck;
        if (ck) {
            this.qt.a(this);
            if (this.vM == null) {
                this.vM = new com.kwad.components.ad.reward.h.kwai.d(this.qt, -1L, getContext());
            }
            if (this.mVideoProgress == null) {
                this.mVideoProgress = new z();
            }
            this.gU = this.qt.oN.jH();
            this.vM.bind(this.qt.getActivity(), this.qt.mAdTemplate, this);
            e eVar = this.vT;
            if (eVar != null) {
                eVar.z(this.qt);
            }
        }
    }

    protected abstract boolean ck();

    @Override // com.kwad.components.core.webview.a.i
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qt.mRootContainer;
    }

    protected boolean iI() {
        return false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        this.qt.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.vM;
        if (dVar == null || dVar.ji() == null) {
            return;
        }
        this.vM.ji().gV();
    }

    public void onRegisterLifecycleLisener(an anVar) {
        e eVar = this.vT;
        if (eVar != null) {
            eVar.a(anVar);
        }
    }

    public void onRegisterVideoMuteStateListener(o oVar) {
        this.vO = oVar;
        this.gU.a(this.gV);
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.c.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z = com.kwad.components.core.r.a.aj(c.this.getContext()).pI() || !c.this.qt.mVideoPlayConfig.isVideoSoundEnable();
                m mVar = new m();
                mVar.Vf = z;
                c.this.vO.b(mVar);
                c.this.gU.setAudioEnabled(!z, false);
            }
        });
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
        this.vN = pVar;
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.ad.reward.h.k.a
            public final void d(r rVar) {
                com.kwad.components.ad.reward.d.fm().c(rVar);
            }
        });
        lVar.c(kVar);
        long j2 = this.qt.pA;
        lVar.c(new com.kwad.components.ad.reward.h.g(j2 > 0 ? ((int) j2) / 1000 : 0));
        com.kwad.components.ad.reward.h.i iVar = new com.kwad.components.ad.reward.h.i();
        this.vP = iVar;
        lVar.c(iVar);
        j jVar = new j();
        this.vQ = jVar;
        lVar.c(jVar);
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.qt.b(this.mPlayEndPageListener);
        lVar.c(new aa(new aa.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.11
            AnonymousClass11() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aa.b
            public final void a(aa.a aVar) {
                c.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.h.d dVar = new com.kwad.components.ad.reward.h.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.12

            /* renamed from: com.kwad.components.ad.reward.presenter.f.c$12$1 */
            final class AnonymousClass1 implements a.b {
                final /* synthetic */ q vX;

                AnonymousClass1(q qVar2) {
                    qVar = qVar2;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (qVar.Vi) {
                        c.this.iM();
                    } else {
                        c.this.iN();
                    }
                }
            }

            AnonymousClass12() {
            }

            @Override // com.kwad.components.ad.reward.h.d.a
            public final void a(q qVar2) {
                com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ap(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.12.1
                    final /* synthetic */ q vX;

                    AnonymousClass1(q qVar22) {
                        qVar = qVar22;
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (qVar.Vi) {
                            c.this.iM();
                        } else {
                            c.this.iN();
                        }
                    }
                }));
            }
        });
        lVar.c(dVar);
        com.kwad.components.ad.reward.h.e eVar = new com.kwad.components.ad.reward.h.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.13

            /* renamed from: com.kwad.components.ad.reward.presenter.f.c$13$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.iO();
                }
            }

            AnonymousClass13() {
            }

            @Override // com.kwad.components.ad.reward.h.e.a
            public final void iS() {
                com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.qt.mAdTemplate).b(c.this.qt.mApkDownloadHelper).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.13.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        c.this.iO();
                    }
                }));
            }
        });
        lVar.c(eVar);
        lVar.c(new com.kwad.components.ad.reward.h.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.14
            AnonymousClass14() {
            }

            @Override // com.kwad.components.ad.reward.h.h.a
            public final void T(int i2) {
                if (com.kwad.components.ad.reward.j.q(c.this.qt.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.j.o(c.this.qt.mAdTemplate) || c.this.qt.pw == null) {
                        if (com.kwad.components.ad.reward.j.p(c.this.qt.mAdTemplate) && c.this.qt.px != null && !c.this.qt.px.jv()) {
                            c.this.qt.px.ju();
                        }
                    } else if (!c.this.qt.pw.jv()) {
                        c.this.qt.pw.ju();
                    }
                }
                if (c.this.qt.fS() != RewardRenderResult.DEFAULT) {
                    c.this.qt.pn = i2;
                }
                c.this.notifyRewardVerify();
            }
        }));
        lVar.c(new com.kwad.components.ad.reward.h.c() { // from class: com.kwad.components.ad.reward.presenter.f.c.15
            AnonymousClass15() {
            }

            @Override // com.kwad.components.ad.reward.h.c
            public final void iT() {
                super.iT();
                c.this.iL();
            }
        });
        lVar.c(new com.kwad.components.ad.reward.h.f() { // from class: com.kwad.components.ad.reward.presenter.f.c.16
            AnonymousClass16() {
            }

            @Override // com.kwad.components.ad.reward.h.f
            public final void Z(boolean z) {
                super.Z(z);
                com.kwad.components.ad.reward.presenter.e.a(c.this.qt, c.this.qt.fR());
            }
        });
        lVar.c(new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.f.c.17
            AnonymousClass17() {
            }

            @Override // com.kwad.components.ad.reward.h.b
            public final void iT() {
                super.iT();
                c.this.iK();
            }
        });
        lVar.c(new com.kwad.components.core.webview.a.kwai.q() { // from class: com.kwad.components.ad.reward.presenter.f.c.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.r.h.g(c.this.getContext(), c.this.qt.mAdTemplate);
            }
        });
        lVar.c(new com.kwad.components.ad.reward.f.b(getContext(), this.qt.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.a.kwai.h hVar = new com.kwad.components.core.webview.a.kwai.h();
        this.vS = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.c.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.h.a
            public final void a(com.kwad.components.core.webview.a.kwai.h hVar2) {
                hVar2.aO(c.this.qt.pH);
            }
        });
        lVar.c(this.vS);
        lVar.c(new x());
        lVar.c(new av(bVar, this.qt.mApkDownloadHelper, this.vU));
        lVar.c(new w(this));
    }

    public void onSkipClick(u uVar) {
        com.kwad.components.ad.reward.presenter.e.a(this.qt, false);
    }

    public void onTkLoadFailed() {
        e eVar = this.vT;
        if (eVar != null) {
            eVar.onTkLoadFailed();
        }
    }

    public void onTkLoadSuccess() {
        e eVar = this.vT;
        if (eVar != null) {
            eVar.onTkLoadSuccess();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.vR) {
            e eVar = this.vT;
            if (eVar != null) {
                eVar.A(this.qt);
            }
            this.qt.b(this);
            this.vM.unBind();
            this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
            this.gU.b(this.gV);
            com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
            this.qt.c(this.mPlayEndPageListener);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
        com.kwad.components.ad.reward.j.a aVar = this.gU;
        if (aVar != null) {
            aVar.setAudioEnabled(!mVar.Vf, true);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public void pageClose(WebCloseStatus webCloseStatus) {
    }
}
