package com.kwad.components.ad.reward.presenter.c.kwai;

import android.widget.FrameLayout;
import com.kwad.components.ad.i.a;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements a.b {
    private FrameLayout df;
    private volatile long uV = 0;
    private volatile boolean uW = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.uW = true;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.uV = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.uW = false;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.uW = false;
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            a.this.uV = j3;
            a.this.uW = j2 - j3 < 800;
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (a.this.qt.pv || a.this.qt.oT == null) {
                return;
            }
            a.this.qt.oT.az();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.5
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            a.this.qt.mAdOpenInteractionListener.bN();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.a$1 */
    final class AnonymousClass1 extends AdLivePlayStateListenerAdapter {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.uW = true;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.uV = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.uW = false;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.uW = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.a$2 */
    final class AnonymousClass2 extends j {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            a.this.uV = j3;
            a.this.uW = j2 - j3 < 800;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.a$3 */
    final class AnonymousClass3 implements a.InterfaceC0131a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.i.a.InterfaceC0131a
        public final void V(boolean z) {
            a.this.qt.pq = z;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.a$4 */
    final class AnonymousClass4 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (a.this.qt.pv || a.this.qt.oT == null) {
                return;
            }
            a.this.qt.oT.az();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.a$5 */
    final class AnonymousClass5 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            a.this.qt.mAdOpenInteractionListener.bN();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.uV = 0L;
        this.uW = false;
        com.kwad.components.ad.reward.j jVar = this.qt;
        AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.components.ad.i.a aVar = jVar.oT;
        if (aVar != null) {
            jVar.pq = true;
            aVar.a(this);
            aVar.a(this.mWebCardClickListener);
            aVar.a(this.df, this.qt.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0131a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.3
                AnonymousClass3() {
                }

                @Override // com.kwad.components.ad.i.a.InterfaceC0131a
                public final void V(boolean z) {
                    a.this.qt.pq = z;
                }
            });
            aVar.setActivity(this.qt.getActivity());
            aVar.aG();
            this.qt.b(this.mPlayEndPageListener);
            this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        }
    }

    @Override // com.kwad.components.ad.i.a.b
    public final void in() {
        e.t(this.qt);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.df = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this.mPlayEndPageListener);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
