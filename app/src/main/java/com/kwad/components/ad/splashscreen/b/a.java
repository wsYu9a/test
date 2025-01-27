package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import com.kwad.sdk.R;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    private View BV;
    private com.kwad.sdk.widget.f BW;
    private boolean BX;

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.Cg.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar == null) {
            return;
        }
        this.BX = com.kwad.sdk.core.response.a.c.bQ(hVar.mAdTemplate);
        boolean o = o.o(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate));
        this.BV.setVisibility(o ? 0 : 8);
        if (o) {
            this.BW = new com.kwad.sdk.widget.f(this.BV.getContext(), this.BV, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.d.b.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.BX);
        if (this.BX) {
            this.Cg.c(1, view.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.BV = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
