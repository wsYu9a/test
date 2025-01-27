package com.kwad.components.ad.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public KsDrawAd.AdInteractionListener bV;

    @NonNull
    public com.kwad.components.ad.draw.b.a bX;

    @NonNull
    public com.kwad.components.ad.draw.a.a.a co;

    @Nullable
    public com.kwad.components.ad.i.b cp;

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.bX.release();
    }
}
