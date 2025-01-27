package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dl implements com.kwad.sdk.core.d<AdMatrixInfo.FullScreenInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        fullScreenInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interactionInfo", fullScreenInfo.interactionInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        a2(fullScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        return b2(fullScreenInfo, jSONObject);
    }
}
