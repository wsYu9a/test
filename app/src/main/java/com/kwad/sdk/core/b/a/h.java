package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        a2(adAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        return b2(adAggregateInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adAggregateInfo.upperTab)) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (obj.toString().equals(adAggregateInfo.hotTagUrl)) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adAggregateInfo.aggregateAdType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "aggregateAdType", i10);
        }
        String str = adAggregateInfo.upperTab;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        String str2 = adAggregateInfo.hotTagUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject;
    }
}
