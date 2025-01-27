package com.kwad.sdk.core.network.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* loaded from: classes2.dex */
public final class c {
    public static b wy() {
        f fVar = (f) ServiceProvider.get(f.class);
        return (fVar == null || !fVar.sG()) ? new a() : new d();
    }
}
