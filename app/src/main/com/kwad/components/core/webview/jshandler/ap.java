package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private a aax;

    public interface a {
        void a(com.kwad.components.core.webview.a.b bVar);
    }

    public ap(a aVar) {
        this.aax = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.b bVar = new com.kwad.components.core.webview.a.b();
        try {
            bVar.parseJson(new JSONObject(str));
            a aVar = this.aax;
            if (aVar != null) {
                aVar.a(bVar);
            }
        } catch (Exception e10) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aax = null;
    }
}
