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
public final class a extends com.kwad.sdk.core.response.a.a {
    public String MU;

    @Deprecated
    public boolean Ms;
    public int aJe;
    public int aJf;

    @Deprecated
    public boolean aan;
    public int aap;
    public d aaq;
    public AdTemplate adTemplate;
    public int lz;
    public boolean MG = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aJg = false;
    public boolean aJh = false;

    public final boolean IR() {
        return 1 == this.aap;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.lz == 0 && this.aJf == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.lz = optJSONObject.getInt("itemClickType");
                    this.aJf = optJSONObject.getInt("sceneType");
                    this.aJg = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (bm.isNullString(optString)) {
                    return;
                }
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
