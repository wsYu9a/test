package com.kwad.components.ad.kwai;

import com.kwad.sdk.c;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.core.n.a {
    public a(com.kwad.components.core.n.kwai.a aVar) {
        super(aVar);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.se();
    }
}
