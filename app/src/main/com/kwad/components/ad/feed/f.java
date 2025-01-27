package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class f {
    public static String g(@NonNull AdTemplate adTemplate) {
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        if (!com.kwad.components.core.c.b.nl()) {
            return au;
        }
        return (adTemplate.fromCache ? "【cache】" : "") + au;
    }
}
