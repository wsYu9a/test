package com.kwad.components.ad.splashscreen.presenter;

/* loaded from: classes2.dex */
public final class k extends e implements com.kwad.sdk.core.h.c {
    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.EJ.DV.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.ad(this.EJ.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.af(this.EJ.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cG(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate))) {
            this.EJ.S(getContext());
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        this.EJ.S(getContext());
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.EJ.DV.b(this);
    }
}
