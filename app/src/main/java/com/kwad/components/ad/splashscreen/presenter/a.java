package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    private View Ex;
    private boolean Ey;

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.EJ.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar == null) {
            return;
        }
        this.Ey = com.kwad.sdk.core.response.b.d.dQ(hVar.mAdTemplate);
        boolean n10 = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate));
        this.Ex.setVisibility(n10 ? 0 : 8);
        if (n10) {
            new com.kwad.sdk.widget.f(this.Ex.getContext(), this.Ex, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.Ey);
        if (this.Ey) {
            this.EJ.c(1, view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ex = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
