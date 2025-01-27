package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aa implements com.kwad.sdk.core.d<AdInfo.AdPreloadInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("preloadId");
        adPreloadInfo.preloadId = optString;
        if (optString == JSONObject.NULL) {
            adPreloadInfo.preloadId = "";
        }
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adPreloadInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadId", adPreloadInfo.preloadId);
        }
        int i2 = adPreloadInfo.preloadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadType", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
        com.kwad.sdk.utils.t.putValue(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        a2(adPreloadInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        return b2(adPreloadInfo, jSONObject);
    }
}
