package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gm implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aaJ = jSONObject.optInt("convertType");
        dVar.MI = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(dVar.MI)) {
            dVar.MI = "";
        }
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        dVar.aJj = cVar;
        cVar.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = dVar.aaJ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "convertType", i10);
        }
        String str = dVar.MI;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "payload", dVar.MI);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "clickInfo", dVar.aJj);
        return jSONObject;
    }
}
