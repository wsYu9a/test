package com.kwad.components.core.n;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public long Om;

    public d(int i2, AdTemplate adTemplate) {
        String bD = com.kwad.sdk.core.response.a.a.bD(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        try {
            if (!TextUtils.isEmpty(bD) && bD != null) {
                JSONObject jSONObject = new JSONObject(bD);
                t.putValue(jSONObject, "checkType", i2);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sm();
    }
}
