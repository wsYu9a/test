package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private a UL;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.t tVar);
    }

    public final void a(a aVar) {
        this.UL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UL != null) {
            com.kwad.components.core.webview.a.a.t tVar = new com.kwad.components.core.webview.a.a.t();
            try {
                tVar.parseJson(new JSONObject(str));
                this.UL.a(tVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UL = null;
    }
}
