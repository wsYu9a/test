package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.webview.c.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gw implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        aVar.url = optString;
        if (optString == JSONObject.NULL) {
            aVar.url = "";
        }
        String optString2 = jSONObject.optString("method");
        aVar.method = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.method = "";
        }
        String optString3 = jSONObject.optString("params");
        aVar.params = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.params = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str2 = aVar.method;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "method", aVar.method);
        }
        String str3 = aVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "params", aVar.params);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
