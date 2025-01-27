package com.kwad.components.offline.tk;

import android.content.Context;

/* loaded from: classes2.dex */
public final class a implements com.kwad.components.core.offline.api.a.b {
    @Override // com.kwad.components.core.offline.api.a.b
    public final void a(com.kwad.components.core.offline.api.a.a aVar) {
        b.rQ().a(aVar);
    }

    @Override // com.kwad.components.core.offline.api.a.b
    public final void b(com.kwad.components.core.offline.api.a.a aVar) {
        b.rQ().b(aVar);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<?> getComponentsType() {
        return com.kwad.components.core.offline.api.a.b.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return 100;
    }
}
