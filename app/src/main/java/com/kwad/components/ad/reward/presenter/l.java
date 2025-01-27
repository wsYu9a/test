package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes2.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {

    /* renamed from: qi */
    private RewardActionBarControl f11791qi;

    @Nullable
    private com.kwad.components.ad.reward.n.g tS;
    private KsLogoView tU;

    @Nullable
    private com.kwad.components.ad.reward.n.l tV;
    private boolean tT = false;

    /* renamed from: ia */
    private com.kwad.components.core.video.l f11790ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.l.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            l.this.hP();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.l$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            l.this.hP();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.l$2 */
    public class AnonymousClass2 implements g.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.n.g.a
        public final void hQ() {
            l.this.f11791qi.P(true);
        }
    }

    public void hP() {
        if (this.tT) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.tS;
        if (gVar == null) {
            this.f11791qi.P(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.ad.reward.n.g.a
                public final void hQ() {
                    l.this.f11791qi.P(true);
                }
            }, 500L);
        }
        this.tT = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.reward.g gVar = this.rO;
        this.f11791qi = gVar.f11692qi;
        gVar.f11689qf.a(this.f11790ia);
        AdTemplate adTemplate = this.rO.mAdTemplate;
        boolean z10 = com.kwad.sdk.core.response.b.b.dk(adTemplate).displayWeakCard;
        this.rO.B(z10);
        if (z10) {
            if (this.tS == null) {
                this.tS = new com.kwad.components.ad.reward.n.g(this.rO);
            }
            this.tS.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.tS.b(com.kwad.components.ad.reward.n.r.V(adTemplate));
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cj(adTemplate)) {
            if (this.tV == null) {
                this.tV = new com.kwad.components.ad.reward.n.l(this.rO);
            }
            this.tV.h(this.rO.mRootContainer);
            this.tV.b(com.kwad.components.ad.reward.n.r.V(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), eb2, this.tU, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.rO.f11692qi.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tU = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11790ia);
        this.rO.f11692qi.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.tV;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.tV;
        if (lVar != null) {
            lVar.ku();
        }
    }
}
