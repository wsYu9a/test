package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ag implements com.kwad.sdk.core.webview.b.a {
    private a TJ;

    public interface a {
        void a(com.kwad.components.core.webview.kwai.b bVar);
    }

    public ag(a aVar) {
        this.TJ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.kwai.b bVar = new com.kwad.components.core.webview.kwai.b();
        try {
            bVar.parseJson(new JSONObject(str));
            a aVar = this.TJ;
            if (aVar != null) {
                aVar.a(bVar);
            }
        } catch (Exception e2) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.TJ = null;
    }
}
