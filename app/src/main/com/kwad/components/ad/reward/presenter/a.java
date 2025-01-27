package com.kwad.components.ad.reward.presenter;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class a extends b {

    /* renamed from: ia */
    private com.kwad.components.core.video.l f11742ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.rO.qK = j11;
        }
    };
    private DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.reward.presenter.a$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.rO.qK = j11;
        }
    }

    public a(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    private boolean hD() {
        return com.kwad.sdk.core.response.b.e.k(this.mAdTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)));
    }

    private boolean hE() {
        return com.kwad.sdk.core.response.b.e.J(this.mAdTemplate);
    }

    private void n(com.kwad.components.ad.reward.g gVar) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        com.kwad.components.ad.reward.m.e eVar = gVar.f11689qf;
        if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
            com.kwad.components.ad.reward.m.b bVar = new com.kwad.components.ad.reward.m.b(this.mAdTemplate);
            eVar.a(3, bVar);
            gVar.a(bVar);
        } else {
            com.kwad.components.ad.reward.m.d dVar = new com.kwad.components.ad.reward.m.d(gVar, this.mDetailVideoView);
            eVar.a(1, dVar);
            gVar.a(dVar);
        }
        eVar.a(this.f11742ia);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        getContext();
        boolean z10 = !an.NS();
        if ((hD() || hE()) && z10) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.g(true, com.kwad.sdk.core.config.d.Ed());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_native_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        n(this.rO);
        if (RewardRenderResult.DEFAULT.equals(this.rO.gd())) {
            com.kwad.components.ad.reward.g.a(getContext(), this.rO, (FrameLayout) findViewById(R.id.ksad_reward_play_layout));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ad.reward.m.e eVar = this.rO.f11689qf;
        if (eVar != null) {
            eVar.b(this.f11742ia);
        }
    }
}
