package com.kwad.sdk.core.webview.b;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
