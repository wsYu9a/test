package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class f {
    public static String b(@NonNull AdTemplate adTemplate) {
        String an = com.kwad.sdk.core.response.a.a.an(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        if (!com.kwad.components.core.b.b.lY()) {
            return an;
        }
        return (adTemplate.fromCache ? "【cache】" : "") + an;
    }
}
