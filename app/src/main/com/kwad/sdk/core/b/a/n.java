package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.arT = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.arU = jSONObject.optBoolean("is_api_native");
        bVar.arV = jSONObject.optString("ad_request_type");
        if (obj.toString().equals(bVar.arV)) {
            bVar.arV = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (obj.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.methodName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "method_name", bVar.methodName);
        }
        boolean z10 = bVar.arT;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "is_convert", z10);
        }
        int i10 = bVar.adNum;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_num", i10);
        }
        boolean z11 = bVar.arU;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "is_api_native", z11);
        }
        String str2 = bVar.arV;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_request_type", bVar.arV);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
