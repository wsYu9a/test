package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class k extends com.kwad.sdk.core.response.a.a {
    public int adq;
    public int adr = -1;
    public int ads;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.x.putValue(jSONObject, "insertScreenAdShowStrategy", this.adq);
        com.kwad.sdk.utils.x.putValue(jSONObject, "isAutoShow", this.ads);
        int i10 = this.adr;
        if (i10 != -1) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "triggerType", i10);
        }
        return jSONObject;
    }
}
