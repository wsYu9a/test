package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* loaded from: classes2.dex */
public final class k extends b {
    private final AdLiveCallerContextListener tP = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.rO);
        }
    };
    private final com.kwad.components.core.l.a.a tQ = new com.kwad.components.core.l.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            super.c(fVar);
            if (k.this.rO.f11689qf.kh()) {
                k.this.rO.f11689qf.ki().onResume();
                if (com.kwad.components.core.s.a.av(k.this.rO.mContext).sa()) {
                    k.this.rO.e(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            if (k.this.rO.f11689qf.kh()) {
                k.this.rO.f11689qf.ki().onPause();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.k$1 */
    public class AnonymousClass1 implements AdLiveCallerContextListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.rO);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.k$2 */
    public class AnonymousClass2 extends com.kwad.components.core.l.a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            super.c(fVar);
            if (k.this.rO.f11689qf.kh()) {
                k.this.rO.f11689qf.ki().onResume();
                if (com.kwad.components.core.s.a.av(k.this.rO.mContext).sa()) {
                    k.this.rO.e(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            if (k.this.rO.f11689qf.kh()) {
                k.this.rO.f11689qf.ki().onPause();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.rO.f11689qf.kh()) {
            this.rO.f11689qf.ki().registerAdLiveCallerContextListener(this.tP);
            this.rO.Ov.add(this.tQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.rO.f11689qf.kh()) {
            this.rO.f11689qf.ki().unRegisterAdLiveCallerContextListener(this.tP);
            this.rO.Ov.remove(this.tQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
