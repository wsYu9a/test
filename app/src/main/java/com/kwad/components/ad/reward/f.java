package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.b.a.bR(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        x.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        try {
            String bS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            if (TextUtils.isEmpty(bS)) {
                return;
            }
            putBody("serverExt", new JSONObject(bS));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.zl();
    }
}
