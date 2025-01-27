package com.kwad.components.ad.i.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;

/* loaded from: classes2.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c oN;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.oN = cVar;
    }

    public final void eZ() {
        c cVar = this.oN;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.oN = null;
    }
}
