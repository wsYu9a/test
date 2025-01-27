package com.kwad.components.ad.e.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.d.b.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: classes.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public KsNativeAd.VideoPlayListener mM;

    @NonNull
    public d.a mR;

    @NonNull
    public AdBasePvFrameLayout nd;

    @NonNull
    public com.kwad.components.ad.e.b.a nj;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.nj.release();
    }
}
