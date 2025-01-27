package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jg implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.s> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.message = jSONObject.optString(b7.d.f1362o);
        if (JSONObject.NULL.toString().equals(sVar.message)) {
            sVar.message = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = sVar.message;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, b7.d.f1362o, sVar.message);
        }
        return jSONObject;
    }
}
