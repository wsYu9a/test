package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ia implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        a2(playEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        return b2(playEndInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo = adWebCardInfo;
        adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo = endTopToolBarInfo;
        endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = playEndInfo.type;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "type", i10);
        }
        int i11 = playEndInfo.showLandingPage3;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLandingPage3", i11);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
        return jSONObject;
    }
}
