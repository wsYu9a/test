package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hj implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString(z2.c.f33638f);
        if (obj.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt("http_code");
        iVar.azR = jSONObject.optString("req_type");
        if (obj.toString().equals(iVar.azR)) {
            iVar.azR = "";
        }
        iVar.azS = jSONObject.optInt("use_ip");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = iVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", iVar.url);
        }
        String str2 = iVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, z2.c.f33638f, iVar.host);
        }
        int i10 = iVar.httpCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "http_code", i10);
        }
        String str3 = iVar.azR;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "req_type", iVar.azR);
        }
        int i11 = iVar.azS;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "use_ip", i11);
        }
        return jSONObject;
    }
}
