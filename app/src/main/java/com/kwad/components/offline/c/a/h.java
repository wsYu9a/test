package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.r;

/* loaded from: classes3.dex */
public final class h implements IOfflineTKRenderListener {
    private final r agA;

    public h(r rVar) {
        this.agA = rVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th2) {
        r rVar = this.agA;
        if (rVar != null) {
            rVar.onFailed(th2);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        r rVar = this.agA;
        if (rVar != null) {
            rVar.onSuccess();
        }
    }
}
