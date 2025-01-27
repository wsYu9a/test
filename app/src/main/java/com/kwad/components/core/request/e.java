package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e extends com.kwad.sdk.core.network.d {
    public long TY;

    public e(int i10, AdTemplate adTemplate) {
        String bR = com.kwad.sdk.core.response.b.a.bR(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        try {
            String bS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            try {
                if (!TextUtils.isEmpty(bS)) {
                    putBody("serverExt", new JSONObject(bS));
                }
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
            if (!TextUtils.isEmpty(bR) && bR != null) {
                JSONObject jSONObject = new JSONObject(bR);
                x.putValue(jSONObject, "checkType", i10);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e11) {
            com.kwad.sdk.core.d.c.printStackTrace(e11);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        x.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.zp();
    }
}
