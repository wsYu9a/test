package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private a yG;

    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.p pVar);
    }

    public final void a(a aVar) {
        this.yG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.yG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.p pVar = new com.kwad.components.core.webview.tachikoma.b.p();
        try {
            pVar.parseJson(new JSONObject(str));
            a aVar = this.yG;
            if (aVar != null) {
                aVar.a(pVar);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
