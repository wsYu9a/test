package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.kwai.d;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.h;
import com.kwad.components.core.j.kwai.b;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.w;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.b.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.e;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements i {
    private FrameLayout lE;
    private AdInfo mAdInfo;
    private boolean tx;
    private boolean ty;
    private d vM;
    private boolean wO;
    private g wP;
    private long wQ;
    private j.b tz = new j.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.j.b
        public final boolean interceptPlayCardResume() {
            return a.this.lE != null && a.this.lE.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.j.kwai.a sd = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            int i2 = 0;
            a.this.wO = false;
            if (a.this.wP == null) {
                return;
            }
            w wVar = new w();
            if (!com.kwad.components.core.p.a.pt().pz()) {
                if (com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                    if (com.kwad.components.core.p.a.pt().py() == 1) {
                        if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                            i2 = 2;
                            wVar.Vn = 2;
                        }
                    } else if (com.kwad.components.core.p.a.pt().py() != 3) {
                        return;
                    } else {
                        wVar.Vn = 1;
                    }
                    com.kwad.components.core.p.a.pt().aG(i2);
                    a.this.wP.b(wVar);
                    return;
                }
                return;
            }
            com.kwad.components.core.p.a.pt().aK(false);
            if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pt().pv()) {
                wVar.Vn = 1;
                a.this.wP.b(wVar);
            }
            wVar.Vn = 0;
            a.this.wP.b(wVar);
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            a.this.wO = true;
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            long a2 = j.a(j2, a.this.mAdInfo);
            long aE = com.kwad.sdk.core.response.a.a.aE(a.this.mAdInfo) * 1000;
            if (j3 <= a.this.wQ || a2 - j3 <= aE || a.this.tx) {
                return;
            }
            if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qt.fO) {
                return;
            }
            a.b(a.this, true);
            a.this.vM.bind(a.this.qt.getActivity(), a.this.qt.mAdTemplate, a.this);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$1 */
    final class AnonymousClass1 implements j.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.j.b
        public final boolean interceptPlayCardResume() {
            return a.this.lE != null && a.this.lE.getVisibility() == 0;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$2 */
    final class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            int i2 = 0;
            a.this.wO = false;
            if (a.this.wP == null) {
                return;
            }
            w wVar = new w();
            if (!com.kwad.components.core.p.a.pt().pz()) {
                if (com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                    if (com.kwad.components.core.p.a.pt().py() == 1) {
                        if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                            i2 = 2;
                            wVar.Vn = 2;
                        }
                    } else if (com.kwad.components.core.p.a.pt().py() != 3) {
                        return;
                    } else {
                        wVar.Vn = 1;
                    }
                    com.kwad.components.core.p.a.pt().aG(i2);
                    a.this.wP.b(wVar);
                    return;
                }
                return;
            }
            com.kwad.components.core.p.a.pt().aK(false);
            if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pt().pv()) {
                wVar.Vn = 1;
                a.this.wP.b(wVar);
            }
            wVar.Vn = 0;
            a.this.wP.b(wVar);
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            a.this.wO = true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            long a2 = j.a(j2, a.this.mAdInfo);
            long aE = com.kwad.sdk.core.response.a.a.aE(a.this.mAdInfo) * 1000;
            if (j3 <= a.this.wQ || a2 - j3 <= aE || a.this.tx) {
                return;
            }
            if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qt.fO) {
                return;
            }
            a.b(a.this, true);
            a.this.vM.bind(a.this.qt.getActivity(), a.this.qt.mAdTemplate, a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$4 */
    final class AnonymousClass4 implements DialogInterface.OnDismissListener {
        AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (a.this.wP == null) {
                return;
            }
            w wVar = new w();
            if (com.kwad.components.core.p.a.pt().pz()) {
                com.kwad.components.core.p.a.pt().aK(false);
                if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pt().pv()) {
                    wVar.Vn = 1;
                } else {
                    wVar.Vn = 0;
                }
                a.this.wP.b(wVar);
                return;
            }
            if (com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.p.a.pt().py() == 1) {
                    if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                        return;
                    }
                    wVar.Vn = 0;
                    a.this.wP.b(wVar);
                    return;
                }
                if (com.kwad.components.core.p.a.pt().py() == 3) {
                    wVar.Vn = 1;
                    com.kwad.components.core.p.a.pt().aG(0);
                    a.this.wP.b(wVar);
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$5 */
    final class AnonymousClass5 extends g {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull c cVar) {
            super.handleJsCall(str, cVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$6 */
    final class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.qt.mAdOpenInteractionListener != null) {
                a.this.qt.mAdOpenInteractionListener.onRewardVerify();
            }
            a.this.qt.oN.pause();
            a.this.qt.fH();
        }
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.tx = true;
        return true;
    }

    private void hx() {
        if (h.y(this.qt)) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.qt.mAdOpenInteractionListener != null) {
                        a.this.qt.mAdOpenInteractionListener.onRewardVerify();
                    }
                    a.this.qt.oN.pause();
                    a.this.qt.fH();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.d.b bVar = this.qt.mAdOpenInteractionListener;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qt.oN.pause();
        this.qt.fH();
    }

    private g jb() {
        return new g() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull c cVar) {
                super.handleJsCall(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.wO = false;
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onBind: ");
        if (this.vM == null) {
            this.vM = new d(this.qt, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                AnonymousClass4() {
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.wP == null) {
                        return;
                    }
                    w wVar = new w();
                    if (com.kwad.components.core.p.a.pt().pz()) {
                        com.kwad.components.core.p.a.pt().aK(false);
                        if (com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pt().pv()) {
                            wVar.Vn = 1;
                        } else {
                            wVar.Vn = 0;
                        }
                        a.this.wP.b(wVar);
                        return;
                    }
                    if (com.kwad.components.core.p.a.pt().px() && com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo) == 1) {
                        if (com.kwad.components.core.p.a.pt().py() == 1) {
                            if (ak.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.aq(a.this.mAdInfo))) {
                                return;
                            }
                            wVar.Vn = 0;
                            a.this.wP.b(wVar);
                            return;
                        }
                        if (com.kwad.components.core.p.a.pt().py() == 3) {
                            wVar.Vn = 1;
                            com.kwad.components.core.p.a.pt().aG(0);
                            a.this.wP.b(wVar);
                        }
                    }
                }
            });
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.wQ = com.kwad.sdk.core.response.a.a.aD(r0) * 1000;
        this.qt.oN.a(this.mVideoPlayStateListener, null);
        this.qt.a(this.tz);
        this.qt.JT.add(this.sd);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "getTkTemplateId: ");
        return com.kwad.components.core.webview.a.j.b("ksad-video-task-card", this.qt.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final e getTouchCoordsView() {
        return this.qt.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        int i2;
        this.qt.mAdOpenInteractionListener.bN();
        if (com.kwad.sdk.core.response.a.a.aG(this.mAdInfo)) {
            com.kwad.components.core.p.a.pt().aF(aVar.aqn);
            if (aVar.aqn == -1) {
                i2 = 0;
                com.kwad.components.core.p.a.pt().aK(false);
            } else {
                i2 = 1;
                if (!com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
                    com.kwad.components.core.p.a.pt().aK(true);
                    return;
                } else if (com.kwad.components.core.p.a.pt().py() == 2) {
                    com.kwad.components.core.p.a.pt().aG(3);
                    return;
                }
            }
            com.kwad.components.core.p.a.pt().aG(i2);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onCreate: ");
        this.lE = (FrameLayout) findViewById(R.id.ksad_js_task);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        g jb = jb();
        this.wP = jb;
        lVar.c(jb);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.lE.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onTkLoadSuccess: ");
        getContext();
        if (ai.DL()) {
            this.lE.setVisibility(0);
            this.qt.oN.pause();
            this.ty = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, null);
        this.qt.b(this.tz);
        this.qt.JT.remove(this.sd);
        this.vM.unBind();
        this.vM = null;
        this.lE.setVisibility(8);
        com.kwad.components.core.p.a.pt().clear();
        this.tx = false;
        this.ty = false;
        this.wO = false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        j jVar = this.qt;
        boolean z = webCloseStatus != null && webCloseStatus.interactSuccess;
        jVar.pi = z;
        if (z) {
            jVar.oN.jH().jD();
            if (com.kwad.components.core.p.a.pt().pu() == 1) {
                hx();
            }
        }
        if (this.ty && !this.wO) {
            this.qt.oN.resume();
        }
        this.lE.setVisibility(8);
    }
}
