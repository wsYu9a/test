package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.b.c;

/* loaded from: classes.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {
    private c nN;

    public final void fb() {
        c cVar = this.nN;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull c cVar) {
        this.nN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nN = null;
    }
}
