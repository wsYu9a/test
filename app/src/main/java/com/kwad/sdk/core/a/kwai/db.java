package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class db implements com.kwad.sdk.core.d<AdMatrixInfo.FeedInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.FeedInfo feedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        feedInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.FeedInfo feedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interactionInfo", feedInfo.interactionInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.FeedInfo feedInfo, JSONObject jSONObject) {
        a2(feedInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.FeedInfo feedInfo, JSONObject jSONObject) {
        return b2(feedInfo, jSONObject);
    }
}
