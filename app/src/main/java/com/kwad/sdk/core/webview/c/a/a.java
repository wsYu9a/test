package com.kwad.sdk.core.webview.c.a;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public boolean II;
    public String IY;

    @Deprecated
    public boolean TA;
    public int TC;
    public c TD;
    public int aqn;
    public int aqo;
    public int jU;
    public boolean IQ = true;
    public long creativeId = -1;
    public int adStyle = -1;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.jU == 0 && this.aqo == 0 && jSONObject != null && jSONObject.has("logParam")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                this.jU = optJSONObject.getInt("itemClickType");
                this.aqo = optJSONObject.getInt("sceneType");
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean zg() {
        return 1 == this.TC;
    }
}
