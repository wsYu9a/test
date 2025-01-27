package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes.dex */
public final class l extends a {
    private long gM;

    @NonNull
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.l.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            if (jVar.pf && jVar.pk) {
                lVar.mAdOpenInteractionListener.onVideoSkipToEnd(l.this.gM);
            } else {
                jVar.pC = true;
                lVar.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            com.kwad.components.ad.reward.j jVar2 = l.this.qt;
            if (jVar2.pC) {
                com.kwad.components.ad.reward.m.m(jVar2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            jVar.pB = j2;
            if (jVar.pk) {
                return;
            }
            lVar.gM = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
            l.this.qt.pC = false;
        }
    };
    private final com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.l.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            l lVar = l.this;
            boolean z = lVar.qt.pk;
            com.kwad.components.ad.reward.d.b bVar = lVar.mAdOpenInteractionListener;
            if (z) {
                bVar.onVideoSkipToEnd(l.this.gM);
            } else {
                bVar.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            com.kwad.components.ad.reward.j jVar = l.this.qt;
            if (jVar.pC) {
                com.kwad.components.ad.reward.m.m(jVar);
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            l.this.mAdOpenInteractionListener.onVideoPlayError(i2, i3);
            l.this.hq();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            jVar.pB = j3;
            jVar.pC = j2 - j3 < 800;
            if (jVar.pk) {
                return;
            }
            lVar.gM = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.l$1 */
    final class AnonymousClass1 extends AdLivePlayStateListenerAdapter {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            if (jVar.pf && jVar.pk) {
                lVar.mAdOpenInteractionListener.onVideoSkipToEnd(l.this.gM);
            } else {
                jVar.pC = true;
                lVar.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            com.kwad.components.ad.reward.j jVar2 = l.this.qt;
            if (jVar2.pC) {
                com.kwad.components.ad.reward.m.m(jVar2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            jVar.pB = j2;
            if (jVar.pk) {
                return;
            }
            lVar.gM = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
            l.this.qt.pC = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.l$2 */
    final class AnonymousClass2 extends com.kwad.components.core.video.j {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            l lVar = l.this;
            boolean z = lVar.qt.pk;
            com.kwad.components.ad.reward.d.b bVar = lVar.mAdOpenInteractionListener;
            if (z) {
                bVar.onVideoSkipToEnd(l.this.gM);
            } else {
                bVar.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            com.kwad.components.ad.reward.j jVar = l.this.qt;
            if (jVar.pC) {
                com.kwad.components.ad.reward.m.m(jVar);
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            l.this.mAdOpenInteractionListener.onVideoPlayError(i2, i3);
            l.this.hq();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qt;
            jVar.pB = j3;
            jVar.pC = j2 - j3 < 800;
            if (jVar.pk) {
                return;
            }
            lVar.gM = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qt;
        jVar.pB = 0L;
        jVar.pC = false;
        this.mAdOpenInteractionListener = jVar.mAdOpenInteractionListener;
        jVar.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
