package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        String optString = jSONObject.optString("upperTab");
        adAggregateInfo.upperTab = optString;
        if (optString == JSONObject.NULL) {
            adAggregateInfo.upperTab = "";
        }
        String optString2 = jSONObject.optString("hotTagUrl");
        adAggregateInfo.hotTagUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adAggregateInfo.aggregateAdType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "aggregateAdType", i2);
        }
        String str = adAggregateInfo.upperTab;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        String str2 = adAggregateInfo.hotTagUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        a2(adAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        return b2(adAggregateInfo, jSONObject);
    }
}
