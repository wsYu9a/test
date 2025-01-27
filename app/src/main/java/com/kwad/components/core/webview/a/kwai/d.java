package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.g gVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "commonLog";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.g gVar = new com.kwad.components.core.webview.a.a.g();
        try {
            gVar.parseJson(new JSONObject(str));
            a(gVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
