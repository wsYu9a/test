package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k implements com.kwad.sdk.core.webview.b.a {
    private a wZ;

    public interface a {
        void d(com.kwad.components.core.webview.a.a.r rVar);
    }

    public final void a(a aVar) {
        this.wZ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.wZ != null) {
            com.kwad.components.core.webview.a.a.r rVar = new com.kwad.components.core.webview.a.a.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.wZ.d(rVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wZ = null;
    }
}
