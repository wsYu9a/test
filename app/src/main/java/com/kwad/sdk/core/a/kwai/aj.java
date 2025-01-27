package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aj implements com.kwad.sdk.core.d<AdInfo.AdTrackInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i2));
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adTrackInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        a2(adTrackInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        return b2(adTrackInfo, jSONObject);
    }
}
