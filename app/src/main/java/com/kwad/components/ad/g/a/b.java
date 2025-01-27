package com.kwad.components.ad.g.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.g.d;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public KsNativeAd.VideoPlayListener nG;
    public boolean nK = false;
    public boolean nL = false;

    @NonNull
    public d.a nN;

    @NonNull
    public AdBasePvFrameLayout nZ;

    /* renamed from: of */
    @NonNull
    public com.kwad.components.ad.g.c.a f11531of;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.f11531of.release();
    }
}
