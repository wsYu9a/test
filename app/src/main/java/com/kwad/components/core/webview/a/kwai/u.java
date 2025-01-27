package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class u implements com.kwad.sdk.core.webview.b.a {
    private a UN;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.m mVar);
    }

    public final void a(a aVar) {
        this.UN = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UN != null) {
            com.kwad.components.core.webview.a.a.m mVar = new com.kwad.components.core.webview.a.a.m();
            try {
                mVar.parseJson(new JSONObject(str));
                this.UN.a(mVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UN = null;
    }
}
