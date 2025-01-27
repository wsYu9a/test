package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hl implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        shakeInfo.title = optString;
        if (optString == JSONObject.NULL) {
            shakeInfo.title = "";
        }
        String optString2 = jSONObject.optString("subtitle");
        shakeInfo.subtitle = optString2;
        if (optString2 == JSONObject.NULL) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subtitle", shakeInfo.subtitle);
        }
        int i2 = shakeInfo.acceleration;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "acceleration", i2);
        }
        boolean z = shakeInfo.clickDisabled;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickDisabled", z);
        }
        int i3 = shakeInfo.componentIndex;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "componentIndex", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        a2(shakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return b2(shakeInfo, jSONObject);
    }
}
