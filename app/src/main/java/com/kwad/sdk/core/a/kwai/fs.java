package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fs implements com.kwad.sdk.core.d<AdMatrixInfo.NeoVideoInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        neoVideoInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interactionInfo", neoVideoInfo.interactionInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        a2(neoVideoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        return b2(neoVideoInfo, jSONObject);
    }
}
