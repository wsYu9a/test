package com.kwad.sdk.m.b.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.x;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aEX;
    public List<a> aSc;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : this.aSc) {
            x.putValue(jSONObject, aVar.key, aVar.value);
        }
        x.putValue(jSONObject, "func_ratio_count", this.aEX);
        JSONObject jSONObject2 = new JSONObject();
        x.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
