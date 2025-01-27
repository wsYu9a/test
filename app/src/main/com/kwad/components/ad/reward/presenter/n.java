package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class n extends b {

    /* renamed from: ia */
    private com.kwad.components.core.video.l f11794ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.n.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.hR();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    };

    /* renamed from: ib */
    private final com.kwad.components.ad.reward.e.m f11795ib = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            n.this.rO.f11689qf.release();
            n.this.rO.fV();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.n$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.this.rO.fV();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.n$2 */
    public class AnonymousClass2 extends com.kwad.components.core.video.l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.hR();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.n$3 */
    public class AnonymousClass3 implements com.kwad.components.ad.reward.e.m {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            n.this.rO.f11689qf.release();
            n.this.rO.fV();
        }
    }

    public void hR() {
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (com.kwad.components.core.s.j.d(gVar.mAdTemplate, gVar.qz)) {
            com.kwad.components.ad.reward.g gVar2 = this.rO;
            com.kwad.components.core.s.j.f(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.z(this.rO)) {
            com.kwad.components.ad.reward.g gVar3 = this.rO;
            if (!com.kwad.components.core.s.j.d(gVar3.mAdTemplate, gVar3.qz)) {
                this.rO.fV();
                return;
            }
        }
        bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                n.this.rO.fV();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.f11689qf.a(this.f11794ia);
        com.kwad.components.ad.reward.c.fy().a(this.f11795ib);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11794ia);
        com.kwad.components.ad.reward.c.fy().b(this.f11795ib);
    }
}
