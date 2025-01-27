package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a abu;

    public interface a {
        void eh();
    }

    public b(a aVar) {
        this.abu = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.abu;
        if (aVar != null) {
            aVar.eh();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
