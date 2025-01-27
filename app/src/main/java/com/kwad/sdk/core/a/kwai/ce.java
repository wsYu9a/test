package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ce implements com.kwad.sdk.core.d<AdMatrixInfo.CycleAggregateInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("cutIconUrl");
        cycleAggregateInfo.cutIconUrl = optString;
        if (optString == JSONObject.NULL) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        String optString2 = jSONObject.optString("refreshIconUrl");
        cycleAggregateInfo.refreshIconUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        String optString3 = jSONObject.optString("convertIconUrl");
        cycleAggregateInfo.convertIconUrl = optString3;
        if (optString3 == JSONObject.NULL) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cycleAggregateInfo.cutIconUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        String str2 = cycleAggregateInfo.refreshIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        String str3 = cycleAggregateInfo.convertIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        a2(cycleAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        return b2(cycleAggregateInfo, jSONObject);
    }
}
