package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.r> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.r rVar, JSONObject jSONObject) {
        a2(rVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.r rVar, JSONObject jSONObject) {
        return b2(rVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rVar.templateId)) {
            rVar.templateId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateId", rVar.templateId);
        }
        return jSONObject;
    }
}
