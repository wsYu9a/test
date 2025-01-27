package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gi implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.l> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.adt = jSONObject.optString("landingPageUrl");
        if (JSONObject.NULL.toString().equals(lVar.adt)) {
            lVar.adt = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.adt;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "landingPageUrl", lVar.adt);
        }
        return jSONObject;
    }
}
