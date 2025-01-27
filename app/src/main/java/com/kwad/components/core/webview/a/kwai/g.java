package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class g implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.components.core.webview.a.a.k UE;

    public g(com.kwad.components.core.webview.a.a.k kVar) {
        this.UE = kVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.k kVar = this.UE;
        if (kVar != null) {
            cVar.a(kVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
