package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class am implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.b.c cVar = this.Sb;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.b.c cVar = this.Sb;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
