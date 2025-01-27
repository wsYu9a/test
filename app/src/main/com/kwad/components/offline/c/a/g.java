package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.p;

/* loaded from: classes3.dex */
public final class g implements IOfflineTKCallHandler {
    private final p agz;

    public g(p pVar) {
        this.agz = pVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        p pVar = this.agz;
        if (pVar != null) {
            pVar.callJS(str);
        }
    }
}
