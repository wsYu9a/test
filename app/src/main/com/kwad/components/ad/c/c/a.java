package com.kwad.components.ad.c.c;

import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes2.dex */
public class a extends Presenter {
    public com.kwad.components.ad.c.b cA;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        Object Lj = Lj();
        if (Lj instanceof com.kwad.components.ad.c.b) {
            this.cA = (com.kwad.components.ad.c.b) Lj;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
    }
}
