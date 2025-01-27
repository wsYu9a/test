package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private a UM;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.u uVar);
    }

    public final void a(a aVar) {
        this.UM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UM != null) {
            com.kwad.components.core.webview.a.a.u uVar = new com.kwad.components.core.webview.a.a.u();
            try {
                try {
                    uVar.parseJson(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.UM.a(uVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UM = null;
    }
}
