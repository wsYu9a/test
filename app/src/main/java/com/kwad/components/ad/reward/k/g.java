package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private int yL;

    public g(int i10) {
        this.yL = i10;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.f fVar = new com.kwad.components.core.webview.tachikoma.b.f();
        fVar.ado = this.yL;
        cVar.a(fVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
