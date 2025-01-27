package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* loaded from: classes.dex */
public final class j extends a {
    private final AdLiveCallerContextListener sc = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.j.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.j.e(j.this.qt);
        }
    };
    private final com.kwad.components.core.j.kwai.a sd = new com.kwad.components.core.j.kwai.b() { // from class: com.kwad.components.ad.reward.presenter.j.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            super.a(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onResume();
                if (com.kwad.components.core.r.a.aj(j.this.qt.mContext).pI()) {
                    j.this.qt.c(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onPause();
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void c(com.kwad.components.core.l.d dVar) {
            super.c(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onDestroy();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.j$1 */
    final class AnonymousClass1 implements AdLiveCallerContextListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.j.e(j.this.qt);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.j$2 */
    final class AnonymousClass2 extends com.kwad.components.core.j.kwai.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            super.a(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onResume();
                if (com.kwad.components.core.r.a.aj(j.this.qt.mContext).pI()) {
                    j.this.qt.c(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onPause();
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void c(com.kwad.components.core.l.d dVar) {
            super.c(dVar);
            if (j.this.qt.oN.jF()) {
                j.this.qt.oN.jG().onDestroy();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.qt.oN.jF()) {
            this.qt.oN.jG().registerAdLiveCallerContextListener(this.sc);
            this.qt.JT.add(this.sd);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.qt.oN.jF()) {
            this.qt.oN.jG().unRegisterAdLiveCallerContextListener(this.sc);
            this.qt.JT.remove(this.sd);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
