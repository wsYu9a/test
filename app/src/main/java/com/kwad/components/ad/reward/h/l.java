package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends v {
    public final void d(@NonNull List<AdTemplate> list) {
        b(new v.a(list));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerAggregationDataListener";
    }
}
