package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes2.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g rO;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) Lj();
        this.rO = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    public final void hK() {
        this.rO.hK();
    }

    public final boolean hL() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate));
    }
}
