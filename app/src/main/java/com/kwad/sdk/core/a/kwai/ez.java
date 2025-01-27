package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ez implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.l> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("landingPageUrl");
        lVar.Ve = optString;
        if (optString == JSONObject.NULL) {
            lVar.Ve = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.Ve;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageUrl", lVar.Ve);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }
}
