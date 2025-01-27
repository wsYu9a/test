package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d implements com.kwad.sdk.core.webview.b.a {
    private a wU;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.q qVar);
    }

    public final void a(a aVar) {
        this.wU = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.q qVar = new com.kwad.components.core.webview.a.a.q();
        try {
            qVar.parseJson(new JSONObject(str));
            a aVar = this.wU;
            if (aVar != null) {
                aVar.a(qVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wU = null;
    }
}
