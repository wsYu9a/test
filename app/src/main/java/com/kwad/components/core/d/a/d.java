package com.kwad.components.core.d.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes2.dex */
public final class d extends com.kwad.sdk.mvp.a {

    @Nullable
    public b Iv;
    public b.C0171b Iw;
    public AdTemplate mAdTemplate;

    @Nullable
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }
}
