package com.kwad.components.core.webview.a;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private a Uo;

    public interface a {
        void es();
    }

    public b(a aVar) {
        this.Uo = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.Uo;
        if (aVar != null) {
            aVar.es();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
