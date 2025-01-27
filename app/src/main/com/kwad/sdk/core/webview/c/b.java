package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aIV;
    public String aIW;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aIV = jSONObject.optString("action");
        this.data = jSONObject.optString(h3.e.f26408m);
        this.aIW = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "action", this.aIV);
        x.putValue(jSONObject, h3.e.f26408m, this.data);
        x.putValue(jSONObject, "callback", this.aIW);
        return jSONObject;
    }
}
