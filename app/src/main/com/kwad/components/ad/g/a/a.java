package com.kwad.components.ad.g.a;

import com.kwad.components.core.video.k;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes2.dex */
public class a extends Presenter {
    public k mVideoPlayStateListener;

    /* renamed from: oe */
    public b f11530oe;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.f11530oe = (b) Lj();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.f11530oe.f11531of.a(this.mVideoPlayStateListener);
    }
}
