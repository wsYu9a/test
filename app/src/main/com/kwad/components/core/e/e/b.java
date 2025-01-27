package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public class b extends Presenter {
    protected c Nt;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        c cVar = (c) Lj();
        this.Nt = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(cVar.Ns.getAdTemplate());
    }
}
