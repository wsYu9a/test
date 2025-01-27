package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.kwai.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        bVar.url = optString;
        if (optString == JSONObject.NULL) {
            bVar.url = "";
        }
        String optString2 = jSONObject.optString("title");
        bVar.title = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.title = "";
        }
        String optString3 = jSONObject.optString("params");
        bVar.params = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.params = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", bVar.title);
        }
        String str3 = bVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "params", bVar.params);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
