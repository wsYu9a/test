package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.b;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class il implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString(h3.e.f26414s);
        if (obj.toString().equals(aVar.method)) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString("params");
        if (obj.toString().equals(aVar.params)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", aVar.url);
        }
        String str2 = aVar.method;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, h3.e.f26414s, aVar.method);
        }
        String str3 = aVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "params", aVar.params);
        }
        return jSONObject;
    }
}
