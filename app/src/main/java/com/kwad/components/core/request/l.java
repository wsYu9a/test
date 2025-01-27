package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l extends com.kwad.sdk.core.network.d {
    public l(AdTemplate adTemplate) {
        String bR = com.kwad.sdk.core.response.b.a.bR(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        try {
            String bS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            String bT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            if (!TextUtils.isEmpty(bT)) {
                putBody("adExt", bT);
            }
            if (!TextUtils.isEmpty(bS)) {
                putBody("serverExt", new JSONObject(bS));
            }
            if (!TextUtils.isEmpty(bR) && bR != null) {
                putBody("callbackUrlInfo", new JSONObject(bR).toString());
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        x.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.zq();
    }
}
