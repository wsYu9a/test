package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes.dex */
public final class g extends a implements com.kwad.sdk.a.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.a.a
    public final void X(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.a.a.aq(this.mAdInfo), str)) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            com.kwad.components.ad.reward.d.b bVar = this.qt.mAdOpenInteractionListener;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.qt.oN.pause();
            this.qt.fH();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        com.kwad.sdk.a.b.tA().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.a.b.tA().b(this);
    }
}
