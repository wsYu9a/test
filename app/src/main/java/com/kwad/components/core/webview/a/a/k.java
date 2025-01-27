package com.kwad.components.core.webview.a.a;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k extends com.kwad.sdk.core.response.kwai.a {
    public int Vb;
    public int Vc = -1;
    public int Vd;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.t.putValue(jSONObject, "insertScreenAdShowStrategy", this.Vb);
        com.kwad.sdk.utils.t.putValue(jSONObject, "isAutoShow", this.Vd);
        int i2 = this.Vc;
        if (i2 != -1) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i2);
        }
        return jSONObject;
    }
}
