package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {

    /* renamed from: qi */
    private RewardActionBarControl f11746qi;
    private l tY = new l() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            c.this.hP();
        }
    };

    @Nullable
    private o vv;

    /* renamed from: com.kwad.components.ad.reward.presenter.b.c$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            c.this.hP();
        }
    }

    public void hP() {
        this.f11746qi.P(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        g gVar = this.rO;
        this.f11746qi = gVar.f11692qi;
        gVar.f11689qf.a(this.tY);
        AdTemplate adTemplate = this.rO.mAdTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cS(eb2)) {
            if (this.vv == null) {
                this.vv = new o(this.rO);
            }
            this.vv.a(this.rO.mRootContainer, com.kwad.sdk.core.response.b.a.bf(eb2));
            this.vv.b(r.V(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.rO.f11692qi.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.tY);
        this.rO.f11692qi.b(this);
        o oVar = this.vv;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
