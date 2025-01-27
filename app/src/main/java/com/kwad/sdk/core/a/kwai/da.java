package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class da implements com.kwad.sdk.core.d<AdStyleInfo.FeedAdInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("templateConfig");
        feedAdInfo.templateConfig = optString;
        if (optString == JSONObject.NULL) {
            feedAdInfo.templateConfig = "";
        }
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedAdInfo.templateConfig;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        }
        double d2 = feedAdInfo.heightRatio;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "heightRatio", d2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        a2(feedAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        return b2(feedAdInfo, jSONObject);
    }
}
