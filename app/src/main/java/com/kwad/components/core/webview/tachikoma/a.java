package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.b.l;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private final AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "adTemplate is null");
            return;
        }
        String aS = com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        if (TextUtils.isEmpty(aS)) {
            cVar.onError(-1, "landing page url is null");
            return;
        }
        l lVar = new l();
        lVar.adt = aS;
        cVar.a(lVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLandingPageInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
