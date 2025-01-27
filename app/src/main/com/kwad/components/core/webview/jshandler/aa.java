package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.b YR;

    public aa() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate;
        try {
            com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleJsCall : " + str);
            com.kwad.sdk.core.webview.b bVar = this.YR;
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg((bVar == null || (adTemplate = bVar.getAdTemplate()) == null) ? null : com.kwad.sdk.core.response.b.e.eb(adTemplate));
            webViewCommercialMsg.parseJson(new JSONObject(str));
            a(webViewCommercialMsg);
            cVar.a(null);
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            cVar.onError(-1, e10.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public aa(com.kwad.sdk.core.webview.b bVar) {
        this.YR = bVar;
    }

    private static void a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        com.kwad.sdk.commercial.b.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }
}
