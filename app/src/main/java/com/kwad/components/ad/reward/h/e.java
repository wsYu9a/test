package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private a wV;

    public interface a {
        void iS();
    }

    public final void a(a aVar) {
        this.wV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.wV;
        if (aVar != null) {
            aVar.iS();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wV = null;
    }
}
