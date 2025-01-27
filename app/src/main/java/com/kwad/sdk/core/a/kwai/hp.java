package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.t> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(com.heytap.mcssdk.n.d.l);
        tVar.message = optString;
        if (optString == JSONObject.NULL) {
            tVar.message = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tVar.message;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.heytap.mcssdk.n.d.l, tVar.message);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }
}
