package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ho implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.s> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("templateId");
        sVar.templateId = optString;
        if (optString == JSONObject.NULL) {
            sVar.templateId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = sVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateId", sVar.templateId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }
}
