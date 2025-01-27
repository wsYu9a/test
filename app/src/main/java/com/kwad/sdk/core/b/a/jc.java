package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jc implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        a2(shakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return b2(shakeInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(shakeInfo.title)) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString("subtitle");
        if (obj.toString().equals(shakeInfo.subtitle)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "subtitle", shakeInfo.subtitle);
        }
        int i10 = shakeInfo.acceleration;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "acceleration", i10);
        }
        boolean z10 = shakeInfo.clickDisabled;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clickDisabled", z10);
        }
        int i11 = shakeInfo.componentIndex;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "componentIndex", i11);
        }
        return jSONObject;
    }
}
