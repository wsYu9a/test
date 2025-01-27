package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class g implements com.kwad.sdk.core.webview.b.a {
    private int wX;

    public g(int i2) {
        this.wX = i2;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.f fVar = new com.kwad.components.core.webview.a.a.f();
        fVar.UZ = this.wX;
        cVar.a(fVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
