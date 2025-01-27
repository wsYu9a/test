package com.kwad.components.ad.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {

    /* renamed from: de */
    @Nullable
    public KsDrawAd.AdInteractionListener f11414de;

    /* renamed from: dg */
    @NonNull
    public com.kwad.components.ad.draw.c.a f11415dg;

    @NonNull
    public com.kwad.components.ad.draw.b.b.a dv;

    @Nullable
    public com.kwad.components.ad.m.b dw;

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
        this.f11415dg.release();
    }
}
