package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class m extends a {
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.m.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            m.this.hx();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.m.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            m.this.hx();
        }
    };
    private final com.kwad.components.ad.reward.d.k gs = new com.kwad.components.ad.reward.d.k() { // from class: com.kwad.components.ad.reward.presenter.m.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.k
        public final void a(com.kwad.components.core.webview.a.a.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            m.this.qt.oN.release();
            m.this.qt.fH();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.m$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.qt.fH();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.m$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            m.this.hx();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.m$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            m.this.hx();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.m$4 */
    final class AnonymousClass4 implements com.kwad.components.ad.reward.d.k {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.k
        public final void a(com.kwad.components.core.webview.a.a.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            m.this.qt.oN.release();
            m.this.qt.fH();
        }
    }

    public void hx() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        if (com.kwad.components.core.r.h.e(jVar.mAdTemplate, jVar.pk)) {
            com.kwad.components.ad.reward.j jVar2 = this.qt;
            com.kwad.components.core.r.h.g(jVar2.mContext, jVar2.mAdTemplate);
        }
        if (!h.y(this.qt)) {
            com.kwad.components.ad.reward.j jVar3 = this.qt;
            if (!com.kwad.components.core.r.h.e(jVar3.mAdTemplate, jVar3.pk)) {
                this.qt.fH();
                return;
            }
        }
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.m.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.this.qt.fH();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fm().a(this.gs);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fm().b(this.gs);
    }
}
