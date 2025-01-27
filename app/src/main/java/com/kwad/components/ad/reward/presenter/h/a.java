package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.l.a.b;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class a extends g implements j {
    private AdInfo mAdInfo;
    private boolean vl;
    private boolean vm;
    private d xN;
    private f yA;
    private long yB;
    private boolean yz;
    private g.b vn = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.f11778yf != null && a.this.f11778yf.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.l.a.a tQ = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            a.this.yz = false;
            if (a.this.yA == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.rJ().rP()) {
                com.kwad.components.core.q.a.rJ().aN(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else if (com.kwad.components.core.q.a.rJ().rL()) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else {
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.rJ().rO() != 1) {
                    if (com.kwad.components.core.q.a.rJ().rO() == 3) {
                        vVar.adz = 1;
                        com.kwad.components.core.q.a.rJ().aJ(0);
                        a.this.yA.b(vVar);
                        return;
                    }
                    return;
                }
                if (!ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                } else {
                    vVar.adz = 2;
                    com.kwad.components.core.q.a.rJ().aJ(2);
                    a.this.yA.b(vVar);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            a.this.yz = true;
        }
    };

    /* renamed from: ia */
    private final l f11789ia = new l() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            long a10 = com.kwad.components.ad.reward.g.a(j10, a.this.mAdInfo);
            long aM = com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) * 1000;
            if (j11 <= a.this.yB || a10 - j11 <= aM || a.this.vl) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.rO.f11685hc) {
                return;
            }
            a.b(a.this, true);
            a.this.xN.a(a.this.rO.getActivity(), a.this.rO.mAdResultData, a.this);
            a.this.jz();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$1 */
    public class AnonymousClass1 implements g.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.f11778yf != null && a.this.f11778yf.getVisibility() == 0;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$2 */
    public class AnonymousClass2 extends b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            a.this.yz = false;
            if (a.this.yA == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.rJ().rP()) {
                com.kwad.components.core.q.a.rJ().aN(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else if (com.kwad.components.core.q.a.rJ().rL()) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else {
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.rJ().rO() != 1) {
                    if (com.kwad.components.core.q.a.rJ().rO() == 3) {
                        vVar.adz = 1;
                        com.kwad.components.core.q.a.rJ().aJ(0);
                        a.this.yA.b(vVar);
                        return;
                    }
                    return;
                }
                if (!ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                } else {
                    vVar.adz = 2;
                    com.kwad.components.core.q.a.rJ().aJ(2);
                    a.this.yA.b(vVar);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            a.this.yz = true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$3 */
    public class AnonymousClass3 extends l {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            long a10 = com.kwad.components.ad.reward.g.a(j10, a.this.mAdInfo);
            long aM = com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) * 1000;
            if (j11 <= a.this.yB || a10 - j11 <= aM || a.this.vl) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.rO.f11685hc) {
                return;
            }
            a.b(a.this, true);
            a.this.xN.a(a.this.rO.getActivity(), a.this.rO.mAdResultData, a.this);
            a.this.jz();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$4 */
    public class AnonymousClass4 implements DialogInterface.OnDismissListener {
        public AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (a.this.yA == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.rJ().rP()) {
                com.kwad.components.core.q.a.rJ().aN(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else if (com.kwad.components.core.q.a.rJ().rL()) {
                    vVar.adz = 1;
                    a.this.yA.b(vVar);
                    return;
                } else {
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.rJ().rO() == 1) {
                    if (ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                        return;
                    }
                    vVar.adz = 0;
                    a.this.yA.b(vVar);
                    return;
                }
                if (com.kwad.components.core.q.a.rJ().rO() == 3) {
                    vVar.adz = 1;
                    com.kwad.components.core.q.a.rJ().aJ(0);
                    a.this.yA.b(vVar);
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$5 */
    public class AnonymousClass5 extends f {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull c cVar) {
            super.a(str, cVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.h.a$6 */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.rO.f11688qe != null) {
                a.this.rO.f11688qe.onRewardVerify();
            }
            a.this.rO.f11689qf.pause();
            a.this.rO.fV();
        }
    }

    private void hR() {
        boolean z10 = i.z(this.rO);
        com.kwad.sdk.core.d.c.d("jky", "onPlayCompleted: " + z10);
        if (z10) {
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                public AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.rO.f11688qe != null) {
                        a.this.rO.f11688qe.onRewardVerify();
                    }
                    a.this.rO.f11689qf.pause();
                    a.this.rO.fV();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.rO.f11688qe;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.rO.f11689qf.pause();
        this.rO.fV();
    }

    private f jA() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull c cVar) {
                super.a(str, cVar);
            }
        };
    }

    public void jz() {
        this.f11778yf.setVisibility(0);
        e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.pause();
        }
        this.vm = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        getContext();
        if (an.NS()) {
            this.yz = false;
            com.kwad.sdk.core.d.c.d("TkRewardVideoTaskPresenter", "onBind: ");
            if (this.xN == null) {
                this.xN = new d(this.rO, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                    public AnonymousClass4() {
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.yA == null) {
                            return;
                        }
                        v vVar = new v();
                        if (com.kwad.components.core.q.a.rJ().rP()) {
                            com.kwad.components.core.q.a.rJ().aN(false);
                            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                                vVar.adz = 1;
                                a.this.yA.b(vVar);
                                return;
                            } else if (com.kwad.components.core.q.a.rJ().rL()) {
                                vVar.adz = 1;
                                a.this.yA.b(vVar);
                                return;
                            } else {
                                vVar.adz = 0;
                                a.this.yA.b(vVar);
                                return;
                            }
                        }
                        if (com.kwad.components.core.q.a.rJ().rN() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                            if (com.kwad.components.core.q.a.rJ().rO() == 1) {
                                if (ap.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                                    return;
                                }
                                vVar.adz = 0;
                                a.this.yA.b(vVar);
                                return;
                            }
                            if (com.kwad.components.core.q.a.rJ().rO() == 3) {
                                vVar.adz = 1;
                                com.kwad.components.core.q.a.rJ().aJ(0);
                                a.this.yA.b(vVar);
                            }
                        }
                    }
                });
            }
            this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
            this.yB = com.kwad.sdk.core.response.b.a.aL(r0) * 1000;
            e eVar = this.rO.f11689qf;
            if (eVar != null) {
                eVar.a(this.f11789ia);
            }
            this.rO.a(this.vn);
            this.rO.Ov.add(this.tQ);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dA(this.rO.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.rO.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int ih() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.b(this.f11789ia);
        }
        this.rO.b(this.vn);
        this.rO.Ov.remove(this.tQ);
        d dVar = this.xN;
        if (dVar != null) {
            dVar.jK();
            this.xN = null;
        }
        this.f11778yf.setVisibility(8);
        com.kwad.components.core.q.a.rJ().clear();
        this.vl = false;
        this.vm = false;
        this.yz = false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.vl = true;
        return true;
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
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.f11778yf.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        f jA = jA();
        this.yA = jA;
        sVar.c(jA);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.rO.f11688qe.cg();
        com.kwad.sdk.core.d.c.d("jky", "onAdClicked convertPageType: " + aVar.aJe);
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo)) {
            com.kwad.components.core.q.a.rJ().aI(aVar.aJe);
            if (aVar.aJe == -1) {
                com.kwad.components.core.q.a.rJ().aN(false);
                com.kwad.components.core.q.a.rJ().aJ(0);
            } else {
                if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                    if (com.kwad.components.core.q.a.rJ().rO() == 2) {
                        com.kwad.components.core.q.a.rJ().aJ(3);
                        return;
                    } else {
                        com.kwad.components.core.q.a.rJ().aJ(1);
                        return;
                    }
                }
                com.kwad.components.core.q.a.rJ().aN(true);
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z10 = false;
        this.rO.qx = webCloseStatus != null && webCloseStatus.interactSuccess;
        int rK = com.kwad.components.core.q.a.rJ().rK();
        com.kwad.components.ad.reward.g gVar = this.rO;
        e eVar = gVar.f11689qf;
        if (eVar != null) {
            if (gVar.qx) {
                eVar.ke();
                if (rK == 1) {
                    hR();
                    z10 = true;
                }
            }
            if (this.vm && !this.yz && !z10) {
                this.rO.f11689qf.resume();
            }
        }
        this.f11778yf.setVisibility(8);
    }
}
