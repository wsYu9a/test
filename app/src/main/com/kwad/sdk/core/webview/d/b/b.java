package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bm;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.response.a.a {
    public String aJi;
    public AdTemplate adTemplate;
    public String extra;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String optString = jSONObject.optString("adTemplate");
            if (!bm.isNullString(optString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e10) {
                    ServiceProvider.reportSdkCaughtException(e10);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
