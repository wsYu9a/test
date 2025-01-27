package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* loaded from: classes2.dex */
public final class d implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.b.g XN;

    d(com.kwad.sdk.core.webview.b.g gVar) {
        this.XN = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.b.g gVar = this.XN;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
