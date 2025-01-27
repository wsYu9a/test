package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class g implements com.kwad.sdk.core.webview.b.a {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "uuid";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        aVar.data = UUID.randomUUID().toString();
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
