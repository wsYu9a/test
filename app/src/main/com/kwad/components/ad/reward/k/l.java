package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.tachikoma.a.w;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes2.dex */
public final class l extends w {
    public final void g(@NonNull List<AdTemplate> list) {
        AdResultData adResultData = new AdResultData();
        adResultData.setAdTemplateList(list);
        b(new ae.a(adResultData));
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAggregationDataListener";
    }
}
