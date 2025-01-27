package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void Q(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                return;
            }
            com.kwad.components.ad.reward.e.b bVar = this.rO.f11688qe;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.rO.f11689qf.pause();
            this.rO.fV();
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void R(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        com.kwad.sdk.app.b.BJ().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.BJ().b(this);
    }
}
