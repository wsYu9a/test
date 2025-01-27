package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aqe;
    public String aqf;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aqe = jSONObject.optString("action");
        this.data = jSONObject.optString(MiConfigSingleton.t0);
        this.aqf = jSONObject.optString(com.alipay.sdk.authjs.a.f5376c);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "action", this.aqe);
        t.putValue(jSONObject, MiConfigSingleton.t0, this.data);
        t.putValue(jSONObject, com.alipay.sdk.authjs.a.f5376c, this.aqf);
        return jSONObject;
    }
}
