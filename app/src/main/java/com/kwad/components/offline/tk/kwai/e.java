package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.i;

/* loaded from: classes2.dex */
public final class e implements IOfflineTKCallHandler {
    private final i XO;

    public e(i iVar) {
        this.XO = iVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        i iVar = this.XO;
        if (iVar != null) {
            iVar.callJS(str);
        }
    }
}
