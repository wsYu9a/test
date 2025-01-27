package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public final class p extends b {

    /* renamed from: qh */
    private com.kwad.components.core.playable.a f11811qh;
    private PlayableSource ul;
    private final com.kwad.components.ad.reward.e.j um = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            p.this.ul = playableSource;
            if (p.this.f11811qh != null && p.this.f11811qh.qW()) {
                p.this.f11811qh.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.rO;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.rO.C(true);
                    if (p.this.rO.f11689qf.kh()) {
                        p.this.rO.f11689qf.ki().pause();
                    }
                }
                com.kwad.components.ad.reward.a.fr().b(playableSource);
                return;
            }
            if (p.this.f11811qh != null) {
                p.this.f11811qh.hU();
            }
            if (nVar != null) {
                nVar.ho();
                com.kwad.sdk.core.d.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.rO.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void cu() {
            p.this.f11811qh.hU();
            com.kwad.components.ad.reward.g gVar = p.this.rO;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.rO.f11689qf.kh()) {
                    p.this.rO.f11689qf.ki().resume();
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.p$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.k {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            p.this.ul = playableSource;
            if (p.this.f11811qh != null && p.this.f11811qh.qW()) {
                p.this.f11811qh.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.rO;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.rO.C(true);
                    if (p.this.rO.f11689qf.kh()) {
                        p.this.rO.f11689qf.ki().pause();
                    }
                }
                com.kwad.components.ad.reward.a.fr().b(playableSource);
                return;
            }
            if (p.this.f11811qh != null) {
                p.this.f11811qh.hU();
            }
            if (nVar != null) {
                nVar.ho();
                com.kwad.sdk.core.d.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.rO.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void cu() {
            p.this.f11811qh.hU();
            com.kwad.components.ad.reward.g gVar = p.this.rO;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.rO.f11689qf.kh()) {
                    p.this.rO.f11689qf.ki().resume();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.p$2 */
    public class AnonymousClass2 implements ar.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            if (aVar.isSuccess()) {
                return;
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate);
            long loadTime = p.this.rO.f11691qh.getLoadTime();
            if (loadTime == -1) {
                return;
            }
            com.kwad.components.ad.reward.g gVar = p.this.rO;
            com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, gVar.qu, "playable", com.kwad.sdk.core.response.b.a.bP(eb2), System.currentTimeMillis() - loadTime, 3);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.p$3 */
    public class AnonymousClass3 implements KsAdWebView.e {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate);
            long loadTime = p.this.rO.f11691qh.getLoadTime();
            if (loadTime == -1) {
                return;
            }
            com.kwad.components.ad.reward.monitor.c.a(p.this.rO.qu, "playable", com.kwad.sdk.core.response.b.a.bP(eb2), System.currentTimeMillis() - loadTime);
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            com.kwad.components.ad.reward.g gVar = p.this.rO;
            AdTemplate adTemplate = gVar.mAdTemplate;
            com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar.qu, "playable", com.kwad.sdk.core.response.b.a.bP(com.kwad.sdk.core.response.b.e.eb(adTemplate)), System.currentTimeMillis() - p.this.rO.f11691qh.getLoadTime(), 2);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.reward.g gVar = this.rO;
        com.kwad.components.core.playable.a aVar = gVar.f11691qh;
        this.f11811qh = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar.mAdTemplate, gVar.mRootContainer, gVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.rO.qu, "playable");
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        com.kwad.components.ad.reward.g gVar2 = this.rO;
        com.kwad.components.ad.reward.monitor.c.a(gVar2.mAdTemplate, gVar2.qu, "playable", com.kwad.sdk.core.response.b.a.bP(eb2));
        this.f11811qh.qV();
        this.f11811qh.a(new ar.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo eb22 = com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate);
                long loadTime = p.this.rO.f11691qh.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.g gVar3 = p.this.rO;
                com.kwad.components.ad.reward.monitor.c.a(gVar3.mAdTemplate, gVar3.qu, "playable", com.kwad.sdk.core.response.b.a.bP(eb22), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.f11811qh.a(new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.p.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                AdInfo eb22 = com.kwad.sdk.core.response.b.e.eb(p.this.rO.mAdTemplate);
                long loadTime = p.this.rO.f11691qh.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.rO.qu, "playable", com.kwad.sdk.core.response.b.a.bP(eb22), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.components.ad.reward.g gVar3 = p.this.rO;
                AdTemplate adTemplate = gVar3.mAdTemplate;
                com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar3.qu, "playable", com.kwad.sdk.core.response.b.a.bP(com.kwad.sdk.core.response.b.e.eb(adTemplate)), System.currentTimeMillis() - p.this.rO.f11691qh.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.a.fr().a(this.um);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.f11811qh;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.ul);
            }
        }
    }

    public final void hU() {
        com.kwad.components.core.playable.a aVar = this.f11811qh;
        if (aVar != null) {
            aVar.hU();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.f11811qh;
        if (aVar == null) {
            return;
        }
        aVar.qU();
        this.f11811qh.hU();
        com.kwad.components.ad.reward.a.fr().b(this.um);
    }
}
