package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    com.kwad.sdk.core.webview.b YR;

    public static class a implements com.kwad.sdk.core.b {
        private String Li;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Li = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", this.Li);
            return jSONObject;
        }
    }

    public m(com.kwad.sdk.core.webview.b bVar) {
        this.YR = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.download.a.dJ(com.kwad.sdk.core.response.b.e.eb(a(aVar)).adConversionInfo.appDownloadUrl);
            cVar.a(null);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            cVar.onError(-1, th2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cancelAppDownloadForAd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    private AdTemplate a(a aVar) {
        return aVar.adTemplate != null ? aVar.adTemplate : this.YR.dg(aVar.Li);
    }
}
