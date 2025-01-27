package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class m extends v {
    public final void aR(int i2) {
        com.kwad.components.core.webview.a.a.v vVar = new com.kwad.components.core.webview.a.a.v();
        vVar.nZ = i2;
        super.b(vVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerSplashProgressListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
    }
}
