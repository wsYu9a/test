package com.kwad.sdk.ranger.a.kwai;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public int amB;
    public List<a> ayE;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : this.ayE) {
            t.putValue(jSONObject, aVar.key, aVar.value);
        }
        t.putValue(jSONObject, "func_ratio_count", this.amB);
        JSONObject jSONObject2 = new JSONObject();
        t.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
