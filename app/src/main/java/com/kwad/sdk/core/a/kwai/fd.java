package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fd implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.c> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aqp = jSONObject.optInt("convertType");
        String optString = jSONObject.optString("payload");
        cVar.Ts = optString;
        if (optString == JSONObject.NULL) {
            cVar.Ts = "";
        }
        com.kwad.sdk.core.webview.c.a.b bVar = new com.kwad.sdk.core.webview.c.a.b();
        cVar.aqq = bVar;
        bVar.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = cVar.aqp;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convertType", i2);
        }
        String str = cVar.Ts;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", cVar.Ts);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickInfo", cVar.aqq);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
