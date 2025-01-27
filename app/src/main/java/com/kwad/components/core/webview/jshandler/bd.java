package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes3.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private a aaX = new a();

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
    }

    public final void aR(int i10) {
        com.kwad.sdk.core.webview.c.c cVar = this.YI;
        if (cVar != null) {
            a aVar = this.aaX;
            aVar.status = i10;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerVideoListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }
}
