package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fx implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.n> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        nVar.url = optString;
        if (optString == JSONObject.NULL) {
            nVar.url = "";
        }
        String optString2 = jSONObject.optString("title");
        nVar.title = optString2;
        if (optString2 == JSONObject.NULL) {
            nVar.title = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = nVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", nVar.url);
        }
        String str2 = nVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", nVar.title);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }
}
