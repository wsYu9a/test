package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: classes3.dex */
public final class c {
    public static b FO() {
        h hVar = (h) ServiceProvider.get(h.class);
        return (hVar == null || !hVar.zV()) ? new a() : new d();
    }
}
