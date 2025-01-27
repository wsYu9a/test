package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fc implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aIJ = jSONObject.optString(m5.c.T);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aIJ)) {
            aVar.aIJ = "";
        }
        aVar.aIK = jSONObject.optString(m5.c.I0);
        if (obj.toString().equals(aVar.aIK)) {
            aVar.aIK = "";
        }
        aVar.aIL = jSONObject.optString(h3.e.f26401f);
        if (obj.toString().equals(aVar.aIL)) {
            aVar.aIL = "";
        }
        aVar.aIM = jSONObject.optString(m5.c.f28298d);
        if (obj.toString().equals(aVar.aIM)) {
            aVar.aIM = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aIJ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, m5.c.T, aVar.aIJ);
        }
        String str2 = aVar.aIK;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, m5.c.I0, aVar.aIK);
        }
        String str3 = aVar.aIL;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, h3.e.f26401f, aVar.aIL);
        }
        String str4 = aVar.aIM;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, m5.c.f28298d, aVar.aIM);
        }
        return jSONObject;
    }
}
