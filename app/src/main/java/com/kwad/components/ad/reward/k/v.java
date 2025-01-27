package com.kwad.components.ad.reward.k;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class v {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    private v() {
    }

    public static v B(AdTemplate adTemplate) {
        v vVar = new v();
        vVar.setAdTemplate(adTemplate);
        return vVar;
    }

    public static v a(AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar) {
        v vVar = new v();
        vVar.setAdTemplate(adTemplate);
        vVar.setApkDownloadHelper(cVar);
        return vVar;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Nullable
    public final com.kwad.components.core.d.b.c hb() {
        return this.mApkDownloadHelper;
    }
}
